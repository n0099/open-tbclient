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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private LinearLayout dpb;
    private NestedScrollView dwP;
    protected TbImageView dwQ;
    protected TextView dwR;
    protected TBSpecificationBtn dwS;
    private LinearLayout dwT;
    private int dwU;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.dwU = 0;
        this.rect = new Rect();
        this.dwP = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.dpb = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.dwQ = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dwR = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.dwT = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.dwS = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dwS.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.dwS.setTextSize(R.dimen.tbds42);
        this.dwS.setConfig(bVar);
        this.dwS.setOnClickListener(onClickListener);
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
            this.dwR.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.dwS.setText(str);
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
        this.dwQ.setImageResource(0);
    }

    public void showRefreshButton() {
        this.dwS.setVisibility(0);
        this.dwR.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.dwQ, R.drawable.new_pic_emotion_08);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.dwR, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.dwS != null) {
            this.dwS.aFw();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void ml(int i) {
        if (this.dwU <= 0) {
            this.dwU = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.dwP != null) {
            if (i == 0) {
                this.dwP.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ml(-1);
                    }
                });
            }
            if (this.dwP.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.dpb.getTop());
                int abs2 = i2 - Math.abs(this.dpb.getBottom());
                ViewGroup.LayoutParams layoutParams = this.dpb.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.dwU) {
                        marginLayoutParams.topMargin = this.dwU;
                        this.dpb.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.dwU) {
                        if (abs2 > this.dwU) {
                            marginLayoutParams.topMargin = ((abs2 - this.dwU) / 2) + this.dwU;
                            this.dpb.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.dwU) {
                        if (abs2 < this.dwU) {
                            marginLayoutParams.topMargin = this.dwU;
                        } else if (abs2 == this.dwU) {
                            marginLayoutParams.topMargin = this.dwU;
                        } else if (abs2 > this.dwU) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.dpb.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
