package com.baidu.tieba.frs.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bu;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private static com.baidu.tbadk.core.dialog.e cbN = null;
    private static a cbO = null;

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        TiebaStatic.log(new as("c11839").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && nVar != null && nVar.aJp() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (nVar != null && nVar.qE() != null) {
                    nVar.qE().setIfpost(1);
                }
                bg.aG(tbPageContext.getPageActivity());
                return;
            }
            AntiData qE = nVar.qE();
            if (qE != null && (AntiHelper.f(qE) || AntiHelper.g(qE) || AntiHelper.h(qE))) {
                qE.setBlock_forum_name(nVar.aJp().getName());
                qE.setBlock_forum_id(nVar.aJp().getId());
                qE.setUser_name(nVar.getUserData().getUserName());
                qE.setUser_id(nVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qE, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (nVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig((Context) tbPageContext.getPageActivity(), nVar.aJp().getName(), nVar.aJp().getId(), nVar.getUserData().getUserId(), true)));
            }
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        if (bg.aI(tbPageContext.getPageActivity()) && nVar != null && nVar.aJp() != null && tbPageContext != null) {
            AntiData qE = nVar.qE();
            if (qE != null) {
                if (AntiHelper.f(qE) || AntiHelper.g(qE) || AntiHelper.h(qE)) {
                    qE.setBlock_forum_name(nVar.aJp().getName());
                    qE.setBlock_forum_id(nVar.aJp().getId());
                    qE.setUser_name(nVar.getUserData().getUserName());
                    qE.setUser_id(nVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), qE, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(qE.getPollMessage())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), qE.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (nVar.aJp() != null) {
                postPrefixData = nVar.aJp().getPrefixData();
            }
            int i = 0;
            if (nVar.getUserData() != null) {
                i = nVar.getUserData().getIsMem();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(tbPageContext.getPageActivity(), nVar.aJp().getId(), nVar.aJp().getName(), qE, 13003, postPrefixData, i)));
        }
    }

    public static void c(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        String string;
        TiebaStatic.log("c10798");
        if (bg.aI(tbPageContext.getPageActivity()) && nVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(w.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(w.l.setup));
                    return;
                }
                AntiData qE = nVar.qE();
                if (qE != null && !StringUtils.isNull(qE.getVideo_message())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), qE.getVideo_message());
                    return;
                }
                boolean z = false;
                if (nVar != null && nVar.getUserData() != null && nVar.getUserData().getGodUserData() != null && (nVar.getUserData().getGodUserData().getType() == 2 || nVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (nVar != null && nVar.aJp() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, nVar.aJp().getId(), nVar.aJp().getName());
                }
            } else if (!com.baidu.adp.lib.util.i.he()) {
                tbPageContext.showToast(w.l.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jQ().jR() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jQ().jR().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string2 = tbPageContext.getPageActivity().getString(w.l.plugin_imme_install);
                String string3 = tbPageContext.getPageActivity().getString(w.l.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.i.hg()) {
                    str = f > 0.0f ? String.valueOf(string) + "（" + f + "MB）" : tbPageContext.getPageActivity().getString(w.l.plugin_video_install_tips_mobile);
                    str2 = tbPageContext.getPageActivity().getString(w.l.install_app);
                } else {
                    str = string3;
                    str2 = string2;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cx(str);
                aVar.a(str2, new v(tbPageContext, nVar, pluginConfig));
                aVar.b(w.l.cancel, new w());
                aVar.b(tbPageContext).ts();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(TbPageContext tbPageContext) {
        if (cbN == null) {
            cbN = new com.baidu.tbadk.core.dialog.e(tbPageContext.getPageActivity());
            cbN.setOnCancelListener(new x());
            cbN.setCancelable(true);
            cbN.setCanceledOnTouchOutside(false);
            cbN.setMessage(tbPageContext.getPageActivity().getString(w.l.plugin_video_downloading));
        }
        com.baidu.adp.lib.g.j.a(cbN, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.e {
        private com.baidu.tieba.tbadkCore.n cbS;
        private TbPageContext cbT;

        private a() {
            this.cbS = null;
            this.cbT = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(a aVar) {
            this();
        }

        public void d(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
            this.cbS = nVar;
            this.cbT = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && u.cbN != null) {
                u.cbN.ce((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (u.cbN != null) {
                com.baidu.adp.lib.g.j.b(u.cbN, this.cbT);
            }
            this.cbT.showToast(w.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (u.cbN != null) {
                com.baidu.adp.lib.g.j.b(u.cbN, this.cbT);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cbT != null) {
                this.cbT.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jt().a((com.baidu.adp.plugin.packageManager.e) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (u.cbN != null) {
                com.baidu.adp.lib.g.j.b(u.cbN, this.cbT);
            }
            if (i == 0) {
                u.c(this.cbS, this.cbT);
            } else {
                this.cbT.showToast(String.valueOf(this.cbT.getString(w.l.install_failed)) + str);
            }
            PluginPackageManager.jt().a((com.baidu.adp.plugin.packageManager.e) null);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController) {
        if (bg.aI(tbPageContext.getPageActivity()) && nVar != null && tbPageContext != null) {
            boolean z = false;
            String str = "";
            if (nVar.aJp() != null && nVar.aJp().getAnchorPower() != null) {
                z = nVar.aJp().getCanAddPhotoLivePost();
                str = nVar.aJp().getAnchorPower().can_add_live_post_msg;
            }
            if (z) {
                a(nVar, tbPageContext, frsModelController, 4);
                com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
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
                    aVar.cx(optString);
                    aVar.a(w.l.view, new y(optString2, tbPageContext));
                    aVar.b(w.l.cancel, new z());
                    aVar.b(tbPageContext).ts();
                }
            }
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (nVar != null && nVar.qE() != null) {
                    nVar.qE().setIfpost(1);
                }
                bg.aG(tbPageContext.getPageActivity());
            } else if (nVar != null) {
                a(nVar, tbPageContext, frsModelController, 0);
            }
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController, int i) {
        if (nVar != null && nVar.aJp() != null && tbPageContext != null && frsModelController != null) {
            int i2 = 0;
            if (nVar.getUserData() != null) {
                i2 = nVar.getUserData().getIsMem();
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), i, nVar.aJp().getId(), nVar.aJp().getName(), null, null, 0, nVar.qE(), 13003, false, false, null, false, false, null, null, nVar.aJp().getPrefixData(), i2);
            if (bu.aad().hR(1) != null) {
                writeActivityConfig.setCategroyId(frsModelController.acP());
            }
            writeActivityConfig.addHotTopicInfo(nVar.aJp().getPostTopicData());
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public static void b(FrsActivity frsActivity, int i) {
        if (frsActivity != null) {
            com.baidu.tieba.tbadkCore.n YV = frsActivity.YV();
            FrsModelController Yx = frsActivity.Yx();
            if (YV != null && Yx != null) {
                int i2 = 0;
                if (YV.getUserData() != null) {
                    i2 = YV.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsActivity.getPageContext().getPageActivity(), i, YV.aJp().getId(), frsActivity.getForumName(), null, null, 0, YV.qE(), 13003, false, false, null, false, false, null, null, YV.aJp().getPrefixData(), i2);
                if (bu.aad().hR(1) != null) {
                    writeActivityConfig.setCategroyId(Yx.acP());
                }
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }
}
