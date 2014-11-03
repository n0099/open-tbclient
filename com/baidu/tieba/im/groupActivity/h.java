package com.baidu.tieba.im.groupActivity;

import android.app.TimePickerDialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ e aZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aZh = eVar;
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
        timePickerDialog = this.aZh.aYZ;
        if (timePickerDialog == null) {
            i iVar = new i(this);
            e eVar = this.aZh;
            createGroupActivityActivity = this.aZh.aYQ;
            i3 = this.aZh.aZe;
            i4 = this.aZh.aZf;
            eVar.aYZ = new TimePickerDialog(createGroupActivityActivity, iVar, i3, i4, false);
        }
        timePickerDialog2 = this.aZh.aYZ;
        i = this.aZh.aZe;
        i2 = this.aZh.aZf;
        timePickerDialog2.updateTime(i, i2);
        timePickerDialog3 = this.aZh.aYZ;
        timePickerDialog3.show();
    }
}
