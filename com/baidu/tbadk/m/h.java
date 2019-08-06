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
    protected TbImageView cxd;
    protected TextView cxe;
    protected TextView cxf;
    private LinearLayout cxh;
    protected EmotionButton cxr;
    private int cxs;

    public TextView getTitleView() {
        return this.cxf;
    }

    public EmotionButton atQ() {
        return this.cxr;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.cxd = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cxe = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cxf = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cxh = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.cxr = (EmotionButton) this.attachedView.findViewById(R.id.net_refresh_button);
        this.cxs = R.drawable.new_pic_emotion_09;
        this.cxr.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        kM(0);
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

    public void qO(String str) {
        if (str != null) {
            this.cxf.setText(str);
            this.cxf.setVisibility(0);
        }
    }

    public void kJ(int i) {
        this.cxs = i;
    }

    public void kK(int i) {
        this.cxd.setImageResource(i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cxr.setText(str);
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

    public void kL(int i) {
        ViewGroup.LayoutParams layoutParams = this.cxd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.cxd.setLayoutParams(marginLayoutParams);
        }
    }

    public void kM(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.cxd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.cxd.setLayoutParams(marginLayoutParams);
        }
    }

    public void atK() {
        this.cxr.setVisibility(0);
        this.cxf.setVisibility(0);
        am.f(this.cxe, R.color.cp_cont_d, 1);
    }

    public void atR() {
        this.cxr.setVisibility(8);
        this.cxf.setVisibility(8);
        am.f(this.cxe, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.c(this.cxd, this.cxs);
        am.d(this.cxe, R.color.cp_cont_d, 1, skinType);
        am.d(this.cxf, R.color.cp_cont_j, 1, skinType);
        am.l(this.attachedView, R.color.cp_bg_line_d);
    }

    public View atL() {
        return this.attachedView;
    }
}
