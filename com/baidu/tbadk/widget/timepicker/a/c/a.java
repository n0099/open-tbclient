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
/* loaded from: classes8.dex */
public class a {
    public Context context;
    public ViewGroup decorView;
    public e eFO;
    public d eFP;
    public com.baidu.tbadk.widget.timepicker.a.d.a eFQ;
    public Calendar eFW;
    public Calendar eFX;
    public Calendar eFY;
    public int eFZ;
    public boolean eGC;
    public int eGa;
    public String eGd;
    public String eGe;
    public String eGf;
    public String eGg;
    public String eGh;
    public String eGi;
    public int eGj;
    public int eGk;
    public int eGl;
    public int eGm;
    public int eGn;
    public int eGo;
    public int eGp;
    public String eGr;
    public String eGs;
    public String eGt;
    public boolean eFR = false;
    public boolean eFS = false;
    public boolean eFT = false;
    public boolean eFU = false;
    public boolean[] eFV = {true, true, true, false, false, false};
    public boolean eGb = false;
    public boolean eGc = false;
    public int eGq = 17;
    public int eGu = -16417281;
    public int eGv = -16417281;
    public int eGw = ViewCompat.MEASURED_STATE_MASK;
    public int eGx = -1;
    public int eGy = -657931;
    public int eGz = 17;
    public int eGA = 18;
    public int eGB = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean eGD = true;
    public boolean isCenterLabel = false;
    public Typeface eGE = Typeface.MONOSPACE;
    public WheelView.DividerType eGF = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.eGp = R.layout.pickerview_options;
        } else {
            this.eGp = R.layout.pickerview_time;
        }
    }
}
