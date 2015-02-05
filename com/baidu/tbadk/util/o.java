package com.baidu.tbadk.util;

import android.app.Activity;
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
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.z;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class o {
    public static boolean c(TbPageContext tbPageContext, String str) {
        if (str == null || tbPageContext == null) {
            return false;
        }
        if (str != null) {
            try {
                if (str.contains("jump=outer") && tbPageContext != null) {
                    com.baidu.tbadk.browser.a.z(tbPageContext.getPageActivity(), str);
                    return true;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (str != null && str.contains("jump=finish_this_page") && tbPageContext != null && tbPageContext.getPageActivity() != null) {
            tbPageContext.getPageActivity().finish();
            return true;
        } else if (str.startsWith("tbdou:")) {
            bm.pO().b(tbPageContext, new String[]{str});
            return true;
        } else {
            if (str != null && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && tbPageContext != null) {
                if (str.contains("jumptoapp_browser=classic_everyday")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902021, new DailyClassicalActivityConfig(tbPageContext.getPageActivity())));
                    return true;
                } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), al(str, "userid="), al(str, "un="))));
                    return true;
                } else if (str.contains("jump_chat=1")) {
                    String al = al(str, "userid=");
                    String al2 = al(str, "username=");
                    String al3 = al(str, "portrait=");
                    if (al != null && al.length() > 0) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(al), al2, al3, 0)));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2008012));
                    }
                    return true;
                } else if (str.contains("jump_official_chat=1")) {
                    String al4 = al(str, "barid=");
                    String al5 = al(str, "barname=");
                    String al6 = al(str, "portrait=");
                    if (al4 != null && al4.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.g.c.a(al4, 0L), al5, al6, 0)));
                    }
                    return true;
                } else if (str.contains("kz=")) {
                    String al7 = al(str, "kz=");
                    if (al7 != null && al7.length() >= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(al7, null, "allthread")));
                    }
                    return true;
                } else if (str.contains("kw=")) {
                    String al8 = al(str, "kw=");
                    if (al8 != null && al8.length() >= 0 && tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(al8, "allthread")));
                    }
                    return true;
                } else if (str.contains("jumptologin=1") && (tbPageContext instanceof Activity)) {
                    LoginActivity.a((Activity) tbPageContext, "", true, 0);
                    return true;
                } else if (str.contains("jumptobubble_list") && (tbPageContext instanceof Activity)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleChooseActivityConfig(tbPageContext.getPageActivity())));
                    return true;
                } else {
                    if (str.contains("pay=1") && (tbPageContext instanceof Activity)) {
                        UtilHelper.showToast(tbPageContext.getPageActivity(), z.buy_sucess);
                        ((Activity) tbPageContext).finish();
                    }
                    if (str.contains("jumpstartgame=1")) {
                        String al9 = al(str, "gameId=");
                        String al10 = al(str, "packageName=");
                        String al11 = al(str, "launcherActivity=");
                        if (!TextUtils.isEmpty(al9) && !TextUtils.isEmpty(al10) && !TextUtils.isEmpty(al11)) {
                            if (UtilHelper.isInstallApk(tbPageContext.getPageActivity(), al10) && UtilHelper.startApk(tbPageContext.getPageActivity(), al10, al11)) {
                                ((Activity) tbPageContext).finish();
                                return true;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(tbPageContext.getPageActivity(), al9)));
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

    public static String al(String str, String str2) {
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
