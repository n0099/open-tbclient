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
    public e dQJ;
    public d dQK;
    public com.baidu.tbadk.widget.timepicker.a.d.a dQL;
    public Calendar dQR;
    public Calendar dQS;
    public Calendar dQT;
    public int dQU;
    public int dQV;
    public String dQY;
    public String dQZ;
    public String dRa;
    public String dRb;
    public String dRc;
    public String dRd;
    public int dRe;
    public int dRf;
    public int dRg;
    public int dRh;
    public int dRi;
    public int dRj;
    public int dRk;
    public String dRm;
    public String dRn;
    public String dRo;
    public boolean dRx;
    public ViewGroup decorView;
    public boolean dQM = false;
    public boolean dQN = false;
    public boolean dQO = false;
    public boolean dQP = false;
    public boolean[] dQQ = {true, true, true, false, false, false};
    public boolean dQW = false;
    public boolean dQX = false;
    public int dRl = 17;
    public int dRp = -16417281;
    public int dRq = -16417281;
    public int dRr = ViewCompat.MEASURED_STATE_MASK;
    public int dRs = -1;
    public int dRt = -657931;
    public int dRu = 17;
    public int dRv = 18;
    public int dRw = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean dRy = true;
    public boolean isCenterLabel = false;
    public Typeface dRz = Typeface.MONOSPACE;
    public WheelView.DividerType dRA = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.dRk = R.layout.pickerview_options;
        } else {
            this.dRk = R.layout.pickerview_time;
        }
    }
}
