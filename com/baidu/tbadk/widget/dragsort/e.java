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
    private Bitmap bnF;
    private ImageView bnG;
    private int bnH = -16777216;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.bnH = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View gz(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.bnF = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.bnG == null) {
            this.bnG = new ImageView(this.mListView.getContext());
        }
        this.bnG.setBackgroundColor(this.bnH);
        this.bnG.setPadding(0, 0, 0, 0);
        this.bnG.setImageBitmap(this.bnF);
        this.bnG.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.bnG;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void af(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.bnF.recycle();
        this.bnF = null;
    }
}
