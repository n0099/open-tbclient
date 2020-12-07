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
    private static int fvW = 0;
    private static int fvX = 0;
    private static int fvY = 0;
    private static int fvZ = 0;

    /* renamed from: com.baidu.tbadk.editortools.noConflictPanel.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0603b {
        void ky(boolean z);
    }

    public static void bJ(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean H(Context context, int i) {
        if (fvW != i && i > 0) {
            fvW = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(fvW);
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static int eP(Context context) {
        if (fvW == 0) {
            fvW = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_last_keyboard_height", c(context.getResources()));
            if (fvW > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(fvW);
            }
        }
        return fvW;
    }

    public static int eQ(Context context) {
        return Math.min(b(context.getResources()), Math.max(c(context.getResources()), eP(context)));
    }

    public static int b(Resources resources) {
        if (fvX == 0) {
            fvX = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return fvX;
    }

    public static int c(Resources resources) {
        if (fvY == 0) {
            fvY = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return fvY;
    }

    public static int eR(Context context) {
        if (fvZ == 0) {
            fvZ = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return fvZ;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0603b interfaceC0603b) {
        int height;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        boolean af = d.af(activity);
        boolean B = d.B(activity);
        boolean ag = d.ag(activity);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            height = point.y;
        } else {
            height = defaultDisplay.getHeight();
        }
        a aVar = new a(af, B, ag, viewGroup, bVar, interfaceC0603b, height);
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
        private final int czk;
        private final int dOW;
        private final ViewGroup fwb;
        private final com.baidu.tbadk.editortools.noConflictPanel.b fwc;
        private final boolean fwd;
        private final boolean fwe;
        private boolean fwf;
        private final InterfaceC0603b fwg;
        private int fwi;
        private final boolean isFullScreen;
        private int fwa = 0;
        private boolean fwh = false;

        a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0603b interfaceC0603b, int i) {
            this.fwb = viewGroup;
            this.fwc = bVar;
            this.isFullScreen = z;
            this.fwd = z2;
            this.fwe = z3;
            this.czk = c.getStatusBarHeight(viewGroup.getContext());
            this.fwg = interfaceC0603b;
            this.dOW = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.fwb.getChildAt(0);
            View view = (View) this.fwb.getParent();
            Rect rect = new Rect();
            if (this.fwd) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.fwh) {
                    this.fwh = i2 == this.dOW;
                }
                i = !this.fwh ? this.czk + i2 : i2;
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i != -1) {
                sr(i);
                ss(i);
                this.fwa = i;
            }
        }

        private void sr(int i) {
            int abs;
            int eQ;
            if (this.fwa == 0) {
                this.fwa = i;
                this.fwc.sp(b.eQ(getContext()));
                return;
            }
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.fwd, this.fwe)) {
                abs = ((View) this.fwb.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.fwa);
            }
            if (abs <= b.eR(getContext())) {
                int height = ((View) this.fwb.getParent()).getHeight() - i;
                if (i < this.fwa) {
                    abs = height - this.czk;
                } else {
                    return;
                }
            }
            if (abs != this.czk && b.H(getContext(), abs) && this.fwc.getHeight() != (eQ = b.eQ(getContext()))) {
                this.fwc.sp(eQ);
            }
        }

        private void ss(int i) {
            boolean z;
            boolean z2 = true;
            View view = (View) this.fwb.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.fwd, this.fwe)) {
                if (!this.fwd && height - i == this.czk) {
                    z = this.fwf;
                } else {
                    z = height > i;
                }
            } else {
                int i2 = this.fwb.getResources().getDisplayMetrics().heightPixels;
                if (this.fwd || i2 == height) {
                }
                if (this.fwi == 0) {
                    z2 = this.fwf;
                } else if (i >= this.fwi - b.eR(getContext())) {
                    z2 = false;
                }
                this.fwi = Math.max(this.fwi, height);
                z = z2;
            }
            if (this.fwf != z) {
                this.fwc.ky(z);
                if (this.fwg != null) {
                    this.fwg.ky(z);
                }
            }
            this.fwf = z;
        }

        private Context getContext() {
            return this.fwb.getContext();
        }
    }
}
