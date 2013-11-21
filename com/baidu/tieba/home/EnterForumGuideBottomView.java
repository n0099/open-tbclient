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
public class EnterForumGuideBottomView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f1380a;
    private ImageView b;
    private TextView c;

    public EnterForumGuideBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1380a = -1;
        this.b = null;
        this.c = null;
        a(context);
    }

    public EnterForumGuideBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1380a = -1;
        this.b = null;
        this.c = null;
        a(context);
    }

    public EnterForumGuideBottomView(Context context) {
        super(context);
        this.f1380a = -1;
        this.b = null;
        this.c = null;
        a(context);
    }

    public void a(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.enter_forum_guide_bottom, this);
        this.b = (ImageView) findViewById(R.id.img_bg_bottom);
        this.c = (TextView) findViewById(R.id.tip_bottom);
    }

    private void setSkinType(int i) {
        this.f1380a = i;
    }

    private int getSkinType() {
        return this.f1380a;
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
                this.b.setBackgroundResource(R.drawable.pic_go_ba_1);
                this.c.setTextColor(-8815226);
                return;
            }
            this.b.setBackgroundResource(R.drawable.pic_go_ba);
            this.c.setTextColor(-5065030);
        }
    }

    public void b(int i) {
        Boolean valueOf = Boolean.valueOf(com.baidu.tieba.sharedPref.b.a().a("guideisshow", false));
        if (i == 0) {
            if (!valueOf.booleanValue()) {
                setVisibility(0);
                com.baidu.tieba.sharedPref.b.a().b("guideisshow", true);
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public void a() {
        a(TiebaApplication.g().ap());
    }

    public void b() {
        a();
    }

    public void c() {
        this.f1380a = -1;
        this.b.setBackgroundDrawable(null);
    }
}
