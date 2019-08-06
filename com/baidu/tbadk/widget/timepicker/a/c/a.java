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
    public int cOA;
    public int cOB;
    public int cOC;
    public int cOD;
    public int cOE;
    public int cOF;
    public int cOG;
    public String cOI;
    public String cOJ;
    public String cOK;
    public boolean cOX;
    public e cOf;
    public d cOg;
    public com.baidu.tbadk.widget.timepicker.a.d.a cOh;
    public Calendar cOn;
    public Calendar cOo;
    public Calendar cOp;
    public int cOq;
    public int cOr;
    public String cOu;
    public String cOv;
    public String cOw;
    public String cOx;
    public String cOy;
    public String cOz;
    public Context context;
    public ViewGroup decorView;
    public boolean cOi = false;
    public boolean cOj = false;
    public boolean cOk = false;
    public boolean cOl = false;
    public boolean[] cOm = {true, true, true, false, false, false};
    public boolean cOs = false;
    public boolean cOt = false;
    public int cOH = 17;
    public int cOL = -16417281;
    public int cOM = -16417281;
    public int cON = ViewCompat.MEASURED_STATE_MASK;
    public int cOO = -1;
    public int cOP = -657931;
    public int cOQ = 17;
    public int cOR = 18;
    public int cOS = 18;
    public int cOT = -5723992;
    public int cOU = -14013910;
    public int cOV = -2763307;
    public int cxL = -1;
    public float cOW = 1.6f;
    public boolean cOY = true;
    public boolean cOZ = false;
    public Typeface cPa = Typeface.MONOSPACE;
    public WheelView.DividerType cPb = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.cOG = R.layout.pickerview_options;
        } else {
            this.cOG = R.layout.pickerview_time;
        }
    }
}
