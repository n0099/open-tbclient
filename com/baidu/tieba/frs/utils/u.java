package com.baidu.tieba.frs.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bu;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        TiebaStatic.log(new ar("c11839").ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && nVar != null && nVar.aJY() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (nVar != null && nVar.qm() != null) {
                    nVar.qm().setIfpost(1);
                }
                bf.ai(tbPageContext.getPageActivity());
                return;
            }
            AntiData qm = nVar.qm();
            if (qm != null && (AntiHelper.f(qm) || AntiHelper.g(qm) || AntiHelper.h(qm))) {
                qm.setBlock_forum_name(nVar.aJY().getName());
                qm.setBlock_forum_id(nVar.aJY().getId());
                qm.setUser_name(nVar.getUserData().getUserName());
                qm.setUser_id(nVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qm, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (nVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig((Context) tbPageContext.getPageActivity(), nVar.aJY().getName(), nVar.aJY().getId(), nVar.getUserData().getUserId(), true)));
            }
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        if (bf.ak(tbPageContext.getPageActivity()) && nVar != null && nVar.aJY() != null && tbPageContext != null) {
            AntiData qm = nVar.qm();
            if (qm != null) {
                if (AntiHelper.f(qm) || AntiHelper.g(qm) || AntiHelper.h(qm)) {
                    qm.setBlock_forum_name(nVar.aJY().getName());
                    qm.setBlock_forum_id(nVar.aJY().getId());
                    qm.setUser_name(nVar.getUserData().getUserName());
                    qm.setUser_id(nVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), qm, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(qm.getPollMessage())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), qm.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (nVar.aJY() != null) {
                postPrefixData = nVar.aJY().getPrefixData();
            }
            int i = 0;
            if (nVar.getUserData() != null) {
                i = nVar.getUserData().getIsMem();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(tbPageContext.getPageActivity(), nVar.aJY().getId(), nVar.aJY().getName(), qm, 13003, postPrefixData, i)));
        }
    }

    public static void c(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        TiebaStatic.log("c10798");
        if (bf.ak(tbPageContext.getPageActivity()) && nVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(r.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(r.l.setup));
                    return;
                }
                AntiData qm = nVar.qm();
                if (qm != null && !StringUtils.isNull(qm.getVideo_message())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), qm.getVideo_message());
                    return;
                }
                boolean z = false;
                if (nVar != null && nVar.getUserData() != null && nVar.getUserData().getGodUserData() != null && (nVar.getUserData().getGodUserData().getType() == 2 || nVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (nVar != null && nVar.aJY() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, nVar.aJY().getId(), nVar.aJY().getName());
                    return;
                }
                return;
            }
            XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(r.l.plugin_video_install_tips), tbPageContext.getPageActivity().getString(r.l.plugin_go_install));
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController) {
        if (bf.ak(tbPageContext.getPageActivity()) && nVar != null && tbPageContext != null) {
            boolean z = false;
            String str = "";
            if (nVar.aJY() != null && nVar.aJY().getAnchorPower() != null) {
                z = nVar.aJY().getCanAddPhotoLivePost();
                str = nVar.aJY().getAnchorPower().can_add_live_post_msg;
            }
            if (z) {
                a(nVar, tbPageContext, frsModelController, 4);
                com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
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
                    aVar.cE(optString);
                    aVar.a(r.l.view, new v(optString2, tbPageContext));
                    aVar.b(r.l.cancel, new w());
                    aVar.b(tbPageContext).sV();
                }
            }
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (nVar != null && nVar.qm() != null) {
                    nVar.qm().setIfpost(1);
                }
                bf.ai(tbPageContext.getPageActivity());
            } else if (nVar != null) {
                a(nVar, tbPageContext, frsModelController, 0);
            }
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController, int i) {
        if (nVar != null && nVar.aJY() != null && tbPageContext != null && frsModelController != null) {
            int i2 = 0;
            if (nVar.getUserData() != null) {
                i2 = nVar.getUserData().getIsMem();
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), i, nVar.aJY().getId(), nVar.aJY().getName(), null, null, 0, nVar.qm(), 13003, false, false, null, false, false, null, null, nVar.aJY().getPrefixData(), i2);
            if (bu.Ze().hV(1) != null) {
                writeActivityConfig.setCategroyId(frsModelController.abS());
            }
            writeActivityConfig.addHotTopicInfo(nVar.aJY().getPostTopicData());
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public static void b(FrsActivity frsActivity, int i) {
        if (frsActivity != null) {
            com.baidu.tieba.tbadkCore.n XW = frsActivity.XW();
            FrsModelController Xy = frsActivity.Xy();
            if (XW != null && Xy != null) {
                int i2 = 0;
                if (XW.getUserData() != null) {
                    i2 = XW.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsActivity.getPageContext().getPageActivity(), i, XW.aJY().getId(), frsActivity.getForumName(), null, null, 0, XW.qm(), 13003, false, false, null, false, false, null, null, XW.aJY().getPrefixData(), i2);
                if (bu.Ze().hV(1) != null) {
                    writeActivityConfig.setCategroyId(Xy.abS());
                }
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }
}
