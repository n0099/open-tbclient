package com.baidu.tbadk.youngster.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class c {
    public static void EZ(String str) {
        AccountData currentAccountInfo;
        if (!StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            com.baidu.tbadk.core.sharedPref.b.bvr().putString("key_youngster_verify", a(new com.baidu.tbadk.youngster.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }

    public static void bMD() {
        com.baidu.tbadk.core.sharedPref.b.bvr().remove("key_youngster_verify");
    }

    public static boolean bME() {
        String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bMD();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            bMD();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Fb = Fb(string);
        if (Fb != null && !StringUtils.isNull(Fb.getUid()) && Fb.getUid().equals(currentAccountInfo.getID()) && !StringUtils.isNull(Fb.getPortrait()) && Fb.getPortrait().equals(currentAccountInfo.getPortrait())) {
            return true;
        }
        bMD();
        return false;
    }

    public static boolean Fa(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bMD();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Fb = Fb(string);
        if (Fb != null) {
            return str.equals(Fb.getPassword());
        }
        return false;
    }

    private static String a(com.baidu.tbadk.youngster.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getUid()) || StringUtils.isNull(aVar.getPortrait()) || StringUtils.isNull(aVar.getPassword())) {
            return "";
        }
        return aVar.getUid() + "," + aVar.getPortrait() + "," + aVar.getPassword();
    }

    private static com.baidu.tbadk.youngster.a.a Fb(String str) {
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
