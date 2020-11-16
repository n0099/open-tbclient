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
    private ImageViewerBottomLayout fhX;
    private AbsFloorImageTextView fhY;
    private LinearLayout fhZ;
    private boolean fia = true;
    private final ImageViewerBottomLayout.a fib = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.fia = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.fia)));
            a.this.jO(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fhZ = new LinearLayout(context);
        this.fhZ.setOrientation(1);
        this.fhZ.setVisibility(8);
        ap.a(this.fhZ, R.color.CAM_X0608, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.fhZ, layoutParams);
        bwZ();
        bwY();
    }

    private void bwY() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.fie);
        this.fhX = new ImageViewerBottomLayout(this.mContext);
        this.fhZ.addView(this.fhX, layoutParams);
        this.fhX.setExpandButtonListener(this.fib);
    }

    private void bwZ() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fhY = new FloorImageTextViewNew(this.mContext);
        this.fhZ.addView(this.fhY, layoutParams);
    }

    public void jO(boolean z) {
        if (this.fhY != null) {
            this.fhY.jO(z);
        }
        if (this.fhX != null) {
            this.fhX.jP(!z);
        }
    }

    public void setUserId(String str) {
        if (this.fhY != null) {
            this.fhY.setUserId(str);
        }
        if (this.fhX != null) {
            this.fhX.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.fhY != null) {
            this.fhY.a(imageUrlData);
        }
        if (this.fhX != null) {
            this.fhX.b(imageUrlData);
        }
    }

    private boolean bB(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bB(this.fhZ);
    }

    public boolean bxa() {
        return this.fia;
    }

    public void setVisibility(int i) {
        if (this.fhZ != null) {
            this.fhZ.clearAnimation();
            this.fhZ.setVisibility(i);
        }
    }

    public void be(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.w.a.D(this.fhZ, i2);
        } else {
            com.baidu.tieba.w.a.C(this.fhZ, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fhX != null) {
            this.fhX.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fhX != null) {
            this.fhX.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fhX != null) {
            this.fhX.setOnReplyClickListener(onClickListener);
        }
    }
}
