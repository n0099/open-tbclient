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
    public int dRA;
    public int dRB;
    public String dRD;
    public String dRE;
    public String dRF;
    public boolean dRO;
    public e dRa;
    public d dRb;
    public com.baidu.tbadk.widget.timepicker.a.d.a dRc;
    public Calendar dRi;
    public Calendar dRj;
    public Calendar dRk;
    public int dRl;
    public int dRm;
    public String dRp;
    public String dRq;
    public String dRr;
    public String dRs;
    public String dRt;
    public String dRu;
    public int dRv;
    public int dRw;
    public int dRx;
    public int dRy;
    public int dRz;
    public ViewGroup decorView;
    public boolean dRd = false;
    public boolean dRe = false;
    public boolean dRf = false;
    public boolean dRg = false;
    public boolean[] dRh = {true, true, true, false, false, false};
    public boolean dRn = false;
    public boolean dRo = false;
    public int dRC = 17;
    public int dRG = -16417281;
    public int dRH = -16417281;
    public int dRI = ViewCompat.MEASURED_STATE_MASK;
    public int dRJ = -1;
    public int dRK = -657931;
    public int dRL = 17;
    public int dRM = 18;
    public int dRN = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean dRP = true;
    public boolean isCenterLabel = false;
    public Typeface dRQ = Typeface.MONOSPACE;
    public WheelView.DividerType dRR = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.dRB = R.layout.pickerview_options;
        } else {
            this.dRB = R.layout.pickerview_time;
        }
    }
}
