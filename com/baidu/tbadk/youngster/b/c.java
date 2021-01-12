package com.baidu.tbadk.youngster.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class c {
    public static void DO(String str) {
        AccountData currentAccountInfo;
        if (!StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            com.baidu.tbadk.core.sharedPref.b.brx().putString("key_youngster_verify", a(new com.baidu.tbadk.youngster.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }

    public static void bIL() {
        com.baidu.tbadk.core.sharedPref.b.brx().remove("key_youngster_verify");
    }

    public static boolean bIM() {
        String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bIL();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            bIL();
            return false;
        }
        com.baidu.tbadk.youngster.a.a DQ = DQ(string);
        if (DQ != null && !StringUtils.isNull(DQ.getUid()) && DQ.getUid().equals(currentAccountInfo.getID()) && !StringUtils.isNull(DQ.getPortrait()) && DQ.getPortrait().equals(currentAccountInfo.getPortrait())) {
            return true;
        }
        bIL();
        return false;
    }

    public static boolean DP(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bIL();
            return false;
        }
        com.baidu.tbadk.youngster.a.a DQ = DQ(string);
        if (DQ != null) {
            return str.equals(DQ.getPassword());
        }
        return false;
    }

    private static String a(com.baidu.tbadk.youngster.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getUid()) || StringUtils.isNull(aVar.getPortrait()) || StringUtils.isNull(aVar.getPassword())) {
            return "";
        }
        return aVar.getUid() + "," + aVar.getPortrait() + "," + aVar.getPassword();
    }

    private static com.baidu.tbadk.youngster.a.a DQ(String str) {
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
