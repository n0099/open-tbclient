package com.baidu.tieba.im.groupActivity;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
/* loaded from: classes.dex */
class i implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        e eVar;
        e eVar2;
        e eVar3;
        TimePickerDialog timePickerDialog;
        e eVar4;
        e eVar5;
        eVar = this.a.a;
        eVar.s = i;
        eVar2 = this.a.a;
        eVar2.t = i2;
        eVar3 = this.a.a;
        timePickerDialog = eVar3.n;
        timePickerDialog.dismiss();
        eVar4 = this.a.a;
        eVar4.l();
        eVar5 = this.a.a;
        eVar5.u = true;
    }
}
