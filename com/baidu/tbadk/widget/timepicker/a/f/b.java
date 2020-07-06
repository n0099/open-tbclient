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
    private c eRl;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.ePZ = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        blT();
        initViews();
        Bz();
        if (this.ePZ.eQc == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.eRc);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.ePZ.eQD) ? context.getResources().getString(R.string.pickerview_submit) : this.ePZ.eQD);
            button2.setText(TextUtils.isEmpty(this.ePZ.eQE) ? context.getResources().getString(R.string.pickerview_cancel) : this.ePZ.eQE);
            textView.setText(TextUtils.isEmpty(this.ePZ.eQF) ? "" : this.ePZ.eQF);
            button.setTextColor(this.ePZ.eQG);
            button2.setTextColor(this.ePZ.eQH);
            textView.setTextColor(this.ePZ.eQI);
            relativeLayout.setBackgroundColor(this.ePZ.eQK);
            button.setTextSize(this.ePZ.eQL);
            button2.setTextSize(this.ePZ.eQL);
            textView.setTextSize(this.ePZ.eQM);
        } else {
            this.ePZ.eQc.be(LayoutInflater.from(context).inflate(this.ePZ.eQB, this.eRc));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.ePZ.eQJ);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.eRl = new c(linearLayout, this.ePZ.eQh, this.ePZ.eQC, this.ePZ.eQN);
        if (this.ePZ.eQb != null) {
            this.eRl.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void blS() {
                    try {
                        b.this.ePZ.eQb.n(c.dateFormat.parse(b.this.eRl.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.eRl.ja(this.ePZ.eQo);
        if (this.ePZ.eQl != 0 && this.ePZ.eQm != 0 && this.ePZ.eQl <= this.ePZ.eQm) {
            blV();
        }
        if (this.ePZ.eQj != null && this.ePZ.eQk != null) {
            if (this.ePZ.eQj.getTimeInMillis() > this.ePZ.eQk.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            blW();
        } else if (this.ePZ.eQj != null) {
            if (this.ePZ.eQj.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            blW();
        } else if (this.ePZ.eQk != null) {
            if (this.ePZ.eQk.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            blW();
        } else {
            blW();
        }
        blY();
        this.eRl.c(this.ePZ.eQp, this.ePZ.eQq, this.ePZ.eQr, this.ePZ.eQs, this.ePZ.eQt, this.ePZ.eQu);
        this.eRl.j(this.ePZ.eQv, this.ePZ.eQw, this.ePZ.eQx, this.ePZ.eQy, this.ePZ.eQz, this.ePZ.eQA);
        iZ(this.ePZ.eQP);
        this.eRl.setCyclic(this.ePZ.eQn);
        this.eRl.setDividerColor(this.ePZ.dividerColor);
        this.eRl.setDividerType(this.ePZ.eQR);
        this.eRl.setLineSpacingMultiplier(this.ePZ.lineSpacingMultiplier);
        this.eRl.setTextColorOut(this.ePZ.textColorOut);
        this.eRl.setTextColorCenter(this.ePZ.textColorCenter);
        this.eRl.isCenterLabel(this.ePZ.isCenterLabel);
    }

    private void blV() {
        this.eRl.pg(this.ePZ.eQl);
        this.eRl.ph(this.ePZ.eQm);
    }

    private void blW() {
        this.eRl.a(this.ePZ.eQj, this.ePZ.eQk);
        blX();
    }

    private void blX() {
        if (this.ePZ.eQj != null && this.ePZ.eQk != null) {
            if (this.ePZ.eQi == null || this.ePZ.eQi.getTimeInMillis() < this.ePZ.eQj.getTimeInMillis() || this.ePZ.eQi.getTimeInMillis() > this.ePZ.eQk.getTimeInMillis()) {
                this.ePZ.eQi = this.ePZ.eQj;
            }
        } else if (this.ePZ.eQj != null) {
            this.ePZ.eQi = this.ePZ.eQj;
        } else if (this.ePZ.eQk != null) {
            this.ePZ.eQi = this.ePZ.eQk;
        }
    }

    private void blY() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.ePZ.eQi == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.ePZ.eQi.get(1);
            i2 = this.ePZ.eQi.get(2);
            i3 = this.ePZ.eQi.get(5);
            i4 = this.ePZ.eQi.get(11);
            i5 = this.ePZ.eQi.get(12);
            i6 = this.ePZ.eQi.get(13);
        }
        this.eRl.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            blZ();
        }
        dismiss();
    }

    public void blZ() {
        if (this.ePZ.eQa != null) {
            try {
                this.ePZ.eQa.a(c.dateFormat.parse(this.eRl.getTime()), this.eRh);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean blU() {
        return this.ePZ.eQO;
    }
}
