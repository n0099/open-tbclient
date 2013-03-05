package com.baidu.tieba.home;

import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.pb.PbActivity;
import com.baidu.tieba.pb.dx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements dx {
    final /* synthetic */ LotteryActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LotteryActivity lotteryActivity) {
        this.a = lotteryActivity;
    }

    @Override // com.baidu.tieba.pb.dx
    public boolean a(String str) {
        Pattern pattern;
        Pattern pattern2;
        Pattern pattern3;
        TextView textView;
        TextView textView2;
        if (str == null) {
            return false;
        }
        pattern = this.a.A;
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            pattern2 = this.a.B;
            Matcher matcher2 = pattern2.matcher(str);
            if (!matcher2.find()) {
                pattern3 = this.a.z;
                if (pattern3.matcher(str).find()) {
                    this.a.x = true;
                    textView2 = this.a.o;
                    textView2.setText(R.string.lottery);
                    return false;
                }
                this.a.x = false;
                textView = this.a.o;
                textView.setText((CharSequence) null);
                return false;
            }
            String g = com.baidu.tieba.c.af.g(matcher2.group(1));
            if (g != null && g.length() > 0) {
                FrsActivity.a(this.a, g, (String) null);
            }
            return true;
        }
        String group = matcher.group(1);
        if (group != null && group.length() > 0) {
            PbActivity.a(this.a, group, (String) null);
        }
        return true;
    }
}
