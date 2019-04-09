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
    private c cFL;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.cEt = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        atu();
        initViews();
        initAnim();
        if (this.cEt.cEw == null) {
            LayoutInflater.from(context).inflate(d.h.pickerview_time, this.cFz);
            TextView textView = (TextView) findViewById(d.g.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.rv_topbar);
            Button button = (Button) findViewById(d.g.btnSubmit);
            Button button2 = (Button) findViewById(d.g.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.cEt.cEV) ? context.getResources().getString(d.j.pickerview_submit) : this.cEt.cEV);
            button2.setText(TextUtils.isEmpty(this.cEt.cEW) ? context.getResources().getString(d.j.pickerview_cancel) : this.cEt.cEW);
            textView.setText(TextUtils.isEmpty(this.cEt.cEX) ? "" : this.cEt.cEX);
            button.setTextColor(this.cEt.cEY);
            button2.setTextColor(this.cEt.cEZ);
            textView.setTextColor(this.cEt.cFa);
            relativeLayout.setBackgroundColor(this.cEt.cFc);
            button.setTextSize(this.cEt.cFd);
            button2.setTextSize(this.cEt.cFd);
            textView.setTextSize(this.cEt.cFe);
        } else {
            this.cEt.cEw.aT(LayoutInflater.from(context).inflate(this.cEt.cET, this.cFz));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(d.g.timepicker);
        linearLayout.setBackgroundColor(this.cEt.cFb);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.cFL = new c(linearLayout, this.cEt.cEB, this.cEt.cEU, this.cEt.cFf);
        if (this.cEt.cEv != null) {
            this.cFL.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void ats() {
                    try {
                        b.this.cEt.cEv.p(c.cFN.parse(b.this.cFL.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.cFL.fy(this.cEt.cEG);
        if (this.cEt.startYear != 0 && this.cEt.endYear != 0 && this.cEt.startYear <= this.cEt.endYear) {
            atx();
        }
        if (this.cEt.cED != null && this.cEt.cEE != null) {
            if (this.cEt.cED.getTimeInMillis() > this.cEt.cEE.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aty();
        } else if (this.cEt.cED != null) {
            if (this.cEt.cED.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aty();
        } else if (this.cEt.cEE != null) {
            if (this.cEt.cEE.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aty();
        } else {
            aty();
        }
        atA();
        this.cFL.c(this.cEt.cEH, this.cEt.cEI, this.cEt.cEJ, this.cEt.cEK, this.cEt.cEL, this.cEt.cEM);
        this.cFL.h(this.cEt.cEN, this.cEt.cEO, this.cEt.cEP, this.cEt.cEQ, this.cEt.cER, this.cEt.cES);
        fx(this.cEt.cFl);
        this.cFL.setCyclic(this.cEt.cEF);
        this.cFL.setDividerColor(this.cEt.cFi);
        this.cFL.setDividerType(this.cEt.cFo);
        this.cFL.setLineSpacingMultiplier(this.cEt.cFj);
        this.cFL.setTextColorOut(this.cEt.cFg);
        this.cFL.setTextColorCenter(this.cEt.cFh);
        this.cFL.fz(this.cEt.cFm);
    }

    private void atx() {
        this.cFL.setStartYear(this.cEt.startYear);
        this.cFL.lb(this.cEt.endYear);
    }

    private void aty() {
        this.cFL.a(this.cEt.cED, this.cEt.cEE);
        atz();
    }

    private void atz() {
        if (this.cEt.cED != null && this.cEt.cEE != null) {
            if (this.cEt.cEC == null || this.cEt.cEC.getTimeInMillis() < this.cEt.cED.getTimeInMillis() || this.cEt.cEC.getTimeInMillis() > this.cEt.cEE.getTimeInMillis()) {
                this.cEt.cEC = this.cEt.cED;
            }
        } else if (this.cEt.cED != null) {
            this.cEt.cEC = this.cEt.cED;
        } else if (this.cEt.cEE != null) {
            this.cEt.cEC = this.cEt.cEE;
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
        if (this.cEt.cEC == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.cEt.cEC.get(1);
            i2 = this.cEt.cEC.get(2);
            i3 = this.cEt.cEC.get(5);
            i4 = this.cEt.cEC.get(11);
            i5 = this.cEt.cEC.get(12);
            i6 = this.cEt.cEC.get(13);
        }
        this.cFL.f(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            atB();
        }
        dismiss();
    }

    public void atB() {
        if (this.cEt.cEu != null) {
            try {
                this.cEt.cEu.a(c.cFN.parse(this.cFL.getTime()), this.cFG);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean atw() {
        return this.cEt.cFk;
    }
}
