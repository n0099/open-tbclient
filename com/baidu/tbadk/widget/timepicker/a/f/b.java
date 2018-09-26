package com.baidu.tbadk.widget.timepicker.a.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes.dex */
public class b extends a implements View.OnClickListener {
    private c blw;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.bke = aVar;
        bB(aVar.context);
    }

    private void bB(Context context) {
        PQ();
        initViews();
        initAnim();
        if (this.bke.bkh == null) {
            LayoutInflater.from(context).inflate(e.h.pickerview_time, this.blk);
            TextView textView = (TextView) findViewById(e.g.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.rv_topbar);
            Button button = (Button) findViewById(e.g.btnSubmit);
            Button button2 = (Button) findViewById(e.g.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.bke.bkG) ? context.getResources().getString(e.j.pickerview_submit) : this.bke.bkG);
            button2.setText(TextUtils.isEmpty(this.bke.bkH) ? context.getResources().getString(e.j.pickerview_cancel) : this.bke.bkH);
            textView.setText(TextUtils.isEmpty(this.bke.bkI) ? "" : this.bke.bkI);
            button.setTextColor(this.bke.bkJ);
            button2.setTextColor(this.bke.bkK);
            textView.setTextColor(this.bke.bkL);
            relativeLayout.setBackgroundColor(this.bke.bkN);
            button.setTextSize(this.bke.bkO);
            button2.setTextSize(this.bke.bkO);
            textView.setTextSize(this.bke.bkP);
        } else {
            this.bke.bkh.Z(LayoutInflater.from(context).inflate(this.bke.bkE, this.blk));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(e.g.timepicker);
        linearLayout.setBackgroundColor(this.bke.bkM);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.blw = new c(linearLayout, this.bke.bkm, this.bke.bkF, this.bke.bkQ);
        if (this.bke.bkg != null) {
            this.blw.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void PO() {
                    try {
                        b.this.bke.bkg.j(c.bly.parse(b.this.blw.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.blw.cE(this.bke.bkr);
        if (this.bke.startYear != 0 && this.bke.endYear != 0 && this.bke.startYear <= this.bke.endYear) {
            PU();
        }
        if (this.bke.bko != null && this.bke.bkp != null) {
            if (this.bke.bko.getTimeInMillis() > this.bke.bkp.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            PV();
        } else if (this.bke.bko != null) {
            if (this.bke.bko.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            PV();
        } else if (this.bke.bkp != null) {
            if (this.bke.bkp.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            PV();
        } else {
            PV();
        }
        PX();
        this.blw.c(this.bke.bks, this.bke.bkt, this.bke.bku, this.bke.bkv, this.bke.bkw, this.bke.bkx);
        this.blw.g(this.bke.bky, this.bke.bkz, this.bke.bkA, this.bke.bkB, this.bke.bkC, this.bke.bkD);
        cD(this.bke.bkW);
        this.blw.setCyclic(this.bke.bkq);
        this.blw.setDividerColor(this.bke.bkT);
        this.blw.setDividerType(this.bke.bkZ);
        this.blw.setLineSpacingMultiplier(this.bke.bkU);
        this.blw.setTextColorOut(this.bke.bkR);
        this.blw.setTextColorCenter(this.bke.bkS);
        this.blw.cF(this.bke.bkX);
    }

    private void PU() {
        this.blw.setStartYear(this.bke.startYear);
        this.blw.gB(this.bke.endYear);
    }

    private void PV() {
        this.blw.a(this.bke.bko, this.bke.bkp);
        PW();
    }

    private void PW() {
        if (this.bke.bko != null && this.bke.bkp != null) {
            if (this.bke.bkn == null || this.bke.bkn.getTimeInMillis() < this.bke.bko.getTimeInMillis() || this.bke.bkn.getTimeInMillis() > this.bke.bkp.getTimeInMillis()) {
                this.bke.bkn = this.bke.bko;
            }
        } else if (this.bke.bko != null) {
            this.bke.bkn = this.bke.bko;
        } else if (this.bke.bkp != null) {
            this.bke.bkn = this.bke.bkp;
        }
    }

    private void PX() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.bke.bkn == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.bke.bkn.get(1);
            i2 = this.bke.bkn.get(2);
            i3 = this.bke.bkn.get(5);
            i4 = this.bke.bkn.get(11);
            i5 = this.bke.bkn.get(12);
            i6 = this.bke.bkn.get(13);
        }
        this.blw.e(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            PY();
        }
        dismiss();
    }

    public void PY() {
        if (this.bke.bkf != null) {
            try {
                this.bke.bkf.a(c.bly.parse(this.blw.getTime()), this.blr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean PT() {
        return this.bke.bkV;
    }
}
