package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.view.View;
import java.util.Calendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aYU;
    private final /* synthetic */ Calendar aYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Calendar calendar) {
        this.aYU = eVar;
        this.aYV = calendar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DatePickerDialog datePickerDialog;
        DatePickerDialog datePickerDialog2;
        int i;
        int i2;
        int i3;
        DatePickerDialog datePickerDialog3;
        CreateGroupActivityActivity createGroupActivityActivity;
        int i4;
        int i5;
        int i6;
        datePickerDialog = this.aYU.aYL;
        if (datePickerDialog == null) {
            g gVar = new g(this, this.aYV);
            e eVar = this.aYU;
            createGroupActivityActivity = this.aYU.aYD;
            i4 = this.aYU.aYO;
            i5 = this.aYU.aYP;
            i6 = this.aYU.aYQ;
            eVar.aYL = new DatePickerDialog(createGroupActivityActivity, gVar, i4, i5, i6);
        }
        datePickerDialog2 = this.aYU.aYL;
        i = this.aYU.aYO;
        i2 = this.aYU.aYP;
        i3 = this.aYU.aYQ;
        datePickerDialog2.updateDate(i, i2, i3);
        datePickerDialog3 = this.aYU.aYL;
        datePickerDialog3.show();
    }
}
