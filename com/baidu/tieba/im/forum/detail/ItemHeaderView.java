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
/* loaded from: classes3.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView crl;
    private TextView fYn;
    private BarImageView gGd;
    private TextView gGe;
    private TextView gGf;
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
        this.gGd = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.crl = (TextView) findViewById(R.id.h_forum_name);
        this.gGe = (TextView) findViewById(R.id.forum_authen);
        this.fYn = (TextView) findViewById(R.id.h_fans_num);
        this.gGf = (TextView) findViewById(R.id.h_thread_num);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.crl.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) am.getDrawable(R.drawable.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.crl.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.crl.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds4)));
                this.gGe.setText(recommendForumInfo.authen);
                this.gGe.setVisibility(0);
            } else {
                this.crl.setCompoundDrawables(null, null, null, null);
                this.gGe.setVisibility(8);
            }
            this.fYn.setText(aq.numberUniformFormat(recommendForumInfo.member_count.intValue()));
            this.gGf.setText(aq.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.gGd.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
