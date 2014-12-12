package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.TiebaIMConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String Vb;
    private List<String> Vc;
    private c Vd;
    private boolean Ve;

    public static a tJ() {
        a aVar;
        aVar = e.Vi;
        return aVar;
    }

    private a() {
        this.Vb = null;
        this.Vc = null;
        this.Vd = null;
        this.Ve = false;
        this.Ve = false;
        this.Vc = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(a aVar) {
        this();
    }

    public int tK() {
        return com.baidu.tbadk.core.sharedPref.b.og().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String tL() {
        int tK = tK();
        if (tK >= 10) {
            com.baidu.tbadk.core.sharedPref.b.og().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.og().putString("KeyOfSharedPrefValidIp", "");
            this.Vb = null;
            return null;
        }
        if (this.Vb == null) {
            this.Vb = com.baidu.tbadk.core.sharedPref.b.og().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.k.isEmpty(this.Vb)) {
            com.baidu.tbadk.core.sharedPref.b.og().putInt("KeyOfSharedPrefImCount", tK + 1);
        } else {
            this.Vb = null;
        }
        return this.Vb;
    }

    public void dK(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.Vb = str;
            com.baidu.tbadk.core.sharedPref.b.og().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> tM() {
        if (this.Vc == null) {
            this.Vc = dL(com.baidu.tbadk.core.sharedPref.b.og().getString("KeyOfSharedPrefIpList", null));
        }
        return this.Vc;
    }

    public void tN() {
        this.Ve = false;
    }

    public boolean tO() {
        return this.Ve;
    }

    public void a(b bVar) {
        if (this.Vd == null) {
            this.Ve = true;
            this.Vd = new c(this, bVar);
            this.Vd.setSelfExecute(true);
            this.Vd.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> dL(String str) {
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
