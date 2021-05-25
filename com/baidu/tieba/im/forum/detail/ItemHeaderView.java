package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class ItemHeaderView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17205e;

    /* renamed from: f  reason: collision with root package name */
    public BarImageView f17206f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17207g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17208h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17209i;
    public TextView j;

    public ItemHeaderView(Context context) {
        super(context);
        a(context);
    }

    public void a(Context context) {
        this.f17205e = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_header, (ViewGroup) this, true);
        setVisibility(8);
        this.f17206f = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.f17207g = (TextView) findViewById(R.id.h_forum_name);
        this.f17208h = (TextView) findViewById(R.id.forum_authen);
        this.f17209i = (TextView) findViewById(R.id.h_fans_num);
        this.j = (TextView) findViewById(R.id.h_thread_num);
        this.f17206f.setPlaceHolder(1);
    }

    public void b(ForumDetailActivity forumDetailActivity, int i2) {
        forumDetailActivity.getLayoutMode().k(i2 == 1);
        forumDetailActivity.getLayoutMode().j(this);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo == null) {
            return;
        }
        boolean z = recommendForumInfo.forum_type.intValue() == 1;
        this.f17207g.setText(recommendForumInfo.forum_name);
        if (z) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_v);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.f17207g.setCompoundDrawables(null, null, bitmapDrawable, null);
            TextView textView = this.f17207g;
            Context context = this.f17205e;
            textView.setCompoundDrawablePadding(l.e(context, context.getResources().getDimension(R.dimen.ds4)));
            this.f17208h.setText(recommendForumInfo.authen);
            this.f17208h.setVisibility(0);
        } else {
            this.f17207g.setCompoundDrawables(null, null, null, null);
            this.f17208h.setVisibility(8);
        }
        this.f17209i.setText(StringHelper.numberUniformFormat(recommendForumInfo.member_count.intValue()));
        this.j.setText(StringHelper.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
        int e2 = l.e(this.f17205e, 80.0f);
        this.f17206f.R(recommendForumInfo.avatar, 10, e2, e2, false);
        setVisibility(0);
    }

    public ItemHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ItemHeaderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
