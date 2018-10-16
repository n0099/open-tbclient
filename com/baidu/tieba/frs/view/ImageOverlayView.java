package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes6.dex */
public class ImageOverlayView extends ViewGroup {
    private int ead;
    private int eae;
    private int eaf;
    private int eag;
    private a eah;
    private List<String> eai;
    public final View.OnClickListener eaj;
    private int mImageHeight;
    private int mImageWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void aGT();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.eaj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.eah != null) {
                    ImageOverlayView.this.eah.aGT();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eaj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.eah != null) {
                    ImageOverlayView.this.eah.aGT();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eaj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.eah != null) {
                    ImageOverlayView.this.eah.aGT();
                }
            }
        };
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.ead = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.eae = i4;
        this.eaf = i5;
        this.eag = i6;
        aGS();
    }

    private void aGS() {
        for (int i = 0; i < this.ead; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setBorderWidth(this.eae);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setBorderColor(al.getColor(this.eaf));
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(headImageView);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.ead * this.mImageWidth)) - ((this.ead - 1) * this.eag), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = ((this.ead - 1) * (this.mImageWidth - this.eag)) + getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < this.ead && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.mImageWidth + paddingLeft, this.mImageHeight + paddingTop);
            paddingLeft -= this.mImageWidth - this.eag;
        }
    }

    public void setData(List<String> list) {
        HeadImageView headImageView;
        if (!v.J(list)) {
            this.eai = list;
            for (int i = 0; i < this.ead && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    String str = (String) v.d(list, (list.size() - i) - 1);
                    if (str != null) {
                        headImageView.startLoad(str, 10, this.mImageWidth, this.mImageHeight, false);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void onChangeSkinType() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof HeadImageView) {
                    ((HeadImageView) childAt).setBorderColor(al.getColor(this.eaf));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.eah = aVar;
    }
}
