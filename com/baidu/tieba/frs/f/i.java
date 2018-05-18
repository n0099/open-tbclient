package com.baidu.tieba.frs.f;

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
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes2.dex */
public class i {
    private static com.baidu.tbadk.core.dialog.c dqE = null;
    private static a dqF = null;

    public static void a(l lVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new al("c11839").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && lVar != null && lVar.aVq() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (lVar != null && lVar.qS() != null) {
                    lVar.qS().setIfpost(1);
                }
                az.aJ(tbPageContext.getPageActivity());
                return;
            }
            AntiData qS = lVar.qS();
            if (qS != null && (AntiHelper.d(qS) || AntiHelper.e(qS) || AntiHelper.f(qS))) {
                qS.setBlock_forum_name(lVar.aVq().getName());
                qS.setBlock_forum_id(lVar.aVq().getId());
                qS.setUser_name(lVar.getUserData().getUserName());
                qS.setUser_id(lVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qS, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), d.k.plugin_config_not_found);
            } else if (lVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.eK().G(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), lVar.aVq().getName(), lVar.aVq().getId(), lVar.getUserData().getUserId(), lVar.aVq().getSpecialForumType())));
            }
        }
    }

    public static void b(final l lVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (az.aK(tbPageContext.getPageActivity()) && lVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.k.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.k.setup));
                    return;
                }
                AntiData qS = lVar.qS();
                if (qS != null && !StringUtils.isNull(qS.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), qS.getVideo_message());
                    return;
                }
                boolean z = false;
                if (lVar != null && lVar.getUserData() != null && lVar.getUserData().getGodUserData() != null && (lVar.getUserData().getGodUserData().getType() == 2 || lVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (lVar != null && lVar.aVq() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, lVar.aVq().getId(), lVar.aVq().getName(), "");
                }
            } else if (!j.gP()) {
                tbPageContext.showToast(d.k.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jt().ju() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jt().ju().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.k.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.k.plugin_video_install_tips_wifi);
                if (j.gR()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.k.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.k.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.dc(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.i.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        i.l(TbPageContext.this);
                        if (i.dqF == null) {
                            a unused = i.dqF = new a();
                        }
                        i.dqF.c(lVar, TbPageContext.this);
                        if (PluginPackageManager.iX().bw(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.iX().a(i.dqF);
                        } else {
                            PluginPackageManager.iX().a(pluginConfig, i.dqF);
                        }
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.i.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).tC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(TbPageContext tbPageContext) {
        if (dqE == null) {
            dqE = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            dqE.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.i.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    i.auN();
                }
            });
            dqE.setCancelable(true);
            dqE.setCanceledOnTouchOutside(false);
            dqE.setMessage(tbPageContext.getPageActivity().getString(d.k.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(dqE, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private l dqI;
        private TbPageContext dqJ;

        private a() {
            this.dqI = null;
            this.dqJ = null;
        }

        public void c(l lVar, TbPageContext tbPageContext) {
            this.dqI = lVar;
            this.dqJ = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && i.dqE != null) {
                i.dqE.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (i.dqE != null) {
                com.baidu.adp.lib.g.g.b(i.dqE, this.dqJ);
            }
            this.dqJ.showToast(d.k.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (i.dqE != null) {
                com.baidu.adp.lib.g.g.b(i.dqE, this.dqJ);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dqJ != null) {
                this.dqJ.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.iX().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i.dqE != null) {
                com.baidu.adp.lib.g.g.b(i.dqE, this.dqJ);
            }
            if (i == 0) {
                i.b(this.dqI, this.dqJ);
            } else {
                this.dqJ.showToast(this.dqJ.getString(d.k.install_failed) + str);
            }
            PluginPackageManager.iX().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void c(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            l apD = frsFragment.apD();
            FrsModelController apg = frsFragment.apg();
            if (apD != null) {
                if (apg != null || apD.aVq() == null) {
                    int i2 = 0;
                    if (apD.getUserData() != null) {
                        i2 = apD.getUserData().getIsMem();
                    }
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsFragment.getPageContext().getPageActivity(), i, apD.aVq().getId(), frsFragment.getForumName(), null, null, 0, apD.qS(), 13003, false, false, null, false, false, null, null, apD.aVq().getPrefixData(), i2);
                    if (w.aqE().kj(1) != null) {
                        writeActivityConfig.setCategroyId(apg.aue());
                    }
                    ForumData aVq = apD.aVq();
                    writeActivityConfig.setForumDir(aVq.getFirst_class(), aVq.getSecond_class());
                    frsFragment.sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            }
        }
    }

    public static void auN() {
        dqF = null;
        dqE = null;
        PluginPackageManager.iX().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
