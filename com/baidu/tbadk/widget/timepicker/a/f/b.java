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
    private c eGO;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.eFC = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        bjr();
        initViews();
        AZ();
        if (this.eFC.eFF == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.eGF);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.eFC.eGg) ? context.getResources().getString(R.string.pickerview_submit) : this.eFC.eGg);
            button2.setText(TextUtils.isEmpty(this.eFC.eGh) ? context.getResources().getString(R.string.pickerview_cancel) : this.eFC.eGh);
            textView.setText(TextUtils.isEmpty(this.eFC.eGi) ? "" : this.eFC.eGi);
            button.setTextColor(this.eFC.eGj);
            button2.setTextColor(this.eFC.eGk);
            textView.setTextColor(this.eFC.eGl);
            relativeLayout.setBackgroundColor(this.eFC.eGn);
            button.setTextSize(this.eFC.eGo);
            button2.setTextSize(this.eFC.eGo);
            textView.setTextSize(this.eFC.eGp);
        } else {
            this.eFC.eFF.be(LayoutInflater.from(context).inflate(this.eFC.eGe, this.eGF));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.eFC.eGm);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.eGO = new c(linearLayout, this.eFC.eFK, this.eFC.eGf, this.eFC.eGq);
        if (this.eFC.eFE != null) {
            this.eGO.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bjq() {
                    try {
                        b.this.eFC.eFE.n(c.dateFormat.parse(b.this.eGO.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.eGO.iO(this.eFC.eFR);
        if (this.eFC.eFO != 0 && this.eFC.eFP != 0 && this.eFC.eFO <= this.eFC.eFP) {
            bjt();
        }
        if (this.eFC.eFM != null && this.eFC.eFN != null) {
            if (this.eFC.eFM.getTimeInMillis() > this.eFC.eFN.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bju();
        } else if (this.eFC.eFM != null) {
            if (this.eFC.eFM.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bju();
        } else if (this.eFC.eFN != null) {
            if (this.eFC.eFN.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bju();
        } else {
            bju();
        }
        bjw();
        this.eGO.c(this.eFC.eFS, this.eFC.eFT, this.eFC.eFU, this.eFC.eFV, this.eFC.eFW, this.eFC.eFX);
        this.eGO.j(this.eFC.eFY, this.eFC.eFZ, this.eFC.eGa, this.eFC.eGb, this.eFC.eGc, this.eFC.eGd);
        iN(this.eFC.eGs);
        this.eGO.setCyclic(this.eFC.eFQ);
        this.eGO.setDividerColor(this.eFC.dividerColor);
        this.eGO.setDividerType(this.eFC.eGu);
        this.eGO.setLineSpacingMultiplier(this.eFC.lineSpacingMultiplier);
        this.eGO.setTextColorOut(this.eFC.textColorOut);
        this.eGO.setTextColorCenter(this.eFC.textColorCenter);
        this.eGO.isCenterLabel(this.eFC.isCenterLabel);
    }

    private void bjt() {
        this.eGO.oG(this.eFC.eFO);
        this.eGO.oH(this.eFC.eFP);
    }

    private void bju() {
        this.eGO.a(this.eFC.eFM, this.eFC.eFN);
        bjv();
    }

    private void bjv() {
        if (this.eFC.eFM != null && this.eFC.eFN != null) {
            if (this.eFC.eFL == null || this.eFC.eFL.getTimeInMillis() < this.eFC.eFM.getTimeInMillis() || this.eFC.eFL.getTimeInMillis() > this.eFC.eFN.getTimeInMillis()) {
                this.eFC.eFL = this.eFC.eFM;
            }
        } else if (this.eFC.eFM != null) {
            this.eFC.eFL = this.eFC.eFM;
        } else if (this.eFC.eFN != null) {
            this.eFC.eFL = this.eFC.eFN;
        }
    }

    private void bjw() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.eFC.eFL == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.eFC.eFL.get(1);
            i2 = this.eFC.eFL.get(2);
            i3 = this.eFC.eFL.get(5);
            i4 = this.eFC.eFL.get(11);
            i5 = this.eFC.eFL.get(12);
            i6 = this.eFC.eFL.get(13);
        }
        this.eGO.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bjx();
        }
        dismiss();
    }

    public void bjx() {
        if (this.eFC.eFD != null) {
            try {
                this.eFC.eFD.a(c.dateFormat.parse(this.eGO.getTime()), this.eGK);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bjs() {
        return this.eFC.eGr;
    }
}
