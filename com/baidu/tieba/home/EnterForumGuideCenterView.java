package com.baidu.tieba.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bq;
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

    private void a(Context context) {
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

    private boolean a(int i) {
        if (i == getSkinType()) {
            return false;
        }
        this.c = i;
        return true;
    }

    public final void a() {
        int ae = TiebaApplication.g().ae();
        if (a(ae)) {
            bq.a(this, ae);
            if (ae != 1) {
                this.a.setBackgroundResource(R.drawable.pic_go_ba);
                this.b.setTextColor(-5065030);
                return;
            }
            this.a.setBackgroundResource(R.drawable.pic_go_ba_1);
            this.b.setTextColor(-8815226);
        }
    }

    public final void b() {
        this.c = -1;
        this.a.setBackgroundDrawable(null);
    }
}
