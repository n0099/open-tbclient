package com.baidu.tbadk.youngster.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class c {
    public static void Eq(String str) {
        AccountData currentAccountInfo;
        if (!StringUtils.isNull(str) && (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) != null) {
            com.baidu.tbadk.core.sharedPref.b.brR().putString("key_youngster_verify", a(new com.baidu.tbadk.youngster.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
        }
    }

    public static void bJi() {
        com.baidu.tbadk.core.sharedPref.b.brR().remove("key_youngster_verify");
    }

    public static boolean bJj() {
        String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bJi();
            return false;
        }
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null) {
            bJi();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Es = Es(string);
        if (Es != null && !StringUtils.isNull(Es.getUid()) && Es.getUid().equals(currentAccountInfo.getID()) && !StringUtils.isNull(Es.getPortrait()) && Es.getPortrait().equals(currentAccountInfo.getPortrait())) {
            return true;
        }
        bJi();
        return false;
    }

    public static boolean Er(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("key_youngster_verify", "");
        if (StringUtils.isNull(string)) {
            bJi();
            return false;
        }
        com.baidu.tbadk.youngster.a.a Es = Es(string);
        if (Es != null) {
            return str.equals(Es.getPassword());
        }
        return false;
    }

    private static String a(com.baidu.tbadk.youngster.a.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getUid()) || StringUtils.isNull(aVar.getPortrait()) || StringUtils.isNull(aVar.getPassword())) {
            return "";
        }
        return aVar.getUid() + "," + aVar.getPortrait() + "," + aVar.getPassword();
    }

    private static com.baidu.tbadk.youngster.a.a Es(String str) {
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
