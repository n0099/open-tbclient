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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes2.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c dMS = null;
    private static a dMT = null;

    public static void a(l lVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new am("c11839").al("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && lVar != null && lVar.bbH() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (lVar != null && lVar.vj() != null) {
                    lVar.vj().setIfpost(1);
                }
                ba.bz(tbPageContext.getPageActivity());
                return;
            }
            AntiData vj = lVar.vj();
            if (vj != null && (AntiHelper.d(vj) || AntiHelper.e(vj) || AntiHelper.f(vj))) {
                vj.setBlock_forum_name(lVar.bbH().getName());
                vj.setBlock_forum_id(lVar.bbH().getId());
                vj.setUser_name(lVar.getUserData().getUserName());
                vj.setUser_id(lVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), vj, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), e.j.plugin_config_not_found);
            } else if (lVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.iH().R(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), lVar.bbH().getName(), lVar.bbH().getId(), lVar.getUserData().getUserId(), lVar.bbH().getSpecialForumType())));
            }
        }
    }

    public static void b(final l lVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ba.bA(tbPageContext.getPageActivity()) && lVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(e.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(e.j.setup));
                    return;
                }
                AntiData vj = lVar.vj();
                if (vj != null && !StringUtils.isNull(vj.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), vj.getVideo_message());
                    return;
                }
                boolean z = false;
                if (lVar != null && lVar.getUserData() != null && lVar.getUserData().getGodUserData() != null && (lVar.getUserData().getGodUserData().getType() == 2 || lVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (lVar != null && lVar.bbH() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, lVar.bbH().getId(), lVar.bbH().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.j.kK()) {
                tbPageContext.showToast(e.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.np().nq() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.np().nq().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(e.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(e.j.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.j.kM()) {
                    String string3 = tbPageContext.getPageActivity().getString(e.j.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(e.j.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.dT(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.l(TbPageContext.this);
                        if (j.dMT == null) {
                            a unused = j.dMT = new a();
                        }
                        j.dMT.c(lVar, TbPageContext.this);
                        if (PluginPackageManager.mT().cc(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.mT().a(j.dMT);
                        } else {
                            PluginPackageManager.mT().a(pluginConfig, j.dMT);
                        }
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).yl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(TbPageContext tbPageContext) {
        if (dMS == null) {
            dMS = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            dMS.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.aCq();
                }
            });
            dMS.setCancelable(true);
            dMS.setCanceledOnTouchOutside(false);
            dMS.setMessage(tbPageContext.getPageActivity().getString(e.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(dMS, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private l dMW;
        private TbPageContext dMX;

        private a() {
            this.dMW = null;
            this.dMX = null;
        }

        public void c(l lVar, TbPageContext tbPageContext) {
            this.dMW = lVar;
            this.dMX = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.dMS != null) {
                j.dMS.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.dMS != null) {
                com.baidu.adp.lib.g.g.b(j.dMS, this.dMX);
            }
            this.dMX.showToast(e.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.dMS != null) {
                com.baidu.adp.lib.g.g.b(j.dMS, this.dMX);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dMX != null) {
                this.dMX.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.mT().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.dMS != null) {
                com.baidu.adp.lib.g.g.b(j.dMS, this.dMX);
            }
            if (i == 0) {
                j.b(this.dMW, this.dMX);
            } else {
                this.dMX.showToast(this.dMX.getString(e.j.install_failed) + str);
            }
            PluginPackageManager.mT().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void d(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            l awv = frsFragment.awv();
            FrsModelController avZ = frsFragment.avZ();
            if (awv != null) {
                if (avZ != null || awv.bbH() == null) {
                    int i2 = 0;
                    if (awv.getUserData() != null) {
                        i2 = awv.getUserData().getIsMem();
                    }
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsFragment.getPageContext().getPageActivity(), i, awv.bbH().getId(), frsFragment.getForumName(), null, null, 0, awv.vj(), 13003, false, false, null, false, false, null, null, awv.bbH().getPrefixData(), i2);
                    if (y.axO().lh(1) != null) {
                        writeActivityConfig.setCategroyId(avZ.aBJ());
                    }
                    ForumData bbH = awv.bbH();
                    writeActivityConfig.setForumDir(bbH.getFirst_class(), bbH.getSecond_class());
                    frsFragment.sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            }
        }
    }

    public static void aCq() {
        dMT = null;
        dMS = null;
        PluginPackageManager.mT().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
