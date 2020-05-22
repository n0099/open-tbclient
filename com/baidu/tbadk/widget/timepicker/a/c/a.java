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
    public e eFD;
    public d eFE;
    public com.baidu.tbadk.widget.timepicker.a.d.a eFF;
    public Calendar eFL;
    public Calendar eFM;
    public Calendar eFN;
    public int eFO;
    public int eFP;
    public String eFS;
    public String eFT;
    public String eFU;
    public String eFV;
    public String eFW;
    public String eFX;
    public int eFY;
    public int eFZ;
    public int eGa;
    public int eGb;
    public int eGc;
    public int eGd;
    public int eGe;
    public String eGg;
    public String eGh;
    public String eGi;
    public boolean eGr;
    public boolean eFG = false;
    public boolean eFH = false;
    public boolean eFI = false;
    public boolean eFJ = false;
    public boolean[] eFK = {true, true, true, false, false, false};
    public boolean eFQ = false;
    public boolean eFR = false;
    public int eGf = 17;
    public int eGj = -16417281;
    public int eGk = -16417281;
    public int eGl = ViewCompat.MEASURED_STATE_MASK;
    public int eGm = -1;
    public int eGn = -657931;
    public int eGo = 17;
    public int eGp = 18;
    public int eGq = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean eGs = true;
    public boolean isCenterLabel = false;
    public Typeface eGt = Typeface.MONOSPACE;
    public WheelView.DividerType eGu = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.eGe = R.layout.pickerview_options;
        } else {
            this.eGe = R.layout.pickerview_time;
        }
    }
}
