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
    public Calendar cEB;
    public Calendar cEC;
    public Calendar cED;
    public String cEG;
    public String cEH;
    public String cEI;
    public String cEJ;
    public String cEK;
    public String cEL;
    public int cEM;
    public int cEN;
    public int cEO;
    public int cEP;
    public int cEQ;
    public int cER;
    public int cES;
    public String cEU;
    public String cEV;
    public String cEW;
    public e cEt;
    public d cEu;
    public com.baidu.tbadk.widget.timepicker.a.d.a cEv;
    public boolean cFj;
    public Context context;
    public ViewGroup decorView;
    public int endYear;
    public int startYear;
    public boolean cEw = false;
    public boolean cEx = false;
    public boolean cEy = false;
    public boolean cEz = false;
    public boolean[] cEA = {true, true, true, false, false, false};
    public boolean cEE = false;
    public boolean cEF = false;
    public int cET = 17;
    public int cEX = -16417281;
    public int cEY = -16417281;
    public int cEZ = ViewCompat.MEASURED_STATE_MASK;
    public int cFa = -1;
    public int cFb = -657931;
    public int cFc = 17;
    public int cFd = 18;
    public int cFe = 18;
    public int cFf = -5723992;
    public int cFg = -14013910;
    public int cFh = -2763307;
    public int cog = -1;
    public float cFi = 1.6f;
    public boolean cFk = true;
    public boolean cFl = false;
    public Typeface cFm = Typeface.MONOSPACE;
    public WheelView.DividerType cFn = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.cES = d.h.pickerview_options;
        } else {
            this.cES = d.h.pickerview_time;
        }
    }
}
