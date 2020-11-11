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
    private ImageViewerBottomLayout fiS;
    private AbsFloorImageTextView fiT;
    private LinearLayout fiU;
    private boolean fiV = true;
    private final ImageViewerBottomLayout.a fiW = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.fiV = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.fiV)));
            a.this.jN(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fiU = new LinearLayout(context);
        this.fiU.setOrientation(1);
        this.fiU.setVisibility(8);
        ap.a(this.fiU, R.color.cp_mask_b_alpha66, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.fiU, layoutParams);
        bxJ();
        bxI();
    }

    private void bxI() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.fiY);
        this.fiS = new ImageViewerBottomLayout(this.mContext);
        this.fiU.addView(this.fiS, layoutParams);
        this.fiS.setExpandButtonListener(this.fiW);
    }

    private void bxJ() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fiT = new FloorImageTextViewNew(this.mContext);
        this.fiU.addView(this.fiT, layoutParams);
    }

    public void jN(boolean z) {
        if (this.fiT != null) {
            this.fiT.jN(z);
        }
        if (this.fiS != null) {
            this.fiS.jO(!z);
        }
    }

    public void setUserId(String str) {
        if (this.fiT != null) {
            this.fiT.setUserId(str);
        }
        if (this.fiS != null) {
            this.fiS.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.fiT != null) {
            this.fiT.a(imageUrlData);
        }
        if (this.fiS != null) {
            this.fiS.b(imageUrlData);
        }
    }

    private boolean by(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return by(this.fiU);
    }

    public boolean bxK() {
        return this.fiV;
    }

    public void setVisibility(int i) {
        if (this.fiU != null) {
            this.fiU.clearAnimation();
            this.fiU.setVisibility(i);
        }
    }

    public void be(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.B(this.fiU, i2);
        } else {
            com.baidu.tieba.v.a.A(this.fiU, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fiS != null) {
            this.fiS.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fiS != null) {
            this.fiS.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fiS != null) {
            this.fiS.setOnReplyClickListener(onClickListener);
        }
    }
}
