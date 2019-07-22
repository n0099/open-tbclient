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
    public e cNY;
    public d cNZ;
    public String cOB;
    public String cOC;
    public String cOD;
    public boolean cOQ;
    public com.baidu.tbadk.widget.timepicker.a.d.a cOa;
    public Calendar cOg;
    public Calendar cOh;
    public Calendar cOi;
    public int cOj;
    public int cOk;
    public String cOn;
    public String cOo;
    public String cOp;
    public String cOq;
    public String cOr;
    public String cOs;
    public int cOt;
    public int cOu;
    public int cOv;
    public int cOw;
    public int cOx;
    public int cOy;
    public int cOz;
    public Context context;
    public ViewGroup decorView;
    public boolean cOb = false;
    public boolean cOc = false;
    public boolean cOd = false;
    public boolean cOe = false;
    public boolean[] cOf = {true, true, true, false, false, false};
    public boolean cOl = false;
    public boolean cOm = false;
    public int cOA = 17;
    public int cOE = -16417281;
    public int cOF = -16417281;
    public int cOG = ViewCompat.MEASURED_STATE_MASK;
    public int cOH = -1;
    public int cOI = -657931;
    public int cOJ = 17;
    public int cOK = 18;
    public int cOL = 18;
    public int cOM = -5723992;
    public int cON = -14013910;
    public int cOO = -2763307;
    public int cxE = -1;
    public float cOP = 1.6f;
    public boolean cOR = true;
    public boolean cOS = false;
    public Typeface cOT = Typeface.MONOSPACE;
    public WheelView.DividerType cOU = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.cOz = R.layout.pickerview_options;
        } else {
            this.cOz = R.layout.pickerview_time;
        }
    }
}
