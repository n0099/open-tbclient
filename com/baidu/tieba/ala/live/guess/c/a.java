package com.baidu.tieba.ala.live.guess.c;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes10.dex */
public class a {
    public static float hjk;
    public static float hjl;
    public static float hjm;
    private static a hjn;

    public static a fX(Context context) {
        if (hjn == null) {
            hjn = new a(context);
        }
        return hjn;
    }

    public static a bXX() {
        if (hjn == null) {
            throw new RuntimeException("UiUtil应该先调用含有构造方法进行初始化");
        }
        return hjn;
    }

    private a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (hjk == 0.0f || hjl == 0.0f) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int fY = fY(context);
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                hjk = displayMetrics.heightPixels;
                hjl = displayMetrics.widthPixels - fY;
            } else {
                hjk = displayMetrics.widthPixels;
                hjl = displayMetrics.heightPixels - fY;
            }
            hjm = fY(context);
        }
    }

    public int fY(Context context) {
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

    public int uN(int i) {
        return Math.round((i * hjk) / 414.0f);
    }

    public int uO(int i) {
        return Math.round((i * hjl) / (896.0f - hjm));
    }
}
