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
    private static SharedPreferences dlj = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a cQ(Context context) {
        return new a(context);
    }

    private static SharedPreferences cR(Context context) {
        if (dlj == null) {
            dlj = context.getSharedPreferences("downgradefile", 0);
        }
        return dlj;
    }

    private int cS(Context context) {
        int i = cR(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int cT(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.e(TAG, "error:" + e.getMessage());
            }
            return -1;
        }
    }

    private void r(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set new versioncode:" + i);
        }
        SharedPreferences.Editor edit = cR(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aFc() {
        int cT = cT(this.mContext);
        int cS = cS(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + cT + " /oldVersionCode=" + cS);
        }
        if (cS == 0) {
            lJ(cT);
            r(this.mContext, cT);
            s(this.mContext, cS);
        } else if (cT > cS) {
            L(cT, cS);
            r(this.mContext, cT);
            s(this.mContext, cS);
        } else if (cT < cS) {
            aD(cT, cS);
            r(this.mContext, cT);
            s(this.mContext, cS);
        } else {
            aFd();
        }
    }

    private void L(int i, int i2) {
        com.baidu.swan.apps.am.a.L(i2, i);
    }

    private void aD(int i, int i2) {
    }

    private void lJ(int i) {
        com.baidu.swan.apps.am.a.L(0, i);
    }

    private void aFd() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + cS(this.mContext));
        }
    }

    public static void s(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = cR(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
