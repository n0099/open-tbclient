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
    private TextView aQF;
    private TextView aQx;
    private BarImageView bbb;
    private TextView bbc;
    private TextView bbd;
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
        this.bbb = (BarImageView) findViewById(com.baidu.tieba.w.h_forum_portrait);
        this.aQx = (TextView) findViewById(com.baidu.tieba.w.h_forum_name);
        this.bbc = (TextView) findViewById(com.baidu.tieba.w.forum_authen);
        this.bbd = (TextView) findViewById(com.baidu.tieba.w.h_fans_num);
        this.aQF = (TextView) findViewById(com.baidu.tieba.w.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.aQx.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) bc.getDrawable(com.baidu.tieba.v.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.aQx.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.aQx.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.dip2px(this.mContext, this.mContext.getResources().getDimension(com.baidu.tieba.u.ds4)));
                this.bbc.setText(recommendForumInfo.authen);
                this.bbc.setVisibility(0);
            } else {
                this.aQx.setCompoundDrawables(null, null, null, null);
                this.bbc.setVisibility(8);
            }
            this.bbd.setText(String.valueOf(recommendForumInfo.member_count));
            this.aQF.setText(String.valueOf(recommendForumInfo.thread_count));
            int dip2px = com.baidu.adp.lib.util.l.dip2px(this.mContext, 80.0f);
            this.bbb.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().ab(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }
}
