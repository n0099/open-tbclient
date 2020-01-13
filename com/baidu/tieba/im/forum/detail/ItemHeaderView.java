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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import tbclient.RecommendForumInfo;
/* loaded from: classes11.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView ddX;
    private TextView gPp;
    private BarImageView hwT;
    private TextView hwU;
    private TextView hwV;
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
        this.hwT = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.ddX = (TextView) findViewById(R.id.h_forum_name);
        this.hwU = (TextView) findViewById(R.id.forum_authen);
        this.gPp = (TextView) findViewById(R.id.h_fans_num);
        this.hwV = (TextView) findViewById(R.id.h_thread_num);
        this.hwT.setPlaceHolder(2);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.ddX.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) am.getDrawable(R.drawable.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.ddX.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.ddX.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds4)));
                this.hwU.setText(recommendForumInfo.authen);
                this.hwU.setVisibility(0);
            } else {
                this.ddX.setCompoundDrawables(null, null, null, null);
                this.hwU.setVisibility(8);
            }
            this.gPp.setText(aq.numberUniformFormat(recommendForumInfo.member_count.intValue()));
            this.hwV.setText(aq.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.hwT.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
