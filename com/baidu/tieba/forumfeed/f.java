package com.baidu.tieba.forumfeed;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.home.s;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class f {
    public static final View a(BaseFragmentActivity baseFragmentActivity, String str, int i, View.OnClickListener onClickListener) {
        h hVar = new h();
        View inflate = LinearLayout.inflate(baseFragmentActivity, R.layout.forum_feed_guide, null);
        hVar.b = (NavigationBar) inflate.findViewById(R.id.view_navigation_bar);
        hVar.b.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.nb_item_tieba_logo, (View.OnClickListener) null);
        hVar.f1297a = (LinearLayout) inflate.findViewById(R.id.forum_feed_login_container);
        hVar.d = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        hVar.c = new s(baseFragmentActivity, str, str, 0);
        hVar.f1297a.addView(hVar.c.e());
        inflate.setTag(hVar);
        a(baseFragmentActivity, inflate, i);
        return inflate;
    }

    public static final int a() {
        return R.id.login_btn;
    }

    public static final int b() {
        return R.id.reg_btn;
    }

    public static final int c() {
        return R.id.btn_go;
    }

    public static void a(BaseFragmentActivity baseFragmentActivity, View view, int i) {
        h hVar = (h) view.getTag();
        baseFragmentActivity.a().a(i == 1);
        baseFragmentActivity.a().a(view);
        if (hVar != null) {
            hVar.c.b(i);
            hVar.b.c(i);
            hVar.d.a(i);
        }
    }
}
