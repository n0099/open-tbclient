package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.DailyClassicalActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.TailManagementActivityConfig;
import com.baidu.tbadk.core.atomData.TopThemeListActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.n;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class q {
    public static boolean d(TbPageContext tbPageContext, String str) {
        if (str != null && str.toLowerCase().startsWith("tieba://focusforum")) {
            TbadkCoreApplication.m411getInst().setLikeBarChanged(true);
            return true;
        }
        return false;
    }

    public static boolean e(TbPageContext tbPageContext, String str) {
        String lowerCase;
        int i;
        if (str == null) {
            return false;
        }
        try {
            lowerCase = str.toLowerCase();
            if (lowerCase != null && lowerCase.startsWith("tel:") && tbPageContext != null) {
                UtilHelper.callPhone(tbPageContext.getPageActivity(), lowerCase.substring(4));
            }
            if (lowerCase != null && lowerCase.startsWith("sms:") && tbPageContext != null) {
                String substring = lowerCase.substring(4);
                String str2 = "";
                if (lowerCase.contains("body=")) {
                    str2 = an(lowerCase, "body=");
                    substring = substring.substring(0, substring.indexOf("?") - 1);
                }
                UtilHelper.smsTo(tbPageContext.getPageActivity(), substring, str2);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (lowerCase != null && lowerCase.contains("jump=outer") && tbPageContext != null) {
            com.baidu.tbadk.browser.f.D(tbPageContext.getPageActivity(), lowerCase);
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
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), an(lowerCase, "userid="), an(lowerCase, "un="))));
                    return true;
                } else if (lowerCase.contains("jump_chat=1")) {
                    String an = an(lowerCase, "userid=");
                    String an2 = an(lowerCase, "username=");
                    String an3 = an(lowerCase, "portrait=");
                    if (an != null && an.length() > 0) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(tbPageContext.getPageActivity(), Long.parseLong(an), an2, an3, 0)));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.IM_MESSAGE_CENTER_ACTIVITY_START));
                    }
                    return true;
                } else if (lowerCase.contains("jump_official_chat=1")) {
                    String an4 = an(lowerCase, "barid=");
                    String an5 = an(lowerCase, "barname=");
                    String an6 = an(lowerCase, "portrait=");
                    if (an4 != null && an4.length() > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(tbPageContext.getPageActivity(), com.baidu.adp.lib.h.b.c(an4, 0L), an5, an6, 0)));
                    }
                    return true;
                } else if (lowerCase.contains("kz=")) {
                    String an7 = an(lowerCase, "kz=");
                    if (an7 != null && an7.length() >= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(an7, null, "allthread")));
                    }
                    return true;
                } else if (lowerCase.contains("kw=")) {
                    String an8 = an(lowerCase, "kw=");
                    if (an8 != null && an8.length() >= 0 && tbPageContext != null) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(an8, "allthread")));
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
                        UtilHelper.showToast(tbPageContext.getPageActivity(), n.i.buy_sucess);
                        ((Activity) tbPageContext).finish();
                    }
                    if (lowerCase.contains("jump_tail_edit=1") && tbPageContext != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TailManagementActivityConfig(tbPageContext.getPageActivity())));
                        return true;
                    } else if (lowerCase.contains("jumpstartgame=1")) {
                        String an9 = an(lowerCase, "gameid=");
                        String an10 = an(lowerCase, "packagename=");
                        String an11 = an(lowerCase, "launcheractivity=");
                        if (!TextUtils.isEmpty(an9) && !TextUtils.isEmpty(an10) && !TextUtils.isEmpty(an11)) {
                            if (UtilHelper.isInstallApk(tbPageContext.getPageActivity(), an10) && UtilHelper.startApk(tbPageContext.getPageActivity(), an10, an11)) {
                                ((Activity) tbPageContext).finish();
                                return true;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(tbPageContext.getPageActivity(), an9)));
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
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_TDOU_PAY_BUNDING_PHONE, an(lowerCase, "bindid=")));
                        tbPageContext.getPageActivity().finish();
                        return true;
                    } else if (lowerCase.contains("gamecenter=1")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(tbPageContext.getPageActivity())));
                        ((Activity) tbPageContext).finish();
                        return true;
                    } else {
                        Bundle gf = gf(lowerCase);
                        if (gf != null) {
                            if ("/payWithNative".equalsIgnoreCase(gf.getString("path")) || !StringUtils.isNull(gf.getString(MemberPayActivityConfig.FROM_SCENE))) {
                                AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                                int vipStatus = (currentAccountInfo == null || currentAccountInfo.getVipInfo() == null) ? 0 : currentAccountInfo.getVipInfo().getVipStatus();
                                String string = gf.getString("fromtype");
                                if (!StringUtils.isNull(string)) {
                                    if (string.equals("c10061")) {
                                        i = 6;
                                    } else if (string.equals("c10383")) {
                                        i = 7;
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), vipStatus, false, i, com.baidu.adp.lib.h.b.g(gf.getString(MemberPayActivityConfig.FROM_SCENE), 0))));
                                    return true;
                                }
                                i = 0;
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig((Context) tbPageContext.getPageActivity(), vipStatus, false, i, com.baidu.adp.lib.h.b.g(gf.getString(MemberPayActivityConfig.FROM_SCENE), 0))));
                                return true;
                            } else if ("/buyTBeans".equalsIgnoreCase(gf.getString("path"))) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(tbPageContext.getPageActivity(), 0L)));
                                return true;
                            } else if ("/changeYinjiSuccess".equalsIgnoreCase(gf.getString("path"))) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_YINJIN_CHANGE));
                                return true;
                            }
                        }
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
            } else if (lowerCase.contains("onekeysign:")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new SignAllForumActivityConfig(tbPageContext.getPageActivity())));
                ((Activity) tbPageContext).finish();
                return true;
            } else if (lowerCase.contains("dressupcenter:")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DressupCenterActivityConfig(tbPageContext.getPageActivity())));
                ((Activity) tbPageContext).finish();
                return true;
            } else if (lowerCase.contains("themeskin:")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopThemeListActivityConfig(tbPageContext.getPageActivity())));
                ((Activity) tbPageContext).finish();
                return true;
            } else if (lowerCase.contains("postbubble:")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(tbPageContext.getPageActivity())));
                ((Activity) tbPageContext).finish();
                return true;
            } else {
                if (lowerCase.contains("personalbg:")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(tbPageContext.getPageActivity())));
                    ((Activity) tbPageContext).finish();
                    return true;
                }
                return false;
            }
        }
    }

    public static boolean a(TbPageContextSupport tbPageContextSupport, String str) {
        return e(tbPageContextSupport == null ? null : tbPageContextSupport.getPageContext(), str);
    }

    public static String an(String str, String str2) {
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

    public static Bundle gf(String str) {
        URL url;
        String query;
        String[] split;
        if (StringUtils.isNull(str)) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            url = new URL(str);
            query = url.getQuery();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if ((StringUtils.isNull(query) && StringUtils.isNull(url.getPath())) || (split = query.split("&")) == null) {
            return null;
        }
        bundle.putString("path", url.getPath());
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2 != null && split2.length == 2 && !StringUtils.isNull(split2[0])) {
                bundle.putString(split2[0], split2[1]);
            }
        }
        return bundle;
    }

    /* loaded from: classes.dex */
    public static class a {
        public String BDUSS;
        public String aAM;

        public a(String str, String str2) {
            this.BDUSS = "";
            this.aAM = "";
            this.BDUSS = str;
            this.aAM = str2;
        }

        public int hashCode() {
            return (((this.BDUSS == null ? 0 : this.BDUSS.hashCode()) + 31) * 31) + (this.aAM != null ? this.aAM.hashCode() : 0);
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
                return this.aAM == null ? aVar.aAM == null : this.aAM.equals(aVar.aAM);
            }
            return false;
        }
    }
}
