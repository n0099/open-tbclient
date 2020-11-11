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
    Rect bDL;
    protected TextView bfp;
    private LinearLayout fkc;
    private NestedScrollView fsD;
    protected TbImageView fsE;
    protected TBSpecificationBtn fsF;
    private LinearLayout fsG;
    private int fsH;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.fsH = 0;
        this.bDL = new Rect();
        this.fsD = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.fkc = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.fsE = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bfp = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fsG = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fsF = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fsF.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fsF.setTextSize(R.dimen.tbds42);
        this.fsF.setConfig(aVar);
        this.fsF.setOnClickListener(onClickListener);
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
            this.bfp.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fsF.setText(str);
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
        this.fsE.setImageResource(0);
    }

    public void showRefreshButton() {
        this.fsF.setVisibility(0);
        this.bfp.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fsE, R.drawable.new_pic_emotion_08);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.bfp, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.fsF != null) {
            this.fsF.bsD();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void rC(int i) {
        if (this.fsH <= 0) {
            this.fsH = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.fsD != null) {
            if (i == 0) {
                this.fsD.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rC(-1);
                    }
                });
            }
            if (this.fsD.getLocalVisibleRect(this.bDL)) {
                int i2 = this.bDL.bottom;
                int abs = Math.abs(this.fkc.getTop());
                int abs2 = i2 - Math.abs(this.fkc.getBottom());
                ViewGroup.LayoutParams layoutParams = this.fkc.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.fsH) {
                        marginLayoutParams.topMargin = this.fsH;
                        this.fkc.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.fsH) {
                        if (abs2 > this.fsH) {
                            marginLayoutParams.topMargin = ((abs2 - this.fsH) / 2) + this.fsH;
                            this.fkc.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.fsH) {
                        if (abs2 < this.fsH) {
                            marginLayoutParams.topMargin = this.fsH;
                        } else if (abs2 == this.fsH) {
                            marginLayoutParams.topMargin = this.fsH;
                        } else if (abs2 > this.fsH) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.fkc.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
