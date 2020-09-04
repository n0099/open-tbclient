package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.Activity;
import android.app.Dialog;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes.dex */
public interface a {
    Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar);

    NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup);

    void a(TbPageContext tbPageContext, ViewGroup viewGroup);

    int getSignAlertHours();

    int getSignAlertMins();

    boolean isSignAlertOn();

    void setSignAlertOn(boolean z);

    void setSignAlertTime(int i, int i2);

    void updateSignAlarm();
}
