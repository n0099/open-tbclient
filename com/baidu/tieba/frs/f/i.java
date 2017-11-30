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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
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
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class i {
    private static com.baidu.tbadk.core.dialog.c cZO = null;
    private static a cZP = null;

    public static void a(k kVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new ak("c11839").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && kVar != null && kVar.aRf() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (kVar != null && kVar.qi() != null) {
                    kVar.qi().setIfpost(1);
                }
                ax.aU(tbPageContext.getPageActivity());
                return;
            }
            AntiData qi = kVar.qi();
            if (qi != null && (AntiHelper.d(qi) || AntiHelper.e(qi) || AntiHelper.f(qi))) {
                qi.setBlock_forum_name(kVar.aRf().getName());
                qi.setBlock_forum_id(kVar.aRf().getId());
                qi.setUser_name(kVar.getUserData().getUserName());
                qi.setUser_id(kVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qi, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                l.showToast(tbPageContext.getPageActivity(), d.j.plugin_config_not_found);
            } else if (kVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.fc().D(false);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(tbPageContext.getPageActivity(), kVar.aRf().getName(), kVar.aRf().getId(), kVar.getUserData().getUserId(), kVar.aRf().isGameForumType())));
            }
        }
    }

    public static void b(final k kVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ax.aV(tbPageContext.getPageActivity()) && kVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
                    return;
                }
                AntiData qi = kVar.qi();
                if (qi != null && !StringUtils.isNull(qi.getVideo_message())) {
                    l.showToast(tbPageContext.getPageActivity(), qi.getVideo_message());
                    return;
                }
                boolean z = false;
                if (kVar != null && kVar.getUserData() != null && kVar.getUserData().getGodUserData() != null && (kVar.getUserData().getGodUserData().getType() == 2 || kVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (kVar != null && kVar.aRf() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, kVar.aRf().getId(), kVar.aRf().getName(), "");
                }
            } else if (!j.hh()) {
                tbPageContext.showToast(d.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
                if (j.hj()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.j.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cS(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.f.i.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        i.m(TbPageContext.this);
                        if (i.cZP == null) {
                            a unused = i.cZP = new a();
                        }
                        i.cZP.c(kVar, TbPageContext.this);
                        if (PluginPackageManager.js().br(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.js().a(i.cZP);
                        } else {
                            PluginPackageManager.js().a(pluginConfig, i.cZP);
                        }
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.i.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).tk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(TbPageContext tbPageContext) {
        if (cZO == null) {
            cZO = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            cZO.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.f.i.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    i.aqu();
                }
            });
            cZO.setCancelable(true);
            cZO.setCanceledOnTouchOutside(false);
            cZO.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(cZO, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private k cZS;
        private TbPageContext cZT;

        private a() {
            this.cZS = null;
            this.cZT = null;
        }

        public void c(k kVar, TbPageContext tbPageContext) {
            this.cZS = kVar;
            this.cZT = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && i.cZO != null) {
                i.cZO.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (i.cZO != null) {
                com.baidu.adp.lib.g.g.b(i.cZO, this.cZT);
            }
            this.cZT.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (i.cZO != null) {
                com.baidu.adp.lib.g.g.b(i.cZO, this.cZT);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cZT != null) {
                this.cZT.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i.cZO != null) {
                com.baidu.adp.lib.g.g.b(i.cZO, this.cZT);
            }
            if (i == 0) {
                i.b(this.cZS, this.cZT);
            } else {
                this.cZT.showToast(this.cZT.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, int i) {
        if (fVar != null) {
            k alv = fVar.alv();
            FrsModelController akZ = fVar.akZ();
            if (alv != null && akZ != null) {
                int i2 = 0;
                if (alv.getUserData() != null) {
                    i2 = alv.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(fVar.getPageContext().getPageActivity(), i, alv.aRf().getId(), fVar.getForumName(), null, null, 0, alv.qi(), 13003, false, false, null, false, false, null, null, alv.aRf().getPrefixData(), i2);
                if (z.amo().jT(1) != null) {
                    writeActivityConfig.setCategroyId(akZ.apK());
                }
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void aqu() {
        cZP = null;
        cZO = null;
        PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
