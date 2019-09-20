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
    private LinearLayout cpd;
    private NestedScrollView cxY;
    protected TbImageView cxZ;
    protected TextView cya;
    protected TextView cyb;
    protected TextView cyc;
    private LinearLayout cyd;
    private int cye;
    Rect cyf;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.cye = 0;
        this.cyf = new Rect();
        this.cxY = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.cpd = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.cxZ = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cya = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cyb = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cyd = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.cyc = (TextView) this.attachedView.findViewById(R.id.net_refresh_button);
        this.cyc.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void qY(String str) {
        if (str == null) {
            this.cya.setVisibility(8);
            return;
        }
        this.cya.setVisibility(0);
        this.cya.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.cyb.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cyc.setText(str);
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
        this.cxZ.setImageResource(0);
    }

    public void atW() {
        this.cyc.setVisibility(0);
        this.cyb.setVisibility(0);
        am.f(this.cya, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.c(this.cxZ, (int) R.drawable.new_pic_emotion_gray_09);
        am.d(this.cya, R.color.cp_cont_d, 1, skinType);
        am.d(this.cyb, R.color.cp_cont_j, 1, skinType);
        am.d(this.cyc, R.color.cp_link_tip_a, 1, skinType);
        am.l(this.attachedView, R.color.cp_bg_line_d);
    }

    public View atX() {
        return this.attachedView;
    }

    public void kL(int i) {
        if (this.cye <= 0) {
            this.cye = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.cxY != null) {
            if (i == 0) {
                this.cxY.post(new Runnable() { // from class: com.baidu.tbadk.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kL(-1);
                    }
                });
            }
            if (this.cxY.getLocalVisibleRect(this.cyf)) {
                int i2 = this.cyf.bottom;
                int abs = Math.abs(this.cpd.getTop());
                int abs2 = i2 - Math.abs(this.cpd.getBottom());
                ViewGroup.LayoutParams layoutParams = this.cpd.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.cye) {
                        marginLayoutParams.topMargin = this.cye;
                        this.cpd.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.cye) {
                        if (abs2 > this.cye) {
                            marginLayoutParams.topMargin = ((abs2 - this.cye) / 2) + this.cye;
                            this.cpd.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.cye) {
                        if (abs2 < this.cye) {
                            marginLayoutParams.topMargin = this.cye;
                        } else if (abs2 == this.cye) {
                            marginLayoutParams.topMargin = this.cye;
                        } else if (abs2 > this.cye) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.cpd.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
