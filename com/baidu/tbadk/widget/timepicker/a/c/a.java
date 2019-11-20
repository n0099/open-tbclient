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
    public Calendar cXE;
    public Calendar cXF;
    public Calendar cXG;
    public int cXH;
    public int cXI;
    public String cXL;
    public String cXM;
    public String cXN;
    public String cXO;
    public String cXP;
    public String cXQ;
    public int cXR;
    public int cXS;
    public int cXT;
    public int cXU;
    public int cXV;
    public int cXW;
    public int cXX;
    public String cXZ;
    public e cXw;
    public d cXx;
    public com.baidu.tbadk.widget.timepicker.a.d.a cXy;
    public String cYa;
    public String cYb;
    public boolean cYo;
    public Context context;
    public ViewGroup decorView;
    public boolean cXz = false;
    public boolean cXA = false;
    public boolean cXB = false;
    public boolean cXC = false;
    public boolean[] cXD = {true, true, true, false, false, false};
    public boolean cXJ = false;
    public boolean cXK = false;
    public int cXY = 17;
    public int cYc = -16417281;
    public int cYd = -16417281;
    public int cYe = ViewCompat.MEASURED_STATE_MASK;
    public int cYf = -1;
    public int cYg = -657931;
    public int cYh = 17;
    public int cYi = 18;
    public int cYj = 18;
    public int cYk = -5723992;
    public int cYl = -14013910;
    public int cYm = -2763307;
    public int backgroundId = -1;
    public float cYn = 1.6f;
    public boolean cYp = true;
    public boolean cYq = false;
    public Typeface cYr = Typeface.MONOSPACE;
    public WheelView.DividerType cYs = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.cXX = R.layout.pickerview_options;
        } else {
            this.cXX = R.layout.pickerview_time;
        }
    }
}
