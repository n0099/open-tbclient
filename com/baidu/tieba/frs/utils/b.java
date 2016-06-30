package com.baidu.tieba.frs.utils;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.u;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static void a(p pVar, TbPageContext tbPageContext) {
        if (bn.ab(tbPageContext.getPageActivity()) && pVar != null && pVar.aDN() != null && tbPageContext != null) {
            AntiData pt = pVar.pt();
            if (pt != null) {
                if (AntiHelper.e(pt) || AntiHelper.f(pt) || AntiHelper.g(pt)) {
                    pt.setBlock_forum_name(pVar.aDN().getName());
                    pt.setBlock_forum_id(pVar.aDN().getId());
                    pt.setUser_name(pVar.getUserData().getUserName());
                    pt.setUser_id(pVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), pt, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(pt.getPollMessage())) {
                    k.showToast(tbPageContext.getPageActivity(), pt.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (pVar.aDN() != null) {
                postPrefixData = pVar.aDN().getPrefixData();
            }
            int i = 0;
            if (pVar.getUserData() != null) {
                i = pVar.getUserData().getIsMem();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(tbPageContext.getPageActivity(), pVar.aDN().getId(), pVar.aDN().getName(), pt, 13003, postPrefixData, i)));
        }
    }

    public static void b(p pVar, TbPageContext tbPageContext) {
        TiebaStatic.log("c10798");
        if (bn.ab(tbPageContext.getPageActivity()) && pVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(u.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(u.j.setup));
                    return;
                }
                AntiData pt = pVar.pt();
                if (pt != null && !StringUtils.isNull(pt.getVideo_message())) {
                    k.showToast(tbPageContext.getPageActivity(), pt.getVideo_message());
                    return;
                }
                boolean z = false;
                if (pVar != null && pVar.getUserData() != null && pVar.getUserData().getGodUserData() != null && (pVar.getUserData().getGodUserData().getType() == 2 || pVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (pVar != null && pVar.aDN() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, pVar.aDN().getId(), pVar.aDN().getName());
                    return;
                }
                return;
            }
            XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(u.j.plugin_video_install_tips), tbPageContext.getPageActivity().getString(u.j.plugin_go_install));
        }
    }

    public static void a(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.f.a aVar) {
        if (bn.ab(tbPageContext.getPageActivity()) && pVar != null && tbPageContext != null) {
            boolean z = false;
            String str = "";
            if (pVar.aDN() != null && pVar.aDN().getAnchorPower() != null) {
                z = pVar.aDN().getCanAddPhotoLivePost();
                str = pVar.aDN().getAnchorPower().can_add_live_post_msg;
            }
            if (z) {
                a(pVar, tbPageContext, aVar, 4);
                com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
                return;
            }
            d(tbPageContext, str);
        }
    }

    public static void d(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null) {
            JSONObject jSONObject = null;
            if (!StringUtils.isNull(str)) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    if (jSONArray.length() > 0) {
                        jSONObject = jSONArray.optJSONObject(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(optString)) {
                    String optString2 = jSONObject.optString("tid");
                    if (!StringUtils.isNull(optString) && optString.contains("_")) {
                        optString = optString.replace("_", "");
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                    aVar.cz(optString);
                    aVar.a(u.j.view, new c(optString2, tbPageContext));
                    aVar.b(u.j.cancel, new d());
                    aVar.b(tbPageContext).rT();
                }
            }
        }
    }

    public static void b(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.f.a aVar) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (pVar != null && pVar.pt() != null) {
                    pVar.pt().setIfpost(1);
                }
                bn.Z(tbPageContext.getPageActivity());
            } else if (pVar != null) {
                a(pVar, tbPageContext, aVar, 0);
            }
        }
    }

    public static void P(FrsActivity frsActivity) {
        if (!TbadkCoreApplication.isLogin()) {
            bn.Z(frsActivity.getPageContext().getPageActivity());
            return;
        }
        frsActivity.iW(frsActivity.getPageContext().getResources().getString(u.j.Waiting));
        frsActivity.VJ().iZ(frsActivity.VC().aDN().getId());
    }

    public static void a(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.f.a aVar, int i) {
        if (pVar != null && pVar.aDN() != null && tbPageContext != null && aVar != null) {
            int i2 = 0;
            if (pVar.getUserData() != null) {
                i2 = pVar.getUserData().getIsMem();
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), i, pVar.aDN().getId(), pVar.aDN().getName(), null, null, 0, pVar.pt(), 13003, false, false, null, false, false, null, null, pVar.aDN().getPrefixData(), i2);
            if (dd.WW().ht(1) != null) {
                writeActivityConfig.setCategroyId(aVar.ZD());
            }
            boolean Fj = com.baidu.tbadk.plugins.d.Fj();
            if (!pVar.getUserData().canPostHi()) {
                Fj = false;
            }
            writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, Fj);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public static void c(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.f.a aVar) {
        if (bn.ab(tbPageContext.getPageActivity()) && com.baidu.tbadk.plugins.d.f(tbPageContext) && pVar != null && pVar.aDN() != null) {
            if (pVar.getUserData() != null) {
                pVar.getUserData().getIsMem();
            }
            if (dd.WW().ht(1) != null) {
                aVar.ZD();
            }
            com.baidu.tbadk.plugins.d.g(tbPageContext.getPageActivity(), 12016);
        }
    }
}
