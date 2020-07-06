package com.baidu.tieba.frs.f;

import android.content.DialogInterface;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes9.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c hYP = null;
    private static a hYQ = null;

    public static void a(FrsViewData frsViewData, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new ao("c11839").dk("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && frsViewData != null && frsViewData.getForum() != null) {
            if (Build.VERSION.SDK_INT < 21) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.setAutoNight(false);
                aVar.kS(R.string.prompt);
                aVar.we(tbPageContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.f.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).aUN();
            } else if (!TbadkCoreApplication.isLogin()) {
                if (frsViewData != null && frsViewData.getAnti() != null) {
                    frsViewData.getAnti().setIfpost(1);
                }
                be.skipToLoginActivity(tbPageContext.getPageActivity());
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
                    l.showToast(tbPageContext.getPageActivity(), (int) R.string.plugin_config_not_found);
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
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.frs.f.j.2
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    com.baidu.adp.lib.c.a.kG().getAddress(false);
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
        if (be.checkUpIsLogin(tbPageContext.getPageActivity()) && frsViewData != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(R.string.plugin_video_not_active), tbPageContext.getPageActivity().getString(R.string.setup));
                    return;
                }
                AntiData anti = frsViewData.getAnti();
                if (anti != null && !StringUtils.isNull(anti.getVideo_message())) {
                    l.showToast(tbPageContext.getPageActivity(), anti.getVideo_message());
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
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.oK().oL() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.oK().oL().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
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
                aVar.we(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.j.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.u(TbPageContext.this);
                        if (j.hYQ == null) {
                            a unused = j.hYQ = new a();
                        }
                        j.hYQ.c(frsViewData, TbPageContext.this);
                        if (PluginPackageManager.oo().cA(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.oo().a(j.hYQ);
                        } else {
                            PluginPackageManager.oo().a(pluginConfig, j.hYQ);
                        }
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.j.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).aUN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(TbPageContext tbPageContext) {
        if (hYP == null) {
            hYP = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            hYP.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.j.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.ceL();
                }
            });
            hYP.setCancelable(true);
            hYP.setCanceledOnTouchOutside(false);
            hYP.setMessage(tbPageContext.getPageActivity().getString(R.string.on_downloading));
        }
        com.baidu.adp.lib.f.g.showDialog(hYP, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private FrsViewData hYT;
        private TbPageContext hYU;

        private a() {
            this.hYT = null;
            this.hYU = null;
        }

        public void c(FrsViewData frsViewData, TbPageContext tbPageContext) {
            this.hYT = frsViewData;
            this.hYU = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.hYP != null) {
                j.hYP.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.hYP != null) {
                com.baidu.adp.lib.f.g.b(j.hYP, this.hYU);
            }
            this.hYU.showToast(R.string.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.hYP != null) {
                com.baidu.adp.lib.f.g.b(j.hYP, this.hYU);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.hYU != null) {
                this.hYU.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.oo().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.hYP != null) {
                com.baidu.adp.lib.f.g.b(j.hYP, this.hYU);
            }
            if (i == 0) {
                j.b(this.hYT, this.hYU);
            } else {
                this.hYU.showToast(this.hYU.getString(R.string.install_failed) + str);
            }
            PluginPackageManager.oo().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void g(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            FrsViewData bYC = frsFragment.bYC();
            FrsModelController bXV = frsFragment.bXV();
            if (bYC != null) {
                if (bXV != null || bYC.getForum() == null) {
                    int i2 = 0;
                    if (bYC.getUserData() != null) {
                        i2 = bYC.getUserData().getIsMem();
                    }
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsFragment.getPageContext().getPageActivity(), i, bYC.getForum().getId(), frsFragment.getForumName(), null, null, 0, bYC.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, bYC.getForum().getPrefixData(), i2);
                    if (ae.bZY().uK(1) != null) {
                        writeActivityConfig.setCategroyId(bXV.cdL());
                    }
                    ForumData forum = bYC.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    frsFragment.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            }
        }
    }

    public static void ceL() {
        hYQ = null;
        hYP = null;
        PluginPackageManager.oo().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
