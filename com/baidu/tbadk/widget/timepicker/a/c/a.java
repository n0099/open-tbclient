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
    public String cYC;
    public String cYD;
    public String cYE;
    public String cYF;
    public String cYG;
    public String cYH;
    public int cYI;
    public int cYJ;
    public int cYK;
    public int cYL;
    public int cYM;
    public int cYN;
    public int cYO;
    public String cYQ;
    public String cYR;
    public String cYS;
    public e cYn;
    public d cYo;
    public com.baidu.tbadk.widget.timepicker.a.d.a cYp;
    public Calendar cYv;
    public Calendar cYw;
    public Calendar cYx;
    public int cYy;
    public int cYz;
    public boolean cZf;
    public Context context;
    public ViewGroup decorView;
    public boolean cYq = false;
    public boolean cYr = false;
    public boolean cYs = false;
    public boolean cYt = false;
    public boolean[] cYu = {true, true, true, false, false, false};
    public boolean cYA = false;
    public boolean cYB = false;
    public int cYP = 17;
    public int cYT = -16417281;
    public int cYU = -16417281;
    public int cYV = ViewCompat.MEASURED_STATE_MASK;
    public int cYW = -1;
    public int cYX = -657931;
    public int cYY = 17;
    public int cYZ = 18;
    public int cZa = 18;
    public int cZb = -5723992;
    public int cZc = -14013910;
    public int cZd = -2763307;
    public int backgroundId = -1;
    public float cZe = 1.6f;
    public boolean cZg = true;
    public boolean cZh = false;
    public Typeface cZi = Typeface.MONOSPACE;
    public WheelView.DividerType cZj = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.cYO = R.layout.pickerview_options;
        } else {
            this.cYO = R.layout.pickerview_time;
        }
    }
}
