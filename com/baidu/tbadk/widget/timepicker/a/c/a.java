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
    public String fhA;
    public String fhB;
    public int fhC;
    public int fhD;
    public int fhE;
    public int fhF;
    public int fhG;
    public int fhH;
    public int fhI;
    public String fhK;
    public String fhL;
    public String fhM;
    public boolean fhV;
    public e fhh;
    public d fhi;
    public com.baidu.tbadk.widget.timepicker.a.d.a fhj;
    public Calendar fhp;
    public Calendar fhq;
    public Calendar fhr;
    public int fhs;
    public int fht;
    public String fhw;
    public String fhx;
    public String fhy;
    public String fhz;
    public boolean fhk = false;
    public boolean fhl = false;
    public boolean fhm = false;
    public boolean fhn = false;
    public boolean[] fho = {true, true, true, false, false, false};
    public boolean fhu = false;
    public boolean fhv = false;
    public int fhJ = 17;
    public int fhN = -16417281;
    public int fhO = -16417281;
    public int fhP = ViewCompat.MEASURED_STATE_MASK;
    public int fhQ = -1;
    public int fhR = -657931;
    public int fhS = 17;
    public int fhT = 18;
    public int fhU = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean fhW = true;
    public boolean isCenterLabel = false;
    public Typeface fhX = Typeface.MONOSPACE;
    public WheelView.DividerType fhY = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.fhI = R.layout.pickerview_options;
        } else {
            this.fhI = R.layout.pickerview_time;
        }
    }
}
