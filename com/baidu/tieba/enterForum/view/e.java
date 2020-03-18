package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e implements AbsListView.OnScrollListener {
    private a gaU;
    private b gaW;
    private int mScrollState = -1;
    private int gaV = 0;

    /* loaded from: classes9.dex */
    public interface b {
        void a(AbsListView absListView, int i, int i2);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.mScrollState = i;
        if (i != 0 && i != 2 && i == 1) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        View childAt;
        if (absListView != null && i >= 0 && absListView.getChildCount() > 0 && (childAt = absListView.getChildAt(0)) != null) {
            if (i == 0 && childAt.getTop() == absListView.getPaddingTop()) {
                if (this.gaV != 0 && this.gaW != null) {
                    this.gaW.a(absListView, 0, -this.gaV);
                }
                this.gaV = 0;
                this.gaU = null;
                return;
            }
            a aVar = new a(absListView, i);
            if (this.gaU == null) {
                this.gaU = aVar;
                this.gaV = absListView.getPaddingTop() - childAt.getTop();
                if (this.gaW != null) {
                    this.gaW.a(absListView, this.gaV, 0);
                    return;
                }
                return;
            }
            int a2 = this.gaU.a(aVar);
            this.gaU = aVar;
            this.gaV += a2;
            if (this.gaW != null) {
                this.gaW.a(absListView, this.gaV, a2);
            }
        }
    }

    public void a(b bVar) {
        this.gaW = bVar;
    }

    /* loaded from: classes9.dex */
    private class a {
        private List<c> list;

        private a(AbsListView absListView, int i) {
            this.list = new ArrayList();
            int childCount = absListView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = absListView.getChildAt(i2);
                if (childAt != null) {
                    this.list.add(new c(childAt, i + i2));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a(a aVar) {
            if (aVar == null) {
                return 0;
            }
            for (c cVar : this.list) {
                for (c cVar2 : aVar.list) {
                    if (cVar.position == cVar2.position) {
                        return cVar.f1017top - cVar2.f1017top;
                    }
                }
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c {
        private int bottom;
        private int position;

        /* renamed from: top  reason: collision with root package name */
        private int f1017top;

        private c(View view, int i) {
            this.position = i;
            this.f1017top = view.getTop();
            this.bottom = view.getBottom();
        }
    }
}
