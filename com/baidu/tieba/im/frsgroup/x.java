package com.baidu.tieba.im.frsgroup;

import android.view.View;
import java.util.Set;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Set set;
        y yVar;
        y yVar2;
        Set set2;
        Set set3;
        view.setSelected(!view.isSelected());
        boolean isSelected = view.isSelected();
        Long l = (Long) view.getTag();
        if (isSelected) {
            set3 = this.a.g;
            set3.add(l);
        } else {
            set = this.a.g;
            set.remove(l);
        }
        yVar = this.a.b;
        if (yVar != null) {
            yVar2 = this.a.b;
            set2 = this.a.g;
            yVar2.a(set2.size());
        }
    }
}
