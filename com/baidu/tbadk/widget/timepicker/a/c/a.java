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
    public Calendar cEC;
    public Calendar cED;
    public Calendar cEE;
    public String cEH;
    public String cEI;
    public String cEJ;
    public String cEK;
    public String cEL;
    public String cEM;
    public int cEN;
    public int cEO;
    public int cEP;
    public int cEQ;
    public int cER;
    public int cES;
    public int cET;
    public String cEV;
    public String cEW;
    public String cEX;
    public e cEu;
    public d cEv;
    public com.baidu.tbadk.widget.timepicker.a.d.a cEw;
    public boolean cFk;
    public Context context;
    public ViewGroup decorView;
    public int endYear;
    public int startYear;
    public boolean cEx = false;
    public boolean cEy = false;
    public boolean cEz = false;
    public boolean cEA = false;
    public boolean[] cEB = {true, true, true, false, false, false};
    public boolean cEF = false;
    public boolean cEG = false;
    public int cEU = 17;
    public int cEY = -16417281;
    public int cEZ = -16417281;
    public int cFa = ViewCompat.MEASURED_STATE_MASK;
    public int cFb = -1;
    public int cFc = -657931;
    public int cFd = 17;
    public int cFe = 18;
    public int cFf = 18;
    public int cFg = -5723992;
    public int cFh = -14013910;
    public int cFi = -2763307;
    public int coh = -1;
    public float cFj = 1.6f;
    public boolean cFl = true;
    public boolean cFm = false;
    public Typeface cFn = Typeface.MONOSPACE;
    public WheelView.DividerType cFo = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.cET = d.h.pickerview_options;
        } else {
            this.cET = d.h.pickerview_time;
        }
    }
}
