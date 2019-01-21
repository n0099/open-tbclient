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
    private c buB;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.bth = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        Ty();
        initViews();
        initAnim();
        if (this.bth.btk == null) {
            LayoutInflater.from(context).inflate(e.h.pickerview_time, this.bup);
            TextView textView = (TextView) findViewById(e.g.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.rv_topbar);
            Button button = (Button) findViewById(e.g.btnSubmit);
            Button button2 = (Button) findViewById(e.g.btnCancel);
            button.setTag("submit");
            button2.setTag(AiAppsUBCStatistic.VALUE_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.bth.btK) ? context.getResources().getString(e.j.pickerview_submit) : this.bth.btK);
            button2.setText(TextUtils.isEmpty(this.bth.btL) ? context.getResources().getString(e.j.pickerview_cancel) : this.bth.btL);
            textView.setText(TextUtils.isEmpty(this.bth.btM) ? "" : this.bth.btM);
            button.setTextColor(this.bth.btN);
            button2.setTextColor(this.bth.btO);
            textView.setTextColor(this.bth.btP);
            relativeLayout.setBackgroundColor(this.bth.btR);
            button.setTextSize(this.bth.btS);
            button2.setTextSize(this.bth.btS);
            textView.setTextSize(this.bth.btT);
        } else {
            this.bth.btk.Z(LayoutInflater.from(context).inflate(this.bth.btI, this.bup));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(e.g.timepicker);
        linearLayout.setBackgroundColor(this.bth.btQ);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.buB = new c(linearLayout, this.bth.btq, this.bth.btJ, this.bth.btU);
        if (this.bth.btj != null) {
            this.buB.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void Tw() {
                    try {
                        b.this.bth.btj.k(c.buD.parse(b.this.buB.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.buB.di(this.bth.btv);
        if (this.bth.startYear != 0 && this.bth.endYear != 0 && this.bth.startYear <= this.bth.endYear) {
            TB();
        }
        if (this.bth.bts != null && this.bth.btt != null) {
            if (this.bth.bts.getTimeInMillis() > this.bth.btt.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            TC();
        } else if (this.bth.bts != null) {
            if (this.bth.bts.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            TC();
        } else if (this.bth.btt != null) {
            if (this.bth.btt.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            TC();
        } else {
            TC();
        }
        TE();
        this.buB.c(this.bth.btw, this.bth.btx, this.bth.bty, this.bth.btz, this.bth.btA, this.bth.btB);
        this.buB.h(this.bth.btC, this.bth.btD, this.bth.btE, this.bth.btF, this.bth.btG, this.bth.btH);
        dh(this.bth.bua);
        this.buB.setCyclic(this.bth.btu);
        this.buB.setDividerColor(this.bth.btX);
        this.buB.setDividerType(this.bth.bud);
        this.buB.setLineSpacingMultiplier(this.bth.btY);
        this.buB.setTextColorOut(this.bth.btV);
        this.buB.setTextColorCenter(this.bth.btW);
        this.buB.dj(this.bth.bub);
    }

    private void TB() {
        this.buB.setStartYear(this.bth.startYear);
        this.buB.hm(this.bth.endYear);
    }

    private void TC() {
        this.buB.a(this.bth.bts, this.bth.btt);
        TD();
    }

    private void TD() {
        if (this.bth.bts != null && this.bth.btt != null) {
            if (this.bth.btr == null || this.bth.btr.getTimeInMillis() < this.bth.bts.getTimeInMillis() || this.bth.btr.getTimeInMillis() > this.bth.btt.getTimeInMillis()) {
                this.bth.btr = this.bth.bts;
            }
        } else if (this.bth.bts != null) {
            this.bth.btr = this.bth.bts;
        } else if (this.bth.btt != null) {
            this.bth.btr = this.bth.btt;
        }
    }

    private void TE() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.bth.btr == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.bth.btr.get(1);
            i2 = this.bth.btr.get(2);
            i3 = this.bth.btr.get(5);
            i4 = this.bth.btr.get(11);
            i5 = this.bth.btr.get(12);
            i6 = this.bth.btr.get(13);
        }
        this.buB.f(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            TF();
        }
        dismiss();
    }

    public void TF() {
        if (this.bth.bti != null) {
            try {
                this.bth.bti.a(c.buD.parse(this.buB.getTime()), this.buw);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean TA() {
        return this.bth.btZ;
    }
}
