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
    private static SharedPreferences dcF = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a df(Context context) {
        return new a(context);
    }

    private static SharedPreferences dg(Context context) {
        if (dcF == null) {
            dcF = context.getSharedPreferences("downgradefile", 0);
        }
        return dcF;
    }

    private int dh(Context context) {
        int i = dg(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int di(Context context) {
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
        SharedPreferences.Editor edit = dg(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aET() {
        int di = di(this.mContext);
        int dh = dh(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + di + " /oldVersionCode=" + dh);
        }
        if (dh == 0) {
            mF(di);
            t(this.mContext, di);
            u(this.mContext, dh);
        } else if (di > dh) {
            H(di, dh);
            t(this.mContext, di);
            u(this.mContext, dh);
        } else if (di < dh) {
            aE(di, dh);
            t(this.mContext, di);
            u(this.mContext, dh);
        } else {
            aEU();
        }
    }

    private void H(int i, int i2) {
        com.baidu.swan.apps.am.a.H(i2, i);
    }

    private void aE(int i, int i2) {
    }

    private void mF(int i) {
        com.baidu.swan.apps.am.a.H(0, i);
    }

    private void aEU() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dh(this.mContext));
        }
    }

    public static void u(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dg(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
