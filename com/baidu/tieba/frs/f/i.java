package com.baidu.tieba.frs.f;

import android.content.DialogInterface;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes2.dex */
public class i {
    private static com.baidu.tbadk.core.dialog.c dUy = null;
    private static a dUz = null;

    public static void a(m mVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new ak("c11839").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && mVar != null && mVar.bas() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (mVar != null && mVar.yn() != null) {
                    mVar.yn().setIfpost(1);
                }
                ay.aZ(tbPageContext.getPageActivity());
                return;
            }
            AntiData yn = mVar.yn();
            if (yn != null && (AntiHelper.d(yn) || AntiHelper.e(yn) || AntiHelper.f(yn))) {
                yn.setBlock_forum_name(mVar.bas().getName());
                yn.setBlock_forum_id(mVar.bas().getId());
                yn.setUser_name(mVar.getUserData().getUserName());
                yn.setUser_id(mVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), yn, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                l.showToast(tbPageContext.getPageActivity(), d.j.plugin_config_not_found);
            } else if (mVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.mG().an(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), mVar.bas().getName(), mVar.bas().getId(), mVar.getUserData().getUserId(), mVar.bas().getSpecialForumType())));
            }
        }
    }

    public static void b(final m mVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ay.ba(tbPageContext.getPageActivity()) && mVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
                    return;
                }
                AntiData yn = mVar.yn();
                if (yn != null && !StringUtils.isNull(yn.getVideo_message())) {
                    l.showToast(tbPageContext.getPageActivity(), yn.getVideo_message());
                    return;
                }
                boolean z = false;
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getGodUserData() != null && (mVar.getUserData().getGodUserData().getType() == 2 || mVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (mVar != null && mVar.bas() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, mVar.bas().getId(), mVar.bas().getName(), "");
                }
            } else if (!j.oJ()) {
                tbPageContext.showToast(d.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
                if (j.oL()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.j.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.dk(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.i.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        i.k(TbPageContext.this);
                        if (i.dUz == null) {
                            a unused = i.dUz = new a();
                        }
                        i.dUz.c(mVar, TbPageContext.this);
                        if (PluginPackageManager.qS().bz(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.qS().a(i.dUz);
                        } else {
                            PluginPackageManager.qS().a(pluginConfig, i.dUz);
                        }
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.i.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).AV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(TbPageContext tbPageContext) {
        if (dUy == null) {
            dUy = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            dUy.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.i.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    i.azV();
                }
            });
            dUy.setCancelable(true);
            dUy.setCanceledOnTouchOutside(false);
            dUy.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(dUy, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private m dUC;
        private TbPageContext dUD;

        private a() {
            this.dUC = null;
            this.dUD = null;
        }

        public void c(m mVar, TbPageContext tbPageContext) {
            this.dUC = mVar;
            this.dUD = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && i.dUy != null) {
                i.dUy.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (i.dUy != null) {
                com.baidu.adp.lib.g.g.b(i.dUy, this.dUD);
            }
            this.dUD.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (i.dUy != null) {
                com.baidu.adp.lib.g.g.b(i.dUy, this.dUD);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dUD != null) {
                this.dUD.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i.dUy != null) {
                com.baidu.adp.lib.g.g.b(i.dUy, this.dUD);
            }
            if (i == 0) {
                i.b(this.dUC, this.dUD);
            } else {
                this.dUD.showToast(this.dUD.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.i iVar, int i) {
        if (iVar != null) {
            m avl = iVar.avl();
            FrsModelController auO = iVar.auO();
            if (avl != null && auO != null) {
                int i2 = 0;
                if (avl.getUserData() != null) {
                    i2 = avl.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(iVar.getPageContext().getPageActivity(), i, avl.bas().getId(), iVar.getForumName(), null, null, 0, avl.yn(), 13003, false, false, null, false, false, null, null, avl.bas().getPrefixData(), i2);
                if (aa.awm().mX(1) != null) {
                    writeActivityConfig.setCategroyId(auO.azq());
                }
                iVar.sendMessage(new CustomMessage(2002001, writeActivityConfig));
            }
        }
    }

    public static void azV() {
        dUz = null;
        dUy = null;
        PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
