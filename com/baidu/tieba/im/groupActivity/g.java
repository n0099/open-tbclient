package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.baidu.tieba.x;
import java.util.Calendar;
/* loaded from: classes.dex */
class g implements DatePickerDialog.OnDateSetListener {
    final /* synthetic */ f a;
    private final /* synthetic */ Calendar b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Calendar calendar) {
        this.a = fVar;
        this.b = calendar;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
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
            createGroupActivityActivity.c(x.group_activity_time_val);
            return;
        }
        eVar2 = this.a.a;
        eVar2.o = i;
        eVar3 = this.a.a;
        eVar3.p = i2;
        eVar4 = this.a.a;
        eVar4.q = i3;
        eVar5 = this.a.a;
        datePickerDialog = eVar5.l;
        datePickerDialog.dismiss();
        eVar6 = this.a.a;
        eVar6.j();
        eVar7 = this.a.a;
        eVar7.t = true;
    }
}
