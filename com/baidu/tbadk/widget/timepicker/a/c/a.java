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
    public int erA;
    public int erB;
    public int erC;
    public int erD;
    public int erE;
    public String erG;
    public String erH;
    public String erI;
    public boolean erR;
    public e erc;
    public d erd;
    public com.baidu.tbadk.widget.timepicker.a.d.a ere;
    public Calendar erk;
    public Calendar erl;
    public Calendar erm;
    public int ern;
    public int ero;
    public String ers;
    public String ert;
    public String eru;
    public String erv;
    public String erw;
    public String erx;
    public int ery;
    public int erz;
    public boolean erf = false;
    public boolean erg = false;
    public boolean erh = false;
    public boolean eri = false;
    public boolean[] erj = {true, true, true, false, false, false};
    public boolean erp = false;
    public boolean erq = false;
    public int erF = 17;
    public int erJ = -16417281;
    public int erK = -16417281;
    public int erL = ViewCompat.MEASURED_STATE_MASK;
    public int erM = -1;
    public int erN = -657931;
    public int erO = 17;
    public int erP = 18;
    public int erQ = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean erS = true;
    public boolean isCenterLabel = false;
    public Typeface erT = Typeface.MONOSPACE;
    public WheelView.DividerType erU = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.erE = R.layout.pickerview_options;
        } else {
            this.erE = R.layout.pickerview_time;
        }
    }
}
