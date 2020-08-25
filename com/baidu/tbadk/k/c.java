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
/* loaded from: classes2.dex */
public class c extends a {
    protected TextView aWP;
    private LinearLayout eHv;
    private NestedScrollView ePi;
    protected TbImageView ePj;
    protected TBSpecificationBtn ePk;
    private LinearLayout ePl;
    private int ePm;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.ePm = 0;
        this.rect = new Rect();
        this.ePi = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.eHv = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.ePj = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aWP = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.ePl = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.ePk = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.ePk.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.ePk.setTextSize(R.dimen.tbds42);
        this.ePk.setConfig(aVar);
        this.ePk.setOnClickListener(onClickListener);
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
            this.aWP.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.ePk.setText(str);
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
        this.ePj.setImageResource(0);
    }

    public void showRefreshButton() {
        this.ePk.setVisibility(0);
        this.aWP.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.ePj, R.drawable.new_pic_emotion_08);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.aWP, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.ePk != null) {
            this.ePk.bkF();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void qs(int i) {
        if (this.ePm <= 0) {
            this.ePm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.ePi != null) {
            if (i == 0) {
                this.ePi.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.qs(-1);
                    }
                });
            }
            if (this.ePi.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.eHv.getTop());
                int abs2 = i2 - Math.abs(this.eHv.getBottom());
                ViewGroup.LayoutParams layoutParams = this.eHv.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.ePm) {
                        marginLayoutParams.topMargin = this.ePm;
                        this.eHv.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.ePm) {
                        if (abs2 > this.ePm) {
                            marginLayoutParams.topMargin = ((abs2 - this.ePm) / 2) + this.ePm;
                            this.eHv.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.ePm) {
                        if (abs2 < this.ePm) {
                            marginLayoutParams.topMargin = this.ePm;
                        } else if (abs2 == this.ePm) {
                            marginLayoutParams.topMargin = this.ePm;
                        } else if (abs2 > this.ePm) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.eHv.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
