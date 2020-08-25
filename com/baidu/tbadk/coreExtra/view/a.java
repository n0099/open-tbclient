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
/* loaded from: classes15.dex */
public class a {
    private ImageViewerBottomLayout eGk;
    private AbsFloorImageTextView eGl;
    private LinearLayout eGm;
    private boolean eGn = true;
    private final ImageViewerBottomLayout.a eGo = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.eGn = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.eGn)));
            a.this.iU(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.eGm = new LinearLayout(context);
        this.eGm.setOrientation(1);
        this.eGm.setVisibility(8);
        ap.a(this.eGm, R.color.cp_mask_b_alpha66, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.eGm, layoutParams);
        bpM();
        bpL();
    }

    private void bpL() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.eGq);
        this.eGk = new ImageViewerBottomLayout(this.mContext);
        this.eGm.addView(this.eGk, layoutParams);
        this.eGk.setExpandButtonListener(this.eGo);
    }

    private void bpM() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eGl = new FloorImageTextViewNew(this.mContext);
        this.eGm.addView(this.eGl, layoutParams);
    }

    public void iU(boolean z) {
        if (this.eGl != null) {
            this.eGl.iU(z);
        }
        if (this.eGk != null) {
            this.eGk.iV(!z);
        }
    }

    public void setUserId(String str) {
        if (this.eGl != null) {
            this.eGl.setUserId(str);
        }
        if (this.eGk != null) {
            this.eGk.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.eGl != null) {
            this.eGl.a(imageUrlData);
        }
        if (this.eGk != null) {
            this.eGk.b(imageUrlData);
        }
    }

    private boolean bn(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bn(this.eGm);
    }

    public boolean bpN() {
        return this.eGn;
    }

    public void setVisibility(int i) {
        if (this.eGm != null) {
            this.eGm.clearAnimation();
            this.eGm.setVisibility(i);
        }
    }

    public void be(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.y(this.eGm, i2);
        } else {
            com.baidu.tieba.v.a.x(this.eGm, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.eGk != null) {
            this.eGk.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.eGk != null) {
            this.eGk.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.eGk != null) {
            this.eGk.setOnReplyClickListener(onClickListener);
        }
    }
}
