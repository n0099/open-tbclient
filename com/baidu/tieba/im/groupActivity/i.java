package com.baidu.tieba.im.groupActivity;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
/* loaded from: classes.dex */
class i implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ h aYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aYX = hVar;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        e eVar;
        e eVar2;
        e eVar3;
        TimePickerDialog timePickerDialog;
        e eVar4;
        e eVar5;
        eVar = this.aYX.aYU;
        eVar.aYR = i;
        eVar2 = this.aYX.aYU;
        eVar2.aYS = i2;
        eVar3 = this.aYX.aYU;
        timePickerDialog = eVar3.aYM;
        timePickerDialog.dismiss();
        eVar4 = this.aYX.aYU;
        eVar4.NZ();
        eVar5 = this.aYX.aYU;
        eVar5.aYT = true;
    }
}
