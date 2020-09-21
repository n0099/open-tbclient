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
/* loaded from: classes20.dex */
public class a {
    private ImageViewerBottomLayout eIv;
    private AbsFloorImageTextView eIw;
    private LinearLayout eIx;
    private boolean eIy = true;
    private final ImageViewerBottomLayout.a eIz = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.eIy = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.eIy)));
            a.this.iT(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.eIx = new LinearLayout(context);
        this.eIx.setOrientation(1);
        this.eIx.setVisibility(8);
        ap.a(this.eIx, R.color.cp_mask_b_alpha66, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.eIx, layoutParams);
        bqH();
        bqG();
    }

    private void bqG() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.eIB);
        this.eIv = new ImageViewerBottomLayout(this.mContext);
        this.eIx.addView(this.eIv, layoutParams);
        this.eIv.setExpandButtonListener(this.eIz);
    }

    private void bqH() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eIw = new FloorImageTextViewNew(this.mContext);
        this.eIx.addView(this.eIw, layoutParams);
    }

    public void iT(boolean z) {
        if (this.eIw != null) {
            this.eIw.iT(z);
        }
        if (this.eIv != null) {
            this.eIv.iU(!z);
        }
    }

    public void setUserId(String str) {
        if (this.eIw != null) {
            this.eIw.setUserId(str);
        }
        if (this.eIv != null) {
            this.eIv.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.eIw != null) {
            this.eIw.a(imageUrlData);
        }
        if (this.eIv != null) {
            this.eIv.b(imageUrlData);
        }
    }

    private boolean bp(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bp(this.eIx);
    }

    public boolean bqI() {
        return this.eIy;
    }

    public void setVisibility(int i) {
        if (this.eIx != null) {
            this.eIx.clearAnimation();
            this.eIx.setVisibility(i);
        }
    }

    public void be(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.z(this.eIx, i2);
        } else {
            com.baidu.tieba.v.a.y(this.eIx, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.eIv != null) {
            this.eIv.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.eIv != null) {
            this.eIv.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.eIv != null) {
            this.eIv.setOnReplyClickListener(onClickListener);
        }
    }
}
