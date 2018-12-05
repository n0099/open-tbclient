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
    private c btI;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.bsp = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        Ta();
        initViews();
        initAnim();
        if (this.bsp.bss == null) {
            LayoutInflater.from(context).inflate(e.h.pickerview_time, this.btw);
            TextView textView = (TextView) findViewById(e.g.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.rv_topbar);
            Button button = (Button) findViewById(e.g.btnSubmit);
            Button button2 = (Button) findViewById(e.g.btnCancel);
            button.setTag("submit");
            button2.setTag(AiAppsUBCStatistic.VALUE_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.bsp.bsR) ? context.getResources().getString(e.j.pickerview_submit) : this.bsp.bsR);
            button2.setText(TextUtils.isEmpty(this.bsp.bsS) ? context.getResources().getString(e.j.pickerview_cancel) : this.bsp.bsS);
            textView.setText(TextUtils.isEmpty(this.bsp.bsT) ? "" : this.bsp.bsT);
            button.setTextColor(this.bsp.bsU);
            button2.setTextColor(this.bsp.bsV);
            textView.setTextColor(this.bsp.bsW);
            relativeLayout.setBackgroundColor(this.bsp.bsY);
            button.setTextSize(this.bsp.bsZ);
            button2.setTextSize(this.bsp.bsZ);
            textView.setTextSize(this.bsp.bta);
        } else {
            this.bsp.bss.Z(LayoutInflater.from(context).inflate(this.bsp.bsP, this.btw));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(e.g.timepicker);
        linearLayout.setBackgroundColor(this.bsp.bsX);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.btI = new c(linearLayout, this.bsp.bsx, this.bsp.bsQ, this.bsp.btb);
        if (this.bsp.bsr != null) {
            this.btI.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void SY() {
                    try {
                        b.this.bsp.bsr.j(c.btK.parse(b.this.btI.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.btI.df(this.bsp.bsC);
        if (this.bsp.startYear != 0 && this.bsp.endYear != 0 && this.bsp.startYear <= this.bsp.endYear) {
            Td();
        }
        if (this.bsp.bsz != null && this.bsp.bsA != null) {
            if (this.bsp.bsz.getTimeInMillis() > this.bsp.bsA.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            Te();
        } else if (this.bsp.bsz != null) {
            if (this.bsp.bsz.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            Te();
        } else if (this.bsp.bsA != null) {
            if (this.bsp.bsA.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            Te();
        } else {
            Te();
        }
        Tg();
        this.btI.c(this.bsp.bsD, this.bsp.bsE, this.bsp.bsF, this.bsp.bsG, this.bsp.bsH, this.bsp.bsI);
        this.btI.h(this.bsp.bsJ, this.bsp.bsK, this.bsp.bsL, this.bsp.bsM, this.bsp.bsN, this.bsp.bsO);
        de(this.bsp.bth);
        this.btI.setCyclic(this.bsp.bsB);
        this.btI.setDividerColor(this.bsp.bte);
        this.btI.setDividerType(this.bsp.btk);
        this.btI.setLineSpacingMultiplier(this.bsp.btf);
        this.btI.setTextColorOut(this.bsp.btc);
        this.btI.setTextColorCenter(this.bsp.btd);
        this.btI.dg(this.bsp.bti);
    }

    private void Td() {
        this.btI.setStartYear(this.bsp.startYear);
        this.btI.hl(this.bsp.endYear);
    }

    private void Te() {
        this.btI.a(this.bsp.bsz, this.bsp.bsA);
        Tf();
    }

    private void Tf() {
        if (this.bsp.bsz != null && this.bsp.bsA != null) {
            if (this.bsp.bsy == null || this.bsp.bsy.getTimeInMillis() < this.bsp.bsz.getTimeInMillis() || this.bsp.bsy.getTimeInMillis() > this.bsp.bsA.getTimeInMillis()) {
                this.bsp.bsy = this.bsp.bsz;
            }
        } else if (this.bsp.bsz != null) {
            this.bsp.bsy = this.bsp.bsz;
        } else if (this.bsp.bsA != null) {
            this.bsp.bsy = this.bsp.bsA;
        }
    }

    private void Tg() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.bsp.bsy == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.bsp.bsy.get(1);
            i2 = this.bsp.bsy.get(2);
            i3 = this.bsp.bsy.get(5);
            i4 = this.bsp.bsy.get(11);
            i5 = this.bsp.bsy.get(12);
            i6 = this.bsp.bsy.get(13);
        }
        this.btI.f(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            Th();
        }
        dismiss();
    }

    public void Th() {
        if (this.bsp.bsq != null) {
            try {
                this.bsp.bsq.a(c.btK.parse(this.btI.getTime()), this.btD);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean Tc() {
        return this.bsp.btg;
    }
}
