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
    public e cME;
    public d cMF;
    public com.baidu.tbadk.widget.timepicker.a.d.a cMG;
    public Calendar cMM;
    public Calendar cMN;
    public Calendar cMO;
    public String cMR;
    public String cMS;
    public String cMT;
    public String cMU;
    public String cMV;
    public String cMW;
    public int cMX;
    public int cMY;
    public int cMZ;
    public int cNa;
    public int cNb;
    public int cNc;
    public int cNd;
    public String cNf;
    public String cNg;
    public String cNh;
    public boolean cNu;
    public Context context;
    public ViewGroup decorView;
    public int endYear;
    public int startYear;
    public boolean cMH = false;
    public boolean cMI = false;
    public boolean cMJ = false;
    public boolean cMK = false;
    public boolean[] cML = {true, true, true, false, false, false};
    public boolean cMP = false;
    public boolean cMQ = false;
    public int cNe = 17;
    public int cNi = -16417281;
    public int cNj = -16417281;
    public int cNk = ViewCompat.MEASURED_STATE_MASK;
    public int cNl = -1;
    public int cNm = -657931;
    public int cNn = 17;
    public int cNo = 18;
    public int cNp = 18;
    public int cNq = -5723992;
    public int cNr = -14013910;
    public int cNs = -2763307;
    public int cwp = -1;
    public float cNt = 1.6f;
    public boolean cNv = true;
    public boolean cNw = false;
    public Typeface cNx = Typeface.MONOSPACE;
    public WheelView.DividerType cNy = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.cNd = R.layout.pickerview_options;
        } else {
            this.cNd = R.layout.pickerview_time;
        }
    }
}
