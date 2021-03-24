package com.baidu.tieba.compatible;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public final class StatusBarUtil {
    public View actionBarView;
    public boolean lightStatusBar;
    public boolean transparentStatusBar;
    public Window window;

    /* loaded from: classes4.dex */
    public static final class Builder {
        public View actionBarView;
        public boolean lightStatusBar = false;
        public boolean transparentStatusbar = false;
        public Window window;

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setWindow(Window window) {
            this.window = window;
            return this;
        }

        public boolean process() {
            return new StatusBarUtil(this.window, this.lightStatusBar, this.transparentStatusbar, this.actionBarView, null).process();
        }

        public Builder setActionbarView(View view) {
            this.actionBarView = view;
            return this;
        }

        public Builder setLightStatusBar(boolean z) {
            this.lightStatusBar = z;
            return this;
        }

        public Builder setTransparentStatusbar(boolean z) {
            this.transparentStatusbar = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setWindow(Activity activity) {
            this.window = activity.getWindow();
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setWindow(Dialog dialog) {
            this.window = dialog.getWindow();
            return this;
        }
    }

    public StatusBarUtil(Window window, boolean z, boolean z2, View view) {
        this.lightStatusBar = z;
        this.transparentStatusBar = z2;
        this.window = window;
        this.actionBarView = view;
    }

    public static Builder from(Activity activity) {
        return new Builder().setWindow(activity);
    }

    public static int getStatusBarOffsetPx(Context context) {
        if (isLessKitkat()) {
            return 0;
        }
        Context applicationContext = context.getApplicationContext();
        int identifier = applicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return applicationContext.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean isKitkat() {
        return Build.VERSION.SDK_INT == 19;
    }

    public static boolean isLessKitkat() {
        return Build.VERSION.SDK_INT < 19;
    }

    public static boolean isMoreLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private boolean processFlyMe(boolean z) {
        WindowManager.LayoutParams attributes = this.window.getAttributes();
        try {
            Class<?> cls = Class.forName("android.view.WindowManager$LayoutParams");
            int i = cls.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON").getInt(attributes);
            Field declaredField = cls.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(attributes);
            if (z) {
                declaredField.set(attributes, Integer.valueOf(i2 | i));
            } else {
                declaredField.set(attributes, Integer.valueOf((i ^ (-1)) & i2));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @TargetApi(21)
    private boolean processLollipopAbove() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        int systemUiVisibility = this.window.getDecorView().getSystemUiVisibility();
        if (this.lightStatusBar) {
            systemUiVisibility |= -2147475456;
        }
        if (this.transparentStatusBar) {
            systemUiVisibility |= 1280;
        }
        this.window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        this.window.setStatusBarColor(0);
        return true;
    }

    private boolean processMIUI(boolean z) {
        Class<?> cls = this.window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window = this.window;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean process() {
        int i = Build.VERSION.SDK_INT;
        if (processPrivateAPI() || processLollipopAbove()) {
            if (i == 19) {
                processKitkat();
            }
            processActionBar(this.actionBarView);
            return true;
        }
        return false;
    }

    public void processActionBar(final View view) {
        if (view == null || !this.transparentStatusBar || isLessKitkat()) {
            return;
        }
        view.post(new Runnable() { // from class: com.baidu.tieba.compatible.StatusBarUtil.1
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                view2.setPadding(view2.getPaddingLeft(), view.getPaddingTop() + StatusBarUtil.getStatusBarOffsetPx(view.getContext()), view.getPaddingRight(), view.getPaddingBottom());
                view.getLayoutParams().height += StatusBarUtil.getStatusBarOffsetPx(view.getContext());
            }
        });
    }

    @TargetApi(19)
    public void processKitkat() {
        WindowManager.LayoutParams attributes = this.window.getAttributes();
        if (this.transparentStatusBar) {
            attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
        } else {
            attributes.flags &= -67108865;
        }
        this.window.setAttributes(attributes);
    }

    public boolean processPrivateAPI() {
        return processFlyMe(this.lightStatusBar) || processMIUI(this.lightStatusBar);
    }

    public static Builder from(Dialog dialog) {
        return new Builder().setWindow(dialog);
    }

    public static Builder from(Window window) {
        return new Builder().setWindow(window);
    }

    public /* synthetic */ StatusBarUtil(Window window, boolean z, boolean z2, View view, StatusBarUtil statusBarUtil) {
        this(window, z, z2, view);
    }
}
