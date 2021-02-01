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
    public int fZA;
    public int fZB;
    public String fZD;
    public String fZE;
    public String fZF;
    public boolean fZO;
    public e fZa;
    public d fZb;
    public com.baidu.tbadk.widget.timepicker.a.d.a fZc;
    public Calendar fZi;
    public Calendar fZj;
    public Calendar fZk;
    public int fZl;
    public int fZm;
    public String fZp;
    public String fZq;
    public String fZr;
    public String fZs;
    public String fZt;
    public String fZu;
    public int fZv;
    public int fZw;
    public int fZx;
    public int fZy;
    public int fZz;
    public boolean fZd = false;
    public boolean fZe = false;
    public boolean fZf = false;
    public boolean fZg = false;
    public boolean[] fZh = {true, true, true, false, false, false};
    public boolean fZn = false;
    public boolean fZo = false;
    public int fZC = 17;
    public int fZG = -16417281;
    public int fZH = -16417281;
    public int fZI = ViewCompat.MEASURED_STATE_MASK;
    public int fZJ = -1;
    public int fZK = -657931;
    public int fZL = 17;
    public int fZM = 18;
    public int fZN = 18;
    public int dAm = -5723992;
    public int dAn = -14013910;
    public int dAo = -2763307;
    public int backgroundId = -1;
    public float dAp = 1.6f;
    public boolean cancelable = true;
    public boolean dzZ = false;
    public Typeface font = Typeface.MONOSPACE;
    public WheelView.DividerType fZP = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.fZB = R.layout.pickerview_options;
        } else {
            this.fZB = R.layout.pickerview_time;
        }
    }
}
