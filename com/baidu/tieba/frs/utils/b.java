package com.baidu.tieba.frs.utils;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.en;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.o;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static void a(o oVar, TbPageContext tbPageContext) {
        if (bl.ac(tbPageContext.getPageActivity()) && oVar != null && oVar.avA() != null && tbPageContext != null) {
            AntiData pz = oVar.pz();
            if (pz != null) {
                if (AntiHelper.e(pz) || AntiHelper.f(pz) || AntiHelper.g(pz)) {
                    pz.setBlock_forum_name(oVar.avA().getName());
                    pz.setBlock_forum_id(oVar.avA().getId());
                    pz.setUser_name(oVar.getUserData().getUserName());
                    pz.setUser_id(oVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), pz, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(pz.getPollMessage())) {
                    k.showToast(tbPageContext.getPageActivity(), pz.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (oVar.avA() != null) {
                postPrefixData = oVar.avA().getPrefixData();
            }
            int i = 0;
            if (oVar.getUserData() != null) {
                i = oVar.getUserData().getIsMem();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(tbPageContext.getPageActivity(), oVar.avA().getId(), oVar.avA().getName(), pz, 13003, postPrefixData, i)));
        }
    }

    public static void b(o oVar, TbPageContext tbPageContext) {
        TiebaStatic.log("c10798");
        if (bl.ac(tbPageContext.getPageActivity()) && oVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(t.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(t.j.setup));
                    return;
                }
                AntiData pz = oVar.pz();
                if (pz != null && !StringUtils.isNull(pz.getVideo_message())) {
                    k.showToast(tbPageContext.getPageActivity(), pz.getVideo_message());
                    return;
                }
                boolean z = false;
                if (oVar != null && oVar.getUserData() != null && oVar.getUserData().getGodUserData() != null && (oVar.getUserData().getGodUserData().getType() == 2 || oVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (oVar != null && oVar.avA() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, oVar.avA().getId(), oVar.avA().getName());
                    return;
                }
                return;
            }
            XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(t.j.plugin_video_install_tips), tbPageContext.getPageActivity().getString(t.j.plugin_go_install));
        }
    }

    public static void a(o oVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar) {
        if (bl.ac(tbPageContext.getPageActivity()) && oVar != null && tbPageContext != null) {
            boolean z = false;
            String str = "";
            if (oVar.avA() != null && oVar.avA().getAnchorPower() != null) {
                z = oVar.avA().getCanAddPhotoLivePost();
                str = oVar.avA().getAnchorPower().can_add_live_post_msg;
            }
            if (z) {
                a(oVar, tbPageContext, aVar, 4);
                com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
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
                    aVar.cA(optString);
                    aVar.a(t.j.view, new c(optString2, tbPageContext));
                    aVar.b(t.j.cancel, new d());
                    aVar.b(tbPageContext).rU();
                }
            }
        }
    }

    public static void b(o oVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (oVar != null && oVar.pz() != null) {
                    oVar.pz().setIfpost(1);
                }
                bl.aa(tbPageContext.getPageActivity());
            } else if (oVar != null) {
                a(oVar, tbPageContext, aVar, 0);
            }
        }
    }

    public static void a(o oVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar, int i) {
        if (oVar != null && oVar.avA() != null && tbPageContext != null && aVar != null) {
            int i2 = 0;
            if (oVar.getUserData() != null) {
                i2 = oVar.getUserData().getIsMem();
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), i, oVar.avA().getId(), oVar.avA().getName(), null, null, 0, oVar.pz(), 13003, false, false, null, false, false, null, null, oVar.avA().getPrefixData(), i2);
            if (en.RC().gt(1) != null) {
                writeActivityConfig.setCategroyId(aVar.Tp());
            }
            boolean Fa = com.baidu.tbadk.plugins.d.Fa();
            if (!oVar.getUserData().canPostHi()) {
                Fa = false;
            }
            writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, Fa);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    public static void c(o oVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar) {
        if (bl.ac(tbPageContext.getPageActivity()) && com.baidu.tbadk.plugins.d.f(tbPageContext) && oVar != null && oVar.avA() != null) {
            if (oVar.getUserData() != null) {
                oVar.getUserData().getIsMem();
            }
            if (en.RC().gt(1) != null) {
                aVar.Tp();
            }
            com.baidu.tbadk.plugins.d.g(tbPageContext.getPageActivity(), 12016);
        }
    }
}
