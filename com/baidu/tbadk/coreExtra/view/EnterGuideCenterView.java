package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes.dex */
public class EnterGuideCenterView extends RelativeLayout {
    private ImageView a;
    private TextView b;
    private int c;

    public EnterGuideCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = -1;
        a(context);
    }

    public EnterGuideCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = -1;
        a(context);
    }

    public EnterGuideCenterView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = -1;
        a(context);
    }

    public void a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.enter_forum_guide_center, this);
        this.a = (ImageView) findViewById(com.baidu.tieba.v.img_bg_center);
        this.b = (TextView) findViewById(com.baidu.tieba.v.tip_center);
    }

    public void setTipText(int i) {
        if (this.b != null) {
            this.b.setText(i);
        }
    }

    private void setSkinType(int i) {
        this.c = i;
    }

    private int getSkinType() {
        return this.c;
    }

    private boolean b(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void a(int i) {
        if (b(i)) {
            be.a(this, i);
            if (i == 1) {
                this.a.setBackgroundResource(com.baidu.tieba.u.pic_go_ba_1);
                this.b.setTextColor(-8815226);
                return;
            }
            this.a.setBackgroundResource(com.baidu.tieba.u.pic_go_ba);
            this.b.setTextColor(-5065030);
        }
    }

    public void a() {
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void b() {
        a();
    }

    public void c() {
        this.c = -1;
        this.a.setBackgroundDrawable(null);
    }
}
