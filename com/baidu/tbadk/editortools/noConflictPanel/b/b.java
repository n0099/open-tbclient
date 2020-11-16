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

    /* renamed from: for  reason: not valid java name */
    private static int f2for = 0;
    private static int fos = 0;
    private static int fot = 0;
    private static int fou = 0;

    /* renamed from: com.baidu.tbadk.editortools.noConflictPanel.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0590b {
        void kh(boolean z);
    }

    public static void bG(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean y(Context context, int i) {
        if (f2for != i && i > 0) {
            f2for = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(f2for);
            com.baidu.tbadk.core.sharedPref.b.bpu().putInt("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static int ek(Context context) {
        if (f2for == 0) {
            f2for = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_last_keyboard_height", c(context.getResources()));
            if (f2for > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(f2for);
            }
        }
        return f2for;
    }

    public static int el(Context context) {
        return Math.min(b(context.getResources()), Math.max(c(context.getResources()), ek(context)));
    }

    public static int b(Resources resources) {
        if (fos == 0) {
            fos = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return fos;
    }

    public static int c(Resources resources) {
        if (fot == 0) {
            fot = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return fot;
    }

    public static int em(Context context) {
        if (fou == 0) {
            fou = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return fou;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0590b interfaceC0590b) {
        int height;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        boolean ae = d.ae(activity);
        boolean B = d.B(activity);
        boolean af = d.af(activity);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            height = point.y;
        } else {
            height = defaultDisplay.getHeight();
        }
        a aVar = new a(ae, B, af, viewGroup, bVar, interfaceC0590b, height);
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
        private final int cso;
        private final int dHY;
        private boolean foA;
        private final InterfaceC0590b foB;
        private int foD;
        private final ViewGroup fow;
        private final com.baidu.tbadk.editortools.noConflictPanel.b fox;
        private final boolean foy;
        private final boolean foz;
        private final boolean isFullScreen;
        private int fov = 0;
        private boolean foC = false;

        a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0590b interfaceC0590b, int i) {
            this.fow = viewGroup;
            this.fox = bVar;
            this.isFullScreen = z;
            this.foy = z2;
            this.foz = z3;
            this.cso = c.getStatusBarHeight(viewGroup.getContext());
            this.foB = interfaceC0590b;
            this.dHY = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.fow.getChildAt(0);
            View view = (View) this.fow.getParent();
            Rect rect = new Rect();
            if (this.foy) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.foC) {
                    this.foC = i2 == this.dHY;
                }
                i = !this.foC ? this.cso + i2 : i2;
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i != -1) {
                rQ(i);
                rR(i);
                this.fov = i;
            }
        }

        private void rQ(int i) {
            int abs;
            int el;
            if (this.fov == 0) {
                this.fov = i;
                this.fox.rO(b.el(getContext()));
                return;
            }
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.foy, this.foz)) {
                abs = ((View) this.fow.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.fov);
            }
            if (abs <= b.em(getContext())) {
                int height = ((View) this.fow.getParent()).getHeight() - i;
                if (i < this.fov) {
                    abs = height - this.cso;
                } else {
                    return;
                }
            }
            if (abs != this.cso && b.y(getContext(), abs) && this.fox.getHeight() != (el = b.el(getContext()))) {
                this.fox.rO(el);
            }
        }

        private void rR(int i) {
            boolean z;
            boolean z2 = true;
            View view = (View) this.fow.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.foy, this.foz)) {
                if (!this.foy && height - i == this.cso) {
                    z = this.foA;
                } else {
                    z = height > i;
                }
            } else {
                int i2 = this.fow.getResources().getDisplayMetrics().heightPixels;
                if (this.foy || i2 == height) {
                }
                if (this.foD == 0) {
                    z2 = this.foA;
                } else if (i >= this.foD - b.em(getContext())) {
                    z2 = false;
                }
                this.foD = Math.max(this.foD, height);
                z = z2;
            }
            if (this.foA != z) {
                this.fox.kh(z);
                if (this.foB != null) {
                    this.foB.kh(z);
                }
            }
            this.foA = z;
        }

        private Context getContext() {
            return this.fow.getContext();
        }
    }
}
