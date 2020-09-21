package com.baidu.tbadk.youngster.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class b {
    public static void Dv(String str) {
        AccountData currentAccountInfo;
        if (!StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_youngster_verify", a(new com.baidu.tbadk.youngster.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }

    public static void bAn() {
        com.baidu.tbadk.core.sharedPref.b.bjf().remove("key_youngster_verify");
    }

    public static boolean bAo() {
        String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bAn();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            bAn();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Dx = Dx(string);
        if (Dx != null && !StringUtils.isNull(Dx.getUid()) && Dx.getUid().equals(currentAccountInfo.getID()) && !StringUtils.isNull(Dx.getPortrait()) && Dx.getPortrait().equals(currentAccountInfo.getPortrait())) {
            return true;
        }
        bAn();
        return false;
    }

    public static boolean Dw(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bAn();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Dx = Dx(string);
        if (Dx != null) {
            return str.equals(Dx.getPassword());
        }
        return false;
    }

    private static String a(com.baidu.tbadk.youngster.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getUid()) || StringUtils.isNull(aVar.getPortrait()) || StringUtils.isNull(aVar.getPassword())) {
            return "";
        }
        return aVar.getUid() + Constants.ACCEPT_TIME_SEPARATOR_SP + aVar.getPortrait() + Constants.ACCEPT_TIME_SEPARATOR_SP + aVar.getPassword();
    }

    private static com.baidu.tbadk.youngster.a.a Dx(String str) {
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
