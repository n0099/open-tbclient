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
import d.b.i0.e1.l.c.a;
/* loaded from: classes4.dex */
public class OfficialFeedItemBottom extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17552e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17553f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17554g;

    public OfficialFeedItemBottom(Context context) {
        this(context, null);
    }

    public void a(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17554g.getLayoutParams();
        layoutParams.topMargin = i;
        this.f17554g.setLayoutParams(layoutParams);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17552e).inflate(R.layout.official_feed_item_bottom, (ViewGroup) this, true);
        this.f17553f = (TextView) findViewById(R.id.message_no_image_title);
        this.f17554g = (TextView) findViewById(R.id.message_info);
        c();
    }

    public void c() {
        SkinManager.setViewTextColor(this.f17554g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f17553f, R.color.CAM_X0105);
    }

    public void setData(a.C1266a c1266a, boolean z) {
        int i = TextUtils.isEmpty(c1266a.f55430b) ? 8 : 0;
        this.f17553f.setText(c1266a.f55429a);
        this.f17554g.setText(c1266a.f55430b);
        this.f17554g.setVisibility(i);
        if (z) {
            this.f17553f.setVisibility(8);
        } else {
            this.f17553f.setVisibility(0);
        }
    }

    public OfficialFeedItemBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17552e = context;
        b();
    }
}
