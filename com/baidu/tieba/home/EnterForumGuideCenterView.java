package com.baidu.tieba.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EnterForumGuideCenterView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f1322a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private int e;

    public EnterForumGuideCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1322a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = -1;
        a(context);
    }

    public EnterForumGuideCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1322a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = -1;
        a(context);
    }

    public EnterForumGuideCenterView(Context context) {
        super(context);
        this.f1322a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = -1;
        a(context);
    }

    public void a(Context context) {
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.enter_forum_guide_center, (ViewGroup) null));
        this.f1322a = (ImageView) findViewById(R.id.img_bg_center);
        this.c = (TextView) findViewById(R.id.tip_center);
        this.d = (TextView) findViewById(R.id.tip_no_center);
        this.b = (ImageView) findViewById(R.id.arrows_center);
    }

    public void setTipText(int i) {
        if (this.c != null) {
            this.c.setText(i);
        }
    }

    public void setNoCenterTipText(int i) {
        if (this.d != null) {
            this.d.setText(i);
        }
    }

    public void setArrowDisplay(int i) {
        if (this.b != null) {
            this.b.setVisibility(i);
        }
        if (this.c != null) {
            this.c.setVisibility(i);
        }
    }

    private void setSkinType(int i) {
        this.e = i;
    }

    private int getSkinType() {
        return this.e;
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
            if (i == 1) {
                this.f1322a.setBackgroundResource(R.drawable.pic_go_ba_1);
                this.c.setTextColor(-8815226);
                this.d.setTextColor(-8815226);
                return;
            }
            this.f1322a.setBackgroundResource(R.drawable.pic_go_ba);
            this.c.setTextColor(-5065030);
            this.d.setTextColor(-5065030);
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
        a(TiebaApplication.g().as());
    }

    public void b() {
        a();
    }

    public void c() {
        this.e = -1;
        this.f1322a.setBackgroundDrawable(null);
    }
}
