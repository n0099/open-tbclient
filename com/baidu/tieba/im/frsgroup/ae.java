package com.baidu.tieba.im.frsgroup;

import android.view.View;
import java.util.Set;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ ad aYk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.aYk = adVar;
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
            set3 = this.aYk.aYj;
            set3.add(l);
        } else {
            set = this.aYk.aYj;
            set.remove(l);
        }
        afVar = this.aYk.aYg;
        if (afVar != null) {
            afVar2 = this.aYk.aYg;
            set2 = this.aYk.aYj;
            afVar2.fI(set2.size());
        }
    }
}
