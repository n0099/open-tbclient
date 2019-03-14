package com.baidu.tbadk.widget.timepicker.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.d;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.d;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    public Calendar cEA;
    public Calendar cEB;
    public String cEE;
    public String cEF;
    public String cEG;
    public String cEH;
    public String cEI;
    public String cEJ;
    public int cEK;
    public int cEL;
    public int cEM;
    public int cEN;
    public int cEO;
    public int cEP;
    public int cEQ;
    public String cES;
    public String cET;
    public String cEU;
    public e cEr;
    public d cEs;
    public com.baidu.tbadk.widget.timepicker.a.d.a cEt;
    public Calendar cEz;
    public boolean cFh;
    public Context context;
    public ViewGroup decorView;
    public int endYear;
    public int startYear;
    public boolean cEu = false;
    public boolean cEv = false;
    public boolean cEw = false;
    public boolean cEx = false;
    public boolean[] cEy = {true, true, true, false, false, false};
    public boolean cEC = false;
    public boolean cED = false;
    public int cER = 17;
    public int cEV = -16417281;
    public int cEW = -16417281;
    public int cEX = ViewCompat.MEASURED_STATE_MASK;
    public int cEY = -1;
    public int cEZ = -657931;
    public int cFa = 17;
    public int cFb = 18;
    public int cFc = 18;
    public int cFd = -5723992;
    public int cFe = -14013910;
    public int cFf = -2763307;
    public int coe = -1;
    public float cFg = 1.6f;
    public boolean cFi = true;
    public boolean cFj = false;
    public Typeface cFk = Typeface.MONOSPACE;
    public WheelView.DividerType cFl = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.cEQ = d.h.pickerview_options;
        } else {
            this.cEQ = d.h.pickerview_time;
        }
    }
}
