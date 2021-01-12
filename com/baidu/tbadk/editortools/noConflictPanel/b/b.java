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
    private static int fAU = 0;
    private static int fAV = 0;
    private static int fAW = 0;
    private static int fAX = 0;

    /* renamed from: com.baidu.tbadk.editortools.noConflictPanel.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0577b {
        void kQ(boolean z);
    }

    public static void bS(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(Context context, int i) {
        if (fAU != i && i > 0) {
            fAU = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(fAU);
            com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static int fj(Context context) {
        if (fAU == 0) {
            fAU = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_last_keyboard_height", i(context.getResources()));
            if (fAU > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(fAU);
            }
        }
        return fAU;
    }

    public static int fk(Context context) {
        return Math.min(h(context.getResources()), Math.max(i(context.getResources()), fj(context)));
    }

    public static int h(Resources resources) {
        if (fAV == 0) {
            fAV = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return fAV;
    }

    public static int i(Resources resources) {
        if (fAW == 0) {
            fAW = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return fAW;
    }

    public static int fl(Context context) {
        if (fAX == 0) {
            fAX = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return fAX;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0577b interfaceC0577b) {
        int height;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        boolean ah = d.ah(activity);
        boolean A = d.A(activity);
        boolean ai = d.ai(activity);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            height = point.y;
        } else {
            height = defaultDisplay.getHeight();
        }
        a aVar = new a(ah, A, ai, viewGroup, bVar, interfaceC0577b, height);
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
        private final int czr;
        private final int dTc;
        private final ViewGroup fAZ;
        private final com.baidu.tbadk.editortools.noConflictPanel.b fBa;
        private final boolean fBb;
        private final boolean fBc;
        private boolean fBd;
        private final InterfaceC0577b fBe;
        private int fBg;
        private final boolean isFullScreen;
        private int fAY = 0;
        private boolean fBf = false;

        a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0577b interfaceC0577b, int i) {
            this.fAZ = viewGroup;
            this.fBa = bVar;
            this.isFullScreen = z;
            this.fBb = z2;
            this.fBc = z3;
            this.czr = c.getStatusBarHeight(viewGroup.getContext());
            this.fBe = interfaceC0577b;
            this.dTc = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.fAZ.getChildAt(0);
            View view = (View) this.fAZ.getParent();
            Rect rect = new Rect();
            if (this.fBb) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.fBf) {
                    this.fBf = i2 == this.dTc;
                }
                i = !this.fBf ? this.czr + i2 : i2;
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i != -1) {
                qX(i);
                qY(i);
                this.fAY = i;
            }
        }

        private void qX(int i) {
            int abs;
            int fk;
            if (this.fAY == 0) {
                this.fAY = i;
                this.fBa.qV(b.fk(getContext()));
                return;
            }
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.g(this.isFullScreen, this.fBb, this.fBc)) {
                abs = ((View) this.fAZ.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.fAY);
            }
            if (abs <= b.fl(getContext())) {
                int height = ((View) this.fAZ.getParent()).getHeight() - i;
                if (i < this.fAY) {
                    abs = height - this.czr;
                } else {
                    return;
                }
            }
            if (abs != this.czr && b.I(getContext(), abs) && this.fBa.getHeight() != (fk = b.fk(getContext()))) {
                this.fBa.qV(fk);
            }
        }

        private void qY(int i) {
            boolean z;
            boolean z2 = true;
            View view = (View) this.fAZ.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.g(this.isFullScreen, this.fBb, this.fBc)) {
                if (!this.fBb && height - i == this.czr) {
                    z = this.fBd;
                } else {
                    z = height > i;
                }
            } else {
                int i2 = this.fAZ.getResources().getDisplayMetrics().heightPixels;
                if (this.fBb || i2 == height) {
                }
                if (this.fBg == 0) {
                    z2 = this.fBd;
                } else if (i >= this.fBg - b.fl(getContext())) {
                    z2 = false;
                }
                this.fBg = Math.max(this.fBg, height);
                z = z2;
            }
            if (this.fBd != z) {
                this.fBa.kQ(z);
                if (this.fBe != null) {
                    this.fBe.kQ(z);
                }
            }
            this.fBd = z;
        }

        private Context getContext() {
            return this.fAZ.getContext();
        }
    }
}
