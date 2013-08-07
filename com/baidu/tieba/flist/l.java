package com.baidu.tieba.flist;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    final View f1046a;
    final View b;
    ViewPager c;
    LinearLayout d;
    RelativeLayout e;
    ImageView f;
    TextView g;
    ListView h;
    ListView i;
    TextView j;
    TextView k;
    LinearLayout l;
    TextView m;
    ImageView n;
    LinearLayout o;
    TextView p;
    ImageView q;
    ImageView r;

    public l(ForumListActivity forumListActivity) {
        this.c = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.c.setOnPageChangeListener(forumListActivity);
        this.d = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.e = (RelativeLayout) forumListActivity.findViewById(R.id.title);
        this.f = (ImageView) forumListActivity.findViewById(R.id.title_back);
        this.g = (TextView) forumListActivity.findViewById(R.id.title_text);
        this.r = (ImageView) forumListActivity.findViewById(R.id.home);
        this.f.setOnClickListener(forumListActivity);
        this.j = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.j.setOnClickListener(forumListActivity);
        this.k = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.k.setOnClickListener(forumListActivity);
        this.l = (LinearLayout) forumListActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.f1046a = this.l.findViewById(R.id.footer_background);
        this.m = (TextView) this.l.findViewById(R.id.footer_text);
        this.n = (ImageView) this.l.findViewById(R.id.footer_icon);
        this.o = (LinearLayout) forumListActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.b = this.o.findViewById(R.id.footer_background);
        this.p = (TextView) this.o.findViewById(R.id.footer_text);
        this.q = (ImageView) this.o.findViewById(R.id.footer_icon);
    }
}
