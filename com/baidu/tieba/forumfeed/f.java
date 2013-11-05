package com.baidu.tieba.forumfeed;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tieba.home.p;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class f {
    public static final View a(com.baidu.tieba.j jVar, String str, int i, View.OnClickListener onClickListener) {
        h hVar = new h();
        View inflate = LinearLayout.inflate(jVar, R.layout.forum_feed_guide, null);
        hVar.b = (RelativeLayout) inflate.findViewById(R.id.title);
        hVar.f1235a = (LinearLayout) inflate.findViewById(R.id.forum_feed_login_container);
        hVar.d = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        hVar.c = new p(jVar, str, str, 0);
        hVar.f1235a.addView(hVar.c.e());
        inflate.setTag(hVar);
        a(jVar, inflate, i);
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

    public static void a(com.baidu.tieba.j jVar, View view, int i) {
        h hVar = (h) view.getTag();
        jVar.m().a(i == 1);
        jVar.m().a(view);
        if (hVar != null) {
            hVar.c.b(i);
            bb.d(hVar.b, i);
            hVar.d.a(i);
        }
    }
}
