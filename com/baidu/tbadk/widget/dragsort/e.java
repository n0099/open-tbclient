package com.baidu.tbadk.widget.dragsort;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.baidu.tbadk.widget.dragsort.a;
/* loaded from: classes.dex */
public class e implements a.h {
    private Bitmap fUt;
    private int fUu = ViewCompat.MEASURED_STATE_MASK;
    private ImageView mImageView;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.fUu = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View tp(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.fUt = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.mImageView == null) {
            this.mImageView = new ImageView(this.mListView.getContext());
        }
        this.mImageView.setBackgroundColor(this.fUu);
        this.mImageView.setPadding(0, 0, 0, 0);
        this.mImageView.setImageBitmap(this.fUt);
        this.mImageView.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.mImageView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void ca(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.fUt.recycle();
        this.fUt = null;
    }
}
