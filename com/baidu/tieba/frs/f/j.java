package com.baidu.tieba.frs.f;

import android.content.DialogInterface;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes2.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c dFL = null;
    private static a dFM = null;

    public static void a(l lVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new an("c11839").ae("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && lVar != null && lVar.aZg() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (lVar != null && lVar.ug() != null) {
                    lVar.ug().setIfpost(1);
                }
                bb.aT(tbPageContext.getPageActivity());
                return;
            }
            AntiData ug = lVar.ug();
            if (ug != null && (AntiHelper.d(ug) || AntiHelper.e(ug) || AntiHelper.f(ug))) {
                ug.setBlock_forum_name(lVar.aZg().getName());
                ug.setBlock_forum_id(lVar.aZg().getId());
                ug.setUser_name(lVar.getUserData().getUserName());
                ug.setUser_id(lVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), ug, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), f.j.plugin_config_not_found);
            } else if (lVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.hB().H(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), lVar.aZg().getName(), lVar.aZg().getId(), lVar.getUserData().getUserId(), lVar.aZg().getSpecialForumType())));
            }
        }
    }

    public static void b(final l lVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (bb.aU(tbPageContext.getPageActivity()) && lVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(f.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(f.j.setup));
                    return;
                }
                AntiData ug = lVar.ug();
                if (ug != null && !StringUtils.isNull(ug.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), ug.getVideo_message());
                    return;
                }
                boolean z = false;
                if (lVar != null && lVar.getUserData() != null && lVar.getUserData().getGodUserData() != null && (lVar.getUserData().getGodUserData().getType() == 2 || lVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (lVar != null && lVar.aZg() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, lVar.aZg().getId(), lVar.aZg().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.j.jE()) {
                tbPageContext.showToast(f.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(f.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(f.j.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.j.jG()) {
                    String string3 = tbPageContext.getPageActivity().getString(f.j.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(f.j.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.dB(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.l(TbPageContext.this);
                        if (j.dFM == null) {
                            a unused = j.dFM = new a();
                        }
                        j.dFM.c(lVar, TbPageContext.this);
                        if (PluginPackageManager.lN().bL(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.lN().a(j.dFM);
                        } else {
                            PluginPackageManager.lN().a(pluginConfig, j.dFM);
                        }
                    }
                });
                aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).xe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(TbPageContext tbPageContext) {
        if (dFL == null) {
            dFL = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            dFL.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.aAh();
                }
            });
            dFL.setCancelable(true);
            dFL.setCanceledOnTouchOutside(false);
            dFL.setMessage(tbPageContext.getPageActivity().getString(f.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(dFL, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private l dFP;
        private TbPageContext dFQ;

        private a() {
            this.dFP = null;
            this.dFQ = null;
        }

        public void c(l lVar, TbPageContext tbPageContext) {
            this.dFP = lVar;
            this.dFQ = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.dFL != null) {
                j.dFL.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.dFL != null) {
                com.baidu.adp.lib.g.g.b(j.dFL, this.dFQ);
            }
            this.dFQ.showToast(f.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.dFL != null) {
                com.baidu.adp.lib.g.g.b(j.dFL, this.dFQ);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dFQ != null) {
                this.dFQ.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.lN().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.dFL != null) {
                com.baidu.adp.lib.g.g.b(j.dFL, this.dFQ);
            }
            if (i == 0) {
                j.b(this.dFP, this.dFQ);
            } else {
                this.dFQ.showToast(this.dFQ.getString(f.j.install_failed) + str);
            }
            PluginPackageManager.lN().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void d(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            l auC = frsFragment.auC();
            FrsModelController aug = frsFragment.aug();
            if (auC != null) {
                if (aug != null || auC.aZg() == null) {
                    int i2 = 0;
                    if (auC.getUserData() != null) {
                        i2 = auC.getUserData().getIsMem();
                    }
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsFragment.getPageContext().getPageActivity(), i, auC.aZg().getId(), frsFragment.getForumName(), null, null, 0, auC.ug(), 13003, false, false, null, false, false, null, null, auC.aZg().getPrefixData(), i2);
                    if (y.avH().kE(1) != null) {
                        writeActivityConfig.setCategroyId(aug.azA());
                    }
                    ForumData aZg = auC.aZg();
                    writeActivityConfig.setForumDir(aZg.getFirst_class(), aZg.getSecond_class());
                    frsFragment.sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            }
        }
    }

    public static void aAh() {
        dFM = null;
        dFL = null;
        PluginPackageManager.lN().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
