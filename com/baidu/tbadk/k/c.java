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
    protected TextView aHO;
    private LinearLayout dTF;
    private NestedScrollView ebi;
    protected TbImageView ebj;
    protected TBSpecificationBtn ebk;
    private LinearLayout ebl;
    private int ebm;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.ebm = 0;
        this.rect = new Rect();
        this.ebi = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.dTF = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.ebj = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aHO = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.ebl = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.ebk = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.ebk.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.ebk.setTextSize(R.dimen.tbds42);
        this.ebk.setConfig(bVar);
        this.ebk.setOnClickListener(onClickListener);
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
            this.aHO.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.ebk.setText(str);
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
        this.ebj.setImageResource(0);
    }

    public void showRefreshButton() {
        this.ebk.setVisibility(0);
        this.aHO.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.ebj, R.drawable.new_pic_emotion_08);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.aHO, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.ebk != null) {
            this.ebk.aQp();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void mQ(int i) {
        if (this.ebm <= 0) {
            this.ebm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.ebi != null) {
            if (i == 0) {
                this.ebi.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.mQ(-1);
                    }
                });
            }
            if (this.ebi.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.dTF.getTop());
                int abs2 = i2 - Math.abs(this.dTF.getBottom());
                ViewGroup.LayoutParams layoutParams = this.dTF.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.ebm) {
                        marginLayoutParams.topMargin = this.ebm;
                        this.dTF.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.ebm) {
                        if (abs2 > this.ebm) {
                            marginLayoutParams.topMargin = ((abs2 - this.ebm) / 2) + this.ebm;
                            this.dTF.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.ebm) {
                        if (abs2 < this.ebm) {
                            marginLayoutParams.topMargin = this.ebm;
                        } else if (abs2 == this.ebm) {
                            marginLayoutParams.topMargin = this.ebm;
                        } else if (abs2 > this.ebm) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.dTF.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
