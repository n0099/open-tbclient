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
    private Bitmap fPM;
    private int fPN = ViewCompat.MEASURED_STATE_MASK;
    private ImageView mImageView;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.fPN = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View rJ(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.fPM = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.mImageView == null) {
            this.mImageView = new ImageView(this.mListView.getContext());
        }
        this.mImageView.setBackgroundColor(this.fPN);
        this.mImageView.setPadding(0, 0, 0, 0);
        this.mImageView.setImageBitmap(this.fPM);
        this.mImageView.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.mImageView;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void ca(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.fPM.recycle();
        this.fPM = null;
    }
}
