package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ItemHeaderView extends RelativeLayout {
    private Context a;
    private HeadImageView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;

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
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.forum_detail_header, (ViewGroup) this, true);
        this.b = (HeadImageView) findViewById(R.id.h_forum_portrait);
        this.d = (TextView) findViewById(R.id.h_forum_name);
        this.c = (ImageView) findViewById(R.id.h_forum_rank);
        this.e = (TextView) findViewById(R.id.h_fans_num);
        this.f = (TextView) findViewById(R.id.h_thread_num);
        this.g = (TextView) findViewById(R.id.h_fans_icon);
        this.h = (TextView) findViewById(R.id.h_thread_icon);
    }

    public boolean a(ForumDetailData forumDetailData) {
        int i;
        if (forumDetailData == null || forumDetailData.forumDir == null) {
            return false;
        }
        int an = TiebaApplication.g().an();
        ForumDetailData.ForumInfo forumInfo = forumDetailData.forumInfo;
        this.d.setText(forumInfo.forumName);
        this.e.setText(String.valueOf(forumInfo.memberCount));
        this.f.setText(String.valueOf(forumInfo.threadCount));
        int i2 = forumDetailData.forumDir.rank;
        if (i2 > 0 && i2 <= 3) {
            if (an == 1) {
                if (i2 == 1) {
                    i = R.drawable.icon_brief_grade_orange_1;
                } else {
                    i = i2 == 2 ? R.drawable.icon_brief_grade_blue_1 : R.drawable.icon_brief_grade_green_1;
                }
            } else {
                i = i2 == 1 ? R.drawable.icon_brief_grade_orange : i2 == 2 ? R.drawable.icon_brief_grade_blue : R.drawable.icon_brief_grade_green;
            }
            this.c.setImageResource(i);
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        int a = com.baidu.adp.lib.h.g.a(this.a, 80.0f);
        com.baidu.tieba.util.i iVar = new com.baidu.tieba.util.i(this.a);
        iVar.a(a, a);
        com.baidu.adp.widget.ImageView.d d = iVar.d(forumInfo.avatar);
        if (d != null) {
            this.b.setImageBitmap(d.h());
            this.b.invalidate();
        } else {
            iVar.a(forumInfo.avatar, new j(this));
        }
        return true;
    }

    public void a(com.baidu.tieba.j jVar, int i) {
        jVar.getLayoutMode().a(i == 1);
        jVar.getLayoutMode().a(this);
    }
}
