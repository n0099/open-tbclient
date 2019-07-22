package com.baidu.tbadk.widget.timepicker.a.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class b extends a implements View.OnClickListener {
    private c cPr;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.cNX = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        azO();
        initViews();
        initAnim();
        if (this.cNX.cOa == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.cPf);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.cNX.cOB) ? context.getResources().getString(R.string.pickerview_submit) : this.cNX.cOB);
            button2.setText(TextUtils.isEmpty(this.cNX.cOC) ? context.getResources().getString(R.string.pickerview_cancel) : this.cNX.cOC);
            textView.setText(TextUtils.isEmpty(this.cNX.cOD) ? "" : this.cNX.cOD);
            button.setTextColor(this.cNX.cOE);
            button2.setTextColor(this.cNX.cOF);
            textView.setTextColor(this.cNX.cOG);
            relativeLayout.setBackgroundColor(this.cNX.cOI);
            button.setTextSize(this.cNX.cOJ);
            button2.setTextSize(this.cNX.cOJ);
            textView.setTextSize(this.cNX.cOK);
        } else {
            this.cNX.cOa.bb(LayoutInflater.from(context).inflate(this.cNX.cOz, this.cPf));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.cNX.cOH);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.cPr = new c(linearLayout, this.cNX.cOf, this.cNX.cOA, this.cNX.cOL);
        if (this.cNX.cNZ != null) {
            this.cPr.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void azK() {
                    try {
                        b.this.cNX.cNZ.p(c.cPt.parse(b.this.cPr.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.cPr.fZ(this.cNX.cOm);
        if (this.cNX.cOj != 0 && this.cNX.cOk != 0 && this.cNX.cOj <= this.cNX.cOk) {
            azR();
        }
        if (this.cNX.cOh != null && this.cNX.cOi != null) {
            if (this.cNX.cOh.getTimeInMillis() > this.cNX.cOi.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            azS();
        } else if (this.cNX.cOh != null) {
            if (this.cNX.cOh.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            azS();
        } else if (this.cNX.cOi != null) {
            if (this.cNX.cOi.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            azS();
        } else {
            azS();
        }
        azU();
        this.cPr.c(this.cNX.cOn, this.cNX.cOo, this.cNX.cOp, this.cNX.cOq, this.cNX.cOr, this.cNX.cOs);
        this.cPr.i(this.cNX.cOt, this.cNX.cOu, this.cNX.cOv, this.cNX.cOw, this.cNX.cOx, this.cNX.cOy);
        fY(this.cNX.cOR);
        this.cPr.setCyclic(this.cNX.cOl);
        this.cPr.setDividerColor(this.cNX.cOO);
        this.cPr.setDividerType(this.cNX.cOU);
        this.cPr.setLineSpacingMultiplier(this.cNX.cOP);
        this.cPr.setTextColorOut(this.cNX.cOM);
        this.cPr.setTextColorCenter(this.cNX.cON);
        this.cPr.ga(this.cNX.cOS);
    }

    private void azR() {
        this.cPr.lW(this.cNX.cOj);
        this.cPr.lX(this.cNX.cOk);
    }

    private void azS() {
        this.cPr.a(this.cNX.cOh, this.cNX.cOi);
        azT();
    }

    private void azT() {
        if (this.cNX.cOh != null && this.cNX.cOi != null) {
            if (this.cNX.cOg == null || this.cNX.cOg.getTimeInMillis() < this.cNX.cOh.getTimeInMillis() || this.cNX.cOg.getTimeInMillis() > this.cNX.cOi.getTimeInMillis()) {
                this.cNX.cOg = this.cNX.cOh;
            }
        } else if (this.cNX.cOh != null) {
            this.cNX.cOg = this.cNX.cOh;
        } else if (this.cNX.cOi != null) {
            this.cNX.cOg = this.cNX.cOi;
        }
    }

    private void azU() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.cNX.cOg == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.cNX.cOg.get(1);
            i2 = this.cNX.cOg.get(2);
            i3 = this.cNX.cOg.get(5);
            i4 = this.cNX.cOg.get(11);
            i5 = this.cNX.cOg.get(12);
            i6 = this.cNX.cOg.get(13);
        }
        this.cPr.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            azV();
        }
        dismiss();
    }

    public void azV() {
        if (this.cNX.cNY != null) {
            try {
                this.cNX.cNY.a(c.cPt.parse(this.cPr.getTime()), this.cPm);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean azQ() {
        return this.cNX.cOQ;
    }
}
