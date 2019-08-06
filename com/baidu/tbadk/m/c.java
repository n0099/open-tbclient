package com.baidu.tbadk.m;

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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private LinearLayout coi;
    private NestedScrollView cxc;
    protected TbImageView cxd;
    protected TextView cxe;
    protected TextView cxf;
    protected TextView cxg;
    private LinearLayout cxh;
    private int cxi;
    Rect cxj;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.cxi = 0;
        this.cxj = new Rect();
        this.cxc = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.coi = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.cxd = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cxe = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cxf = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cxh = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.cxg = (TextView) this.attachedView.findViewById(R.id.net_refresh_button);
        this.cxg.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void qN(String str) {
        if (str == null) {
            this.cxe.setVisibility(8);
            return;
        }
        this.cxe.setVisibility(0);
        this.cxe.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.cxf.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cxg.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        super.onViewDettached();
        this.cxd.setImageResource(0);
    }

    public void atK() {
        this.cxg.setVisibility(0);
        this.cxf.setVisibility(0);
        am.f(this.cxe, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.c(this.cxd, (int) R.drawable.new_pic_emotion_gray_09);
        am.d(this.cxe, R.color.cp_cont_d, 1, skinType);
        am.d(this.cxf, R.color.cp_cont_j, 1, skinType);
        am.d(this.cxg, R.color.cp_link_tip_a, 1, skinType);
        am.l(this.attachedView, R.color.cp_bg_line_d);
    }

    public View atL() {
        return this.attachedView;
    }

    public void kI(int i) {
        if (this.cxi <= 0) {
            this.cxi = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.cxc != null) {
            if (i == 0) {
                this.cxc.post(new Runnable() { // from class: com.baidu.tbadk.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kI(-1);
                    }
                });
            }
            if (this.cxc.getLocalVisibleRect(this.cxj)) {
                int i2 = this.cxj.bottom;
                int abs = Math.abs(this.coi.getTop());
                int abs2 = i2 - Math.abs(this.coi.getBottom());
                ViewGroup.LayoutParams layoutParams = this.coi.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.cxi) {
                        marginLayoutParams.topMargin = this.cxi;
                        this.coi.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.cxi) {
                        if (abs2 > this.cxi) {
                            marginLayoutParams.topMargin = ((abs2 - this.cxi) / 2) + this.cxi;
                            this.coi.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.cxi) {
                        if (abs2 < this.cxi) {
                            marginLayoutParams.topMargin = this.cxi;
                        } else if (abs2 == this.cxi) {
                            marginLayoutParams.topMargin = this.cxi;
                        } else if (abs2 > this.cxi) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.coi.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
