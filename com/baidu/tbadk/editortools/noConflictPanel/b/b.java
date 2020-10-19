package com.baidu.tbadk.editortools.noConflictPanel.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b {
    private static int faT = 0;
    private static int faU = 0;
    private static int faV = 0;
    private static int faW = 0;

    /* renamed from: com.baidu.tbadk.editortools.noConflictPanel.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0565b {
        void jK(boolean z);
    }

    public static void by(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean y(Context context, int i) {
        if (faT != i && i > 0) {
            faT = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(faT);
            com.baidu.tbadk.core.sharedPref.b.blO().putInt("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static int ek(Context context) {
        if (faT == 0) {
            faT = com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_last_keyboard_height", c(context.getResources()));
            if (faT > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(faT);
            }
        }
        return faT;
    }

    public static int el(Context context) {
        return Math.min(b(context.getResources()), Math.max(c(context.getResources()), ek(context)));
    }

    public static int b(Resources resources) {
        if (faU == 0) {
            faU = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return faU;
    }

    public static int c(Resources resources) {
        if (faV == 0) {
            faV = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return faV;
    }

    public static int em(Context context) {
        if (faW == 0) {
            faW = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return faW;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0565b interfaceC0565b) {
        int height;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        boolean af = d.af(activity);
        boolean C = d.C(activity);
        boolean ag = d.ag(activity);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            height = point.y;
        } else {
            height = defaultDisplay.getHeight();
        }
        a aVar = new a(af, C, ag, viewGroup, bVar, interfaceC0565b, height);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        return aVar;
    }

    @TargetApi(16)
    public static void a(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (Build.VERSION.SDK_INT >= 16) {
            viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    /* loaded from: classes.dex */
    private static class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private final int cfD;
        private final int dvr;
        private final ViewGroup faY;
        private final com.baidu.tbadk.editortools.noConflictPanel.b faZ;
        private final boolean fba;
        private final boolean fbb;
        private boolean fbc;
        private final InterfaceC0565b fbd;
        private int fbf;
        private final boolean isFullScreen;
        private int faX = 0;
        private boolean fbe = false;

        a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0565b interfaceC0565b, int i) {
            this.faY = viewGroup;
            this.faZ = bVar;
            this.isFullScreen = z;
            this.fba = z2;
            this.fbb = z3;
            this.cfD = c.getStatusBarHeight(viewGroup.getContext());
            this.fbd = interfaceC0565b;
            this.dvr = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.faY.getChildAt(0);
            View view = (View) this.faY.getParent();
            Rect rect = new Rect();
            if (this.fba) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.fbe) {
                    this.fbe = i2 == this.dvr;
                }
                i = !this.fbe ? this.cfD + i2 : i2;
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i != -1) {
                qX(i);
                qY(i);
                this.faX = i;
            }
        }

        private void qX(int i) {
            int abs;
            int el;
            if (this.faX == 0) {
                this.faX = i;
                this.faZ.qV(b.el(getContext()));
                return;
            }
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.fba, this.fbb)) {
                abs = ((View) this.faY.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.faX);
            }
            if (abs <= b.em(getContext())) {
                int height = ((View) this.faY.getParent()).getHeight() - i;
                if (i < this.faX) {
                    abs = height - this.cfD;
                } else {
                    return;
                }
            }
            if (abs != this.cfD && b.y(getContext(), abs) && this.faZ.getHeight() != (el = b.el(getContext()))) {
                this.faZ.qV(el);
            }
        }

        private void qY(int i) {
            boolean z;
            boolean z2 = true;
            View view = (View) this.faY.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.fba, this.fbb)) {
                if (!this.fba && height - i == this.cfD) {
                    z = this.fbc;
                } else {
                    z = height > i;
                }
            } else {
                int i2 = this.faY.getResources().getDisplayMetrics().heightPixels;
                if (this.fba || i2 == height) {
                }
                if (this.fbf == 0) {
                    z2 = this.fbc;
                } else if (i >= this.fbf - b.em(getContext())) {
                    z2 = false;
                }
                this.fbf = Math.max(this.fbf, height);
                z = z2;
            }
            if (this.fbc != z) {
                this.faZ.jK(z);
                if (this.fbd != null) {
                    this.fbd.jK(z);
                }
            }
            this.fbc = z;
        }

        private Context getContext() {
            return this.faY.getContext();
        }
    }
}
