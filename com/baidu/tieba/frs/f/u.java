package com.baidu.tieba.frs.f;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private static com.baidu.tbadk.core.dialog.e cao = null;
    private static a cap = null;

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        TiebaStatic.log(new as("c11839").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext != null && nVar != null && nVar.aJw() != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (nVar != null && nVar.rb() != null) {
                    nVar.rb().setIfpost(1);
                }
                bg.aI(tbPageContext.getPageActivity());
                return;
            }
            AntiData rb = nVar.rb();
            if (rb != null && (AntiHelper.f(rb) || AntiHelper.g(rb) || AntiHelper.h(rb))) {
                rb.setBlock_forum_name(nVar.aJw().getName());
                rb.setBlock_forum_id(nVar.aJw().getId());
                rb.setUser_name(nVar.getUserData().getUserName());
                rb.setUser_id(nVar.getUserData().getUserId());
                if (AntiHelper.a(tbPageContext.getPageActivity(), rb, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (nVar.getUserData() != null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, new AlaLiveRoomActivityConfig((Context) tbPageContext.getPageActivity(), nVar.aJw().getName(), nVar.aJw().getId(), nVar.getUserData().getUserId(), true)));
            }
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        if (bg.aK(tbPageContext.getPageActivity()) && nVar != null && nVar.aJw() != null && tbPageContext != null) {
            AntiData rb = nVar.rb();
            if (rb != null) {
                if (AntiHelper.f(rb) || AntiHelper.g(rb) || AntiHelper.h(rb)) {
                    rb.setBlock_forum_name(nVar.aJw().getName());
                    rb.setBlock_forum_id(nVar.aJw().getId());
                    rb.setUser_name(nVar.getUserData().getUserName());
                    rb.setUser_id(nVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), rb, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(rb.getPollMessage())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), rb.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (nVar.aJw() != null) {
                postPrefixData = nVar.aJw().getPrefixData();
            }
            int i = 0;
            if (nVar.getUserData() != null) {
                i = nVar.getUserData().getIsMem();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(tbPageContext.getPageActivity(), nVar.aJw().getId(), nVar.aJw().getName(), rb, 13003, postPrefixData, i)));
        }
    }

    public static void c(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String str;
        String str2;
        String string;
        TiebaStatic.log("c10798");
        if (bg.aK(tbPageContext.getPageActivity()) && nVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(w.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(w.l.setup));
                    return;
                }
                AntiData rb = nVar.rb();
                if (rb != null && !StringUtils.isNull(rb.getVideo_message())) {
                    com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), rb.getVideo_message());
                    return;
                }
                boolean z = false;
                if (nVar != null && nVar.getUserData() != null && nVar.getUserData().getGodUserData() != null && (nVar.getUserData().getGodUserData().getType() == 2 || nVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (nVar != null && nVar.aJw() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, nVar.aJw().getId(), nVar.aJw().getName());
                }
            } else if (!com.baidu.adp.lib.util.i.hj()) {
                tbPageContext.showToast(w.l.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
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
                aVar.cE(str);
                aVar.a(str2, new v(tbPageContext, nVar, pluginConfig));
                aVar.b(w.l.cancel, new w());
                aVar.b(tbPageContext).tQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(TbPageContext tbPageContext) {
        if (cao == null) {
            cao = new com.baidu.tbadk.core.dialog.e(tbPageContext.getPageActivity());
            cao.setOnCancelListener(new x());
            cao.setCancelable(true);
            cao.setCanceledOnTouchOutside(false);
            cao.setMessage(tbPageContext.getPageActivity().getString(w.l.plugin_video_downloading));
        }
        com.baidu.adp.lib.g.j.a(cao, tbPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.e {
        private com.baidu.tieba.tbadkCore.n cat;
        private TbPageContext cau;

        private a() {
            this.cat = null;
            this.cau = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(a aVar) {
            this();
        }

        public void d(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext) {
            this.cat = nVar;
            this.cau = tbPageContext;
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && u.cao != null) {
                u.cao.ch((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (u.cao != null) {
                com.baidu.adp.lib.g.j.b(u.cao, this.cau);
            }
            this.cau.showToast(w.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (u.cao != null) {
                com.baidu.adp.lib.g.j.b(u.cao, this.cau);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cau != null) {
                this.cau.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (u.cao != null) {
                com.baidu.adp.lib.g.j.b(u.cao, this.cau);
            }
            if (i == 0) {
                u.c(this.cat, this.cau);
            } else {
                this.cau.showToast(String.valueOf(this.cau.getString(w.l.install_failed)) + str);
            }
            PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController) {
        if (bg.aK(tbPageContext.getPageActivity()) && nVar != null && tbPageContext != null) {
            boolean z = false;
            String str = "";
            if (nVar.aJw() != null && nVar.aJw().getAnchorPower() != null) {
                z = nVar.aJw().getCanAddPhotoLivePost();
                str = nVar.aJw().getAnchorPower().can_add_live_post_msg;
            }
            if (z) {
                a(nVar, tbPageContext, frsModelController, 4);
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
                return;
            }
            d(tbPageContext, str);
        }
    }

    public static void d(TbPageContext tbPageContext, String str) {
        if (tbPageContext != null) {
            JSONObject jSONObject = null;
            if (!StringUtils.isNull(str)) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    if (jSONArray.length() > 0) {
                        jSONObject = jSONArray.optJSONObject(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (jSONObject != null) {
                String optString = jSONObject.optString(AddFriendActivityConfig.MSG);
                if (!StringUtils.isNull(optString)) {
                    String optString2 = jSONObject.optString("tid");
                    if (!StringUtils.isNull(optString) && optString.contains("_")) {
                        optString = optString.replace("_", "");
                    }
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                    aVar.cE(optString);
                    aVar.a(w.l.view, new y(optString2, tbPageContext));
                    aVar.b(w.l.cancel, new z());
                    aVar.b(tbPageContext).tQ();
                }
            }
        }
    }

    public static void b(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (nVar != null && nVar.rb() != null) {
                    nVar.rb().setIfpost(1);
                }
                bg.aI(tbPageContext.getPageActivity());
            } else if (nVar != null) {
                a(nVar, tbPageContext, frsModelController, 0);
            }
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.n nVar, TbPageContext tbPageContext, FrsModelController frsModelController, int i) {
        if (nVar != null && nVar.aJw() != null && tbPageContext != null && frsModelController != null) {
            int i2 = 0;
            if (nVar.getUserData() != null) {
                i2 = nVar.getUserData().getIsMem();
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), i, nVar.aJw().getId(), nVar.aJw().getName(), null, null, 0, nVar.rb(), 13003, false, false, null, false, false, null, null, nVar.aJw().getPrefixData(), i2);
            if (bw.aaB().hU(1) != null) {
                writeActivityConfig.setCategroyId(frsModelController.acJ());
            }
            writeActivityConfig.addHotTopicInfo(nVar.aJw().getPostTopicData());
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public static void b(FrsActivity frsActivity, int i) {
        if (frsActivity != null) {
            com.baidu.tieba.tbadkCore.n Zr = frsActivity.Zr();
            FrsModelController YT = frsActivity.YT();
            if (Zr != null && YT != null) {
                int i2 = 0;
                if (Zr.getUserData() != null) {
                    i2 = Zr.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(frsActivity.getPageContext().getPageActivity(), i, Zr.aJw().getId(), frsActivity.getForumName(), null, null, 0, Zr.rb(), 13003, false, false, null, false, false, null, null, Zr.aJw().getPrefixData(), i2);
                if (bw.aaB().hU(1) != null) {
                    writeActivityConfig.setCategroyId(YT.acJ());
                }
                frsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    public static void adv() {
        cap = null;
        cao = null;
        PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
    }
}
