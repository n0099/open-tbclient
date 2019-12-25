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
/* loaded from: classes5.dex */
public class b extends a implements View.OnClickListener {
    private c dNr;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.dMf = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        aSg();
        initViews();
        tz();
        if (this.dMf.dMi == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.dNi);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(UgcUBCUtils.UGC_TIME_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.dMf.dMJ) ? context.getResources().getString(R.string.pickerview_submit) : this.dMf.dMJ);
            button2.setText(TextUtils.isEmpty(this.dMf.dMK) ? context.getResources().getString(R.string.pickerview_cancel) : this.dMf.dMK);
            textView.setText(TextUtils.isEmpty(this.dMf.dML) ? "" : this.dMf.dML);
            button.setTextColor(this.dMf.dMM);
            button2.setTextColor(this.dMf.dMN);
            textView.setTextColor(this.dMf.dMO);
            relativeLayout.setBackgroundColor(this.dMf.dMQ);
            button.setTextSize(this.dMf.dMR);
            button2.setTextSize(this.dMf.dMR);
            textView.setTextSize(this.dMf.dMS);
        } else {
            this.dMf.dMi.aY(LayoutInflater.from(context).inflate(this.dMf.dMH, this.dNi));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.dMf.dMP);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.dNr = new c(linearLayout, this.dMf.dMn, this.dMf.dMI, this.dMf.dMT);
        if (this.dMf.dMh != null) {
            this.dNr.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void aSf() {
                    try {
                        b.this.dMf.dMh.m(c.dNt.parse(b.this.dNr.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.dNr.hg(this.dMf.dMu);
        if (this.dMf.dMr != 0 && this.dMf.dMs != 0 && this.dMf.dMr <= this.dMf.dMs) {
            aSi();
        }
        if (this.dMf.dMp != null && this.dMf.dMq != null) {
            if (this.dMf.dMp.getTimeInMillis() > this.dMf.dMq.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aSj();
        } else if (this.dMf.dMp != null) {
            if (this.dMf.dMp.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aSj();
        } else if (this.dMf.dMq != null) {
            if (this.dMf.dMq.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aSj();
        } else {
            aSj();
        }
        aSl();
        this.dNr.c(this.dMf.dMv, this.dMf.dMw, this.dMf.dMx, this.dMf.dMy, this.dMf.dMz, this.dMf.dMA);
        this.dNr.j(this.dMf.dMB, this.dMf.dMC, this.dMf.dMD, this.dMf.dME, this.dMf.dMF, this.dMf.dMG);
        hf(this.dMf.dMV);
        this.dNr.setCyclic(this.dMf.dMt);
        this.dNr.setDividerColor(this.dMf.dividerColor);
        this.dNr.setDividerType(this.dMf.dMX);
        this.dNr.setLineSpacingMultiplier(this.dMf.lineSpacingMultiplier);
        this.dNr.setTextColorOut(this.dMf.textColorOut);
        this.dNr.setTextColorCenter(this.dMf.textColorCenter);
        this.dNr.isCenterLabel(this.dMf.isCenterLabel);
    }

    private void aSi() {
        this.dNr.nv(this.dMf.dMr);
        this.dNr.nw(this.dMf.dMs);
    }

    private void aSj() {
        this.dNr.a(this.dMf.dMp, this.dMf.dMq);
        aSk();
    }

    private void aSk() {
        if (this.dMf.dMp != null && this.dMf.dMq != null) {
            if (this.dMf.dMo == null || this.dMf.dMo.getTimeInMillis() < this.dMf.dMp.getTimeInMillis() || this.dMf.dMo.getTimeInMillis() > this.dMf.dMq.getTimeInMillis()) {
                this.dMf.dMo = this.dMf.dMp;
            }
        } else if (this.dMf.dMp != null) {
            this.dMf.dMo = this.dMf.dMp;
        } else if (this.dMf.dMq != null) {
            this.dMf.dMo = this.dMf.dMq;
        }
    }

    private void aSl() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.dMf.dMo == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.dMf.dMo.get(1);
            i2 = this.dMf.dMo.get(2);
            i3 = this.dMf.dMo.get(5);
            i4 = this.dMf.dMo.get(11);
            i5 = this.dMf.dMo.get(12);
            i6 = this.dMf.dMo.get(13);
        }
        this.dNr.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            aSm();
        }
        dismiss();
    }

    public void aSm() {
        if (this.dMf.dMg != null) {
            try {
                this.dMf.dMg.a(c.dNt.parse(this.dNr.getTime()), this.dNn);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean aSh() {
        return this.dMf.dMU;
    }
}
