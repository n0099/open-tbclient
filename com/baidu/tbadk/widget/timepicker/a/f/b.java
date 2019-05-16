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
    private c cNU;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.cMC = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        ayz();
        initViews();
        initAnim();
        if (this.cMC.cMF == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.cNI);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.cMC.cNe) ? context.getResources().getString(R.string.pickerview_submit) : this.cMC.cNe);
            button2.setText(TextUtils.isEmpty(this.cMC.cNf) ? context.getResources().getString(R.string.pickerview_cancel) : this.cMC.cNf);
            textView.setText(TextUtils.isEmpty(this.cMC.cNg) ? "" : this.cMC.cNg);
            button.setTextColor(this.cMC.cNh);
            button2.setTextColor(this.cMC.cNi);
            textView.setTextColor(this.cMC.cNj);
            relativeLayout.setBackgroundColor(this.cMC.cNl);
            button.setTextSize(this.cMC.cNm);
            button2.setTextSize(this.cMC.cNm);
            textView.setTextSize(this.cMC.cNn);
        } else {
            this.cMC.cMF.aZ(LayoutInflater.from(context).inflate(this.cMC.cNc, this.cNI));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.cMC.cNk);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.cNU = new c(linearLayout, this.cMC.cMK, this.cMC.cNd, this.cMC.cNo);
        if (this.cMC.cME != null) {
            this.cNU.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void ayx() {
                    try {
                        b.this.cMC.cME.p(c.cNW.parse(b.this.cNU.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.cNU.fV(this.cMC.cMP);
        if (this.cMC.startYear != 0 && this.cMC.endYear != 0 && this.cMC.startYear <= this.cMC.endYear) {
            ayC();
        }
        if (this.cMC.cMM != null && this.cMC.cMN != null) {
            if (this.cMC.cMM.getTimeInMillis() > this.cMC.cMN.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            ayD();
        } else if (this.cMC.cMM != null) {
            if (this.cMC.cMM.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            ayD();
        } else if (this.cMC.cMN != null) {
            if (this.cMC.cMN.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            ayD();
        } else {
            ayD();
        }
        ayF();
        this.cNU.c(this.cMC.cMQ, this.cMC.cMR, this.cMC.cMS, this.cMC.cMT, this.cMC.cMU, this.cMC.cMV);
        this.cNU.h(this.cMC.cMW, this.cMC.cMX, this.cMC.cMY, this.cMC.cMZ, this.cMC.cNa, this.cMC.cNb);
        fU(this.cMC.cNu);
        this.cNU.setCyclic(this.cMC.cMO);
        this.cNU.setDividerColor(this.cMC.cNr);
        this.cNU.setDividerType(this.cMC.cNx);
        this.cNU.setLineSpacingMultiplier(this.cMC.cNs);
        this.cNU.setTextColorOut(this.cMC.cNp);
        this.cNU.setTextColorCenter(this.cMC.cNq);
        this.cNU.fW(this.cMC.cNv);
    }

    private void ayC() {
        this.cNU.setStartYear(this.cMC.startYear);
        this.cNU.lQ(this.cMC.endYear);
    }

    private void ayD() {
        this.cNU.a(this.cMC.cMM, this.cMC.cMN);
        ayE();
    }

    private void ayE() {
        if (this.cMC.cMM != null && this.cMC.cMN != null) {
            if (this.cMC.cML == null || this.cMC.cML.getTimeInMillis() < this.cMC.cMM.getTimeInMillis() || this.cMC.cML.getTimeInMillis() > this.cMC.cMN.getTimeInMillis()) {
                this.cMC.cML = this.cMC.cMM;
            }
        } else if (this.cMC.cMM != null) {
            this.cMC.cML = this.cMC.cMM;
        } else if (this.cMC.cMN != null) {
            this.cMC.cML = this.cMC.cMN;
        }
    }

    private void ayF() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.cMC.cML == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.cMC.cML.get(1);
            i2 = this.cMC.cML.get(2);
            i3 = this.cMC.cML.get(5);
            i4 = this.cMC.cML.get(11);
            i5 = this.cMC.cML.get(12);
            i6 = this.cMC.cML.get(13);
        }
        this.cNU.f(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            ayG();
        }
        dismiss();
    }

    public void ayG() {
        if (this.cMC.cMD != null) {
            try {
                this.cMC.cMD.a(c.cNW.parse(this.cNU.getTime()), this.cNP);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean ayB() {
        return this.cMC.cNt;
    }
}
