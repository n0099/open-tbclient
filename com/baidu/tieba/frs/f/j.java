package com.baidu.tieba.frs.f;

import android.content.DialogInterface;
import android.os.Build;
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
/* loaded from: classes6.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c efU = null;
    private static a efV = null;

    public static void a(l lVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new am("c11839").aB("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && lVar != null && lVar.bhx() != null) {
            if (Build.VERSION.SDK_INT < 21) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.setAutoNight(false);
                aVar.da(e.j.prompt);
                aVar.eK(tbPageContext.getResources().getString(e.j.disallow_open_live_by_android_v5_0));
                aVar.bn(true);
                aVar.bm(true);
                aVar.a(e.j.know, new a.b() { // from class: com.baidu.tieba.frs.f.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).BS();
            } else if (!TbadkCoreApplication.isLogin()) {
                if (lVar != null && lVar.yR() != null) {
                    lVar.yR().setIfpost(1);
                }
                ba.bI(tbPageContext.getPageActivity());
            } else {
                AntiData yR = lVar.yR();
                if (yR != null && (AntiHelper.d(yR) || AntiHelper.e(yR) || AntiHelper.f(yR))) {
                    yR.setBlock_forum_name(lVar.bhx().getName());
                    yR.setBlock_forum_id(lVar.bhx().getId());
                    yR.setUser_name(lVar.getUserData().getUserName());
                    yR.setUser_id(lVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), yR, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), e.j.plugin_config_not_found);
                } else if (lVar.getUserData() != null) {
                    MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                    com.baidu.adp.lib.d.a.iW().af(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), lVar.bhx().getName(), lVar.bhx().getId(), lVar.getUserData().getUserId(), lVar.bhx().getSpecialForumType())));
                }
            }
        }
    }

    public static void b(final l lVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ba.bJ(tbPageContext.getPageActivity()) && lVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(e.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(e.j.setup));
                    return;
                }
                AntiData yR = lVar.yR();
                if (yR != null && !StringUtils.isNull(yR.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), yR.getVideo_message());
                    return;
                }
                boolean z = false;
                if (lVar != null && lVar.getUserData() != null && lVar.getUserData().getGodUserData() != null && (lVar.getUserData().getGodUserData().getType() == 2 || lVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (lVar != null && lVar.bhx() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, lVar.bhx().getId(), lVar.bhx().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.j.kV()) {
                tbPageContext.showToast(e.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().nB() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().nB().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(e.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(e.j.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.j.kX()) {
                    String string3 = tbPageContext.getPageActivity().getString(e.j.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(e.j.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.eK(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.l(TbPageContext.this);
                        if (j.efV == null) {
                            a unused = j.efV = new a();
                        }
                        j.efV.c(lVar, TbPageContext.this);
                        if (PluginPackageManager.nd().cc(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.nd().a(j.efV);
                        } else {
                            PluginPackageManager.nd().a(pluginConfig, j.efV);
                        }
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.j.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).BS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(TbPageContext tbPageContext) {
        if (efU == null) {
            efU = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            efU.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.j.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.aIc();
                }
            });
            efU.setCancelable(true);
            efU.setCanceledOnTouchOutside(false);
            efU.setMessage(tbPageContext.getPageActivity().getString(e.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(efU, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private l efY;
        private TbPageContext efZ;

        private a() {
            this.efY = null;
            this.efZ = null;
        }

        public void c(l lVar, TbPageContext tbPageContext) {
            this.efY = lVar;
            this.efZ = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.efU != null) {
                j.efU.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.efU != null) {
                com.baidu.adp.lib.g.g.b(j.efU, this.efZ);
            }
            this.efZ.showToast(e.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.efU != null) {
                com.baidu.adp.lib.g.g.b(j.efU, this.efZ);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.efZ != null) {
                this.efZ.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.nd().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.efU != null) {
                com.baidu.adp.lib.g.g.b(j.efU, this.efZ);
            }
            if (i == 0) {
                j.b(this.efY, this.efZ);
            } else {
                this.efZ.showToast(this.efZ.getString(e.j.install_failed) + str);
            }
            PluginPackageManager.nd().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void d(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            l aCl = frsFragment.aCl();
            FrsModelController aBP = frsFragment.aBP();
            if (aCl != null) {
                if (aBP != null || aCl.bhx() == null) {
                    int i2 = 0;
                    if (aCl.getUserData() != null) {
                        i2 = aCl.getUserData().getIsMem();
                    }
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsFragment.getPageContext().getPageActivity(), i, aCl.bhx().getId(), frsFragment.getForumName(), null, null, 0, aCl.yR(), 13003, false, false, null, false, false, null, null, aCl.bhx().getPrefixData(), i2);
                    if (y.aDD().mB(1) != null) {
                        writeActivityConfig.setCategroyId(aBP.aHw());
                    }
                    ForumData bhx = aCl.bhx();
                    writeActivityConfig.setForumDir(bhx.getFirst_class(), bhx.getSecond_class());
                    frsFragment.sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            }
        }
    }

    public static void aIc() {
        efV = null;
        efU = null;
        PluginPackageManager.nd().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
