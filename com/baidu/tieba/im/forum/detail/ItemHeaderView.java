package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.x;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView aPA;
    private TextView aPs;
    private BarImageView aZE;
    private TextView aZF;
    private TextView aZG;
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
        com.baidu.adp.lib.g.b.ek().a(context, x.forum_detail_header, this, true);
        setVisibility(8);
        this.aZE = (BarImageView) findViewById(com.baidu.tieba.w.h_forum_portrait);
        this.aPs = (TextView) findViewById(com.baidu.tieba.w.h_forum_name);
        this.aZF = (TextView) findViewById(com.baidu.tieba.w.forum_authen);
        this.aZG = (TextView) findViewById(com.baidu.tieba.w.h_fans_num);
        this.aPA = (TextView) findViewById(com.baidu.tieba.w.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.aPs.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ax.getDrawable(com.baidu.tieba.v.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.aPs.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.aPs.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.dip2px(this.mContext, this.mContext.getResources().getDimension(com.baidu.tieba.u.ds4)));
                this.aZF.setText(recommendForumInfo.authen);
                this.aZF.setVisibility(0);
            } else {
                this.aPs.setCompoundDrawables(null, null, null, null);
                this.aZF.setVisibility(8);
            }
            this.aZG.setText(String.valueOf(recommendForumInfo.member_count));
            this.aPA.setText(String.valueOf(recommendForumInfo.thread_count));
            int dip2px = com.baidu.adp.lib.util.l.dip2px(this.mContext, 80.0f);
            this.aZE.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().ab(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }
}
