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
    private Bitmap cHL;
    private ImageView cHM;
    private int cHN = ViewCompat.MEASURED_STATE_MASK;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.cHN = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View lh(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.cHL = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.cHM == null) {
            this.cHM = new ImageView(this.mListView.getContext());
        }
        this.cHM.setBackgroundColor(this.cHN);
        this.cHM.setPadding(0, 0, 0, 0);
        this.cHM.setImageBitmap(this.cHL);
        this.cHM.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.cHM;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void bi(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.cHL.recycle();
        this.cHL = null;
    }
}
