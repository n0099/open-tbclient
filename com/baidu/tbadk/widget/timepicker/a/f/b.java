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
    private c cNV;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.cMD = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        ayA();
        initViews();
        initAnim();
        if (this.cMD.cMG == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.cNJ);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.cMD.cNf) ? context.getResources().getString(R.string.pickerview_submit) : this.cMD.cNf);
            button2.setText(TextUtils.isEmpty(this.cMD.cNg) ? context.getResources().getString(R.string.pickerview_cancel) : this.cMD.cNg);
            textView.setText(TextUtils.isEmpty(this.cMD.cNh) ? "" : this.cMD.cNh);
            button.setTextColor(this.cMD.cNi);
            button2.setTextColor(this.cMD.cNj);
            textView.setTextColor(this.cMD.cNk);
            relativeLayout.setBackgroundColor(this.cMD.cNm);
            button.setTextSize(this.cMD.cNn);
            button2.setTextSize(this.cMD.cNn);
            textView.setTextSize(this.cMD.cNo);
        } else {
            this.cMD.cMG.aZ(LayoutInflater.from(context).inflate(this.cMD.cNd, this.cNJ));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.cMD.cNl);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.cNV = new c(linearLayout, this.cMD.cML, this.cMD.cNe, this.cMD.cNp);
        if (this.cMD.cMF != null) {
            this.cNV.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void ayy() {
                    try {
                        b.this.cMD.cMF.p(c.cNX.parse(b.this.cNV.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.cNV.fV(this.cMD.cMQ);
        if (this.cMD.startYear != 0 && this.cMD.endYear != 0 && this.cMD.startYear <= this.cMD.endYear) {
            ayD();
        }
        if (this.cMD.cMN != null && this.cMD.cMO != null) {
            if (this.cMD.cMN.getTimeInMillis() > this.cMD.cMO.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            ayE();
        } else if (this.cMD.cMN != null) {
            if (this.cMD.cMN.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            ayE();
        } else if (this.cMD.cMO != null) {
            if (this.cMD.cMO.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            ayE();
        } else {
            ayE();
        }
        ayG();
        this.cNV.c(this.cMD.cMR, this.cMD.cMS, this.cMD.cMT, this.cMD.cMU, this.cMD.cMV, this.cMD.cMW);
        this.cNV.h(this.cMD.cMX, this.cMD.cMY, this.cMD.cMZ, this.cMD.cNa, this.cMD.cNb, this.cMD.cNc);
        fU(this.cMD.cNv);
        this.cNV.setCyclic(this.cMD.cMP);
        this.cNV.setDividerColor(this.cMD.cNs);
        this.cNV.setDividerType(this.cMD.cNy);
        this.cNV.setLineSpacingMultiplier(this.cMD.cNt);
        this.cNV.setTextColorOut(this.cMD.cNq);
        this.cNV.setTextColorCenter(this.cMD.cNr);
        this.cNV.fW(this.cMD.cNw);
    }

    private void ayD() {
        this.cNV.setStartYear(this.cMD.startYear);
        this.cNV.lQ(this.cMD.endYear);
    }

    private void ayE() {
        this.cNV.a(this.cMD.cMN, this.cMD.cMO);
        ayF();
    }

    private void ayF() {
        if (this.cMD.cMN != null && this.cMD.cMO != null) {
            if (this.cMD.cMM == null || this.cMD.cMM.getTimeInMillis() < this.cMD.cMN.getTimeInMillis() || this.cMD.cMM.getTimeInMillis() > this.cMD.cMO.getTimeInMillis()) {
                this.cMD.cMM = this.cMD.cMN;
            }
        } else if (this.cMD.cMN != null) {
            this.cMD.cMM = this.cMD.cMN;
        } else if (this.cMD.cMO != null) {
            this.cMD.cMM = this.cMD.cMO;
        }
    }

    private void ayG() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.cMD.cMM == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.cMD.cMM.get(1);
            i2 = this.cMD.cMM.get(2);
            i3 = this.cMD.cMM.get(5);
            i4 = this.cMD.cMM.get(11);
            i5 = this.cMD.cMM.get(12);
            i6 = this.cMD.cMM.get(13);
        }
        this.cNV.f(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            ayH();
        }
        dismiss();
    }

    public void ayH() {
        if (this.cMD.cME != null) {
            try {
                this.cMD.cME.a(c.cNX.parse(this.cNV.getTime()), this.cNQ);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean ayC() {
        return this.cMD.cNu;
    }
}
