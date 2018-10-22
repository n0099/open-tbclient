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
    private int eae;
    private int eaf;
    private int eag;
    private int eah;
    private a eai;
    private List<String> eaj;
    public final View.OnClickListener eak;
    private int mImageHeight;
    private int mImageWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void aGT();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.eak = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.eai != null) {
                    ImageOverlayView.this.eai.aGT();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eak = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.eai != null) {
                    ImageOverlayView.this.eai.aGT();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eak = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.eai != null) {
                    ImageOverlayView.this.eai.aGT();
                }
            }
        };
    }

    public void h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eae = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.eaf = i4;
        this.eag = i5;
        this.eah = i6;
        aGS();
    }

    private void aGS() {
        for (int i = 0; i < this.eae; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setBorderWidth(this.eaf);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setBorderColor(al.getColor(this.eag));
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(headImageView);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.eae * this.mImageWidth)) - ((this.eae - 1) * this.eah), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt;
        int paddingLeft = ((this.eae - 1) * (this.mImageWidth - this.eah)) + getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < this.eae && i5 < getChildCount() && (childAt = getChildAt(i5)) != null; i5++) {
            childAt.layout(paddingLeft, paddingTop, this.mImageWidth + paddingLeft, this.mImageHeight + paddingTop);
            paddingLeft -= this.mImageWidth - this.eah;
        }
    }

    public void setData(List<String> list) {
        HeadImageView headImageView;
        if (!v.J(list)) {
            this.eaj = list;
            for (int i = 0; i < this.eae && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
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
                    ((HeadImageView) childAt).setBorderColor(al.getColor(this.eag));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.eai = aVar;
    }
}
