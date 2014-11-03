package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.view.View;
import java.util.Calendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e aZh;
    private final /* synthetic */ Calendar aZi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Calendar calendar) {
        this.aZh = eVar;
        this.aZi = calendar;
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
        datePickerDialog = this.aZh.aYY;
        if (datePickerDialog == null) {
            g gVar = new g(this, this.aZi);
            e eVar = this.aZh;
            createGroupActivityActivity = this.aZh.aYQ;
            i4 = this.aZh.aZb;
            i5 = this.aZh.aZc;
            i6 = this.aZh.aZd;
            eVar.aYY = new DatePickerDialog(createGroupActivityActivity, gVar, i4, i5, i6);
        }
        datePickerDialog2 = this.aZh.aYY;
        i = this.aZh.aZb;
        i2 = this.aZh.aZc;
        i3 = this.aZh.aZd;
        datePickerDialog2.updateDate(i, i2, i3);
        datePickerDialog3 = this.aZh.aYY;
        datePickerDialog3.show();
    }
}
