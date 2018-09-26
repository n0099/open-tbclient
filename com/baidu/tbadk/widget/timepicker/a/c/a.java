package com.baidu.tbadk.widget.timepicker.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.d;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.e;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    public int bkA;
    public int bkB;
    public int bkC;
    public int bkD;
    public int bkE;
    public String bkG;
    public String bkH;
    public String bkI;
    public boolean bkV;
    public e bkf;
    public d bkg;
    public com.baidu.tbadk.widget.timepicker.a.d.a bkh;
    public Calendar bkn;
    public Calendar bko;
    public Calendar bkp;
    public String bks;
    public String bkt;
    public String bku;
    public String bkv;
    public String bkw;
    public String bkx;
    public int bky;
    public int bkz;
    public Context context;
    public ViewGroup decorView;
    public int endYear;
    public int startYear;
    public boolean bki = false;
    public boolean bkj = false;
    public boolean bkk = false;
    public boolean bkl = false;
    public boolean[] bkm = {true, true, true, false, false, false};
    public boolean bkq = false;
    public boolean bkr = false;
    public int bkF = 17;
    public int bkJ = -16417281;
    public int bkK = -16417281;
    public int bkL = ViewCompat.MEASURED_STATE_MASK;
    public int bkM = -1;
    public int bkN = -657931;
    public int bkO = 17;
    public int bkP = 18;
    public int bkQ = 18;
    public int bkR = -5723992;
    public int bkS = -14013910;
    public int bkT = -2763307;
    public int aVb = -1;
    public float bkU = 1.6f;
    public boolean bkW = true;
    public boolean bkX = false;
    public Typeface bkY = Typeface.MONOSPACE;
    public WheelView.DividerType bkZ = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.bkE = e.h.pickerview_options;
        } else {
            this.bkE = e.h.pickerview_time;
        }
    }
}
