package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ItemHeaderView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1081a;
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
        this.f1081a = context;
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
        int ap = TiebaApplication.g().ap();
        ForumDetailData.ForumInfo forumInfo = forumDetailData.forumInfo;
        this.d.setText(forumInfo.forumName);
        this.e.setText(String.valueOf(forumInfo.memberCount));
        this.f.setText(String.valueOf(forumInfo.threadCount));
        if (ap == 1) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.f1081a.getResources().getDrawable(R.drawable.icon_people_1);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.g.setCompoundDrawables(bitmapDrawable, null, null, null);
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.f1081a.getResources().getDrawable(R.drawable.icon_discuss_1);
            bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
            this.h.setCompoundDrawables(bitmapDrawable2, null, null, null);
        } else {
            BitmapDrawable bitmapDrawable3 = (BitmapDrawable) this.f1081a.getResources().getDrawable(R.drawable.icon_people);
            bitmapDrawable3.setBounds(0, 0, bitmapDrawable3.getIntrinsicWidth(), bitmapDrawable3.getIntrinsicHeight());
            this.g.setCompoundDrawables(bitmapDrawable3, null, null, null);
            BitmapDrawable bitmapDrawable4 = (BitmapDrawable) this.f1081a.getResources().getDrawable(R.drawable.icon_discuss);
            bitmapDrawable4.setBounds(0, 0, bitmapDrawable4.getIntrinsicWidth(), bitmapDrawable4.getIntrinsicHeight());
            this.h.setCompoundDrawables(bitmapDrawable4, null, null, null);
        }
        int i2 = forumDetailData.forumDir.rank;
        if (i2 > 0 && i2 <= 3) {
            if (ap == 1) {
                if (i2 == 1) {
                    i = R.drawable.icon_brief_grade_orange_1;
                } else {
                    i = i2 == 2 ? R.drawable.icon_brief_grade_blue_1 : R.drawable.icon_brief_grade_green_1;
                }
            } else if (i2 == 1) {
                i = R.drawable.icon_brief_grade_orange;
            } else {
                i = i2 == 2 ? R.drawable.icon_brief_grade_blue : R.drawable.icon_brief_grade_green;
            }
            this.c.setImageResource(i);
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
        int a2 = UtilHelper.a(this.f1081a, 80.0f);
        com.baidu.tieba.util.a aVar = new com.baidu.tieba.util.a(this.f1081a);
        aVar.a(a2, a2);
        com.baidu.adp.widget.a.c d = aVar.d(forumInfo.avatar);
        if (d != null) {
            this.b.setImageBitmap(d.f());
            this.b.invalidate();
        } else {
            aVar.a(forumInfo.avatar, new j(this));
        }
        return true;
    }

    public void a(com.baidu.tieba.j jVar, int i) {
        jVar.l().a(i == 1);
        jVar.l().a(this);
    }
}
