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
    private static int fjs = 0;
    private static int fjt = 0;
    private static int fju = 0;
    private static int fjv = 0;

    /* renamed from: com.baidu.tbadk.editortools.noConflictPanel.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0579b {
        void jX(boolean z);
    }

    public static void bz(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean y(Context context, int i) {
        if (fjs != i && i > 0) {
            fjs = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(fjs);
            com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static int ek(Context context) {
        if (fjs == 0) {
            fjs = com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_last_keyboard_height", c(context.getResources()));
            if (fjs > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(fjs);
            }
        }
        return fjs;
    }

    public static int el(Context context) {
        return Math.min(b(context.getResources()), Math.max(c(context.getResources()), ek(context)));
    }

    public static int b(Resources resources) {
        if (fjt == 0) {
            fjt = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return fjt;
    }

    public static int c(Resources resources) {
        if (fju == 0) {
            fju = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return fju;
    }

    public static int em(Context context) {
        if (fjv == 0) {
            fjv = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return fjv;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0579b interfaceC0579b) {
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
        a aVar = new a(af, C, ag, viewGroup, bVar, interfaceC0579b, height);
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
        private final int coc;
        private final int dDO;
        private final boolean fjA;
        private boolean fjB;
        private final InterfaceC0579b fjC;
        private int fjE;
        private final ViewGroup fjx;
        private final com.baidu.tbadk.editortools.noConflictPanel.b fjy;
        private final boolean fjz;
        private final boolean isFullScreen;
        private int fjw = 0;
        private boolean fjD = false;

        a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0579b interfaceC0579b, int i) {
            this.fjx = viewGroup;
            this.fjy = bVar;
            this.isFullScreen = z;
            this.fjz = z2;
            this.fjA = z3;
            this.coc = c.getStatusBarHeight(viewGroup.getContext());
            this.fjC = interfaceC0579b;
            this.dDO = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.fjx.getChildAt(0);
            View view = (View) this.fjx.getParent();
            Rect rect = new Rect();
            if (this.fjz) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.fjD) {
                    this.fjD = i2 == this.dDO;
                }
                i = !this.fjD ? this.coc + i2 : i2;
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i != -1) {
                ri(i);
                rj(i);
                this.fjw = i;
            }
        }

        private void ri(int i) {
            int abs;
            int el;
            if (this.fjw == 0) {
                this.fjw = i;
                this.fjy.rg(b.el(getContext()));
                return;
            }
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.fjz, this.fjA)) {
                abs = ((View) this.fjx.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.fjw);
            }
            if (abs <= b.em(getContext())) {
                int height = ((View) this.fjx.getParent()).getHeight() - i;
                if (i < this.fjw) {
                    abs = height - this.coc;
                } else {
                    return;
                }
            }
            if (abs != this.coc && b.y(getContext(), abs) && this.fjy.getHeight() != (el = b.el(getContext()))) {
                this.fjy.rg(el);
            }
        }

        private void rj(int i) {
            boolean z;
            boolean z2 = true;
            View view = (View) this.fjx.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.fjz, this.fjA)) {
                if (!this.fjz && height - i == this.coc) {
                    z = this.fjB;
                } else {
                    z = height > i;
                }
            } else {
                int i2 = this.fjx.getResources().getDisplayMetrics().heightPixels;
                if (this.fjz || i2 == height) {
                }
                if (this.fjE == 0) {
                    z2 = this.fjB;
                } else if (i >= this.fjE - b.em(getContext())) {
                    z2 = false;
                }
                this.fjE = Math.max(this.fjE, height);
                z = z2;
            }
            if (this.fjB != z) {
                this.fjy.jX(z);
                if (this.fjC != null) {
                    this.fjC.jX(z);
                }
            }
            this.fjB = z;
        }

        private Context getContext() {
            return this.fjx.getContext();
        }
    }
}
