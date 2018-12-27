package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.e;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView aJM;
    private BarImageView eRp;
    private TextView eRq;
    private TextView eRr;
    private TextView eli;
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
        LayoutInflater.from(context).inflate(e.h.forum_detail_header, (ViewGroup) this, true);
        setVisibility(8);
        this.eRp = (BarImageView) findViewById(e.g.h_forum_portrait);
        this.aJM = (TextView) findViewById(e.g.h_forum_name);
        this.eRq = (TextView) findViewById(e.g.forum_authen);
        this.eli = (TextView) findViewById(e.g.h_fans_num);
        this.eRr = (TextView) findViewById(e.g.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.aJM.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) al.getDrawable(e.f.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.aJM.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.aJM.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(e.C0210e.ds4)));
                this.eRq.setText(recommendForumInfo.authen);
                this.eRq.setVisibility(0);
            } else {
                this.aJM.setCompoundDrawables(null, null, null, null);
                this.eRq.setVisibility(8);
            }
            this.eli.setText(ao.Q(recommendForumInfo.member_count.intValue()));
            this.eRr.setText(ao.Q(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.eRp.startLoad(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
