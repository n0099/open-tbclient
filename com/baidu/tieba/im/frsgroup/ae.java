package com.baidu.tieba.im.frsgroup;

import android.view.View;
import java.util.Set;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ ad a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.a = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Set set;
        af afVar;
        af afVar2;
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
        afVar = this.a.b;
        if (afVar != null) {
            afVar2 = this.a.b;
            set2 = this.a.g;
            afVar2.a(set2.size());
        }
    }
}
