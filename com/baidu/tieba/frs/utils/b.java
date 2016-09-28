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
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cz;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static void a(p pVar, TbPageContext tbPageContext) {
        if (bm.ak(tbPageContext.getPageActivity()) && pVar != null && pVar.aMr() != null && tbPageContext != null) {
            AntiData qq = pVar.qq();
            if (qq != null) {
                if (AntiHelper.e(qq) || AntiHelper.f(qq) || AntiHelper.g(qq)) {
                    qq.setBlock_forum_name(pVar.aMr().getName());
                    qq.setBlock_forum_id(pVar.aMr().getId());
                    qq.setUser_name(pVar.getUserData().getUserName());
                    qq.setUser_id(pVar.getUserData().getUserId());
                    if (AntiHelper.a(tbPageContext.getPageActivity(), qq, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(qq.getPollMessage())) {
                    k.showToast(tbPageContext.getPageActivity(), qq.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (pVar.aMr() != null) {
                postPrefixData = pVar.aMr().getPrefixData();
            }
            int i = 0;
            if (pVar.getUserData() != null) {
                i = pVar.getUserData().getIsMem();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(tbPageContext.getPageActivity(), pVar.aMr().getId(), pVar.aMr().getName(), qq, 13003, postPrefixData, i)));
        }
    }

    public static void b(p pVar, TbPageContext tbPageContext) {
        TiebaStatic.log("c10798");
        if (bm.ak(tbPageContext.getPageActivity()) && pVar != null && tbPageContext != null) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(r.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(r.j.setup));
                    return;
                }
                AntiData qq = pVar.qq();
                if (qq != null && !StringUtils.isNull(qq.getVideo_message())) {
                    k.showToast(tbPageContext.getPageActivity(), qq.getVideo_message());
                    return;
                }
                boolean z = false;
                if (pVar != null && pVar.getUserData() != null && pVar.getUserData().getGodUserData() != null && (pVar.getUserData().getGodUserData().getType() == 2 || pVar.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (pVar != null && pVar.aMr() != null) {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), z, pVar.aMr().getId(), pVar.aMr().getName());
                    return;
                }
                return;
            }
            XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(r.j.plugin_video_install_tips), tbPageContext.getPageActivity().getString(r.j.plugin_go_install));
        }
    }

    public static void a(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar) {
        if (bm.ak(tbPageContext.getPageActivity()) && pVar != null && tbPageContext != null) {
            boolean z = false;
            String str = "";
            if (pVar.aMr() != null && pVar.aMr().getAnchorPower() != null) {
                z = pVar.aMr().getCanAddPhotoLivePost();
                str = pVar.aMr().getAnchorPower().can_add_live_post_msg;
            }
            if (z) {
                a(pVar, tbPageContext, aVar, 4);
                com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
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
                    aVar.cD(optString);
                    aVar.a(r.j.view, new c(optString2, tbPageContext));
                    aVar.b(r.j.cancel, new d());
                    aVar.b(tbPageContext).tm();
                }
            }
        }
    }

    public static void b(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar) {
        if (tbPageContext != null) {
            if (!TbadkCoreApplication.isLogin()) {
                if (pVar != null && pVar.qq() != null) {
                    pVar.qq().setIfpost(1);
                }
                bm.ai(tbPageContext.getPageActivity());
            } else if (pVar != null) {
                a(pVar, tbPageContext, aVar, 0);
            }
        }
    }

    public static void O(FrsActivity frsActivity) {
        if (!TbadkCoreApplication.isLogin()) {
            bm.ai(frsActivity.getPageContext().getPageActivity());
            return;
        }
        frsActivity.jS(frsActivity.getPageContext().getResources().getString(r.j.Waiting));
        frsActivity.abl().jV(frsActivity.abe().aMr().getId());
    }

    public static void a(p pVar, TbPageContext tbPageContext, com.baidu.tieba.frs.e.a aVar, int i) {
        if (pVar != null && pVar.aMr() != null && tbPageContext != null && aVar != null) {
            int i2 = 0;
            if (pVar.getUserData() != null) {
                i2 = pVar.getUserData().getIsMem();
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(tbPageContext.getPageActivity(), i, pVar.aMr().getId(), pVar.aMr().getName(), null, null, 0, pVar.qq(), 13003, false, false, null, false, false, null, null, pVar.aMr().getPrefixData(), i2);
            if (cz.acy().hZ(1) != null) {
                writeActivityConfig.setCategroyId(aVar.aeY());
            }
            writeActivityConfig.addHotTopicInfo(pVar.aMr().getPostTopicData());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }
}
