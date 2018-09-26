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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tieba.e;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes.dex */
public class d {
    private static final long aHA = 1 * ao.atp;
    private static d aHz;
    private com.baidu.tbadk.widget.timepicker.a.f.b aHB;

    public static d FA() {
        if (aHz == null) {
            synchronized (d.class) {
                if (aHz == null) {
                    aHz = new d();
                }
            }
        }
        return aHz;
    }

    public boolean isSignAlertOn() {
        return TbadkSettings.getInst().loadBoolean("alert_sign_on", false);
    }

    public void setSignAlertOn(boolean z) {
        TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
        updateSignAlarm();
    }

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
        calendar.setTimeInMillis(System.currentTimeMillis() + aHA);
        setSignAlertTime(calendar.get(11), calendar.get(12));
    }

    public int getSignAlertHours() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
        }
        return loadInt;
    }

    public int getSignAlertMins() {
        int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
        }
        return loadInt;
    }

    public void setSignAlertTime(int i, int i2) {
        TbadkSettings.getInst().saveInt("alert_sign_hours", i);
        TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
        updateSignAlarm();
    }

    public void a(TbPageContext tbPageContext, final RelativeLayout relativeLayout) {
        final Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null && g.q(pageActivity) && !c.Ff().isSignAlertOn() && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("sign_time_set_dialog", 0) <= 0) {
            a(tbPageContext, new e() { // from class: com.baidu.tbadk.coreExtra.messageCenter.d.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.e
                public void a(Date date, View view) {
                    if (date != null) {
                        d.this.setSignAlertOn(true);
                        c.Ff().setSignAlertTime(date.getHours(), date.getMinutes());
                        d.FA().b(pageActivity, relativeLayout);
                    }
                }
            });
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("sign_time_set_dialog", 1);
        }
    }

    public Dialog a(final TbPageContext tbPageContext, e eVar) {
        Activity pageActivity;
        if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !g.q(pageActivity)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int signAlertHours = c.Ff().getSignAlertHours();
        int signAlertMins = c.Ff().getSignAlertMins();
        if (signAlertHours > 0 && signAlertMins > 0) {
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), signAlertHours, signAlertMins);
        } else {
            calendar.setTimeInMillis(System.currentTimeMillis() + aHA);
        }
        this.aHB = new com.baidu.tbadk.widget.timepicker.a.b.a(pageActivity, eVar).a(calendar).a(e.h.dialog_sign_remind, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tbadk.coreExtra.messageCenter.d.2
            @Override // com.baidu.tbadk.widget.timepicker.a.d.a
            public void Z(View view) {
                com.baidu.tbadk.o.a.a(tbPageContext, view);
                View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.messageCenter.d.2.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        return true;
                    }
                };
                View findViewById = view.findViewById(e.g.layout_bottom_title);
                View findViewById2 = view.findViewById(e.g.layout_content);
                findViewById.setOnTouchListener(onTouchListener);
                findViewById2.setOnTouchListener(onTouchListener);
                ((TextView) view.findViewById(e.g.dialog_yes)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.messageCenter.d.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (d.this.aHB != null) {
                            d.this.aHB.PY();
                            d.this.aHB.dismiss();
                        }
                        am amVar = new am("c13250");
                        amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(amVar);
                    }
                });
                ((ImageView) view.findViewById(e.g.dialog_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.messageCenter.d.2.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (d.this.aHB != null) {
                            d.this.aHB.dismiss();
                        }
                        am amVar = new am("c13251");
                        amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(amVar);
                    }
                });
            }
        }).gq(18).b(new boolean[]{false, false, false, true, true, false}).b("年", "月", "日", "时", "分", "秒").ad(2.0f).d(0, 0, 0, 0, 0, 0).cB(false).gr(al.getColor(e.d.cp_bg_line_b)).gt(al.getColor(e.d.cp_cont_b)).gu(al.getColor(e.d.cp_cont_d)).gs(al.getColor(e.d.black_alpha30)).gp(al.getColor(e.d.cp_bg_line_d)).PN();
        this.aHB.show();
        am amVar = new am("c13249");
        amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(amVar);
        return this.aHB.getDialog();
    }

    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            return null;
        }
        View findViewById = relativeLayout.findViewById(e.g.navbar_cover_tip_view);
        if (findViewById != null) {
            relativeLayout.removeView(findViewById);
        }
        NavigationBarCoverTip navigationBarCoverTip = new NavigationBarCoverTip(activity);
        navigationBarCoverTip.setId(e.g.navbar_cover_tip_view);
        relativeLayout.addView(navigationBarCoverTip, new RelativeLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(activity);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setMinHeight(getDimensionPixelSize(e.C0141e.tbds112));
        int dimensionPixelSize = getDimensionPixelSize(e.C0141e.tbds20);
        textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        textView.setGravity(17);
        textView.setTextSize(0, getDimensionPixelSize(e.C0141e.tbfontsize42));
        textView.setLineSpacing(getDimensionPixelSize(e.C0141e.ds2), 1.0f);
        textView.setText(activity.getString(e.j.sign_remind_timer_succ));
        al.h(textView, e.d.cp_cont_i);
        al.j(navigationBarCoverTip, e.d.cp_link_tip_a_alpha95);
        navigationBarCoverTip.f(activity, textView);
        return navigationBarCoverTip;
    }

    private int getDimensionPixelSize(int i) {
        return l.h(TbadkCoreApplication.getInst(), i);
    }
}
