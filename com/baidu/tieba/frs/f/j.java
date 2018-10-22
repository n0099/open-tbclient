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
/* loaded from: classes6.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c dUO = null;
    private static a dUP = null;

    public static void a(l lVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new am("c11839").ax("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && lVar != null && lVar.beT() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (lVar != null && lVar.xs() != null) {
                    lVar.xs().setIfpost(1);
                }
                ba.bH(tbPageContext.getPageActivity());
                return;
            }
            AntiData xs = lVar.xs();
            if (xs != null && (AntiHelper.d(xs) || AntiHelper.e(xs) || AntiHelper.f(xs))) {
                xs.setBlock_forum_name(lVar.beT().getName());
                xs.setBlock_forum_id(lVar.beT().getId());
                xs.setUser_name(lVar.getUserData().getUserName());
                xs.setUser_id(lVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), xs, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), e.j.plugin_config_not_found);
            } else if (lVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.iX().R(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), lVar.beT().getName(), lVar.beT().getId(), lVar.getUserData().getUserId(), lVar.beT().getSpecialForumType())));
            }
        }
    }

    public static void b(final l lVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ba.bI(tbPageContext.getPageActivity()) && lVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(e.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(e.j.setup));
                    return;
                }
                AntiData xs = lVar.xs();
                if (xs != null && !StringUtils.isNull(xs.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), xs.getVideo_message());
                    return;
                }
                boolean z = false;
                if (lVar != null && lVar.getUserData() != null && lVar.getUserData().getGodUserData() != null && (lVar.getUserData().getGodUserData().getType() == 2 || lVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (lVar != null && lVar.beT() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, lVar.beT().getId(), lVar.beT().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.j.kX()) {
                tbPageContext.showToast(e.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nz().nA() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nz().nA().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(e.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(e.j.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.j.kZ()) {
                    String string3 = tbPageContext.getPageActivity().getString(e.j.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(e.j.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.ej(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.l(TbPageContext.this);
                        if (j.dUP == null) {
                            a unused = j.dUP = new a();
                        }
                        j.dUP.c(lVar, TbPageContext.this);
                        if (PluginPackageManager.nd().cb(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.nd().a(j.dUP);
                        } else {
                            PluginPackageManager.nd().a(pluginConfig, j.dUP);
                        }
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).Au();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(TbPageContext tbPageContext) {
        if (dUO == null) {
            dUO = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            dUO.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.aFI();
                }
            });
            dUO.setCancelable(true);
            dUO.setCanceledOnTouchOutside(false);
            dUO.setMessage(tbPageContext.getPageActivity().getString(e.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(dUO, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private l dUS;
        private TbPageContext dUT;

        private a() {
            this.dUS = null;
            this.dUT = null;
        }

        public void c(l lVar, TbPageContext tbPageContext) {
            this.dUS = lVar;
            this.dUT = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.dUO != null) {
                j.dUO.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.dUO != null) {
                com.baidu.adp.lib.g.g.b(j.dUO, this.dUT);
            }
            this.dUT.showToast(e.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.dUO != null) {
                com.baidu.adp.lib.g.g.b(j.dUO, this.dUT);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dUT != null) {
                this.dUT.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.nd().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.dUO != null) {
                com.baidu.adp.lib.g.g.b(j.dUO, this.dUT);
            }
            if (i == 0) {
                j.b(this.dUS, this.dUT);
            } else {
                this.dUT.showToast(this.dUT.getString(e.j.install_failed) + str);
            }
            PluginPackageManager.nd().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void d(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            l azS = frsFragment.azS();
            FrsModelController azw = frsFragment.azw();
            if (azS != null) {
                if (azw != null || azS.beT() == null) {
                    int i2 = 0;
                    if (azS.getUserData() != null) {
                        i2 = azS.getUserData().getIsMem();
                    }
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsFragment.getPageContext().getPageActivity(), i, azS.beT().getId(), frsFragment.getForumName(), null, null, 0, azS.xs(), 13003, false, false, null, false, false, null, null, azS.beT().getPrefixData(), i2);
                    if (y.aBk().lF(1) != null) {
                        writeActivityConfig.setCategroyId(azw.aFc());
                    }
                    ForumData beT = azS.beT();
                    writeActivityConfig.setForumDir(beT.getFirst_class(), beT.getSecond_class());
                    frsFragment.sendMessage(new CustomMessage(2002001, writeActivityConfig));
                }
            }
        }
    }

    public static void aFI() {
        dUP = null;
        dUO = null;
        PluginPackageManager.nd().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
