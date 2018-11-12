package com.baidu.tbadk.widget.timepicker.a.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tieba.e;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes.dex */
public class b extends a implements View.OnClickListener {
    private c bqk;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.boS = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        RU();
        initViews();
        initAnim();
        if (this.boS.boV == null) {
            LayoutInflater.from(context).inflate(e.h.pickerview_time, this.bpY);
            TextView textView = (TextView) findViewById(e.g.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.rv_topbar);
            Button button = (Button) findViewById(e.g.btnSubmit);
            Button button2 = (Button) findViewById(e.g.btnCancel);
            button.setTag("submit");
            button2.setTag(AiAppsUBCStatistic.VALUE_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.boS.bpu) ? context.getResources().getString(e.j.pickerview_submit) : this.boS.bpu);
            button2.setText(TextUtils.isEmpty(this.boS.bpv) ? context.getResources().getString(e.j.pickerview_cancel) : this.boS.bpv);
            textView.setText(TextUtils.isEmpty(this.boS.bpw) ? "" : this.boS.bpw);
            button.setTextColor(this.boS.bpx);
            button2.setTextColor(this.boS.bpy);
            textView.setTextColor(this.boS.bpz);
            relativeLayout.setBackgroundColor(this.boS.bpB);
            button.setTextSize(this.boS.bpC);
            button2.setTextSize(this.boS.bpC);
            textView.setTextSize(this.boS.bpD);
        } else {
            this.boS.boV.Z(LayoutInflater.from(context).inflate(this.boS.bps, this.bpY));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(e.g.timepicker);
        linearLayout.setBackgroundColor(this.boS.bpA);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.bqk = new c(linearLayout, this.boS.bpa, this.boS.bpt, this.boS.bpE);
        if (this.boS.boU != null) {
            this.bqk.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void RS() {
                    try {
                        b.this.boS.boU.j(c.bqm.parse(b.this.bqk.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.bqk.de(this.boS.bpf);
        if (this.boS.startYear != 0 && this.boS.endYear != 0 && this.boS.startYear <= this.boS.endYear) {
            RX();
        }
        if (this.boS.bpc != null && this.boS.bpd != null) {
            if (this.boS.bpc.getTimeInMillis() > this.boS.bpd.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            RY();
        } else if (this.boS.bpc != null) {
            if (this.boS.bpc.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            RY();
        } else if (this.boS.bpd != null) {
            if (this.boS.bpd.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            RY();
        } else {
            RY();
        }
        Sa();
        this.bqk.c(this.boS.bpg, this.boS.bph, this.boS.bpi, this.boS.bpj, this.boS.bpk, this.boS.bpl);
        this.bqk.h(this.boS.bpm, this.boS.bpn, this.boS.bpo, this.boS.bpp, this.boS.bpq, this.boS.bpr);
        dd(this.boS.bpK);
        this.bqk.setCyclic(this.boS.bpe);
        this.bqk.setDividerColor(this.boS.bpH);
        this.bqk.setDividerType(this.boS.bpN);
        this.bqk.setLineSpacingMultiplier(this.boS.bpI);
        this.bqk.setTextColorOut(this.boS.bpF);
        this.bqk.setTextColorCenter(this.boS.bpG);
        this.bqk.df(this.boS.bpL);
    }

    private void RX() {
        this.bqk.setStartYear(this.boS.startYear);
        this.bqk.gX(this.boS.endYear);
    }

    private void RY() {
        this.bqk.a(this.boS.bpc, this.boS.bpd);
        RZ();
    }

    private void RZ() {
        if (this.boS.bpc != null && this.boS.bpd != null) {
            if (this.boS.bpb == null || this.boS.bpb.getTimeInMillis() < this.boS.bpc.getTimeInMillis() || this.boS.bpb.getTimeInMillis() > this.boS.bpd.getTimeInMillis()) {
                this.boS.bpb = this.boS.bpc;
            }
        } else if (this.boS.bpc != null) {
            this.boS.bpb = this.boS.bpc;
        } else if (this.boS.bpd != null) {
            this.boS.bpb = this.boS.bpd;
        }
    }

    private void Sa() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.boS.bpb == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.boS.bpb.get(1);
            i2 = this.boS.bpb.get(2);
            i3 = this.boS.bpb.get(5);
            i4 = this.boS.bpb.get(11);
            i5 = this.boS.bpb.get(12);
            i6 = this.boS.bpb.get(13);
        }
        this.bqk.f(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            Sb();
        }
        dismiss();
    }

    public void Sb() {
        if (this.boS.boT != null) {
            try {
                this.boS.boT.a(c.bqm.parse(this.bqk.getTime()), this.bqf);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean RW() {
        return this.boS.bpJ;
    }
}
