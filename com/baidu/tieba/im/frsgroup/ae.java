package com.baidu.tieba.im.frsgroup;

import android.view.View;
import java.util.Set;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ ad aXW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.aXW = adVar;
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
            set3 = this.aXW.aXV;
            set3.add(l);
        } else {
            set = this.aXW.aXV;
            set.remove(l);
        }
        afVar = this.aXW.aXS;
        if (afVar != null) {
            afVar2 = this.aXW.aXS;
            set2 = this.aXW.aXV;
            afVar2.fI(set2.size());
        }
    }
}
