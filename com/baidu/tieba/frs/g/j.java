package com.baidu.tieba.frs.g;

import android.content.Context;
import android.content.DialogInterface;
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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c cHh = null;
    private static a cHi = null;

    public static void a(com.baidu.tieba.tbadkCore.i iVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new ak("c11839").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && iVar != null && iVar.aMU() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (iVar != null && iVar.qa() != null) {
                    iVar.qa().setIfpost(1);
                }
                ax.aS(tbPageContext.getPageActivity());
                return;
            }
            AntiData qa = iVar.qa();
            if (qa != null && (AntiHelper.f(qa) || AntiHelper.g(qa) || AntiHelper.h(qa))) {
                qa.setBlock_forum_name(iVar.aMU().getName());
                qa.setBlock_forum_id(iVar.aMU().getId());
                qa.setUser_name(iVar.getUserData().getUserName());
                qa.setUser_id(iVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qa, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                l.showToast(tbPageContext.getPageActivity(), d.l.plugin_config_not_found);
            } else if (iVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.fc().D(false);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig((Context) tbPageContext.getPageActivity(), iVar.aMU().getName(), iVar.aMU().getId(), iVar.getUserData().getUserId(), true, iVar.aMU().isGameForumType())));
            }
        }
    }

    public static void b(final com.baidu.tieba.tbadkCore.i iVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ax.aT(tbPageContext.getPageActivity()) && iVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.l.setup));
                    return;
                }
                AntiData qa = iVar.qa();
                if (qa != null && !StringUtils.isNull(qa.getVideo_message())) {
                    l.showToast(tbPageContext.getPageActivity(), qa.getVideo_message());
                    return;
                }
                boolean z = false;
                if (iVar != null && iVar.getUserData() != null && iVar.getUserData().getGodUserData() != null && (iVar.getUserData().getGodUserData().getType() == 2 || iVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (iVar != null && iVar.aMU() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, iVar.aMU().getId(), iVar.aMU().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.j.hh()) {
                tbPageContext.showToast(d.l.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.l.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.j.hj()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.l.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cL(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.g.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.n(TbPageContext.this);
                        if (j.cHi == null) {
                            a unused = j.cHi = new a();
                        }
                        j.cHi.c(iVar, TbPageContext.this);
                        if (PluginPackageManager.jv().br(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.jv().a(j.cHi);
                        } else {
                            PluginPackageManager.jv().a(pluginConfig, j.cHi);
                        }
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.g.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).tb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(TbPageContext tbPageContext) {
        if (cHh == null) {
            cHh = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            cHh.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.g.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.alA();
                }
            });
            cHh.setCancelable(true);
            cHh.setCanceledOnTouchOutside(false);
            cHh.setMessage(tbPageContext.getPageActivity().getString(d.l.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(cHh, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private com.baidu.tieba.tbadkCore.i cHl;
        private TbPageContext cHm;

        private a() {
            this.cHl = null;
            this.cHm = null;
        }

        public void c(com.baidu.tieba.tbadkCore.i iVar, TbPageContext tbPageContext) {
            this.cHl = iVar;
            this.cHm = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.cHh != null) {
                j.cHh.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.cHh != null) {
                com.baidu.adp.lib.g.g.b(j.cHh, this.cHm);
            }
            this.cHm.showToast(d.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.cHh != null) {
                com.baidu.adp.lib.g.g.b(j.cHh, this.cHm);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cHm != null) {
                this.cHm.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jv().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.cHh != null) {
                com.baidu.adp.lib.g.g.b(j.cHh, this.cHm);
            }
            if (i == 0) {
                j.b(this.cHl, this.cHm);
            } else {
                this.cHm.showToast(this.cHm.getString(d.l.install_failed) + str);
            }
            PluginPackageManager.jv().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, int i) {
        if (fVar != null) {
            com.baidu.tieba.tbadkCore.i ahf = fVar.ahf();
            FrsModelController agK = fVar.agK();
            if (ahf != null && agK != null) {
                int i2 = 0;
                if (ahf.getUserData() != null) {
                    i2 = ahf.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(fVar.getPageContext().getPageActivity(), i, ahf.aMU().getId(), fVar.getForumName(), null, null, 0, ahf.qa(), 13003, false, false, null, false, false, null, null, ahf.aMU().getPrefixData(), i2);
                if (z.ahW().jg(1) != null) {
                    writeActivityConfig.setCategroyId(agK.akQ());
                }
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void alA() {
        cHi = null;
        cHh = null;
        PluginPackageManager.jv().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
