package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.forumdetail.ForumDetailData;
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

    private void a(Context context) {
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.forum_detail_header, (ViewGroup) this, true);
        this.b = (HeadImageView) findViewById(com.baidu.tieba.a.h.h_forum_portrait);
        this.d = (TextView) findViewById(com.baidu.tieba.a.h.h_forum_name);
        this.c = (ImageView) findViewById(com.baidu.tieba.a.h.h_forum_rank);
        this.e = (TextView) findViewById(com.baidu.tieba.a.h.h_fans_num);
        this.f = (TextView) findViewById(com.baidu.tieba.a.h.h_thread_num);
    }

    public final boolean a(ForumDetailData forumDetailData) {
        int i;
        if (forumDetailData == null || forumDetailData.forumDir == null) {
            return false;
        }
        int l = TbadkApplication.j().l();
        ForumDetailData.ForumInfo forumInfo = forumDetailData.forumInfo;
        this.d.setText(forumInfo.forumName);
        this.e.setText(String.valueOf(forumInfo.memberCount));
        this.f.setText(String.valueOf(forumInfo.threadCount));
        int i2 = forumDetailData.forumDir.rank;
        if (i2 > 0 && i2 <= 3) {
            if (l == 1) {
                if (i2 == 1) {
                    i = com.baidu.tieba.a.g.icon_brief_grade_orange_1;
                } else {
                    i = i2 == 2 ? com.baidu.tieba.a.g.icon_brief_grade_blue_1 : com.baidu.tieba.a.g.icon_brief_grade_green_1;
                }
            } else if (i2 == 1) {
                i = com.baidu.tieba.a.g.icon_brief_grade_orange;
            } else {
                i = i2 == 2 ? com.baidu.tieba.a.g.icon_brief_grade_blue : com.baidu.tieba.a.g.icon_brief_grade_green;
            }
            this.c.setImageResource(i);
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        int a = com.baidu.adp.lib.util.i.a(this.a, 80.0f);
        aa aaVar = new aa(this.a);
        aaVar.a(a, a);
        aaVar.b(forumInfo.avatar, new j(this));
        return true;
    }

    public final void a(com.baidu.tbadk.a aVar, int i) {
        aVar.getLayoutMode().a(i == 1);
        aVar.getLayoutMode().a(this);
    }
}
