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
    public Context f17178e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17179f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17180g;

    public OfficialFeedItemBottom(Context context) {
        this(context, null);
    }

    public void a(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17180g.getLayoutParams();
        layoutParams.topMargin = i2;
        this.f17180g.setLayoutParams(layoutParams);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17178e).inflate(R.layout.official_feed_item_bottom, (ViewGroup) this, true);
        this.f17179f = (TextView) findViewById(R.id.message_no_image_title);
        this.f17180g = (TextView) findViewById(R.id.message_info);
        c();
    }

    public void c() {
        SkinManager.setViewTextColor(this.f17180g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f17179f, R.color.CAM_X0105);
    }

    public void setData(a.C1374a c1374a, boolean z) {
        int i2 = TextUtils.isEmpty(c1374a.f58297b) ? 8 : 0;
        this.f17179f.setText(c1374a.f58296a);
        this.f17180g.setText(c1374a.f58297b);
        this.f17180g.setVisibility(i2);
        if (z) {
            this.f17179f.setVisibility(8);
        } else {
            this.f17179f.setVisibility(0);
        }
    }

    public OfficialFeedItemBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17178e = context;
        b();
    }
}
