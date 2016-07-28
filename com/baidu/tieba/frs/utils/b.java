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
import com.baidu.tbadk.plugins.g;
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
        if (bn.ab(tbPageContext.getPageActivity()) && pVar != null && pVar.aGX() != null && tbPageContext != null) {
            AntiData pc = pVar.pc();
            if (pc != null) {
                if (AntiHelper.e(pc) || AntiHelper.f(pc) || AntiHelper.g(pc)) {
                    pc.setBlock_forum_name(pVar.aGX().getName());
                    pc.setBlock_forum_id(pVar.aGX().getId());
                    pc.setUser_name(pVar.getUserData().getUserName());
                    pc.setUser_id(pVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), pc, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(pc.getPollMessage())) {
                    k.showToast(tbPageContext.getPageActivity(), pc.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (pVar.aGX() != null) {
                postPrefixData = pVar.aGX().getPrefixData();
            }
            int i = 0;
            if (pVar.getUserData() != null) {
                i = pVar.getUserData().getIsMem();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(tbPageContext.getPageActivity(), pVar.aGX().getId(), pVar.aGX().getName(), pc, 13003, postPrefixData, i)));
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
                AntiData pc = pVar.pc();
                if (pc != null && !StringUtils.isNull(pc.getVideo_message())) {
                    k.showToast(tbPageContext.getPageActivity(), pc.getVideo_message());
                    return;
                }
                boolean z = false;
                if (pVar != null && pVar.getUserData() != null && pVar.getUserData().getGodUserData() != null && (pVar.getUserData().getGodUserData().getType() == 2 || pVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (pVar != null && pVar.aGX() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, pVar.aGX().getId(), pVar.aGX().getName());
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
            if (pVar.aGX() != null && pVar.aGX().getAnchorPower() != null) {
                z = pVar.aGX().getCanAddPhotoLivePost();
                str = pVar.aGX().getAnchorPower().can_add_live_post_msg;
            }
            if (z) {
                a(pVar, tbPageContext, aVar, 4);
                com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
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
                    aVar.b(tbPageContext).rS();
                }
            }
        }
    }

    public static void b(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.f.a aVar) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (pVar != null && pVar.pc() != null) {
                    pVar.pc().setIfpost(1);
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
        frsActivity.jc(frsActivity.getPageContext().getResources().getString(u.j.Waiting));
        frsActivity.Wb().jf(frsActivity.VU().aGX().getId());
    }

    public static void a(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.f.a aVar, int i) {
        if (pVar != null && pVar.aGX() != null && tbPageContext != null && aVar != null) {
            int i2 = 0;
            if (pVar.getUserData() != null) {
                i2 = pVar.getUserData().getIsMem();
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), i, pVar.aGX().getId(), pVar.aGX().getName(), null, null, 0, pVar.pc(), 13003, false, false, null, false, false, null, null, pVar.aGX().getPrefixData(), i2);
            if (dd.Xo().hs(1) != null) {
                writeActivityConfig.setCategroyId(aVar.ZZ());
            }
            boolean Fk = g.Fk();
            if (!pVar.getUserData().canPostHi()) {
                Fk = false;
            }
            writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, Fk);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public static void c(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.f.a aVar) {
        if (bn.ab(tbPageContext.getPageActivity()) && g.f(tbPageContext) && pVar != null && pVar.aGX() != null) {
            if (pVar.getUserData() != null) {
                pVar.getUserData().getIsMem();
            }
            if (dd.Xo().hs(1) != null) {
                aVar.ZZ();
            }
            g.g(tbPageContext.getPageActivity(), 12016);
        }
    }
}
