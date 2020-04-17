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
/* loaded from: classes8.dex */
public class b extends a implements View.OnClickListener {
    private c esj;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.eqW = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        bdi();
        initViews();
        zK();
        if (this.eqW.eqZ == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.esa);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.eqW.erB) ? context.getResources().getString(R.string.pickerview_submit) : this.eqW.erB);
            button2.setText(TextUtils.isEmpty(this.eqW.erC) ? context.getResources().getString(R.string.pickerview_cancel) : this.eqW.erC);
            textView.setText(TextUtils.isEmpty(this.eqW.erD) ? "" : this.eqW.erD);
            button.setTextColor(this.eqW.erE);
            button2.setTextColor(this.eqW.erF);
            textView.setTextColor(this.eqW.erG);
            relativeLayout.setBackgroundColor(this.eqW.erI);
            button.setTextSize(this.eqW.erJ);
            button2.setTextSize(this.eqW.erJ);
            textView.setTextSize(this.eqW.erK);
        } else {
            this.eqW.eqZ.bd(LayoutInflater.from(context).inflate(this.eqW.erz, this.esa));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.eqW.erH);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.esj = new c(linearLayout, this.eqW.ere, this.eqW.erA, this.eqW.erL);
        if (this.eqW.eqY != null) {
            this.esj.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bdh() {
                    try {
                        b.this.eqW.eqY.m(c.dateFormat.parse(b.this.esj.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.esj.ir(this.eqW.erl);
        if (this.eqW.eri != 0 && this.eqW.erj != 0 && this.eqW.eri <= this.eqW.erj) {
            bdk();
        }
        if (this.eqW.erg != null && this.eqW.erh != null) {
            if (this.eqW.erg.getTimeInMillis() > this.eqW.erh.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bdl();
        } else if (this.eqW.erg != null) {
            if (this.eqW.erg.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bdl();
        } else if (this.eqW.erh != null) {
            if (this.eqW.erh.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bdl();
        } else {
            bdl();
        }
        bdn();
        this.esj.c(this.eqW.erm, this.eqW.ern, this.eqW.ero, this.eqW.erp, this.eqW.erq, this.eqW.ers);
        this.esj.j(this.eqW.ert, this.eqW.eru, this.eqW.erv, this.eqW.erw, this.eqW.erx, this.eqW.ery);
        iq(this.eqW.erN);
        this.esj.setCyclic(this.eqW.erk);
        this.esj.setDividerColor(this.eqW.dividerColor);
        this.esj.setDividerType(this.eqW.erP);
        this.esj.setLineSpacingMultiplier(this.eqW.lineSpacingMultiplier);
        this.esj.setTextColorOut(this.eqW.textColorOut);
        this.esj.setTextColorCenter(this.eqW.textColorCenter);
        this.esj.isCenterLabel(this.eqW.isCenterLabel);
    }

    private void bdk() {
        this.esj.ob(this.eqW.eri);
        this.esj.oc(this.eqW.erj);
    }

    private void bdl() {
        this.esj.a(this.eqW.erg, this.eqW.erh);
        bdm();
    }

    private void bdm() {
        if (this.eqW.erg != null && this.eqW.erh != null) {
            if (this.eqW.erf == null || this.eqW.erf.getTimeInMillis() < this.eqW.erg.getTimeInMillis() || this.eqW.erf.getTimeInMillis() > this.eqW.erh.getTimeInMillis()) {
                this.eqW.erf = this.eqW.erg;
            }
        } else if (this.eqW.erg != null) {
            this.eqW.erf = this.eqW.erg;
        } else if (this.eqW.erh != null) {
            this.eqW.erf = this.eqW.erh;
        }
    }

    private void bdn() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.eqW.erf == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.eqW.erf.get(1);
            i2 = this.eqW.erf.get(2);
            i3 = this.eqW.erf.get(5);
            i4 = this.eqW.erf.get(11);
            i5 = this.eqW.erf.get(12);
            i6 = this.eqW.erf.get(13);
        }
        this.esj.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bdo();
        }
        dismiss();
    }

    public void bdo() {
        if (this.eqW.eqX != null) {
            try {
                this.eqW.eqX.a(c.dateFormat.parse(this.esj.getTime()), this.esf);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bdj() {
        return this.eqW.erM;
    }
}
