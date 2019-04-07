package com.baidu.tbadk.widget.timepicker.a.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class b extends a implements View.OnClickListener {
    private c cFK;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.cEs = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        atu();
        initViews();
        initAnim();
        if (this.cEs.cEv == null) {
            LayoutInflater.from(context).inflate(d.h.pickerview_time, this.cFy);
            TextView textView = (TextView) findViewById(d.g.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.rv_topbar);
            Button button = (Button) findViewById(d.g.btnSubmit);
            Button button2 = (Button) findViewById(d.g.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.cEs.cEU) ? context.getResources().getString(d.j.pickerview_submit) : this.cEs.cEU);
            button2.setText(TextUtils.isEmpty(this.cEs.cEV) ? context.getResources().getString(d.j.pickerview_cancel) : this.cEs.cEV);
            textView.setText(TextUtils.isEmpty(this.cEs.cEW) ? "" : this.cEs.cEW);
            button.setTextColor(this.cEs.cEX);
            button2.setTextColor(this.cEs.cEY);
            textView.setTextColor(this.cEs.cEZ);
            relativeLayout.setBackgroundColor(this.cEs.cFb);
            button.setTextSize(this.cEs.cFc);
            button2.setTextSize(this.cEs.cFc);
            textView.setTextSize(this.cEs.cFd);
        } else {
            this.cEs.cEv.aT(LayoutInflater.from(context).inflate(this.cEs.cES, this.cFy));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(d.g.timepicker);
        linearLayout.setBackgroundColor(this.cEs.cFa);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.cFK = new c(linearLayout, this.cEs.cEA, this.cEs.cET, this.cEs.cFe);
        if (this.cEs.cEu != null) {
            this.cFK.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void ats() {
                    try {
                        b.this.cEs.cEu.p(c.cFM.parse(b.this.cFK.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.cFK.fy(this.cEs.cEF);
        if (this.cEs.startYear != 0 && this.cEs.endYear != 0 && this.cEs.startYear <= this.cEs.endYear) {
            atx();
        }
        if (this.cEs.cEC != null && this.cEs.cED != null) {
            if (this.cEs.cEC.getTimeInMillis() > this.cEs.cED.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aty();
        } else if (this.cEs.cEC != null) {
            if (this.cEs.cEC.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aty();
        } else if (this.cEs.cED != null) {
            if (this.cEs.cED.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aty();
        } else {
            aty();
        }
        atA();
        this.cFK.c(this.cEs.cEG, this.cEs.cEH, this.cEs.cEI, this.cEs.cEJ, this.cEs.cEK, this.cEs.cEL);
        this.cFK.h(this.cEs.cEM, this.cEs.cEN, this.cEs.cEO, this.cEs.cEP, this.cEs.cEQ, this.cEs.cER);
        fx(this.cEs.cFk);
        this.cFK.setCyclic(this.cEs.cEE);
        this.cFK.setDividerColor(this.cEs.cFh);
        this.cFK.setDividerType(this.cEs.cFn);
        this.cFK.setLineSpacingMultiplier(this.cEs.cFi);
        this.cFK.setTextColorOut(this.cEs.cFf);
        this.cFK.setTextColorCenter(this.cEs.cFg);
        this.cFK.fz(this.cEs.cFl);
    }

    private void atx() {
        this.cFK.setStartYear(this.cEs.startYear);
        this.cFK.lb(this.cEs.endYear);
    }

    private void aty() {
        this.cFK.a(this.cEs.cEC, this.cEs.cED);
        atz();
    }

    private void atz() {
        if (this.cEs.cEC != null && this.cEs.cED != null) {
            if (this.cEs.cEB == null || this.cEs.cEB.getTimeInMillis() < this.cEs.cEC.getTimeInMillis() || this.cEs.cEB.getTimeInMillis() > this.cEs.cED.getTimeInMillis()) {
                this.cEs.cEB = this.cEs.cEC;
            }
        } else if (this.cEs.cEC != null) {
            this.cEs.cEB = this.cEs.cEC;
        } else if (this.cEs.cED != null) {
            this.cEs.cEB = this.cEs.cED;
        }
    }

    private void atA() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.cEs.cEB == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.cEs.cEB.get(1);
            i2 = this.cEs.cEB.get(2);
            i3 = this.cEs.cEB.get(5);
            i4 = this.cEs.cEB.get(11);
            i5 = this.cEs.cEB.get(12);
            i6 = this.cEs.cEB.get(13);
        }
        this.cFK.f(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            atB();
        }
        dismiss();
    }

    public void atB() {
        if (this.cEs.cEt != null) {
            try {
                this.cEs.cEt.a(c.cFM.parse(this.cFK.getTime()), this.cFF);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean atw() {
        return this.cEs.cFj;
    }
}
