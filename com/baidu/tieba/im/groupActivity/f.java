package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.view.View;
import java.util.Calendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e a;
    private final /* synthetic */ Calendar b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Calendar calendar) {
        this.a = eVar;
        this.b = calendar;
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
        datePickerDialog = this.a.l;
        if (datePickerDialog == null) {
            g gVar = new g(this, this.b);
            e eVar = this.a;
            createGroupActivityActivity = this.a.a;
            i4 = this.a.o;
            i5 = this.a.p;
            i6 = this.a.q;
            eVar.l = new DatePickerDialog(createGroupActivityActivity, gVar, i4, i5, i6);
        }
        datePickerDialog2 = this.a.l;
        i = this.a.o;
        i2 = this.a.p;
        i3 = this.a.q;
        datePickerDialog2.updateDate(i, i2, i3);
        datePickerDialog3 = this.a.l;
        datePickerDialog3.show();
    }
}
