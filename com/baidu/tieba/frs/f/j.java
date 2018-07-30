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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes2.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c dFP = null;
    private static a dFQ = null;

    public static void a(l lVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new an("c11839").af("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && lVar != null && lVar.aZl() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (lVar != null && lVar.uh() != null) {
                    lVar.uh().setIfpost(1);
                }
                ba.aU(tbPageContext.getPageActivity());
                return;
            }
            AntiData uh = lVar.uh();
            if (uh != null && (AntiHelper.d(uh) || AntiHelper.e(uh) || AntiHelper.f(uh))) {
                uh.setBlock_forum_name(lVar.aZl().getName());
                uh.setBlock_forum_id(lVar.aZl().getId());
                uh.setUser_name(lVar.getUserData().getUserName());
                uh.setUser_id(lVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), uh, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), d.j.plugin_config_not_found);
            } else if (lVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.hB().H(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), lVar.aZl().getName(), lVar.aZl().getId(), lVar.getUserData().getUserId(), lVar.aZl().getSpecialForumType())));
            }
        }
    }

    public static void b(final l lVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ba.aV(tbPageContext.getPageActivity()) && lVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
                    return;
                }
                AntiData uh = lVar.uh();
                if (uh != null && !StringUtils.isNull(uh.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), uh.getVideo_message());
                    return;
                }
                boolean z = false;
                if (lVar != null && lVar.getUserData() != null && lVar.getUserData().getGodUserData() != null && (lVar.getUserData().getGodUserData().getType() == 2 || lVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (lVar != null && lVar.aZl() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, lVar.aZl().getId(), lVar.aZl().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.j.jE()) {
                tbPageContext.showToast(d.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.j.jG()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.j.install_app);
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
                        if (j.dFQ == null) {
                            a unused = j.dFQ = new a();
                        }
                        j.dFQ.c(lVar, TbPageContext.this);
                        if (PluginPackageManager.lN().bL(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.lN().a(j.dFQ);
                        } else {
                            PluginPackageManager.lN().a(pluginConfig, j.dFQ);
                        }
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).xf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(TbPageContext tbPageContext) {
        if (dFP == null) {
            dFP = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            dFP.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.aAk();
                }
            });
            dFP.setCancelable(true);
            dFP.setCanceledOnTouchOutside(false);
            dFP.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(dFP, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private l dFT;
        private TbPageContext dFU;

        private a() {
            this.dFT = null;
            this.dFU = null;
        }

        public void c(l lVar, TbPageContext tbPageContext) {
            this.dFT = lVar;
            this.dFU = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.dFP != null) {
                j.dFP.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.dFP != null) {
                com.baidu.adp.lib.g.g.b(j.dFP, this.dFU);
            }
            this.dFU.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.dFP != null) {
                com.baidu.adp.lib.g.g.b(j.dFP, this.dFU);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dFU != null) {
                this.dFU.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.lN().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.dFP != null) {
                com.baidu.adp.lib.g.g.b(j.dFP, this.dFU);
            }
            if (i == 0) {
                j.b(this.dFT, this.dFU);
            } else {
                this.dFU.showToast(this.dFU.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.lN().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void d(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            l auD = frsFragment.auD();
            FrsModelController auh = frsFragment.auh();
            if (auD != null) {
                if (auh != null || auD.aZl() == null) {
                    int i2 = 0;
                    if (auD.getUserData() != null) {
                        i2 = auD.getUserData().getIsMem();
                    }
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsFragment.getPageContext().getPageActivity(), i, auD.aZl().getId(), frsFragment.getForumName(), null, null, 0, auD.uh(), 13003, false, false, null, false, false, null, null, auD.aZl().getPrefixData(), i2);
                    if (y.avI().kF(1) != null) {
                        writeActivityConfig.setCategroyId(auh.azD());
                    }
                    ForumData aZl = auD.aZl();
                    writeActivityConfig.setForumDir(aZl.getFirst_class(), aZl.getSecond_class());
                    frsFragment.sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            }
        }
    }

    public static void aAk() {
        dFQ = null;
        dFP = null;
        PluginPackageManager.lN().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
