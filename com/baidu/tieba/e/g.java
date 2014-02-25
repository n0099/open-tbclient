package com.baidu.tieba.e;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g {
    public static final View a(com.baidu.tieba.k kVar, String str, int i, View.OnClickListener onClickListener) {
        h hVar = new h(null);
        View inflate = LinearLayout.inflate(kVar, R.layout.forum_feed_guide, null);
        hVar.a = (LinearLayout) inflate.findViewById(R.id.forum_feed_login_container);
        hVar.c = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        hVar.b = new com.baidu.tieba.home.r(kVar, str, str, 0);
        hVar.a.addView(hVar.b.e());
        inflate.setTag(hVar);
        a(kVar, inflate, i);
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

    public static void a(com.baidu.tieba.k kVar, View view, int i) {
        h hVar = (h) view.getTag();
        kVar.a().a(i == 1);
        kVar.a().a(view);
        if (hVar != null) {
            hVar.b.b(i);
            hVar.c.a(i);
        }
    }
}
