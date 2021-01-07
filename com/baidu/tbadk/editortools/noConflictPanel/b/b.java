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
    private static int fFC = 0;
    private static int fFD = 0;
    private static int fFE = 0;
    private static int fFF = 0;

    /* renamed from: com.baidu.tbadk.editortools.noConflictPanel.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0594b {
        void kU(boolean z);
    }

    public static void bS(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean I(Context context, int i) {
        if (fFC != i && i > 0) {
            fFC = i;
            TbadkCoreApplication.getInst().setKeyboardHeight(fFC);
            com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_last_keyboard_height", i);
            return true;
        }
        return false;
    }

    public static int fl(Context context) {
        if (fFC == 0) {
            fFC = com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_last_keyboard_height", i(context.getResources()));
            if (fFC > 0) {
                TbadkCoreApplication.getInst().setKeyboardHeight(fFC);
            }
        }
        return fFC;
    }

    public static int fm(Context context) {
        return Math.min(h(context.getResources()), Math.max(i(context.getResources()), fl(context)));
    }

    public static int h(Resources resources) {
        if (fFD == 0) {
            fFD = resources.getDimensionPixelSize(R.dimen.max_editor_panel_height);
        }
        return fFD;
    }

    public static int i(Resources resources) {
        if (fFE == 0) {
            fFE = resources.getDimensionPixelSize(R.dimen.ds460);
        }
        return fFE;
    }

    public static int fn(Context context) {
        if (fFF == 0) {
            fFF = context.getResources().getDimensionPixelSize(R.dimen.ds460);
        }
        return fFF;
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener a(Activity activity, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0594b interfaceC0594b) {
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
        a aVar = new a(ah, A, ai, viewGroup, bVar, interfaceC0594b, height);
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
        private final int cEd;
        private final int dXO;
        private final ViewGroup fFH;
        private final com.baidu.tbadk.editortools.noConflictPanel.b fFI;
        private final boolean fFJ;
        private final boolean fFK;
        private boolean fFL;
        private final InterfaceC0594b fFM;
        private int fFO;
        private final boolean isFullScreen;
        private int fFG = 0;
        private boolean fFN = false;

        a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, com.baidu.tbadk.editortools.noConflictPanel.b bVar, InterfaceC0594b interfaceC0594b, int i) {
            this.fFH = viewGroup;
            this.fFI = bVar;
            this.isFullScreen = z;
            this.fFJ = z2;
            this.fFK = z3;
            this.cEd = c.getStatusBarHeight(viewGroup.getContext());
            this.fFM = interfaceC0594b;
            this.dXO = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            View childAt = this.fFH.getChildAt(0);
            View view = (View) this.fFH.getParent();
            Rect rect = new Rect();
            if (this.fFJ) {
                view.getWindowVisibleDisplayFrame(rect);
                int i2 = rect.bottom - rect.top;
                if (!this.fFN) {
                    this.fFN = i2 == this.dXO;
                }
                i = !this.fFN ? this.cEd + i2 : i2;
            } else if (childAt != null) {
                childAt.getWindowVisibleDisplayFrame(rect);
                i = rect.bottom - rect.top;
            } else {
                i = -1;
            }
            if (i != -1) {
                sD(i);
                sE(i);
                this.fFG = i;
            }
        }

        private void sD(int i) {
            int abs;
            int fm;
            if (this.fFG == 0) {
                this.fFG = i;
                this.fFI.sB(b.fm(getContext()));
                return;
            }
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.g(this.isFullScreen, this.fFJ, this.fFK)) {
                abs = ((View) this.fFH.getParent()).getHeight() - i;
            } else {
                abs = Math.abs(i - this.fFG);
            }
            if (abs <= b.fn(getContext())) {
                int height = ((View) this.fFH.getParent()).getHeight() - i;
                if (i < this.fFG) {
                    abs = height - this.cEd;
                } else {
                    return;
                }
            }
            if (abs != this.cEd && b.I(getContext(), abs) && this.fFI.getHeight() != (fm = b.fm(getContext()))) {
                this.fFI.sB(fm);
            }
        }

        private void sE(int i) {
            boolean z;
            boolean z2 = true;
            View view = (View) this.fFH.getParent();
            int height = view.getHeight() - view.getPaddingTop();
            if (com.baidu.tbadk.editortools.noConflictPanel.b.a.g(this.isFullScreen, this.fFJ, this.fFK)) {
                if (!this.fFJ && height - i == this.cEd) {
                    z = this.fFL;
                } else {
                    z = height > i;
                }
            } else {
                int i2 = this.fFH.getResources().getDisplayMetrics().heightPixels;
                if (this.fFJ || i2 == height) {
                }
                if (this.fFO == 0) {
                    z2 = this.fFL;
                } else if (i >= this.fFO - b.fn(getContext())) {
                    z2 = false;
                }
                this.fFO = Math.max(this.fFO, height);
                z = z2;
            }
            if (this.fFL != z) {
                this.fFI.kU(z);
                if (this.fFM != null) {
                    this.fFM.kU(z);
                }
            }
            this.fFL = z;
        }

        private Context getContext() {
            return this.fFH.getContext();
        }
    }
}
