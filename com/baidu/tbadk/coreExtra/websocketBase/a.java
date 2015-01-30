package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.TiebaIMConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String VG;
    private List<String> VH;
    private c VI;
    private boolean VJ;

    public static a ua() {
        a aVar;
        aVar = e.VN;
        return aVar;
    }

    private a() {
        this.VG = null;
        this.VH = null;
        this.VI = null;
        this.VJ = false;
        this.VJ = false;
        this.VH = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(a aVar) {
        this();
    }

    public int ub() {
        return com.baidu.tbadk.core.sharedPref.b.oj().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String uc() {
        int ub = ub();
        if (ub >= 10) {
            com.baidu.tbadk.core.sharedPref.b.oj().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.oj().putString("KeyOfSharedPrefValidIp", "");
            this.VG = null;
            return null;
        }
        if (this.VG == null) {
            this.VG = com.baidu.tbadk.core.sharedPref.b.oj().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.k.isEmpty(this.VG)) {
            com.baidu.tbadk.core.sharedPref.b.oj().putInt("KeyOfSharedPrefImCount", ub + 1);
        } else {
            this.VG = null;
        }
        return this.VG;
    }

    public void dJ(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.VG = str;
            com.baidu.tbadk.core.sharedPref.b.oj().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> ud() {
        if (this.VH == null) {
            this.VH = dK(com.baidu.tbadk.core.sharedPref.b.oj().getString("KeyOfSharedPrefIpList", null));
        }
        return this.VH;
    }

    public void ue() {
        this.VJ = false;
    }

    public boolean uf() {
        return this.VJ;
    }

    public void a(b bVar) {
        if (this.VI == null) {
            this.VJ = true;
            this.VI = new c(this, bVar);
            this.VI.setSelfExecute(true);
            this.VI.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> dK(String str) {
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
