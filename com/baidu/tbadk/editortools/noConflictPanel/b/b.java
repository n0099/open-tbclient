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
    private static int fEI = 0;
    private static int fEJ = 0;
    private static int fEK = 0;
    private static int fEL = 0;

    /* renamed from: com.baidu.tbadk.editortools.noConflictPanel.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0580b {
        void kT(boolean z);
    }

    public static void bO(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(Context context, int i) {
        if (fEI != i && i > 0) {
            fEI = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(fEI);
            com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static int fh(Context context) {
        if (fEI == 0) {
            fEI = com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_last_keyboard_height", i(context.getResources()));
            if (fEI > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(fEI);
            }
        }
        return fEI;
    }

    public static int fi(Context context) {
        return Math.min(h(context.getResources()), Math.max(i(context.getResources()), fh(context)));
    }

    public static int h(Resources resources) {
        if (fEJ == 0) {
            fEJ = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return fEJ;
    }

    public static int i(Resources resources) {
        if (fEK == 0) {
            fEK = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return fEK;
    }

    public static int fj(Context context) {
        if (fEL == 0) {
            fEL = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return fEL;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0580b interfaceC0580b) {
        int height;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        boolean ab = d.ab(activity);
        boolean u = d.u(activity);
        boolean ac = d.ac(activity);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            height = point.y;
        } else {
            height = defaultDisplay.getHeight();
        }
        a aVar = new a(ab, u, ac, viewGroup, bVar, interfaceC0580b, height);
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
        private final int cDn;
        private final int dWJ;
        private final ViewGroup fEN;
        private final com.baidu.tbadk.editortools.noConflictPanel.b fEO;
        private final boolean fEP;
        private final boolean fEQ;
        private boolean fER;
        private final InterfaceC0580b fES;
        private int fEU;
        private final boolean isFullScreen;
        private int fEM = 0;
        private boolean fET = false;

        a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0580b interfaceC0580b, int i) {
            this.fEN = viewGroup;
            this.fEO = bVar;
            this.isFullScreen = z;
            this.fEP = z2;
            this.fEQ = z3;
            this.cDn = c.getStatusBarHeight(viewGroup.getContext());
            this.fES = interfaceC0580b;
            this.dWJ = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.fEN.getChildAt(0);
            View view = (View) this.fEN.getParent();
            Rect rect = new Rect();
            if (this.fEP) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.fET) {
                    this.fET = i2 == this.dWJ;
                }
                i = !this.fET ? this.cDn + i2 : i2;
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i != -1) {
                rd(i);
                re(i);
                this.fEM = i;
            }
        }

        private void rd(int i) {
            int abs;
            int fi;
            if (this.fEM == 0) {
                this.fEM = i;
                this.fEO.rb(b.fi(getContext()));
                return;
            }
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.g(this.isFullScreen, this.fEP, this.fEQ)) {
                abs = ((View) this.fEN.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.fEM);
            }
            if (abs <= b.fj(getContext())) {
                int height = ((View) this.fEN.getParent()).getHeight() - i;
                if (i < this.fEM) {
                    abs = height - this.cDn;
                } else {
                    return;
                }
            }
            if (abs != this.cDn && b.I(getContext(), abs) && this.fEO.getHeight() != (fi = b.fi(getContext()))) {
                this.fEO.rb(fi);
            }
        }

        private void re(int i) {
            boolean z;
            boolean z2 = true;
            View view = (View) this.fEN.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.g(this.isFullScreen, this.fEP, this.fEQ)) {
                if (!this.fEP && height - i == this.cDn) {
                    z = this.fER;
                } else {
                    z = height > i;
                }
            } else {
                int i2 = this.fEN.getResources().getDisplayMetrics().heightPixels;
                if (this.fEP || i2 == height) {
                }
                if (this.fEU == 0) {
                    z2 = this.fER;
                } else if (i >= this.fEU - b.fj(getContext())) {
                    z2 = false;
                }
                this.fEU = Math.max(this.fEU, height);
                z = z2;
            }
            if (this.fER != z) {
                this.fEO.kT(z);
                if (this.fES != null) {
                    this.fES.kT(z);
                }
            }
            this.fER = z;
        }

        private Context getContext() {
            return this.fEN.getContext();
        }
    }
}
