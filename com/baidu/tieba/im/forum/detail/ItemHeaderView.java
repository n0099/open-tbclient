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
/* loaded from: classes26.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView fdz;
    private TextView jDE;
    private BarImageView ksw;
    private TextView ksx;
    private TextView ksy;
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
        this.ksw = (BarImageView) findViewById(R.id.h_forum_portrait);
        this.fdz = (TextView) findViewById(R.id.h_forum_name);
        this.ksx = (TextView) findViewById(R.id.forum_authen);
        this.jDE = (TextView) findViewById(R.id.h_fans_num);
        this.ksy = (TextView) findViewById(R.id.h_thread_num);
        this.ksw.setPlaceHolder(1);
    }

    public void setData(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            boolean z = recommendForumInfo.forum_type.intValue() == 1;
            this.fdz.setText(recommendForumInfo.forum_name);
            if (z) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) ap.getDrawable(R.drawable.icon_v);
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                this.fdz.setCompoundDrawables(null, null, bitmapDrawable, null);
                this.fdz.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds4)));
                this.ksx.setText(recommendForumInfo.authen);
                this.ksx.setVisibility(0);
            } else {
                this.fdz.setCompoundDrawables(null, null, null, null);
                this.ksx.setVisibility(8);
            }
            this.jDE.setText(au.numberUniformFormat(recommendForumInfo.member_count.intValue()));
            this.ksy.setText(au.numberUniformFormat(recommendForumInfo.thread_count.intValue()));
            int dip2px = l.dip2px(this.mContext, 80.0f);
            this.ksw.a(recommendForumInfo.avatar, 10, dip2px, dip2px, false);
            setVisibility(0);
        }
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }
}
