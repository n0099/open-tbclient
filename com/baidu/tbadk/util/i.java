package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
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
import com.baidu.tieba.y;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class i {
    public static boolean r(Context context, String str) {
        if (str != null) {
            try {
                if (str.contains("jump=outer")) {
                    com.baidu.tbadk.browser.a.k(context, str);
                    return true;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (str != null && str.contains("jump=finish_this_page") && (context instanceof BaseActivity)) {
            ((BaseActivity) context).finish();
            return true;
        }
        if (str != null && str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE)) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2010021, new DailyClassicalActivityConfig(context)));
                return true;
            } else if (str.contains("jump_personalCenter=1") && str.contains("userid=") && str.contains("un=")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, Z(str, "userid="), Z(str, "un="))));
                return true;
            } else if (str.contains("jump_chat=1")) {
                String Z = Z(str, "userid=");
                String Z2 = Z(str, "username=");
                String Z3 = Z(str, "portrait=");
                if (Z != null && Z.length() > 0) {
                    try {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(context, Long.parseLong(Z), Z2, Z3, 0)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2008012));
                }
                return true;
            } else if (str.contains("jump_official_chat=1")) {
                String Z4 = Z(str, "barid=");
                String Z5 = Z(str, "barname=");
                String Z6 = Z(str, "portrait=");
                if (Z4 != null && Z4.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(context, com.baidu.adp.lib.g.c.a(Z4, 0L), Z5, Z6, 0)));
                }
                return true;
            } else if (str.contains("kz=")) {
                String Z7 = Z(str, "kz=");
                if (Z7 != null && Z7.length() >= 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(Z7, null, "allthread")));
                }
                return true;
            } else if (str.contains("kw=")) {
                String Z8 = Z(str, "kw=");
                if (Z8 != null && Z8.length() >= 0) {
                    if (context instanceof BaseActivity) {
                        ((BaseActivity) context).sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg(Z8, "allthread")));
                    } else if (context instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) context).sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg(Z8, "allthread")));
                    }
                }
                return true;
            } else if (str.contains("jumptologin=1") && (context instanceof Activity)) {
                LoginActivity.a((Activity) context, "", true, 0);
                return true;
            } else if (str.contains("jumptobubble_list") && (context instanceof Activity)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleChooseActivityConfig(context)));
                return true;
            } else {
                if (str.contains("pay=1") && (context instanceof Activity)) {
                    UtilHelper.showToast(context, y.buy_sucess);
                    ((Activity) context).finish();
                }
                if (str.contains("jumpstartgame=1")) {
                    String Z9 = Z(str, "gameId=");
                    String Z10 = Z(str, "packageName=");
                    String Z11 = Z(str, "launcherActivity=");
                    if (!TextUtils.isEmpty(Z9) && !TextUtils.isEmpty(Z10) && !TextUtils.isEmpty(Z11)) {
                        if (UtilHelper.isInstallApk(context, Z10) && UtilHelper.startApk(context, Z10, Z11)) {
                            ((Activity) context).finish();
                            return true;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(context, Z9)));
                    }
                    ((Activity) context).finish();
                    return true;
                }
            }
        }
        return false;
    }

    public static String Z(String str, String str2) {
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
