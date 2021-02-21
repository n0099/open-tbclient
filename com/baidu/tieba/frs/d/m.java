package com.baidu.tieba.frs.d;

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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes2.dex */
public class m {
    private static com.baidu.tbadk.core.dialog.c jJH = null;
    private static a jJI = null;

    public static void a(FrsViewData frsViewData, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new ar("c11839").dR("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && frsViewData != null && frsViewData.getForum() != null) {
            if (Build.VERSION.SDK_INT < 21) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.setAutoNight(false);
                aVar.nw(R.string.prompt);
                aVar.Au(tbPageContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.d.m.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).bqx();
            } else if (!TbadkCoreApplication.isLogin()) {
                if (frsViewData != null && frsViewData.getAnti() != null) {
                    frsViewData.getAnti().setIfpost(1);
                }
                bh.skipToLoginActivity(tbPageContext.getPageActivity());
            } else {
                AntiData anti = frsViewData.getAnti();
                if (anti != null && (AntiHelper.c(anti) || AntiHelper.d(anti) || AntiHelper.e(anti))) {
                    anti.setBlock_forum_name(frsViewData.getForum().getName());
                    anti.setBlock_forum_id(frsViewData.getForum().getId());
                    anti.setUser_name(frsViewData.getUserData().getUserName());
                    anti.setUser_id(frsViewData.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), anti, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), R.string.plugin_config_not_found);
                } else if (frsViewData.getUserData() != null) {
                    d(tbPageContext, frsViewData);
                }
            }
        }
    }

    public static void d(final TbPageContext tbPageContext, final FrsViewData frsViewData) {
        if (tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.frs.d.m.2
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    com.baidu.adp.lib.c.a.lH().getAddress(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(TbPageContext.this.getPageActivity(), frsViewData.getForum().getName(), frsViewData.getForum().getId(), frsViewData.getUserData().getUserId(), frsViewData.getForum().getSpecialForumType())));
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public static void b(final FrsViewData frsViewData, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (bh.checkUpIsLogin(tbPageContext.getPageActivity()) && frsViewData != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(R.string.plugin_video_not_active), tbPageContext.getPageActivity().getString(R.string.setup));
                    return;
                }
                AntiData anti = frsViewData.getAnti();
                if (anti != null && !StringUtils.isNull(anti.getVideo_message())) {
                    com.baidu.adp.lib.util.l.showToast(tbPageContext.getPageActivity(), anti.getVideo_message());
                    return;
                }
                boolean z = false;
                if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getUserData().getGodUserData() != null && (frsViewData.getUserData().getGodUserData().getType() == 2 || frsViewData.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, frsViewData.getForum().getId(), frsViewData.getForum().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                tbPageContext.showToast(R.string.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().pS() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.pR().pS().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(R.string.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(R.string.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    String string3 = tbPageContext.getPageActivity().getString(R.string.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(R.string.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.Au(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.d.m.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        m.s(TbPageContext.this);
                        if (m.jJI == null) {
                            a unused = m.jJI = new a();
                        }
                        m.jJI.c(frsViewData, TbPageContext.this);
                        if (PluginPackageManager.pv().cE(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.pv().a(m.jJI);
                        } else {
                            PluginPackageManager.pv().a(pluginConfig, m.jJI);
                        }
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.d.m.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).bqx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(TbPageContext tbPageContext) {
        if (jJH == null) {
            jJH = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            jJH.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.d.m.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    m.cKK();
                }
            });
            jJH.setCancelable(true);
            jJH.setCanceledOnTouchOutside(false);
            jJH.setMessage(tbPageContext.getPageActivity().getString(R.string.on_downloading));
        }
        com.baidu.adp.lib.f.g.showDialog(jJH, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private FrsViewData jJL;
        private TbPageContext jJM;

        private a() {
            this.jJL = null;
            this.jJM = null;
        }

        public void c(FrsViewData frsViewData, TbPageContext tbPageContext) {
            this.jJL = frsViewData;
            this.jJM = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && m.jJH != null) {
                m.jJH.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (m.jJH != null) {
                com.baidu.adp.lib.f.g.b(m.jJH, this.jJM);
            }
            this.jJM.showToast(R.string.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (m.jJH != null) {
                com.baidu.adp.lib.f.g.b(m.jJH, this.jJM);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.jJM != null) {
                this.jJM.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.pv().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (m.jJH != null) {
                com.baidu.adp.lib.f.g.b(m.jJH, this.jJM);
            }
            if (i == 0) {
                m.b(this.jJL, this.jJM);
            } else {
                this.jJM.showToast(this.jJM.getString(R.string.install_failed) + str);
            }
            PluginPackageManager.pv().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void g(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            FrsViewData cDg = frsFragment.cDg();
            FrsModelController cCw = frsFragment.cCw();
            if (cDg != null) {
                if ((cCw != null || cDg.getForum() == null) && !WriteActivityConfig.isAsyncWriting()) {
                    int i2 = -1;
                    if (cCw != null && ac.cEF().yX(1) != null) {
                        i2 = cCw.cJF();
                    }
                    WriteActivityConfig.newInstance(frsFragment.getPageContext().getPageActivity()).setType(i).setForumData(cDg.getForum()).setAntiData(cDg.getAnti()).setCategoryId(i2).send();
                }
            }
        }
    }

    public static void cKK() {
        jJI = null;
        jJH = null;
        PluginPackageManager.pv().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
