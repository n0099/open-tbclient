package com.baidu.tbadk.youngster.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class c {
    public static void Fa(String str) {
        AccountData currentAccountInfo;
        if (!StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putString("key_youngster_verify", a(new com.baidu.tbadk.youngster.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }

    public static void bMC() {
        com.baidu.tbadk.core.sharedPref.b.bvq().remove("key_youngster_verify");
    }

    public static boolean bMD() {
        String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bMC();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            bMC();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Fc = Fc(string);
        if (Fc != null && !StringUtils.isNull(Fc.getUid()) && Fc.getUid().equals(currentAccountInfo.getID()) && !StringUtils.isNull(Fc.getPortrait()) && Fc.getPortrait().equals(currentAccountInfo.getPortrait())) {
            return true;
        }
        bMC();
        return false;
    }

    public static boolean Fb(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bMC();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Fc = Fc(string);
        if (Fc != null) {
            return str.equals(Fc.getPassword());
        }
        return false;
    }

    private static String a(com.baidu.tbadk.youngster.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getUid()) || StringUtils.isNull(aVar.getPortrait()) || StringUtils.isNull(aVar.getPassword())) {
            return "";
        }
        return aVar.getUid() + "," + aVar.getPortrait() + "," + aVar.getPassword();
    }

    private static com.baidu.tbadk.youngster.a.a Fc(String str) {
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
