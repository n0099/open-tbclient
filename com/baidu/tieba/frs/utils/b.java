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
import com.baidu.tieba.frs.cz;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static void a(p pVar, TbPageContext tbPageContext) {
        if (bn.al(tbPageContext.getPageActivity()) && pVar != null && pVar.aLP() != null && tbPageContext != null) {
            AntiData qf = pVar.qf();
            if (qf != null) {
                if (AntiHelper.e(qf) || AntiHelper.f(qf) || AntiHelper.g(qf)) {
                    qf.setBlock_forum_name(pVar.aLP().getName());
                    qf.setBlock_forum_id(pVar.aLP().getId());
                    qf.setUser_name(pVar.getUserData().getUserName());
                    qf.setUser_id(pVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), qf, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(qf.getPollMessage())) {
                    k.showToast(tbPageContext.getPageActivity(), qf.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (pVar.aLP() != null) {
                postPrefixData = pVar.aLP().getPrefixData();
            }
            int i = 0;
            if (pVar.getUserData() != null) {
                i = pVar.getUserData().getIsMem();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(tbPageContext.getPageActivity(), pVar.aLP().getId(), pVar.aLP().getName(), qf, 13003, postPrefixData, i)));
        }
    }

    public static void b(p pVar, TbPageContext tbPageContext) {
        TiebaStatic.log("c10798");
        if (bn.al(tbPageContext.getPageActivity()) && pVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(t.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(t.j.setup));
                    return;
                }
                AntiData qf = pVar.qf();
                if (qf != null && !StringUtils.isNull(qf.getVideo_message())) {
                    k.showToast(tbPageContext.getPageActivity(), qf.getVideo_message());
                    return;
                }
                boolean z = false;
                if (pVar != null && pVar.getUserData() != null && pVar.getUserData().getGodUserData() != null && (pVar.getUserData().getGodUserData().getType() == 2 || pVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (pVar != null && pVar.aLP() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, pVar.aLP().getId(), pVar.aLP().getName());
                    return;
                }
                return;
            }
            XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(t.j.plugin_video_install_tips), tbPageContext.getPageActivity().getString(t.j.plugin_go_install));
        }
    }

    public static void a(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar) {
        if (bn.al(tbPageContext.getPageActivity()) && pVar != null && tbPageContext != null) {
            boolean z = false;
            String str = "";
            if (pVar.aLP() != null && pVar.aLP().getAnchorPower() != null) {
                z = pVar.aLP().getCanAddPhotoLivePost();
                str = pVar.aLP().getAnchorPower().can_add_live_post_msg;
            }
            if (z) {
                a(pVar, tbPageContext, aVar, 4);
                com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
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
                    aVar.cB(optString);
                    aVar.a(t.j.view, new c(optString2, tbPageContext));
                    aVar.b(t.j.cancel, new d());
                    aVar.b(tbPageContext).sX();
                }
            }
        }
    }

    public static void b(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (pVar != null && pVar.qf() != null) {
                    pVar.qf().setIfpost(1);
                }
                bn.aj(tbPageContext.getPageActivity());
            } else if (pVar != null) {
                a(pVar, tbPageContext, aVar, 0);
            }
        }
    }

    public static void M(FrsActivity frsActivity) {
        if (!TbadkCoreApplication.isLogin()) {
            bn.aj(frsActivity.getPageContext().getPageActivity());
            return;
        }
        frsActivity.jL(frsActivity.getPageContext().getResources().getString(t.j.Waiting));
        frsActivity.aaY().jO(frsActivity.aaR().aLP().getId());
    }

    public static void a(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar, int i) {
        if (pVar != null && pVar.aLP() != null && tbPageContext != null && aVar != null) {
            int i2 = 0;
            if (pVar.getUserData() != null) {
                i2 = pVar.getUserData().getIsMem();
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), i, pVar.aLP().getId(), pVar.aLP().getName(), null, null, 0, pVar.qf(), 13003, false, false, null, false, false, null, null, pVar.aLP().getPrefixData(), i2);
            if (cz.acl().hV(1) != null) {
                writeActivityConfig.setCategroyId(aVar.aeK());
            }
            boolean GE = g.GE();
            if (!pVar.getUserData().canPostHi()) {
                GE = false;
            }
            writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, GE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public static void c(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar) {
        if (bn.al(tbPageContext.getPageActivity()) && g.f(tbPageContext) && pVar != null && pVar.aLP() != null) {
            if (pVar.getUserData() != null) {
                pVar.getUserData().getIsMem();
            }
            if (cz.acl().hV(1) != null) {
                aVar.aeK();
            }
            g.i(tbPageContext.getPageActivity(), 12016);
        }
    }
}
