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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import tbclient.RecommendForumInfo;
/* loaded from: classes8.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView fkQ;
    private TextView jSz;
    private BarImageView kGO;
    private TextView kGP;
    private TextView kGQ;
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
        this.kGO = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.fkQ = (TextView) findViewById(R.id.h_forum_name);
        this.kGP = (TextView) findViewById(R.id.forum_authen);
        this.jSz = (TextView) findViewById(R.id.h_fans_num);
        this.kGQ = (TextView) findViewById(R.id.h_thread_num);
        this.kGO.setPlaceHolder(1);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.fkQ.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ap.getDrawable(R.drawable.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.fkQ.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.fkQ.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds4)));
                this.kGP.setText(recommendForumInfo.authen);
                this.kGP.setVisibility(0);
            } else {
                this.fkQ.setCompoundDrawables(null, null, null, null);
                this.kGP.setVisibility(8);
            }
            this.jSz.setText(au.numberUniformFormat(recommendForumInfo.member_count.intValue()));
            this.kGQ.setText(au.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.kGO.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
