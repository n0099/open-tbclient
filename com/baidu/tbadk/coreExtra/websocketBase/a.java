package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.TiebaIMConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String afR;
    private List<String> afS;
    private c afT;
    private boolean afU;

    public static a xr() {
        a aVar;
        aVar = e.afY;
        return aVar;
    }

    private a() {
        this.afR = null;
        this.afS = null;
        this.afT = null;
        this.afU = false;
        this.afU = false;
        this.afS = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(a aVar) {
        this();
    }

    public int xs() {
        return com.baidu.tbadk.core.sharedPref.b.rB().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String xt() {
        int xs = xs();
        if (xs >= 10) {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.rB().putString("KeyOfSharedPrefValidIp", "");
            this.afR = null;
            return null;
        }
        if (this.afR == null) {
            this.afR = com.baidu.tbadk.core.sharedPref.b.rB().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.m.isEmpty(this.afR)) {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("KeyOfSharedPrefImCount", xs + 1);
        } else {
            this.afR = null;
        }
        return this.afR;
    }

    public void dS(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.afR = str;
            com.baidu.tbadk.core.sharedPref.b.rB().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> xu() {
        if (this.afS == null) {
            this.afS = dT(com.baidu.tbadk.core.sharedPref.b.rB().getString("KeyOfSharedPrefIpList", null));
        }
        return this.afS;
    }

    public void xv() {
        this.afU = false;
    }

    public boolean xw() {
        return this.afU;
    }

    public void a(b bVar) {
        if (this.afT == null) {
            this.afU = true;
            this.afT = new c(this, bVar);
            this.afT.setSelfExecute(true);
            this.afT.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> dT(String str) {
        String[] split;
        ArrayList arrayList = null;
        if (str != null && str.length() > 0 && (split = str.split(",")) != null && split.length > 0) {
            arrayList = new ArrayList(3);
            for (String str2 : split) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }
}
