package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.tbadk.TiebaIMConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private String agS;
    private List<String> agT;
    private c agU;
    private boolean agV;

    public static a ye() {
        a aVar;
        aVar = e.agZ;
        return aVar;
    }

    private a() {
        this.agS = null;
        this.agT = null;
        this.agU = null;
        this.agV = false;
        this.agV = false;
        this.agT = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(a aVar) {
        this();
    }

    public int yf() {
        return com.baidu.tbadk.core.sharedPref.b.sl().getInt("KeyOfSharedPrefImCount", 0);
    }

    public String yg() {
        int yf = yf();
        if (yf >= 10) {
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("KeyOfSharedPrefImCount", 0);
            com.baidu.tbadk.core.sharedPref.b.sl().putString("KeyOfSharedPrefValidIp", "");
            this.agS = null;
            return null;
        }
        if (this.agS == null) {
            this.agS = com.baidu.tbadk.core.sharedPref.b.sl().getString("KeyOfSharedPrefValidIp", null);
        }
        if (!com.baidu.adp.lib.util.m.isEmpty(this.agS)) {
            com.baidu.tbadk.core.sharedPref.b.sl().putInt("KeyOfSharedPrefImCount", yf + 1);
        } else {
            this.agS = null;
        }
        return this.agS;
    }

    public void ej(String str) {
        if (!TiebaIMConfig.defaultUrl.equals(str)) {
            this.agS = str;
            com.baidu.tbadk.core.sharedPref.b.sl().putString("KeyOfSharedPrefValidIp", str);
        }
    }

    public List<String> yh() {
        if (this.agT == null) {
            this.agT = ek(com.baidu.tbadk.core.sharedPref.b.sl().getString("KeyOfSharedPrefIpList", null));
        }
        return this.agT;
    }

    public void yi() {
        this.agV = false;
    }

    public boolean yj() {
        return this.agV;
    }

    public void a(b bVar) {
        if (this.agU == null) {
            this.agV = true;
            this.agU = new c(this, bVar);
            this.agU.setSelfExecute(true);
            this.agU.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> ek(String str) {
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
