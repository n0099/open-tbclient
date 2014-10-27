package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.TiebaIMConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String Pl;
    private List<String> Pm;
    private c Pn;
    private boolean Po;

    public static a qo() {
        a aVar;
        aVar = e.Ps;
        return aVar;
    }

    private a() {
        this.Pl = null;
        this.Pm = null;
        this.Pn = null;
        this.Po = false;
        this.Po = false;
        this.Pm = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(a aVar) {
        this();
    }

    public int qp() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String qq() {
        int qp = qp();
        if (qp >= 10) {
            com.baidu.tbadk.core.sharedPref.b.lk().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.lk().putString("KeyOfSharedPrefValidIp", "");
            this.Pl = null;
            return null;
        }
        if (this.Pl == null) {
            this.Pl = com.baidu.tbadk.core.sharedPref.b.lk().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.l.aA(this.Pl)) {
            com.baidu.tbadk.core.sharedPref.b.lk().putInt("KeyOfSharedPrefImCount", qp + 1);
        } else {
            this.Pl = null;
        }
        return this.Pl;
    }

    public void cO(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.Pl = str;
            com.baidu.tbadk.core.sharedPref.b.lk().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> qr() {
        if (this.Pm == null) {
            this.Pm = cP(com.baidu.tbadk.core.sharedPref.b.lk().getString("KeyOfSharedPrefIpList", null));
        }
        return this.Pm;
    }

    public void qs() {
        this.Po = false;
    }

    public boolean qt() {
        return this.Po;
    }

    public void a(b bVar) {
        if (this.Pn == null) {
            this.Po = true;
            this.Pn = new c(this, bVar);
            this.Pn.setSelfExecute(true);
            this.Pn.execute(new Object[0]);
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
