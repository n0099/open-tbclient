package com.baidu.tieba.im.groupActivity;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.baidu.tieba.y;
import java.util.Calendar;
/* loaded from: classes.dex */
class g implements DatePickerDialog.OnDateSetListener {
    private final /* synthetic */ Calendar aZi;
    final /* synthetic */ f aZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, Calendar calendar) {
        this.aZj = fVar;
        this.aZi = calendar;
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
        int i4 = this.aZi.get(1);
        int i5 = this.aZi.get(2);
        int i6 = this.aZi.get(5);
        if (i < i4 || ((i == i4 && i2 < i5) || (i == i4 && i2 == i5 && i3 < i6))) {
            eVar = this.aZj.aZh;
            createGroupActivityActivity = eVar.aYQ;
            createGroupActivityActivity.showToast(y.group_activity_time_val);
            return;
        }
        eVar2 = this.aZj.aZh;
        eVar2.aZb = i;
        eVar3 = this.aZj.aZh;
        eVar3.aZc = i2;
        eVar4 = this.aZj.aZh;
        eVar4.aZd = i3;
        eVar5 = this.aZj.aZh;
        datePickerDialog = eVar5.aYY;
        datePickerDialog.dismiss();
        eVar6 = this.aZj.aZh;
        eVar6.Od();
        eVar7 = this.aZj.aZh;
        eVar7.aZg = true;
    }
}
