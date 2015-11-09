package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.atomData.TailManagementActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.i;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class p {
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
            com.baidu.tbadk.browser.g.D(tbPageContext.getPageActivity(), lowerCase);
            return true;
        } else if (lowerCase != null && lowerCase.contains("jump=finish_this_page") && tbPageContext != null && tbPageContext.getPageActivity() != null) {
            tbPageContext.getPageActivity().finish();
            return true;
        } else {
            if (lowerCase != null && lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && tbPageContext != null) {
                if (lowerCase.contains("jumptoapp_browser=classic_everyday")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_DAILY_CLASSICLA, new DailyClassicalActivityConfig(tbPageContext.getPageActivity())));
                    return true;
                } else if (lowerCase.contains("jump_personalCenter=1") && lowerCase.contains("userid=") && lowerCase.contains("un=")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), am(lowerCase, "userid="), am(lowerCase, "un="))));
                    return true;
                } else if (lowerCase.contains("jump_chat=1")) {
                    String am = am(lowerCase, "userid=");
                    String am2 = am(lowerCase, "username=");
                    String am3 = am(lowerCase, "portrait=");
                    if (am != null && am.length() > 0) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(am), am2, am3, 0)));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.IM_MESSAGE_CENTER_ACTIVITY_START));
                    }
                    return true;
                } else if (lowerCase.contains("jump_official_chat=1")) {
                    String am4 = am(lowerCase, "barid=");
                    String am5 = am(lowerCase, "barname=");
                    String am6 = am(lowerCase, "portrait=");
                    if (am4 != null && am4.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.g.b.c(am4, 0L), am5, am6, 0)));
                    }
                    return true;
                } else if (lowerCase.contains("kz=")) {
                    String am7 = am(lowerCase, "kz=");
                    if (am7 != null && am7.length() >= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(am7, null, "allthread")));
                    }
                    return true;
                } else if (lowerCase.contains("kw=")) {
                    String am8 = am(lowerCase, "kw=");
                    if (am8 != null && am8.length() >= 0 && tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(am8, "allthread")));
                    }
                    return true;
                } else if (lowerCase.contains("jumptologin=1") && (tbPageContext instanceof Activity)) {
                    TbadkCoreApplication.m411getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) ((Activity) tbPageContext), "", true, 0)));
                    return true;
                } else if (lowerCase.contains("jumptobubble_list") && (tbPageContext instanceof Activity)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleChooseActivityConfig(tbPageContext.getPageActivity())));
                    return true;
                } else {
                    if (lowerCase.contains("pay=1") && (tbPageContext instanceof Activity)) {
                        UtilHelper.showToast(tbPageContext.getPageActivity(), i.h.buy_sucess);
                        ((Activity) tbPageContext).finish();
                    }
                    if (lowerCase.contains("jump_tail_edit=1") && tbPageContext != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailManagementActivityConfig(tbPageContext.getPageActivity())));
                        return true;
                    } else if (lowerCase.contains("jumpstartgame=1")) {
                        String am9 = am(lowerCase, "gameId=");
                        String am10 = am(lowerCase, "packageName=");
                        String am11 = am(lowerCase, "launcherActivity=");
                        if (!TextUtils.isEmpty(am9) && !TextUtils.isEmpty(am10) && !TextUtils.isEmpty(am11)) {
                            if (UtilHelper.isInstallApk(tbPageContext.getPageActivity(), am10) && UtilHelper.startApk(tbPageContext.getPageActivity(), am10, am11)) {
                                ((Activity) tbPageContext).finish();
                                return true;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(tbPageContext.getPageActivity(), am9)));
                        }
                        ((Activity) tbPageContext).finish();
                        return true;
                    } else if (lowerCase.contains("jump_enter_forum=1")) {
                        com.baidu.tbadk.core.c.b.a(tbPageContext.getPageActivity(), 1, true);
                        return true;
                    } else if (lowerCase.contains("jump_chosen_post=1")) {
                        com.baidu.tbadk.core.c.b.a(tbPageContext.getPageActivity(), 2, true);
                        return true;
                    } else if (lowerCase.contains("bunding_phone=1")) {
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_TDOU_PAY_BUNDING_PHONE, am(lowerCase, "bindid=")));
                        tbPageContext.getPageActivity().finish();
                        return true;
                    }
                }
            }
            if (lowerCase.startsWith("baiduxiuba://")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(lowerCase));
                intent.setFlags(268435456);
                tbPageContext.getPageActivity().startActivity(intent);
                return true;
            }
            return false;
        }
    }

    public static boolean a(TbPageContextSupport tbPageContextSupport, String str) {
        return c(tbPageContextSupport == null ? null : tbPageContextSupport.getPageContext(), str);
    }

    public static String am(String str, String str2) {
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

    /* loaded from: classes.dex */
    public static class a {
        public String BDUSS;
        public String ayG;

        public a(String str, String str2) {
            this.BDUSS = "";
            this.ayG = "";
            this.BDUSS = str;
            this.ayG = str2;
        }

        public int hashCode() {
            return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.ayG != null ? this.ayG.hashCode() : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                if (this.BDUSS == null) {
                    if (aVar.BDUSS != null) {
                        return false;
                    }
                } else if (!this.BDUSS.equals(aVar.BDUSS)) {
                    return false;
                }
                return this.ayG == null ? aVar.ayG == null : this.ayG.equals(aVar.ayG);
            }
            return false;
        }
    }
}
