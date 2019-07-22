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
    private int ewl;
    private int fVN;
    private int fVO;
    private int fVP;
    private int fVQ;
    private a fVR;
    private List<String> fVS;
    private boolean fVT;
    public final View.OnClickListener fVU;
    private int mImageHeight;
    private int mImageWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void btF();
    }

    public ImageOverlayView(Context context) {
        super(context);
        this.ewl = 10;
        this.fVT = false;
        this.fVU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fVR != null) {
                    ImageOverlayView.this.fVR.btF();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewl = 10;
        this.fVT = false;
        this.fVU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fVR != null) {
                    ImageOverlayView.this.fVR.btF();
                }
            }
        };
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ewl = 10;
        this.fVT = false;
        this.fVU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.fVR != null) {
                    ImageOverlayView.this.fVR.btF();
                }
            }
        };
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fVN = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.fVO = i4;
        this.fVP = i5;
        this.fVQ = i6;
        btE();
    }

    private void btE() {
        for (int i = 0; i < this.fVN; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setBorderWidth(this.fVO);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setBorderColor(am.getColor(this.fVP));
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(headImageView);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((getPaddingLeft() + getPaddingRight()) + (this.fVN * this.mImageWidth)) - ((this.fVN - 1) * this.fVQ), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        if (this.fVT) {
            paddingLeft = getPaddingLeft();
            paddingTop = getPaddingTop();
        } else {
            paddingLeft = ((this.fVN - 1) * (this.mImageWidth - this.fVQ)) + getPaddingLeft();
            paddingTop = getPaddingTop();
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.fVN && i6 < getChildCount() && (childAt = getChildAt(i6)) != null; i6++) {
            if (this.fVT) {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 += this.mImageWidth - this.fVQ;
            } else {
                childAt.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                i5 -= this.mImageWidth - this.fVQ;
            }
        }
    }

    public void setData(List<String> list) {
        HeadImageView headImageView;
        if (!v.aa(list)) {
            this.fVS = list;
            for (int i = 0; i < this.fVN && (headImageView = (HeadImageView) getChildAt(i)) != null; i++) {
                if (i >= list.size()) {
                    headImageView.setVisibility(8);
                } else {
                    headImageView.setVisibility(0);
                    String str = (String) v.c(list, (list.size() - i) - 1);
                    if (str != null) {
                        if (this.ewl == 12) {
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
                    ((HeadImageView) childAt).setBorderColor(am.getColor(this.fVP));
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.fVR = aVar;
    }

    public void setLoadImageType(int i) {
        this.ewl = i;
    }

    public void setOrientation(boolean z) {
        this.fVT = z;
    }
}
