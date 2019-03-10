package com.baidu.tieba.aiapps.apps;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
/* loaded from: classes4.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static SharedPreferences cQV = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dy(Context context) {
        return new a(context);
    }

    private static SharedPreferences dz(Context context) {
        if (cQV == null) {
            cQV = context.getSharedPreferences("downgradefile", 0);
        }
        return cQV;
    }

    private int dA(Context context) {
        int i = dz(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int dB(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.e(TAG, "error:" + e.getMessage());
            }
            return -1;
        }
    }

    private void t(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set new versioncode:" + i);
        }
        SharedPreferences.Editor edit = dz(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void axS() {
        int dB = dB(this.mContext);
        int dA = dA(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + dB + " /oldVersionCode=" + dA);
        }
        if (dA == 0) {
            lF(dB);
            t(this.mContext, dB);
            u(this.mContext, dA);
        } else if (dB > dA) {
            G(dB, dA);
            t(this.mContext, dB);
            u(this.mContext, dA);
        } else if (dB < dA) {
            az(dB, dA);
            t(this.mContext, dB);
            u(this.mContext, dA);
        } else {
            axT();
        }
    }

    private void G(int i, int i2) {
        com.baidu.swan.apps.am.a.G(i2, i);
    }

    private void az(int i, int i2) {
    }

    private void lF(int i) {
        com.baidu.swan.apps.am.a.G(0, i);
    }

    private void axT() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dA(this.mContext));
        }
    }

    public static void u(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dz(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
