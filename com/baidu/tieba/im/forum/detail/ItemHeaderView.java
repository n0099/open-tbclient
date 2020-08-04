package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import tbclient.RecommendForumInfo;
/* loaded from: classes20.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView ekx;
    private BarImageView iZm;
    private TextView iZn;
    private TextView iZo;
    private TextView imF;
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
        this.iZm = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.ekx = (TextView) findViewById(R.id.h_forum_name);
        this.iZn = (TextView) findViewById(R.id.forum_authen);
        this.imF = (TextView) findViewById(R.id.h_fans_num);
        this.iZo = (TextView) findViewById(R.id.h_thread_num);
        this.iZm.setPlaceHolder(2);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.ekx.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ao.getDrawable(R.drawable.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.ekx.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.ekx.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds4)));
                this.iZn.setText(recommendForumInfo.authen);
                this.iZn.setVisibility(0);
            } else {
                this.ekx.setCompoundDrawables(null, null, null, null);
                this.iZn.setVisibility(8);
            }
            this.imF.setText(as.numberUniformFormat(recommendForumInfo.member_count.intValue()));
            this.iZo.setText(as.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.iZm.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
