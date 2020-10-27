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
/* loaded from: classes21.dex */
public class b extends a implements View.OnClickListener {
    private c fFV;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.fEJ = aVar;
        dQ(aVar.context);
    }

    private void dQ(Context context) {
        bEo();
        initViews();
        Jw();
        if (this.fEJ.fEM == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.fFM);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.fEJ.fFn) ? context.getResources().getString(R.string.pickerview_submit) : this.fEJ.fFn);
            button2.setText(TextUtils.isEmpty(this.fEJ.fFo) ? context.getResources().getString(R.string.pickerview_cancel) : this.fEJ.fFo);
            textView.setText(TextUtils.isEmpty(this.fEJ.fFp) ? "" : this.fEJ.fFp);
            button.setTextColor(this.fEJ.fFq);
            button2.setTextColor(this.fEJ.fFr);
            textView.setTextColor(this.fEJ.fFs);
            relativeLayout.setBackgroundColor(this.fEJ.fFu);
            button.setTextSize(this.fEJ.fFv);
            button2.setTextSize(this.fEJ.fFv);
            textView.setTextSize(this.fEJ.fFw);
        } else {
            this.fEJ.fEM.bt(LayoutInflater.from(context).inflate(this.fEJ.fFl, this.fFM));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.fEJ.fFt);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.fFV = new c(linearLayout, this.fEJ.fER, this.fEJ.fFm, this.fEJ.fFx);
        if (this.fEJ.fEL != null) {
            this.fFV.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bEn() {
                    try {
                        b.this.fEJ.fEL.q(c.dateFormat.parse(b.this.fFV.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.fFV.kR(this.fEJ.fEY);
        if (this.fEJ.fEV != 0 && this.fEJ.fEW != 0 && this.fEJ.fEV <= this.fEJ.fEW) {
            bEq();
        }
        if (this.fEJ.fET != null && this.fEJ.fEU != null) {
            if (this.fEJ.fET.getTimeInMillis() > this.fEJ.fEU.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bEr();
        } else if (this.fEJ.fET != null) {
            if (this.fEJ.fET.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bEr();
        } else if (this.fEJ.fEU != null) {
            if (this.fEJ.fEU.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bEr();
        } else {
            bEr();
        }
        bEt();
        this.fFV.d(this.fEJ.fEZ, this.fEJ.fFa, this.fEJ.fFb, this.fEJ.fFc, this.fEJ.fFd, this.fEJ.fFe);
        this.fFV.i(this.fEJ.fFf, this.fEJ.fFg, this.fEJ.fFh, this.fEJ.fFi, this.fEJ.fFj, this.fEJ.fFk);
        kQ(this.fEJ.fFz);
        this.fFV.setCyclic(this.fEJ.fEX);
        this.fFV.setDividerColor(this.fEJ.dividerColor);
        this.fFV.setDividerType(this.fEJ.fFB);
        this.fFV.setLineSpacingMultiplier(this.fEJ.lineSpacingMultiplier);
        this.fFV.setTextColorOut(this.fEJ.textColorOut);
        this.fFV.setTextColorCenter(this.fEJ.textColorCenter);
        this.fFV.isCenterLabel(this.fEJ.isCenterLabel);
    }

    private void bEq() {
        this.fFV.sJ(this.fEJ.fEV);
        this.fFV.sK(this.fEJ.fEW);
    }

    private void bEr() {
        this.fFV.a(this.fEJ.fET, this.fEJ.fEU);
        bEs();
    }

    private void bEs() {
        if (this.fEJ.fET != null && this.fEJ.fEU != null) {
            if (this.fEJ.fES == null || this.fEJ.fES.getTimeInMillis() < this.fEJ.fET.getTimeInMillis() || this.fEJ.fES.getTimeInMillis() > this.fEJ.fEU.getTimeInMillis()) {
                this.fEJ.fES = this.fEJ.fET;
            }
        } else if (this.fEJ.fET != null) {
            this.fEJ.fES = this.fEJ.fET;
        } else if (this.fEJ.fEU != null) {
            this.fEJ.fES = this.fEJ.fEU;
        }
    }

    private void bEt() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.fEJ.fES == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.fEJ.fES.get(1);
            i2 = this.fEJ.fES.get(2);
            i3 = this.fEJ.fES.get(5);
            i4 = this.fEJ.fES.get(11);
            i5 = this.fEJ.fES.get(12);
            i6 = this.fEJ.fES.get(13);
        }
        this.fFV.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bEu();
        }
        dismiss();
    }

    public void bEu() {
        if (this.fEJ.fEK != null) {
            try {
                this.fEJ.fEK.a(c.dateFormat.parse(this.fFV.getTime()), this.fFR);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bEp() {
        return this.fEJ.fFy;
    }
}
