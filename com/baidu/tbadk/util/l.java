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
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tieba.z;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class l {
    public static boolean c(TbPageContext tbPageContext, String str) {
        if (str != null) {
            try {
                if (str.contains("jump=outer") && tbPageContext != null) {
                    com.baidu.tbadk.browser.a.A(tbPageContext.getPageActivity(), str);
                    return true;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (str != null && str.contains("jump=finish_this_page") && tbPageContext != null && tbPageContext.getPageActivity() != null) {
            tbPageContext.getPageActivity().finish();
            return true;
        }
        if (str != null && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && tbPageContext != null) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902021, new DailyClassicalActivityConfig(tbPageContext.getPageActivity())));
                return true;
            } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), ai(str, "userid="), ai(str, "un="))));
                return true;
            } else if (str.contains("jump_chat=1")) {
                String ai = ai(str, "userid=");
                String ai2 = ai(str, "username=");
                String ai3 = ai(str, "portrait=");
                if (ai != null && ai.length() > 0) {
                    try {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(ai), ai2, ai3, 0)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2008012));
                }
                return true;
            } else if (str.contains("jump_official_chat=1")) {
                String ai4 = ai(str, "barid=");
                String ai5 = ai(str, "barname=");
                String ai6 = ai(str, "portrait=");
                if (ai4 != null && ai4.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.g.c.a(ai4, 0L), ai5, ai6, 0)));
                }
                return true;
            } else if (str.contains("kz=")) {
                String ai7 = ai(str, "kz=");
                if (ai7 != null && ai7.length() >= 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(ai7, null, "allthread")));
                }
                return true;
            } else if (str.contains("kw=")) {
                String ai8 = ai(str, "kw=");
                if (ai8 != null && ai8.length() >= 0 && tbPageContext != null) {
                    tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(ai8, "allthread")));
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
                    String ai9 = ai(str, "gameId=");
                    String ai10 = ai(str, "packageName=");
                    String ai11 = ai(str, "launcherActivity=");
                    if (!TextUtils.isEmpty(ai9) && !TextUtils.isEmpty(ai10) && !TextUtils.isEmpty(ai11)) {
                        if (UtilHelper.isInstallApk(tbPageContext.getPageActivity(), ai10) && UtilHelper.startApk(tbPageContext.getPageActivity(), ai10, ai11)) {
                            ((Activity) tbPageContext).finish();
                            return true;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(tbPageContext.getPageActivity(), ai9)));
                    }
                    ((Activity) tbPageContext).finish();
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(TbPageContextSupport tbPageContextSupport, String str) {
        return c(tbPageContextSupport == null ? null : tbPageContextSupport.getPageContext(), str);
    }

    public static String ai(String str, String str2) {
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
