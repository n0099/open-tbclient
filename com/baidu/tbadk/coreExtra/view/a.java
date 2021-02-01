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
    private ImageViewerBottomLayout fwN;
    private AbsFloorImageTextView fwO;
    private LinearLayout fwP;
    private boolean fwQ = true;
    private final ImageViewerBottomLayout.a fwR = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.fwQ = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.fwQ)));
            a.this.kz(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fwP = new LinearLayout(context);
        this.fwP.setOrientation(1);
        this.fwP.setVisibility(8);
        ap.a(this.fwP, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.fwP, layoutParams);
        bzs();
        bzr();
    }

    private void bzr() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.fwT);
        this.fwN = new ImageViewerBottomLayout(this.mContext);
        this.fwP.addView(this.fwN, layoutParams);
        this.fwN.setExpandButtonListener(this.fwR);
    }

    private void bzs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fwO = new FloorImageTextViewNew(this.mContext);
        this.fwP.addView(this.fwO, layoutParams);
    }

    public void kz(boolean z) {
        if (this.fwO != null) {
            this.fwO.kz(z);
        }
        if (this.fwN != null) {
            this.fwN.kA(!z);
        }
    }

    public void setUserId(String str) {
        if (this.fwO != null) {
            this.fwO.setUserId(str);
        }
        if (this.fwN != null) {
            this.fwN.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.fwO != null) {
            this.fwO.a(imageUrlData);
        }
        if (this.fwN != null) {
            this.fwN.b(imageUrlData);
        }
    }

    private boolean bJ(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bJ(this.fwP);
    }

    public boolean bzt() {
        return this.fwQ;
    }

    public void setVisibility(int i) {
        if (this.fwP != null) {
            this.fwP.clearAnimation();
            this.fwP.setVisibility(i);
        }
    }

    public void bb(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.G(this.fwP, i2);
        } else {
            com.baidu.tieba.v.a.F(this.fwP, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fwN != null) {
            this.fwN.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fwN != null) {
            this.fwN.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fwN != null) {
            this.fwN.setOnReplyClickListener(onClickListener);
        }
    }

    public int getBottomHeight() {
        if (this.fwN == null || this.fwO == null) {
            return 0;
        }
        return this.fwN.getHeight() + AbsFloorImageTextView.fvH;
    }
}
