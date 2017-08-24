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
    private static com.baidu.tbadk.core.dialog.c czg = null;
    private static a czh = null;

    public static void a(com.baidu.tieba.tbadkCore.i iVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new aj("c11839").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && iVar != null && iVar.aPJ() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (iVar != null && iVar.qs() != null) {
                    iVar.qs().setIfpost(1);
                }
                aw.aN(tbPageContext.getPageActivity());
                return;
            }
            AntiData qs = iVar.qs();
            if (qs != null && (AntiHelper.f(qs) || AntiHelper.g(qs) || AntiHelper.h(qs))) {
                qs.setBlock_forum_name(iVar.aPJ().getName());
                qs.setBlock_forum_id(iVar.aPJ().getId());
                qs.setUser_name(iVar.getUserData().getUserName());
                qs.setUser_id(iVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qs, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                k.showToast(tbPageContext.getPageActivity(), d.l.plugin_config_not_found);
            } else if (iVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig((Context) tbPageContext.getPageActivity(), iVar.aPJ().getName(), iVar.aPJ().getId(), iVar.getUserData().getUserId(), true, iVar.aPJ().isGameForumType())));
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
                AntiData qs = iVar.qs();
                if (qs != null && !StringUtils.isNull(qs.getVideo_message())) {
                    k.showToast(tbPageContext.getPageActivity(), qs.getVideo_message());
                    return;
                }
                boolean z = false;
                if (iVar != null && iVar.getUserData() != null && iVar.getUserData().getGodUserData() != null && (iVar.getUserData().getGodUserData().getType() == 2 || iVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (iVar != null && iVar.aPJ() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, iVar.aPJ().getId(), iVar.aPJ().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.i.hr()) {
                tbPageContext.showToast(d.l.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ka().kb() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ka().kb().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
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
                aVar.cW(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.q(TbPageContext.this);
                        if (j.czh == null) {
                            a unused = j.czh = new a();
                        }
                        j.czh.c(iVar, TbPageContext.this);
                        if (PluginPackageManager.jE().bv(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.jE().a(j.czh);
                        } else {
                            PluginPackageManager.jE().a(pluginConfig, j.czh);
                        }
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).ts();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(TbPageContext tbPageContext) {
        if (czg == null) {
            czg = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            czg.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.ajG();
                }
            });
            czg.setCancelable(true);
            czg.setCanceledOnTouchOutside(false);
            czg.setMessage(tbPageContext.getPageActivity().getString(d.l.plugin_video_downloading));
        }
        com.baidu.adp.lib.g.g.a(czg, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private com.baidu.tieba.tbadkCore.i czk;
        private TbPageContext czl;

        private a() {
            this.czk = null;
            this.czl = null;
        }

        public void c(com.baidu.tieba.tbadkCore.i iVar, TbPageContext tbPageContext) {
            this.czk = iVar;
            this.czl = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.czg != null) {
                j.czg.ck((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.czg != null) {
                com.baidu.adp.lib.g.g.b(j.czg, this.czl);
            }
            this.czl.showToast(d.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.czg != null) {
                com.baidu.adp.lib.g.g.b(j.czg, this.czl);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.czl != null) {
                this.czl.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jE().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.czg != null) {
                com.baidu.adp.lib.g.g.b(j.czg, this.czl);
            }
            if (i == 0) {
                j.b(this.czk, this.czl);
            } else {
                this.czl.showToast(this.czl.getString(d.l.install_failed) + str);
            }
            PluginPackageManager.jE().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, int i) {
        if (fVar != null) {
            com.baidu.tieba.tbadkCore.i afH = fVar.afH();
            FrsModelController afk = fVar.afk();
            if (afH != null && afk != null) {
                int i2 = 0;
                if (afH.getUserData() != null) {
                    i2 = afH.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(fVar.getPageContext().getPageActivity(), i, afH.aPJ().getId(), fVar.getForumName(), null, null, 0, afH.qs(), 13003, false, false, null, false, false, null, null, afH.aPJ().getPrefixData(), i2);
                if (y.agu().iL(1) != null) {
                    writeActivityConfig.setCategroyId(afk.aiX());
                }
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void ajG() {
        czh = null;
        czg = null;
        PluginPackageManager.jE().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
