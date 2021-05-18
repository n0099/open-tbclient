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
import d.a.k0.e1.l.c.a;
/* loaded from: classes4.dex */
public class OfficialFeedItemBottom extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17192e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17193f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17194g;

    public OfficialFeedItemBottom(Context context) {
        this(context, null);
    }

    public void a(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17194g.getLayoutParams();
        layoutParams.topMargin = i2;
        this.f17194g.setLayoutParams(layoutParams);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17192e).inflate(R.layout.official_feed_item_bottom, (ViewGroup) this, true);
        this.f17193f = (TextView) findViewById(R.id.message_no_image_title);
        this.f17194g = (TextView) findViewById(R.id.message_info);
        c();
    }

    public void c() {
        SkinManager.setViewTextColor(this.f17194g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f17193f, R.color.CAM_X0105);
    }

    public void setData(a.C1300a c1300a, boolean z) {
        int i2 = TextUtils.isEmpty(c1300a.f54418b) ? 8 : 0;
        this.f17193f.setText(c1300a.f54417a);
        this.f17194g.setText(c1300a.f54418b);
        this.f17194g.setVisibility(i2);
        if (z) {
            this.f17193f.setVisibility(8);
        } else {
            this.f17193f.setVisibility(0);
        }
    }

    public OfficialFeedItemBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17192e = context;
        b();
    }
}
