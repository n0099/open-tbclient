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
    private Bitmap baT;
    private ImageView baU;
    private int baV = ViewCompat.MEASURED_STATE_MASK;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.baV = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View fB(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.baT = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.baU == null) {
            this.baU = new ImageView(this.mListView.getContext());
        }
        this.baU.setBackgroundColor(this.baV);
        this.baU.setPadding(0, 0, 0, 0);
        this.baU.setImageBitmap(this.baT);
        this.baU.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.baU;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void T(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.baT.recycle();
        this.baT = null;
    }
}
