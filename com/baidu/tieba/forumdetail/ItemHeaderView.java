package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ItemHeaderView extends RelativeLayout {
    private Context a;
    private HeadImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;

    public ItemHeaderView(Context context) {
        super(context);
        a(context);
    }

    public ItemHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ItemHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a(Context context) {
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(w.forum_detail_header, (ViewGroup) this, true);
        this.b = (HeadImageView) findViewById(v.h_forum_portrait);
        this.d = (TextView) findViewById(v.h_forum_name);
        this.c = (ImageView) findViewById(v.h_forum_rank);
        this.e = (TextView) findViewById(v.h_fans_num);
        this.f = (TextView) findViewById(v.h_thread_num);
    }

    public boolean a(ForumDetailData forumDetailData) {
        int i;
        if (forumDetailData == null || forumDetailData.forumDir == null) {
            return false;
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        ForumDetailData.ForumInfo forumInfo = forumDetailData.forumInfo;
        this.d.setText(forumInfo.forumName);
        this.e.setText(String.valueOf(forumInfo.memberCount));
        this.f.setText(String.valueOf(forumInfo.threadCount));
        int i2 = forumDetailData.forumDir.rank;
        if (i2 > 0 && i2 <= 3) {
            if (skinType == 1) {
                if (i2 == 1) {
                    i = u.icon_brief_grade_orange_1;
                } else {
                    i = i2 == 2 ? u.icon_brief_grade_blue_1 : u.icon_brief_grade_green_1;
                }
            } else if (i2 == 1) {
                i = u.icon_brief_grade_orange;
            } else {
                i = i2 == 2 ? u.icon_brief_grade_blue : u.icon_brief_grade_green;
            }
            this.c.setImageResource(i);
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        int a = com.baidu.adp.lib.util.j.a(this.a, 80.0f);
        this.b.a(forumInfo.avatar, 10, a, a, false);
        return true;
    }

    public void a(BaseActivity baseActivity, int i) {
        baseActivity.getLayoutMode().a(i == 1);
        baseActivity.getLayoutMode().a((View) this);
    }
}
