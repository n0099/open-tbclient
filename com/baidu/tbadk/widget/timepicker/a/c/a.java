package com.baidu.tbadk.widget.timepicker.a.c;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.d;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.e;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    public e boT;
    public d boU;
    public com.baidu.tbadk.widget.timepicker.a.d.a boV;
    public boolean bpJ;
    public Calendar bpb;
    public Calendar bpc;
    public Calendar bpd;
    public String bpg;
    public String bph;
    public String bpi;
    public String bpj;
    public String bpk;
    public String bpl;
    public int bpm;
    public int bpn;
    public int bpo;
    public int bpp;
    public int bpq;
    public int bpr;
    public int bps;
    public String bpu;
    public String bpv;
    public String bpw;
    public Context context;
    public ViewGroup decorView;
    public int endYear;
    public int startYear;
    public boolean boW = false;
    public boolean boX = false;
    public boolean boY = false;
    public boolean boZ = false;
    public boolean[] bpa = {true, true, true, false, false, false};
    public boolean bpe = false;
    public boolean bpf = false;
    public int bpt = 17;
    public int bpx = -16417281;
    public int bpy = -16417281;
    public int bpz = -16777216;
    public int bpA = -1;
    public int bpB = -657931;
    public int bpC = 17;
    public int bpD = 18;
    public int bpE = 18;
    public int bpF = -5723992;
    public int bpG = -14013910;
    public int bpH = -2763307;
    public int ban = -1;
    public float bpI = 1.6f;
    public boolean bpK = true;
    public boolean bpL = false;
    public Typeface bpM = Typeface.MONOSPACE;
    public WheelView.DividerType bpN = WheelView.DividerType.FILL;

    public a(int i) {
        if (i == 1) {
            this.bps = e.h.pickerview_options;
        } else {
            this.bps = e.h.pickerview_time;
        }
    }
}
