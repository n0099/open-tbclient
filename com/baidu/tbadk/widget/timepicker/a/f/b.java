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
    private c cFI;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.cEq = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        atx();
        initViews();
        initAnim();
        if (this.cEq.cEt == null) {
            LayoutInflater.from(context).inflate(d.h.pickerview_time, this.cFw);
            TextView textView = (TextView) findViewById(d.g.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(d.g.rv_topbar);
            Button button = (Button) findViewById(d.g.btnSubmit);
            Button button2 = (Button) findViewById(d.g.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.cEq.cES) ? context.getResources().getString(d.j.pickerview_submit) : this.cEq.cES);
            button2.setText(TextUtils.isEmpty(this.cEq.cET) ? context.getResources().getString(d.j.pickerview_cancel) : this.cEq.cET);
            textView.setText(TextUtils.isEmpty(this.cEq.cEU) ? "" : this.cEq.cEU);
            button.setTextColor(this.cEq.cEV);
            button2.setTextColor(this.cEq.cEW);
            textView.setTextColor(this.cEq.cEX);
            relativeLayout.setBackgroundColor(this.cEq.cEZ);
            button.setTextSize(this.cEq.cFa);
            button2.setTextSize(this.cEq.cFa);
            textView.setTextSize(this.cEq.cFb);
        } else {
            this.cEq.cEt.aT(LayoutInflater.from(context).inflate(this.cEq.cEQ, this.cFw));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(d.g.timepicker);
        linearLayout.setBackgroundColor(this.cEq.cEY);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.cFI = new c(linearLayout, this.cEq.cEy, this.cEq.cER, this.cEq.cFc);
        if (this.cEq.cEs != null) {
            this.cFI.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void atv() {
                    try {
                        b.this.cEq.cEs.p(c.cFK.parse(b.this.cFI.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.cFI.fy(this.cEq.cED);
        if (this.cEq.startYear != 0 && this.cEq.endYear != 0 && this.cEq.startYear <= this.cEq.endYear) {
            atA();
        }
        if (this.cEq.cEA != null && this.cEq.cEB != null) {
            if (this.cEq.cEA.getTimeInMillis() > this.cEq.cEB.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            atB();
        } else if (this.cEq.cEA != null) {
            if (this.cEq.cEA.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            atB();
        } else if (this.cEq.cEB != null) {
            if (this.cEq.cEB.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            atB();
        } else {
            atB();
        }
        atD();
        this.cFI.c(this.cEq.cEE, this.cEq.cEF, this.cEq.cEG, this.cEq.cEH, this.cEq.cEI, this.cEq.cEJ);
        this.cFI.h(this.cEq.cEK, this.cEq.cEL, this.cEq.cEM, this.cEq.cEN, this.cEq.cEO, this.cEq.cEP);
        fx(this.cEq.cFi);
        this.cFI.setCyclic(this.cEq.cEC);
        this.cFI.setDividerColor(this.cEq.cFf);
        this.cFI.setDividerType(this.cEq.cFl);
        this.cFI.setLineSpacingMultiplier(this.cEq.cFg);
        this.cFI.setTextColorOut(this.cEq.cFd);
        this.cFI.setTextColorCenter(this.cEq.cFe);
        this.cFI.fz(this.cEq.cFj);
    }

    private void atA() {
        this.cFI.setStartYear(this.cEq.startYear);
        this.cFI.lc(this.cEq.endYear);
    }

    private void atB() {
        this.cFI.a(this.cEq.cEA, this.cEq.cEB);
        atC();
    }

    private void atC() {
        if (this.cEq.cEA != null && this.cEq.cEB != null) {
            if (this.cEq.cEz == null || this.cEq.cEz.getTimeInMillis() < this.cEq.cEA.getTimeInMillis() || this.cEq.cEz.getTimeInMillis() > this.cEq.cEB.getTimeInMillis()) {
                this.cEq.cEz = this.cEq.cEA;
            }
        } else if (this.cEq.cEA != null) {
            this.cEq.cEz = this.cEq.cEA;
        } else if (this.cEq.cEB != null) {
            this.cEq.cEz = this.cEq.cEB;
        }
    }

    private void atD() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.cEq.cEz == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.cEq.cEz.get(1);
            i2 = this.cEq.cEz.get(2);
            i3 = this.cEq.cEz.get(5);
            i4 = this.cEq.cEz.get(11);
            i5 = this.cEq.cEz.get(12);
            i6 = this.cEq.cEz.get(13);
        }
        this.cFI.f(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            atE();
        }
        dismiss();
    }

    public void atE() {
        if (this.cEq.cEr != null) {
            try {
                this.cEq.cEr.a(c.cFK.parse(this.cFI.getTime()), this.cFD);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean atz() {
        return this.cEq.cFh;
    }
}
