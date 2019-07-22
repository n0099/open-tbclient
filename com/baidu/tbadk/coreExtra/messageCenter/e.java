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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes3.dex */
public class e implements a {
    private static final long ciG = 1 * aq.bTA;
    private com.baidu.tbadk.widget.timepicker.a.f.b ciH;

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
        calendar.setTimeInMillis(System.currentTimeMillis() + ciG);
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
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null && g.t(pageActivity) && !d.aok().isSignAlertOn() && com.baidu.tbadk.core.sharedPref.b.ahO().getInt("sign_time_set_dialog", 0) <= 0) {
            a(tbPageContext, new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.e
                public void a(Date date, View view) {
                    if (date != null) {
                        e.this.setSignAlertOn(true);
                        d.aok().setSignAlertTime(date.getHours(), date.getMinutes());
                        e.this.b(pageActivity, relativeLayout);
                    }
                }
            });
            com.baidu.tbadk.core.sharedPref.b.ahO().putInt("sign_time_set_dialog", 1);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public Dialog a(TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        Activity pageActivity;
        if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !g.t(pageActivity)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int signAlertHours = d.aok().getSignAlertHours();
        int signAlertMins = d.aok().getSignAlertMins();
        if (signAlertHours > 0 && signAlertMins > 0) {
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), signAlertHours, signAlertMins);
        } else {
            calendar.setTimeInMillis(System.currentTimeMillis() + ciG);
        }
        this.ciH = new com.baidu.tbadk.widget.timepicker.a.b.a(pageActivity, eVar).a(calendar).a(R.layout.dialog_sign_remind, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.2
            @Override // com.baidu.tbadk.widget.timepicker.a.d.a
            public void bb(View view) {
                View findViewById = view.findViewById(R.id.layout_bottom_title);
                View findViewById2 = view.findViewById(R.id.layout_bg);
                View findViewById3 = view.findViewById(R.id.layout_bg_top);
                TextView textView = (TextView) view.findViewById(R.id.dialog_yes);
                ImageView imageView = (ImageView) view.findViewById(R.id.dialog_cancel);
                am.k(findViewById2, R.color.cp_bg_line_d);
                am.k(findViewById3, R.drawable.pic_frs_popup_sign);
                am.j(textView, R.color.select_topbar_icon_white_color_tint);
                am.c(imageView, (int) R.drawable.selector_topbar_close_white);
                am.j((TextView) view.findViewById(R.id.tv_title), R.color.cp_btn_a);
                View findViewById4 = view.findViewById(R.id.layout_content);
                am.l(findViewById4, R.color.cp_bg_line_d);
                am.j((TextView) view.findViewById(R.id.tv_tip), R.color.cp_cont_b);
                am.j((TextView) view.findViewById(R.id.sign_remind_timer), R.color.cp_cont_b);
                am.l((LinearLayout) view.findViewById(R.id.timepicker), R.color.cp_bg_line_d);
                View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.2.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        return true;
                    }
                };
                findViewById.setOnTouchListener(onTouchListener);
                findViewById4.setOnTouchListener(onTouchListener);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (e.this.ciH != null) {
                            e.this.ciH.azV();
                            e.this.ciH.dismiss();
                        }
                        an anVar = new an("c13250");
                        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(anVar);
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.2.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (e.this.ciH != null) {
                            e.this.ciH.dismiss();
                        }
                        an anVar = new an("c13251");
                        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(anVar);
                    }
                });
            }
        }).lL(18).b(new boolean[]{false, false, false, true, true, false}).b("年", "月", "日", "时", "分", "秒").av(2.0f).f(0, 0, 0, 0, 0, 0).fW(false).lM(am.getColor(R.color.cp_bg_line_b)).lO(am.getColor(R.color.cp_cont_b)).lP(am.getColor(R.color.cp_cont_d)).lN(am.getColor(R.color.black_alpha30)).lK(am.getColor(R.color.cp_bg_line_d)).azJ();
        this.ciH.show();
        an anVar = new an("c13249");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(anVar);
        return this.ciH.getDialog();
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public NavigationBarCoverTip b(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            return null;
        }
        View findViewById = relativeLayout.findViewById(R.id.navbar_cover_tip_view);
        if (findViewById != null) {
            relativeLayout.removeView(findViewById);
        }
        NavigationBarCoverTip navigationBarCoverTip = new NavigationBarCoverTip(activity);
        navigationBarCoverTip.setId(R.id.navbar_cover_tip_view);
        relativeLayout.addView(navigationBarCoverTip, new RelativeLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(activity);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setMinHeight(getDimensionPixelSize(R.dimen.tbds112));
        int dimensionPixelSize = getDimensionPixelSize(R.dimen.tbds20);
        textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        textView.setGravity(17);
        textView.setTextSize(0, getDimensionPixelSize(R.dimen.tbfontsize42));
        textView.setLineSpacing(getDimensionPixelSize(R.dimen.ds2), 1.0f);
        textView.setText(activity.getString(R.string.sign_remind_timer_succ));
        am.j(textView, R.color.cp_btn_a);
        am.l(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
        navigationBarCoverTip.h(activity, textView);
        return navigationBarCoverTip;
    }

    private int getDimensionPixelSize(int i) {
        return l.g(TbadkCoreApplication.getInst(), i);
    }
}
