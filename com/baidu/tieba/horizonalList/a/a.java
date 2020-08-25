package com.baidu.tieba.horizonalList.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.tieba.horizonalList.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0702a {
        protected View view;

        public abstract boolean isHardwareAccelerated();

        public abstract void postOnAnimation(Runnable runnable);

        public abstract void setScrollX(int i);

        protected AbstractC0702a(View view) {
            this.view = view;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends AbstractC0702a {
        public b(View view) {
            super(view);
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0702a
        public void postOnAnimation(Runnable runnable) {
            this.view.post(runnable);
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0702a
        public void setScrollX(int i) {
            this.view.scrollTo(i, this.view.getScrollY());
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0702a
        public boolean isHardwareAccelerated() {
            return false;
        }
    }

    public static final AbstractC0702a cr(View view) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.tieba.horizonalList.a.b.a(view) : new b(view);
    }
}
