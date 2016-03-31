package com.baidu.tieba.frs;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp extends CountDownTimer {
    final /* synthetic */ FrsLotteryCountDownView boe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp(FrsLotteryCountDownView frsLotteryCountDownView, long j, long j2) {
        super(j, j2);
        this.boe = frsLotteryCountDownView;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        long j2;
        TextView textView2;
        long j3;
        long j4;
        TextView textView3;
        long j5;
        long j6;
        long j7;
        TextView textView4;
        long j8;
        long j9;
        long j10;
        long j11;
        textView = this.boe.bnV;
        j2 = FrsLotteryCountDownView.INTERVAL_DAY;
        textView.setText(StringUtils.string(Long.valueOf(j / j2)));
        textView2 = this.boe.bnX;
        j3 = FrsLotteryCountDownView.INTERVAL_DAY;
        j4 = FrsLotteryCountDownView.INTERVAL_HOUR;
        textView2.setText(StringUtils.string(Long.valueOf((j % j3) / j4)));
        textView3 = this.boe.bnZ;
        j5 = FrsLotteryCountDownView.INTERVAL_DAY;
        j6 = FrsLotteryCountDownView.INTERVAL_HOUR;
        long j12 = (j % j5) % j6;
        j7 = FrsLotteryCountDownView.bnT;
        textView3.setText(StringUtils.string(Long.valueOf(j12 / j7)));
        textView4 = this.boe.bob;
        j8 = FrsLotteryCountDownView.INTERVAL_DAY;
        j9 = FrsLotteryCountDownView.INTERVAL_HOUR;
        long j13 = (j % j8) % j9;
        j10 = FrsLotteryCountDownView.bnT;
        long j14 = j13 % j10;
        j11 = FrsLotteryCountDownView.bnU;
        textView4.setText(StringUtils.string(Long.valueOf(j14 / j11)));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        TextView textView;
        textView = this.boe.bob;
        textView.setText("0");
    }
}
