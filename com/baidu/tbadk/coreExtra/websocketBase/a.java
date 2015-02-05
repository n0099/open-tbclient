package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.TiebaIMConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String VD;
    private List<String> VE;
    private c VF;
    private boolean VG;

    public static a tU() {
        a aVar;
        aVar = e.VK;
        return aVar;
    }

    private a() {
        this.VD = null;
        this.VE = null;
        this.VF = null;
        this.VG = false;
        this.VG = false;
        this.VE = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(a aVar) {
        this();
    }

    public int tV() {
        return com.baidu.tbadk.core.sharedPref.b.oc().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String tW() {
        int tV = tV();
        if (tV >= 10) {
            com.baidu.tbadk.core.sharedPref.b.oc().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.oc().putString("KeyOfSharedPrefValidIp", "");
            this.VD = null;
            return null;
        }
        if (this.VD == null) {
            this.VD = com.baidu.tbadk.core.sharedPref.b.oc().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.k.isEmpty(this.VD)) {
            com.baidu.tbadk.core.sharedPref.b.oc().putInt("KeyOfSharedPrefImCount", tV + 1);
        } else {
            this.VD = null;
        }
        return this.VD;
    }

    public void dG(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.VD = str;
            com.baidu.tbadk.core.sharedPref.b.oc().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> tX() {
        if (this.VE == null) {
            this.VE = dH(com.baidu.tbadk.core.sharedPref.b.oc().getString("KeyOfSharedPrefIpList", null));
        }
        return this.VE;
    }

    public void tY() {
        this.VG = false;
    }

    public boolean tZ() {
        return this.VG;
    }

    public void a(b bVar) {
        if (this.VF == null) {
            this.VG = true;
            this.VF = new c(this, bVar);
            this.VF.setSelfExecute(true);
            this.VF.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> dH(String str) {
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
