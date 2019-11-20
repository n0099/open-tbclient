package com.baidu.tieba.ala.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.z;
/* loaded from: classes6.dex */
public class m {
    private static volatile m dNa;
    private z TJ;
    private SparseArray<String> dNb = new SparseArray<>();
    private SparseArray<String> dNc = new SparseArray<>();
    private SparseArray<String> dNd = new SparseArray<>();
    private SparseArray<String> dNe = new SparseArray<>();

    private m() {
    }

    public static m aLv() {
        if (dNa == null) {
            synchronized (m.class) {
                if (dNa == null) {
                    dNa = new m();
                }
            }
        }
        return dNa;
    }

    public String aLw() {
        if (aLy() || this.TJ.Td == null) {
            return null;
        }
        return this.TJ.Td;
    }

    public String mL(int i) {
        String str = this.dNb.get(i);
        if (TextUtils.isEmpty(str)) {
            if (aLy() || this.TJ.Th == null) {
                return null;
            }
            String optString = this.TJ.Th.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.dNb.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String mM(int i) {
        String str = this.dNc.get(i);
        if (TextUtils.isEmpty(str)) {
            if (aLy() || this.TJ.Tf == null) {
                return null;
            }
            String optString = this.TJ.Tf.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.dNc.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String mN(int i) {
        String str = this.dNd.get(i);
        if (TextUtils.isEmpty(str)) {
            if (aLy() || this.TJ.Tg == null) {
                return null;
            }
            String optString = this.TJ.Tg.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.dNd.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String mO(int i) {
        String str = this.dNe.get(i);
        if (TextUtils.isEmpty(str)) {
            if (aLy() || this.TJ.Ti == null) {
                return null;
            }
            String optString = this.TJ.Ti.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.dNe.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public z aLx() {
        if (aLy()) {
            return null;
        }
        return this.TJ;
    }

    private boolean aLy() {
        if (this.TJ == null) {
            this.TJ = com.baidu.live.l.a.uB().aku.TJ;
            if (this.TJ == null) {
                return true;
            }
        }
        return false;
    }
}
