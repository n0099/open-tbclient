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
    private static com.baidu.tbadk.core.dialog.c dRt = null;
    private static a dRu = null;

    public static void a(l lVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new ak("c11839").aa("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && lVar != null && lVar.aYJ() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (lVar != null && lVar.xH() != null) {
                    lVar.xH().setIfpost(1);
                }
                ax.ba(tbPageContext.getPageActivity());
                return;
            }
            AntiData xH = lVar.xH();
            if (xH != null && (AntiHelper.d(xH) || AntiHelper.e(xH) || AntiHelper.f(xH))) {
                xH.setBlock_forum_name(lVar.aYJ().getName());
                xH.setBlock_forum_id(lVar.aYJ().getId());
                xH.setUser_name(lVar.getUserData().getUserName());
                xH.setUser_id(lVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), xH, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), d.j.plugin_config_not_found);
            } else if (lVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.mG().ak(false);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), lVar.aYJ().getName(), lVar.aYJ().getId(), lVar.getUserData().getUserId(), lVar.aYJ().isGameForumType())));
            }
        }
    }

    public static void b(final l lVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ax.bb(tbPageContext.getPageActivity()) && lVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
                    return;
                }
                AntiData xH = lVar.xH();
                if (xH != null && !StringUtils.isNull(xH.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), xH.getVideo_message());
                    return;
                }
                boolean z = false;
                if (lVar != null && lVar.getUserData() != null && lVar.getUserData().getGodUserData() != null && (lVar.getUserData().getGodUserData().getType() == 2 || lVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (lVar != null && lVar.aYJ() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, lVar.aYJ().getId(), lVar.aYJ().getName(), "");
                }
            } else if (!j.oJ()) {
                tbPageContext.showToast(d.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
                if (j.oL()) {
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
                        if (i.dRu == null) {
                            a unused = i.dRu = new a();
                        }
                        i.dRu.c(lVar, TbPageContext.this);
                        if (PluginPackageManager.qS().bz(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.qS().a(i.dRu);
                        } else {
                            PluginPackageManager.qS().a(pluginConfig, i.dRu);
                        }
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.e.i.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).AB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(TbPageContext tbPageContext) {
        if (dRt == null) {
            dRt = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            dRt.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.e.i.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    i.ayS();
                }
            });
            dRt.setCancelable(true);
            dRt.setCanceledOnTouchOutside(false);
            dRt.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(dRt, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private l dRx;
        private TbPageContext dRy;

        private a() {
            this.dRx = null;
            this.dRy = null;
        }

        public void c(l lVar, TbPageContext tbPageContext) {
            this.dRx = lVar;
            this.dRy = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && i.dRt != null) {
                i.dRt.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (i.dRt != null) {
                com.baidu.adp.lib.g.g.b(i.dRt, this.dRy);
            }
            this.dRy.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (i.dRt != null) {
                com.baidu.adp.lib.g.g.b(i.dRt, this.dRy);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dRy != null) {
                this.dRy.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i.dRt != null) {
                com.baidu.adp.lib.g.g.b(i.dRt, this.dRy);
            }
            if (i == 0) {
                i.b(this.dRx, this.dRy);
            } else {
                this.dRy.showToast(this.dRy.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.i iVar, int i) {
        if (iVar != null) {
            l auv = iVar.auv();
            FrsModelController atY = iVar.atY();
            if (auv != null && atY != null) {
                int i2 = 0;
                if (auv.getUserData() != null) {
                    i2 = auv.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(iVar.getPageContext().getPageActivity(), i, auv.aYJ().getId(), iVar.getForumName(), null, null, 0, auv.xH(), 13003, false, false, null, false, false, null, null, auv.aYJ().getPrefixData(), i2);
                if (aa.avn().mZ(1) != null) {
                    writeActivityConfig.setCategroyId(atY.ayn());
                }
                iVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void ayS() {
        dRu = null;
        dRt = null;
        PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
