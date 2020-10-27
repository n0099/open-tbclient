package com.baidu.tbadk.k;

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
    protected TextView bdT;
    Rect bxA;
    private LinearLayout fej;
    private NestedScrollView fmK;
    protected TbImageView fmL;
    protected TBSpecificationBtn fmM;
    private LinearLayout fmN;
    private int fmO;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.fmO = 0;
        this.bxA = new Rect();
        this.fmK = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.fej = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.fmL = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bdT = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fmN = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fmM = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fmM.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fmM.setTextSize(R.dimen.tbds42);
        this.fmM.setConfig(aVar);
        this.fmM.setOnClickListener(onClickListener);
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
            this.bdT.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fmM.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        super.onViewDettached();
        this.fmL.setImageResource(0);
    }

    public void showRefreshButton() {
        this.fmM.setVisibility(0);
        this.bdT.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fmL, R.drawable.new_pic_emotion_08);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.bdT, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.fmM != null) {
            this.fmM.bqd();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void rs(int i) {
        if (this.fmO <= 0) {
            this.fmO = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.fmK != null) {
            if (i == 0) {
                this.fmK.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rs(-1);
                    }
                });
            }
            if (this.fmK.getLocalVisibleRect(this.bxA)) {
                int i2 = this.bxA.bottom;
                int abs = Math.abs(this.fej.getTop());
                int abs2 = i2 - Math.abs(this.fej.getBottom());
                ViewGroup.LayoutParams layoutParams = this.fej.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.fmO) {
                        marginLayoutParams.topMargin = this.fmO;
                        this.fej.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.fmO) {
                        if (abs2 > this.fmO) {
                            marginLayoutParams.topMargin = ((abs2 - this.fmO) / 2) + this.fmO;
                            this.fej.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.fmO) {
                        if (abs2 < this.fmO) {
                            marginLayoutParams.topMargin = this.fmO;
                        } else if (abs2 == this.fmO) {
                            marginLayoutParams.topMargin = this.fmO;
                        } else if (abs2 > this.fmO) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.fej.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
