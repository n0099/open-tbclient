package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a {
    private LinearLayout fpA;
    private boolean fpB = true;
    private final ImageViewerBottomLayout.a fpC = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.fpB = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.fpB)));
            a.this.ke(z);
        }
    };
    private ImageViewerBottomLayout fpy;
    private AbsFloorImageTextView fpz;
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fpA = new LinearLayout(context);
        this.fpA.setOrientation(1);
        this.fpA.setVisibility(8);
        ap.a(this.fpA, R.color.CAM_X0608, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.fpA, layoutParams);
        bAz();
        bAy();
    }

    private void bAy() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.fpE);
        this.fpy = new ImageViewerBottomLayout(this.mContext);
        this.fpA.addView(this.fpy, layoutParams);
        this.fpy.setExpandButtonListener(this.fpC);
    }

    private void bAz() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fpz = new FloorImageTextViewNew(this.mContext);
        this.fpA.addView(this.fpz, layoutParams);
    }

    public void ke(boolean z) {
        if (this.fpz != null) {
            this.fpz.ke(z);
        }
        if (this.fpy != null) {
            this.fpy.kf(!z);
        }
    }

    public void setUserId(String str) {
        if (this.fpz != null) {
            this.fpz.setUserId(str);
        }
        if (this.fpy != null) {
            this.fpy.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.fpz != null) {
            this.fpz.a(imageUrlData);
        }
        if (this.fpy != null) {
            this.fpy.b(imageUrlData);
        }
    }

    private boolean bE(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bE(this.fpA);
    }

    public boolean bAA() {
        return this.fpB;
    }

    public void setVisibility(int i) {
        if (this.fpA != null) {
            this.fpA.clearAnimation();
            this.fpA.setVisibility(i);
        }
    }

    public void bg(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.w.a.D(this.fpA, i2);
        } else {
            com.baidu.tieba.w.a.C(this.fpA, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fpy != null) {
            this.fpy.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fpy != null) {
            this.fpy.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fpy != null) {
            this.fpy.setOnReplyClickListener(onClickListener);
        }
    }
}
