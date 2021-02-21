package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e implements AbsListView.OnScrollListener {
    private a iRh;
    private b iRj;
    private int mScrollState = -1;
    private int iRi = 0;

    /* loaded from: classes2.dex */
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
                if (this.iRi != 0 && this.iRj != null) {
                    this.iRj.a(absListView, 0, -this.iRi);
                }
                this.iRi = 0;
                this.iRh = null;
                return;
            }
            a aVar = new a(absListView, i);
            if (this.iRh == null) {
                this.iRh = aVar;
                this.iRi = absListView.getPaddingTop() - childAt.getTop();
                if (this.iRj != null) {
                    this.iRj.a(absListView, this.iRi, 0);
                    return;
                }
                return;
            }
            int a2 = this.iRh.a(aVar);
            this.iRh = aVar;
            this.iRi += a2;
            if (this.iRj != null) {
                this.iRj.a(absListView, this.iRi, a2);
            }
        }
    }

    public void a(b bVar) {
        this.iRj = bVar;
    }

    /* loaded from: classes2.dex */
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
                        return cVar.top - cVar2.top;
                    }
                }
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        private int bottom;
        private int position;
        private int top;

        private c(View view, int i) {
            this.position = i;
            this.top = view.getTop();
            this.bottom = view.getBottom();
        }
    }
}
