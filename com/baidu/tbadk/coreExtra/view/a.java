package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    private ImageViewerBottomLayout fzf;
    private AbsFloorImageTextView fzg;
    private LinearLayout fzh;
    private boolean fzi = true;
    private final ImageViewerBottomLayout.a fzj = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.fzi = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.fzi)));
            a.this.kA(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fzh = new LinearLayout(context);
        this.fzh.setOrientation(1);
        this.fzh.setVisibility(8);
        ao.a(this.fzh, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.fzh, layoutParams);
        bCT();
        bCS();
    }

    private void bCS() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.fzl);
        this.fzf = new ImageViewerBottomLayout(this.mContext);
        this.fzh.addView(this.fzf, layoutParams);
        this.fzf.setExpandButtonListener(this.fzj);
    }

    private void bCT() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fzg = new FloorImageTextViewNew(this.mContext);
        this.fzh.addView(this.fzg, layoutParams);
    }

    public void kA(boolean z) {
        if (this.fzg != null) {
            this.fzg.kA(z);
        }
        if (this.fzf != null) {
            this.fzf.kB(!z);
        }
    }

    public void setUserId(String str) {
        if (this.fzg != null) {
            this.fzg.setUserId(str);
        }
        if (this.fzf != null) {
            this.fzf.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.fzg != null) {
            this.fzg.a(imageUrlData);
        }
        if (this.fzf != null) {
            this.fzf.b(imageUrlData);
        }
    }

    private boolean bN(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bN(this.fzh);
    }

    public boolean bCU() {
        return this.fzi;
    }

    public void setVisibility(int i) {
        if (this.fzh != null) {
            this.fzh.clearAnimation();
            this.fzh.setVisibility(i);
        }
    }

    public void be(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.G(this.fzh, i2);
        } else {
            com.baidu.tieba.v.a.F(this.fzh, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fzf != null) {
            this.fzf.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fzf != null) {
            this.fzf.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fzf != null) {
            this.fzf.setOnReplyClickListener(onClickListener);
        }
    }

    public int getBottomHeight() {
        if (this.fzf == null || this.fzg == null) {
            return 0;
        }
        return this.fzf.getHeight() + AbsFloorImageTextView.fxY;
    }
}
