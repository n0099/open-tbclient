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
    public e fEK;
    public d fEL;
    public com.baidu.tbadk.widget.timepicker.a.d.a fEM;
    public Calendar fES;
    public Calendar fET;
    public Calendar fEU;
    public int fEV;
    public int fEW;
    public String fEZ;
    public String fFa;
    public String fFb;
    public String fFc;
    public String fFd;
    public String fFe;
    public int fFf;
    public int fFg;
    public int fFh;
    public int fFi;
    public int fFj;
    public int fFk;
    public int fFl;
    public String fFn;
    public String fFo;
    public String fFp;
    public boolean fFy;
    public boolean fEN = false;
    public boolean fEO = false;
    public boolean fEP = false;
    public boolean fEQ = false;
    public boolean[] fER = {true, true, true, false, false, false};
    public boolean fEX = false;
    public boolean fEY = false;
    public int fFm = 17;
    public int fFq = -16417281;
    public int fFr = -16417281;
    public int fFs = ViewCompat.MEASURED_STATE_MASK;
    public int fFt = -1;
    public int fFu = -657931;
    public int fFv = 17;
    public int fFw = 18;
    public int fFx = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean fFz = true;
    public boolean isCenterLabel = false;
    public Typeface fFA = Typeface.MONOSPACE;
    public WheelView.DividerType fFB = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.fFl = R.layout.pickerview_options;
        } else {
            this.fFl = R.layout.pickerview_time;
        }
    }
}
