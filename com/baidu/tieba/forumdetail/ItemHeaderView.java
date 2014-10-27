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
    private BarImageView axo;
    private ImageView axp;
    private TextView axq;
    private TextView axr;
    private TextView axs;
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
        this.axo = (BarImageView) findViewById(v.h_forum_portrait);
        this.axq = (TextView) findViewById(v.h_forum_name);
        this.axp = (ImageView) findViewById(v.h_forum_rank);
        this.axr = (TextView) findViewById(v.h_fans_num);
        this.axs = (TextView) findViewById(v.h_thread_num);
    }

    public boolean e(ForumDetailData forumDetailData) {
        if (forumDetailData == null || forumDetailData.forum_dir == null) {
            return false;
        }
        TbadkApplication.m251getInst().getSkinType();
        ForumDetailData.ForumInfo forumInfo = forumDetailData.forum_info;
        this.axq.setText(forumInfo.forum_name);
        this.axr.setText(String.valueOf(forumInfo.member_count));
        this.axs.setText(String.valueOf(forumInfo.thread_count));
        int i = forumDetailData.forum_dir.rank;
        if (i > 0 && i <= 3) {
            if (i == 1) {
                aw.c(this.axp, u.icon_brief_grade_orange);
            } else if (i == 2) {
                aw.c(this.axp, u.icon_brief_grade_blue);
            } else {
                aw.c(this.axp, u.icon_brief_grade_green);
            }
            this.axp.setVisibility(0);
        } else {
            this.axp.setVisibility(8);
        }
        int dip2px = m.dip2px(this.mContext, 80.0f);
        this.axo.a(forumInfo.avatar, 10, dip2px, dip2px, false);
        return true;
    }

    public void a(BaseActivity baseActivity, int i) {
        baseActivity.getLayoutMode().L(i == 1);
        baseActivity.getLayoutMode().h(this);
    }
}
