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
/* loaded from: classes6.dex */
public class a {
    public Context context;
    public int dMA;
    public String dMD;
    public String dME;
    public String dMF;
    public String dMG;
    public String dMH;
    public String dMI;
    public int dMJ;
    public int dMK;
    public int dML;
    public int dMM;
    public int dMN;
    public int dMO;
    public int dMP;
    public String dMR;
    public String dMS;
    public String dMT;
    public e dMo;
    public d dMp;
    public com.baidu.tbadk.widget.timepicker.a.d.a dMq;
    public Calendar dMw;
    public Calendar dMx;
    public Calendar dMy;
    public int dMz;
    public boolean dNc;
    public ViewGroup decorView;
    public boolean dMr = false;
    public boolean dMs = false;
    public boolean dMt = false;
    public boolean dMu = false;
    public boolean[] dMv = {true, true, true, false, false, false};
    public boolean dMB = false;
    public boolean dMC = false;
    public int dMQ = 17;
    public int dMU = -16417281;
    public int dMV = -16417281;
    public int dMW = ViewCompat.MEASURED_STATE_MASK;
    public int dMX = -1;
    public int dMY = -657931;
    public int dMZ = 17;
    public int dNa = 18;
    public int dNb = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean dNd = true;
    public boolean isCenterLabel = false;
    public Typeface dNe = Typeface.MONOSPACE;
    public WheelView.DividerType dNf = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.dMP = R.layout.pickerview_options;
        } else {
            this.dMP = R.layout.pickerview_time;
        }
    }
}
