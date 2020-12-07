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
    public e fRO;
    public d fRP;
    public com.baidu.tbadk.widget.timepicker.a.d.a fRQ;
    public Calendar fRW;
    public Calendar fRX;
    public Calendar fRY;
    public int fRZ;
    public boolean fSC;
    public int fSa;
    public String fSd;
    public String fSe;
    public String fSf;
    public String fSg;
    public String fSh;
    public String fSi;
    public int fSj;
    public int fSk;
    public int fSl;
    public int fSm;
    public int fSn;
    public int fSo;
    public int fSp;
    public String fSr;
    public String fSs;
    public String fSt;
    public boolean fRR = false;
    public boolean fRS = false;
    public boolean fRT = false;
    public boolean fRU = false;
    public boolean[] fRV = {true, true, true, false, false, false};
    public boolean fSb = false;
    public boolean fSc = false;
    public int fSq = 17;
    public int fSu = -16417281;
    public int fSv = -16417281;
    public int fSw = ViewCompat.MEASURED_STATE_MASK;
    public int fSx = -1;
    public int fSy = -657931;
    public int fSz = 17;
    public int fSA = 18;
    public int fSB = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean fSD = true;
    public boolean isCenterLabel = false;
    public Typeface fSE = Typeface.MONOSPACE;
    public WheelView.DividerType fSF = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.fSp = R.layout.pickerview_options;
        } else {
            this.fSp = R.layout.pickerview_time;
        }
    }
}
