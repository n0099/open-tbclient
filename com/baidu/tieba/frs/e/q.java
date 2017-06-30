package com.baidu.tieba.frs.e;

import android.content.Context;
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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class q {
    private static com.baidu.tbadk.core.dialog.e coV = null;
    private static a coW = null;

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new au("c11839").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && nVar != null && nVar.aMt() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (nVar != null && nVar.qe() != null) {
                    nVar.qe().setIfpost(1);
                }
                bl.aM(tbPageContext.getPageActivity());
                return;
            }
            AntiData qe = nVar.qe();
            if (qe != null && (AntiHelper.f(qe) || AntiHelper.g(qe) || AntiHelper.h(qe))) {
                qe.setBlock_forum_name(nVar.aMt().getName());
                qe.setBlock_forum_id(nVar.aMt().getId());
                qe.setUser_name(nVar.getUserData().getUserName());
                qe.setUser_id(nVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), qe, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), w.l.plugin_config_not_found);
            } else if (nVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig((Context) tbPageContext.getPageActivity(), nVar.aMt().getName(), nVar.aMt().getId(), nVar.getUserData().getUserId(), true, nVar.aMt().isGameForumType())));
            }
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        String string;
        TiebaStatic.log("c10798");
        if (bl.aN(tbPageContext.getPageActivity()) && nVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(w.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(w.l.setup));
                    return;
                }
                AntiData qe = nVar.qe();
                if (qe != null && !StringUtils.isNull(qe.getVideo_message())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), qe.getVideo_message());
                    return;
                }
                boolean z = false;
                if (nVar != null && nVar.getUserData() != null && nVar.getUserData().getGodUserData() != null && (nVar.getUserData().getGodUserData().getType() == 2 || nVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (nVar != null && nVar.aMt() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, nVar.aMt().getId(), nVar.aMt().getName(), "");
                }
            } else if (!com.baidu.adp.lib.util.i.hj()) {
                tbPageContext.showToast(w.l.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string2 = tbPageContext.getPageActivity().getString(w.l.plugin_imme_install);
                String string3 = tbPageContext.getPageActivity().getString(w.l.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.i.hl()) {
                    str = f > 0.0f ? String.valueOf(string) + "（" + f + "MB）" : tbPageContext.getPageActivity().getString(w.l.plugin_video_install_tips_mobile);
                    str2 = tbPageContext.getPageActivity().getString(w.l.install_app);
                } else {
                    str = string3;
                    str2 = string2;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cI(str);
                aVar.a(str2, new r(tbPageContext, nVar, pluginConfig));
                aVar.b(w.l.cancel, new s());
                aVar.b(tbPageContext).ta();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(TbPageContext tbPageContext) {
        if (coV == null) {
            coV = new com.baidu.tbadk.core.dialog.e(tbPageContext.getPageActivity());
            coV.setOnCancelListener(new t());
            coV.setCancelable(true);
            coV.setCanceledOnTouchOutside(false);
            coV.setMessage(tbPageContext.getPageActivity().getString(w.l.plugin_video_downloading));
        }
        com.baidu.adp.lib.g.j.a(coV, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.e {
        private com.baidu.tieba.tbadkCore.n coZ;
        private TbPageContext cpa;

        private a() {
            this.coZ = null;
            this.cpa = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(a aVar) {
            this();
        }

        public void c(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
            this.coZ = nVar;
            this.cpa = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && q.coV != null) {
                q.coV.cg((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (q.coV != null) {
                com.baidu.adp.lib.g.j.b(q.coV, this.cpa);
            }
            this.cpa.showToast(w.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (q.coV != null) {
                com.baidu.adp.lib.g.j.b(q.coV, this.cpa);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cpa != null) {
                this.cpa.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.e) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (q.coV != null) {
                com.baidu.adp.lib.g.j.b(q.coV, this.cpa);
            }
            if (i == 0) {
                q.b(this.coZ, this.cpa);
            } else {
                this.cpa.showToast(String.valueOf(this.cpa.getString(w.l.install_failed)) + str);
            }
            PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.e) null);
        }
    }

    public static void b(com.baidu.tieba.frs.r rVar, int i) {
        if (rVar != null) {
            com.baidu.tieba.tbadkCore.n aek = rVar.aek();
            FrsModelController adP = rVar.adP();
            if (aek != null && adP != null) {
                int i2 = 0;
                if (aek.getUserData() != null) {
                    i2 = aek.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(rVar.getPageContext().getPageActivity(), i, aek.aMt().getId(), rVar.getForumName(), null, null, 0, aek.qe(), 13003, false, false, null, false, false, null, null, aek.aMt().getPrefixData(), i2);
                if (br.aeU().iA(1) != null) {
                    writeActivityConfig.setCategroyId(adP.agL());
                }
                rVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void ahv() {
        coW = null;
        coV = null;
        PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
