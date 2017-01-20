package com.baidu.tieba.horizonalList.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.horizonalList.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0064a {
        protected View view;

        public abstract void i(Runnable runnable);

        public abstract boolean isHardwareAccelerated();

        public abstract void setScrollX(int i);

        protected AbstractC0064a(View view) {
            this.view = view;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends AbstractC0064a {
        public b(View view) {
            super(view);
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0064a
        public void i(Runnable runnable) {
            this.view.post(runnable);
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0064a
        public void setScrollX(int i) {
            this.view.scrollTo(i, this.view.getScrollY());
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0064a
        public boolean isHardwareAccelerated() {
            return false;
        }
    }

    public static final AbstractC0064a az(View view) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.tieba.horizonalList.a.b.a(view) : new b(view);
    }
}
