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
    private static int eOM = 0;
    private static int eON = 0;
    private static int eOO = 0;
    private static int eOP = 0;

    /* renamed from: com.baidu.tbadk.editortools.noConflictPanel.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0548b {
        void jm(boolean z);
    }

    public static void bu(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean y(Context context, int i) {
        if (eOM != i && i > 0) {
            eOM = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(eOM);
            com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static int ed(Context context) {
        if (eOM == 0) {
            eOM = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_last_keyboard_height", c(context.getResources()));
            if (eOM > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(eOM);
            }
        }
        return eOM;
    }

    public static int ee(Context context) {
        return Math.min(b(context.getResources()), Math.max(c(context.getResources()), ed(context)));
    }

    public static int b(Resources resources) {
        if (eON == 0) {
            eON = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return eON;
    }

    public static int c(Resources resources) {
        if (eOO == 0) {
            eOO = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return eOO;
    }

    public static int ef(Context context) {
        if (eOP == 0) {
            eOP = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return eOP;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0548b interfaceC0548b) {
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
        a aVar = new a(af, B, ag, viewGroup, bVar, interfaceC0548b, height);
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
        private final int bTp;
        private final int djl;
        private final ViewGroup eOR;
        private final com.baidu.tbadk.editortools.noConflictPanel.b eOS;
        private final boolean eOT;
        private final boolean eOU;
        private boolean eOV;
        private final InterfaceC0548b eOW;
        private int eOY;
        private final boolean isFullScreen;
        private int eOQ = 0;
        private boolean eOX = false;

        a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0548b interfaceC0548b, int i) {
            this.eOR = viewGroup;
            this.eOS = bVar;
            this.isFullScreen = z;
            this.eOT = z2;
            this.eOU = z3;
            this.bTp = c.getStatusBarHeight(viewGroup.getContext());
            this.eOW = interfaceC0548b;
            this.djl = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.eOR.getChildAt(0);
            View view = (View) this.eOR.getParent();
            Rect rect = new Rect();
            if (this.eOT) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.eOX) {
                    this.eOX = i2 == this.djl;
                }
                i = !this.eOX ? this.bTp + i2 : i2;
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i != -1) {
                qz(i);
                qA(i);
                this.eOQ = i;
            }
        }

        private void qz(int i) {
            int abs;
            int ee;
            if (this.eOQ == 0) {
                this.eOQ = i;
                this.eOS.qx(b.ee(getContext()));
                return;
            }
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.eOT, this.eOU)) {
                abs = ((View) this.eOR.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.eOQ);
            }
            if (abs <= b.ef(getContext())) {
                int height = ((View) this.eOR.getParent()).getHeight() - i;
                if (i < this.eOQ) {
                    abs = height - this.bTp;
                } else {
                    return;
                }
            }
            if (abs != this.bTp && b.y(getContext(), abs) && this.eOS.getHeight() != (ee = b.ee(getContext()))) {
                this.eOS.qx(ee);
            }
        }

        private void qA(int i) {
            boolean z;
            boolean z2 = true;
            View view = (View) this.eOR.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.f(this.isFullScreen, this.eOT, this.eOU)) {
                if (!this.eOT && height - i == this.bTp) {
                    z = this.eOV;
                } else {
                    z = height > i;
                }
            } else {
                int i2 = this.eOR.getResources().getDisplayMetrics().heightPixels;
                if (this.eOT || i2 == height) {
                }
                if (this.eOY == 0) {
                    z2 = this.eOV;
                } else if (i >= this.eOY - b.ef(getContext())) {
                    z2 = false;
                }
                this.eOY = Math.max(this.eOY, height);
                z = z2;
            }
            if (this.eOV != z) {
                this.eOS.jm(z);
                if (this.eOW != null) {
                    this.eOW.jm(z);
                }
            }
            this.eOV = z;
        }

        private Context getContext() {
            return this.eOR.getContext();
        }
    }
}
