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
    private LinearLayout cnB;
    protected EmotionButton cnK;
    private int cnL;
    protected TbImageView cnx;
    protected TextView cny;
    protected TextView cnz;

    public TextView getTitleView() {
        return this.cnz;
    }

    public EmotionButton anG() {
        return this.cnK;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.cnx = (TbImageView) this.attachedView.findViewById(d.g.net_refresh_image);
        this.cny = (TextView) this.attachedView.findViewById(d.g.net_refresh_desc);
        this.cnz = (TextView) this.attachedView.findViewById(d.g.net_refresh_title);
        this.cnB = (LinearLayout) this.attachedView.findViewById(d.g.net_refresh_info_layout);
        this.cnK = (EmotionButton) this.attachedView.findViewById(d.g.net_refresh_button);
        this.cnL = d.f.new_pic_emotion_09;
        this.cnK.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        jS(0);
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

    public void pp(String str) {
        if (str != null) {
            this.cnz.setText(str);
            this.cnz.setVisibility(0);
        }
    }

    public void jP(int i) {
        this.cnL = i;
    }

    public void jQ(int i) {
        this.cnx.setImageResource(i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cnK.setText(str);
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

    public void jR(int i) {
        ViewGroup.LayoutParams layoutParams = this.cnx.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.cnx.setLayoutParams(marginLayoutParams);
        }
    }

    public void jS(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.cnx.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.cnx.setLayoutParams(marginLayoutParams);
        }
    }

    public void anB() {
        this.cnK.setVisibility(0);
        this.cnz.setVisibility(0);
        al.d(this.cny, d.C0277d.cp_cont_d, 1);
    }

    public void anH() {
        this.cnK.setVisibility(8);
        this.cnz.setVisibility(8);
        al.d(this.cny, d.C0277d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.cnx, this.cnL);
        al.c(this.cny, d.C0277d.cp_cont_d, 1, skinType);
        al.c(this.cnz, d.C0277d.cp_cont_j, 1, skinType);
        al.l(this.attachedView, d.C0277d.cp_bg_line_d);
    }

    public View anC() {
        return this.attachedView;
    }
}
