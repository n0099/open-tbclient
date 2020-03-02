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
    public Calendar dQE;
    public Calendar dQF;
    public Calendar dQG;
    public int dQH;
    public int dQI;
    public String dQL;
    public String dQM;
    public String dQN;
    public String dQO;
    public String dQP;
    public String dQQ;
    public int dQR;
    public int dQS;
    public int dQT;
    public int dQU;
    public int dQV;
    public int dQW;
    public int dQX;
    public String dQZ;
    public e dQw;
    public d dQx;
    public com.baidu.tbadk.widget.timepicker.a.d.a dQy;
    public String dRa;
    public String dRb;
    public boolean dRk;
    public ViewGroup decorView;
    public boolean dQz = false;
    public boolean dQA = false;
    public boolean dQB = false;
    public boolean dQC = false;
    public boolean[] dQD = {true, true, true, false, false, false};
    public boolean dQJ = false;
    public boolean dQK = false;
    public int dQY = 17;
    public int dRc = -16417281;
    public int dRd = -16417281;
    public int dRe = ViewCompat.MEASURED_STATE_MASK;
    public int dRf = -1;
    public int dRg = -657931;
    public int dRh = 17;
    public int dRi = 18;
    public int dRj = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean dRl = true;
    public boolean isCenterLabel = false;
    public Typeface dRm = Typeface.MONOSPACE;
    public WheelView.DividerType dRn = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.dQX = R.layout.pickerview_options;
        } else {
            this.dQX = R.layout.pickerview_time;
        }
    }
}
