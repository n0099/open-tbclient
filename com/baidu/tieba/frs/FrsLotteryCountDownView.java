package com.baidu.tieba.frs;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.t;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class FrsLotteryCountDownView extends LinearLayout {
    private static final long INTERVAL_DAY = TimeUnit.DAYS.toMillis(1);
    private static final long INTERVAL_HOUR = TimeUnit.HOURS.toMillis(1);
    private static final long bnT = TimeUnit.MINUTES.toMillis(1);
    private static final long bnU = TimeUnit.SECONDS.toMillis(1);
    private TextView bnV;
    private TextView bnW;
    private TextView bnX;
    private TextView bnY;
    private TextView bnZ;
    private TextView boa;
    private TextView bob;
    private TextView boc;
    private CountDownTimer bod;
    private Context mContext;
    private View mRootView;

    public FrsLotteryCountDownView(Context context) {
        super(context);
        this.mContext = null;
        this.bod = null;
        this.mContext = context;
        init();
    }

    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.bod = null;
        this.mContext = context;
        init();
    }

    public FrsLotteryCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.bod = null;
        this.mContext = context;
        init();
    }

    protected void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.frs_lottery_count_down, (ViewGroup) this, true);
        this.bnV = (TextView) this.mRootView.findViewById(t.g.lottery_count_day);
        this.bnW = (TextView) this.mRootView.findViewById(t.g.lottery_count_day_txt);
        this.bnX = (TextView) this.mRootView.findViewById(t.g.lottery_count_hour);
        this.bnY = (TextView) this.mRootView.findViewById(t.g.lottery_count_hour_txt);
        this.bnZ = (TextView) this.mRootView.findViewById(t.g.lottery_count_minute);
        this.boa = (TextView) this.mRootView.findViewById(t.g.lottery_count_minute_txt);
        this.bob = (TextView) this.mRootView.findViewById(t.g.lottery_count_second);
        this.boc = (TextView) this.mRootView.findViewById(t.g.lottery_count_second_txt);
    }

    public void setData(long j) {
        com.baidu.tbadk.core.util.at.j((View) this.bnV, t.d.cp_cont_g);
        com.baidu.tbadk.core.util.at.j((View) this.bnW, t.d.cp_cont_c);
        com.baidu.tbadk.core.util.at.l(this.bnV, t.d.frs_lottery_count_bg);
        com.baidu.tbadk.core.util.at.j((View) this.bnX, t.d.cp_cont_g);
        com.baidu.tbadk.core.util.at.j((View) this.bnY, t.d.cp_cont_c);
        com.baidu.tbadk.core.util.at.l(this.bnX, t.d.frs_lottery_count_bg);
        com.baidu.tbadk.core.util.at.j((View) this.bnZ, t.d.cp_cont_g);
        com.baidu.tbadk.core.util.at.j((View) this.boa, t.d.cp_cont_c);
        com.baidu.tbadk.core.util.at.l(this.bnZ, t.d.frs_lottery_count_bg);
        com.baidu.tbadk.core.util.at.j((View) this.bob, t.d.cp_cont_g);
        com.baidu.tbadk.core.util.at.j((View) this.boc, t.d.cp_cont_c);
        com.baidu.tbadk.core.util.at.l(this.bob, t.d.frs_lottery_count_bg);
        if (j <= bnU) {
            this.bnV.setText("0");
            this.bnX.setText("0");
            this.bnZ.setText("0");
            this.bob.setText("0");
            return;
        }
        if (j / INTERVAL_DAY <= 0) {
            this.bnV.setVisibility(8);
            this.bnW.setVisibility(8);
        } else {
            this.bnV.setVisibility(0);
            this.bnW.setVisibility(0);
        }
        if (this.bod != null) {
            this.bod.cancel();
        }
        this.bod = new cp(this, j, 1000L).start();
    }
}
