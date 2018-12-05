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
    private Bitmap bmO;
    private ImageView bmP;
    private int bmQ = -16777216;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.bmQ = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View gy(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.bmO = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.bmP == null) {
            this.bmP = new ImageView(this.mListView.getContext());
        }
        this.bmP.setBackgroundColor(this.bmQ);
        this.bmP.setPadding(0, 0, 0, 0);
        this.bmP.setImageBitmap(this.bmO);
        this.bmP.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.bmP;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void af(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.bmO.recycle();
        this.bmO = null;
    }
}
