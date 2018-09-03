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
import com.baidu.tieba.f;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView axQ;
    private TextView dLi;
    private BarImageView erk;
    private TextView erl;
    private TextView erm;
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
        LayoutInflater.from(context).inflate(f.h.forum_detail_header, (ViewGroup) this, true);
        setVisibility(8);
        this.erk = (BarImageView) findViewById(f.g.h_forum_portrait);
        this.axQ = (TextView) findViewById(f.g.h_forum_name);
        this.erl = (TextView) findViewById(f.g.forum_authen);
        this.dLi = (TextView) findViewById(f.g.h_fans_num);
        this.erm = (TextView) findViewById(f.g.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.axQ.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) am.getDrawable(f.C0146f.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.axQ.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.axQ.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(f.e.ds4)));
                this.erl.setText(recommendForumInfo.authen);
                this.erl.setVisibility(0);
            } else {
                this.axQ.setCompoundDrawables(null, null, null, null);
                this.erl.setVisibility(8);
            }
            this.dLi.setText(ap.A(recommendForumInfo.member_count.intValue()));
            this.erm.setText(ap.A(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.erk.startLoad(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
