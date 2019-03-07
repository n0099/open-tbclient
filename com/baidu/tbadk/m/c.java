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
    private LinearLayout ceE;
    protected TextView cnA;
    private LinearLayout cnB;
    private int cnC;
    private NestedScrollView cnw;
    protected TbImageView cnx;
    protected TextView cny;
    protected TextView cnz;
    Rect rect;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.frs_net_refresh_view_layout, (ViewGroup) null));
        this.cnC = 0;
        this.rect = new Rect();
        this.cnw = (NestedScrollView) this.attachedView.findViewById(d.g.scrollview);
        this.ceE = (LinearLayout) this.attachedView.findViewById(d.g.container);
        this.cnx = (TbImageView) this.attachedView.findViewById(d.g.net_refresh_image);
        this.cny = (TextView) this.attachedView.findViewById(d.g.net_refresh_desc);
        this.cnz = (TextView) this.attachedView.findViewById(d.g.net_refresh_title);
        this.cnB = (LinearLayout) this.attachedView.findViewById(d.g.net_refresh_info_layout);
        this.cnA = (TextView) this.attachedView.findViewById(d.g.net_refresh_button);
        this.cnA.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void po(String str) {
        if (str == null) {
            this.cny.setVisibility(8);
            return;
        }
        this.cny.setVisibility(0);
        this.cny.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.cnz.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cnA.setText(str);
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
        this.cnx.setImageResource(0);
    }

    public void anC() {
        this.cnA.setVisibility(0);
        this.cnz.setVisibility(0);
        al.d(this.cny, d.C0236d.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.cnx, d.f.new_pic_emotion_gray_09);
        al.c(this.cny, d.C0236d.cp_cont_d, 1, skinType);
        al.c(this.cnz, d.C0236d.cp_cont_j, 1, skinType);
        al.c(this.cnA, d.C0236d.cp_link_tip_a, 1, skinType);
        al.l(this.attachedView, d.C0236d.cp_bg_line_d);
    }

    public View anD() {
        return this.attachedView;
    }

    public void jO(int i) {
        if (this.cnC <= 0) {
            this.cnC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(d.e.tbds156);
        }
        if (this.cnw != null) {
            if (i == 0) {
                this.cnw.post(new Runnable() { // from class: com.baidu.tbadk.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jO(-1);
                    }
                });
            }
            if (this.cnw.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.ceE.getTop());
                int abs2 = i2 - Math.abs(this.ceE.getBottom());
                ViewGroup.LayoutParams layoutParams = this.ceE.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.cnC) {
                        marginLayoutParams.topMargin = this.cnC;
                        this.ceE.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.cnC) {
                        if (abs2 > this.cnC) {
                            marginLayoutParams.topMargin = ((abs2 - this.cnC) / 2) + this.cnC;
                            this.ceE.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.cnC) {
                        if (abs2 < this.cnC) {
                            marginLayoutParams.topMargin = this.cnC;
                        } else if (abs2 == this.cnC) {
                            marginLayoutParams.topMargin = this.cnC;
                        } else if (abs2 > this.cnC) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.ceE.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
