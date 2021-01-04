package com.baidu.tbadk.widget.timepicker.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.baidu.tbadk.widget.timepicker.a.d.d;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    public Context context;
    public ViewGroup decorView;
    public Calendar gbA;
    public Calendar gbB;
    public Calendar gbC;
    public int gbD;
    public int gbE;
    public String gbH;
    public String gbI;
    public String gbJ;
    public String gbK;
    public String gbL;
    public String gbM;
    public int gbN;
    public int gbO;
    public int gbP;
    public int gbQ;
    public int gbR;
    public int gbS;
    public int gbT;
    public String gbV;
    public String gbW;
    public String gbX;
    public e gbs;
    public d gbt;
    public com.baidu.tbadk.widget.timepicker.a.d.a gbu;
    public boolean gcg;
    public boolean gbv = false;
    public boolean gbw = false;
    public boolean gbx = false;
    public boolean gby = false;
    public boolean[] gbz = {true, true, true, false, false, false};
    public boolean gbF = false;
    public boolean gbG = false;
    public int gbU = 17;
    public int gbY = -16417281;
    public int gbZ = -16417281;
    public int gca = ViewCompat.MEASURED_STATE_MASK;
    public int gcb = -1;
    public int gcc = -657931;
    public int gcd = 17;
    public int gce = 18;
    public int gcf = 18;
    public int dCT = -5723992;
    public int dCU = -14013910;
    public int dCV = -2763307;
    public int backgroundId = -1;
    public float dCW = 1.6f;
    public boolean cancelable = true;
    public boolean dCG = false;
    public Typeface font = Typeface.MONOSPACE;
    public WheelView.DividerType gch = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.gbT = R.layout.pickerview_options;
        } else {
            this.gbT = R.layout.pickerview_time;
        }
    }
}
