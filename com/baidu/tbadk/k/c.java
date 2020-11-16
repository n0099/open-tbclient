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
    Rect bCa;
    protected TextView bdB;
    private LinearLayout fjk;
    private NestedScrollView frL;
    protected TbImageView frM;
    protected TBSpecificationBtn frN;
    private LinearLayout frO;
    private int frP;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.frP = 0;
        this.bCa = new Rect();
        this.frL = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.fjk = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.frM = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bdB = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.frO = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.frN = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.frN.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.frN.setTextSize(R.dimen.tbds42);
        this.frN.setConfig(aVar);
        this.frN.setOnClickListener(onClickListener);
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
            this.bdB.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.frN.setText(str);
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
        this.frM.setImageResource(0);
    }

    public void showRefreshButton() {
        this.frN.setVisibility(0);
        this.bdB.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.frM, R.drawable.new_pic_emotion_08);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1, skinType);
        ap.setViewTextColor(this.bdB, R.color.CAM_X0107, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
        if (this.frN != null) {
            this.frN.brT();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void sa(int i) {
        if (this.frP <= 0) {
            this.frP = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.frL != null) {
            if (i == 0) {
                this.frL.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.sa(-1);
                    }
                });
            }
            if (this.frL.getLocalVisibleRect(this.bCa)) {
                int i2 = this.bCa.bottom;
                int abs = Math.abs(this.fjk.getTop());
                int abs2 = i2 - Math.abs(this.fjk.getBottom());
                ViewGroup.LayoutParams layoutParams = this.fjk.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.frP) {
                        marginLayoutParams.topMargin = this.frP;
                        this.fjk.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.frP) {
                        if (abs2 > this.frP) {
                            marginLayoutParams.topMargin = ((abs2 - this.frP) / 2) + this.frP;
                            this.fjk.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.frP) {
                        if (abs2 < this.frP) {
                            marginLayoutParams.topMargin = this.frP;
                        } else if (abs2 == this.frP) {
                            marginLayoutParams.topMargin = this.frP;
                        } else if (abs2 > this.frP) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.fjk.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
