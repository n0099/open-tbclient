package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class a {
    private ImageViewerBottomLayout evL;
    private AbsFloorImageTextView evM;
    private LinearLayout evN;
    private boolean evO = true;
    private final ImageViewerBottomLayout.a evP = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.evO = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.evO)));
            a.this.iw(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.evN = new LinearLayout(context);
        this.evN.setOrientation(1);
        this.evN.setVisibility(8);
        ao.a(this.evN, R.color.cp_mask_b_alpha66, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.evN, layoutParams);
        bha();
        bgZ();
    }

    private void bgZ() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.evR);
        this.evL = new ImageViewerBottomLayout(this.mContext);
        this.evN.addView(this.evL, layoutParams);
        this.evL.setExpandButtonListener(this.evP);
    }

    private void bha() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.evM = new FloorImageTextViewNew(this.mContext);
        this.evN.addView(this.evM, layoutParams);
    }

    public void iw(boolean z) {
        if (this.evM != null) {
            this.evM.iw(z);
        }
        if (this.evL != null) {
            this.evL.ix(!z);
        }
    }

    public void setUserId(String str) {
        if (this.evM != null) {
            this.evM.setUserId(str);
        }
        if (this.evL != null) {
            this.evL.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.evM != null) {
            this.evM.a(imageUrlData);
        }
        if (this.evL != null) {
            this.evL.b(imageUrlData);
        }
    }

    private boolean bl(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bl(this.evN);
    }

    public boolean bhb() {
        return this.evO;
    }

    public void setVisibility(int i) {
        if (this.evN != null) {
            this.evN.clearAnimation();
            this.evN.setVisibility(i);
        }
    }

    public void aV(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.y(this.evN, i2);
        } else {
            com.baidu.tieba.v.a.x(this.evN, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.evL != null) {
            this.evL.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.evL != null) {
            this.evL.setOnDownloadImageListener(bVar);
        }
    }
}
