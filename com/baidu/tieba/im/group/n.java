package com.baidu.tieba.im.group;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
final class n {
    LinearLayout a;
    GroupTabWidget b;
    View c;

    private n() {
    }

    public static n a(View view) {
        n nVar = new n();
        nVar.a = (LinearLayout) view.findViewById(com.baidu.tieba.im.h.parent);
        nVar.b = (GroupTabWidget) view.findViewById(com.baidu.tieba.im.h.text_widget);
        nVar.c = view.findViewById(com.baidu.tieba.im.h.blank);
        return nVar;
    }
}
