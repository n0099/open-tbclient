package com.baidu.tieba.im.frsgroup;

import android.view.View;
import java.util.Set;
/* loaded from: classes.dex */
class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f1726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f1726a = wVar;
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
            set3 = this.f1726a.g;
            set3.add(l);
        } else {
            set = this.f1726a.g;
            set.remove(l);
        }
        yVar = this.f1726a.b;
        if (yVar != null) {
            yVar2 = this.f1726a.b;
            set2 = this.f1726a.g;
            yVar2.a(set2.size());
        }
    }
}
