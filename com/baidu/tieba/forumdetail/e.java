package com.baidu.tieba.forumdetail;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class e extends com.baidu.adp.a.e {
    com.baidu.tieba.f a;
    private ForumDetailData c;
    private ViewGroup d;
    private ProgressBar e;
    private NavigationBar f;
    private ItemHeaderView g;
    private ItemInfoView h;
    private ItemHotThreadView i;
    private ItemFootNavView j;

    public e(com.baidu.tieba.f fVar) {
        super(fVar);
        this.a = null;
        this.c = null;
        this.d = null;
        this.a = fVar;
        this.a.setContentView(R.layout.forum_detail_activity);
        this.f = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.f.a(this.a.getString(R.string.forum_detail_title));
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.HOME_BUTTON);
        this.g = (ItemHeaderView) this.a.findViewById(R.id.item_header);
        this.h = (ItemInfoView) this.a.findViewById(R.id.item_info);
        this.i = (ItemHotThreadView) this.a.findViewById(R.id.item_hot_thread);
        this.j = (ItemFootNavView) this.a.findViewById(R.id.item_foot_nav);
        this.d = (ViewGroup) this.a.findViewById(R.id.parent);
        this.e = new ProgressBar(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.e.setLayoutParams(layoutParams);
        this.e.setIndeterminateDrawable(this.a.getResources().getDrawable(R.drawable.progressbar));
        this.e.setVisibility(8);
        ((ViewGroup) this.a.findViewById(16908290)).addView(this.e);
        this.e.setVisibility(0);
    }

    public final void a(ForumDetailData forumDetailData) {
        this.c = forumDetailData;
        this.e.setVisibility(8);
        if (this.g.a(this.c)) {
            this.g.setVisibility(0);
        }
        if (this.h.a(this.c, this.a)) {
            this.h.setVisibility(0);
        }
        if (this.i.a(this.c)) {
            this.i.setVisibility(0);
        }
        if (this.j.a(this.c, this.a)) {
            this.j.setVisibility(0);
        }
    }

    public final void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.d);
        this.f.b(i);
        this.g.a(this.a, i);
        this.h.a(this.a, i);
        this.i.a(this.a, i);
        this.j.a(this.a, i);
    }

    public final void a() {
        this.j.a(this.a);
    }
}
