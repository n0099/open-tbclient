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
import d.b.b.e.p.l;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemHeaderView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17972e;

    /* renamed from: f  reason: collision with root package name */
    public BarImageView f17973f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17974g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17975h;
    public TextView i;
    public TextView j;

    public ItemHeaderView(Context context) {
        super(context);
        a(context);
    }

    public void a(Context context) {
        this.f17972e = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_header, (ViewGroup) this, true);
        setVisibility(8);
        this.f17973f = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.f17974g = (TextView) findViewById(R.id.h_forum_name);
        this.f17975h = (TextView) findViewById(R.id.forum_authen);
        this.i = (TextView) findViewById(R.id.h_fans_num);
        this.j = (TextView) findViewById(R.id.h_thread_num);
        this.f17973f.setPlaceHolder(1);
    }

    public void b(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().k(i == 1);
        forumDetailActivity.getLayoutMode().j(this);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo == null) {
            return;
        }
        boolean z = recommendForumInfo.forum_type.intValue() == 1;
        this.f17974g.setText(recommendForumInfo.forum_name);
        if (z) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_v);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.f17974g.setCompoundDrawables(null, null, bitmapDrawable, null);
            TextView textView = this.f17974g;
            Context context = this.f17972e;
            textView.setCompoundDrawablePadding(l.e(context, context.getResources().getDimension(R.dimen.ds4)));
            this.f17975h.setText(recommendForumInfo.authen);
            this.f17975h.setVisibility(0);
        } else {
            this.f17974g.setCompoundDrawables(null, null, null, null);
            this.f17975h.setVisibility(8);
        }
        this.i.setText(StringHelper.numberUniformFormat(recommendForumInfo.member_count.intValue()));
        this.j.setText(StringHelper.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
        int e2 = l.e(this.f17972e, 80.0f);
        this.f17973f.T(recommendForumInfo.avatar, 10, e2, e2, false);
        setVisibility(0);
    }

    public ItemHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ItemHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
