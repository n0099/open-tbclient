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
    public e cOV;
    public d cOW;
    public com.baidu.tbadk.widget.timepicker.a.d.a cOX;
    public String cPA;
    public boolean cPN;
    public Calendar cPd;
    public Calendar cPe;
    public Calendar cPf;
    public int cPg;
    public int cPh;
    public String cPk;
    public String cPl;
    public String cPm;
    public String cPn;
    public String cPo;
    public String cPp;
    public int cPq;
    public int cPr;
    public int cPs;
    public int cPt;
    public int cPu;
    public int cPv;
    public int cPw;
    public String cPy;
    public String cPz;
    public Context context;
    public ViewGroup decorView;
    public boolean cOY = false;
    public boolean cOZ = false;
    public boolean cPa = false;
    public boolean cPb = false;
    public boolean[] cPc = {true, true, true, false, false, false};
    public boolean cPi = false;
    public boolean cPj = false;
    public int cPx = 17;
    public int cPB = -16417281;
    public int cPC = -16417281;
    public int cPD = ViewCompat.MEASURED_STATE_MASK;
    public int cPE = -1;
    public int cPF = -657931;
    public int cPG = 17;
    public int cPH = 18;
    public int cPI = 18;
    public int cPJ = -5723992;
    public int cPK = -14013910;
    public int cPL = -2763307;
    public int cyH = -1;
    public float cPM = 1.6f;
    public boolean cPO = true;
    public boolean cPP = false;
    public Typeface cPQ = Typeface.MONOSPACE;
    public WheelView.DividerType cPR = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.cPw = R.layout.pickerview_options;
        } else {
            this.cPw = R.layout.pickerview_time;
        }
    }
}
