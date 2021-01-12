package com.baidu.tieba.horizonalList.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static abstract class a {
        protected View view;

        public abstract boolean RU();

        public abstract void postOnAnimation(Runnable runnable);

        public abstract void setScrollX(int i);

        protected a(View view) {
            this.view = view;
        }
    }

    /* renamed from: com.baidu.tieba.horizonalList.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0747b extends a {
        public C0747b(View view) {
            super(view);
        }

        @Override // com.baidu.tieba.horizonalList.a.b.a
        public void postOnAnimation(Runnable runnable) {
            this.view.post(runnable);
        }

        @Override // com.baidu.tieba.horizonalList.a.b.a
        public void setScrollX(int i) {
            this.view.scrollTo(i, this.view.getScrollY());
        }

        @Override // com.baidu.tieba.horizonalList.a.b.a
        public boolean RU() {
            return false;
        }
    }

    public static final a dj(View view) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.tieba.horizonalList.a.b.a(view) : new C0747b(view);
    }
}
