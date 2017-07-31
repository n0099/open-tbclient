package com.baidu.tieba.frs.f;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c cxi = null;
    private static a cxj = null;

    public static void a(com.baidu.tieba.tbadkCore.i iVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new aj("c11839").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && iVar != null && iVar.aPh() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (iVar != null && iVar.qr() != null) {
                    iVar.qr().setIfpost(1);
                }
                aw.aN(tbPageContext.getPageActivity());
                return;
            }
            AntiData qr = iVar.qr();
            if (qr != null && (AntiHelper.f(qr) || AntiHelper.g(qr) || AntiHelper.h(qr))) {
                qr.setBlock_forum_name(iVar.aPh().getName());
                qr.setBlock_forum_id(iVar.aPh().getId());
                qr.setUser_name(iVar.getUserData().getUserName());
                qr.setUser_id(iVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qr, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                k.showToast(tbPageContext.getPageActivity(), d.l.plugin_config_not_found);
            } else if (iVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig((Context) tbPageContext.getPageActivity(), iVar.aPh().getName(), iVar.aPh().getId(), iVar.getUserData().getUserId(), true, iVar.aPh().isGameForumType())));
            }
        }
    }

    public static void b(final com.baidu.tieba.tbadkCore.i iVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (aw.aO(tbPageContext.getPageActivity()) && iVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.l.setup));
                    return;
                }
                AntiData qr = iVar.qr();
                if (qr != null && !StringUtils.isNull(qr.getVideo_message())) {
                    k.showToast(tbPageContext.getPageActivity(), qr.getVideo_message());
                    return;
                }
                boolean z = false;
                if (iVar != null && iVar.getUserData() != null && iVar.getUserData().getGodUserData() != null && (iVar.getUserData().getGodUserData().getType() == 2 || iVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (iVar != null && iVar.aPh() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, iVar.aPh().getId(), iVar.aPh().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.i.hr()) {
                tbPageContext.showToast(d.l.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.kb().kc() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.kb().kc().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.l.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.i.ht()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.l.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cT(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.q(TbPageContext.this);
                        if (j.cxj == null) {
                            a unused = j.cxj = new a();
                        }
                        j.cxj.c(iVar, TbPageContext.this);
                        if (PluginPackageManager.jE().bu(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.jE().a(j.cxj);
                        } else {
                            PluginPackageManager.jE().a(pluginConfig, j.cxj);
                        }
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).tr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(TbPageContext tbPageContext) {
        if (cxi == null) {
            cxi = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            cxi.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.ajf();
                }
            });
            cxi.setCancelable(true);
            cxi.setCanceledOnTouchOutside(false);
            cxi.setMessage(tbPageContext.getPageActivity().getString(d.l.plugin_video_downloading));
        }
        com.baidu.adp.lib.g.g.a(cxi, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private com.baidu.tieba.tbadkCore.i cxm;
        private TbPageContext cxn;

        private a() {
            this.cxm = null;
            this.cxn = null;
        }

        public void c(com.baidu.tieba.tbadkCore.i iVar, TbPageContext tbPageContext) {
            this.cxm = iVar;
            this.cxn = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.cxi != null) {
                j.cxi.ck((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.cxi != null) {
                com.baidu.adp.lib.g.g.b(j.cxi, this.cxn);
            }
            this.cxn.showToast(d.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.cxi != null) {
                com.baidu.adp.lib.g.g.b(j.cxi, this.cxn);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cxn != null) {
                this.cxn.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jE().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.cxi != null) {
                com.baidu.adp.lib.g.g.b(j.cxi, this.cxn);
            }
            if (i == 0) {
                j.b(this.cxm, this.cxn);
            } else {
                this.cxn.showToast(this.cxn.getString(d.l.install_failed) + str);
            }
            PluginPackageManager.jE().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, int i) {
        if (fVar != null) {
            com.baidu.tieba.tbadkCore.i afr = fVar.afr();
            FrsModelController aeU = fVar.aeU();
            if (afr != null && aeU != null) {
                int i2 = 0;
                if (afr.getUserData() != null) {
                    i2 = afr.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(fVar.getPageContext().getPageActivity(), i, afr.aPh().getId(), fVar.getForumName(), null, null, 0, afr.qr(), 13003, false, false, null, false, false, null, null, afr.aPh().getPrefixData(), i2);
                if (y.agf().iJ(1) != null) {
                    writeActivityConfig.setCategroyId(aeU.aiw());
                }
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void ajf() {
        cxj = null;
        cxi = null;
        PluginPackageManager.jE().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
