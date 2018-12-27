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
    private Bitmap bmR;
    private ImageView bmS;
    private int bmT = -16777216;
    private ListView mListView;

    public e(ListView listView) {
        this.mListView = listView;
    }

    public void setBackgroundColor(int i) {
        this.bmT = i;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public View gz(int i) {
        View childAt = this.mListView.getChildAt((this.mListView.getHeaderViewsCount() + i) - this.mListView.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.bmR = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.bmS == null) {
            this.bmS = new ImageView(this.mListView.getContext());
        }
        this.bmS.setBackgroundColor(this.bmT);
        this.bmS.setPadding(0, 0, 0, 0);
        this.bmS.setImageBitmap(this.bmR);
        this.bmS.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.bmS;
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
    }

    @Override // com.baidu.tbadk.widget.dragsort.a.h
    public void af(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.bmR.recycle();
        this.bmR = null;
    }
}
