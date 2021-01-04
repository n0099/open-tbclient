package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.hottopic.data.l;
import java.util.List;
/* loaded from: classes8.dex */
public class ImageOverlayView extends ViewGroup {
    private int iOw;
    private int iOz;
    private a kuj;
    private List<l> kuk;
    private int mImageHeight;
    private int mImageWidth;

    /* loaded from: classes8.dex */
    public interface a {
    }

    public ImageOverlayView(Context context) {
        super(context);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.iOw * this.mImageWidth)) - ((this.iOw - 1) * this.iOz), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < this.iOw && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.mImageWidth + paddingLeft, this.mImageHeight + paddingTop);
            paddingLeft += this.mImageWidth - this.iOz;
        }
    }

    public void setImageClickListener(a aVar) {
        this.kuj = aVar;
    }

    public void setData(List<l> list) {
        HeadImageView headImageView;
        if (!x.isEmpty(list)) {
            this.kuk = list;
            for (int i = 0; i < this.iOw && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    l lVar = (l) x.getItem(list, (list.size() - i) - 1);
                    if (lVar != null) {
                        headImageView.setUserId(String.valueOf(lVar.userId));
                        headImageView.a(lVar.portrait, 12, this.mImageWidth, this.mImageHeight, false);
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
