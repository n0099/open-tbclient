package com.baidu.tbadk.widget.dragsort;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.baidu.tbadk.widget.dragsort.a;
/* loaded from: classes.dex */
public class e implements a.h {
    private Bitmap bjq;
    private ImageView bjr;
    private int bjs = -16777216;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.bjs = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View gk(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.bjq = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.bjr == null) {
            this.bjr = new ImageView(this.mListView.getContext());
        }
        this.bjr.setBackgroundColor(this.bjs);
        this.bjr.setPadding(0, 0, 0, 0);
        this.bjr.setImageBitmap(this.bjq);
        this.bjr.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.bjr;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void af(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.bjq.recycle();
        this.bjq = null;
    }
}
