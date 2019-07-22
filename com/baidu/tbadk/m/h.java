package com.baidu.tbadk.m;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.EmotionButton;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView cwW;
    protected TextView cwX;
    protected TextView cwY;
    private LinearLayout cxa;
    protected EmotionButton cxk;
    private int cxl;

    public TextView getTitleView() {
        return this.cwY;
    }

    public EmotionButton atO() {
        return this.cxk;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.cwW = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cwX = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cwY = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cxa = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.cxk = (EmotionButton) this.attachedView.findViewById(R.id.net_refresh_button);
        this.cxl = R.drawable.new_pic_emotion_09;
        this.cxk.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        kL(0);
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

    public void qO(String str) {
        if (str != null) {
            this.cwY.setText(str);
            this.cwY.setVisibility(0);
        }
    }

    public void kI(int i) {
        this.cxl = i;
    }

    public void kJ(int i) {
        this.cwW.setImageResource(i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cxk.setText(str);
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

    public void kK(int i) {
        ViewGroup.LayoutParams layoutParams = this.cwW.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.cwW.setLayoutParams(marginLayoutParams);
        }
    }

    public void kL(int i) {
        int i2;
        if (i < 0) {
            i = 0;
        }
        int ah = l.ah(TbadkCoreApplication.getInst());
        if (ah <= 0) {
            i2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200);
        } else {
            i2 = (int) (ah * 0.11d);
        }
        ViewGroup.LayoutParams layoutParams = this.cwW.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.cwW.setLayoutParams(marginLayoutParams);
        }
    }

    public void atI() {
        this.cxk.setVisibility(0);
        this.cwY.setVisibility(0);
        am.f(this.cwX, R.color.cp_cont_d, 1);
    }

    public void atP() {
        this.cxk.setVisibility(8);
        this.cwY.setVisibility(8);
        am.f(this.cwX, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.c(this.cwW, this.cxl);
        am.d(this.cwX, R.color.cp_cont_d, 1, skinType);
        am.d(this.cwY, R.color.cp_cont_j, 1, skinType);
        am.l(this.attachedView, R.color.cp_bg_line_d);
    }

    public View atJ() {
        return this.attachedView;
    }
}
