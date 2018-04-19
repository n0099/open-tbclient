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
    private static com.baidu.tbadk.core.dialog.c dpz = null;
    private static a dpA = null;

    public static void a(l lVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new al("c11839").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && lVar != null && lVar.aVq() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (lVar != null && lVar.qT() != null) {
                    lVar.qT().setIfpost(1);
                }
                az.aJ(tbPageContext.getPageActivity());
                return;
            }
            AntiData qT = lVar.qT();
            if (qT != null && (AntiHelper.d(qT) || AntiHelper.e(qT) || AntiHelper.f(qT))) {
                qT.setBlock_forum_name(lVar.aVq().getName());
                qT.setBlock_forum_id(lVar.aVq().getId());
                qT.setUser_name(lVar.getUserData().getUserName());
                qT.setUser_id(lVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qT, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
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
                AntiData qT = lVar.qT();
                if (qT != null && !StringUtils.isNull(qT.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), qT.getVideo_message());
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
                        i.k(TbPageContext.this);
                        if (i.dpA == null) {
                            a unused = i.dpA = new a();
                        }
                        i.dpA.c(lVar, TbPageContext.this);
                        if (PluginPackageManager.iX().bw(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.iX().a(i.dpA);
                        } else {
                            PluginPackageManager.iX().a(pluginConfig, i.dpA);
                        }
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.i.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).tD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(TbPageContext tbPageContext) {
        if (dpz == null) {
            dpz = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            dpz.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.i.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    i.auO();
                }
            });
            dpz.setCancelable(true);
            dpz.setCanceledOnTouchOutside(false);
            dpz.setMessage(tbPageContext.getPageActivity().getString(d.k.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(dpz, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private l dpD;
        private TbPageContext dpE;

        private a() {
            this.dpD = null;
            this.dpE = null;
        }

        public void c(l lVar, TbPageContext tbPageContext) {
            this.dpD = lVar;
            this.dpE = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && i.dpz != null) {
                i.dpz.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (i.dpz != null) {
                com.baidu.adp.lib.g.g.b(i.dpz, this.dpE);
            }
            this.dpE.showToast(d.k.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (i.dpz != null) {
                com.baidu.adp.lib.g.g.b(i.dpz, this.dpE);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dpE != null) {
                this.dpE.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.iX().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i.dpz != null) {
                com.baidu.adp.lib.g.g.b(i.dpz, this.dpE);
            }
            if (i == 0) {
                i.b(this.dpD, this.dpE);
            } else {
                this.dpE.showToast(this.dpE.getString(d.k.install_failed) + str);
            }
            PluginPackageManager.iX().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void c(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            l apE = frsFragment.apE();
            FrsModelController aph = frsFragment.aph();
            if (apE != null) {
                if (aph != null || apE.aVq() == null) {
                    int i2 = 0;
                    if (apE.getUserData() != null) {
                        i2 = apE.getUserData().getIsMem();
                    }
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsFragment.getPageContext().getPageActivity(), i, apE.aVq().getId(), frsFragment.getForumName(), null, null, 0, apE.qT(), 13003, false, false, null, false, false, null, null, apE.aVq().getPrefixData(), i2);
                    if (w.aqF().kk(1) != null) {
                        writeActivityConfig.setCategroyId(aph.auf());
                    }
                    ForumData aVq = apE.aVq();
                    writeActivityConfig.setForumDir(aVq.getFirst_class(), aVq.getSecond_class());
                    frsFragment.sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            }
        }
    }

    public static void auO() {
        dpA = null;
        dpz = null;
        PluginPackageManager.iX().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
