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
    private static int fpj = 0;
    private static int fpk = 0;
    private static int fpl = 0;
    private static int fpm = 0;

    /* renamed from: com.baidu.tbadk.editortools.noConflictPanel.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0591b {
        void kg(boolean z);
    }

    public static void bD(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean y(Context context, int i) {
        if (fpj != i && i > 0) {
            fpj = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(fpj);
            com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static int ek(Context context) {
        if (fpj == 0) {
            fpj = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_last_keyboard_height", c(context.getResources()));
            if (fpj > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(fpj);
            }
        }
        return fpj;
    }

    public static int el(Context context) {
        return Math.min(b(context.getResources()), Math.max(c(context.getResources()), ek(context)));
    }

    public static int b(Resources resources) {
        if (fpk == 0) {
            fpk = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return fpk;
    }

    public static int c(Resources resources) {
        if (fpl == 0) {
            fpl = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return fpl;
    }

    public static int em(Context context) {
        if (fpm == 0) {
            fpm = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return fpm;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0591b interfaceC0591b) {
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
        a aVar = new a(af, C, ag, viewGroup, bVar, interfaceC0591b, height);
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
        private final int cua;
        private final int dJG;
        private final ViewGroup fpo;
        private final com.baidu.tbadk.editortools.noConflictPanel.b fpp;
        private final boolean fpq;
        private final boolean fpr;
        private boolean fpt;
        private final InterfaceC0591b fpu;
        private int fpw;
        private final boolean isFullScreen;
        private int fpn = 0;
        private boolean fpv = false;

        a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0591b interfaceC0591b, int i) {
            this.fpo = viewGroup;
            this.fpp = bVar;
            this.isFullScreen = z;
            this.fpq = z2;
            this.fpr = z3;
            this.cua = c.getStatusBarHeight(viewGroup.getContext());
            this.fpu = interfaceC0591b;
            this.dJG = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.fpo.getChildAt(0);
            View view = (View) this.fpo.getParent();
            Rect rect = new Rect();
            if (this.fpq) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.fpv) {
                    this.fpv = i2 == this.dJG;
                }
                i = !this.fpv ? this.cua + i2 : i2;
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i != -1) {
                rs(i);
                rt(i);
                this.fpn = i;
            }
        }

        private void rs(int i) {
            int abs;
            int el;
            if (this.fpn == 0) {
                this.fpn = i;
                this.fpp.rq(b.el(getContext()));
                return;
            }
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.fpq, this.fpr)) {
                abs = ((View) this.fpo.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.fpn);
            }
            if (abs <= b.em(getContext())) {
                int height = ((View) this.fpo.getParent()).getHeight() - i;
                if (i < this.fpn) {
                    abs = height - this.cua;
                } else {
                    return;
                }
            }
            if (abs != this.cua && b.y(getContext(), abs) && this.fpp.getHeight() != (el = b.el(getContext()))) {
                this.fpp.rq(el);
            }
        }

        private void rt(int i) {
            boolean z;
            boolean z2 = true;
            View view = (View) this.fpo.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.fpq, this.fpr)) {
                if (!this.fpq && height - i == this.cua) {
                    z = this.fpt;
                } else {
                    z = height > i;
                }
            } else {
                int i2 = this.fpo.getResources().getDisplayMetrics().heightPixels;
                if (this.fpq || i2 == height) {
                }
                if (this.fpw == 0) {
                    z2 = this.fpt;
                } else if (i >= this.fpw - b.em(getContext())) {
                    z2 = false;
                }
                this.fpw = Math.max(this.fpw, height);
                z = z2;
            }
            if (this.fpt != z) {
                this.fpp.kg(z);
                if (this.fpu != null) {
                    this.fpu.kg(z);
                }
            }
            this.fpt = z;
        }

        private Context getContext() {
            return this.fpo.getContext();
        }
    }
}
