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
    private LinearLayout ceG;
    protected TextView cnA;
    protected TextView cnB;
    protected TextView cnC;
    private LinearLayout cnD;
    private int cnE;
    private NestedScrollView cny;
    protected TbImageView cnz;
    Rect rect;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.frs_net_refresh_view_layout, (ViewGroup) null));
        this.cnE = 0;
        this.rect = new Rect();
        this.cny = (NestedScrollView) this.attachedView.findViewById(d.g.scrollview);
        this.ceG = (LinearLayout) this.attachedView.findViewById(d.g.container);
        this.cnz = (TbImageView) this.attachedView.findViewById(d.g.net_refresh_image);
        this.cnA = (TextView) this.attachedView.findViewById(d.g.net_refresh_desc);
        this.cnB = (TextView) this.attachedView.findViewById(d.g.net_refresh_title);
        this.cnD = (LinearLayout) this.attachedView.findViewById(d.g.net_refresh_info_layout);
        this.cnC = (TextView) this.attachedView.findViewById(d.g.net_refresh_button);
        this.cnC.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void pp(String str) {
        if (str == null) {
            this.cnA.setVisibility(8);
            return;
        }
        this.cnA.setVisibility(0);
        this.cnA.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.cnB.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cnC.setText(str);
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
        this.cnz.setImageResource(0);
    }

    public void any() {
        this.cnC.setVisibility(0);
        this.cnB.setVisibility(0);
        al.d(this.cnA, d.C0277d.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.cnz, d.f.new_pic_emotion_gray_09);
        al.c(this.cnA, d.C0277d.cp_cont_d, 1, skinType);
        al.c(this.cnB, d.C0277d.cp_cont_j, 1, skinType);
        al.c(this.cnC, d.C0277d.cp_link_tip_a, 1, skinType);
        al.l(this.attachedView, d.C0277d.cp_bg_line_d);
    }

    public View anz() {
        return this.attachedView;
    }

    public void jN(int i) {
        if (this.cnE <= 0) {
            this.cnE = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.tbds156);
        }
        if (this.cny != null) {
            if (i == 0) {
                this.cny.post(new Runnable() { // from class: com.baidu.tbadk.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jN(-1);
                    }
                });
            }
            if (this.cny.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.ceG.getTop());
                int abs2 = i2 - Math.abs(this.ceG.getBottom());
                ViewGroup.LayoutParams layoutParams = this.ceG.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.cnE) {
                        marginLayoutParams.topMargin = this.cnE;
                        this.ceG.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.cnE) {
                        if (abs2 > this.cnE) {
                            marginLayoutParams.topMargin = ((abs2 - this.cnE) / 2) + this.cnE;
                            this.ceG.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.cnE) {
                        if (abs2 < this.cnE) {
                            marginLayoutParams.topMargin = this.cnE;
                        } else if (abs2 == this.cnE) {
                            marginLayoutParams.topMargin = this.cnE;
                        } else if (abs2 > this.cnE) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.ceG.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
