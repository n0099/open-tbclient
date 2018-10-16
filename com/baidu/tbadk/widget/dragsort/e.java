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
    private Bitmap biF;
    private ImageView biG;
    private int biH = -16777216;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.biH = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View fW(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.biF = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.biG == null) {
            this.biG = new ImageView(this.mListView.getContext());
        }
        this.biG.setBackgroundColor(this.biH);
        this.biG.setPadding(0, 0, 0, 0);
        this.biG.setImageBitmap(this.biF);
        this.biG.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.biG;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void ag(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.biF.recycle();
        this.biF = null;
    }
}
