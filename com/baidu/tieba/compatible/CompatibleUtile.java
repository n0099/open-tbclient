package com.baidu.tieba.compatible;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.FloatMath;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class CompatibleUtile {
    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.compatible.CompatibleUtile$1] */
    public static int getMemoryClass(Context context) {
        if (Build.VERSION.SDK_INT >= 5) {
            return new Object() { // from class: com.baidu.tieba.compatible.CompatibleUtile.1
                public int getMemoryClass(Context context2) {
                    ActivityManager am = (ActivityManager) context2.getSystemService("activity");
                    return am.getMemoryClass();
                }
            }.getMemoryClass(context);
        }
        return 16;
    }

    public static int getBitmapMaxMemory(Context context) {
        int max = getMemoryClass(context);
        if (max <= 0) {
            max = 16;
        }
        return ((max * AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) * AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) / 2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.compatible.CompatibleUtile$2] */
    public static int getActionMask() {
        return Build.VERSION.SDK_INT >= 5 ? new Object() { // from class: com.baidu.tieba.compatible.CompatibleUtile.2
            public int getActionMask() {
                return MotionEventCompat.ACTION_MASK;
            }
        }.getActionMask() : MotionEventCompat.ACTION_MASK;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.compatible.CompatibleUtile$3] */
    public static int getActionPointerUp() {
        if (Build.VERSION.SDK_INT >= 5) {
            return new Object() { // from class: com.baidu.tieba.compatible.CompatibleUtile.3
                public int getActionPointerUp() {
                    return 6;
                }
            }.getActionPointerUp();
        }
        return 6;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.compatible.CompatibleUtile$4] */
    public static int getActionPointerDown() {
        if (Build.VERSION.SDK_INT >= 5) {
            return new Object() { // from class: com.baidu.tieba.compatible.CompatibleUtile.4
                public int getActionPointerDown() {
                    return 5;
                }
            }.getActionPointerDown();
        }
        return 5;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.compatible.CompatibleUtile$5] */
    public static float getSpacing(final MotionEvent event) {
        if (Build.VERSION.SDK_INT >= 5) {
            return new Object() { // from class: com.baidu.tieba.compatible.CompatibleUtile.5
                public float getSpacing() {
                    int pointer = event.getPointerCount();
                    if (pointer < 2) {
                        return -1.0f;
                    }
                    float x = event.getX(0) - event.getX(1);
                    float y = event.getY(0) - event.getY(1);
                    return FloatMath.sqrt((x * x) + (y * y));
                }
            }.getSpacing();
        }
        return -1.0f;
    }
}
