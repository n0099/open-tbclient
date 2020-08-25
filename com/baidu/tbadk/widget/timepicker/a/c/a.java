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
/* loaded from: classes15.dex */
public class a {
    public Context context;
    public ViewGroup decorView;
    public int fhA;
    public int fhB;
    public int fhC;
    public int fhD;
    public int fhE;
    public String fhG;
    public String fhH;
    public String fhI;
    public boolean fhR;
    public e fhd;
    public d fhe;
    public com.baidu.tbadk.widget.timepicker.a.d.a fhf;
    public Calendar fhl;
    public Calendar fhm;
    public Calendar fhn;
    public int fho;
    public int fhp;
    public String fhs;
    public String fht;
    public String fhu;
    public String fhv;
    public String fhw;
    public String fhx;
    public int fhy;
    public int fhz;
    public boolean fhg = false;
    public boolean fhh = false;
    public boolean fhi = false;
    public boolean fhj = false;
    public boolean[] fhk = {true, true, true, false, false, false};
    public boolean fhq = false;
    public boolean fhr = false;
    public int fhF = 17;
    public int fhJ = -16417281;
    public int fhK = -16417281;
    public int fhL = ViewCompat.MEASURED_STATE_MASK;
    public int fhM = -1;
    public int fhN = -657931;
    public int fhO = 17;
    public int fhP = 18;
    public int fhQ = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean fhS = true;
    public boolean isCenterLabel = false;
    public Typeface fhT = Typeface.MONOSPACE;
    public WheelView.DividerType fhU = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.fhE = R.layout.pickerview_options;
        } else {
            this.fhE = R.layout.pickerview_time;
        }
    }
}
