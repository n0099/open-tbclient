package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView beF;
    private BarImageView eCH;
    private TextView eCI;
    private TextView eCJ;
    private TextView eaa;
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
        LayoutInflater.from(context).inflate(d.h.forum_detail_header, (ViewGroup) this, true);
        setVisibility(8);
        this.eCH = (BarImageView) findViewById(d.g.h_forum_portrait);
        this.beF = (TextView) findViewById(d.g.h_forum_name);
        this.eCI = (TextView) findViewById(d.g.forum_authen);
        this.eaa = (TextView) findViewById(d.g.h_fans_num);
        this.eCJ = (TextView) findViewById(d.g.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.beF.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) aj.getDrawable(d.f.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.beF.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.beF.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(d.e.ds4)));
                this.eCI.setText(recommendForumInfo.authen);
                this.eCI.setVisibility(0);
            } else {
                this.beF.setCompoundDrawables(null, null, null, null);
                this.eCI.setVisibility(8);
            }
            this.eaa.setText(am.C(recommendForumInfo.member_count.intValue()));
            this.eCJ.setText(am.C(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.eCH.startLoad(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().aQ(i == 1);
        forumDetailActivity.getLayoutMode().aM(this);
    }
}
