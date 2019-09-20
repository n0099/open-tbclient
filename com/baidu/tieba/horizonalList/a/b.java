package com.baidu.tieba.horizonalList.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static abstract class a {
        protected View view;

        public abstract boolean isHardwareAccelerated();

        public abstract void postOnAnimation(Runnable runnable);

        public abstract void setScrollX(int i);

        protected a(View view) {
            this.view = view;
        }
    }

    /* renamed from: com.baidu.tieba.horizonalList.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0339b extends a {
        public C0339b(View view) {
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
        public boolean isHardwareAccelerated() {
            return false;
        }
    }

    public static final a cc(View view) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.tieba.horizonalList.a.b.a(view) : new C0339b(view);
    }
}
