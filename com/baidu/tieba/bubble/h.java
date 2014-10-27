package com.baidu.tieba.bubble;

import android.app.Activity;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
/* loaded from: classes.dex */
public class h {
    private static com.baidu.adp.lib.guide.d ajf;

    public static void a(Activity activity, View view, boolean z, t tVar) {
        SpannableString spannableString;
        int defaultBubbleEndTime = TbadkApplication.m251getInst().getDefaultBubbleEndTime();
        if (defaultBubbleEndTime > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                new com.baidu.tieba.model.e(activity).p(0, com.baidu.adp.lib.util.m.n(activity), com.baidu.adp.lib.util.m.o(activity));
                TbadkApplication.m251getInst().setDefaultBubble(null);
                TbadkApplication.m251getInst().setDefaultBubbleEndTime(0);
                if (tVar != null) {
                    tVar.hz();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
                aVar.P(false);
                View inflate = com.baidu.adp.lib.g.b.ek().inflate(activity, w.bubble_free_dialog_content, null);
                TextView textView = (TextView) inflate.findViewById(v.tip1);
                TextView textView2 = (TextView) inflate.findViewById(v.tip2);
                aw.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
                aw.b(textView2, com.baidu.tieba.s.cp_cont_b, 1);
                textView.setText(activity.getString(y.bubble_ended_tip));
                textView2.setText(activity.getString(y.bubble_ended_tip2));
                textView2.setTextSize(0, activity.getResources().getDimensionPixelSize(com.baidu.tieba.t.fontsize32));
                aVar.j(inflate);
                aVar.a(y.open_now, new i(activity));
                aVar.b(y.group_create_private_isee, new j(activity));
                aVar.kT();
                aVar.kW();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != com.baidu.tbadk.core.sharedPref.b.lk().getLong("bubble_time@" + TbadkApplication.getCurrentAccount(), 0L)) {
                int i2 = com.baidu.tieba.s.cp_cont_g;
                int i3 = com.baidu.tieba.s.cp_link_tip_d;
                int i4 = u.pop_float_arrow;
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        spannableString = new SpannableString(activity.getString(y.bubble_end_time_tip_today));
                        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(i3)), 9, 13, 34);
                    } else {
                        spannableString = new SpannableString(String.format(activity.getString(y.bubble_end_time_tip), 1));
                        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(i2)), 0, spannableString.length(), 34);
                        spannableString.setSpan(new ForegroundColorSpan(aw.getColor(i3)), 10, 14, 34);
                    }
                } else {
                    spannableString = new SpannableString(String.format(activity.getString(y.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString.setSpan(new ForegroundColorSpan(aw.getColor(i2)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(aw.getColor(i3)), 10, 14, 34);
                }
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.b(view).A(0).r(false);
                gVar.a(new k(activity, z, spannableString, i4));
                gVar.q(true);
                gVar.s(false);
                ajf = gVar.dA();
                new Handler().postDelayed(new m(activity, z), 300L);
                com.baidu.tbadk.core.sharedPref.b.lk().putLong("bubble_time@" + TbadkApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Activity activity, boolean z) {
        if (ajf != null) {
            ajf.c(activity);
        }
        if (!z) {
            new Handler().postDelayed(new n(), TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public static void a(Activity activity, BubbleListData.BubbleData bubbleData, s sVar) {
        if (bubbleData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.P(false);
            Date date = new Date();
            Date date2 = new Date(date.getTime() + (bubbleData.getTime_interval() * 1000));
            String d = ay.d(date);
            String d2 = ay.d(date2);
            String format = String.format(activity.getString(y.bubble_free_dialog_text), bubbleData.getBname(), Integer.valueOf(bubbleData.getTime_interval() / 86400));
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(activity, w.bubble_free_dialog_content, null);
            TextView textView = (TextView) inflate.findViewById(v.tip1);
            TextView textView2 = (TextView) inflate.findViewById(v.tip2);
            aw.b(textView, com.baidu.tieba.s.cp_cont_b, 1);
            aw.b(textView2, com.baidu.tieba.s.cp_cont_c, 1);
            textView.setText(format);
            textView2.setText(String.valueOf(d) + activity.getString(y.to) + d2);
            aVar.j(inflate);
            aVar.a(y.use_now, new o(sVar, bubbleData));
            aVar.b(y.cancel, new p(sVar));
            aVar.kT();
            aVar.kW();
        }
    }

    public static void b(Activity activity, BubbleListData.BubbleData bubbleData, s sVar) {
        if (bubbleData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.P(false);
            aVar.bg(String.format(activity.getString(y.bubble_pay_dialog_text), bubbleData.getLevel_name()));
            aVar.a(y.open_now, new q(sVar, bubbleData));
            aVar.b(y.cancel, new r(sVar));
            aVar.kT();
            aVar.kW();
        }
    }
}
