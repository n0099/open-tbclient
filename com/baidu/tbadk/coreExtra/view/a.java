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
    private boolean fuA = true;
    private final ImageViewerBottomLayout.a fuB = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.fuA = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.fuA)));
            a.this.kw(z);
        }
    };
    private ImageViewerBottomLayout fux;
    private AbsFloorImageTextView fuy;
    private LinearLayout fuz;
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fuz = new LinearLayout(context);
        this.fuz.setOrientation(1);
        this.fuz.setVisibility(8);
        ao.a(this.fuz, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.fuz, layoutParams);
        bza();
        byZ();
    }

    private void byZ() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.fuD);
        this.fux = new ImageViewerBottomLayout(this.mContext);
        this.fuz.addView(this.fux, layoutParams);
        this.fux.setExpandButtonListener(this.fuB);
    }

    private void bza() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fuy = new FloorImageTextViewNew(this.mContext);
        this.fuz.addView(this.fuy, layoutParams);
    }

    public void kw(boolean z) {
        if (this.fuy != null) {
            this.fuy.kw(z);
        }
        if (this.fux != null) {
            this.fux.kx(!z);
        }
    }

    public void setUserId(String str) {
        if (this.fuy != null) {
            this.fuy.setUserId(str);
        }
        if (this.fux != null) {
            this.fux.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.fuy != null) {
            this.fuy.a(imageUrlData);
        }
        if (this.fux != null) {
            this.fux.b(imageUrlData);
        }
    }

    private boolean bN(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bN(this.fuz);
    }

    public boolean bzb() {
        return this.fuA;
    }

    public void setVisibility(int i) {
        if (this.fuz != null) {
            this.fuz.clearAnimation();
            this.fuz.setVisibility(i);
        }
    }

    public void be(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.G(this.fuz, i2);
        } else {
            com.baidu.tieba.v.a.F(this.fuz, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fux != null) {
            this.fux.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fux != null) {
            this.fux.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fux != null) {
            this.fux.setOnReplyClickListener(onClickListener);
        }
    }

    public int getBottomHeight() {
        if (this.fux == null || this.fuy == null) {
            return 0;
        }
        return this.fux.getHeight() + AbsFloorImageTextView.ftq;
    }
}
