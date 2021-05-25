package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.f1.l.c.a;
/* loaded from: classes4.dex */
public class OfficialFeedItemBottom extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17102e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17103f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17104g;

    public OfficialFeedItemBottom(Context context) {
        this(context, null);
    }

    public void a(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17104g.getLayoutParams();
        layoutParams.topMargin = i2;
        this.f17104g.setLayoutParams(layoutParams);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17102e).inflate(R.layout.official_feed_item_bottom, (ViewGroup) this, true);
        this.f17103f = (TextView) findViewById(R.id.message_no_image_title);
        this.f17104g = (TextView) findViewById(R.id.message_info);
        c();
    }

    public void c() {
        SkinManager.setViewTextColor(this.f17104g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f17103f, R.color.CAM_X0105);
    }

    public void setData(a.C1318a c1318a, boolean z) {
        int i2 = TextUtils.isEmpty(c1318a.f54608b) ? 8 : 0;
        this.f17103f.setText(c1318a.f54607a);
        this.f17104g.setText(c1318a.f54608b);
        this.f17104g.setVisibility(i2);
        if (z) {
            this.f17103f.setVisibility(8);
        } else {
            this.f17103f.setVisibility(0);
        }
    }

    public OfficialFeedItemBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17102e = context;
        b();
    }
}
