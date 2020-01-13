package com.baidu.tbadk.widget.timepicker.a.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tieba.R;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class b extends a implements View.OnClickListener {
    private c dNz;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.dMn = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        aSA();
        initViews();
        tQ();
        if (this.dMn.dMq == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.dNq);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(UgcUBCUtils.UGC_TIME_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.dMn.dMR) ? context.getResources().getString(R.string.pickerview_submit) : this.dMn.dMR);
            button2.setText(TextUtils.isEmpty(this.dMn.dMS) ? context.getResources().getString(R.string.pickerview_cancel) : this.dMn.dMS);
            textView.setText(TextUtils.isEmpty(this.dMn.dMT) ? "" : this.dMn.dMT);
            button.setTextColor(this.dMn.dMU);
            button2.setTextColor(this.dMn.dMV);
            textView.setTextColor(this.dMn.dMW);
            relativeLayout.setBackgroundColor(this.dMn.dMY);
            button.setTextSize(this.dMn.dMZ);
            button2.setTextSize(this.dMn.dMZ);
            textView.setTextSize(this.dMn.dNa);
        } else {
            this.dMn.dMq.bc(LayoutInflater.from(context).inflate(this.dMn.dMP, this.dNq));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.dMn.dMX);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.dNz = new c(linearLayout, this.dMn.dMv, this.dMn.dMQ, this.dMn.dNb);
        if (this.dMn.dMp != null) {
            this.dNz.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void aSz() {
                    try {
                        b.this.dMn.dMp.m(c.dNB.parse(b.this.dNz.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.dNz.hl(this.dMn.dMC);
        if (this.dMn.dMz != 0 && this.dMn.dMA != 0 && this.dMn.dMz <= this.dMn.dMA) {
            aSC();
        }
        if (this.dMn.dMx != null && this.dMn.dMy != null) {
            if (this.dMn.dMx.getTimeInMillis() > this.dMn.dMy.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aSD();
        } else if (this.dMn.dMx != null) {
            if (this.dMn.dMx.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aSD();
        } else if (this.dMn.dMy != null) {
            if (this.dMn.dMy.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aSD();
        } else {
            aSD();
        }
        aSF();
        this.dNz.c(this.dMn.dMD, this.dMn.dME, this.dMn.dMF, this.dMn.dMG, this.dMn.dMH, this.dMn.dMI);
        this.dNz.j(this.dMn.dMJ, this.dMn.dMK, this.dMn.dML, this.dMn.dMM, this.dMn.dMN, this.dMn.dMO);
        hk(this.dMn.dNd);
        this.dNz.setCyclic(this.dMn.dMB);
        this.dNz.setDividerColor(this.dMn.dividerColor);
        this.dNz.setDividerType(this.dMn.dNf);
        this.dNz.setLineSpacingMultiplier(this.dMn.lineSpacingMultiplier);
        this.dNz.setTextColorOut(this.dMn.textColorOut);
        this.dNz.setTextColorCenter(this.dMn.textColorCenter);
        this.dNz.isCenterLabel(this.dMn.isCenterLabel);
    }

    private void aSC() {
        this.dNz.nv(this.dMn.dMz);
        this.dNz.nw(this.dMn.dMA);
    }

    private void aSD() {
        this.dNz.a(this.dMn.dMx, this.dMn.dMy);
        aSE();
    }

    private void aSE() {
        if (this.dMn.dMx != null && this.dMn.dMy != null) {
            if (this.dMn.dMw == null || this.dMn.dMw.getTimeInMillis() < this.dMn.dMx.getTimeInMillis() || this.dMn.dMw.getTimeInMillis() > this.dMn.dMy.getTimeInMillis()) {
                this.dMn.dMw = this.dMn.dMx;
            }
        } else if (this.dMn.dMx != null) {
            this.dMn.dMw = this.dMn.dMx;
        } else if (this.dMn.dMy != null) {
            this.dMn.dMw = this.dMn.dMy;
        }
    }

    private void aSF() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.dMn.dMw == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.dMn.dMw.get(1);
            i2 = this.dMn.dMw.get(2);
            i3 = this.dMn.dMw.get(5);
            i4 = this.dMn.dMw.get(11);
            i5 = this.dMn.dMw.get(12);
            i6 = this.dMn.dMw.get(13);
        }
        this.dNz.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            aSG();
        }
        dismiss();
    }

    public void aSG() {
        if (this.dMn.dMo != null) {
            try {
                this.dMn.dMo.a(c.dNB.parse(this.dNz.getTime()), this.dNv);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean aSB() {
        return this.dMn.dNc;
    }
}
