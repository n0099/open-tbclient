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
    private c fXT;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.fWJ = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        bIh();
        initViews();
        GS();
        if (this.fWJ.fWM == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.fXK);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.fWJ.fXn) ? context.getResources().getString(R.string.pickerview_submit) : this.fWJ.fXn);
            button2.setText(TextUtils.isEmpty(this.fWJ.fXo) ? context.getResources().getString(R.string.pickerview_cancel) : this.fWJ.fXo);
            textView.setText(TextUtils.isEmpty(this.fWJ.fXp) ? "" : this.fWJ.fXp);
            button.setTextColor(this.fWJ.fXq);
            button2.setTextColor(this.fWJ.fXr);
            textView.setTextColor(this.fWJ.fXs);
            relativeLayout.setBackgroundColor(this.fWJ.fXu);
            button.setTextSize(this.fWJ.fXv);
            button2.setTextSize(this.fWJ.fXv);
            textView.setTextSize(this.fWJ.fXw);
        } else {
            this.fWJ.fWM.bM(LayoutInflater.from(context).inflate(this.fWJ.fXl, this.fXK));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.fWJ.fXt);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.fXT = new c(linearLayout, this.fWJ.fWR, this.fWJ.fXm, this.fWJ.fXx);
        if (this.fWJ.fWL != null) {
            this.fXT.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bIg() {
                    try {
                        b.this.fWJ.fWL.q(c.dateFormat.parse(b.this.fXT.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.fXT.lN(this.fWJ.fWY);
        if (this.fWJ.fWV != 0 && this.fWJ.fWW != 0 && this.fWJ.fWV <= this.fWJ.fWW) {
            bIj();
        }
        if (this.fWJ.fWT != null && this.fWJ.fWU != null) {
            if (this.fWJ.fWT.getTimeInMillis() > this.fWJ.fWU.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bIk();
        } else if (this.fWJ.fWT != null) {
            if (this.fWJ.fWT.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bIk();
        } else if (this.fWJ.fWU != null) {
            if (this.fWJ.fWU.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bIk();
        } else {
            bIk();
        }
        bIm();
        this.fXT.e(this.fWJ.fWZ, this.fWJ.fXa, this.fWJ.fXb, this.fWJ.fXc, this.fWJ.fXd, this.fWJ.fXe);
        this.fXT.k(this.fWJ.fXf, this.fWJ.fXg, this.fWJ.fXh, this.fWJ.fXi, this.fWJ.fXj, this.fWJ.fXk);
        lM(this.fWJ.cancelable);
        this.fXT.setCyclic(this.fWJ.fWX);
        this.fXT.setDividerColor(this.fWJ.dyj);
        this.fXT.setDividerType(this.fWJ.fXz);
        this.fXT.setLineSpacingMultiplier(this.fWJ.dyk);
        this.fXT.setTextColorOut(this.fWJ.dyh);
        this.fXT.setTextColorCenter(this.fWJ.dyi);
        this.fXT.lO(this.fWJ.dxU);
    }

    private void bIj() {
        this.fXT.sz(this.fWJ.fWV);
        this.fXT.sA(this.fWJ.fWW);
    }

    private void bIk() {
        this.fXT.a(this.fWJ.fWT, this.fWJ.fWU);
        bIl();
    }

    private void bIl() {
        if (this.fWJ.fWT != null && this.fWJ.fWU != null) {
            if (this.fWJ.fWS == null || this.fWJ.fWS.getTimeInMillis() < this.fWJ.fWT.getTimeInMillis() || this.fWJ.fWS.getTimeInMillis() > this.fWJ.fWU.getTimeInMillis()) {
                this.fWJ.fWS = this.fWJ.fWT;
            }
        } else if (this.fWJ.fWT != null) {
            this.fWJ.fWS = this.fWJ.fWT;
        } else if (this.fWJ.fWU != null) {
            this.fWJ.fWS = this.fWJ.fWU;
        }
    }

    private void bIm() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.fWJ.fWS == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.fWJ.fWS.get(1);
            i2 = this.fWJ.fWS.get(2);
            i3 = this.fWJ.fWS.get(5);
            i4 = this.fWJ.fWS.get(11);
            i5 = this.fWJ.fWS.get(12);
            i6 = this.fWJ.fWS.get(13);
        }
        this.fXT.i(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bIn();
        }
        dismiss();
    }

    public void bIn() {
        if (this.fWJ.fWK != null) {
            try {
                this.fWJ.fWK.a(c.dateFormat.parse(this.fXT.getTime()), this.fXP);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bIi() {
        return this.fWJ.fXy;
    }
}
