package com.baidu.tbadk.youngster.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class c {
    public static void Eg(String str) {
        AccountData currentAccountInfo;
        if (!StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            com.baidu.tbadk.core.sharedPref.b.blO().putString("key_youngster_verify", a(new com.baidu.tbadk.youngster.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }

    public static void bCZ() {
        com.baidu.tbadk.core.sharedPref.b.blO().remove("key_youngster_verify");
    }

    public static boolean bDa() {
        String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bCZ();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            bCZ();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Ei = Ei(string);
        if (Ei != null && !StringUtils.isNull(Ei.getUid()) && Ei.getUid().equals(currentAccountInfo.getID()) && !StringUtils.isNull(Ei.getPortrait()) && Ei.getPortrait().equals(currentAccountInfo.getPortrait())) {
            return true;
        }
        bCZ();
        return false;
    }

    public static boolean Eh(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bCZ();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Ei = Ei(string);
        if (Ei != null) {
            return str.equals(Ei.getPassword());
        }
        return false;
    }

    private static String a(com.baidu.tbadk.youngster.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getUid()) || StringUtils.isNull(aVar.getPortrait()) || StringUtils.isNull(aVar.getPassword())) {
            return "";
        }
        return aVar.getUid() + Constants.ACCEPT_TIME_SEPARATOR_SP + aVar.getPortrait() + Constants.ACCEPT_TIME_SEPARATOR_SP + aVar.getPassword();
    }

    private static com.baidu.tbadk.youngster.a.a Ei(String str) {
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
