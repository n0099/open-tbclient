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
    private c fiu;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.fhg = aVar;
        dL(aVar.context);
    }

    private void dL(Context context) {
        byC();
        initViews();
        HE();
        if (this.fhg.fhj == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.fik);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.fhg.fhK) ? context.getResources().getString(R.string.pickerview_submit) : this.fhg.fhK);
            button2.setText(TextUtils.isEmpty(this.fhg.fhL) ? context.getResources().getString(R.string.pickerview_cancel) : this.fhg.fhL);
            textView.setText(TextUtils.isEmpty(this.fhg.fhM) ? "" : this.fhg.fhM);
            button.setTextColor(this.fhg.fhN);
            button2.setTextColor(this.fhg.fhO);
            textView.setTextColor(this.fhg.fhP);
            relativeLayout.setBackgroundColor(this.fhg.fhR);
            button.setTextSize(this.fhg.fhS);
            button2.setTextSize(this.fhg.fhS);
            textView.setTextSize(this.fhg.fhT);
        } else {
            this.fhg.fhj.bm(LayoutInflater.from(context).inflate(this.fhg.fhI, this.fik));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.fhg.fhQ);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.fiu = new c(linearLayout, this.fhg.fho, this.fhg.fhJ, this.fhg.fhU);
        if (this.fhg.fhi != null) {
            this.fiu.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void byB() {
                    try {
                        b.this.fhg.fhi.q(c.dateFormat.parse(b.this.fiu.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.fiu.kf(this.fhg.fhv);
        if (this.fhg.fhs != 0 && this.fhg.fht != 0 && this.fhg.fhs <= this.fhg.fht) {
            byE();
        }
        if (this.fhg.fhq != null && this.fhg.fhr != null) {
            if (this.fhg.fhq.getTimeInMillis() > this.fhg.fhr.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            byF();
        } else if (this.fhg.fhq != null) {
            if (this.fhg.fhq.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            byF();
        } else if (this.fhg.fhr != null) {
            if (this.fhg.fhr.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            byF();
        } else {
            byF();
        }
        byH();
        this.fiu.c(this.fhg.fhw, this.fhg.fhx, this.fhg.fhy, this.fhg.fhz, this.fhg.fhA, this.fhg.fhB);
        this.fiu.i(this.fhg.fhC, this.fhg.fhD, this.fhg.fhE, this.fhg.fhF, this.fhg.fhG, this.fhg.fhH);
        ke(this.fhg.fhW);
        this.fiu.setCyclic(this.fhg.fhu);
        this.fiu.setDividerColor(this.fhg.dividerColor);
        this.fiu.setDividerType(this.fhg.fhY);
        this.fiu.setLineSpacingMultiplier(this.fhg.lineSpacingMultiplier);
        this.fiu.setTextColorOut(this.fhg.textColorOut);
        this.fiu.setTextColorCenter(this.fhg.textColorCenter);
        this.fiu.isCenterLabel(this.fhg.isCenterLabel);
    }

    private void byE() {
        this.fiu.rJ(this.fhg.fhs);
        this.fiu.rK(this.fhg.fht);
    }

    private void byF() {
        this.fiu.a(this.fhg.fhq, this.fhg.fhr);
        byG();
    }

    private void byG() {
        if (this.fhg.fhq != null && this.fhg.fhr != null) {
            if (this.fhg.fhp == null || this.fhg.fhp.getTimeInMillis() < this.fhg.fhq.getTimeInMillis() || this.fhg.fhp.getTimeInMillis() > this.fhg.fhr.getTimeInMillis()) {
                this.fhg.fhp = this.fhg.fhq;
            }
        } else if (this.fhg.fhq != null) {
            this.fhg.fhp = this.fhg.fhq;
        } else if (this.fhg.fhr != null) {
            this.fhg.fhp = this.fhg.fhr;
        }
    }

    private void byH() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.fhg.fhp == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.fhg.fhp.get(1);
            i2 = this.fhg.fhp.get(2);
            i3 = this.fhg.fhp.get(5);
            i4 = this.fhg.fhp.get(11);
            i5 = this.fhg.fhp.get(12);
            i6 = this.fhg.fhp.get(13);
        }
        this.fiu.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            byI();
        }
        dismiss();
    }

    public void byI() {
        if (this.fhg.fhh != null) {
            try {
                this.fhg.fhh.a(c.dateFormat.parse(this.fiu.getTime()), this.fiq);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean byD() {
        return this.fhg.fhV;
    }
}
