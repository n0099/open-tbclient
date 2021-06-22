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
import d.a.o0.f1.l.c.a;
/* loaded from: classes4.dex */
public class OfficialFeedItemBottom extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17260e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17261f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17262g;

    public OfficialFeedItemBottom(Context context) {
        this(context, null);
    }

    public void a(int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17262g.getLayoutParams();
        layoutParams.topMargin = i2;
        this.f17262g.setLayoutParams(layoutParams);
    }

    public final void b() {
        setOrientation(1);
        LayoutInflater.from(this.f17260e).inflate(R.layout.official_feed_item_bottom, (ViewGroup) this, true);
        this.f17261f = (TextView) findViewById(R.id.message_no_image_title);
        this.f17262g = (TextView) findViewById(R.id.message_info);
        c();
    }

    public void c() {
        SkinManager.setViewTextColor(this.f17262g, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f17261f, R.color.CAM_X0105);
    }

    public void setData(a.C1378a c1378a, boolean z) {
        int i2 = TextUtils.isEmpty(c1378a.f58422b) ? 8 : 0;
        this.f17261f.setText(c1378a.f58421a);
        this.f17262g.setText(c1378a.f58422b);
        this.f17262g.setVisibility(i2);
        if (z) {
            this.f17261f.setVisibility(8);
        } else {
            this.f17261f.setVisibility(0);
        }
    }

    public OfficialFeedItemBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17260e = context;
        b();
    }
}
