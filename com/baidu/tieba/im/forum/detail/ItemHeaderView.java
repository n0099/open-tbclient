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
    private TextView eIK;
    private TextView iXc;
    private BarImageView jLS;
    private TextView jLT;
    private TextView jLU;
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
        this.jLS = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.eIK = (TextView) findViewById(R.id.h_forum_name);
        this.jLT = (TextView) findViewById(R.id.forum_authen);
        this.iXc = (TextView) findViewById(R.id.h_fans_num);
        this.jLU = (TextView) findViewById(R.id.h_thread_num);
        this.jLS.setPlaceHolder(2);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.eIK.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ap.getDrawable(R.drawable.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.eIK.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.eIK.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds4)));
                this.jLT.setText(recommendForumInfo.authen);
                this.jLT.setVisibility(0);
            } else {
                this.eIK.setCompoundDrawables(null, null, null, null);
                this.jLT.setVisibility(8);
            }
            this.iXc.setText(at.numberUniformFormat(recommendForumInfo.member_count.intValue()));
            this.jLU.setText(at.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.jLS.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
