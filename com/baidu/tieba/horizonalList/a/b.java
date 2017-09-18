package com.baidu.tieba.horizonalList.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static abstract class a {
        protected View view;

        public abstract void i(Runnable runnable);

        public abstract boolean isHardwareAccelerated();

        public abstract void setScrollX(int i);

        protected a(View view) {
            this.view = view;
        }
    }

    /* renamed from: com.baidu.tieba.horizonalList.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0090b extends a {
        public C0090b(View view) {
            super(view);
        }

        @Override // com.baidu.tieba.horizonalList.a.b.a
        public void i(Runnable runnable) {
            this.view.post(runnable);
        }

        @Override // com.baidu.tieba.horizonalList.a.b.a
        public void setScrollX(int i) {
            this.view.scrollTo(i, this.view.getScrollY());
        }

        @Override // com.baidu.tieba.horizonalList.a.b.a
        public boolean isHardwareAccelerated() {
            return false;
        }
    }

    public static final a aG(View view) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.tieba.horizonalList.a.b.a(view) : new C0090b(view);
    }
}
