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
/* loaded from: classes13.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView dWR;
    private TextView hRs;
    private BarImageView izi;
    private TextView izj;
    private TextView izk;
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
        this.izi = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.dWR = (TextView) findViewById(R.id.h_forum_name);
        this.izj = (TextView) findViewById(R.id.forum_authen);
        this.hRs = (TextView) findViewById(R.id.h_fans_num);
        this.izk = (TextView) findViewById(R.id.h_thread_num);
        this.izi.setPlaceHolder(2);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.dWR.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) am.getDrawable(R.drawable.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.dWR.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.dWR.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds4)));
                this.izj.setText(recommendForumInfo.authen);
                this.izj.setVisibility(0);
            } else {
                this.dWR.setCompoundDrawables(null, null, null, null);
                this.izj.setVisibility(8);
            }
            this.hRs.setText(aq.numberUniformFormat(recommendForumInfo.member_count.intValue()));
            this.izk.setText(aq.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.izi.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
