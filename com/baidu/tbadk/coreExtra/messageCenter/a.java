package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.Activity;
import android.app.Dialog;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes.dex */
public interface a {
    Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar);

    void a(TbPageContext tbPageContext, RelativeLayout relativeLayout);

    NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout);

    int getSignAlertHours();

    int getSignAlertMins();

    boolean isSignAlertOn();

    void setSignAlertOn(boolean z);

    void setSignAlertTime(int i, int i2);

    void updateSignAlarm();
}
