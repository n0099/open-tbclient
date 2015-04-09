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
    private TextView aED;
    private TextView aEF;
    private BarImageView bds;
    private TextView bdt;
    private TextView bdu;
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
        this.bds = (BarImageView) findViewById(com.baidu.tieba.v.h_forum_portrait);
        this.aED = (TextView) findViewById(com.baidu.tieba.v.h_forum_name);
        this.bdt = (TextView) findViewById(com.baidu.tieba.v.forum_authen);
        this.bdu = (TextView) findViewById(com.baidu.tieba.v.h_fans_num);
        this.aEF = (TextView) findViewById(com.baidu.tieba.v.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.aED.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ba.getDrawable(com.baidu.tieba.u.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.aED.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.aED.setCompoundDrawablePadding(com.baidu.adp.lib.util.n.dip2px(this.mContext, this.mContext.getResources().getDimension(com.baidu.tieba.t.ds4)));
                this.bdt.setText(recommendForumInfo.authen);
                this.bdt.setVisibility(0);
            } else {
                this.aED.setCompoundDrawables(null, null, null, null);
                this.bdt.setVisibility(8);
            }
            this.bdu.setText(String.valueOf(recommendForumInfo.member_count));
            this.aEF.setText(String.valueOf(recommendForumInfo.thread_count));
            int dip2px = com.baidu.adp.lib.util.n.dip2px(this.mContext, 80.0f);
            this.bds.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().X(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }
}
