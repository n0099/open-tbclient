package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.view.NoNetworkView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class q {
    public static final View a(Context context, String str, int i, View.OnClickListener onClickListener) {
        r rVar = new r(null);
        View inflate = LinearLayout.inflate(context, R.layout.forum_feed_guide, null);
        rVar.c = (TextView) inflate.findViewById(R.id.titel_text);
        rVar.b = (RelativeLayout) inflate.findViewById(R.id.title);
        rVar.f1193a = (LinearLayout) inflate.findViewById(R.id.forum_feed_login_container);
        rVar.e = (NoNetworkView) inflate.findViewById(R.id.view_no_network);
        rVar.d = new z((Activity) context, str, str, 0);
        rVar.f1193a.addView(rVar.d.c());
        inflate.setTag(rVar);
        a(inflate, i);
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

    public static void a(View view, int i) {
        r rVar = (r) view.getTag();
        if (rVar != null) {
            if (i == 1) {
                rVar.f1193a.setBackgroundColor(-13618114);
            } else {
                rVar.f1193a.setBackgroundColor(-328966);
            }
            rVar.d.b(i);
            com.baidu.tieba.util.ao.d(rVar.b, i);
            com.baidu.tieba.util.ao.f(rVar.c, i);
            rVar.e.a(i);
        }
    }
}
