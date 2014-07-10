package com.baidu.tieba.im.frsgroup;

import android.view.View;
import java.util.Set;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Set set;
        ae aeVar;
        ae aeVar2;
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
        aeVar = this.a.b;
        if (aeVar != null) {
            aeVar2 = this.a.b;
            set2 = this.a.f;
            aeVar2.a(set2.size());
        }
    }
}
