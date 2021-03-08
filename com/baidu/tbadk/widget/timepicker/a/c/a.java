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
    public e gaB;
    public d gaC;
    public com.baidu.tbadk.widget.timepicker.a.d.a gaD;
    public Calendar gaJ;
    public Calendar gaK;
    public Calendar gaL;
    public int gaM;
    public int gaN;
    public String gaQ;
    public String gaR;
    public String gaS;
    public String gaT;
    public String gaU;
    public String gaV;
    public int gaW;
    public int gaX;
    public int gaY;
    public int gaZ;
    public int gba;
    public int gbb;
    public int gbc;
    public String gbe;
    public String gbf;
    public String gbg;
    public boolean gbp;
    public boolean gaE = false;
    public boolean gaF = false;
    public boolean gaG = false;
    public boolean gaH = false;
    public boolean[] gaI = {true, true, true, false, false, false};
    public boolean gaO = false;
    public boolean gaP = false;
    public int gbd = 17;
    public int gbh = -16417281;
    public int gbi = -16417281;
    public int gbj = ViewCompat.MEASURED_STATE_MASK;
    public int gbk = -1;
    public int gbl = -657931;
    public int gbm = 17;
    public int gbn = 18;
    public int gbo = 18;
    public int dBN = -5723992;
    public int dBO = -14013910;
    public int dBP = -2763307;
    public int backgroundId = -1;
    public float dBQ = 1.6f;
    public boolean cancelable = true;
    public boolean dBA = false;
    public Typeface font = Typeface.MONOSPACE;
    public WheelView.DividerType gbq = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.gbc = R.layout.pickerview_options;
        } else {
            this.gbc = R.layout.pickerview_time;
        }
    }
}
