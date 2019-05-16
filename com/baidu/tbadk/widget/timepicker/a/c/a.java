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
/* loaded from: classes3.dex */
public class a {
    public e cMD;
    public d cME;
    public com.baidu.tbadk.widget.timepicker.a.d.a cMF;
    public Calendar cML;
    public Calendar cMM;
    public Calendar cMN;
    public String cMQ;
    public String cMR;
    public String cMS;
    public String cMT;
    public String cMU;
    public String cMV;
    public int cMW;
    public int cMX;
    public int cMY;
    public int cMZ;
    public int cNa;
    public int cNb;
    public int cNc;
    public String cNe;
    public String cNf;
    public String cNg;
    public boolean cNt;
    public Context context;
    public ViewGroup decorView;
    public int endYear;
    public int startYear;
    public boolean cMG = false;
    public boolean cMH = false;
    public boolean cMI = false;
    public boolean cMJ = false;
    public boolean[] cMK = {true, true, true, false, false, false};
    public boolean cMO = false;
    public boolean cMP = false;
    public int cNd = 17;
    public int cNh = -16417281;
    public int cNi = -16417281;
    public int cNj = ViewCompat.MEASURED_STATE_MASK;
    public int cNk = -1;
    public int cNl = -657931;
    public int cNm = 17;
    public int cNn = 18;
    public int cNo = 18;
    public int cNp = -5723992;
    public int cNq = -14013910;
    public int cNr = -2763307;
    public int cwo = -1;
    public float cNs = 1.6f;
    public boolean cNu = true;
    public boolean cNv = false;
    public Typeface cNw = Typeface.MONOSPACE;
    public WheelView.DividerType cNx = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.cNc = R.layout.pickerview_options;
        } else {
            this.cNc = R.layout.pickerview_time;
        }
    }
}
