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
    private c eXG;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.eWu = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        bpN();
        initViews();
        Cb();
        if (this.eWu.eWx == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.eXx);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.eWu.eWY) ? context.getResources().getString(R.string.pickerview_submit) : this.eWu.eWY);
            button2.setText(TextUtils.isEmpty(this.eWu.eWZ) ? context.getResources().getString(R.string.pickerview_cancel) : this.eWu.eWZ);
            textView.setText(TextUtils.isEmpty(this.eWu.eXa) ? "" : this.eWu.eXa);
            button.setTextColor(this.eWu.eXb);
            button2.setTextColor(this.eWu.eXc);
            textView.setTextColor(this.eWu.eXd);
            relativeLayout.setBackgroundColor(this.eWu.eXf);
            button.setTextSize(this.eWu.eXg);
            button2.setTextSize(this.eWu.eXg);
            textView.setTextSize(this.eWu.eXh);
        } else {
            this.eWu.eWx.bk(LayoutInflater.from(context).inflate(this.eWu.eWW, this.eXx));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.eWu.eXe);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.eXG = new c(linearLayout, this.eWu.eWC, this.eWu.eWX, this.eWu.eXi);
        if (this.eWu.eWw != null) {
            this.eXG.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bpM() {
                    try {
                        b.this.eWu.eWw.q(c.dateFormat.parse(b.this.eXG.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.eXG.jF(this.eWu.eWJ);
        if (this.eWu.eWG != 0 && this.eWu.eWH != 0 && this.eWu.eWG <= this.eWu.eWH) {
            bpP();
        }
        if (this.eWu.eWE != null && this.eWu.eWF != null) {
            if (this.eWu.eWE.getTimeInMillis() > this.eWu.eWF.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bpQ();
        } else if (this.eWu.eWE != null) {
            if (this.eWu.eWE.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bpQ();
        } else if (this.eWu.eWF != null) {
            if (this.eWu.eWF.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bpQ();
        } else {
            bpQ();
        }
        bpS();
        this.eXG.c(this.eWu.eWK, this.eWu.eWL, this.eWu.eWM, this.eWu.eWN, this.eWu.eWO, this.eWu.eWP);
        this.eXG.j(this.eWu.eWQ, this.eWu.eWR, this.eWu.eWS, this.eWu.eWT, this.eWu.eWU, this.eWu.eWV);
        jE(this.eWu.eXk);
        this.eXG.setCyclic(this.eWu.eWI);
        this.eXG.setDividerColor(this.eWu.dividerColor);
        this.eXG.setDividerType(this.eWu.eXm);
        this.eXG.setLineSpacingMultiplier(this.eWu.lineSpacingMultiplier);
        this.eXG.setTextColorOut(this.eWu.textColorOut);
        this.eXG.setTextColorCenter(this.eWu.textColorCenter);
        this.eXG.isCenterLabel(this.eWu.isCenterLabel);
    }

    private void bpP() {
        this.eXG.py(this.eWu.eWG);
        this.eXG.pz(this.eWu.eWH);
    }

    private void bpQ() {
        this.eXG.a(this.eWu.eWE, this.eWu.eWF);
        bpR();
    }

    private void bpR() {
        if (this.eWu.eWE != null && this.eWu.eWF != null) {
            if (this.eWu.eWD == null || this.eWu.eWD.getTimeInMillis() < this.eWu.eWE.getTimeInMillis() || this.eWu.eWD.getTimeInMillis() > this.eWu.eWF.getTimeInMillis()) {
                this.eWu.eWD = this.eWu.eWE;
            }
        } else if (this.eWu.eWE != null) {
            this.eWu.eWD = this.eWu.eWE;
        } else if (this.eWu.eWF != null) {
            this.eWu.eWD = this.eWu.eWF;
        }
    }

    private void bpS() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.eWu.eWD == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.eWu.eWD.get(1);
            i2 = this.eWu.eWD.get(2);
            i3 = this.eWu.eWD.get(5);
            i4 = this.eWu.eWD.get(11);
            i5 = this.eWu.eWD.get(12);
            i6 = this.eWu.eWD.get(13);
        }
        this.eXG.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bpT();
        }
        dismiss();
    }

    public void bpT() {
        if (this.eWu.eWv != null) {
            try {
                this.eWu.eWv.a(c.dateFormat.parse(this.eXG.getTime()), this.eXC);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bpO() {
        return this.eWu.eXj;
    }
}
