package com.baidu.tieba.frs.g;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tieba.frs.y;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class j {
    private static com.baidu.tbadk.core.dialog.c cGA = null;
    private static a cGB = null;

    public static void a(com.baidu.tieba.tbadkCore.i iVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new ak("c11839").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && iVar != null && iVar.aPg() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (iVar != null && iVar.qn() != null) {
                    iVar.qn().setIfpost(1);
                }
                ax.aT(tbPageContext.getPageActivity());
                return;
            }
            AntiData qn = iVar.qn();
            if (qn != null && (AntiHelper.f(qn) || AntiHelper.g(qn) || AntiHelper.h(qn))) {
                qn.setBlock_forum_name(iVar.aPg().getName());
                qn.setBlock_forum_id(iVar.aPg().getId());
                qn.setUser_name(iVar.getUserData().getUserName());
                qn.setUser_id(iVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qn, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                k.showToast(tbPageContext.getPageActivity(), d.l.plugin_config_not_found);
            } else if (iVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                com.baidu.adp.lib.d.a.fd().D(false);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig((Context) tbPageContext.getPageActivity(), iVar.aPg().getName(), iVar.aPg().getId(), iVar.getUserData().getUserId(), true, iVar.aPg().isGameForumType())));
            }
        }
    }

    public static void b(final com.baidu.tieba.tbadkCore.i iVar, final TbPageContext tbPageContext) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        TiebaStatic.log("c10798");
        if (ax.aU(tbPageContext.getPageActivity()) && iVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.l.setup));
                    return;
                }
                AntiData qn = iVar.qn();
                if (qn != null && !StringUtils.isNull(qn.getVideo_message())) {
                    k.showToast(tbPageContext.getPageActivity(), qn.getVideo_message());
                    return;
                }
                boolean z = false;
                if (iVar != null && iVar.getUserData() != null && iVar.getUserData().getGodUserData() != null && (iVar.getUserData().getGodUserData().getType() == 2 || iVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (iVar != null && iVar.aPg() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, iVar.aPg().getId(), iVar.aPg().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.i.hi()) {
                tbPageContext.showToast(d.l.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.l.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.i.hk()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_mobile);
                    str = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str2 = tbPageContext.getPageActivity().getString(d.l.install_app);
                } else {
                    str = string2;
                    str2 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cM(str);
                aVar.a(str2, new a.b() { // from class: com.baidu.tieba.frs.g.j.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        j.q(TbPageContext.this);
                        if (j.cGB == null) {
                            a unused = j.cGB = new a();
                        }
                        j.cGB.c(iVar, TbPageContext.this);
                        if (PluginPackageManager.jw().br(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.jw().a(j.cGB);
                        } else {
                            PluginPackageManager.jw().a(pluginConfig, j.cGB);
                        }
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.g.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).to();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(TbPageContext tbPageContext) {
        if (cGA == null) {
            cGA = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            cGA.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.frs.g.j.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    j.alB();
                }
            });
            cGA.setCancelable(true);
            cGA.setCanceledOnTouchOutside(false);
            cGA.setMessage(tbPageContext.getPageActivity().getString(d.l.on_downloading));
        }
        com.baidu.adp.lib.g.g.a(cGA, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private com.baidu.tieba.tbadkCore.i cGE;
        private TbPageContext cGF;

        private a() {
            this.cGE = null;
            this.cGF = null;
        }

        public void c(com.baidu.tieba.tbadkCore.i iVar, TbPageContext tbPageContext) {
            this.cGE = iVar;
            this.cGF = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && j.cGA != null) {
                j.cGA.ck((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (j.cGA != null) {
                com.baidu.adp.lib.g.g.b(j.cGA, this.cGF);
            }
            this.cGF.showToast(d.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (j.cGA != null) {
                com.baidu.adp.lib.g.g.b(j.cGA, this.cGF);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cGF != null) {
                this.cGF.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (j.cGA != null) {
                com.baidu.adp.lib.g.g.b(j.cGA, this.cGF);
            }
            if (i == 0) {
                j.b(this.cGE, this.cGF);
            } else {
                this.cGF.showToast(this.cGF.getString(d.l.install_failed) + str);
            }
            PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    public static void b(com.baidu.tieba.frs.f fVar, int i) {
        if (fVar != null) {
            com.baidu.tieba.tbadkCore.i ahq = fVar.ahq();
            FrsModelController agT = fVar.agT();
            if (ahq != null && agT != null) {
                int i2 = 0;
                if (ahq.getUserData() != null) {
                    i2 = ahq.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(fVar.getPageContext().getPageActivity(), i, ahq.aPg().getId(), fVar.getForumName(), null, null, 0, ahq.qn(), 13003, false, false, null, false, false, null, null, ahq.aPg().getPrefixData(), i2);
                if (y.aid().iZ(1) != null) {
                    writeActivityConfig.setCategroyId(agT.akR());
                }
                fVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void alB() {
        cGB = null;
        cGA = null;
        PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
