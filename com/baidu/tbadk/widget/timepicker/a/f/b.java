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
    private c cZG;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.cYm = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        aAl();
        initViews();
        rJ();
        if (this.cYm.cYp == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.cZu);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.cYm.cYQ) ? context.getResources().getString(R.string.pickerview_submit) : this.cYm.cYQ);
            button2.setText(TextUtils.isEmpty(this.cYm.cYR) ? context.getResources().getString(R.string.pickerview_cancel) : this.cYm.cYR);
            textView.setText(TextUtils.isEmpty(this.cYm.cYS) ? "" : this.cYm.cYS);
            button.setTextColor(this.cYm.cYT);
            button2.setTextColor(this.cYm.cYU);
            textView.setTextColor(this.cYm.cYV);
            relativeLayout.setBackgroundColor(this.cYm.cYX);
            button.setTextSize(this.cYm.cYY);
            button2.setTextSize(this.cYm.cYY);
            textView.setTextSize(this.cYm.cYZ);
        } else {
            this.cYm.cYp.bb(LayoutInflater.from(context).inflate(this.cYm.cYO, this.cZu));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.cYm.cYW);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.cZG = new c(linearLayout, this.cYm.cYu, this.cYm.cYP, this.cYm.cZa);
        if (this.cYm.cYo != null) {
            this.cZG.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void aAh() {
                    try {
                        b.this.cYm.cYo.k(c.cZI.parse(b.this.cZG.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.cZG.fR(this.cYm.cYB);
        if (this.cYm.cYy != 0 && this.cYm.cYz != 0 && this.cYm.cYy <= this.cYm.cYz) {
            aAo();
        }
        if (this.cYm.cYw != null && this.cYm.cYx != null) {
            if (this.cYm.cYw.getTimeInMillis() > this.cYm.cYx.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aAp();
        } else if (this.cYm.cYw != null) {
            if (this.cYm.cYw.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aAp();
        } else if (this.cYm.cYx != null) {
            if (this.cYm.cYx.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aAp();
        } else {
            aAp();
        }
        aAr();
        this.cZG.c(this.cYm.cYC, this.cYm.cYD, this.cYm.cYE, this.cYm.cYF, this.cYm.cYG, this.cYm.cYH);
        this.cZG.i(this.cYm.cYI, this.cYm.cYJ, this.cYm.cYK, this.cYm.cYL, this.cYm.cYM, this.cYm.cYN);
        fQ(this.cYm.cZg);
        this.cZG.setCyclic(this.cYm.cYA);
        this.cZG.setDividerColor(this.cYm.cZd);
        this.cZG.setDividerType(this.cYm.cZj);
        this.cZG.setLineSpacingMultiplier(this.cYm.cZe);
        this.cZG.setTextColorOut(this.cYm.cZb);
        this.cZG.setTextColorCenter(this.cYm.cZc);
        this.cZG.fS(this.cYm.cZh);
    }

    private void aAo() {
        this.cZG.lg(this.cYm.cYy);
        this.cZG.lh(this.cYm.cYz);
    }

    private void aAp() {
        this.cZG.a(this.cYm.cYw, this.cYm.cYx);
        aAq();
    }

    private void aAq() {
        if (this.cYm.cYw != null && this.cYm.cYx != null) {
            if (this.cYm.cYv == null || this.cYm.cYv.getTimeInMillis() < this.cYm.cYw.getTimeInMillis() || this.cYm.cYv.getTimeInMillis() > this.cYm.cYx.getTimeInMillis()) {
                this.cYm.cYv = this.cYm.cYw;
            }
        } else if (this.cYm.cYw != null) {
            this.cYm.cYv = this.cYm.cYw;
        } else if (this.cYm.cYx != null) {
            this.cYm.cYv = this.cYm.cYx;
        }
    }

    private void aAr() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.cYm.cYv == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.cYm.cYv.get(1);
            i2 = this.cYm.cYv.get(2);
            i3 = this.cYm.cYv.get(5);
            i4 = this.cYm.cYv.get(11);
            i5 = this.cYm.cYv.get(12);
            i6 = this.cYm.cYv.get(13);
        }
        this.cZG.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            aAs();
        }
        dismiss();
    }

    public void aAs() {
        if (this.cYm.cYn != null) {
            try {
                this.cYm.cYn.a(c.cZI.parse(this.cZG.getTime()), this.cZB);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean aAn() {
        return this.cYm.cZf;
    }
}
