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
    private Bitmap cGr;
    private ImageView cGs;
    private int cGt = ViewCompat.MEASURED_STATE_MASK;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.cGt = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View lb(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.cGr = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.cGs == null) {
            this.cGs = new ImageView(this.mListView.getContext());
        }
        this.cGs.setBackgroundColor(this.cGt);
        this.cGs.setPadding(0, 0, 0, 0);
        this.cGs.setImageBitmap(this.cGr);
        this.cGs.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.cGs;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void bg(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.cGr.recycle();
        this.cGr = null;
    }
}
