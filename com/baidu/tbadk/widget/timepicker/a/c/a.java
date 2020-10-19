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
/* loaded from: classes21.dex */
public class a {
    public Context context;
    public ViewGroup decorView;
    public int fwA;
    public int fwB;
    public String fwE;
    public String fwF;
    public String fwG;
    public String fwH;
    public String fwI;
    public String fwJ;
    public int fwK;
    public int fwL;
    public int fwM;
    public int fwN;
    public int fwO;
    public int fwP;
    public int fwQ;
    public String fwS;
    public String fwT;
    public String fwU;
    public e fwp;
    public d fwq;
    public com.baidu.tbadk.widget.timepicker.a.d.a fwr;
    public Calendar fwx;
    public Calendar fwy;
    public Calendar fwz;
    public boolean fxd;
    public boolean fws = false;
    public boolean fwt = false;
    public boolean fwu = false;
    public boolean fwv = false;
    public boolean[] fww = {true, true, true, false, false, false};
    public boolean fwC = false;
    public boolean fwD = false;
    public int fwR = 17;
    public int fwV = -16417281;
    public int fwW = -16417281;
    public int fwX = ViewCompat.MEASURED_STATE_MASK;
    public int fwY = -1;
    public int fwZ = -657931;
    public int fxa = 17;
    public int fxb = 18;
    public int fxc = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean fxe = true;
    public boolean isCenterLabel = false;
    public Typeface fxf = Typeface.MONOSPACE;
    public WheelView.DividerType fxg = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.fwQ = R.layout.pickerview_options;
        } else {
            this.fwQ = R.layout.pickerview_time;
        }
    }
}
