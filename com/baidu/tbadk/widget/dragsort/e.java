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
    private Bitmap bel;
    private ImageView bem;
    private int ben = ViewCompat.MEASURED_STATE_MASK;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.ben = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View fN(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.bel = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.bem == null) {
            this.bem = new ImageView(this.mListView.getContext());
        }
        this.bem.setBackgroundColor(this.ben);
        this.bem.setPadding(0, 0, 0, 0);
        this.bem.setImageBitmap(this.bel);
        this.bem.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.bem;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void ag(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.bel.recycle();
        this.bel = null;
    }
}
