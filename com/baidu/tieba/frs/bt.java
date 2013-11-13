package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bs f1345a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar) {
        this.f1345a = bsVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        com.baidu.tieba.d.a.a().b(switchState == BdSwitchView.SwitchState.ON);
        this.f1345a.r = true;
    }
}
