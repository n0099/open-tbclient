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
    private ImageViewerBottomLayout eGo;
    private AbsFloorImageTextView eGp;
    private LinearLayout eGq;
    private boolean eGr = true;
    private final ImageViewerBottomLayout.a eGs = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.eGr = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.eGr)));
            a.this.iW(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.eGq = new LinearLayout(context);
        this.eGq.setOrientation(1);
        this.eGq.setVisibility(8);
        ap.a(this.eGq, R.color.cp_mask_b_alpha66, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.eGq, layoutParams);
        bpN();
        bpM();
    }

    private void bpM() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.eGu);
        this.eGo = new ImageViewerBottomLayout(this.mContext);
        this.eGq.addView(this.eGo, layoutParams);
        this.eGo.setExpandButtonListener(this.eGs);
    }

    private void bpN() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eGp = new FloorImageTextViewNew(this.mContext);
        this.eGq.addView(this.eGp, layoutParams);
    }

    public void iW(boolean z) {
        if (this.eGp != null) {
            this.eGp.iW(z);
        }
        if (this.eGo != null) {
            this.eGo.iX(!z);
        }
    }

    public void setUserId(String str) {
        if (this.eGp != null) {
            this.eGp.setUserId(str);
        }
        if (this.eGo != null) {
            this.eGo.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.eGp != null) {
            this.eGp.a(imageUrlData);
        }
        if (this.eGo != null) {
            this.eGo.b(imageUrlData);
        }
    }

    private boolean bn(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bn(this.eGq);
    }

    public boolean bpO() {
        return this.eGr;
    }

    public void setVisibility(int i) {
        if (this.eGq != null) {
            this.eGq.clearAnimation();
            this.eGq.setVisibility(i);
        }
    }

    public void be(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.y(this.eGq, i2);
        } else {
            com.baidu.tieba.v.a.x(this.eGq, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.eGo != null) {
            this.eGo.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.eGo != null) {
            this.eGo.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.eGo != null) {
            this.eGo.setOnReplyClickListener(onClickListener);
        }
    }
}
