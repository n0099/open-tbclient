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
/* loaded from: classes20.dex */
public class b extends a implements View.OnClickListener {
    private c fLo;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.fKc = aVar;
        dQ(aVar.context);
    }

    private void dQ(Context context) {
        bGg();
        initViews();
        Jn();
        if (this.fKc.fKf == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.fLf);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.fKc.fKG) ? context.getResources().getString(R.string.pickerview_submit) : this.fKc.fKG);
            button2.setText(TextUtils.isEmpty(this.fKc.fKH) ? context.getResources().getString(R.string.pickerview_cancel) : this.fKc.fKH);
            textView.setText(TextUtils.isEmpty(this.fKc.fKI) ? "" : this.fKc.fKI);
            button.setTextColor(this.fKc.fKJ);
            button2.setTextColor(this.fKc.fKK);
            textView.setTextColor(this.fKc.fKL);
            relativeLayout.setBackgroundColor(this.fKc.fKN);
            button.setTextSize(this.fKc.fKO);
            button2.setTextSize(this.fKc.fKO);
            textView.setTextSize(this.fKc.fKP);
        } else {
            this.fKc.fKf.bA(LayoutInflater.from(context).inflate(this.fKc.fKE, this.fLf));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.fKc.fKM);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.fLo = new c(linearLayout, this.fKc.fKk, this.fKc.fKF, this.fKc.fKQ);
        if (this.fKc.fKe != null) {
            this.fLo.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bGf() {
                    try {
                        b.this.fKc.fKe.q(c.dateFormat.parse(b.this.fLo.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.fLo.lb(this.fKc.fKr);
        if (this.fKc.fKo != 0 && this.fKc.fKp != 0 && this.fKc.fKo <= this.fKc.fKp) {
            bGi();
        }
        if (this.fKc.fKm != null && this.fKc.fKn != null) {
            if (this.fKc.fKm.getTimeInMillis() > this.fKc.fKn.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bGj();
        } else if (this.fKc.fKm != null) {
            if (this.fKc.fKm.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bGj();
        } else if (this.fKc.fKn != null) {
            if (this.fKc.fKn.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bGj();
        } else {
            bGj();
        }
        bGl();
        this.fLo.d(this.fKc.fKs, this.fKc.fKt, this.fKc.fKu, this.fKc.fKv, this.fKc.fKw, this.fKc.fKx);
        this.fLo.i(this.fKc.fKy, this.fKc.fKz, this.fKc.fKA, this.fKc.fKB, this.fKc.fKC, this.fKc.fKD);
        la(this.fKc.fKS);
        this.fLo.setCyclic(this.fKc.fKq);
        this.fLo.setDividerColor(this.fKc.dividerColor);
        this.fLo.setDividerType(this.fKc.fKU);
        this.fLo.setLineSpacingMultiplier(this.fKc.lineSpacingMultiplier);
        this.fLo.setTextColorOut(this.fKc.textColorOut);
        this.fLo.setTextColorCenter(this.fKc.textColorCenter);
        this.fLo.isCenterLabel(this.fKc.isCenterLabel);
    }

    private void bGi() {
        this.fLo.tr(this.fKc.fKo);
        this.fLo.ts(this.fKc.fKp);
    }

    private void bGj() {
        this.fLo.a(this.fKc.fKm, this.fKc.fKn);
        bGk();
    }

    private void bGk() {
        if (this.fKc.fKm != null && this.fKc.fKn != null) {
            if (this.fKc.fKl == null || this.fKc.fKl.getTimeInMillis() < this.fKc.fKm.getTimeInMillis() || this.fKc.fKl.getTimeInMillis() > this.fKc.fKn.getTimeInMillis()) {
                this.fKc.fKl = this.fKc.fKm;
            }
        } else if (this.fKc.fKm != null) {
            this.fKc.fKl = this.fKc.fKm;
        } else if (this.fKc.fKn != null) {
            this.fKc.fKl = this.fKc.fKn;
        }
    }

    private void bGl() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.fKc.fKl == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.fKc.fKl.get(1);
            i2 = this.fKc.fKl.get(2);
            i3 = this.fKc.fKl.get(5);
            i4 = this.fKc.fKl.get(11);
            i5 = this.fKc.fKl.get(12);
            i6 = this.fKc.fKl.get(13);
        }
        this.fLo.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bGm();
        }
        dismiss();
    }

    public void bGm() {
        if (this.fKc.fKd != null) {
            try {
                this.fKc.fKd.a(c.dateFormat.parse(this.fLo.getTime()), this.fLk);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bGh() {
        return this.fKc.fKR;
    }
}
