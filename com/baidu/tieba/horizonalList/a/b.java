package com.baidu.tieba.horizonalList.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: view  reason: collision with root package name */
        protected View f17view;

        public abstract boolean isHardwareAccelerated();

        public abstract void postOnAnimation(Runnable runnable);

        public abstract void setScrollX(int i);

        protected a(View view2) {
            this.f17view = view2;
        }
    }

    /* renamed from: com.baidu.tieba.horizonalList.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0147b extends a {
        public C0147b(View view2) {
            super(view2);
        }

        @Override // com.baidu.tieba.horizonalList.a.b.a
        public void postOnAnimation(Runnable runnable) {
            this.f17view.post(runnable);
        }

        @Override // com.baidu.tieba.horizonalList.a.b.a
        public void setScrollX(int i) {
            this.f17view.scrollTo(i, this.f17view.getScrollY());
        }

        @Override // com.baidu.tieba.horizonalList.a.b.a
        public boolean isHardwareAccelerated() {
            return false;
        }
    }

    public static final a aC(View view2) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.tieba.horizonalList.a.b.a(view2) : new C0147b(view2);
    }
}
