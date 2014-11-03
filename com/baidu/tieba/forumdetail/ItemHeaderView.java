package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ItemHeaderView extends RelativeLayout {
    private TextView axA;
    private TextView axB;
    private BarImageView axx;
    private ImageView axy;
    private TextView axz;
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
        com.baidu.adp.lib.g.b.ek().a(context, w.forum_detail_header, this, true);
        this.axx = (BarImageView) findViewById(v.h_forum_portrait);
        this.axz = (TextView) findViewById(v.h_forum_name);
        this.axy = (ImageView) findViewById(v.h_forum_rank);
        this.axA = (TextView) findViewById(v.h_fans_num);
        this.axB = (TextView) findViewById(v.h_thread_num);
    }

    public boolean e(ForumDetailData forumDetailData) {
        if (forumDetailData == null || forumDetailData.forum_dir == null) {
            return false;
        }
        TbadkApplication.m251getInst().getSkinType();
        ForumDetailData.ForumInfo forumInfo = forumDetailData.forum_info;
        this.axz.setText(forumInfo.forum_name);
        this.axA.setText(String.valueOf(forumInfo.member_count));
        this.axB.setText(String.valueOf(forumInfo.thread_count));
        int i = forumDetailData.forum_dir.rank;
        if (i > 0 && i <= 3) {
            if (i == 1) {
                aw.c(this.axy, u.icon_brief_grade_orange);
            } else if (i == 2) {
                aw.c(this.axy, u.icon_brief_grade_blue);
            } else {
                aw.c(this.axy, u.icon_brief_grade_green);
            }
            this.axy.setVisibility(0);
        } else {
            this.axy.setVisibility(8);
        }
        int dip2px = m.dip2px(this.mContext, 80.0f);
        this.axx.a(forumInfo.avatar, 10, dip2px, dip2px, false);
        return true;
    }

    public void a(BaseActivity baseActivity, int i) {
        baseActivity.getLayoutMode().L(i == 1);
        baseActivity.getLayoutMode().h(this);
    }
}
