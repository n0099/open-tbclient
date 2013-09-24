package com.baidu.tieba.forumfeed;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tieba.util.as;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class f {
    public static final View a(com.baidu.tieba.j jVar, String str, int i, View.OnClickListener onClickListener) {
        g gVar = new g(null);
        View inflate = LinearLayout.inflate(jVar, R.layout.forum_feed_guide, null);
        gVar.b = (RelativeLayout) inflate.findViewById(R.id.title);
        gVar.f1103a = (LinearLayout) inflate.findViewById(R.id.forum_feed_login_container);
        gVar.d = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        gVar.c = new com.baidu.tieba.home.l(jVar, str, str, 0);
        gVar.f1103a.addView(gVar.c.c());
        inflate.setTag(gVar);
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
        g gVar = (g) view.getTag();
        jVar.l().a(i == 1);
        jVar.l().a(view);
        if (gVar != null) {
            gVar.c.b(i);
            as.d(gVar.b, i);
            gVar.d.a(i);
        }
    }
}
