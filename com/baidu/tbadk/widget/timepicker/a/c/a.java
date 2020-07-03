package com.baidu.tbadk.widget.timepicker.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.d;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class a {
    public Context context;
    public ViewGroup decorView;
    public int eQA;
    public int eQB;
    public String eQD;
    public String eQE;
    public String eQF;
    public boolean eQO;
    public e eQa;
    public d eQb;
    public com.baidu.tbadk.widget.timepicker.a.d.a eQc;
    public Calendar eQi;
    public Calendar eQj;
    public Calendar eQk;
    public int eQl;
    public int eQm;
    public String eQp;
    public String eQq;
    public String eQr;
    public String eQs;
    public String eQt;
    public String eQu;
    public int eQv;
    public int eQw;
    public int eQx;
    public int eQy;
    public int eQz;
    public boolean eQd = false;
    public boolean eQe = false;
    public boolean eQf = false;
    public boolean eQg = false;
    public boolean[] eQh = {true, true, true, false, false, false};
    public boolean eQn = false;
    public boolean eQo = false;
    public int eQC = 17;
    public int eQG = -16417281;
    public int eQH = -16417281;
    public int eQI = ViewCompat.MEASURED_STATE_MASK;
    public int eQJ = -1;
    public int eQK = -657931;
    public int eQL = 17;
    public int eQM = 18;
    public int eQN = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean eQP = true;
    public boolean isCenterLabel = false;
    public Typeface eQQ = Typeface.MONOSPACE;
    public WheelView.DividerType eQR = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.eQB = R.layout.pickerview_options;
        } else {
            this.eQB = R.layout.pickerview_time;
        }
    }
}
