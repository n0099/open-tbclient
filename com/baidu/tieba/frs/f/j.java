package com.baidu.tieba.frs.f;

import android.content.DialogInterface;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c cQM = null;
    private static a cQN = null;

    public static void a(com.baidu.tieba.tbadkCore.j jVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new ak("c11839").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && jVar != null && jVar.aPU() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (jVar != null && jVar.qf() != null) {
                    jVar.qf().setIfpost(1);
                }
                ax.aS(tbPageContext.getPageActivity());
                return;
            }
            AntiData qf = jVar.qf();
            if (qf != null && (AntiHelper.f(qf) || AntiHelper.g(qf) || AntiHelper.h(qf))) {
                qf.setBlock_forum_name(jVar.aPU().getName());
                qf.setBlock_forum_id(jVar.aPU().getId());
                qf.setUser_name(jVar.getUserData().getUserName());
                qf.setUser_id(jVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qf, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                l.showToast(tbPageContext.getPageActivity(), d.j.plugin_config_not_found);
            } else if (jVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.fc().D(false);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), jVar.aPU().getName(), jVar.aPU().getId(), jVar.getUserData().getUserId(), jVar.aPU().isGameForumType())));
            }
        }
    }

    public static void b(final com.baidu.tieba.tbadkCore.j jVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ax.aT(tbPageContext.getPageActivity()) && jVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
                    return;
                }
                AntiData qf = jVar.qf();
                if (qf != null && !StringUtils.isNull(qf.getVideo_message())) {
                    l.showToast(tbPageContext.getPageActivity(), qf.getVideo_message());
                    return;
                }
                boolean z = false;
                if (jVar != null && jVar.getUserData() != null && jVar.getUserData().getGodUserData() != null && (jVar.getUserData().getGodUserData().getType() == 2 || jVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (jVar != null && jVar.aPU() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, jVar.aPU().getId(), jVar.aPU().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.j.hh()) {
                tbPageContext.showToast(d.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.j.hj()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.j.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cS(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.n(TbPageContext.this);
                        if (j.cQN == null) {
                            a unused = j.cQN = new a();
                        }
                        j.cQN.c(jVar, TbPageContext.this);
                        if (PluginPackageManager.js().br(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.js().a(j.cQN);
                        } else {
                            PluginPackageManager.js().a(pluginConfig, j.cQN);
                        }
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).th();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(TbPageContext tbPageContext) {
        if (cQM == null) {
            cQM = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            cQM.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.aoA();
                }
            });
            cQM.setCancelable(true);
            cQM.setCanceledOnTouchOutside(false);
            cQM.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(cQM, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private com.baidu.tieba.tbadkCore.j cQQ;
        private TbPageContext cQR;

        private a() {
            this.cQQ = null;
            this.cQR = null;
        }

        public void c(com.baidu.tieba.tbadkCore.j jVar, TbPageContext tbPageContext) {
            this.cQQ = jVar;
            this.cQR = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.cQM != null) {
                j.cQM.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.cQM != null) {
                com.baidu.adp.lib.g.g.b(j.cQM, this.cQR);
            }
            this.cQR.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.cQM != null) {
                com.baidu.adp.lib.g.g.b(j.cQM, this.cQR);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cQR != null) {
                this.cQR.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.cQM != null) {
                com.baidu.adp.lib.g.g.b(j.cQM, this.cQR);
            }
            if (i == 0) {
                j.b(this.cQQ, this.cQR);
            } else {
                this.cQR.showToast(this.cQR.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, int i) {
        if (fVar != null) {
            com.baidu.tieba.tbadkCore.j ajB = fVar.ajB();
            FrsModelController ajf = fVar.ajf();
            if (ajB != null && ajf != null) {
                int i2 = 0;
                if (ajB.getUserData() != null) {
                    i2 = ajB.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(fVar.getPageContext().getPageActivity(), i, ajB.aPU().getId(), fVar.getForumName(), null, null, 0, ajB.qf(), 13003, false, false, null, false, false, null, null, ajB.aPU().getPrefixData(), i2);
                if (z.aks().jv(1) != null) {
                    writeActivityConfig.setCategroyId(ajf.anQ());
                }
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void aoA() {
        cQN = null;
        cQM = null;
        PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
