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
    private static SharedPreferences cZl = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dd(Context context) {
        return new a(context);
    }

    private static SharedPreferences de(Context context) {
        if (cZl == null) {
            cZl = context.getSharedPreferences("downgradefile", 0);
        }
        return cZl;
    }

    private int df(Context context) {
        int i = de(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int dg(Context context) {
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
        SharedPreferences.Editor edit = de(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aCX() {
        int dg = dg(this.mContext);
        int df = df(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + dg + " /oldVersionCode=" + df);
        }
        if (df == 0) {
            mt(dg);
            t(this.mContext, dg);
            u(this.mContext, df);
        } else if (dg > df) {
            E(dg, df);
            t(this.mContext, dg);
            u(this.mContext, df);
        } else if (dg < df) {
            az(dg, df);
            t(this.mContext, dg);
            u(this.mContext, df);
        } else {
            aCY();
        }
    }

    private void E(int i, int i2) {
        com.baidu.swan.apps.am.a.E(i2, i);
    }

    private void az(int i, int i2) {
    }

    private void mt(int i) {
        com.baidu.swan.apps.am.a.E(0, i);
    }

    private void aCY() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + df(this.mContext));
        }
    }

    public static void u(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = de(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
