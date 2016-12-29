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
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    public static void a(com.baidu.tieba.tbadkCore.o oVar, TbPageContext tbPageContext) {
        if (bh.ai(tbPageContext.getPageActivity()) && oVar != null && oVar.aIk() != null && tbPageContext != null) {
            AntiData qt = oVar.qt();
            if (qt != null) {
                if (AntiHelper.f(qt) || AntiHelper.g(qt) || AntiHelper.h(qt)) {
                    qt.setBlock_forum_name(oVar.aIk().getName());
                    qt.setBlock_forum_id(oVar.aIk().getId());
                    qt.setUser_name(oVar.getUserData().getUserName());
                    qt.setUser_id(oVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), qt, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(qt.getPollMessage())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), qt.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (oVar.aIk() != null) {
                postPrefixData = oVar.aIk().getPrefixData();
            }
            int i = 0;
            if (oVar.getUserData() != null) {
                i = oVar.getUserData().getIsMem();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(tbPageContext.getPageActivity(), oVar.aIk().getId(), oVar.aIk().getName(), qt, 13003, postPrefixData, i)));
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.o oVar, TbPageContext tbPageContext) {
        TiebaStatic.log("c10798");
        if (bh.ai(tbPageContext.getPageActivity()) && oVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(r.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(r.j.setup));
                    return;
                }
                AntiData qt = oVar.qt();
                if (qt != null && !StringUtils.isNull(qt.getVideo_message())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), qt.getVideo_message());
                    return;
                }
                boolean z = false;
                if (oVar != null && oVar.getUserData() != null && oVar.getUserData().getGodUserData() != null && (oVar.getUserData().getGodUserData().getType() == 2 || oVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (oVar != null && oVar.aIk() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, oVar.aIk().getId(), oVar.aIk().getName());
                    return;
                }
                return;
            }
            XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(r.j.plugin_video_install_tips), tbPageContext.getPageActivity().getString(r.j.plugin_go_install));
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.o oVar, TbPageContext tbPageContext, com.baidu.tieba.frs.d.i iVar) {
        if (bh.ai(tbPageContext.getPageActivity()) && oVar != null && tbPageContext != null) {
            boolean z = false;
            String str = "";
            if (oVar.aIk() != null && oVar.aIk().getAnchorPower() != null) {
                z = oVar.aIk().getCanAddPhotoLivePost();
                str = oVar.aIk().getAnchorPower().can_add_live_post_msg;
            }
            if (z) {
                a(oVar, tbPageContext, iVar, 4);
                com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
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
                    aVar.cG(optString);
                    aVar.a(r.j.view, new v(optString2, tbPageContext));
                    aVar.b(r.j.cancel, new w());
                    aVar.b(tbPageContext).tb();
                }
            }
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.o oVar, TbPageContext tbPageContext, com.baidu.tieba.frs.d.i iVar) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (oVar != null && oVar.qt() != null) {
                    oVar.qt().setIfpost(1);
                }
                bh.ag(tbPageContext.getPageActivity());
            } else if (oVar != null) {
                a(oVar, tbPageContext, iVar, 0);
            }
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.o oVar, TbPageContext tbPageContext, com.baidu.tieba.frs.d.i iVar, int i) {
        if (oVar != null && oVar.aIk() != null && tbPageContext != null && iVar != null) {
            int i2 = 0;
            if (oVar.getUserData() != null) {
                i2 = oVar.getUserData().getIsMem();
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), i, oVar.aIk().getId(), oVar.aIk().getName(), null, null, 0, oVar.qt(), 13003, false, false, null, false, false, null, null, oVar.aIk().getPrefixData(), i2);
            if (bw.XX().hj(1) != null) {
                writeActivityConfig.setCategroyId(iVar.aaM());
            }
            writeActivityConfig.addHotTopicInfo(oVar.aIk().getPostTopicData());
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public static void b(FrsActivity frsActivity, int i) {
        if (frsActivity != null) {
            com.baidu.tieba.tbadkCore.o WF = frsActivity.WF();
            com.baidu.tieba.frs.d.i Wh = frsActivity.Wh();
            if (WF != null && Wh != null) {
                int i2 = 0;
                if (WF.getUserData() != null) {
                    i2 = WF.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsActivity.getPageContext().getPageActivity(), i, WF.aIk().getId(), frsActivity.getForumName(), null, null, 0, WF.qt(), 13003, false, false, null, false, false, null, null, WF.aIk().getPrefixData(), i2);
                if (bw.XX().hj(1) != null) {
                    writeActivityConfig.setCategroyId(Wh.aaM());
                }
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }
}
