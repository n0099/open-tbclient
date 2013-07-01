package com.baidu.tieba.flist;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    final View f824a;
    final View b;
    CoverFlow c;
    FrameLayout d;
    ViewPager e;
    LinearLayout f;
    RelativeLayout g;
    ImageView h;
    TextView i;
    ListView j;
    ListView k;
    TextView l;
    TextView m;
    LinearLayout n;
    TextView o;
    ImageView p;
    LinearLayout q;
    TextView r;
    ImageView s;
    ImageView t;

    public m(ForumListActivity forumListActivity) {
        this.c = (CoverFlow) forumListActivity.findViewById(R.id.cover_flow);
        this.d = (FrameLayout) forumListActivity.findViewById(R.id.cover_flow_parent);
        this.e = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.e.setOnPageChangeListener(forumListActivity);
        this.f = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.g = (RelativeLayout) forumListActivity.findViewById(R.id.title);
        this.h = (ImageView) forumListActivity.findViewById(R.id.title_back);
        this.i = (TextView) forumListActivity.findViewById(R.id.title_text);
        this.t = (ImageView) forumListActivity.findViewById(R.id.home);
        this.h.setOnClickListener(forumListActivity);
        this.l = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.l.setOnClickListener(forumListActivity);
        this.m = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.m.setOnClickListener(forumListActivity);
        this.n = (LinearLayout) forumListActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.f824a = this.n.findViewById(R.id.footer_background);
        this.o = (TextView) this.n.findViewById(R.id.footer_text);
        this.p = (ImageView) this.n.findViewById(R.id.footer_icon);
        this.q = (LinearLayout) forumListActivity.getLayoutInflater().inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.b = this.q.findViewById(R.id.footer_background);
        this.r = (TextView) this.q.findViewById(R.id.footer_text);
        this.s = (ImageView) this.q.findViewById(R.id.footer_icon);
    }
}
