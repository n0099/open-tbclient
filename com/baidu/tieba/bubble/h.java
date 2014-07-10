package com.baidu.tieba.bubble;

import android.app.Activity;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
/* loaded from: classes.dex */
public class h {
    private static com.baidu.adp.lib.guide.d a;

    public static void a(Activity activity, View view, boolean z, t tVar) {
        SpannableString spannableString;
        int defaultBubbleEndTime = TbadkApplication.m252getInst().getDefaultBubbleEndTime();
        if (defaultBubbleEndTime > 0) {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                new com.baidu.tieba.model.d().a(0, com.baidu.adp.lib.util.j.b(activity), com.baidu.adp.lib.util.j.c(activity));
                TbadkApplication.m252getInst().setDefaultBubble(null);
                TbadkApplication.m252getInst().setDefaultBubbleEndTime(0);
                if (tVar != null) {
                    tVar.a();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
                aVar.a(false);
                View inflate = activity.getLayoutInflater().inflate(w.bubble_free_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(v.tip1);
                TextView textView2 = (TextView) inflate.findViewById(v.tip2);
                bk.a(textView, com.baidu.tieba.s.cp_cont_b, 1);
                bk.a(textView2, com.baidu.tieba.s.cp_cont_b, 1);
                textView.setText(activity.getString(y.bubble_ended_tip));
                textView2.setText(activity.getString(y.bubble_ended_tip2));
                textView2.setTextSize(0, activity.getResources().getDimensionPixelSize(com.baidu.tieba.t.fontsize32));
                aVar.a(inflate);
                aVar.a(y.open_now, new i(activity));
                aVar.b(y.group_create_private_isee, new j());
                aVar.a();
                aVar.b();
                return;
            }
            int i = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (i <= 3 && i >= 0 && System.currentTimeMillis() / 86400000 != com.baidu.tbadk.core.sharedPref.b.a().a("bubble_time@" + TbadkApplication.getCurrentAccount(), 0L)) {
                int i2 = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.s.cp_cont_g_1 : com.baidu.tieba.s.cp_cont_g;
                int i3 = TbadkApplication.m252getInst().getSkinType() == 1 ? com.baidu.tieba.s.cp_link_tip_d_1 : com.baidu.tieba.s.cp_link_tip_d;
                int i4 = TbadkApplication.m252getInst().getSkinType() == 1 ? u.pop_float_arrow_1 : u.pop_float_arrow;
                if (i == 0) {
                    if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                        SpannableString spannableString2 = new SpannableString(activity.getString(y.bubble_end_time_tip_today));
                        spannableString2.setSpan(new ForegroundColorSpan(activity.getResources().getColor(i2)), 0, spannableString2.length(), 34);
                        spannableString2.setSpan(new ForegroundColorSpan(activity.getResources().getColor(i3)), 9, 13, 34);
                        spannableString = spannableString2;
                    } else {
                        SpannableString spannableString3 = new SpannableString(String.format(activity.getString(y.bubble_end_time_tip), 1));
                        spannableString3.setSpan(new ForegroundColorSpan(activity.getResources().getColor(i2)), 0, spannableString3.length(), 34);
                        spannableString3.setSpan(new ForegroundColorSpan(activity.getResources().getColor(i3)), 10, 14, 34);
                        spannableString = spannableString3;
                    }
                } else {
                    SpannableString spannableString4 = new SpannableString(String.format(activity.getString(y.bubble_end_time_tip), Integer.valueOf(i)));
                    spannableString4.setSpan(new ForegroundColorSpan(activity.getResources().getColor(i2)), 0, spannableString4.length(), 34);
                    spannableString4.setSpan(new ForegroundColorSpan(activity.getResources().getColor(i3)), 10, 14, 34);
                    spannableString = spannableString4;
                }
                com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
                gVar.a(view).a(0).b(false);
                gVar.a(new k(activity, z, spannableString, i4));
                gVar.a(true);
                gVar.c(false);
                a = gVar.a();
                new Handler().postDelayed(new m(activity, z), 300L);
                com.baidu.tbadk.core.sharedPref.b.a().b("bubble_time@" + TbadkApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, boolean z) {
        if (a != null) {
            a.a(activity);
        }
        if (!z) {
            new Handler().postDelayed(new n(), TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public static void a(Activity activity, BubbleListData.BubbleData bubbleData, s sVar) {
        if (bubbleData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.a(false);
            Date date = new Date();
            Date date2 = new Date(date.getTime() + (bubbleData.getTime_interval() * 1000));
            String d = bm.d(date);
            String d2 = bm.d(date2);
            String format = String.format(activity.getString(y.bubble_free_dialog_text), bubbleData.getBname(), Integer.valueOf(bubbleData.getTime_interval() / 86400));
            View inflate = activity.getLayoutInflater().inflate(w.bubble_free_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(v.tip1);
            TextView textView2 = (TextView) inflate.findViewById(v.tip2);
            bk.a(textView, com.baidu.tieba.s.cp_cont_b, 1);
            bk.a(textView2, com.baidu.tieba.s.cp_cont_c, 1);
            textView.setText(format);
            textView2.setText(String.valueOf(d) + activity.getString(y.to) + d2);
            aVar.a(inflate);
            aVar.a(y.use_now, new o(sVar, bubbleData));
            aVar.b(y.cancel, new p(sVar));
            aVar.a();
            aVar.b();
        }
    }

    public static void b(Activity activity, BubbleListData.BubbleData bubbleData, s sVar) {
        if (bubbleData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
            aVar.a(false);
            aVar.b(String.format(activity.getString(y.bubble_pay_dialog_text), bubbleData.getLevel_name()));
            aVar.a(y.open_now, new q(sVar, bubbleData));
            aVar.b(y.cancel, new r(sVar));
            aVar.a();
            aVar.b();
        }
    }
}
