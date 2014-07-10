package com.baidu.tieba.forumfeed;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h {
    public static final View a(BaseFragmentActivity baseFragmentActivity, String str, int i, View.OnClickListener onClickListener) {
        i iVar = new i(null);
        View inflate = LinearLayout.inflate(baseFragmentActivity, w.forum_feed_guide, null);
        iVar.a = (LinearLayout) inflate.findViewById(v.forum_feed_login_container);
        iVar.c = (NoNetworkView) inflate.findViewById(v.view_no_network);
        iVar.b = new com.baidu.tbadk.core.view.b(baseFragmentActivity, str, str, 0);
        iVar.a.addView(iVar.b.b());
        inflate.setTag(iVar);
        a(baseFragmentActivity, inflate, i);
        return inflate;
    }

    public static final int a() {
        return v.login_btn;
    }

    public static final int b() {
        return v.reg_btn;
    }

    public static final int c() {
        return v.btn_go;
    }

    public static void a(BaseFragmentActivity baseFragmentActivity, View view, int i) {
        i iVar = (i) view.getTag();
        baseFragmentActivity.c().a(i == 1);
        baseFragmentActivity.c().a(view);
        if (iVar != null) {
            iVar.b.b(i);
            iVar.c.a(i);
        }
    }

    public static void a(View view) {
        i iVar;
        if (view != null && view.getTag() != null && (iVar = (i) view.getTag()) != null && iVar.b != null) {
            iVar.b.d();
        }
    }
}
