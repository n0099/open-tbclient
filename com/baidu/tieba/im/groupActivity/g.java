package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;
/* loaded from: classes.dex */
final class g implements DatePickerDialog.OnDateSetListener {
    final /* synthetic */ f a;
    private final /* synthetic */ Calendar b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Calendar calendar) {
        this.a = fVar;
        this.b = calendar;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        e eVar;
        CreateGroupActivityActivity createGroupActivityActivity;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        DatePickerDialog datePickerDialog;
        e eVar6;
        e eVar7;
        int i4 = this.b.get(1);
        int i5 = this.b.get(2);
        int i6 = this.b.get(5);
        if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
            eVar = this.a.a;
            createGroupActivityActivity = eVar.a;
            createGroupActivityActivity.d(com.baidu.tieba.im.j.group_activity_time_val);
            return;
        }
        eVar2 = this.a.a;
        eVar2.p = i;
        eVar3 = this.a.a;
        eVar3.q = i2;
        eVar4 = this.a.a;
        eVar4.r = i3;
        eVar5 = this.a.a;
        datePickerDialog = eVar5.m;
        datePickerDialog.dismiss();
        eVar6 = this.a.a;
        eVar6.k();
        eVar7 = this.a.a;
        eVar7.u = true;
    }
}
