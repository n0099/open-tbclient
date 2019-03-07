package com.baidu.tbadk.widget.dragsort;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.baidu.tbadk.widget.dragsort.a;
/* loaded from: classes.dex */
public class e implements a.h {
    private Bitmap cyh;
    private ImageView cyi;
    private int cyj = ViewCompat.MEASURED_STATE_MASK;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.cyj = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View kn(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.cyh = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.cyi == null) {
            this.cyi = new ImageView(this.mListView.getContext());
        }
        this.cyi.setBackgroundColor(this.cyj);
        this.cyi.setPadding(0, 0, 0, 0);
        this.cyi.setImageBitmap(this.cyh);
        this.cyi.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.cyi;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void ba(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.cyh.recycle();
        this.cyh = null;
    }
}
