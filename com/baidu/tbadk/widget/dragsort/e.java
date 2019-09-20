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
    private Bitmap cIJ;
    private ImageView cIK;
    private int cIL = ViewCompat.MEASURED_STATE_MASK;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.cIL = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View lm(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.cIJ = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.cIK == null) {
            this.cIK = new ImageView(this.mListView.getContext());
        }
        this.cIK.setBackgroundColor(this.cIL);
        this.cIK.setPadding(0, 0, 0, 0);
        this.cIK.setImageBitmap(this.cIJ);
        this.cIK.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.cIK;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void bi(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.cIJ.recycle();
        this.cIJ = null;
    }
}
