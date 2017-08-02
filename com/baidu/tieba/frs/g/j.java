package com.baidu.tieba.frs.g;

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
    private static com.baidu.tbadk.core.dialog.c cvO = null;
    private static a cvP = null;

    public static void a(com.baidu.tieba.tbadkCore.i iVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new aj("c11839").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && iVar != null && iVar.aOW() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (iVar != null && iVar.qh() != null) {
                    iVar.qh().setIfpost(1);
                }
                aw.aM(tbPageContext.getPageActivity());
                return;
            }
            AntiData qh = iVar.qh();
            if (qh != null && (AntiHelper.f(qh) || AntiHelper.g(qh) || AntiHelper.h(qh))) {
                qh.setBlock_forum_name(iVar.aOW().getName());
                qh.setBlock_forum_id(iVar.aOW().getId());
                qh.setUser_name(iVar.getUserData().getUserName());
                qh.setUser_id(iVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qh, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                k.showToast(tbPageContext.getPageActivity(), d.l.plugin_config_not_found);
            } else if (iVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig((Context) tbPageContext.getPageActivity(), iVar.aOW().getName(), iVar.aOW().getId(), iVar.getUserData().getUserId(), true, iVar.aOW().isGameForumType())));
            }
        }
    }

    public static void b(final com.baidu.tieba.tbadkCore.i iVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (aw.aN(tbPageContext.getPageActivity()) && iVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.l.setup));
                    return;
                }
                AntiData qh = iVar.qh();
                if (qh != null && !StringUtils.isNull(qh.getVideo_message())) {
                    k.showToast(tbPageContext.getPageActivity(), qh.getVideo_message());
                    return;
                }
                boolean z = false;
                if (iVar != null && iVar.getUserData() != null && iVar.getUserData().getGodUserData() != null && (iVar.getUserData().getGodUserData().getType() == 2 || iVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (iVar != null && iVar.aOW() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, iVar.aOW().getId(), iVar.aOW().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.i.hh()) {
                tbPageContext.showToast(d.l.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.l.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.i.hj()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.l.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cN(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.g.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.q(TbPageContext.this);
                        if (j.cvP == null) {
                            a unused = j.cvP = new a();
                        }
                        j.cvP.c(iVar, TbPageContext.this);
                        if (PluginPackageManager.ju().bo(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.ju().a(j.cvP);
                        } else {
                            PluginPackageManager.ju().a(pluginConfig, j.cvP);
                        }
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.g.j.2
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
    public static void q(TbPageContext tbPageContext) {
        if (cvO == null) {
            cvO = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            cvO.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.g.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.aiT();
                }
            });
            cvO.setCancelable(true);
            cvO.setCanceledOnTouchOutside(false);
            cvO.setMessage(tbPageContext.getPageActivity().getString(d.l.plugin_video_downloading));
        }
        com.baidu.adp.lib.g.g.a(cvO, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private com.baidu.tieba.tbadkCore.i cvS;
        private TbPageContext cvT;

        private a() {
            this.cvS = null;
            this.cvT = null;
        }

        public void c(com.baidu.tieba.tbadkCore.i iVar, TbPageContext tbPageContext) {
            this.cvS = iVar;
            this.cvT = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.cvO != null) {
                j.cvO.ci((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.cvO != null) {
                com.baidu.adp.lib.g.g.b(j.cvO, this.cvT);
            }
            this.cvT.showToast(d.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.cvO != null) {
                com.baidu.adp.lib.g.g.b(j.cvO, this.cvT);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cvT != null) {
                this.cvT.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.ju().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.cvO != null) {
                com.baidu.adp.lib.g.g.b(j.cvO, this.cvT);
            }
            if (i == 0) {
                j.b(this.cvS, this.cvT);
            } else {
                this.cvT.showToast(this.cvT.getString(d.l.install_failed) + str);
            }
            PluginPackageManager.ju().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, int i) {
        if (fVar != null) {
            com.baidu.tieba.tbadkCore.i afm = fVar.afm();
            FrsModelController aeP = fVar.aeP();
            if (afm != null && aeP != null) {
                int i2 = 0;
                if (afm.getUserData() != null) {
                    i2 = afm.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(fVar.getPageContext().getPageActivity(), i, afm.aOW().getId(), fVar.getForumName(), null, null, 0, afm.qh(), 13003, false, false, null, false, false, null, null, afm.aOW().getPrefixData(), i2);
                if (y.afY().iJ(1) != null) {
                    writeActivityConfig.setCategroyId(aeP.aik());
                }
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void aiT() {
        cvP = null;
        cvO = null;
        PluginPackageManager.ju().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
