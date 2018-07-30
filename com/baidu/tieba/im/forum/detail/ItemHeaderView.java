package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView axT;
    private TextView dLm;
    private BarImageView ero;
    private TextView erp;
    private TextView erq;
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
        this.ero = (BarImageView) findViewById(d.g.h_forum_portrait);
        this.axT = (TextView) findViewById(d.g.h_forum_name);
        this.erp = (TextView) findViewById(d.g.forum_authen);
        this.dLm = (TextView) findViewById(d.g.h_fans_num);
        this.erq = (TextView) findViewById(d.g.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.axT.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) am.getDrawable(d.f.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.axT.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.axT.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(d.e.ds4)));
                this.erp.setText(recommendForumInfo.authen);
                this.erp.setVisibility(0);
            } else {
                this.axT.setCompoundDrawables(null, null, null, null);
                this.erp.setVisibility(8);
            }
            this.dLm.setText(ap.A(recommendForumInfo.member_count.intValue()));
            this.erq.setText(ap.A(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.ero.startLoad(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
