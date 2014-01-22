package com.baidu.tieba.im.frsgroup;

import android.view.View;
import java.util.Set;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Set set;
        aa aaVar;
        aa aaVar2;
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
        aaVar = this.a.b;
        if (aaVar != null) {
            aaVar2 = this.a.b;
            set2 = this.a.g;
            aaVar2.a(set2.size());
        }
    }
}
