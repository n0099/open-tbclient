package com.baidu.tieba.im.live.livelist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class HotLiveInitGuideView extends RelativeLayout {
    private ImageView a;
    private TextView b;
    private TextView c;
    private int d;

    public HotLiveInitGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = -1;
        a(context);
    }

    public HotLiveInitGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = -1;
        a(context);
    }

    public HotLiveInitGuideView(Context context) {
        super(context);
        this.d = -1;
        a(context);
    }

    public void a(Context context) {
        addView(com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.im_frsgroup_guide, null));
        this.a = (ImageView) findViewById(com.baidu.tieba.u.guide_img);
        this.b = (TextView) findViewById(com.baidu.tieba.u.guide_tip1);
        this.c = (TextView) findViewById(com.baidu.tieba.u.guide_tip2);
    }

    private void setSkinType(int i) {
        this.d = i;
    }

    private int getSkinType() {
        return this.d;
    }

    private boolean b(int i) {
        if (i == getSkinType()) {
            return false;
        }
        setSkinType(i);
        return true;
    }

    public void a() {
        setVisibility(8);
    }

    public boolean b() {
        return getVisibility() == 0;
    }

    public void a(int i) {
        if (b(i)) {
            if (i == 1) {
                this.a.setBackgroundResource(com.baidu.tieba.t.pic_emotion05_1);
                this.b.setTextColor(-8815226);
                this.c.setTextColor(-8815226);
                return;
            }
            this.a.setBackgroundResource(com.baidu.tieba.t.pic_emotion05);
            this.b.setTextColor(-5065030);
            this.c.setTextColor(-5065030);
        }
    }

    public void c() {
        setVisibility(0);
        getTip1().setVisibility(4);
        getTip2().setText(com.baidu.tieba.x.live_hotlist_no_living_tip);
    }

    public void d() {
        setVisibility(0);
        getTip1().setVisibility(4);
        getTip2().setText(com.baidu.tieba.x.live_hotlist_no_review_tip);
    }

    public void e() {
        setVisibility(0);
        getTip1().setVisibility(4);
        getTip2().setVisibility(0);
        getTip2().setText(com.baidu.tieba.x.live_hotlist_no_foreshow_tip);
    }

    public TextView getTip1() {
        return this.b;
    }

    public TextView getTip2() {
        return this.c;
    }

    public void f() {
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void g() {
        f();
    }

    public void h() {
        this.d = -1;
        this.a.setBackgroundDrawable(null);
    }
}
