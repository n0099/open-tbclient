package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private ImageViewerBottomLayout epw;
    private AbsFloorImageTextView epx;
    private LinearLayout epy;
    private Context mContext;
    private boolean epz = true;
    private final ImageViewerBottomLayout.a epA = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.epz = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.epz)));
            a.this.hS(z);
        }
    };

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.epy = new LinearLayout(context);
        this.epy.setOrientation(1);
        this.epy.setVisibility(8);
        an.a(this.epy, R.color.cp_mask_b_alpha66, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.epy, layoutParams);
        bdt();
        bds();
    }

    private void bds() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.epC);
        this.epw = new ImageViewerBottomLayout(this.mContext);
        this.epy.addView(this.epw, layoutParams);
        this.epw.setExpandButtonListener(this.epA);
    }

    private void bdt() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.epx = new FloorImageTextViewNew(this.mContext);
        this.epy.addView(this.epx, layoutParams);
    }

    public void hS(boolean z) {
        if (this.epx != null) {
            this.epx.hS(z);
        }
        if (this.epw != null) {
            this.epw.hT(!z);
        }
    }

    public void setUserId(String str) {
        if (this.epx != null) {
            this.epx.setUserId(str);
        }
        if (this.epw != null) {
            this.epw.setUserId(str);
        }
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.epw != null) {
            this.epw.setIsBjhDynamic(z);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.epx != null) {
            this.epx.a(imageUrlData);
        }
        if (this.epw != null) {
            this.epw.b(imageUrlData);
        }
    }

    private boolean bf(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bf(this.epy);
    }

    public boolean bdu() {
        return this.epz;
    }

    public void setVisibility(int i) {
        if (this.epy != null) {
            this.epy.clearAnimation();
            this.epy.setVisibility(i);
        }
    }

    public void aU(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.x(this.epy, i2);
        } else {
            com.baidu.tieba.v.a.w(this.epy, i2);
        }
    }
}
