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
/* loaded from: classes.dex */
public class b extends a implements View.OnClickListener {
    private c gaj;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.fYZ = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        bIA();
        initViews();
        Ii();
        if (this.fYZ.fZc == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.gaa);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.fYZ.fZD) ? context.getResources().getString(R.string.pickerview_submit) : this.fYZ.fZD);
            button2.setText(TextUtils.isEmpty(this.fYZ.fZE) ? context.getResources().getString(R.string.pickerview_cancel) : this.fYZ.fZE);
            textView.setText(TextUtils.isEmpty(this.fYZ.fZF) ? "" : this.fYZ.fZF);
            button.setTextColor(this.fYZ.fZG);
            button2.setTextColor(this.fYZ.fZH);
            textView.setTextColor(this.fYZ.fZI);
            relativeLayout.setBackgroundColor(this.fYZ.fZK);
            button.setTextSize(this.fYZ.fZL);
            button2.setTextSize(this.fYZ.fZL);
            textView.setTextSize(this.fYZ.fZM);
        } else {
            this.fYZ.fZc.bI(LayoutInflater.from(context).inflate(this.fYZ.fZB, this.gaa));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.fYZ.fZJ);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.gaj = new c(linearLayout, this.fYZ.fZh, this.fYZ.fZC, this.fYZ.fZN);
        if (this.fYZ.fZb != null) {
            this.gaj.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bIz() {
                    try {
                        b.this.fYZ.fZb.q(c.dateFormat.parse(b.this.gaj.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.gaj.lR(this.fYZ.fZo);
        if (this.fYZ.fZl != 0 && this.fYZ.fZm != 0 && this.fYZ.fZl <= this.fYZ.fZm) {
            bIC();
        }
        if (this.fYZ.fZj != null && this.fYZ.fZk != null) {
            if (this.fYZ.fZj.getTimeInMillis() > this.fYZ.fZk.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bID();
        } else if (this.fYZ.fZj != null) {
            if (this.fYZ.fZj.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bID();
        } else if (this.fYZ.fZk != null) {
            if (this.fYZ.fZk.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bID();
        } else {
            bID();
        }
        bIF();
        this.gaj.e(this.fYZ.fZp, this.fYZ.fZq, this.fYZ.fZr, this.fYZ.fZs, this.fYZ.fZt, this.fYZ.fZu);
        this.gaj.k(this.fYZ.fZv, this.fYZ.fZw, this.fYZ.fZx, this.fYZ.fZy, this.fYZ.fZz, this.fYZ.fZA);
        lQ(this.fYZ.cancelable);
        this.gaj.setCyclic(this.fYZ.fZn);
        this.gaj.setDividerColor(this.fYZ.dAo);
        this.gaj.setDividerType(this.fYZ.fZP);
        this.gaj.setLineSpacingMultiplier(this.fYZ.dAp);
        this.gaj.setTextColorOut(this.fYZ.dAm);
        this.gaj.setTextColorCenter(this.fYZ.dAn);
        this.gaj.lS(this.fYZ.dzZ);
    }

    private void bIC() {
        this.gaj.sE(this.fYZ.fZl);
        this.gaj.sF(this.fYZ.fZm);
    }

    private void bID() {
        this.gaj.a(this.fYZ.fZj, this.fYZ.fZk);
        bIE();
    }

    private void bIE() {
        if (this.fYZ.fZj != null && this.fYZ.fZk != null) {
            if (this.fYZ.fZi == null || this.fYZ.fZi.getTimeInMillis() < this.fYZ.fZj.getTimeInMillis() || this.fYZ.fZi.getTimeInMillis() > this.fYZ.fZk.getTimeInMillis()) {
                this.fYZ.fZi = this.fYZ.fZj;
            }
        } else if (this.fYZ.fZj != null) {
            this.fYZ.fZi = this.fYZ.fZj;
        } else if (this.fYZ.fZk != null) {
            this.fYZ.fZi = this.fYZ.fZk;
        }
    }

    private void bIF() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.fYZ.fZi == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.fYZ.fZi.get(1);
            i2 = this.fYZ.fZi.get(2);
            i3 = this.fYZ.fZi.get(5);
            i4 = this.fYZ.fZi.get(11);
            i5 = this.fYZ.fZi.get(12);
            i6 = this.fYZ.fZi.get(13);
        }
        this.gaj.i(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bIG();
        }
        dismiss();
    }

    public void bIG() {
        if (this.fYZ.fZa != null) {
            try {
                this.fYZ.fZa.a(c.dateFormat.parse(this.gaj.getTime()), this.gaf);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bIB() {
        return this.fYZ.fZO;
    }
}
