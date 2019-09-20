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
    protected TbImageView cxZ;
    protected TextView cya;
    protected TextView cyb;
    private LinearLayout cyd;
    protected EmotionButton cyn;
    private int cyo;

    public TextView getTitleView() {
        return this.cyb;
    }

    public EmotionButton auc() {
        return this.cyn;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.cxZ = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cya = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cyb = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cyd = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.cyn = (EmotionButton) this.attachedView.findViewById(R.id.net_refresh_button);
        this.cyo = R.drawable.new_pic_emotion_09;
        this.cyn.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        kP(0);
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

    public void qZ(String str) {
        if (str != null) {
            this.cyb.setText(str);
            this.cyb.setVisibility(0);
        }
    }

    public void kM(int i) {
        this.cyo = i;
    }

    public void kN(int i) {
        this.cxZ.setImageResource(i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cyn.setText(str);
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

    public void kO(int i) {
        ViewGroup.LayoutParams layoutParams = this.cxZ.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.cxZ.setLayoutParams(marginLayoutParams);
        }
    }

    public void kP(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.cxZ.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.cxZ.setLayoutParams(marginLayoutParams);
        }
    }

    public void atW() {
        this.cyn.setVisibility(0);
        this.cyb.setVisibility(0);
        am.f(this.cya, R.color.cp_cont_d, 1);
    }

    public void aud() {
        this.cyn.setVisibility(8);
        this.cyb.setVisibility(8);
        am.f(this.cya, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.c(this.cxZ, this.cyo);
        am.d(this.cya, R.color.cp_cont_d, 1, skinType);
        am.d(this.cyb, R.color.cp_cont_j, 1, skinType);
        am.l(this.attachedView, R.color.cp_bg_line_d);
    }

    public View atX() {
        return this.attachedView;
    }
}
