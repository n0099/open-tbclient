package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes4.dex */
public class ImageOverlayView extends ViewGroup {
    private int ews;
    private int fWD;
    private int fWE;
    private int fWF;
    private int fWG;
    private a fWH;
    private List<String> fWI;
    private boolean fWJ;
    public final View.OnClickListener fWK;
    private int mImageHeight;
    private int mImageWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void btS();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.ews = 10;
        this.fWJ = false;
        this.fWK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fWH != null) {
                    ImageOverlayView.this.fWH.btS();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ews = 10;
        this.fWJ = false;
        this.fWK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fWH != null) {
                    ImageOverlayView.this.fWH.btS();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ews = 10;
        this.fWJ = false;
        this.fWK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fWH != null) {
                    ImageOverlayView.this.fWH.btS();
                }
            }
        };
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fWD = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.fWE = i4;
        this.fWF = i5;
        this.fWG = i6;
        btR();
    }

    private void btR() {
        for (int i = 0; i < this.fWD; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setBorderWidth(this.fWE);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setBorderColor(am.getColor(this.fWF));
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(headImageView);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.fWD * this.mImageWidth)) - ((this.fWD - 1) * this.fWG), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        if (this.fWJ) {
            paddingLeft = getPaddingLeft();
            paddingTop = getPaddingTop();
        } else {
            paddingLeft = ((this.fWD - 1) * (this.mImageWidth - this.fWG)) + getPaddingLeft();
            paddingTop = getPaddingTop();
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.fWD && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            if (this.fWJ) {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 += this.mImageWidth - this.fWG;
            } else {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 -= this.mImageWidth - this.fWG;
            }
        }
    }

    public void setData(List<String> list) {
        HeadImageView headImageView;
        if (!v.aa(list)) {
            this.fWI = list;
            for (int i = 0; i < this.fWD && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    String str = (String) v.c(list, (list.size() - i) - 1);
                    if (str != null) {
                        if (this.ews == 12) {
                            headImageView.startLoad(str, 12, this.mImageWidth, this.mImageHeight, false);
                        } else {
                            headImageView.startLoad(str, 10, this.mImageWidth, this.mImageHeight, false);
                        }
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
                    ((HeadImageView) childAt).setBorderColor(am.getColor(this.fWF));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.fWH = aVar;
    }

    public void setLoadImageType(int i) {
        this.ews = i;
    }

    public void setOrientation(boolean z) {
        this.fWJ = z;
    }
}
