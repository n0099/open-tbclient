package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class e implements a {
    private static final long bZy = 1 * ap.bKK;
    private com.baidu.tbadk.widget.timepicker.a.f.b bZz;

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public boolean isSignAlertOn() {
        return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public void setSignAlertOn(boolean z) {
        TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
        updateSignAlarm();
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public void updateSignAlarm() {
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        AlarmManager alarmManager = (AlarmManager) inst.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent createIntentForSignAlarm = createIntentForSignAlarm();
        if (isSignAlertOn()) {
            Calendar calendar = Calendar.getInstance();
            int signAlertHours = getSignAlertHours();
            int i = calendar.get(11);
            int signAlertMins = getSignAlertMins();
            int i2 = calendar.get(12);
            calendar.set(11, signAlertHours);
            calendar.set(12, signAlertMins);
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (i >= signAlertHours && (i != signAlertHours || i2 >= signAlertMins)) {
                calendar.set(6, calendar.get(6) + 1);
            }
            alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(inst, 0, createIntentForSignAlarm, 134217728));
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(inst, 0, createIntentForSignAlarm, 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
        }
    }

    public Intent createIntentForSignAlarm() {
        Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
        intent.setData(Uri.parse("tieba_sign://alert"));
        intent.setClass(TbadkCoreApplication.getInst(), SignAlertReceiver.class);
        return intent;
    }

    private void prepareForDefaultAlertTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis() + bZy);
        setSignAlertTime(calendar.get(11), calendar.get(12));
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public int getSignAlertHours() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
        }
        return loadInt;
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public int getSignAlertMins() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
        }
        return loadInt;
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public void setSignAlertTime(int i, int i2) {
        TbadkSettings.getInst().saveInt("alert_sign_hours", i);
        TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
        updateSignAlarm();
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public void a(TbPageContext tbPageContext, final RelativeLayout relativeLayout) {
        final Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null && g.q(pageActivity) && !d.aih().isSignAlertOn() && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("sign_time_set_dialog", 0) <= 0) {
            a(tbPageContext, new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.e
                public void a(Date date, View view) {
                    if (date != null) {
                        e.this.setSignAlertOn(true);
                        d.aih().setSignAlertTime(date.getHours(), date.getMinutes());
                        e.this.b(pageActivity, relativeLayout);
                    }
                }
            });
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("sign_time_set_dialog", 1);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public Dialog a(final TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        Activity pageActivity;
        if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !g.q(pageActivity)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int signAlertHours = d.aih().getSignAlertHours();
        int signAlertMins = d.aih().getSignAlertMins();
        if (signAlertHours > 0 && signAlertMins > 0) {
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), signAlertHours, signAlertMins);
        } else {
            calendar.setTimeInMillis(System.currentTimeMillis() + bZy);
        }
        this.bZz = new com.baidu.tbadk.widget.timepicker.a.b.a(pageActivity, eVar).a(calendar).a(d.h.dialog_sign_remind, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.2
            @Override // com.baidu.tbadk.widget.timepicker.a.d.a
            public void aT(View view) {
                com.baidu.tbadk.r.a.a(tbPageContext, view);
                View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.2.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        return true;
                    }
                };
                View findViewById = view.findViewById(d.g.layout_bottom_title);
                View findViewById2 = view.findViewById(d.g.layout_content);
                findViewById.setOnTouchListener(onTouchListener);
                findViewById2.setOnTouchListener(onTouchListener);
                ((TextView) view.findViewById(d.g.dialog_yes)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (e.this.bZz != null) {
                            e.this.bZz.atE();
                            e.this.bZz.dismiss();
                        }
                        am amVar = new am("c13250");
                        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(amVar);
                    }
                });
                ((ImageView) view.findViewById(d.g.dialog_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.2.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (e.this.bZz != null) {
                            e.this.bZz.dismiss();
                        }
                        am amVar = new am("c13251");
                        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(amVar);
                    }
                });
            }
        }).kR(18).b(new boolean[]{false, false, false, true, true, false}).b("年", "月", "日", "时", "分", "秒").at(2.0f).e(0, 0, 0, 0, 0, 0).fv(false).kS(al.getColor(d.C0236d.cp_bg_line_b)).kU(al.getColor(d.C0236d.cp_cont_b)).kV(al.getColor(d.C0236d.cp_cont_d)).kT(al.getColor(d.C0236d.black_alpha30)).kQ(al.getColor(d.C0236d.cp_bg_line_d)).atu();
        this.bZz.show();
        am amVar = new am("c13249");
        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(amVar);
        return this.bZz.getDialog();
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            return null;
        }
        View findViewById = relativeLayout.findViewById(d.g.navbar_cover_tip_view);
        if (findViewById != null) {
            relativeLayout.removeView(findViewById);
        }
        NavigationBarCoverTip navigationBarCoverTip = new NavigationBarCoverTip(activity);
        navigationBarCoverTip.setId(d.g.navbar_cover_tip_view);
        relativeLayout.addView(navigationBarCoverTip, new RelativeLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(activity);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setMinHeight(getDimensionPixelSize(d.e.tbds112));
        int dimensionPixelSize = getDimensionPixelSize(d.e.tbds20);
        textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        textView.setGravity(17);
        textView.setTextSize(0, getDimensionPixelSize(d.e.tbfontsize42));
        textView.setLineSpacing(getDimensionPixelSize(d.e.ds2), 1.0f);
        textView.setText(activity.getString(d.j.sign_remind_timer_succ));
        al.j(textView, d.C0236d.cp_btn_a);
        al.l(navigationBarCoverTip, d.C0236d.cp_link_tip_a_alpha95);
        navigationBarCoverTip.g(activity, textView);
        return navigationBarCoverTip;
    }

    private int getDimensionPixelSize(int i) {
        return l.h(TbadkCoreApplication.getInst(), i);
    }
}
