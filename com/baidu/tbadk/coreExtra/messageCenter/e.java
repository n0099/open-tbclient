package com.baidu.tbadk.coreExtra.messageCenter;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes.dex */
public class e implements a {
    private static final long DELAY_TIME = 1 * au.MS_TO_MIN;
    private com.baidu.tbadk.widget.timepicker.a.f.b ftu;

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public boolean isSignAlertOn() {
        return TbadkSettings.getInst().loadBoolean(SharedPrefConfig.ALERT_SIGN_ON, false);
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public void setSignAlertOn(boolean z) {
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.ALERT_SIGN_ON, z);
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
        calendar.setTimeInMillis(System.currentTimeMillis() + DELAY_TIME);
        setSignAlertTime(calendar.get(11), calendar.get(12));
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public int getSignAlertHours() {
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.ALERT_SIGN_HOURS, -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt(SharedPrefConfig.ALERT_SIGN_HOURS, 12);
        }
        return loadInt;
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public int getSignAlertMins() {
        int loadInt = TbadkSettings.getInst().loadInt(SharedPrefConfig.ALERT_SIGN_MINS, -1);
        if (loadInt == -1) {
            prepareForDefaultAlertTime();
            return TbadkSettings.getInst().loadInt(SharedPrefConfig.ALERT_SIGN_MINS, 30);
        }
        return loadInt;
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public void setSignAlertTime(int i, int i2) {
        TbadkSettings.getInst().saveInt(SharedPrefConfig.ALERT_SIGN_HOURS, i);
        TbadkSettings.getInst().saveInt(SharedPrefConfig.ALERT_SIGN_MINS, i2);
        updateSignAlarm();
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public void a(final TbPageContext tbPageContext, final ViewGroup viewGroup) {
        final Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null && g.isActivityCanShowDialogOrPopupWindow(pageActivity) && !d.bye().isSignAlertOn() && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("sign_time_set_dialog", 0) <= 0) {
            a(tbPageContext, new com.baidu.tbadk.widget.timepicker.a.d.e() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.e
                public void a(Date date, View view) {
                    boolean z = false;
                    if (date != null) {
                        if ("frs.FrsActivity".equals(pageActivity.getLocalClassName()) && com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("first_call_attention", true)) {
                            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("first_call_attention", false);
                            if (!NotificationManagerCompat.from(tbPageContext.getPageActivity()).areNotificationsEnabled()) {
                                z = true;
                            }
                        }
                        if (z) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001223, date));
                            com.baidu.tbadk.coreExtra.c.a.a(tbPageContext, new boolean[]{true, false}, 2);
                            return;
                        }
                        e.this.setSignAlertOn(true);
                        d.bye().setSignAlertTime(date.getHours(), date.getMinutes());
                        e.this.a(pageActivity, viewGroup);
                    }
                }
            });
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt("sign_time_set_dialog", 1);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public Dialog a(final TbPageContext tbPageContext, com.baidu.tbadk.widget.timepicker.a.d.e eVar) {
        Activity pageActivity;
        if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !g.isActivityCanShowDialogOrPopupWindow(pageActivity)) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int signAlertHours = d.bye().getSignAlertHours();
        int signAlertMins = d.bye().getSignAlertMins();
        if (signAlertHours > 0 && signAlertMins > 0) {
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), signAlertHours, signAlertMins);
        } else {
            calendar.setTimeInMillis(System.currentTimeMillis() + DELAY_TIME);
        }
        this.ftu = new com.baidu.tbadk.widget.timepicker.a.b.a(pageActivity, eVar).a(calendar).a(R.layout.dialog_sign_remind, new com.baidu.tbadk.widget.timepicker.a.d.a() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.2
            @Override // com.baidu.tbadk.widget.timepicker.a.d.a
            public void bI(View view) {
                View findViewById = view.findViewById(R.id.layout_bottom_title);
                View findViewById2 = view.findViewById(R.id.layout_bg);
                View findViewById3 = view.findViewById(R.id.layout_bg_top);
                TextView textView = (TextView) view.findViewById(R.id.dialog_yes);
                ImageView imageView = (ImageView) view.findViewById(R.id.dialog_cancel);
                ap.setBackgroundResource(findViewById2, R.color.CAM_X0211);
                ap.setBackgroundResource(findViewById3, R.drawable.pic_frs_popup_sign);
                ap.setViewTextColor(textView, R.color.select_topbar_icon_white_color_tint);
                ap.setImageResource(imageView, R.drawable.selector_topbar_close_white);
                ap.setViewTextColor((TextView) view.findViewById(R.id.tv_title), R.color.CAM_X0101);
                View findViewById4 = view.findViewById(R.id.layout_content);
                ap.setBackgroundColor(findViewById4, R.color.CAM_X0211);
                ap.setViewTextColor((TextView) view.findViewById(R.id.tv_tip), R.color.CAM_X0105);
                ap.setViewTextColor((TextView) view.findViewById(R.id.sign_remind_timer), R.color.CAM_X0105);
                ap.setBackgroundColor((LinearLayout) view.findViewById(R.id.timepicker), R.color.CAM_X0211);
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
                        if (e.this.ftu != null) {
                            e.this.ftu.bIG();
                            e.this.ftu.dismiss();
                        }
                        ar arVar = new ar("c13250");
                        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(arVar);
                        if (com.baidu.tbadk.coreExtra.c.a.G(TbadkCoreApplication.getInst(), 0)) {
                            com.baidu.tbadk.coreExtra.c.a.a(tbPageContext, 5, 0L);
                        }
                    }
                });
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.messageCenter.e.2.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (e.this.ftu != null) {
                            e.this.ftu.dismiss();
                        }
                        ar arVar = new ar("c13251");
                        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(arVar);
                    }
                });
            }
        }).st(18).a(new boolean[]{false, false, false, true, true, false}).d("年", "月", "日", "时", "分", "秒").av(2.0f).h(0, 0, 0, 0, 0, 0).lO(false).su(ap.getColor(R.color.CAM_X0204)).sw(ap.getColor(R.color.CAM_X0105)).sx(ap.getColor(R.color.CAM_X0109)).sv(ap.getColor(R.color.black_alpha30)).ss(ap.getColor(R.color.CAM_X0211)).bIy();
        this.ftu.show();
        ar arVar = new ar("c13249");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(arVar);
        return this.ftu.getDialog();
    }

    @Override // com.baidu.tbadk.coreExtra.messageCenter.a
    public NavigationBarCoverTip a(Activity activity, ViewGroup viewGroup) {
        if (activity == null || viewGroup == null) {
            return null;
        }
        View findViewById = viewGroup.findViewById(R.id.navbar_cover_tip_view);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        NavigationBarCoverTip navigationBarCoverTip = new NavigationBarCoverTip(activity);
        navigationBarCoverTip.setId(R.id.navbar_cover_tip_view);
        viewGroup.addView(navigationBarCoverTip, new RelativeLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(activity);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setMinHeight(getDimensionPixelSize(R.dimen.tbds112));
        int dimensionPixelSize = getDimensionPixelSize(R.dimen.tbds20);
        textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        textView.setGravity(17);
        textView.setTextSize(0, getDimensionPixelSize(R.dimen.tbfontsize42));
        textView.setLineSpacing(getDimensionPixelSize(R.dimen.ds2), 1.0f);
        textView.setText(activity.getString(R.string.sign_remind_timer_succ));
        ap.setViewTextColor(textView, R.color.CAM_X0101);
        ap.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
        navigationBarCoverTip.e(activity, textView);
        return navigationBarCoverTip;
    }

    private int getDimensionPixelSize(int i) {
        return l.getDimens(TbadkCoreApplication.getInst(), i);
    }
}
