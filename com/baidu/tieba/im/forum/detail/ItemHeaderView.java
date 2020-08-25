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
/* loaded from: classes20.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView eus;
    private TextView iAJ;
    private BarImageView jom;
    private TextView jon;
    private TextView joo;
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
        this.jom = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.eus = (TextView) findViewById(R.id.h_forum_name);
        this.jon = (TextView) findViewById(R.id.forum_authen);
        this.iAJ = (TextView) findViewById(R.id.h_fans_num);
        this.joo = (TextView) findViewById(R.id.h_thread_num);
        this.jom.setPlaceHolder(2);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.eus.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ap.getDrawable(R.drawable.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.eus.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.eus.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds4)));
                this.jon.setText(recommendForumInfo.authen);
                this.jon.setVisibility(0);
            } else {
                this.eus.setCompoundDrawables(null, null, null, null);
                this.jon.setVisibility(8);
            }
            this.iAJ.setText(at.numberUniformFormat(recommendForumInfo.member_count.intValue()));
            this.joo.setText(at.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.jom.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
