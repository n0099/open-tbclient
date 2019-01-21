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
    private Bitmap bnG;
    private ImageView bnH;
    private int bnI = -16777216;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.bnI = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View gz(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.bnG = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.bnH == null) {
            this.bnH = new ImageView(this.mListView.getContext());
        }
        this.bnH.setBackgroundColor(this.bnI);
        this.bnH.setPadding(0, 0, 0, 0);
        this.bnH.setImageBitmap(this.bnG);
        this.bnH.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.bnH;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void af(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.bnG.recycle();
        this.bnG = null;
    }
}
