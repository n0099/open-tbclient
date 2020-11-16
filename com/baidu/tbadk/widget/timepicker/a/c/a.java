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
    public int fKA;
    public int fKB;
    public int fKC;
    public int fKD;
    public int fKE;
    public String fKG;
    public String fKH;
    public String fKI;
    public boolean fKR;
    public e fKd;
    public d fKe;
    public com.baidu.tbadk.widget.timepicker.a.d.a fKf;
    public Calendar fKl;
    public Calendar fKm;
    public Calendar fKn;
    public int fKo;
    public int fKp;
    public String fKs;
    public String fKt;
    public String fKu;
    public String fKv;
    public String fKw;
    public String fKx;
    public int fKy;
    public int fKz;
    public boolean fKg = false;
    public boolean fKh = false;
    public boolean fKi = false;
    public boolean fKj = false;
    public boolean[] fKk = {true, true, true, false, false, false};
    public boolean fKq = false;
    public boolean fKr = false;
    public int fKF = 17;
    public int fKJ = -16417281;
    public int fKK = -16417281;
    public int fKL = ViewCompat.MEASURED_STATE_MASK;
    public int fKM = -1;
    public int fKN = -657931;
    public int fKO = 17;
    public int fKP = 18;
    public int fKQ = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean fKS = true;
    public boolean isCenterLabel = false;
    public Typeface fKT = Typeface.MONOSPACE;
    public WheelView.DividerType fKU = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.fKE = R.layout.pickerview_options;
        } else {
            this.fKE = R.layout.pickerview_time;
        }
    }
}
