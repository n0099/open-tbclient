package com.baidu.tieba.horizonalList.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.horizonalList.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0699a {
        protected View view;

        public abstract boolean isHardwareAccelerated();

        public abstract void postOnAnimation(Runnable runnable);

        public abstract void setScrollX(int i);

        protected AbstractC0699a(View view) {
            this.view = view;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends AbstractC0699a {
        public b(View view) {
            super(view);
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0699a
        public void postOnAnimation(Runnable runnable) {
            this.view.post(runnable);
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0699a
        public void setScrollX(int i) {
            this.view.scrollTo(i, this.view.getScrollY());
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0699a
        public boolean isHardwareAccelerated() {
            return false;
        }
    }

    public static final AbstractC0699a cA(View view) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.tieba.horizonalList.a.b.a(view) : new b(view);
    }
}
