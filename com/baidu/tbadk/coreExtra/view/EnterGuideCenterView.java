package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class EnterGuideCenterView extends RelativeLayout {
    private ImageView a;
    private Bitmap b;
    private TextView c;
    private int d;
    private int e;
    private int f;

    public EnterGuideCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = -1;
        this.e = com.baidu.tieba.t.pic_emotion03;
        this.f = com.baidu.tieba.t.pic_emotion03_1;
        a(context);
    }

    public EnterGuideCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = -1;
        this.e = com.baidu.tieba.t.pic_emotion03;
        this.f = com.baidu.tieba.t.pic_emotion03_1;
        a(context);
    }

    public EnterGuideCenterView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = -1;
        this.e = com.baidu.tieba.t.pic_emotion03;
        this.f = com.baidu.tieba.t.pic_emotion03_1;
        a(context);
    }

    public void a(Context context) {
        com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.enter_forum_guide_center, this);
        this.a = (ImageView) findViewById(com.baidu.tieba.u.img_bg_center);
        this.c = (TextView) findViewById(com.baidu.tieba.u.tip_center);
    }

    public void setTipTextByString(String str) {
        if (this.c != null) {
            this.c.setText(str);
        }
    }

    public void a(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public void setTipText(int i) {
        if (this.c != null) {
            this.c.setText(i);
        }
    }

    private void setSkinType(int i) {
        this.d = i;
    }

    private int getSkinType() {
        return this.d;
    }

    private boolean c(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void a(int i) {
        if (c(i)) {
            com.baidu.tbadk.core.util.ay.a(this, i);
            if (i == 1) {
                this.b = com.baidu.tbadk.core.util.d.b(getContext(), this.f);
                this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_cont_d_1));
            } else {
                this.b = com.baidu.tbadk.core.util.d.b(getContext(), this.e);
                this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_cont_d));
            }
            if (this.b != null) {
                this.a.setImageBitmap(this.b);
            }
        }
    }

    public void b(int i) {
        if (i == 0) {
            b();
            setVisibility(0);
            return;
        }
        setVisibility(8);
        c();
    }

    public void a() {
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void b() {
        a();
    }

    public void c() {
        this.d = -1;
        this.a.setImageDrawable(null);
        if (this.b != null) {
            if (!this.b.isRecycled()) {
                this.b.recycle();
            }
            this.b = null;
        }
    }
}
