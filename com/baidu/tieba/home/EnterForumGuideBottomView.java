package com.baidu.tieba.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class EnterForumGuideBottomView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f1139a;
    private ImageView b;
    private TextView c;

    public EnterForumGuideBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1139a = -1;
        this.b = null;
        this.c = null;
        a(context);
    }

    public EnterForumGuideBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1139a = -1;
        this.b = null;
        this.c = null;
        a(context);
    }

    public EnterForumGuideBottomView(Context context) {
        super(context);
        this.f1139a = -1;
        this.b = null;
        this.c = null;
        a(context);
    }

    public void a(Context context) {
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.enter_forum_guide_bottom, (ViewGroup) null));
        this.b = (ImageView) findViewById(R.id.img_bg_bottom);
        this.c = (TextView) findViewById(R.id.tip_bottom);
    }

    private void setSkinType(int i) {
        this.f1139a = i;
    }

    private int getSkinType() {
        return this.f1139a;
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
        SharedPreferences sharedPreferences = TiebaApplication.g().getSharedPreferences("settings", 0);
        Boolean valueOf = Boolean.valueOf(sharedPreferences.getBoolean("guideisshow", false));
        if (i == 0) {
            if (!valueOf.booleanValue()) {
                setVisibility(0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("guideisshow", true);
                edit.commit();
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public void a() {
        a(TiebaApplication.g().an());
    }

    public void b() {
        a();
    }

    public void c() {
        this.f1139a = -1;
        this.b.setBackgroundResource(0);
    }
}
