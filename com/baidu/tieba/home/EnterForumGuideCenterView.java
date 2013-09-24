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
    private ImageView f1187a;
    private TextView b;
    private TextView c;
    private int d;

    public EnterForumGuideCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1187a = null;
        this.b = null;
        this.c = null;
        this.d = -1;
        a(context);
    }

    public EnterForumGuideCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1187a = null;
        this.b = null;
        this.c = null;
        this.d = -1;
        a(context);
    }

    public EnterForumGuideCenterView(Context context) {
        super(context);
        this.f1187a = null;
        this.b = null;
        this.c = null;
        this.d = -1;
        a(context);
    }

    public void a(Context context) {
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.enter_forum_guide_center, (ViewGroup) null));
        this.f1187a = (ImageView) findViewById(R.id.img_bg_center);
        this.b = (TextView) findViewById(R.id.tip_center);
        this.c = (TextView) findViewById(R.id.tip_no_center);
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
            if (i == 1) {
                this.f1187a.setBackgroundResource(R.drawable.pic_go_ba_1);
                this.b.setTextColor(-8815226);
                this.c.setTextColor(-8815226);
                return;
            }
            this.f1187a.setBackgroundResource(R.drawable.pic_go_ba);
            this.b.setTextColor(-5065030);
            this.c.setTextColor(-5065030);
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
        a(TiebaApplication.g().ap());
    }

    public void b() {
        a();
    }

    public void c() {
        this.d = -1;
        this.f1187a.setBackgroundResource(0);
    }
}
