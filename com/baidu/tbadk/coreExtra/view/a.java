package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private ImageViewerBottomLayout egM;
    private AbsFloorImageTextView egN;
    private LinearLayout egO;
    private boolean egP = true;
    private final ImageViewerBottomLayout.a egQ = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.egP = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.egP)));
            a.this.hJ(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.egO = new LinearLayout(context);
        this.egO.setOrientation(1);
        this.egO.setVisibility(8);
        am.a(this.egO, R.color.cp_mask_b_alpha66, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.egO, layoutParams);
        bbr();
        bbq();
    }

    private void bbq() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.egS);
        this.egM = new ImageViewerBottomLayout(this.mContext);
        this.egO.addView(this.egM, layoutParams);
        this.egM.setExpandButtonListener(this.egQ);
    }

    private void bbr() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.egN = new FloorImageTextViewNew(this.mContext);
        this.egO.addView(this.egN, layoutParams);
    }

    public void hJ(boolean z) {
        if (this.egN != null) {
            this.egN.hJ(z);
        }
        if (this.egM != null) {
            this.egM.hK(!z);
        }
    }

    public void setUserId(String str) {
        if (this.egN != null) {
            this.egN.setUserId(str);
        }
        if (this.egM != null) {
            this.egM.setUserId(str);
        }
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.egM != null) {
            this.egM.setIsBjhDynamic(z);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.egN != null) {
            this.egN.a(imageUrlData);
        }
        if (this.egM != null) {
            this.egM.b(imageUrlData);
        }
    }

    private boolean bf(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bf(this.egO);
    }

    public boolean bbs() {
        return this.egP;
    }

    public void setVisibility(int i) {
        if (this.egO != null) {
            this.egO.clearAnimation();
            this.egO.setVisibility(i);
        }
    }

    public void aQ(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.x(this.egO, i2);
        } else {
            com.baidu.tieba.v.a.w(this.egO, i2);
        }
    }
}
