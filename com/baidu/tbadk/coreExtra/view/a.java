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
    private ImageViewerBottomLayout eUC;
    private AbsFloorImageTextView eUD;
    private LinearLayout eUE;
    private boolean eUF = true;
    private final ImageViewerBottomLayout.a eUG = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.eUF = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.eUF)));
            a.this.jr(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.eUE = new LinearLayout(context);
        this.eUE.setOrientation(1);
        this.eUE.setVisibility(8);
        ap.a(this.eUE, R.color.cp_mask_b_alpha66, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.eUE, layoutParams);
        btr();
        btq();
    }

    private void btq() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.eUI);
        this.eUC = new ImageViewerBottomLayout(this.mContext);
        this.eUE.addView(this.eUC, layoutParams);
        this.eUC.setExpandButtonListener(this.eUG);
    }

    private void btr() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eUD = new FloorImageTextViewNew(this.mContext);
        this.eUE.addView(this.eUD, layoutParams);
    }

    public void jr(boolean z) {
        if (this.eUD != null) {
            this.eUD.jr(z);
        }
        if (this.eUC != null) {
            this.eUC.js(!z);
        }
    }

    public void setUserId(String str) {
        if (this.eUD != null) {
            this.eUD.setUserId(str);
        }
        if (this.eUC != null) {
            this.eUC.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.eUD != null) {
            this.eUD.a(imageUrlData);
        }
        if (this.eUC != null) {
            this.eUC.b(imageUrlData);
        }
    }

    private boolean bt(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bt(this.eUE);
    }

    public boolean bts() {
        return this.eUF;
    }

    public void setVisibility(int i) {
        if (this.eUE != null) {
            this.eUE.clearAnimation();
            this.eUE.setVisibility(i);
        }
    }

    public void bd(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.A(this.eUE, i2);
        } else {
            com.baidu.tieba.v.a.z(this.eUE, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.eUC != null) {
            this.eUC.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.eUC != null) {
            this.eUC.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.eUC != null) {
            this.eUC.setOnReplyClickListener(onClickListener);
        }
    }
}
