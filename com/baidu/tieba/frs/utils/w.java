package com.baidu.tieba.frs.utils;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w {
    public static void a(com.baidu.tieba.tbadkCore.p pVar, TbPageContext tbPageContext) {
        if (bk.ak(tbPageContext.getPageActivity()) && pVar != null && pVar.aOk() != null && tbPageContext != null) {
            AntiData qs = pVar.qs();
            if (qs != null) {
                if (AntiHelper.e(qs) || AntiHelper.f(qs) || AntiHelper.g(qs)) {
                    qs.setBlock_forum_name(pVar.aOk().getName());
                    qs.setBlock_forum_id(pVar.aOk().getId());
                    qs.setUser_name(pVar.getUserData().getUserName());
                    qs.setUser_id(pVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), qs, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(qs.getPollMessage())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), qs.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (pVar.aOk() != null) {
                postPrefixData = pVar.aOk().getPrefixData();
            }
            int i = 0;
            if (pVar.getUserData() != null) {
                i = pVar.getUserData().getIsMem();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(tbPageContext.getPageActivity(), pVar.aOk().getId(), pVar.aOk().getName(), qs, 13003, postPrefixData, i)));
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.p pVar, TbPageContext tbPageContext) {
        TiebaStatic.log("c10798");
        if (bk.ak(tbPageContext.getPageActivity()) && pVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(r.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(r.j.setup));
                    return;
                }
                AntiData qs = pVar.qs();
                if (qs != null && !StringUtils.isNull(qs.getVideo_message())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), qs.getVideo_message());
                    return;
                }
                boolean z = false;
                if (pVar != null && pVar.getUserData() != null && pVar.getUserData().getGodUserData() != null && (pVar.getUserData().getGodUserData().getType() == 2 || pVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (pVar != null && pVar.aOk() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, pVar.aOk().getId(), pVar.aOk().getName());
                    return;
                }
                return;
            }
            XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(r.j.plugin_video_install_tips), tbPageContext.getPageActivity().getString(r.j.plugin_go_install));
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.i iVar) {
        if (bk.ak(tbPageContext.getPageActivity()) && pVar != null && tbPageContext != null) {
            boolean z = false;
            String str = "";
            if (pVar.aOk() != null && pVar.aOk().getAnchorPower() != null) {
                z = pVar.aOk().getCanAddPhotoLivePost();
                str = pVar.aOk().getAnchorPower().can_add_live_post_msg;
            }
            if (z) {
                a(pVar, tbPageContext, iVar, 4);
                com.baidu.tbadk.core.sharedPref.b.um().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
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
                    aVar.cF(optString);
                    aVar.a(r.j.view, new x(optString2, tbPageContext));
                    aVar.b(r.j.cancel, new y());
                    aVar.b(tbPageContext).tq();
                }
            }
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.i iVar) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (pVar != null && pVar.qs() != null) {
                    pVar.qs().setIfpost(1);
                }
                bk.ai(tbPageContext.getPageActivity());
            } else if (pVar != null) {
                a(pVar, tbPageContext, iVar, 0);
            }
        }
    }

    public static void G(FrsActivity frsActivity) {
        if (!TbadkCoreApplication.isLogin()) {
            bk.ai(frsActivity.getPageContext().getPageActivity());
            return;
        }
        frsActivity.jV(frsActivity.getPageContext().getResources().getString(r.j.Waiting));
        frsActivity.acv().jZ(frsActivity.acr().aOk().getId());
    }

    public static void a(com.baidu.tieba.tbadkCore.p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.i iVar, int i) {
        if (pVar != null && pVar.aOk() != null && tbPageContext != null && iVar != null) {
            int i2 = 0;
            if (pVar.getUserData() != null) {
                i2 = pVar.getUserData().getIsMem();
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), i, pVar.aOk().getId(), pVar.aOk().getName(), null, null, 0, pVar.qs(), 13003, false, false, null, false, false, null, null, pVar.aOk().getPrefixData(), i2);
            if (bx.adE().hY(1) != null) {
                writeActivityConfig.setCategroyId(iVar.agq());
            }
            writeActivityConfig.addHotTopicInfo(pVar.aOk().getPostTopicData());
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public static void b(FrsActivity frsActivity, int i) {
        if (frsActivity != null) {
            com.baidu.tieba.tbadkCore.p acr = frsActivity.acr();
            com.baidu.tieba.frs.e.i abS = frsActivity.abS();
            if (acr != null && abS != null) {
                int i2 = i == 4 ? 7 : i;
                int i3 = 0;
                if (acr.getUserData() != null) {
                    i3 = acr.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsActivity.getPageContext().getPageActivity(), i2, acr.aOk().getId(), frsActivity.getForumName(), null, null, 0, acr.qs(), 13003, false, false, null, false, false, null, null, acr.aOk().getPrefixData(), i3);
                if (bx.adE().hY(1) != null) {
                    writeActivityConfig.setCategroyId(abS.agq());
                }
                boolean GI = com.baidu.tbadk.plugins.h.GI();
                if (!acr.getUserData().canPostHi()) {
                    GI = false;
                }
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, GI);
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }
}
