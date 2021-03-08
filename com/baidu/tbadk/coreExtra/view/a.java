package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private ImageViewerBottomLayout fym;
    private AbsFloorImageTextView fyn;
    private LinearLayout fyo;
    private boolean fyp = true;
    private final ImageViewerBottomLayout.a fyq = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.fyp = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.fyp)));
            a.this.kz(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fyo = new LinearLayout(context);
        this.fyo.setOrientation(1);
        this.fyo.setVisibility(8);
        ap.a(this.fyo, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.fyo, layoutParams);
        bzv();
        bzu();
    }

    private void bzu() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.fys);
        this.fym = new ImageViewerBottomLayout(this.mContext);
        this.fyo.addView(this.fym, layoutParams);
        this.fym.setExpandButtonListener(this.fyq);
    }

    private void bzv() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fyn = new FloorImageTextViewNew(this.mContext);
        this.fyo.addView(this.fyn, layoutParams);
    }

    public void kz(boolean z) {
        if (this.fyn != null) {
            this.fyn.kz(z);
        }
        if (this.fym != null) {
            this.fym.kA(!z);
        }
    }

    public void setUserId(String str) {
        if (this.fyn != null) {
            this.fyn.setUserId(str);
        }
        if (this.fym != null) {
            this.fym.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.fyn != null) {
            this.fyn.a(imageUrlData);
        }
        if (this.fym != null) {
            this.fym.b(imageUrlData);
        }
    }

    private boolean bJ(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bJ(this.fyo);
    }

    public boolean bzw() {
        return this.fyp;
    }

    public void setVisibility(int i) {
        if (this.fyo != null) {
            this.fyo.clearAnimation();
            this.fyo.setVisibility(i);
        }
    }

    public void bb(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.G(this.fyo, i2);
        } else {
            com.baidu.tieba.v.a.F(this.fyo, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fym != null) {
            this.fym.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fym != null) {
            this.fym.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fym != null) {
            this.fym.setOnReplyClickListener(onClickListener);
        }
    }

    public int getBottomHeight() {
        if (this.fym == null || this.fyn == null) {
            return 0;
        }
        return this.fym.getHeight() + AbsFloorImageTextView.fxg;
    }
}
