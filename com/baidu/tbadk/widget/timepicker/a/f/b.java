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
    private c btL;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.bss = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        Tc();
        initViews();
        initAnim();
        if (this.bss.bsv == null) {
            LayoutInflater.from(context).inflate(e.h.pickerview_time, this.btz);
            TextView textView = (TextView) findViewById(e.g.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.rv_topbar);
            Button button = (Button) findViewById(e.g.btnSubmit);
            Button button2 = (Button) findViewById(e.g.btnCancel);
            button.setTag("submit");
            button2.setTag(AiAppsUBCStatistic.VALUE_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.bss.bsU) ? context.getResources().getString(e.j.pickerview_submit) : this.bss.bsU);
            button2.setText(TextUtils.isEmpty(this.bss.bsV) ? context.getResources().getString(e.j.pickerview_cancel) : this.bss.bsV);
            textView.setText(TextUtils.isEmpty(this.bss.bsW) ? "" : this.bss.bsW);
            button.setTextColor(this.bss.bsX);
            button2.setTextColor(this.bss.bsY);
            textView.setTextColor(this.bss.bsZ);
            relativeLayout.setBackgroundColor(this.bss.btb);
            button.setTextSize(this.bss.btc);
            button2.setTextSize(this.bss.btc);
            textView.setTextSize(this.bss.btd);
        } else {
            this.bss.bsv.Z(LayoutInflater.from(context).inflate(this.bss.bsS, this.btz));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(e.g.timepicker);
        linearLayout.setBackgroundColor(this.bss.bta);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.btL = new c(linearLayout, this.bss.bsA, this.bss.bsT, this.bss.bte);
        if (this.bss.bsu != null) {
            this.btL.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void Ta() {
                    try {
                        b.this.bss.bsu.k(c.btN.parse(b.this.btL.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.btL.df(this.bss.bsF);
        if (this.bss.startYear != 0 && this.bss.endYear != 0 && this.bss.startYear <= this.bss.endYear) {
            Tf();
        }
        if (this.bss.bsC != null && this.bss.bsD != null) {
            if (this.bss.bsC.getTimeInMillis() > this.bss.bsD.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            Tg();
        } else if (this.bss.bsC != null) {
            if (this.bss.bsC.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            Tg();
        } else if (this.bss.bsD != null) {
            if (this.bss.bsD.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            Tg();
        } else {
            Tg();
        }
        Ti();
        this.btL.c(this.bss.bsG, this.bss.bsH, this.bss.bsI, this.bss.bsJ, this.bss.bsK, this.bss.bsL);
        this.btL.h(this.bss.bsM, this.bss.bsN, this.bss.bsO, this.bss.bsP, this.bss.bsQ, this.bss.bsR);
        de(this.bss.btk);
        this.btL.setCyclic(this.bss.bsE);
        this.btL.setDividerColor(this.bss.bth);
        this.btL.setDividerType(this.bss.bto);
        this.btL.setLineSpacingMultiplier(this.bss.bti);
        this.btL.setTextColorOut(this.bss.btf);
        this.btL.setTextColorCenter(this.bss.btg);
        this.btL.dg(this.bss.btl);
    }

    private void Tf() {
        this.btL.setStartYear(this.bss.startYear);
        this.btL.hm(this.bss.endYear);
    }

    private void Tg() {
        this.btL.a(this.bss.bsC, this.bss.bsD);
        Th();
    }

    private void Th() {
        if (this.bss.bsC != null && this.bss.bsD != null) {
            if (this.bss.bsB == null || this.bss.bsB.getTimeInMillis() < this.bss.bsC.getTimeInMillis() || this.bss.bsB.getTimeInMillis() > this.bss.bsD.getTimeInMillis()) {
                this.bss.bsB = this.bss.bsC;
            }
        } else if (this.bss.bsC != null) {
            this.bss.bsB = this.bss.bsC;
        } else if (this.bss.bsD != null) {
            this.bss.bsB = this.bss.bsD;
        }
    }

    private void Ti() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.bss.bsB == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.bss.bsB.get(1);
            i2 = this.bss.bsB.get(2);
            i3 = this.bss.bsB.get(5);
            i4 = this.bss.bsB.get(11);
            i5 = this.bss.bsB.get(12);
            i6 = this.bss.bsB.get(13);
        }
        this.btL.f(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            Tj();
        }
        dismiss();
    }

    public void Tj() {
        if (this.bss.bst != null) {
            try {
                this.bss.bst.a(c.btN.parse(this.btL.getTime()), this.btG);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean Te() {
        return this.bss.btj;
    }
}
