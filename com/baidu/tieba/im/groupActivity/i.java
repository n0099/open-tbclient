package com.baidu.tieba.im.groupActivity;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
/* loaded from: classes.dex */
class i implements TimePickerDialog.OnTimeSetListener {
    final /* synthetic */ h aZk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.aZk = hVar;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        e eVar;
        e eVar2;
        e eVar3;
        TimePickerDialog timePickerDialog;
        e eVar4;
        e eVar5;
        eVar = this.aZk.aZh;
        eVar.aZe = i;
        eVar2 = this.aZk.aZh;
        eVar2.aZf = i2;
        eVar3 = this.aZk.aZh;
        timePickerDialog = eVar3.aYZ;
        timePickerDialog.dismiss();
        eVar4 = this.aZk.aZh;
        eVar4.Oc();
        eVar5 = this.aZk.aZh;
        eVar5.aZg = true;
    }
}
