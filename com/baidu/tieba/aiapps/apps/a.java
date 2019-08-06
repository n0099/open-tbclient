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
    private static SharedPreferences daS = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a de(Context context) {
        return new a(context);
    }

    private static SharedPreferences df(Context context) {
        if (daS == null) {
            daS = context.getSharedPreferences("downgradefile", 0);
        }
        return daS;
    }

    private int dg(Context context) {
        int i = df(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int dh(Context context) {
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
        SharedPreferences.Editor edit = df(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aEp() {
        int dh = dh(this.mContext);
        int dg = dg(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + dh + " /oldVersionCode=" + dg);
        }
        if (dg == 0) {
            mB(dh);
            t(this.mContext, dh);
            u(this.mContext, dg);
        } else if (dh > dg) {
            H(dh, dg);
            t(this.mContext, dh);
            u(this.mContext, dg);
        } else if (dh < dg) {
            aE(dh, dg);
            t(this.mContext, dh);
            u(this.mContext, dg);
        } else {
            aEq();
        }
    }

    private void H(int i, int i2) {
        com.baidu.swan.apps.am.a.H(i2, i);
    }

    private void aE(int i, int i2) {
    }

    private void mB(int i) {
        com.baidu.swan.apps.am.a.H(0, i);
    }

    private void aEq() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dg(this.mContext));
        }
    }

    public static void u(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = df(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
