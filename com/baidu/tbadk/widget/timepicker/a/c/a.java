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
    public e fWK;
    public d fWL;
    public com.baidu.tbadk.widget.timepicker.a.d.a fWM;
    public Calendar fWS;
    public Calendar fWT;
    public Calendar fWU;
    public int fWV;
    public int fWW;
    public String fWZ;
    public String fXa;
    public String fXb;
    public String fXc;
    public String fXd;
    public String fXe;
    public int fXf;
    public int fXg;
    public int fXh;
    public int fXi;
    public int fXj;
    public int fXk;
    public int fXl;
    public String fXn;
    public String fXo;
    public String fXp;
    public boolean fXy;
    public boolean fWN = false;
    public boolean fWO = false;
    public boolean fWP = false;
    public boolean fWQ = false;
    public boolean[] fWR = {true, true, true, false, false, false};
    public boolean fWX = false;
    public boolean fWY = false;
    public int fXm = 17;
    public int fXq = -16417281;
    public int fXr = -16417281;
    public int fXs = ViewCompat.MEASURED_STATE_MASK;
    public int fXt = -1;
    public int fXu = -657931;
    public int fXv = 17;
    public int fXw = 18;
    public int fXx = 18;
    public int dyh = -5723992;
    public int dyi = -14013910;
    public int dyj = -2763307;
    public int backgroundId = -1;
    public float dyk = 1.6f;
    public boolean cancelable = true;
    public boolean dxU = false;
    public Typeface font = Typeface.MONOSPACE;
    public WheelView.DividerType fXz = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.fXl = R.layout.pickerview_options;
        } else {
            this.fXl = R.layout.pickerview_time;
        }
    }
}
