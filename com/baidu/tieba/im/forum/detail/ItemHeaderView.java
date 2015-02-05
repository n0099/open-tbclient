package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView aQE;
    private TextView aQw;
    private BarImageView bba;
    private TextView bbb;
    private TextView bbc;
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
        com.baidu.adp.lib.g.b.ei().a(context, com.baidu.tieba.x.forum_detail_header, this, true);
        setVisibility(8);
        this.bba = (BarImageView) findViewById(com.baidu.tieba.w.h_forum_portrait);
        this.aQw = (TextView) findViewById(com.baidu.tieba.w.h_forum_name);
        this.bbb = (TextView) findViewById(com.baidu.tieba.w.forum_authen);
        this.bbc = (TextView) findViewById(com.baidu.tieba.w.h_fans_num);
        this.aQE = (TextView) findViewById(com.baidu.tieba.w.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.aQw.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) bc.getDrawable(com.baidu.tieba.v.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.aQw.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.aQw.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.dip2px(this.mContext, this.mContext.getResources().getDimension(com.baidu.tieba.u.ds4)));
                this.bbb.setText(recommendForumInfo.authen);
                this.bbb.setVisibility(0);
            } else {
                this.aQw.setCompoundDrawables(null, null, null, null);
                this.bbb.setVisibility(8);
            }
            this.bbc.setText(String.valueOf(recommendForumInfo.member_count));
            this.aQE.setText(String.valueOf(recommendForumInfo.thread_count));
            int dip2px = com.baidu.adp.lib.util.l.dip2px(this.mContext, 80.0f);
            this.bba.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().ab(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }
}
