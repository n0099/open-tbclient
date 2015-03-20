package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.TiebaIMConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String afJ;
    private List<String> afK;
    private c afL;
    private boolean afM;

    public static a xl() {
        a aVar;
        aVar = e.afQ;
        return aVar;
    }

    private a() {
        this.afJ = null;
        this.afK = null;
        this.afL = null;
        this.afM = false;
        this.afM = false;
        this.afK = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(a aVar) {
        this();
    }

    public int xm() {
        return com.baidu.tbadk.core.sharedPref.b.rB().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String xn() {
        int xm = xm();
        if (xm >= 10) {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.rB().putString("KeyOfSharedPrefValidIp", "");
            this.afJ = null;
            return null;
        }
        if (this.afJ == null) {
            this.afJ = com.baidu.tbadk.core.sharedPref.b.rB().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.m.isEmpty(this.afJ)) {
            com.baidu.tbadk.core.sharedPref.b.rB().putInt("KeyOfSharedPrefImCount", xm + 1);
        } else {
            this.afJ = null;
        }
        return this.afJ;
    }

    public void dP(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.afJ = str;
            com.baidu.tbadk.core.sharedPref.b.rB().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> xo() {
        if (this.afK == null) {
            this.afK = dQ(com.baidu.tbadk.core.sharedPref.b.rB().getString("KeyOfSharedPrefIpList", null));
        }
        return this.afK;
    }

    public void xp() {
        this.afM = false;
    }

    public boolean xq() {
        return this.afM;
    }

    public void a(b bVar) {
        if (this.afL == null) {
            this.afM = true;
            this.afL = new c(this, bVar);
            this.afL.setSelfExecute(true);
            this.afL.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> dQ(String str) {
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
