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
    private ImageViewerBottomLayout fcZ;
    private AbsFloorImageTextView fda;
    private LinearLayout fdb;
    private boolean fdc = true;
    private final ImageViewerBottomLayout.a fdd = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.a.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            a.this.fdc = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(a.this.fdc)));
            a.this.jE(z);
        }
    };
    private Context mContext;

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.fdb = new LinearLayout(context);
        this.fdb.setOrientation(1);
        this.fdb.setVisibility(8);
        ap.a(this.fdb, R.color.cp_mask_b_alpha66, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.fdb, layoutParams);
        bvk();
        bvj();
    }

    private void bvj() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.fdf);
        this.fcZ = new ImageViewerBottomLayout(this.mContext);
        this.fdb.addView(this.fcZ, layoutParams);
        this.fcZ.setExpandButtonListener(this.fdd);
    }

    private void bvk() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fda = new FloorImageTextViewNew(this.mContext);
        this.fdb.addView(this.fda, layoutParams);
    }

    public void jE(boolean z) {
        if (this.fda != null) {
            this.fda.jE(z);
        }
        if (this.fcZ != null) {
            this.fcZ.jF(!z);
        }
    }

    public void setUserId(String str) {
        if (this.fda != null) {
            this.fda.setUserId(str);
        }
        if (this.fcZ != null) {
            this.fcZ.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.fda != null) {
            this.fda.a(imageUrlData);
        }
        if (this.fcZ != null) {
            this.fcZ.b(imageUrlData);
        }
    }

    private boolean bu(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bu(this.fdb);
    }

    public boolean bvl() {
        return this.fdc;
    }

    public void setVisibility(int i) {
        if (this.fdb != null) {
            this.fdb.clearAnimation();
            this.fdb.setVisibility(i);
        }
    }

    public void be(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.B(this.fdb, i2);
        } else {
            com.baidu.tieba.v.a.A(this.fdb, i2);
        }
    }

    public void setOnShareImageListener(ImageViewerBottomLayout.c cVar) {
        if (this.fcZ != null) {
            this.fcZ.setOnShareImageListener(cVar);
        }
    }

    public void setOnDownloadImageListener(ImageViewerBottomLayout.b bVar) {
        if (this.fcZ != null) {
            this.fcZ.setOnDownloadImageListener(bVar);
        }
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        if (this.fcZ != null) {
            this.fcZ.setOnReplyClickListener(onClickListener);
        }
    }
}
