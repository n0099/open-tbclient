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
    private c buA;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.btg = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        Ty();
        initViews();
        initAnim();
        if (this.btg.btj == null) {
            LayoutInflater.from(context).inflate(e.h.pickerview_time, this.buo);
            TextView textView = (TextView) findViewById(e.g.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.rv_topbar);
            Button button = (Button) findViewById(e.g.btnSubmit);
            Button button2 = (Button) findViewById(e.g.btnCancel);
            button.setTag("submit");
            button2.setTag(AiAppsUBCStatistic.VALUE_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.btg.btJ) ? context.getResources().getString(e.j.pickerview_submit) : this.btg.btJ);
            button2.setText(TextUtils.isEmpty(this.btg.btK) ? context.getResources().getString(e.j.pickerview_cancel) : this.btg.btK);
            textView.setText(TextUtils.isEmpty(this.btg.btL) ? "" : this.btg.btL);
            button.setTextColor(this.btg.btM);
            button2.setTextColor(this.btg.btN);
            textView.setTextColor(this.btg.btO);
            relativeLayout.setBackgroundColor(this.btg.btQ);
            button.setTextSize(this.btg.btR);
            button2.setTextSize(this.btg.btR);
            textView.setTextSize(this.btg.btS);
        } else {
            this.btg.btj.Z(LayoutInflater.from(context).inflate(this.btg.btH, this.buo));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(e.g.timepicker);
        linearLayout.setBackgroundColor(this.btg.btP);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.buA = new c(linearLayout, this.btg.btp, this.btg.btI, this.btg.btT);
        if (this.btg.bti != null) {
            this.buA.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void Tw() {
                    try {
                        b.this.btg.bti.k(c.buC.parse(b.this.buA.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.buA.di(this.btg.btu);
        if (this.btg.startYear != 0 && this.btg.endYear != 0 && this.btg.startYear <= this.btg.endYear) {
            TB();
        }
        if (this.btg.btr != null && this.btg.bts != null) {
            if (this.btg.btr.getTimeInMillis() > this.btg.bts.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            TC();
        } else if (this.btg.btr != null) {
            if (this.btg.btr.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            TC();
        } else if (this.btg.bts != null) {
            if (this.btg.bts.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            TC();
        } else {
            TC();
        }
        TE();
        this.buA.c(this.btg.btv, this.btg.btw, this.btg.btx, this.btg.bty, this.btg.btz, this.btg.btA);
        this.buA.h(this.btg.btB, this.btg.btC, this.btg.btD, this.btg.btE, this.btg.btF, this.btg.btG);
        dh(this.btg.btZ);
        this.buA.setCyclic(this.btg.btt);
        this.buA.setDividerColor(this.btg.btW);
        this.buA.setDividerType(this.btg.buc);
        this.buA.setLineSpacingMultiplier(this.btg.btX);
        this.buA.setTextColorOut(this.btg.btU);
        this.buA.setTextColorCenter(this.btg.btV);
        this.buA.dj(this.btg.bua);
    }

    private void TB() {
        this.buA.setStartYear(this.btg.startYear);
        this.buA.hm(this.btg.endYear);
    }

    private void TC() {
        this.buA.a(this.btg.btr, this.btg.bts);
        TD();
    }

    private void TD() {
        if (this.btg.btr != null && this.btg.bts != null) {
            if (this.btg.btq == null || this.btg.btq.getTimeInMillis() < this.btg.btr.getTimeInMillis() || this.btg.btq.getTimeInMillis() > this.btg.bts.getTimeInMillis()) {
                this.btg.btq = this.btg.btr;
            }
        } else if (this.btg.btr != null) {
            this.btg.btq = this.btg.btr;
        } else if (this.btg.bts != null) {
            this.btg.btq = this.btg.bts;
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
        if (this.btg.btq == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.btg.btq.get(1);
            i2 = this.btg.btq.get(2);
            i3 = this.btg.btq.get(5);
            i4 = this.btg.btq.get(11);
            i5 = this.btg.btq.get(12);
            i6 = this.btg.btq.get(13);
        }
        this.buA.f(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            TF();
        }
        dismiss();
    }

    public void TF() {
        if (this.btg.bth != null) {
            try {
                this.btg.bth.a(c.buC.parse(this.buA.getTime()), this.buv);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean TA() {
        return this.btg.btY;
    }
}
