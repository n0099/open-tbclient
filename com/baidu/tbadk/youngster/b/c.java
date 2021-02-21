package com.baidu.tbadk.youngster.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class c {
    public static void Ej(String str) {
        AccountData currentAccountInfo;
        if (!StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_youngster_verify", a(new com.baidu.tbadk.youngster.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }

    public static void bJe() {
        com.baidu.tbadk.core.sharedPref.b.brQ().remove("key_youngster_verify");
    }

    public static boolean bJf() {
        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bJe();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            bJe();
            return false;
        }
        com.baidu.tbadk.youngster.a.a El = El(string);
        if (El != null && !StringUtils.isNull(El.getUid()) && El.getUid().equals(currentAccountInfo.getID()) && !StringUtils.isNull(El.getPortrait()) && El.getPortrait().equals(currentAccountInfo.getPortrait())) {
            return true;
        }
        bJe();
        return false;
    }

    public static boolean Ek(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bJe();
            return false;
        }
        com.baidu.tbadk.youngster.a.a El = El(string);
        if (El != null) {
            return str.equals(El.getPassword());
        }
        return false;
    }

    private static String a(com.baidu.tbadk.youngster.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getUid()) || StringUtils.isNull(aVar.getPortrait()) || StringUtils.isNull(aVar.getPassword())) {
            return "";
        }
        return aVar.getUid() + "," + aVar.getPortrait() + "," + aVar.getPassword();
    }

    private static com.baidu.tbadk.youngster.a.a El(String str) {
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
