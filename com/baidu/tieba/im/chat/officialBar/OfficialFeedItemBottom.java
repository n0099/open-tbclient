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
import d.b.i0.d1.l.c.a;
/* loaded from: classes3.dex */
public class OfficialFeedItemBottom extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17875e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17876f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17877g;

    public OfficialFeedItemBottom(Context context) {
        this(context, null);
    }

    public void a(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17877g.getLayoutParams();
        layoutParams.topMargin = i;
        this.f17877g.setLayoutParams(layoutParams);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17875e).inflate(R.layout.official_feed_item_bottom, (ViewGroup) this, true);
        this.f17876f = (TextView) findViewById(R.id.message_no_image_title);
        this.f17877g = (TextView) findViewById(R.id.message_info);
        c();
    }

    public void c() {
        SkinManager.setViewTextColor(this.f17877g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f17876f, R.color.CAM_X0105);
    }

    public void setData(a.C1203a c1203a, boolean z) {
        int i = TextUtils.isEmpty(c1203a.f53908b) ? 8 : 0;
        this.f17876f.setText(c1203a.f53907a);
        this.f17877g.setText(c1203a.f53908b);
        this.f17877g.setVisibility(i);
        if (z) {
            this.f17876f.setVisibility(8);
        } else {
            this.f17876f.setVisibility(0);
        }
    }

    public OfficialFeedItemBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17875e = context;
        b();
    }
}
