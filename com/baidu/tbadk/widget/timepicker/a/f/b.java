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
    private c cYP;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.cXv = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        aAj();
        initViews();
        rK();
        if (this.cXv.cXy == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.cYD);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.cXv.cXZ) ? context.getResources().getString(R.string.pickerview_submit) : this.cXv.cXZ);
            button2.setText(TextUtils.isEmpty(this.cXv.cYa) ? context.getResources().getString(R.string.pickerview_cancel) : this.cXv.cYa);
            textView.setText(TextUtils.isEmpty(this.cXv.cYb) ? "" : this.cXv.cYb);
            button.setTextColor(this.cXv.cYc);
            button2.setTextColor(this.cXv.cYd);
            textView.setTextColor(this.cXv.cYe);
            relativeLayout.setBackgroundColor(this.cXv.cYg);
            button.setTextSize(this.cXv.cYh);
            button2.setTextSize(this.cXv.cYh);
            textView.setTextSize(this.cXv.cYi);
        } else {
            this.cXv.cXy.bb(LayoutInflater.from(context).inflate(this.cXv.cXX, this.cYD));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.cXv.cYf);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.cYP = new c(linearLayout, this.cXv.cXD, this.cXv.cXY, this.cXv.cYj);
        if (this.cXv.cXx != null) {
            this.cYP.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void aAf() {
                    try {
                        b.this.cXv.cXx.k(c.cYR.parse(b.this.cYP.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.cYP.fR(this.cXv.cXK);
        if (this.cXv.cXH != 0 && this.cXv.cXI != 0 && this.cXv.cXH <= this.cXv.cXI) {
            aAm();
        }
        if (this.cXv.cXF != null && this.cXv.cXG != null) {
            if (this.cXv.cXF.getTimeInMillis() > this.cXv.cXG.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aAn();
        } else if (this.cXv.cXF != null) {
            if (this.cXv.cXF.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aAn();
        } else if (this.cXv.cXG != null) {
            if (this.cXv.cXG.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aAn();
        } else {
            aAn();
        }
        aAp();
        this.cYP.c(this.cXv.cXL, this.cXv.cXM, this.cXv.cXN, this.cXv.cXO, this.cXv.cXP, this.cXv.cXQ);
        this.cYP.i(this.cXv.cXR, this.cXv.cXS, this.cXv.cXT, this.cXv.cXU, this.cXv.cXV, this.cXv.cXW);
        fQ(this.cXv.cYp);
        this.cYP.setCyclic(this.cXv.cXJ);
        this.cYP.setDividerColor(this.cXv.cYm);
        this.cYP.setDividerType(this.cXv.cYs);
        this.cYP.setLineSpacingMultiplier(this.cXv.cYn);
        this.cYP.setTextColorOut(this.cXv.cYk);
        this.cYP.setTextColorCenter(this.cXv.cYl);
        this.cYP.fS(this.cXv.cYq);
    }

    private void aAm() {
        this.cYP.lf(this.cXv.cXH);
        this.cYP.lg(this.cXv.cXI);
    }

    private void aAn() {
        this.cYP.a(this.cXv.cXF, this.cXv.cXG);
        aAo();
    }

    private void aAo() {
        if (this.cXv.cXF != null && this.cXv.cXG != null) {
            if (this.cXv.cXE == null || this.cXv.cXE.getTimeInMillis() < this.cXv.cXF.getTimeInMillis() || this.cXv.cXE.getTimeInMillis() > this.cXv.cXG.getTimeInMillis()) {
                this.cXv.cXE = this.cXv.cXF;
            }
        } else if (this.cXv.cXF != null) {
            this.cXv.cXE = this.cXv.cXF;
        } else if (this.cXv.cXG != null) {
            this.cXv.cXE = this.cXv.cXG;
        }
    }

    private void aAp() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.cXv.cXE == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.cXv.cXE.get(1);
            i2 = this.cXv.cXE.get(2);
            i3 = this.cXv.cXE.get(5);
            i4 = this.cXv.cXE.get(11);
            i5 = this.cXv.cXE.get(12);
            i6 = this.cXv.cXE.get(13);
        }
        this.cYP.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            aAq();
        }
        dismiss();
    }

    public void aAq() {
        if (this.cXv.cXw != null) {
            try {
                this.cXv.cXw.a(c.cYR.parse(this.cYP.getTime()), this.cYK);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean aAl() {
        return this.cXv.cYo;
    }
}
