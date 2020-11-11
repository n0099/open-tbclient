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
    public e fKA;
    public d fKB;
    public com.baidu.tbadk.widget.timepicker.a.d.a fKC;
    public Calendar fKI;
    public Calendar fKJ;
    public Calendar fKK;
    public int fKL;
    public int fKM;
    public String fKP;
    public String fKQ;
    public String fKR;
    public String fKS;
    public String fKT;
    public String fKU;
    public int fKV;
    public int fKW;
    public int fKX;
    public int fKY;
    public int fKZ;
    public int fLa;
    public int fLb;
    public String fLd;
    public String fLe;
    public String fLf;
    public boolean fLo;
    public boolean fKD = false;
    public boolean fKE = false;
    public boolean fKF = false;
    public boolean fKG = false;
    public boolean[] fKH = {true, true, true, false, false, false};
    public boolean fKN = false;
    public boolean fKO = false;
    public int fLc = 17;
    public int fLg = -16417281;
    public int fLh = -16417281;
    public int fLi = ViewCompat.MEASURED_STATE_MASK;
    public int fLj = -1;
    public int fLk = -657931;
    public int fLl = 17;
    public int fLm = 18;
    public int fLn = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean fLp = true;
    public boolean isCenterLabel = false;
    public Typeface fLq = Typeface.MONOSPACE;
    public WheelView.DividerType fLr = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.fLb = R.layout.pickerview_options;
        } else {
            this.fLb = R.layout.pickerview_time;
        }
    }
}
