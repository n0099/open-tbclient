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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends a {
    private LinearLayout ceH;
    protected TbImageView cnA;
    protected TextView cnB;
    protected TextView cnC;
    protected TextView cnD;
    private LinearLayout cnE;
    private int cnF;
    private NestedScrollView cnz;
    Rect rect;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.frs_net_refresh_view_layout, (ViewGroup) null));
        this.cnF = 0;
        this.rect = new Rect();
        this.cnz = (NestedScrollView) this.attachedView.findViewById(d.g.scrollview);
        this.ceH = (LinearLayout) this.attachedView.findViewById(d.g.container);
        this.cnA = (TbImageView) this.attachedView.findViewById(d.g.net_refresh_image);
        this.cnB = (TextView) this.attachedView.findViewById(d.g.net_refresh_desc);
        this.cnC = (TextView) this.attachedView.findViewById(d.g.net_refresh_title);
        this.cnE = (LinearLayout) this.attachedView.findViewById(d.g.net_refresh_info_layout);
        this.cnD = (TextView) this.attachedView.findViewById(d.g.net_refresh_button);
        this.cnD.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void pp(String str) {
        if (str == null) {
            this.cnB.setVisibility(8);
            return;
        }
        this.cnB.setVisibility(0);
        this.cnB.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.cnC.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cnD.setText(str);
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
        this.cnA.setImageResource(0);
    }

    public void any() {
        this.cnD.setVisibility(0);
        this.cnC.setVisibility(0);
        al.d(this.cnB, d.C0277d.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.cnA, d.f.new_pic_emotion_gray_09);
        al.c(this.cnB, d.C0277d.cp_cont_d, 1, skinType);
        al.c(this.cnC, d.C0277d.cp_cont_j, 1, skinType);
        al.c(this.cnD, d.C0277d.cp_link_tip_a, 1, skinType);
        al.l(this.attachedView, d.C0277d.cp_bg_line_d);
    }

    public View anz() {
        return this.attachedView;
    }

    public void jN(int i) {
        if (this.cnF <= 0) {
            this.cnF = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.tbds156);
        }
        if (this.cnz != null) {
            if (i == 0) {
                this.cnz.post(new Runnable() { // from class: com.baidu.tbadk.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jN(-1);
                    }
                });
            }
            if (this.cnz.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.ceH.getTop());
                int abs2 = i2 - Math.abs(this.ceH.getBottom());
                ViewGroup.LayoutParams layoutParams = this.ceH.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.cnF) {
                        marginLayoutParams.topMargin = this.cnF;
                        this.ceH.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.cnF) {
                        if (abs2 > this.cnF) {
                            marginLayoutParams.topMargin = ((abs2 - this.cnF) / 2) + this.cnF;
                            this.ceH.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.cnF) {
                        if (abs2 < this.cnF) {
                            marginLayoutParams.topMargin = this.cnF;
                        } else if (abs2 == this.cnF) {
                            marginLayoutParams.topMargin = this.cnF;
                        } else if (abs2 > this.cnF) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.ceH.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
