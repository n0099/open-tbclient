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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import tbclient.RecommendForumInfo;
/* loaded from: classes26.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView eRg;
    private BarImageView jYq;
    private TextView jYr;
    private TextView jYs;
    private TextView jjz;
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
        this.jYq = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.eRg = (TextView) findViewById(R.id.h_forum_name);
        this.jYr = (TextView) findViewById(R.id.forum_authen);
        this.jjz = (TextView) findViewById(R.id.h_fans_num);
        this.jYs = (TextView) findViewById(R.id.h_thread_num);
        this.jYq.setPlaceHolder(2);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.eRg.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ap.getDrawable(R.drawable.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.eRg.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.eRg.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds4)));
                this.jYr.setText(recommendForumInfo.authen);
                this.jYr.setVisibility(0);
            } else {
                this.eRg.setCompoundDrawables(null, null, null, null);
                this.jYr.setVisibility(8);
            }
            this.jjz.setText(at.numberUniformFormat(recommendForumInfo.member_count.intValue()));
            this.jYs.setText(at.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.jYq.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
