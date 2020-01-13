package com.baidu.tieba.ala.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.ag;
/* loaded from: classes2.dex */
public class l {
    private static volatile l eCt;
    private ag aaT;
    private SparseArray<String> eCu = new SparseArray<>();
    private SparseArray<String> eCv = new SparseArray<>();
    private SparseArray<String> eCw = new SparseArray<>();
    private SparseArray<String> eCx = new SparseArray<>();

    private l() {
    }

    public static l bcZ() {
        if (eCt == null) {
            synchronized (l.class) {
                if (eCt == null) {
                    eCt = new l();
                }
            }
        }
        return eCt;
    }

    public String bda() {
        if (bdc() || this.aaT.aah == null) {
            return null;
        }
        return this.aaT.aah;
    }

    public String pc(int i) {
        String str = this.eCu.get(i);
        if (TextUtils.isEmpty(str)) {
            if (bdc() || this.aaT.aal == null) {
                return null;
            }
            String optString = this.aaT.aal.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.eCu.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String pd(int i) {
        String str = this.eCv.get(i);
        if (TextUtils.isEmpty(str)) {
            if (bdc() || this.aaT.aaj == null) {
                return null;
            }
            String optString = this.aaT.aaj.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.eCv.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String pe(int i) {
        String str = this.eCw.get(i);
        if (TextUtils.isEmpty(str)) {
            if (bdc() || this.aaT.aak == null) {
                return null;
            }
            String optString = this.aaT.aak.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.eCw.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String pf(int i) {
        String str = this.eCx.get(i);
        if (TextUtils.isEmpty(str)) {
            if (bdc() || this.aaT.aam == null) {
                return null;
            }
            String optString = this.aaT.aam.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.eCx.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public ag bdb() {
        if (bdc()) {
            return null;
        }
        return this.aaT;
    }

    private boolean bdc() {
        if (this.aaT == null) {
            this.aaT = com.baidu.live.s.a.wR().atk.aaT;
            if (this.aaT == null) {
                return true;
            }
        }
        return false;
    }
}
