package com.baidu.tieba.forumfeed;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
public class h {
    public static final View a(com.baidu.tbadk.core.e eVar, String str, int i, View.OnClickListener onClickListener) {
        i iVar = new i(null);
        View inflate = LinearLayout.inflate(eVar, s.forum_feed_guide, null);
        iVar.a = (LinearLayout) inflate.findViewById(r.forum_feed_login_container);
        iVar.c = (NoNetworkView) inflate.findViewById(r.view_no_network);
        iVar.b = new com.baidu.tbadk.core.view.b(eVar, str, str, 0);
        iVar.a.addView(iVar.b.b());
        inflate.setTag(iVar);
        a(eVar, inflate, i);
        return inflate;
    }

    public static final int a() {
        return r.login_btn;
    }

    public static final int b() {
        return r.reg_btn;
    }

    public static final int c() {
        return r.btn_go;
    }

    public static void a(com.baidu.tbadk.core.e eVar, View view, int i) {
        i iVar = (i) view.getTag();
        eVar.a().a(i == 1);
        eVar.a().a(view);
        if (iVar != null) {
            iVar.b.b(i);
            iVar.c.a(i);
        }
    }
}
