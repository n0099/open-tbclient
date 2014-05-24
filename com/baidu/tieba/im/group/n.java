package com.baidu.tieba.im.group;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
class n {
    LinearLayout a;
    GroupTabWidget b;
    View c;

    private n() {
    }

    public static n a(View view) {
        n nVar = new n();
        nVar.a = (LinearLayout) view.findViewById(v.parent);
        nVar.b = (GroupTabWidget) view.findViewById(v.text_widget);
        nVar.c = view.findViewById(v.blank);
        return nVar;
    }
}
