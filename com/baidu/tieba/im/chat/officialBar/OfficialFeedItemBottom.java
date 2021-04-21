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
import d.b.j0.e1.l.c.a;
/* loaded from: classes4.dex */
public class OfficialFeedItemBottom extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17560e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17561f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17562g;

    public OfficialFeedItemBottom(Context context) {
        this(context, null);
    }

    public void a(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17562g.getLayoutParams();
        layoutParams.topMargin = i;
        this.f17562g.setLayoutParams(layoutParams);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17560e).inflate(R.layout.official_feed_item_bottom, (ViewGroup) this, true);
        this.f17561f = (TextView) findViewById(R.id.message_no_image_title);
        this.f17562g = (TextView) findViewById(R.id.message_info);
        c();
    }

    public void c() {
        SkinManager.setViewTextColor(this.f17562g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f17561f, R.color.CAM_X0105);
    }

    public void setData(a.C1289a c1289a, boolean z) {
        int i = TextUtils.isEmpty(c1289a.f55851b) ? 8 : 0;
        this.f17561f.setText(c1289a.f55850a);
        this.f17562g.setText(c1289a.f55851b);
        this.f17562g.setVisibility(i);
        if (z) {
            this.f17561f.setVisibility(8);
        } else {
            this.f17561f.setVisibility(0);
        }
    }

    public OfficialFeedItemBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17560e = context;
        b();
    }
}
