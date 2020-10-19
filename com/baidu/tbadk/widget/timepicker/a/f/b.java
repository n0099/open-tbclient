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
    private c fxA;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.fwo = aVar;
        dQ(aVar.context);
    }

    private void dQ(Context context) {
        bCv();
        initViews();
        Jd();
        if (this.fwo.fwr == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.fxr);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.fwo.fwS) ? context.getResources().getString(R.string.pickerview_submit) : this.fwo.fwS);
            button2.setText(TextUtils.isEmpty(this.fwo.fwT) ? context.getResources().getString(R.string.pickerview_cancel) : this.fwo.fwT);
            textView.setText(TextUtils.isEmpty(this.fwo.fwU) ? "" : this.fwo.fwU);
            button.setTextColor(this.fwo.fwV);
            button2.setTextColor(this.fwo.fwW);
            textView.setTextColor(this.fwo.fwX);
            relativeLayout.setBackgroundColor(this.fwo.fwZ);
            button.setTextSize(this.fwo.fxa);
            button2.setTextSize(this.fwo.fxa);
            textView.setTextSize(this.fwo.fxb);
        } else {
            this.fwo.fwr.bs(LayoutInflater.from(context).inflate(this.fwo.fwQ, this.fxr));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.fwo.fwY);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.fxA = new c(linearLayout, this.fwo.fww, this.fwo.fwR, this.fwo.fxc);
        if (this.fwo.fwq != null) {
            this.fxA.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bCu() {
                    try {
                        b.this.fwo.fwq.q(c.dateFormat.parse(b.this.fxA.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.fxA.kE(this.fwo.fwD);
        if (this.fwo.fwA != 0 && this.fwo.fwB != 0 && this.fwo.fwA <= this.fwo.fwB) {
            bCx();
        }
        if (this.fwo.fwy != null && this.fwo.fwz != null) {
            if (this.fwo.fwy.getTimeInMillis() > this.fwo.fwz.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bCy();
        } else if (this.fwo.fwy != null) {
            if (this.fwo.fwy.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bCy();
        } else if (this.fwo.fwz != null) {
            if (this.fwo.fwz.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bCy();
        } else {
            bCy();
        }
        bCA();
        this.fxA.c(this.fwo.fwE, this.fwo.fwF, this.fwo.fwG, this.fwo.fwH, this.fwo.fwI, this.fwo.fwJ);
        this.fxA.i(this.fwo.fwK, this.fwo.fwL, this.fwo.fwM, this.fwo.fwN, this.fwo.fwO, this.fwo.fwP);
        kD(this.fwo.fxe);
        this.fxA.setCyclic(this.fwo.fwC);
        this.fxA.setDividerColor(this.fwo.dividerColor);
        this.fxA.setDividerType(this.fwo.fxg);
        this.fxA.setLineSpacingMultiplier(this.fwo.lineSpacingMultiplier);
        this.fxA.setTextColorOut(this.fwo.textColorOut);
        this.fxA.setTextColorCenter(this.fwo.textColorCenter);
        this.fxA.isCenterLabel(this.fwo.isCenterLabel);
    }

    private void bCx() {
        this.fxA.sy(this.fwo.fwA);
        this.fxA.sz(this.fwo.fwB);
    }

    private void bCy() {
        this.fxA.a(this.fwo.fwy, this.fwo.fwz);
        bCz();
    }

    private void bCz() {
        if (this.fwo.fwy != null && this.fwo.fwz != null) {
            if (this.fwo.fwx == null || this.fwo.fwx.getTimeInMillis() < this.fwo.fwy.getTimeInMillis() || this.fwo.fwx.getTimeInMillis() > this.fwo.fwz.getTimeInMillis()) {
                this.fwo.fwx = this.fwo.fwy;
            }
        } else if (this.fwo.fwy != null) {
            this.fwo.fwx = this.fwo.fwy;
        } else if (this.fwo.fwz != null) {
            this.fwo.fwx = this.fwo.fwz;
        }
    }

    private void bCA() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.fwo.fwx == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.fwo.fwx.get(1);
            i2 = this.fwo.fwx.get(2);
            i3 = this.fwo.fwx.get(5);
            i4 = this.fwo.fwx.get(11);
            i5 = this.fwo.fwx.get(12);
            i6 = this.fwo.fwx.get(13);
        }
        this.fxA.g(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bCB();
        }
        dismiss();
    }

    public void bCB() {
        if (this.fwo.fwp != null) {
            try {
                this.fwo.fwp.a(c.dateFormat.parse(this.fxA.getTime()), this.fxw);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bCw() {
        return this.fwo.fxd;
    }
}
