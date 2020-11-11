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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes22.dex */
public class l {
    private static com.baidu.tbadk.core.dialog.c jhK = null;
    private static a jhL = null;

    public static void a(FrsViewData frsViewData, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new aq("c11839").dR("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && frsViewData != null && frsViewData.getForum() != null) {
            if (Build.VERSION.SDK_INT < 21) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.setAutoNight(false);
                aVar.ov(R.string.prompt);
                aVar.Bo(tbPageContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.a(R.string.know, new a.b() { // from class: com.baidu.tieba.frs.f.l.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).bpc();
            } else if (!TbadkCoreApplication.isLogin()) {
                if (frsViewData != null && frsViewData.getAnti() != null) {
                    frsViewData.getAnti().setIfpost(1);
                }
                bg.skipToLoginActivity(tbPageContext.getPageActivity());
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
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.frs.f.l.2
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
                    com.baidu.adp.lib.c.a.mk().getAddress(false);
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
        if (bg.checkUpIsLogin(tbPageContext.getPageActivity()) && frsViewData != null && tbPageContext != null) {
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
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qp().qq().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
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
                aVar.Bo(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.l.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        l.t(TbPageContext.this);
                        if (l.jhL == null) {
                            a unused = l.jhL = new a();
                        }
                        l.jhL.c(frsViewData, TbPageContext.this);
                        if (PluginPackageManager.pT().cG(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.pT().a(l.jhL);
                        } else {
                            PluginPackageManager.pT().a(pluginConfig, l.jhL);
                        }
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.l.4
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).bpc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(TbPageContext tbPageContext) {
        if (jhK == null) {
            jhK = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            jhK.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.l.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    l.cFl();
                }
            });
            jhK.setCancelable(true);
            jhK.setCanceledOnTouchOutside(false);
            jhK.setMessage(tbPageContext.getPageActivity().getString(R.string.on_downloading));
        }
        com.baidu.adp.lib.f.g.showDialog(jhK, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private FrsViewData jhO;
        private TbPageContext jhP;

        private a() {
            this.jhO = null;
            this.jhP = null;
        }

        public void c(FrsViewData frsViewData, TbPageContext tbPageContext) {
            this.jhO = frsViewData;
            this.jhP = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && l.jhK != null) {
                l.jhK.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (l.jhK != null) {
                com.baidu.adp.lib.f.g.b(l.jhK, this.jhP);
            }
            this.jhP.showToast(R.string.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (l.jhK != null) {
                com.baidu.adp.lib.f.g.b(l.jhK, this.jhP);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.jhP != null) {
                this.jhP.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.pT().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (l.jhK != null) {
                com.baidu.adp.lib.f.g.b(l.jhK, this.jhP);
            }
            if (i == 0) {
                l.b(this.jhO, this.jhP);
            } else {
                this.jhP.showToast(this.jhP.getString(R.string.install_failed) + str);
            }
            PluginPackageManager.pT().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void g(FrsFragment frsFragment, int i) {
        if (frsFragment != null) {
            FrsViewData cyP = frsFragment.cyP();
            FrsModelController cyg = frsFragment.cyg();
            if (cyP != null) {
                if (cyg != null || cyP.getForum() == null) {
                    int i2 = 0;
                    if (cyP.getUserData() != null) {
                        i2 = cyP.getUserData().getIsMem();
                    }
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsFragment.getPageContext().getPageActivity(), i, cyP.getForum().getId(), frsFragment.getForumName(), null, null, 0, cyP.getAnti(), RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, cyP.getForum().getPrefixData(), i2);
                    if (ag.cAo().ze(1) != null) {
                        writeActivityConfig.setCategroyId(cyg.cEk());
                    }
                    ForumData forum = cyP.getForum();
                    writeActivityConfig.setForumDir(forum.getFirst_class(), forum.getSecond_class());
                    frsFragment.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            }
        }
    }

    public static void cFl() {
        jhL = null;
        jhK = null;
        PluginPackageManager.pT().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
