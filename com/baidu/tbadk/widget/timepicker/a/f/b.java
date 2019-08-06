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
    private c cPy;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.cOe = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        azQ();
        initViews();
        initAnim();
        if (this.cOe.cOh == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.cPm);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.cOe.cOI) ? context.getResources().getString(R.string.pickerview_submit) : this.cOe.cOI);
            button2.setText(TextUtils.isEmpty(this.cOe.cOJ) ? context.getResources().getString(R.string.pickerview_cancel) : this.cOe.cOJ);
            textView.setText(TextUtils.isEmpty(this.cOe.cOK) ? "" : this.cOe.cOK);
            button.setTextColor(this.cOe.cOL);
            button2.setTextColor(this.cOe.cOM);
            textView.setTextColor(this.cOe.cON);
            relativeLayout.setBackgroundColor(this.cOe.cOP);
            button.setTextSize(this.cOe.cOQ);
            button2.setTextSize(this.cOe.cOQ);
            textView.setTextSize(this.cOe.cOR);
        } else {
            this.cOe.cOh.bb(LayoutInflater.from(context).inflate(this.cOe.cOG, this.cPm));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.cOe.cOO);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.cPy = new c(linearLayout, this.cOe.cOm, this.cOe.cOH, this.cOe.cOS);
        if (this.cOe.cOg != null) {
            this.cPy.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void azM() {
                    try {
                        b.this.cOe.cOg.p(c.cPA.parse(b.this.cPy.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.cPy.fZ(this.cOe.cOt);
        if (this.cOe.cOq != 0 && this.cOe.cOr != 0 && this.cOe.cOq <= this.cOe.cOr) {
            azT();
        }
        if (this.cOe.cOo != null && this.cOe.cOp != null) {
            if (this.cOe.cOo.getTimeInMillis() > this.cOe.cOp.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            azU();
        } else if (this.cOe.cOo != null) {
            if (this.cOe.cOo.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            azU();
        } else if (this.cOe.cOp != null) {
            if (this.cOe.cOp.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            azU();
        } else {
            azU();
        }
        azW();
        this.cPy.c(this.cOe.cOu, this.cOe.cOv, this.cOe.cOw, this.cOe.cOx, this.cOe.cOy, this.cOe.cOz);
        this.cPy.i(this.cOe.cOA, this.cOe.cOB, this.cOe.cOC, this.cOe.cOD, this.cOe.cOE, this.cOe.cOF);
        fY(this.cOe.cOY);
        this.cPy.setCyclic(this.cOe.cOs);
        this.cPy.setDividerColor(this.cOe.cOV);
        this.cPy.setDividerType(this.cOe.cPb);
        this.cPy.setLineSpacingMultiplier(this.cOe.cOW);
        this.cPy.setTextColorOut(this.cOe.cOT);
        this.cPy.setTextColorCenter(this.cOe.cOU);
        this.cPy.ga(this.cOe.cOZ);
    }

    private void azT() {
        this.cPy.lX(this.cOe.cOq);
        this.cPy.lY(this.cOe.cOr);
    }

    private void azU() {
        this.cPy.a(this.cOe.cOo, this.cOe.cOp);
        azV();
    }

    private void azV() {
        if (this.cOe.cOo != null && this.cOe.cOp != null) {
            if (this.cOe.cOn == null || this.cOe.cOn.getTimeInMillis() < this.cOe.cOo.getTimeInMillis() || this.cOe.cOn.getTimeInMillis() > this.cOe.cOp.getTimeInMillis()) {
                this.cOe.cOn = this.cOe.cOo;
            }
        } else if (this.cOe.cOo != null) {
            this.cOe.cOn = this.cOe.cOo;
        } else if (this.cOe.cOp != null) {
            this.cOe.cOn = this.cOe.cOp;
        }
    }

    private void azW() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.cOe.cOn == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.cOe.cOn.get(1);
            i2 = this.cOe.cOn.get(2);
            i3 = this.cOe.cOn.get(5);
            i4 = this.cOe.cOn.get(11);
            i5 = this.cOe.cOn.get(12);
            i6 = this.cOe.cOn.get(13);
        }
        this.cPy.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            azX();
        }
        dismiss();
    }

    public void azX() {
        if (this.cOe.cOf != null) {
            try {
                this.cOe.cOf.a(c.cPA.parse(this.cPy.getTime()), this.cPt);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean azS() {
        return this.cOe.cOX;
    }
}
