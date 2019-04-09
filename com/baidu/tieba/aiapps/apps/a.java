package com.baidu.tieba.aiapps.apps;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
/* loaded from: classes4.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static SharedPreferences cQV = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dx(Context context) {
        return new a(context);
    }

    private static SharedPreferences dy(Context context) {
        if (cQV == null) {
            cQV = context.getSharedPreferences("downgradefile", 0);
        }
        return cQV;
    }

    private int dz(Context context) {
        int i = dy(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int dA(Context context) {
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
        SharedPreferences.Editor edit = dy(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void axO() {
        int dA = dA(this.mContext);
        int dz = dz(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + dA + " /oldVersionCode=" + dz);
        }
        if (dz == 0) {
            lE(dA);
            t(this.mContext, dA);
            u(this.mContext, dz);
        } else if (dA > dz) {
            G(dA, dz);
            t(this.mContext, dA);
            u(this.mContext, dz);
        } else if (dA < dz) {
            az(dA, dz);
            t(this.mContext, dA);
            u(this.mContext, dz);
        } else {
            axP();
        }
    }

    private void G(int i, int i2) {
        com.baidu.swan.apps.am.a.G(i2, i);
    }

    private void az(int i, int i2) {
    }

    private void lE(int i) {
        com.baidu.swan.apps.am.a.G(0, i);
    }

    private void axP() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dz(this.mContext));
        }
    }

    public static void u(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dy(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
