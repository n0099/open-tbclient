package com.baidu.tieba.ala.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.ac;
/* loaded from: classes2.dex */
public class l {
    private static volatile l eBi;
    private ac aaG;
    private SparseArray<String> eBj = new SparseArray<>();
    private SparseArray<String> eBk = new SparseArray<>();
    private SparseArray<String> eBl = new SparseArray<>();
    private SparseArray<String> eBm = new SparseArray<>();

    private l() {
    }

    public static l bcE() {
        if (eBi == null) {
            synchronized (l.class) {
                if (eBi == null) {
                    eBi = new l();
                }
            }
        }
        return eBi;
    }

    public String bcF() {
        if (bcH() || this.aaG.ZT == null) {
            return null;
        }
        return this.aaG.ZT;
    }

    public String pb(int i) {
        String str = this.eBj.get(i);
        if (TextUtils.isEmpty(str)) {
            if (bcH() || this.aaG.ZX == null) {
                return null;
            }
            String optString = this.aaG.ZX.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.eBj.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String pc(int i) {
        String str = this.eBk.get(i);
        if (TextUtils.isEmpty(str)) {
            if (bcH() || this.aaG.ZV == null) {
                return null;
            }
            String optString = this.aaG.ZV.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.eBk.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String pd(int i) {
        String str = this.eBl.get(i);
        if (TextUtils.isEmpty(str)) {
            if (bcH() || this.aaG.ZW == null) {
                return null;
            }
            String optString = this.aaG.ZW.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.eBl.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String pe(int i) {
        String str = this.eBm.get(i);
        if (TextUtils.isEmpty(str)) {
            if (bcH() || this.aaG.ZY == null) {
                return null;
            }
            String optString = this.aaG.ZY.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.eBm.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public ac bcG() {
        if (bcH()) {
            return null;
        }
        return this.aaG;
    }

    private boolean bcH() {
        if (this.aaG == null) {
            this.aaG = com.baidu.live.r.a.wA().asy.aaG;
            if (this.aaG == null) {
                return true;
            }
        }
        return false;
    }
}
