package com.baidu.tbadk.l;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    Rect bHi;
    protected TextView bhK;
    private LinearLayout fqI;
    protected TbImageView fzA;
    protected TBSpecificationBtn fzB;
    private LinearLayout fzC;
    private int fzD;
    private NestedScrollView fzz;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.fzD = 0;
        this.bHi = new Rect();
        this.fzz = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.fqI = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.fzA = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bhK = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fzC = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fzB = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fzB.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fzB.setTextSize(R.dimen.tbds42);
        this.fzB.setConfig(aVar);
        this.fzB.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bhK.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fzB.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.l.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.l.a
    public void onViewDettached() {
        super.onViewDettached();
        this.fzA.setImageResource(0);
    }

    public void showRefreshButton() {
        this.fzB.setVisibility(0);
        this.bhK.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fzA, R.drawable.new_pic_emotion_08);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
        ap.setViewTextColor(this.bhK, R.color.CAM_X0107, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        if (this.fzB != null) {
            this.fzB.bvt();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void sB(int i) {
        if (this.fzD <= 0) {
            this.fzD = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.fzz != null) {
            if (i == 0) {
                this.fzz.post(new Runnable() { // from class: com.baidu.tbadk.l.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.sB(-1);
                    }
                });
            }
            if (this.fzz.getLocalVisibleRect(this.bHi)) {
                int i2 = this.bHi.bottom;
                int abs = Math.abs(this.fqI.getTop());
                int abs2 = i2 - Math.abs(this.fqI.getBottom());
                ViewGroup.LayoutParams layoutParams = this.fqI.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.fzD) {
                        marginLayoutParams.topMargin = this.fzD;
                        this.fqI.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.fzD) {
                        if (abs2 > this.fzD) {
                            marginLayoutParams.topMargin = ((abs2 - this.fzD) / 2) + this.fzD;
                            this.fqI.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.fzD) {
                        if (abs2 < this.fzD) {
                            marginLayoutParams.topMargin = this.fzD;
                        } else if (abs2 == this.fzD) {
                            marginLayoutParams.topMargin = this.fzD;
                        } else if (abs2 > this.fzD) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.fqI.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
