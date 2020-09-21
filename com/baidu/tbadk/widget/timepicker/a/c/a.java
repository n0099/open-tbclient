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
/* loaded from: classes20.dex */
public class a {
    public Context context;
    public ViewGroup decorView;
    public int fkA;
    public int fkB;
    public int fkC;
    public String fkE;
    public String fkF;
    public String fkG;
    public boolean fkP;
    public e fkb;
    public d fkc;
    public com.baidu.tbadk.widget.timepicker.a.d.a fkd;
    public Calendar fkj;
    public Calendar fkk;
    public Calendar fkl;
    public int fkm;
    public int fkn;
    public String fkq;
    public String fkr;
    public String fks;
    public String fkt;
    public String fku;
    public String fkv;
    public int fkw;
    public int fkx;
    public int fky;
    public int fkz;
    public boolean fke = false;
    public boolean fkf = false;
    public boolean fkg = false;
    public boolean fkh = false;
    public boolean[] fki = {true, true, true, false, false, false};
    public boolean fko = false;
    public boolean fkp = false;
    public int fkD = 17;
    public int fkH = -16417281;
    public int fkI = -16417281;
    public int fkJ = ViewCompat.MEASURED_STATE_MASK;
    public int fkK = -1;
    public int fkL = -657931;
    public int fkM = 17;
    public int fkN = 18;
    public int fkO = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean fkQ = true;
    public boolean isCenterLabel = false;
    public Typeface fkR = Typeface.MONOSPACE;
    public WheelView.DividerType fkS = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.fkC = R.layout.pickerview_options;
        } else {
            this.fkC = R.layout.pickerview_time;
        }
    }
}
