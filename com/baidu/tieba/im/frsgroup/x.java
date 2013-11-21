package com.baidu.tieba.im.frsgroup;

import android.widget.CompoundButton;
import java.util.Set;
/* loaded from: classes.dex */
class x implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f1658a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.f1658a = wVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Set set;
        y yVar;
        y yVar2;
        Set set2;
        Set set3;
        Long l = (Long) compoundButton.getTag();
        if (z) {
            set3 = this.f1658a.g;
            set3.add(l);
        } else {
            set = this.f1658a.g;
            set.remove(l);
        }
        yVar = this.f1658a.b;
        if (yVar != null) {
            yVar2 = this.f1658a.b;
            set2 = this.f1658a.g;
            yVar2.a(set2.size());
        }
    }
}
