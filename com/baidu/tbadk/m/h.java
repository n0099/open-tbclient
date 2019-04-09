package com.baidu.tbadk.m;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.EmotionButton;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView cnA;
    protected TextView cnB;
    protected TextView cnC;
    private LinearLayout cnE;
    protected EmotionButton cnN;
    private int cnO;

    public TextView getTitleView() {
        return this.cnC;
    }

    public EmotionButton anD() {
        return this.cnN;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.cnA = (TbImageView) this.attachedView.findViewById(d.g.net_refresh_image);
        this.cnB = (TextView) this.attachedView.findViewById(d.g.net_refresh_desc);
        this.cnC = (TextView) this.attachedView.findViewById(d.g.net_refresh_title);
        this.cnE = (LinearLayout) this.attachedView.findViewById(d.g.net_refresh_info_layout);
        this.cnN = (EmotionButton) this.attachedView.findViewById(d.g.net_refresh_button);
        this.cnO = d.f.new_pic_emotion_09;
        this.cnN.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        jR(0);
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

    public void pq(String str) {
        if (str != null) {
            this.cnC.setText(str);
            this.cnC.setVisibility(0);
        }
    }

    public void jO(int i) {
        this.cnO = i;
    }

    public void jP(int i) {
        this.cnA.setImageResource(i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cnN.setText(str);
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

    public void jQ(int i) {
        ViewGroup.LayoutParams layoutParams = this.cnA.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.cnA.setLayoutParams(marginLayoutParams);
        }
    }

    public void jR(int i) {
        int i2;
        if (i < 0) {
            i = 0;
        }
        int aQ = l.aQ(TbadkCoreApplication.getInst());
        if (aQ <= 0) {
            i2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds200);
        } else {
            i2 = (int) (aQ * 0.11d);
        }
        ViewGroup.LayoutParams layoutParams = this.cnA.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.cnA.setLayoutParams(marginLayoutParams);
        }
    }

    public void any() {
        this.cnN.setVisibility(0);
        this.cnC.setVisibility(0);
        al.d(this.cnB, d.C0277d.cp_cont_d, 1);
    }

    public void anE() {
        this.cnN.setVisibility(8);
        this.cnC.setVisibility(8);
        al.d(this.cnB, d.C0277d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.cnA, this.cnO);
        al.c(this.cnB, d.C0277d.cp_cont_d, 1, skinType);
        al.c(this.cnC, d.C0277d.cp_cont_j, 1, skinType);
        al.l(this.attachedView, d.C0277d.cp_bg_line_d);
    }

    public View anz() {
        return this.attachedView;
    }
}
