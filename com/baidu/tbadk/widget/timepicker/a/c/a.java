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
/* loaded from: classes5.dex */
public class a {
    public Context context;
    public String dMA;
    public int dMB;
    public int dMC;
    public int dMD;
    public int dME;
    public int dMF;
    public int dMG;
    public int dMH;
    public String dMJ;
    public String dMK;
    public String dML;
    public boolean dMU;
    public e dMg;
    public d dMh;
    public com.baidu.tbadk.widget.timepicker.a.d.a dMi;
    public Calendar dMo;
    public Calendar dMp;
    public Calendar dMq;
    public int dMr;
    public int dMs;
    public String dMv;
    public String dMw;
    public String dMx;
    public String dMy;
    public String dMz;
    public ViewGroup decorView;
    public boolean dMj = false;
    public boolean dMk = false;
    public boolean dMl = false;
    public boolean dMm = false;
    public boolean[] dMn = {true, true, true, false, false, false};
    public boolean dMt = false;
    public boolean dMu = false;
    public int dMI = 17;
    public int dMM = -16417281;
    public int dMN = -16417281;
    public int dMO = ViewCompat.MEASURED_STATE_MASK;
    public int dMP = -1;
    public int dMQ = -657931;
    public int dMR = 17;
    public int dMS = 18;
    public int dMT = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean dMV = true;
    public boolean isCenterLabel = false;
    public Typeface dMW = Typeface.MONOSPACE;
    public WheelView.DividerType dMX = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.dMH = R.layout.pickerview_options;
        } else {
            this.dMH = R.layout.pickerview_time;
        }
    }
}
