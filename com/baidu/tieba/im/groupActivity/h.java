package com.baidu.tieba.im.groupActivity;

import android.app.TimePickerDialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ e aYU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aYU = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TimePickerDialog timePickerDialog;
        TimePickerDialog timePickerDialog2;
        int i;
        int i2;
        TimePickerDialog timePickerDialog3;
        CreateGroupActivityActivity createGroupActivityActivity;
        int i3;
        int i4;
        timePickerDialog = this.aYU.aYM;
        if (timePickerDialog == null) {
            i iVar = new i(this);
            e eVar = this.aYU;
            createGroupActivityActivity = this.aYU.aYD;
            i3 = this.aYU.aYR;
            i4 = this.aYU.aYS;
            eVar.aYM = new TimePickerDialog(createGroupActivityActivity, iVar, i3, i4, false);
        }
        timePickerDialog2 = this.aYU.aYM;
        i = this.aYU.aYR;
        i2 = this.aYU.aYS;
        timePickerDialog2.updateTime(i, i2);
        timePickerDialog3 = this.aYU.aYM;
        timePickerDialog3.show();
    }
}
