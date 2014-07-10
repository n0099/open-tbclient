package com.baidu.tieba.im.groupActivity;

import android.app.TimePickerDialog;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.a = eVar;
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
        timePickerDialog = this.a.m;
        if (timePickerDialog == null) {
            i iVar = new i(this);
            e eVar = this.a;
            createGroupActivityActivity = this.a.a;
            i3 = this.a.r;
            i4 = this.a.s;
            eVar.m = new TimePickerDialog(createGroupActivityActivity, iVar, i3, i4, false);
        }
        timePickerDialog2 = this.a.m;
        i = this.a.r;
        i2 = this.a.s;
        timePickerDialog2.updateTime(i, i2);
        timePickerDialog3 = this.a.m;
        timePickerDialog3.show();
    }
}
