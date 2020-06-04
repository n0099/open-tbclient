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
    private c eGZ;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.eFN = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        bjt();
        initViews();
        AZ();
        if (this.eFN.eFQ == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.eGQ);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.eFN.eGr) ? context.getResources().getString(R.string.pickerview_submit) : this.eFN.eGr);
            button2.setText(TextUtils.isEmpty(this.eFN.eGs) ? context.getResources().getString(R.string.pickerview_cancel) : this.eFN.eGs);
            textView.setText(TextUtils.isEmpty(this.eFN.eGt) ? "" : this.eFN.eGt);
            button.setTextColor(this.eFN.eGu);
            button2.setTextColor(this.eFN.eGv);
            textView.setTextColor(this.eFN.eGw);
            relativeLayout.setBackgroundColor(this.eFN.eGy);
            button.setTextSize(this.eFN.eGz);
            button2.setTextSize(this.eFN.eGz);
            textView.setTextSize(this.eFN.eGA);
        } else {
            this.eFN.eFQ.be(LayoutInflater.from(context).inflate(this.eFN.eGp, this.eGQ));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.eFN.eGx);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.eGZ = new c(linearLayout, this.eFN.eFV, this.eFN.eGq, this.eFN.eGB);
        if (this.eFN.eFP != null) {
            this.eGZ.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bjs() {
                    try {
                        b.this.eFN.eFP.n(c.dateFormat.parse(b.this.eGZ.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.eGZ.iO(this.eFN.eGc);
        if (this.eFN.eFZ != 0 && this.eFN.eGa != 0 && this.eFN.eFZ <= this.eFN.eGa) {
            bjv();
        }
        if (this.eFN.eFX != null && this.eFN.eFY != null) {
            if (this.eFN.eFX.getTimeInMillis() > this.eFN.eFY.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bjw();
        } else if (this.eFN.eFX != null) {
            if (this.eFN.eFX.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bjw();
        } else if (this.eFN.eFY != null) {
            if (this.eFN.eFY.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bjw();
        } else {
            bjw();
        }
        bjy();
        this.eGZ.c(this.eFN.eGd, this.eFN.eGe, this.eFN.eGf, this.eFN.eGg, this.eFN.eGh, this.eFN.eGi);
        this.eGZ.j(this.eFN.eGj, this.eFN.eGk, this.eFN.eGl, this.eFN.eGm, this.eFN.eGn, this.eFN.eGo);
        iN(this.eFN.eGD);
        this.eGZ.setCyclic(this.eFN.eGb);
        this.eGZ.setDividerColor(this.eFN.dividerColor);
        this.eGZ.setDividerType(this.eFN.eGF);
        this.eGZ.setLineSpacingMultiplier(this.eFN.lineSpacingMultiplier);
        this.eGZ.setTextColorOut(this.eFN.textColorOut);
        this.eGZ.setTextColorCenter(this.eFN.textColorCenter);
        this.eGZ.isCenterLabel(this.eFN.isCenterLabel);
    }

    private void bjv() {
        this.eGZ.oI(this.eFN.eFZ);
        this.eGZ.oJ(this.eFN.eGa);
    }

    private void bjw() {
        this.eGZ.a(this.eFN.eFX, this.eFN.eFY);
        bjx();
    }

    private void bjx() {
        if (this.eFN.eFX != null && this.eFN.eFY != null) {
            if (this.eFN.eFW == null || this.eFN.eFW.getTimeInMillis() < this.eFN.eFX.getTimeInMillis() || this.eFN.eFW.getTimeInMillis() > this.eFN.eFY.getTimeInMillis()) {
                this.eFN.eFW = this.eFN.eFX;
            }
        } else if (this.eFN.eFX != null) {
            this.eFN.eFW = this.eFN.eFX;
        } else if (this.eFN.eFY != null) {
            this.eFN.eFW = this.eFN.eFY;
        }
    }

    private void bjy() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.eFN.eFW == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.eFN.eFW.get(1);
            i2 = this.eFN.eFW.get(2);
            i3 = this.eFN.eFW.get(5);
            i4 = this.eFN.eFW.get(11);
            i5 = this.eFN.eFW.get(12);
            i6 = this.eFN.eFW.get(13);
        }
        this.eGZ.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bjz();
        }
        dismiss();
    }

    public void bjz() {
        if (this.eFN.eFO != null) {
            try {
                this.eFN.eFO.a(c.dateFormat.parse(this.eGZ.getTime()), this.eGV);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bju() {
        return this.eFN.eGC;
    }
}
