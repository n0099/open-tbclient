package com.baidu.tieba.ala.live.guess.c;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes11.dex */
public class a {
    public static float hhm;
    public static float hhn;
    public static float hho;
    private static a hhp;

    public static a fY(Context context) {
        if (hhp == null) {
            hhp = new a(context);
        }
        return hhp;
    }

    public static a bXK() {
        if (hhp == null) {
            throw new RuntimeException("UiUtil应该先调用含有构造方法进行初始化");
        }
        return hhp;
    }

    private a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (hhm == 0.0f || hhn == 0.0f) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int fZ = fZ(context);
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                hhm = displayMetrics.heightPixels;
                hhn = displayMetrics.widthPixels - fZ;
            } else {
                hhm = displayMetrics.widthPixels;
                hhn = displayMetrics.heightPixels - fZ;
            }
            hho = fZ(context);
        }
    }

    public int fZ(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE));
        return dimensionPixelSize != -1 ? dimensionPixelSize : e(context, "com.android.internal.R$dimen", "system_bar_height", 48);
    }

    private int e(Context context, String str, String str2, int i) {
        try {
            Class<?> cls = Class.forName(str);
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField(str2).get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public int uL(int i) {
        return Math.round((i * hhm) / 414.0f);
    }

    public int uM(int i) {
        return Math.round((i * hhn) / (896.0f - hho));
    }
}
