package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
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
import com.baidu.tieba.y;
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), ak(lowerCase, "userid="), ak(lowerCase, "un="))));
                    return true;
                } else if (lowerCase.contains("jump_chat=1")) {
                    String ak = ak(lowerCase, "userid=");
                    String ak2 = ak(lowerCase, "username=");
                    String ak3 = ak(lowerCase, "portrait=");
                    if (ak != null && ak.length() > 0) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(ak), ak2, ak3, 0)));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2008012));
                    }
                    return true;
                } else if (lowerCase.contains("jump_official_chat=1")) {
                    String ak4 = ak(lowerCase, "barid=");
                    String ak5 = ak(lowerCase, "barname=");
                    String ak6 = ak(lowerCase, "portrait=");
                    if (ak4 != null && ak4.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.g.c.a(ak4, 0L), ak5, ak6, 0)));
                    }
                    return true;
                } else if (lowerCase.contains("kz=")) {
                    String ak7 = ak(lowerCase, "kz=");
                    if (ak7 != null && ak7.length() >= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(ak7, null, "allthread")));
                    }
                    return true;
                } else if (lowerCase.contains("kw=")) {
                    String ak8 = ak(lowerCase, "kw=");
                    if (ak8 != null && ak8.length() >= 0 && tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(ak8, "allthread")));
                    }
                    return true;
                } else if (lowerCase.contains("jumptologin=1") && (tbPageContext instanceof Activity)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) ((Activity) tbPageContext), "", true, 0)));
                    return true;
                } else if (lowerCase.contains("jumptobubble_list") && (tbPageContext instanceof Activity)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleChooseActivityConfig(tbPageContext.getPageActivity())));
                    return true;
                } else {
                    if (lowerCase.contains("pay=1") && (tbPageContext instanceof Activity)) {
                        UtilHelper.showToast(tbPageContext.getPageActivity(), y.buy_sucess);
                        ((Activity) tbPageContext).finish();
                    }
                    if (lowerCase.contains("jumpstartgame=1")) {
                        String ak9 = ak(lowerCase, "gameId=");
                        String ak10 = ak(lowerCase, "packageName=");
                        String ak11 = ak(lowerCase, "launcherActivity=");
                        if (!TextUtils.isEmpty(ak9) && !TextUtils.isEmpty(ak10) && !TextUtils.isEmpty(ak11)) {
                            if (UtilHelper.isInstallApk(tbPageContext.getPageActivity(), ak10) && UtilHelper.startApk(tbPageContext.getPageActivity(), ak10, ak11)) {
                                ((Activity) tbPageContext).finish();
                                return true;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(tbPageContext.getPageActivity(), ak9)));
                        }
                        ((Activity) tbPageContext).finish();
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean a(TbPageContextSupport tbPageContextSupport, String str) {
        return c(tbPageContextSupport == null ? null : tbPageContextSupport.getPageContext(), str);
    }

    public static String ak(String str, String str2) {
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
