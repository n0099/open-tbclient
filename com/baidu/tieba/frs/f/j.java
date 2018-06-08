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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes2.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c dzR = null;
    private static a dzS = null;

    public static void a(l lVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new am("c11839").ah("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && lVar != null && lVar.bam() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (lVar != null && lVar.uo() != null) {
                    lVar.uo().setIfpost(1);
                }
                ba.aT(tbPageContext.getPageActivity());
                return;
            }
            AntiData uo = lVar.uo();
            if (uo != null && (AntiHelper.d(uo) || AntiHelper.e(uo) || AntiHelper.f(uo))) {
                uo.setBlock_forum_name(lVar.bam().getName());
                uo.setBlock_forum_id(lVar.bam().getId());
                uo.setUser_name(lVar.getUserData().getUserName());
                uo.setUser_id(lVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), uo, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), d.k.plugin_config_not_found);
            } else if (lVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.hB().I(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), lVar.bam().getName(), lVar.bam().getId(), lVar.getUserData().getUserId(), lVar.bam().getSpecialForumType())));
            }
        }
    }

    public static void b(final l lVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ba.aU(tbPageContext.getPageActivity()) && lVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.k.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.k.setup));
                    return;
                }
                AntiData uo = lVar.uo();
                if (uo != null && !StringUtils.isNull(uo.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), uo.getVideo_message());
                    return;
                }
                boolean z = false;
                if (lVar != null && lVar.getUserData() != null && lVar.getUserData().getGodUserData() != null && (lVar.getUserData().getGodUserData().getType() == 2 || lVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (lVar != null && lVar.bam() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, lVar.bam().getId(), lVar.bam().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.j.jD()) {
                tbPageContext.showToast(d.k.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.k.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.k.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.j.jF()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.k.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.k.install_app);
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
                        if (j.dzS == null) {
                            a unused = j.dzS = new a();
                        }
                        j.dzS.c(lVar, TbPageContext.this);
                        if (PluginPackageManager.lL().bI(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.lL().a(j.dzS);
                        } else {
                            PluginPackageManager.lL().a(pluginConfig, j.dzS);
                        }
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).xa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(TbPageContext tbPageContext) {
        if (dzR == null) {
            dzR = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            dzR.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.ayX();
                }
            });
            dzR.setCancelable(true);
            dzR.setCanceledOnTouchOutside(false);
            dzR.setMessage(tbPageContext.getPageActivity().getString(d.k.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(dzR, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private l dzV;
        private TbPageContext dzW;

        private a() {
            this.dzV = null;
            this.dzW = null;
        }

        public void c(l lVar, TbPageContext tbPageContext) {
            this.dzV = lVar;
            this.dzW = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.dzR != null) {
                j.dzR.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.dzR != null) {
                com.baidu.adp.lib.g.g.b(j.dzR, this.dzW);
            }
            this.dzW.showToast(d.k.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.dzR != null) {
                com.baidu.adp.lib.g.g.b(j.dzR, this.dzW);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dzW != null) {
                this.dzW.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.lL().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.dzR != null) {
                com.baidu.adp.lib.g.g.b(j.dzR, this.dzW);
            }
            if (i == 0) {
                j.b(this.dzV, this.dzW);
            } else {
                this.dzW.showToast(this.dzW.getString(d.k.install_failed) + str);
            }
            PluginPackageManager.lL().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void c(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            l atI = frsFragment.atI();
            FrsModelController atm = frsFragment.atm();
            if (atI != null) {
                if (atm != null || atI.bam() == null) {
                    int i2 = 0;
                    if (atI.getUserData() != null) {
                        i2 = atI.getUserData().getIsMem();
                    }
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsFragment.getPageContext().getPageActivity(), i, atI.bam().getId(), frsFragment.getForumName(), null, null, 0, atI.uo(), 13003, false, false, null, false, false, null, null, atI.bam().getPrefixData(), i2);
                    if (w.auJ().ko(1) != null) {
                        writeActivityConfig.setCategroyId(atm.ayr());
                    }
                    ForumData bam = atI.bam();
                    writeActivityConfig.setForumDir(bam.getFirst_class(), bam.getSecond_class());
                    frsFragment.sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            }
        }
    }

    public static void ayX() {
        dzS = null;
        dzR = null;
        PluginPackageManager.lL().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
