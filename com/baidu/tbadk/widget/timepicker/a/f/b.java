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
/* loaded from: classes21.dex */
public class b extends a implements View.OnClickListener {
    private c fLL;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.fKz = aVar;
        dQ(aVar.context);
    }

    private void dQ(Context context) {
        bGN();
        initViews();
        JW();
        if (this.fKz.fKC == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.fLC);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.fKz.fLd) ? context.getResources().getString(R.string.pickerview_submit) : this.fKz.fLd);
            button2.setText(TextUtils.isEmpty(this.fKz.fLe) ? context.getResources().getString(R.string.pickerview_cancel) : this.fKz.fLe);
            textView.setText(TextUtils.isEmpty(this.fKz.fLf) ? "" : this.fKz.fLf);
            button.setTextColor(this.fKz.fLg);
            button2.setTextColor(this.fKz.fLh);
            textView.setTextColor(this.fKz.fLi);
            relativeLayout.setBackgroundColor(this.fKz.fLk);
            button.setTextSize(this.fKz.fLl);
            button2.setTextSize(this.fKz.fLl);
            textView.setTextSize(this.fKz.fLm);
        } else {
            this.fKz.fKC.bx(LayoutInflater.from(context).inflate(this.fKz.fLb, this.fLC));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.fKz.fLj);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.fLL = new c(linearLayout, this.fKz.fKH, this.fKz.fLc, this.fKz.fLn);
        if (this.fKz.fKB != null) {
            this.fLL.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bGM() {
                    try {
                        b.this.fKz.fKB.q(c.dateFormat.parse(b.this.fLL.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.fLL.la(this.fKz.fKO);
        if (this.fKz.fKL != 0 && this.fKz.fKM != 0 && this.fKz.fKL <= this.fKz.fKM) {
            bGP();
        }
        if (this.fKz.fKJ != null && this.fKz.fKK != null) {
            if (this.fKz.fKJ.getTimeInMillis() > this.fKz.fKK.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bGQ();
        } else if (this.fKz.fKJ != null) {
            if (this.fKz.fKJ.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bGQ();
        } else if (this.fKz.fKK != null) {
            if (this.fKz.fKK.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bGQ();
        } else {
            bGQ();
        }
        bGS();
        this.fLL.d(this.fKz.fKP, this.fKz.fKQ, this.fKz.fKR, this.fKz.fKS, this.fKz.fKT, this.fKz.fKU);
        this.fLL.i(this.fKz.fKV, this.fKz.fKW, this.fKz.fKX, this.fKz.fKY, this.fKz.fKZ, this.fKz.fLa);
        kZ(this.fKz.fLp);
        this.fLL.setCyclic(this.fKz.fKN);
        this.fLL.setDividerColor(this.fKz.dividerColor);
        this.fLL.setDividerType(this.fKz.fLr);
        this.fLL.setLineSpacingMultiplier(this.fKz.lineSpacingMultiplier);
        this.fLL.setTextColorOut(this.fKz.textColorOut);
        this.fLL.setTextColorCenter(this.fKz.textColorCenter);
        this.fLL.isCenterLabel(this.fKz.isCenterLabel);
    }

    private void bGP() {
        this.fLL.sT(this.fKz.fKL);
        this.fLL.sU(this.fKz.fKM);
    }

    private void bGQ() {
        this.fLL.a(this.fKz.fKJ, this.fKz.fKK);
        bGR();
    }

    private void bGR() {
        if (this.fKz.fKJ != null && this.fKz.fKK != null) {
            if (this.fKz.fKI == null || this.fKz.fKI.getTimeInMillis() < this.fKz.fKJ.getTimeInMillis() || this.fKz.fKI.getTimeInMillis() > this.fKz.fKK.getTimeInMillis()) {
                this.fKz.fKI = this.fKz.fKJ;
            }
        } else if (this.fKz.fKJ != null) {
            this.fKz.fKI = this.fKz.fKJ;
        } else if (this.fKz.fKK != null) {
            this.fKz.fKI = this.fKz.fKK;
        }
    }

    private void bGS() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.fKz.fKI == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.fKz.fKI.get(1);
            i2 = this.fKz.fKI.get(2);
            i3 = this.fKz.fKI.get(5);
            i4 = this.fKz.fKI.get(11);
            i5 = this.fKz.fKI.get(12);
            i6 = this.fKz.fKI.get(13);
        }
        this.fLL.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bGT();
        }
        dismiss();
    }

    public void bGT() {
        if (this.fKz.fKA != null) {
            try {
                this.fKz.fKA.a(c.dateFormat.parse(this.fLL.getTime()), this.fLH);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bGO() {
        return this.fKz.fLo;
    }
}
