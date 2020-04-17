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
    public e eqX;
    public d eqY;
    public com.baidu.tbadk.widget.timepicker.a.d.a eqZ;
    public String erB;
    public String erC;
    public String erD;
    public boolean erM;
    public Calendar erf;
    public Calendar erg;
    public Calendar erh;
    public int eri;
    public int erj;
    public String erm;
    public String ern;
    public String ero;
    public String erp;
    public String erq;
    public String ers;
    public int ert;
    public int eru;
    public int erv;
    public int erw;
    public int erx;
    public int ery;
    public int erz;
    public boolean era = false;
    public boolean erb = false;
    public boolean erc = false;
    public boolean erd = false;
    public boolean[] ere = {true, true, true, false, false, false};
    public boolean erk = false;
    public boolean erl = false;
    public int erA = 17;
    public int erE = -16417281;
    public int erF = -16417281;
    public int erG = ViewCompat.MEASURED_STATE_MASK;
    public int erH = -1;
    public int erI = -657931;
    public int erJ = 17;
    public int erK = 18;
    public int erL = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean erN = true;
    public boolean isCenterLabel = false;
    public Typeface erO = Typeface.MONOSPACE;
    public WheelView.DividerType erP = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.erz = R.layout.pickerview_options;
        } else {
            this.erz = R.layout.pickerview_time;
        }
    }
}
