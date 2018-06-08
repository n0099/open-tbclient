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
import com.baidu.tieba.d;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView ayc;
    private TextView dFc;
    private BarImageView ejC;
    private TextView ejD;
    private TextView ejE;
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
        LayoutInflater.from(context).inflate(d.i.forum_detail_header, (ViewGroup) this, true);
        setVisibility(8);
        this.ejC = (BarImageView) findViewById(d.g.h_forum_portrait);
        this.ayc = (TextView) findViewById(d.g.h_forum_name);
        this.ejD = (TextView) findViewById(d.g.forum_authen);
        this.dFc = (TextView) findViewById(d.g.h_fans_num);
        this.ejE = (TextView) findViewById(d.g.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.ayc.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) al.getDrawable(d.f.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.ayc.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.ayc.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(d.e.ds4)));
                this.ejD.setText(recommendForumInfo.authen);
                this.ejD.setVisibility(0);
            } else {
                this.ayc.setCompoundDrawables(null, null, null, null);
                this.ejD.setVisibility(8);
            }
            this.dFc.setText(ao.y(recommendForumInfo.member_count.intValue()));
            this.ejE.setText(ao.y(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.ejC.startLoad(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
