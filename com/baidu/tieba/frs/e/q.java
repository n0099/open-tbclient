package com.baidu.tieba.frs.e;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class q {
    private static com.baidu.tbadk.core.dialog.e cgF = null;
    private static a cgG = null;

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new as("c11839").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && nVar != null && nVar.aIz() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (nVar != null && nVar.qh() != null) {
                    nVar.qh().setIfpost(1);
                }
                bh.aL(tbPageContext.getPageActivity());
                return;
            }
            AntiData qh = nVar.qh();
            if (qh != null && (AntiHelper.f(qh) || AntiHelper.g(qh) || AntiHelper.h(qh))) {
                qh.setBlock_forum_name(nVar.aIz().getName());
                qh.setBlock_forum_id(nVar.aIz().getId());
                qh.setUser_name(nVar.getUserData().getUserName());
                qh.setUser_id(nVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qh, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), w.l.plugin_config_not_found);
            } else if (nVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig((Context) tbPageContext.getPageActivity(), nVar.aIz().getName(), nVar.aIz().getId(), nVar.getUserData().getUserId(), true, nVar.aIz().isGameForumType())));
            }
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        String string;
        TiebaStatic.log("c10798");
        if (bh.aN(tbPageContext.getPageActivity()) && nVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(w.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(w.l.setup));
                    return;
                }
                AntiData qh = nVar.qh();
                if (qh != null && !StringUtils.isNull(qh.getVideo_message())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), qh.getVideo_message());
                    return;
                }
                boolean z = false;
                if (nVar != null && nVar.getUserData() != null && nVar.getUserData().getGodUserData() != null && (nVar.getUserData().getGodUserData().getType() == 2 || nVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (nVar != null && nVar.aIz() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, nVar.aIz().getId(), nVar.aIz().getName());
                }
            } else if (!com.baidu.adp.lib.util.i.hk()) {
                tbPageContext.showToast(w.l.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string2 = tbPageContext.getPageActivity().getString(w.l.plugin_imme_install);
                String string3 = tbPageContext.getPageActivity().getString(w.l.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.i.hm()) {
                    str = f > 0.0f ? String.valueOf(string) + "（" + f + "MB）" : tbPageContext.getPageActivity().getString(w.l.plugin_video_install_tips_mobile);
                    str2 = tbPageContext.getPageActivity().getString(w.l.install_app);
                } else {
                    str = string3;
                    str2 = string2;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cB(str);
                aVar.a(str2, new r(tbPageContext, nVar, pluginConfig));
                aVar.b(w.l.cancel, new s());
                aVar.b(tbPageContext).tc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(TbPageContext tbPageContext) {
        if (cgF == null) {
            cgF = new com.baidu.tbadk.core.dialog.e(tbPageContext.getPageActivity());
            cgF.setOnCancelListener(new t());
            cgF.setCancelable(true);
            cgF.setCanceledOnTouchOutside(false);
            cgF.setMessage(tbPageContext.getPageActivity().getString(w.l.plugin_video_downloading));
        }
        com.baidu.adp.lib.g.j.a(cgF, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.e {
        private com.baidu.tieba.tbadkCore.n cgJ;
        private TbPageContext cgK;

        private a() {
            this.cgJ = null;
            this.cgK = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(a aVar) {
            this();
        }

        public void c(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
            this.cgJ = nVar;
            this.cgK = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && q.cgF != null) {
                q.cgF.cg((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (q.cgF != null) {
                com.baidu.adp.lib.g.j.b(q.cgF, this.cgK);
            }
            this.cgK.showToast(w.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (q.cgF != null) {
                com.baidu.adp.lib.g.j.b(q.cgF, this.cgK);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cgK != null) {
                this.cgK.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (q.cgF != null) {
                com.baidu.adp.lib.g.j.b(q.cgF, this.cgK);
            }
            if (i == 0) {
                q.b(this.cgJ, this.cgK);
            } else {
                this.cgK.showToast(String.valueOf(this.cgK.getString(w.l.install_failed)) + str);
            }
            PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (nVar != null && nVar.qh() != null) {
                    nVar.qh().setIfpost(1);
                }
                bh.aL(tbPageContext.getPageActivity());
            } else if (nVar != null) {
                a(nVar, tbPageContext, frsModelController, 0);
            }
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController, int i) {
        if (nVar != null && nVar.aIz() != null && tbPageContext != null && frsModelController != null) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), 0, nVar.aIz().getId(), nVar.aIz().getName(), null, null, 0, nVar.qh(), 0, false, false, null, false, false, null, null, nVar.aIz().getPrefixData(), 0);
            writeActivityConfig.setCallFrom("2");
            writeActivityConfig.setForumLevel(nVar.aIz().getUser_level());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public static void b(com.baidu.tieba.frs.r rVar, int i) {
        if (rVar != null) {
            com.baidu.tieba.tbadkCore.n aau = rVar.aau();
            FrsModelController ZY = rVar.ZY();
            if (aau != null && ZY != null) {
                int i2 = 0;
                if (aau.getUserData() != null) {
                    i2 = aau.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(rVar.getPageContext().getPageActivity(), i, aau.aIz().getId(), rVar.getForumName(), null, null, 0, aau.qh(), 13003, false, false, null, false, false, null, null, aau.aIz().getPrefixData(), i2);
                if (bq.abd().io(1) != null) {
                    writeActivityConfig.setCategroyId(ZY.acS());
                }
                rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void adC() {
        cgG = null;
        cgF = null;
        PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
