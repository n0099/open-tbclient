package com.baidu.tieba.im.frsgroup;

import android.widget.CompoundButton;
import java.util.Set;
/* loaded from: classes.dex */
class ab implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.f1554a = aaVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Set set;
        ac acVar;
        ac acVar2;
        Set set2;
        Set set3;
        Long l = (Long) compoundButton.getTag();
        if (z) {
            set3 = this.f1554a.g;
            set3.add(l);
        } else {
            set = this.f1554a.g;
            set.remove(l);
        }
        acVar = this.f1554a.b;
        if (acVar != null) {
            acVar2 = this.f1554a.b;
            set2 = this.f1554a.g;
            acVar2.a(set2.size());
        }
    }
}
