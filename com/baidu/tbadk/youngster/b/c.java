package com.baidu.tbadk.youngster.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class c {
    public static void EN(String str) {
        AccountData currentAccountInfo;
        if (!StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_youngster_verify", a(new com.baidu.tbadk.youngster.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }

    public static void bHr() {
        com.baidu.tbadk.core.sharedPref.b.bqh().remove("key_youngster_verify");
    }

    public static boolean bHs() {
        String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bHr();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            bHr();
            return false;
        }
        com.baidu.tbadk.youngster.a.a EP = EP(string);
        if (EP != null && !StringUtils.isNull(EP.getUid()) && EP.getUid().equals(currentAccountInfo.getID()) && !StringUtils.isNull(EP.getPortrait()) && EP.getPortrait().equals(currentAccountInfo.getPortrait())) {
            return true;
        }
        bHr();
        return false;
    }

    public static boolean EO(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bHr();
            return false;
        }
        com.baidu.tbadk.youngster.a.a EP = EP(string);
        if (EP != null) {
            return str.equals(EP.getPassword());
        }
        return false;
    }

    private static String a(com.baidu.tbadk.youngster.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getUid()) || StringUtils.isNull(aVar.getPortrait()) || StringUtils.isNull(aVar.getPassword())) {
            return "";
        }
        return aVar.getUid() + Constants.ACCEPT_TIME_SEPARATOR_SP + aVar.getPortrait() + Constants.ACCEPT_TIME_SEPARATOR_SP + aVar.getPassword();
    }

    private static com.baidu.tbadk.youngster.a.a EP(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length > 2) {
            return new com.baidu.tbadk.youngster.a.a(split[0], split[1], split[2]);
        }
        return null;
    }
}
