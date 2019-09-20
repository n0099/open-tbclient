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
    private c cQo;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.cOU = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        aAc();
        initViews();
        initAnim();
        if (this.cOU.cOX == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.cQc);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.cOU.cPy) ? context.getResources().getString(R.string.pickerview_submit) : this.cOU.cPy);
            button2.setText(TextUtils.isEmpty(this.cOU.cPz) ? context.getResources().getString(R.string.pickerview_cancel) : this.cOU.cPz);
            textView.setText(TextUtils.isEmpty(this.cOU.cPA) ? "" : this.cOU.cPA);
            button.setTextColor(this.cOU.cPB);
            button2.setTextColor(this.cOU.cPC);
            textView.setTextColor(this.cOU.cPD);
            relativeLayout.setBackgroundColor(this.cOU.cPF);
            button.setTextSize(this.cOU.cPG);
            button2.setTextSize(this.cOU.cPG);
            textView.setTextSize(this.cOU.cPH);
        } else {
            this.cOU.cOX.bb(LayoutInflater.from(context).inflate(this.cOU.cPw, this.cQc));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.cOU.cPE);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.cQo = new c(linearLayout, this.cOU.cPc, this.cOU.cPx, this.cOU.cPI);
        if (this.cOU.cOW != null) {
            this.cQo.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void azY() {
                    try {
                        b.this.cOU.cOW.p(c.cQq.parse(b.this.cQo.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.cQo.gc(this.cOU.cPj);
        if (this.cOU.cPg != 0 && this.cOU.cPh != 0 && this.cOU.cPg <= this.cOU.cPh) {
            aAf();
        }
        if (this.cOU.cPe != null && this.cOU.cPf != null) {
            if (this.cOU.cPe.getTimeInMillis() > this.cOU.cPf.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aAg();
        } else if (this.cOU.cPe != null) {
            if (this.cOU.cPe.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aAg();
        } else if (this.cOU.cPf != null) {
            if (this.cOU.cPf.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aAg();
        } else {
            aAg();
        }
        aAi();
        this.cQo.c(this.cOU.cPk, this.cOU.cPl, this.cOU.cPm, this.cOU.cPn, this.cOU.cPo, this.cOU.cPp);
        this.cQo.i(this.cOU.cPq, this.cOU.cPr, this.cOU.cPs, this.cOU.cPt, this.cOU.cPu, this.cOU.cPv);
        gb(this.cOU.cPO);
        this.cQo.setCyclic(this.cOU.cPi);
        this.cQo.setDividerColor(this.cOU.cPL);
        this.cQo.setDividerType(this.cOU.cPR);
        this.cQo.setLineSpacingMultiplier(this.cOU.cPM);
        this.cQo.setTextColorOut(this.cOU.cPJ);
        this.cQo.setTextColorCenter(this.cOU.cPK);
        this.cQo.gd(this.cOU.cPP);
    }

    private void aAf() {
        this.cQo.mb(this.cOU.cPg);
        this.cQo.mc(this.cOU.cPh);
    }

    private void aAg() {
        this.cQo.a(this.cOU.cPe, this.cOU.cPf);
        aAh();
    }

    private void aAh() {
        if (this.cOU.cPe != null && this.cOU.cPf != null) {
            if (this.cOU.cPd == null || this.cOU.cPd.getTimeInMillis() < this.cOU.cPe.getTimeInMillis() || this.cOU.cPd.getTimeInMillis() > this.cOU.cPf.getTimeInMillis()) {
                this.cOU.cPd = this.cOU.cPe;
            }
        } else if (this.cOU.cPe != null) {
            this.cOU.cPd = this.cOU.cPe;
        } else if (this.cOU.cPf != null) {
            this.cOU.cPd = this.cOU.cPf;
        }
    }

    private void aAi() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.cOU.cPd == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.cOU.cPd.get(1);
            i2 = this.cOU.cPd.get(2);
            i3 = this.cOU.cPd.get(5);
            i4 = this.cOU.cPd.get(11);
            i5 = this.cOU.cPd.get(12);
            i6 = this.cOU.cPd.get(13);
        }
        this.cQo.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            aAj();
        }
        dismiss();
    }

    public void aAj() {
        if (this.cOU.cOV != null) {
            try {
                this.cOU.cOV.a(c.cQq.parse(this.cQo.getTime()), this.cQj);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean aAe() {
        return this.cOU.cPN;
    }
}
