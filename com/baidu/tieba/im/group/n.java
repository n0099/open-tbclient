package com.baidu.tieba.im.group;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class n {
    LinearLayout a;
    GroupTabWidget b;
    View c;

    private n() {
    }

    public static n a(View view) {
        n nVar = new n();
        nVar.a = (LinearLayout) view.findViewById(r.parent);
        nVar.b = (GroupTabWidget) view.findViewById(r.text_widget);
        nVar.c = view.findViewById(r.blank);
        return nVar;
    }
}
