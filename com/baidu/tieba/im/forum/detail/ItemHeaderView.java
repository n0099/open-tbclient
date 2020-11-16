package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import tbclient.RecommendForumInfo;
/* loaded from: classes25.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView eWc;
    private TextView jqe;
    private BarImageView keY;
    private TextView keZ;
    private TextView kfa;
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
        LayoutInflater.from(context).inflate(R.layout.forum_detail_header, (ViewGroup) this, true);
        setVisibility(8);
        this.keY = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.eWc = (TextView) findViewById(R.id.h_forum_name);
        this.keZ = (TextView) findViewById(R.id.forum_authen);
        this.jqe = (TextView) findViewById(R.id.h_fans_num);
        this.kfa = (TextView) findViewById(R.id.h_thread_num);
        this.keY.setPlaceHolder(1);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.eWc.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ap.getDrawable(R.drawable.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.eWc.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.eWc.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds4)));
                this.keZ.setText(recommendForumInfo.authen);
                this.keZ.setVisibility(0);
            } else {
                this.eWc.setCompoundDrawables(null, null, null, null);
                this.keZ.setVisibility(8);
            }
            this.jqe.setText(au.numberUniformFormat(recommendForumInfo.member_count.intValue()));
            this.kfa.setText(au.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.keY.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
