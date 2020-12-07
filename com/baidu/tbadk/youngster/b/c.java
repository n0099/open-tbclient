package com.baidu.tbadk.youngster.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class c {
    public static void Fc(String str) {
        AccountData currentAccountInfo;
        if (!StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putString("key_youngster_verify", a(new com.baidu.tbadk.youngster.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }

    public static void bKk() {
        com.baidu.tbadk.core.sharedPref.b.bsO().remove("key_youngster_verify");
    }

    public static boolean bKl() {
        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bKk();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            bKk();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Fe = Fe(string);
        if (Fe != null && !StringUtils.isNull(Fe.getUid()) && Fe.getUid().equals(currentAccountInfo.getID()) && !StringUtils.isNull(Fe.getPortrait()) && Fe.getPortrait().equals(currentAccountInfo.getPortrait())) {
            return true;
        }
        bKk();
        return false;
    }

    public static boolean Fd(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bKk();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Fe = Fe(string);
        if (Fe != null) {
            return str.equals(Fe.getPassword());
        }
        return false;
    }

    private static String a(com.baidu.tbadk.youngster.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getUid()) || StringUtils.isNull(aVar.getPortrait()) || StringUtils.isNull(aVar.getPassword())) {
            return "";
        }
        return aVar.getUid() + "," + aVar.getPortrait() + "," + aVar.getPassword();
    }

    private static com.baidu.tbadk.youngster.a.a Fe(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length > 2) {
            return new com.baidu.tbadk.youngster.a.a(split[0], split[1], split[2]);
        }
        return null;
    }
}
