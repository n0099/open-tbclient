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
    public Calendar eWD;
    public Calendar eWE;
    public Calendar eWF;
    public int eWG;
    public int eWH;
    public String eWK;
    public String eWL;
    public String eWM;
    public String eWN;
    public String eWO;
    public String eWP;
    public int eWQ;
    public int eWR;
    public int eWS;
    public int eWT;
    public int eWU;
    public int eWV;
    public int eWW;
    public String eWY;
    public String eWZ;
    public e eWv;
    public d eWw;
    public com.baidu.tbadk.widget.timepicker.a.d.a eWx;
    public String eXa;
    public boolean eXj;
    public boolean eWy = false;
    public boolean eWz = false;
    public boolean eWA = false;
    public boolean eWB = false;
    public boolean[] eWC = {true, true, true, false, false, false};
    public boolean eWI = false;
    public boolean eWJ = false;
    public int eWX = 17;
    public int eXb = -16417281;
    public int eXc = -16417281;
    public int eXd = ViewCompat.MEASURED_STATE_MASK;
    public int eXe = -1;
    public int eXf = -657931;
    public int eXg = 17;
    public int eXh = 18;
    public int eXi = 18;
    public int textColorOut = -5723992;
    public int textColorCenter = -14013910;
    public int dividerColor = -2763307;
    public int backgroundId = -1;
    public float lineSpacingMultiplier = 1.6f;
    public boolean eXk = true;
    public boolean isCenterLabel = false;
    public Typeface eXl = Typeface.MONOSPACE;
    public WheelView.DividerType eXm = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.eWW = R.layout.pickerview_options;
        } else {
            this.eWW = R.layout.pickerview_time;
        }
    }
}
