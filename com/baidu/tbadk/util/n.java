package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.DailyClassicalActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class n {
    public static boolean c(TbPageContext tbPageContext, String str) {
        String lowerCase;
        if (str == null) {
            return false;
        }
        try {
            lowerCase = str.toLowerCase();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (lowerCase != null && lowerCase.contains("jump=outer") && tbPageContext != null) {
            com.baidu.tbadk.browser.f.z(tbPageContext.getPageActivity(), lowerCase);
            return true;
        } else if (lowerCase != null && lowerCase.contains("jump=finish_this_page") && tbPageContext != null && tbPageContext.getPageActivity() != null) {
            tbPageContext.getPageActivity().finish();
            return true;
        } else {
            if (lowerCase != null && lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && tbPageContext != null) {
                if (lowerCase.contains("jumptoapp_browser=classic_everyday")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902021, new DailyClassicalActivityConfig(tbPageContext.getPageActivity())));
                    return true;
                } else if (lowerCase.contains("jump_personalCenter=1") && lowerCase.contains("userid=") && lowerCase.contains("un=")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), ap(lowerCase, "userid="), ap(lowerCase, "un="))));
                    return true;
                } else if (lowerCase.contains("jump_chat=1")) {
                    String ap = ap(lowerCase, "userid=");
                    String ap2 = ap(lowerCase, "username=");
                    String ap3 = ap(lowerCase, "portrait=");
                    if (ap != null && ap.length() > 0) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(ap), ap2, ap3, 0)));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2008012));
                    }
                    return true;
                } else if (lowerCase.contains("jump_official_chat=1")) {
                    String ap4 = ap(lowerCase, "barid=");
                    String ap5 = ap(lowerCase, "barname=");
                    String ap6 = ap(lowerCase, "portrait=");
                    if (ap4 != null && ap4.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.g.c.c(ap4, 0L), ap5, ap6, 0)));
                    }
                    return true;
                } else if (lowerCase.contains("kz=")) {
                    String ap7 = ap(lowerCase, "kz=");
                    if (ap7 != null && ap7.length() >= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(ap7, null, "allthread")));
                    }
                    return true;
                } else if (lowerCase.contains("kw=")) {
                    String ap8 = ap(lowerCase, "kw=");
                    if (ap8 != null && ap8.length() >= 0 && tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(ap8, "allthread")));
                    }
                    return true;
                } else if (lowerCase.contains("jumptologin=1") && (tbPageContext instanceof Activity)) {
                    TbadkCoreApplication.m411getInst().login(null, new CustomMessage<>(2002001, new LoginActivityConfig((Context) ((Activity) tbPageContext), "", true, 0)));
                    return true;
                } else if (lowerCase.contains("jumptobubble_list") && (tbPageContext instanceof Activity)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleChooseActivityConfig(tbPageContext.getPageActivity())));
                    return true;
                } else {
                    if (lowerCase.contains("pay=1") && (tbPageContext instanceof Activity)) {
                        UtilHelper.showToast(tbPageContext.getPageActivity(), t.buy_sucess);
                        ((Activity) tbPageContext).finish();
                    }
                    if (lowerCase.contains("jumpstartgame=1")) {
                        String ap9 = ap(lowerCase, "gameId=");
                        String ap10 = ap(lowerCase, "packageName=");
                        String ap11 = ap(lowerCase, "launcherActivity=");
                        if (!TextUtils.isEmpty(ap9) && !TextUtils.isEmpty(ap10) && !TextUtils.isEmpty(ap11)) {
                            if (UtilHelper.isInstallApk(tbPageContext.getPageActivity(), ap10) && UtilHelper.startApk(tbPageContext.getPageActivity(), ap10, ap11)) {
                                ((Activity) tbPageContext).finish();
                                return true;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(tbPageContext.getPageActivity(), ap9)));
                        }
                        ((Activity) tbPageContext).finish();
                        return true;
                    }
                }
            }
            if (lowerCase.startsWith("baiduxiuba://")) {
                if (!UtilHelper.isInstalledPackage(tbPageContext.getPageActivity(), "com.xiu8.baidu.activity")) {
                    com.baidu.tbadk.browser.f.d(tbPageContext.getPageActivity(), "http://m.down.xiu8.com/download/apk/tiebaxiu.apk", false);
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(lowerCase));
                    intent.setFlags(268435456);
                    tbPageContext.getPageActivity().startActivity(intent);
                }
                return true;
            }
            return false;
        }
    }

    public static boolean a(TbPageContextSupport tbPageContextSupport, String str) {
        return c(tbPageContextSupport == null ? null : tbPageContextSupport.getPageContext(), str);
    }

    public static String ap(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = str2.length() + indexOf;
            int i = length;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            return URLDecoder.decode(str.substring(length, i));
        }
        return "";
    }
}
