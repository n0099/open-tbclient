package com.baidu.tbadk.youngster.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class c {
    public static void Eo(String str) {
        AccountData currentAccountInfo;
        if (!StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putString("key_youngster_verify", a(new com.baidu.tbadk.youngster.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }

    public static void bGK() {
        com.baidu.tbadk.core.sharedPref.b.bpu().remove("key_youngster_verify");
    }

    public static boolean bGL() {
        String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bGK();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            bGK();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Eq = Eq(string);
        if (Eq != null && !StringUtils.isNull(Eq.getUid()) && Eq.getUid().equals(currentAccountInfo.getID()) && !StringUtils.isNull(Eq.getPortrait()) && Eq.getPortrait().equals(currentAccountInfo.getPortrait())) {
            return true;
        }
        bGK();
        return false;
    }

    public static boolean Ep(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bGK();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Eq = Eq(string);
        if (Eq != null) {
            return str.equals(Eq.getPassword());
        }
        return false;
    }

    private static String a(com.baidu.tbadk.youngster.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getUid()) || StringUtils.isNull(aVar.getPortrait()) || StringUtils.isNull(aVar.getPassword())) {
            return "";
        }
        return aVar.getUid() + Constants.ACCEPT_TIME_SEPARATOR_SP + aVar.getPortrait() + Constants.ACCEPT_TIME_SEPARATOR_SP + aVar.getPassword();
    }

    private static com.baidu.tbadk.youngster.a.a Eq(String str) {
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
