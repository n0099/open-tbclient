package com.baidu.tieba.frs.e;

import android.content.DialogInterface;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
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
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes2.dex */
public class i {
    private static com.baidu.tbadk.core.dialog.c dQY = null;
    private static a dQZ = null;

    public static void a(l lVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new ak("c11839").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && lVar != null && lVar.aYE() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (lVar != null && lVar.xG() != null) {
                    lVar.xG().setIfpost(1);
                }
                ax.bd(tbPageContext.getPageActivity());
                return;
            }
            AntiData xG = lVar.xG();
            if (xG != null && (AntiHelper.d(xG) || AntiHelper.e(xG) || AntiHelper.f(xG))) {
                xG.setBlock_forum_name(lVar.aYE().getName());
                xG.setBlock_forum_id(lVar.aYE().getId());
                xG.setUser_name(lVar.getUserData().getUserName());
                xG.setUser_id(lVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), xG, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), d.j.plugin_config_not_found);
            } else if (lVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.mF().aj(false);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), lVar.aYE().getName(), lVar.aYE().getId(), lVar.getUserData().getUserId(), lVar.aYE().isGameForumType())));
            }
        }
    }

    public static void b(final l lVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ax.be(tbPageContext.getPageActivity()) && lVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
                    return;
                }
                AntiData xG = lVar.xG();
                if (xG != null && !StringUtils.isNull(xG.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), xG.getVideo_message());
                    return;
                }
                boolean z = false;
                if (lVar != null && lVar.getUserData() != null && lVar.getUserData().getGodUserData() != null && (lVar.getUserData().getGodUserData().getType() == 2 || lVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (lVar != null && lVar.aYE() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, lVar.aYE().getId(), lVar.aYE().getName(), "");
                }
            } else if (!j.oI()) {
                tbPageContext.showToast(d.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.rn().ro() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.rn().ro().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
                if (j.oK()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.j.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cZ(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.e.i.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        i.l(TbPageContext.this);
                        if (i.dQZ == null) {
                            a unused = i.dQZ = new a();
                        }
                        i.dQZ.c(lVar, TbPageContext.this);
                        if (PluginPackageManager.qR().bz(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.qR().a(i.dQZ);
                        } else {
                            PluginPackageManager.qR().a(pluginConfig, i.dQZ);
                        }
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.e.i.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).AA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(TbPageContext tbPageContext) {
        if (dQY == null) {
            dQY = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            dQY.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.e.i.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    i.ayN();
                }
            });
            dQY.setCancelable(true);
            dQY.setCanceledOnTouchOutside(false);
            dQY.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(dQY, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private l dRc;
        private TbPageContext dRd;

        private a() {
            this.dRc = null;
            this.dRd = null;
        }

        public void c(l lVar, TbPageContext tbPageContext) {
            this.dRc = lVar;
            this.dRd = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && i.dQY != null) {
                i.dQY.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (i.dQY != null) {
                com.baidu.adp.lib.g.g.b(i.dQY, this.dRd);
            }
            this.dRd.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (i.dQY != null) {
                com.baidu.adp.lib.g.g.b(i.dQY, this.dRd);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dRd != null) {
                this.dRd.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.qR().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i.dQY != null) {
                com.baidu.adp.lib.g.g.b(i.dQY, this.dRd);
            }
            if (i == 0) {
                i.b(this.dRc, this.dRd);
            } else {
                this.dRd.showToast(this.dRd.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.qR().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.i iVar, int i) {
        if (iVar != null) {
            l auq = iVar.auq();
            FrsModelController atT = iVar.atT();
            if (auq != null && atT != null) {
                int i2 = 0;
                if (auq.getUserData() != null) {
                    i2 = auq.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(iVar.getPageContext().getPageActivity(), i, auq.aYE().getId(), iVar.getForumName(), null, null, 0, auq.xG(), 13003, false, false, null, false, false, null, null, auq.aYE().getPrefixData(), i2);
                if (aa.avi().mZ(1) != null) {
                    writeActivityConfig.setCategroyId(atT.ayi());
                }
                iVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void ayN() {
        dQZ = null;
        dQY = null;
        PluginPackageManager.qR().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
