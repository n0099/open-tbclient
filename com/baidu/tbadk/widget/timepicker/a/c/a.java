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
    public Calendar dQD;
    public Calendar dQE;
    public Calendar dQF;
    public int dQG;
    public int dQH;
    public String dQK;
    public String dQL;
    public String dQM;
    public String dQN;
    public String dQO;
    public String dQP;
    public int dQQ;
    public int dQR;
    public int dQS;
    public int dQT;
    public int dQU;
    public int dQV;
    public int dQW;
    public String dQY;
    public String dQZ;
    public e dQv;
    public d dQw;
    public com.baidu.tbadk.widget.timepicker.a.d.a dQx;
    public String dRa;
    public boolean dRj;
    public ViewGroup decorView;
    public boolean dQy = false;
    public boolean dQz = false;
    public boolean dQA = false;
    public boolean dQB = false;
    public boolean[] dQC = {true, true, true, false, false, false};
    public boolean dQI = false;
    public boolean dQJ = false;
    public int dQX = 17;
    public int dRb = -16417281;
    public int dRc = -16417281;
    public int dRd = ViewCompat.MEASURED_STATE_MASK;
    public int dRe = -1;
    public int dRf = -657931;
    public int dRg = 17;
    public int dRh = 18;
    public int dRi = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean dRk = true;
    public boolean isCenterLabel = false;
    public Typeface dRl = Typeface.MONOSPACE;
    public WheelView.DividerType dRm = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.dQW = R.layout.pickerview_options;
        } else {
            this.dQW = R.layout.pickerview_time;
        }
    }
}
