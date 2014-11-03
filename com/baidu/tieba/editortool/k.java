package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class k extends TextView {
    private int RH;
    private GradientDrawable aqu;
    protected int aqv;
    protected int aqw;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.RH = -1;
        this.aqv = (int) context.getResources().getDimension(com.baidu.tieba.t.ds12);
        this.aqw = (int) context.getResources().getDimension(com.baidu.tieba.t.ds6);
        setPadding(this.aqv, this.aqw, this.aqv, this.aqw);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(com.baidu.tieba.t.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(com.baidu.tieba.t.ds48));
    }

    public void nz() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (skinType != this.RH) {
            this.RH = skinType;
            sD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sD() {
        if (this.aqu == null) {
            this.aqu = new GradientDrawable();
            this.aqu.setCornerRadius(getContext().getResources().getDimension(com.baidu.tieba.t.ds24));
        }
        com.baidu.tbadk.core.util.aw.b(this, com.baidu.tieba.s.cp_cont_c, 1);
        this.aqu.setColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_bg_line_e));
        setBackgroundDrawable(this.aqu);
    }
}
