package com.baidu.tieba.im.frsgroup;

import android.view.View;
import java.util.Set;
/* loaded from: classes.dex */
final class ab implements View.OnClickListener {
    final /* synthetic */ aa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.a = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Set set;
        ac acVar;
        ac acVar2;
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
        acVar = this.a.b;
        if (acVar != null) {
            acVar2 = this.a.b;
            set2 = this.a.g;
            acVar2.a(set2.size());
        }
    }
}
