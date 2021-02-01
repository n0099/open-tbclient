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
    private static int fDj = 0;
    private static int fDk = 0;
    private static int fDl = 0;
    private static int fDm = 0;

    /* renamed from: com.baidu.tbadk.editortools.noConflictPanel.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0574b {
        void kT(boolean z);
    }

    public static void bO(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(Context context, int i) {
        if (fDj != i && i > 0) {
            fDj = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(fDj);
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static int fi(Context context) {
        if (fDj == 0) {
            fDj = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_last_keyboard_height", i(context.getResources()));
            if (fDj > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(fDj);
            }
        }
        return fDj;
    }

    public static int fj(Context context) {
        return Math.min(h(context.getResources()), Math.max(i(context.getResources()), fi(context)));
    }

    public static int h(Resources resources) {
        if (fDk == 0) {
            fDk = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return fDk;
    }

    public static int i(Resources resources) {
        if (fDl == 0) {
            fDl = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return fDl;
    }

    public static int fk(Context context) {
        if (fDm == 0) {
            fDm = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return fDm;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0574b interfaceC0574b) {
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
        a aVar = new a(ab, u, ac, viewGroup, bVar, interfaceC0574b, height);
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
        private final int cBN;
        private final int dVi;
        private final ViewGroup fDo;
        private final com.baidu.tbadk.editortools.noConflictPanel.b fDp;
        private final boolean fDq;
        private final boolean fDr;
        private boolean fDs;
        private final InterfaceC0574b fDt;
        private int fDv;
        private final boolean isFullScreen;
        private int fDn = 0;
        private boolean fDu = false;

        a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0574b interfaceC0574b, int i) {
            this.fDo = viewGroup;
            this.fDp = bVar;
            this.isFullScreen = z;
            this.fDq = z2;
            this.fDr = z3;
            this.cBN = c.getStatusBarHeight(viewGroup.getContext());
            this.fDt = interfaceC0574b;
            this.dVi = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.fDo.getChildAt(0);
            View view = (View) this.fDo.getParent();
            Rect rect = new Rect();
            if (this.fDq) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.fDu) {
                    this.fDu = i2 == this.dVi;
                }
                i = !this.fDu ? this.cBN + i2 : i2;
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i != -1) {
                rc(i);
                rd(i);
                this.fDn = i;
            }
        }

        private void rc(int i) {
            int abs;
            int fj;
            if (this.fDn == 0) {
                this.fDn = i;
                this.fDp.ra(b.fj(getContext()));
                return;
            }
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.g(this.isFullScreen, this.fDq, this.fDr)) {
                abs = ((View) this.fDo.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.fDn);
            }
            if (abs <= b.fk(getContext())) {
                int height = ((View) this.fDo.getParent()).getHeight() - i;
                if (i < this.fDn) {
                    abs = height - this.cBN;
                } else {
                    return;
                }
            }
            if (abs != this.cBN && b.I(getContext(), abs) && this.fDp.getHeight() != (fj = b.fj(getContext()))) {
                this.fDp.ra(fj);
            }
        }

        private void rd(int i) {
            boolean z;
            boolean z2 = true;
            View view = (View) this.fDo.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.g(this.isFullScreen, this.fDq, this.fDr)) {
                if (!this.fDq && height - i == this.cBN) {
                    z = this.fDs;
                } else {
                    z = height > i;
                }
            } else {
                int i2 = this.fDo.getResources().getDisplayMetrics().heightPixels;
                if (this.fDq || i2 == height) {
                }
                if (this.fDv == 0) {
                    z2 = this.fDs;
                } else if (i >= this.fDv - b.fk(getContext())) {
                    z2 = false;
                }
                this.fDv = Math.max(this.fDv, height);
                z = z2;
            }
            if (this.fDs != z) {
                this.fDp.kT(z);
                if (this.fDt != null) {
                    this.fDt.kT(z);
                }
            }
            this.fDs = z;
        }

        private Context getContext() {
            return this.fDo.getContext();
        }
    }
}
