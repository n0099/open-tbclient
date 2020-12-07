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
    private c fSZ;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.fRN = aVar;
        ev(aVar.context);
    }

    private void ev(Context context) {
        bJG();
        initViews();
        Lo();
        if (this.fRN.fRQ == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.fSQ);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.fRN.fSr) ? context.getResources().getString(R.string.pickerview_submit) : this.fRN.fSr);
            button2.setText(TextUtils.isEmpty(this.fRN.fSs) ? context.getResources().getString(R.string.pickerview_cancel) : this.fRN.fSs);
            textView.setText(TextUtils.isEmpty(this.fRN.fSt) ? "" : this.fRN.fSt);
            button.setTextColor(this.fRN.fSu);
            button2.setTextColor(this.fRN.fSv);
            textView.setTextColor(this.fRN.fSw);
            relativeLayout.setBackgroundColor(this.fRN.fSy);
            button.setTextSize(this.fRN.fSz);
            button2.setTextSize(this.fRN.fSz);
            textView.setTextSize(this.fRN.fSA);
        } else {
            this.fRN.fRQ.bD(LayoutInflater.from(context).inflate(this.fRN.fSp, this.fSQ));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.fRN.fSx);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.fSZ = new c(linearLayout, this.fRN.fRV, this.fRN.fSq, this.fRN.fSB);
        if (this.fRN.fRP != null) {
            this.fSZ.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bJF() {
                    try {
                        b.this.fRN.fRP.q(c.dateFormat.parse(b.this.fSZ.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.fSZ.lv(this.fRN.fSc);
        if (this.fRN.fRZ != 0 && this.fRN.fSa != 0 && this.fRN.fRZ <= this.fRN.fSa) {
            bJI();
        }
        if (this.fRN.fRX != null && this.fRN.fRY != null) {
            if (this.fRN.fRX.getTimeInMillis() > this.fRN.fRY.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bJJ();
        } else if (this.fRN.fRX != null) {
            if (this.fRN.fRX.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bJJ();
        } else if (this.fRN.fRY != null) {
            if (this.fRN.fRY.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bJJ();
        } else {
            bJJ();
        }
        bJL();
        this.fSZ.d(this.fRN.fSd, this.fRN.fSe, this.fRN.fSf, this.fRN.fSg, this.fRN.fSh, this.fRN.fSi);
        this.fSZ.j(this.fRN.fSj, this.fRN.fSk, this.fRN.fSl, this.fRN.fSm, this.fRN.fSn, this.fRN.fSo);
        lu(this.fRN.fSD);
        this.fSZ.setCyclic(this.fRN.fSb);
        this.fSZ.setDividerColor(this.fRN.dividerColor);
        this.fSZ.setDividerType(this.fRN.fSF);
        this.fSZ.setLineSpacingMultiplier(this.fRN.lineSpacingMultiplier);
        this.fSZ.setTextColorOut(this.fRN.textColorOut);
        this.fSZ.setTextColorCenter(this.fRN.textColorCenter);
        this.fSZ.isCenterLabel(this.fRN.isCenterLabel);
    }

    private void bJI() {
        this.fSZ.tU(this.fRN.fRZ);
        this.fSZ.tV(this.fRN.fSa);
    }

    private void bJJ() {
        this.fSZ.a(this.fRN.fRX, this.fRN.fRY);
        bJK();
    }

    private void bJK() {
        if (this.fRN.fRX != null && this.fRN.fRY != null) {
            if (this.fRN.fRW == null || this.fRN.fRW.getTimeInMillis() < this.fRN.fRX.getTimeInMillis() || this.fRN.fRW.getTimeInMillis() > this.fRN.fRY.getTimeInMillis()) {
                this.fRN.fRW = this.fRN.fRX;
            }
        } else if (this.fRN.fRX != null) {
            this.fRN.fRW = this.fRN.fRX;
        } else if (this.fRN.fRY != null) {
            this.fRN.fRW = this.fRN.fRY;
        }
    }

    private void bJL() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.fRN.fRW == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.fRN.fRW.get(1);
            i2 = this.fRN.fRW.get(2);
            i3 = this.fRN.fRW.get(5);
            i4 = this.fRN.fRW.get(11);
            i5 = this.fRN.fRW.get(12);
            i6 = this.fRN.fRW.get(13);
        }
        this.fSZ.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bJM();
        }
        dismiss();
    }

    public void bJM() {
        if (this.fRN.fRO != null) {
            try {
                this.fRN.fRO.a(c.dateFormat.parse(this.fSZ.getTime()), this.fSV);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bJH() {
        return this.fRN.fSC;
    }
}
