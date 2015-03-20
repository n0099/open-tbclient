package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView aEv;
    private TextView aEx;
    private BarImageView bdc;
    private TextView bdd;
    private TextView bde;
    private Context mContext;

    public ItemHeaderView(Context context) {
        super(context);
        init(context);
    }

    public ItemHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ItemHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.hH().a(context, com.baidu.tieba.w.forum_detail_header, this, true);
        setVisibility(8);
        this.bdc = (BarImageView) findViewById(com.baidu.tieba.v.h_forum_portrait);
        this.aEv = (TextView) findViewById(com.baidu.tieba.v.h_forum_name);
        this.bdd = (TextView) findViewById(com.baidu.tieba.v.forum_authen);
        this.bde = (TextView) findViewById(com.baidu.tieba.v.h_fans_num);
        this.aEx = (TextView) findViewById(com.baidu.tieba.v.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.aEv.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ba.getDrawable(com.baidu.tieba.u.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.aEv.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.aEv.setCompoundDrawablePadding(com.baidu.adp.lib.util.n.dip2px(this.mContext, this.mContext.getResources().getDimension(com.baidu.tieba.t.ds4)));
                this.bdd.setText(recommendForumInfo.authen);
                this.bdd.setVisibility(0);
            } else {
                this.aEv.setCompoundDrawables(null, null, null, null);
                this.bdd.setVisibility(8);
            }
            this.bde.setText(String.valueOf(recommendForumInfo.member_count));
            this.aEx.setText(String.valueOf(recommendForumInfo.thread_count));
            int dip2px = com.baidu.adp.lib.util.n.dip2px(this.mContext, 80.0f);
            this.bdc.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().X(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }
}
