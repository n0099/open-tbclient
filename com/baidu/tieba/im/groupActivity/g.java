package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.baidu.tieba.y;
import java.util.Calendar;
/* loaded from: classes.dex */
class g implements DatePickerDialog.OnDateSetListener {
    private final /* synthetic */ Calendar aYV;
    final /* synthetic */ f aYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Calendar calendar) {
        this.aYW = fVar;
        this.aYV = calendar;
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
        int i4 = this.aYV.get(1);
        int i5 = this.aYV.get(2);
        int i6 = this.aYV.get(5);
        if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
            eVar = this.aYW.aYU;
            createGroupActivityActivity = eVar.aYD;
            createGroupActivityActivity.showToast(y.group_activity_time_val);
            return;
        }
        eVar2 = this.aYW.aYU;
        eVar2.aYO = i;
        eVar3 = this.aYW.aYU;
        eVar3.aYP = i2;
        eVar4 = this.aYW.aYU;
        eVar4.aYQ = i3;
        eVar5 = this.aYW.aYU;
        datePickerDialog = eVar5.aYL;
        datePickerDialog.dismiss();
        eVar6 = this.aYW.aYU;
        eVar6.Oa();
        eVar7 = this.aYW.aYU;
        eVar7.aYT = true;
    }
}
