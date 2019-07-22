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
    private LinearLayout cob;
    private NestedScrollView cwV;
    protected TbImageView cwW;
    protected TextView cwX;
    protected TextView cwY;
    protected TextView cwZ;
    private LinearLayout cxa;
    private int cxb;
    Rect cxc;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.cxb = 0;
        this.cxc = new Rect();
        this.cwV = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.cob = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.cwW = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cwX = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cwY = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cxa = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.cwZ = (TextView) this.attachedView.findViewById(R.id.net_refresh_button);
        this.cwZ.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void qN(String str) {
        if (str == null) {
            this.cwX.setVisibility(8);
            return;
        }
        this.cwX.setVisibility(0);
        this.cwX.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.cwY.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cwZ.setText(str);
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
        this.cwW.setImageResource(0);
    }

    public void atI() {
        this.cwZ.setVisibility(0);
        this.cwY.setVisibility(0);
        am.f(this.cwX, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.c(this.cwW, (int) R.drawable.new_pic_emotion_gray_09);
        am.d(this.cwX, R.color.cp_cont_d, 1, skinType);
        am.d(this.cwY, R.color.cp_cont_j, 1, skinType);
        am.d(this.cwZ, R.color.cp_link_tip_a, 1, skinType);
        am.l(this.attachedView, R.color.cp_bg_line_d);
    }

    public View atJ() {
        return this.attachedView;
    }

    public void kH(int i) {
        if (this.cxb <= 0) {
            this.cxb = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.cwV != null) {
            if (i == 0) {
                this.cwV.post(new Runnable() { // from class: com.baidu.tbadk.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kH(-1);
                    }
                });
            }
            if (this.cwV.getLocalVisibleRect(this.cxc)) {
                int i2 = this.cxc.bottom;
                int abs = Math.abs(this.cob.getTop());
                int abs2 = i2 - Math.abs(this.cob.getBottom());
                ViewGroup.LayoutParams layoutParams = this.cob.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.cxb) {
                        marginLayoutParams.topMargin = this.cxb;
                        this.cob.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.cxb) {
                        if (abs2 > this.cxb) {
                            marginLayoutParams.topMargin = ((abs2 - this.cxb) / 2) + this.cxb;
                            this.cob.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.cxb) {
                        if (abs2 < this.cxb) {
                            marginLayoutParams.topMargin = this.cxb;
                        } else if (abs2 == this.cxb) {
                            marginLayoutParams.topMargin = this.cxb;
                        } else if (abs2 > this.cxb) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.cob.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
