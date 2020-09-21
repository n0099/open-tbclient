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
/* loaded from: classes20.dex */
public class b extends a implements View.OnClickListener {
    private c flm;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.fka = aVar;
        dK(aVar.context);
    }

    private void dK(Context context) {
        bzL();
        initViews();
        Ig();
        if (this.fka.fkd == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.fld);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.fka.fkE) ? context.getResources().getString(R.string.pickerview_submit) : this.fka.fkE);
            button2.setText(TextUtils.isEmpty(this.fka.fkF) ? context.getResources().getString(R.string.pickerview_cancel) : this.fka.fkF);
            textView.setText(TextUtils.isEmpty(this.fka.fkG) ? "" : this.fka.fkG);
            button.setTextColor(this.fka.fkH);
            button2.setTextColor(this.fka.fkI);
            textView.setTextColor(this.fka.fkJ);
            relativeLayout.setBackgroundColor(this.fka.fkL);
            button.setTextSize(this.fka.fkM);
            button2.setTextSize(this.fka.fkM);
            textView.setTextSize(this.fka.fkN);
        } else {
            this.fka.fkd.bo(LayoutInflater.from(context).inflate(this.fka.fkC, this.fld));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.fka.fkK);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.flm = new c(linearLayout, this.fka.fki, this.fka.fkD, this.fka.fkO);
        if (this.fka.fkc != null) {
            this.flm.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bzK() {
                    try {
                        b.this.fka.fkc.q(c.dateFormat.parse(b.this.flm.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.flm.kg(this.fka.fkp);
        if (this.fka.fkm != 0 && this.fka.fkn != 0 && this.fka.fkm <= this.fka.fkn) {
            bzN();
        }
        if (this.fka.fkk != null && this.fka.fkl != null) {
            if (this.fka.fkk.getTimeInMillis() > this.fka.fkl.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bzO();
        } else if (this.fka.fkk != null) {
            if (this.fka.fkk.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bzO();
        } else if (this.fka.fkl != null) {
            if (this.fka.fkl.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bzO();
        } else {
            bzO();
        }
        bzQ();
        this.flm.c(this.fka.fkq, this.fka.fkr, this.fka.fks, this.fka.fkt, this.fka.fku, this.fka.fkv);
        this.flm.i(this.fka.fkw, this.fka.fkx, this.fka.fky, this.fka.fkz, this.fka.fkA, this.fka.fkB);
        kf(this.fka.fkQ);
        this.flm.setCyclic(this.fka.fko);
        this.flm.setDividerColor(this.fka.dividerColor);
        this.flm.setDividerType(this.fka.fkS);
        this.flm.setLineSpacingMultiplier(this.fka.lineSpacingMultiplier);
        this.flm.setTextColorOut(this.fka.textColorOut);
        this.flm.setTextColorCenter(this.fka.textColorCenter);
        this.flm.isCenterLabel(this.fka.isCenterLabel);
    }

    private void bzN() {
        this.flm.sa(this.fka.fkm);
        this.flm.sb(this.fka.fkn);
    }

    private void bzO() {
        this.flm.a(this.fka.fkk, this.fka.fkl);
        bzP();
    }

    private void bzP() {
        if (this.fka.fkk != null && this.fka.fkl != null) {
            if (this.fka.fkj == null || this.fka.fkj.getTimeInMillis() < this.fka.fkk.getTimeInMillis() || this.fka.fkj.getTimeInMillis() > this.fka.fkl.getTimeInMillis()) {
                this.fka.fkj = this.fka.fkk;
            }
        } else if (this.fka.fkk != null) {
            this.fka.fkj = this.fka.fkk;
        } else if (this.fka.fkl != null) {
            this.fka.fkj = this.fka.fkl;
        }
    }

    private void bzQ() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.fka.fkj == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.fka.fkj.get(1);
            i2 = this.fka.fkj.get(2);
            i3 = this.fka.fkj.get(5);
            i4 = this.fka.fkj.get(11);
            i5 = this.fka.fkj.get(12);
            i6 = this.fka.fkj.get(13);
        }
        this.flm.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bzR();
        }
        dismiss();
    }

    public void bzR() {
        if (this.fka.fkb != null) {
            try {
                this.fka.fkb.a(c.dateFormat.parse(this.flm.getTime()), this.fli);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bzM() {
        return this.fka.fkP;
    }
}
