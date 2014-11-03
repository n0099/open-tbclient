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
        iVar.Pg = (LinearLayout) inflate.findViewById(v.forum_feed_login_container);
        iVar.ayp = (NoNetworkView) inflate.findViewById(v.view_no_network);
        iVar.ayo = new com.baidu.tbadk.core.view.d(baseFragmentActivity, str, str, 0);
        iVar.Pg.addView(iVar.ayo.getView());
        inflate.setTag(iVar);
        a(baseFragmentActivity, inflate, i);
        return inflate;
    }

    public static final int Em() {
        return v.login_btn;
    }

    public static final int En() {
        return v.reg_btn;
    }

    public static void a(BaseFragmentActivity baseFragmentActivity, View view, int i) {
        i iVar = (i) view.getTag();
        baseFragmentActivity.getLayoutMode().L(i == 1);
        baseFragmentActivity.getLayoutMode().h(view);
        if (iVar != null) {
            iVar.ayo.bG(i);
            iVar.ayp.onChangeSkinType(i);
        }
    }

    public static void y(View view) {
        i iVar;
        if (view != null && view.getTag() != null && (iVar = (i) view.getTag()) != null && iVar.ayo != null) {
            iVar.ayo.onStop();
        }
    }
}
