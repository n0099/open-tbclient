package com.baidu.tieba.im.frsgroup;

import android.view.View;
import java.util.Set;
/* loaded from: classes.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.a = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Set set;
        ad adVar;
        ad adVar2;
        Set set2;
        Set set3;
        view.setSelected(!view.isSelected());
        boolean isSelected = view.isSelected();
        Long l = (Long) view.getTag();
        if (isSelected) {
            set3 = this.a.f;
            set3.add(l);
        } else {
            set = this.a.f;
            set.remove(l);
        }
        adVar = this.a.b;
        if (adVar != null) {
            adVar2 = this.a.b;
            set2 = this.a.f;
            adVar2.a(set2.size());
        }
    }
}
