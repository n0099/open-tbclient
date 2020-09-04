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
    protected TextView aWR;
    private LinearLayout eHz;
    private NestedScrollView ePm;
    protected TbImageView ePn;
    protected TBSpecificationBtn ePo;
    private LinearLayout ePp;
    private int ePq;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.ePq = 0;
        this.rect = new Rect();
        this.ePm = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.eHz = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.ePn = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aWR = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.ePp = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.ePo = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.ePo.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.ePo.setTextSize(R.dimen.tbds42);
        this.ePo.setConfig(aVar);
        this.ePo.setOnClickListener(onClickListener);
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
            this.aWR.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.ePo.setText(str);
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
        this.ePn.setImageResource(0);
    }

    public void showRefreshButton() {
        this.ePo.setVisibility(0);
        this.aWR.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.ePn, R.drawable.new_pic_emotion_08);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.aWR, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.ePo != null) {
            this.ePo.bkF();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void qs(int i) {
        if (this.ePq <= 0) {
            this.ePq = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.ePm != null) {
            if (i == 0) {
                this.ePm.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.qs(-1);
                    }
                });
            }
            if (this.ePm.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.eHz.getTop());
                int abs2 = i2 - Math.abs(this.eHz.getBottom());
                ViewGroup.LayoutParams layoutParams = this.eHz.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.ePq) {
                        marginLayoutParams.topMargin = this.ePq;
                        this.eHz.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.ePq) {
                        if (abs2 > this.ePq) {
                            marginLayoutParams.topMargin = ((abs2 - this.ePq) / 2) + this.ePq;
                            this.eHz.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.ePq) {
                        if (abs2 < this.ePq) {
                            marginLayoutParams.topMargin = this.ePq;
                        } else if (abs2 == this.ePq) {
                            marginLayoutParams.topMargin = this.ePq;
                        } else if (abs2 > this.ePq) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.eHz.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
