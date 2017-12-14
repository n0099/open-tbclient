package com.baidu.tieba.frs.f;

import android.content.DialogInterface;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class i {
    private static com.baidu.tbadk.core.dialog.c daa = null;
    private static a dab = null;

    public static void a(k kVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new ak("c11839").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && kVar != null && kVar.aRo() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (kVar != null && kVar.qg() != null) {
                    kVar.qg().setIfpost(1);
                }
                ax.aR(tbPageContext.getPageActivity());
                return;
            }
            AntiData qg = kVar.qg();
            if (qg != null && (AntiHelper.d(qg) || AntiHelper.e(qg) || AntiHelper.f(qg))) {
                qg.setBlock_forum_name(kVar.aRo().getName());
                qg.setBlock_forum_id(kVar.aRo().getId());
                qg.setUser_name(kVar.getUserData().getUserName());
                qg.setUser_id(kVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qg, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                l.showToast(tbPageContext.getPageActivity(), d.j.plugin_config_not_found);
            } else if (kVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.fc().D(false);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), kVar.aRo().getName(), kVar.aRo().getId(), kVar.getUserData().getUserId(), kVar.aRo().isGameForumType())));
            }
        }
    }

    public static void b(final k kVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ax.aS(tbPageContext.getPageActivity()) && kVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
                    return;
                }
                AntiData qg = kVar.qg();
                if (qg != null && !StringUtils.isNull(qg.getVideo_message())) {
                    l.showToast(tbPageContext.getPageActivity(), qg.getVideo_message());
                    return;
                }
                boolean z = false;
                if (kVar != null && kVar.getUserData() != null && kVar.getUserData().getGodUserData() != null && (kVar.getUserData().getGodUserData().getType() == 2 || kVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (kVar != null && kVar.aRo() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, kVar.aRo().getId(), kVar.aRo().getName(), "");
                }
            } else if (!j.hh()) {
                tbPageContext.showToast(d.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
                if (j.hj()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.j.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cS(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.i.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        i.m(TbPageContext.this);
                        if (i.dab == null) {
                            a unused = i.dab = new a();
                        }
                        i.dab.c(kVar, TbPageContext.this);
                        if (PluginPackageManager.js().br(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.js().a(i.dab);
                        } else {
                            PluginPackageManager.js().a(pluginConfig, i.dab);
                        }
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.i.2
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
    public static void m(TbPageContext tbPageContext) {
        if (daa == null) {
            daa = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            daa.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.i.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    i.aqD();
                }
            });
            daa.setCancelable(true);
            daa.setCanceledOnTouchOutside(false);
            daa.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(daa, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private k dae;
        private TbPageContext daf;

        private a() {
            this.dae = null;
            this.daf = null;
        }

        public void c(k kVar, TbPageContext tbPageContext) {
            this.dae = kVar;
            this.daf = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && i.daa != null) {
                i.daa.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (i.daa != null) {
                com.baidu.adp.lib.g.g.b(i.daa, this.daf);
            }
            this.daf.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (i.daa != null) {
                com.baidu.adp.lib.g.g.b(i.daa, this.daf);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.daf != null) {
                this.daf.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i.daa != null) {
                com.baidu.adp.lib.g.g.b(i.daa, this.daf);
            }
            if (i == 0) {
                i.b(this.dae, this.daf);
            } else {
                this.daf.showToast(this.daf.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.g gVar, int i) {
        if (gVar != null) {
            k alF = gVar.alF();
            FrsModelController alj = gVar.alj();
            if (alF != null && alj != null) {
                int i2 = 0;
                if (alF.getUserData() != null) {
                    i2 = alF.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(gVar.getPageContext().getPageActivity(), i, alF.aRo().getId(), gVar.getForumName(), null, null, 0, alF.qg(), 13003, false, false, null, false, false, null, null, alF.aRo().getPrefixData(), i2);
                if (aa.amx().jV(1) != null) {
                    writeActivityConfig.setCategroyId(alj.apT());
                }
                gVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void aqD() {
        dab = null;
        daa = null;
        PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
