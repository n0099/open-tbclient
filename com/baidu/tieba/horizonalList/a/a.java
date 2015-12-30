package com.baidu.tieba.horizonalList.a;

import android.os.Build;
import android.util.Log;
import android.view.View;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.horizonalList.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0060a {
        protected View view;

        public abstract void d(Runnable runnable);

        public abstract boolean isHardwareAccelerated();

        public abstract void setScrollX(int i);

        protected AbstractC0060a(View view) {
            this.view = view;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends AbstractC0060a {
        public b(View view) {
            super(view);
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0060a
        public void d(Runnable runnable) {
            this.view.post(runnable);
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0060a
        public void setScrollX(int i) {
            Log.d("ViewHelper", "setScrollX: " + i);
            this.view.scrollTo(i, this.view.getScrollY());
        }

        @Override // com.baidu.tieba.horizonalList.a.a.AbstractC0060a
        public boolean isHardwareAccelerated() {
            return false;
        }
    }

    public static final AbstractC0060a N(View view) {
        return Build.VERSION.SDK_INT >= 14 ? new com.baidu.tieba.horizonalList.a.b.a(view) : new b(view);
    }
}
