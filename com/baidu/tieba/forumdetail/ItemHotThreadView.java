package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ItemHotThreadView extends LinearLayout {

    /* renamed from: a */
    private Context f1213a;
    private TextView b;
    private ViewPager c;
    private IndicatorView d;

    public ItemHotThreadView(Context context) {
        super(context);
        a(context);
    }

    public ItemHotThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(Context context) {
        this.f1213a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.forum_detail_hot_thread, (ViewGroup) this, true);
        this.b = (TextView) findViewById(R.id.ht_title);
        this.c = (ViewPager) findViewById(R.id.ht_pager);
        this.d = (IndicatorView) findViewById(R.id.ht_indicator);
    }

    public boolean a(ForumDetailData forumDetailData) {
        if (forumDetailData == null || forumDetailData.threads.length == 0) {
            return false;
        }
        this.c.setAdapter(new l(this.f1213a, forumDetailData.threads));
        this.c.setOnPageChangeListener(new n(this));
        this.d.setCount(forumDetailData.threads.length);
        return true;
    }

    public void a(com.baidu.tieba.j jVar, int i) {
        int i2;
        int i3;
        jVar.m().a(i == 1);
        jVar.m().a(this);
        int i4 = R.drawable.icon_brief_dot_n;
        if (i != 1) {
            i2 = R.drawable.icon_brief_dot_s;
            i3 = R.drawable.icon_brief_hot;
        } else {
            i3 = R.drawable.icon_brief_hot_1;
            i4 = R.drawable.icon_brief_dot_n_1;
            i2 = R.drawable.icon_brief_dot_s_1;
        }
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.f1213a.getResources().getDrawable(i3);
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        this.b.setCompoundDrawables(bitmapDrawable, null, null, null);
        this.d.setDrawable(this.f1213a.getResources().getDrawable(i4));
        this.d.setSelector(this.f1213a.getResources().getDrawable(i2));
    }
}
