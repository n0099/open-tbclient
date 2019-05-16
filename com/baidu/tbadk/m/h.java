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
import com.baidu.tieba.R;
import com.baidu.tieba.view.EmotionButton;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView cvH;
    protected TextView cvI;
    protected TextView cvJ;
    private LinearLayout cvL;
    protected EmotionButton cvU;
    private int cvV;

    public TextView getTitleView() {
        return this.cvJ;
    }

    public EmotionButton asG() {
        return this.cvU;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.cvH = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cvI = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cvJ = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cvL = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.cvU = (EmotionButton) this.attachedView.findViewById(R.id.net_refresh_button);
        this.cvV = R.drawable.new_pic_emotion_09;
        this.cvU.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        kF(0);
    }

    public void qx(String str) {
        if (str == null) {
            this.cvI.setVisibility(8);
            return;
        }
        this.cvI.setVisibility(0);
        this.cvI.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.cvJ.setText(str);
        }
    }

    public void qy(String str) {
        if (str != null) {
            this.cvJ.setText(str);
            this.cvJ.setVisibility(0);
        }
    }

    public void kC(int i) {
        this.cvV = i;
    }

    public void kD(int i) {
        this.cvH.setImageResource(i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cvU.setText(str);
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
        this.cvH.setImageResource(0);
    }

    public void kE(int i) {
        ViewGroup.LayoutParams layoutParams = this.cvH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.cvH.setLayoutParams(marginLayoutParams);
        }
    }

    public void kF(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.cvH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.cvH.setLayoutParams(marginLayoutParams);
        }
    }

    public void asB() {
        this.cvU.setVisibility(0);
        this.cvJ.setVisibility(0);
        al.f(this.cvI, R.color.cp_cont_d, 1);
    }

    public void asH() {
        this.cvU.setVisibility(8);
        this.cvJ.setVisibility(8);
        al.f(this.cvI, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.cvH, this.cvV);
        al.c(this.cvI, R.color.cp_cont_d, 1, skinType);
        al.c(this.cvJ, R.color.cp_cont_j, 1, skinType);
        al.l(this.attachedView, R.color.cp_bg_line_d);
    }

    public View asC() {
        return this.attachedView;
    }
}
