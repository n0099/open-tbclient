package com.baidu.tbadk.widget.timepicker.a.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tieba.R;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class b extends a implements View.OnClickListener {
    private c dSl;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.dQZ = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        aUY();
        initViews();
        vm();
        if (this.dQZ.dRc == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.dSc);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(UgcUBCUtils.UGC_TIME_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.dQZ.dRD) ? context.getResources().getString(R.string.pickerview_submit) : this.dQZ.dRD);
            button2.setText(TextUtils.isEmpty(this.dQZ.dRE) ? context.getResources().getString(R.string.pickerview_cancel) : this.dQZ.dRE);
            textView.setText(TextUtils.isEmpty(this.dQZ.dRF) ? "" : this.dQZ.dRF);
            button.setTextColor(this.dQZ.dRG);
            button2.setTextColor(this.dQZ.dRH);
            textView.setTextColor(this.dQZ.dRI);
            relativeLayout.setBackgroundColor(this.dQZ.dRK);
            button.setTextSize(this.dQZ.dRL);
            button2.setTextSize(this.dQZ.dRL);
            textView.setTextSize(this.dQZ.dRM);
        } else {
            this.dQZ.dRc.bc(LayoutInflater.from(context).inflate(this.dQZ.dRB, this.dSc));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.dQZ.dRJ);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.dSl = new c(linearLayout, this.dQZ.dRh, this.dQZ.dRC, this.dQZ.dRN);
        if (this.dQZ.dRb != null) {
            this.dSl.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void aUX() {
                    try {
                        b.this.dQZ.dRb.m(c.dateFormat.parse(b.this.dSl.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.dSl.ht(this.dQZ.dRo);
        if (this.dQZ.dRl != 0 && this.dQZ.dRm != 0 && this.dQZ.dRl <= this.dQZ.dRm) {
            aVa();
        }
        if (this.dQZ.dRj != null && this.dQZ.dRk != null) {
            if (this.dQZ.dRj.getTimeInMillis() > this.dQZ.dRk.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aVb();
        } else if (this.dQZ.dRj != null) {
            if (this.dQZ.dRj.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aVb();
        } else if (this.dQZ.dRk != null) {
            if (this.dQZ.dRk.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aVb();
        } else {
            aVb();
        }
        aVd();
        this.dSl.c(this.dQZ.dRp, this.dQZ.dRq, this.dQZ.dRr, this.dQZ.dRs, this.dQZ.dRt, this.dQZ.dRu);
        this.dSl.j(this.dQZ.dRv, this.dQZ.dRw, this.dQZ.dRx, this.dQZ.dRy, this.dQZ.dRz, this.dQZ.dRA);
        hs(this.dQZ.dRP);
        this.dSl.setCyclic(this.dQZ.dRn);
        this.dSl.setDividerColor(this.dQZ.dividerColor);
        this.dSl.setDividerType(this.dQZ.dRR);
        this.dSl.setLineSpacingMultiplier(this.dQZ.lineSpacingMultiplier);
        this.dSl.setTextColorOut(this.dQZ.textColorOut);
        this.dSl.setTextColorCenter(this.dQZ.textColorCenter);
        this.dSl.isCenterLabel(this.dQZ.isCenterLabel);
    }

    private void aVa() {
        this.dSl.nO(this.dQZ.dRl);
        this.dSl.nP(this.dQZ.dRm);
    }

    private void aVb() {
        this.dSl.a(this.dQZ.dRj, this.dQZ.dRk);
        aVc();
    }

    private void aVc() {
        if (this.dQZ.dRj != null && this.dQZ.dRk != null) {
            if (this.dQZ.dRi == null || this.dQZ.dRi.getTimeInMillis() < this.dQZ.dRj.getTimeInMillis() || this.dQZ.dRi.getTimeInMillis() > this.dQZ.dRk.getTimeInMillis()) {
                this.dQZ.dRi = this.dQZ.dRj;
            }
        } else if (this.dQZ.dRj != null) {
            this.dQZ.dRi = this.dQZ.dRj;
        } else if (this.dQZ.dRk != null) {
            this.dQZ.dRi = this.dQZ.dRk;
        }
    }

    private void aVd() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.dQZ.dRi == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.dQZ.dRi.get(1);
            i2 = this.dQZ.dRi.get(2);
            i3 = this.dQZ.dRi.get(5);
            i4 = this.dQZ.dRi.get(11);
            i5 = this.dQZ.dRi.get(12);
            i6 = this.dQZ.dRi.get(13);
        }
        this.dSl.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            aVe();
        }
        dismiss();
    }

    public void aVe() {
        if (this.dQZ.dRa != null) {
            try {
                this.dQZ.dRa.a(c.dateFormat.parse(this.dSl.getTime()), this.dSh);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean aUZ() {
        return this.dQZ.dRO;
    }
}
