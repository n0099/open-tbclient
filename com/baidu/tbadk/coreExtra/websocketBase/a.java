package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.TiebaIMConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String Pp;
    private List<String> Pq;
    private c Pr;
    private boolean Ps;

    public static a qq() {
        a aVar;
        aVar = e.Pw;
        return aVar;
    }

    private a() {
        this.Pp = null;
        this.Pq = null;
        this.Pr = null;
        this.Ps = false;
        this.Ps = false;
        this.Pq = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(a aVar) {
        this();
    }

    public int qr() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String qs() {
        int qr = qr();
        if (qr >= 10) {
            com.baidu.tbadk.core.sharedPref.b.lk().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.lk().putString("KeyOfSharedPrefValidIp", "");
            this.Pp = null;
            return null;
        }
        if (this.Pp == null) {
            this.Pp = com.baidu.tbadk.core.sharedPref.b.lk().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.l.aA(this.Pp)) {
            com.baidu.tbadk.core.sharedPref.b.lk().putInt("KeyOfSharedPrefImCount", qr + 1);
        } else {
            this.Pp = null;
        }
        return this.Pp;
    }

    public void cO(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.Pp = str;
            com.baidu.tbadk.core.sharedPref.b.lk().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> qt() {
        if (this.Pq == null) {
            this.Pq = cP(com.baidu.tbadk.core.sharedPref.b.lk().getString("KeyOfSharedPrefIpList", null));
        }
        return this.Pq;
    }

    public void qu() {
        this.Ps = false;
    }

    public boolean qv() {
        return this.Ps;
    }

    public void a(b bVar) {
        if (this.Pr == null) {
            this.Ps = true;
            this.Pr = new c(this, bVar);
            this.Pr.setSelfExecute(true);
            this.Pr.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> cP(String str) {
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
