package com.baidu.tieba.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EnterForumGuideCenterView extends RelativeLayout {
    private ImageView a;
    private TextView b;
    private int c;

    public EnterForumGuideCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = -1;
        a(context);
    }

    public EnterForumGuideCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = -1;
        a(context);
    }

    public EnterForumGuideCenterView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = -1;
        a(context);
    }

    public void a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.enter_forum_guide_center, this);
        this.a = (ImageView) findViewById(R.id.img_bg_center);
        this.b = (TextView) findViewById(R.id.tip_center);
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

    private boolean c(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void a(int i) {
        if (c(i)) {
            com.baidu.tieba.util.bb.a(this, i);
            if (i == 1) {
                this.a.setBackgroundResource(R.drawable.pic_go_ba_1);
                this.b.setTextColor(-8815226);
                return;
            }
            this.a.setBackgroundResource(R.drawable.pic_go_ba);
            this.b.setTextColor(-5065030);
        }
    }

    public void b(int i) {
        if (i == 0) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void a() {
        a(TiebaApplication.h().an());
    }

    public void b() {
        a();
    }

    public void c() {
        this.c = -1;
        this.a.setBackgroundDrawable(null);
    }
}
