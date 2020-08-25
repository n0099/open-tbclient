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
/* loaded from: classes15.dex */
public class b extends a implements View.OnClickListener {
    private c fiq;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.fhc = aVar;
        dL(aVar.context);
    }

    private void dL(Context context) {
        byB();
        initViews();
        HE();
        if (this.fhc.fhf == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.fig);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.fhc.fhG) ? context.getResources().getString(R.string.pickerview_submit) : this.fhc.fhG);
            button2.setText(TextUtils.isEmpty(this.fhc.fhH) ? context.getResources().getString(R.string.pickerview_cancel) : this.fhc.fhH);
            textView.setText(TextUtils.isEmpty(this.fhc.fhI) ? "" : this.fhc.fhI);
            button.setTextColor(this.fhc.fhJ);
            button2.setTextColor(this.fhc.fhK);
            textView.setTextColor(this.fhc.fhL);
            relativeLayout.setBackgroundColor(this.fhc.fhN);
            button.setTextSize(this.fhc.fhO);
            button2.setTextSize(this.fhc.fhO);
            textView.setTextSize(this.fhc.fhP);
        } else {
            this.fhc.fhf.bm(LayoutInflater.from(context).inflate(this.fhc.fhE, this.fig));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.fhc.fhM);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.fiq = new c(linearLayout, this.fhc.fhk, this.fhc.fhF, this.fhc.fhQ);
        if (this.fhc.fhe != null) {
            this.fiq.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void byA() {
                    try {
                        b.this.fhc.fhe.q(c.dateFormat.parse(b.this.fiq.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.fiq.kd(this.fhc.fhr);
        if (this.fhc.fho != 0 && this.fhc.fhp != 0 && this.fhc.fho <= this.fhc.fhp) {
            byD();
        }
        if (this.fhc.fhm != null && this.fhc.fhn != null) {
            if (this.fhc.fhm.getTimeInMillis() > this.fhc.fhn.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            byE();
        } else if (this.fhc.fhm != null) {
            if (this.fhc.fhm.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            byE();
        } else if (this.fhc.fhn != null) {
            if (this.fhc.fhn.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            byE();
        } else {
            byE();
        }
        byG();
        this.fiq.c(this.fhc.fhs, this.fhc.fht, this.fhc.fhu, this.fhc.fhv, this.fhc.fhw, this.fhc.fhx);
        this.fiq.i(this.fhc.fhy, this.fhc.fhz, this.fhc.fhA, this.fhc.fhB, this.fhc.fhC, this.fhc.fhD);
        kc(this.fhc.fhS);
        this.fiq.setCyclic(this.fhc.fhq);
        this.fiq.setDividerColor(this.fhc.dividerColor);
        this.fiq.setDividerType(this.fhc.fhU);
        this.fiq.setLineSpacingMultiplier(this.fhc.lineSpacingMultiplier);
        this.fiq.setTextColorOut(this.fhc.textColorOut);
        this.fiq.setTextColorCenter(this.fhc.textColorCenter);
        this.fiq.isCenterLabel(this.fhc.isCenterLabel);
    }

    private void byD() {
        this.fiq.rJ(this.fhc.fho);
        this.fiq.rK(this.fhc.fhp);
    }

    private void byE() {
        this.fiq.a(this.fhc.fhm, this.fhc.fhn);
        byF();
    }

    private void byF() {
        if (this.fhc.fhm != null && this.fhc.fhn != null) {
            if (this.fhc.fhl == null || this.fhc.fhl.getTimeInMillis() < this.fhc.fhm.getTimeInMillis() || this.fhc.fhl.getTimeInMillis() > this.fhc.fhn.getTimeInMillis()) {
                this.fhc.fhl = this.fhc.fhm;
            }
        } else if (this.fhc.fhm != null) {
            this.fhc.fhl = this.fhc.fhm;
        } else if (this.fhc.fhn != null) {
            this.fhc.fhl = this.fhc.fhn;
        }
    }

    private void byG() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.fhc.fhl == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.fhc.fhl.get(1);
            i2 = this.fhc.fhl.get(2);
            i3 = this.fhc.fhl.get(5);
            i4 = this.fhc.fhl.get(11);
            i5 = this.fhc.fhl.get(12);
            i6 = this.fhc.fhl.get(13);
        }
        this.fiq.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            byH();
        }
        dismiss();
    }

    public void byH() {
        if (this.fhc.fhd != null) {
            try {
                this.fhc.fhd.a(c.dateFormat.parse(this.fiq.getTime()), this.fil);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean byC() {
        return this.fhc.fhR;
    }
}
