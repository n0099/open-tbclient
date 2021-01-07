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
/* loaded from: classes.dex */
public class b extends a implements View.OnClickListener {
    private c gcC;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.gbr = aVar;
        eO(aVar.context);
    }

    private void eO(Context context) {
        bLZ();
        initViews();
        KN();
        if (this.gbr.gbu == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.gcs);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.gbr.gbV) ? context.getResources().getString(R.string.pickerview_submit) : this.gbr.gbV);
            button2.setText(TextUtils.isEmpty(this.gbr.gbW) ? context.getResources().getString(R.string.pickerview_cancel) : this.gbr.gbW);
            textView.setText(TextUtils.isEmpty(this.gbr.gbX) ? "" : this.gbr.gbX);
            button.setTextColor(this.gbr.gbY);
            button2.setTextColor(this.gbr.gbZ);
            textView.setTextColor(this.gbr.gca);
            relativeLayout.setBackgroundColor(this.gbr.gcc);
            button.setTextSize(this.gbr.gcd);
            button2.setTextSize(this.gbr.gcd);
            textView.setTextSize(this.gbr.gce);
        } else {
            this.gbr.gbu.bM(LayoutInflater.from(context).inflate(this.gbr.gbT, this.gcs));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.gbr.gcb);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.gcC = new c(linearLayout, this.gbr.gbz, this.gbr.gbU, this.gbr.gcf);
        if (this.gbr.gbt != null) {
            this.gcC.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bLY() {
                    try {
                        b.this.gbr.gbt.q(c.dateFormat.parse(b.this.gcC.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.gcC.lR(this.gbr.gbG);
        if (this.gbr.gbD != 0 && this.gbr.gbE != 0 && this.gbr.gbD <= this.gbr.gbE) {
            bMb();
        }
        if (this.gbr.gbB != null && this.gbr.gbC != null) {
            if (this.gbr.gbB.getTimeInMillis() > this.gbr.gbC.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bMc();
        } else if (this.gbr.gbB != null) {
            if (this.gbr.gbB.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bMc();
        } else if (this.gbr.gbC != null) {
            if (this.gbr.gbC.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bMc();
        } else {
            bMc();
        }
        bMe();
        this.gcC.e(this.gbr.gbH, this.gbr.gbI, this.gbr.gbJ, this.gbr.gbK, this.gbr.gbL, this.gbr.gbM);
        this.gcC.j(this.gbr.gbN, this.gbr.gbO, this.gbr.gbP, this.gbr.gbQ, this.gbr.gbR, this.gbr.gbS);
        lQ(this.gbr.cancelable);
        this.gcC.setCyclic(this.gbr.gbF);
        this.gcC.setDividerColor(this.gbr.dCV);
        this.gcC.setDividerType(this.gbr.gch);
        this.gcC.setLineSpacingMultiplier(this.gbr.dCW);
        this.gcC.setTextColorOut(this.gbr.dCT);
        this.gcC.setTextColorCenter(this.gbr.dCU);
        this.gcC.lS(this.gbr.dCG);
    }

    private void bMb() {
        this.gcC.uf(this.gbr.gbD);
        this.gcC.ug(this.gbr.gbE);
    }

    private void bMc() {
        this.gcC.a(this.gbr.gbB, this.gbr.gbC);
        bMd();
    }

    private void bMd() {
        if (this.gbr.gbB != null && this.gbr.gbC != null) {
            if (this.gbr.gbA == null || this.gbr.gbA.getTimeInMillis() < this.gbr.gbB.getTimeInMillis() || this.gbr.gbA.getTimeInMillis() > this.gbr.gbC.getTimeInMillis()) {
                this.gbr.gbA = this.gbr.gbB;
            }
        } else if (this.gbr.gbB != null) {
            this.gbr.gbA = this.gbr.gbB;
        } else if (this.gbr.gbC != null) {
            this.gbr.gbA = this.gbr.gbC;
        }
    }

    private void bMe() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.gbr.gbA == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.gbr.gbA.get(1);
            i2 = this.gbr.gbA.get(2);
            i3 = this.gbr.gbA.get(5);
            i4 = this.gbr.gbA.get(11);
            i5 = this.gbr.gbA.get(12);
            i6 = this.gbr.gbA.get(13);
        }
        this.gcC.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bMf();
        }
        dismiss();
    }

    public void bMf() {
        if (this.gbr.gbs != null) {
            try {
                this.gbr.gbs.a(c.dateFormat.parse(this.gcC.getTime()), this.gcy);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bMa() {
        return this.gbr.gcg;
    }
}
