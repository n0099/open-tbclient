package com.baidu.tieba.ala.guardclub;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.data.z;
/* loaded from: classes6.dex */
public class m {
    private static volatile m dNR;
    private z Ud;
    private SparseArray<String> dNS = new SparseArray<>();
    private SparseArray<String> dNT = new SparseArray<>();
    private SparseArray<String> dNU = new SparseArray<>();
    private SparseArray<String> dNV = new SparseArray<>();

    private m() {
    }

    public static m aLx() {
        if (dNR == null) {
            synchronized (m.class) {
                if (dNR == null) {
                    dNR = new m();
                }
            }
        }
        return dNR;
    }

    public String aLy() {
        if (aLA() || this.Ud.Tw == null) {
            return null;
        }
        return this.Ud.Tw;
    }

    public String mM(int i) {
        String str = this.dNS.get(i);
        if (TextUtils.isEmpty(str)) {
            if (aLA() || this.Ud.TA == null) {
                return null;
            }
            String optString = this.Ud.TA.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.dNS.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String mN(int i) {
        String str = this.dNT.get(i);
        if (TextUtils.isEmpty(str)) {
            if (aLA() || this.Ud.Ty == null) {
                return null;
            }
            String optString = this.Ud.Ty.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.dNT.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String mO(int i) {
        String str = this.dNU.get(i);
        if (TextUtils.isEmpty(str)) {
            if (aLA() || this.Ud.Tz == null) {
                return null;
            }
            String optString = this.Ud.Tz.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.dNU.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public String mP(int i) {
        String str = this.dNV.get(i);
        if (TextUtils.isEmpty(str)) {
            if (aLA() || this.Ud.TB == null) {
                return null;
            }
            String optString = this.Ud.TB.optString(String.valueOf(i));
            if (!TextUtils.isEmpty(optString)) {
                this.dNV.put(i, optString);
                return optString;
            }
            return optString;
        }
        return str;
    }

    public z aLz() {
        if (aLA()) {
            return null;
        }
        return this.Ud;
    }

    private boolean aLA() {
        if (this.Ud == null) {
            this.Ud = com.baidu.live.l.a.uA().akM.Ud;
            if (this.Ud == null) {
                return true;
            }
        }
        return false;
    }
}
