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
    private c gbK;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.gaA = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        bIE();
        initViews();
        Il();
        if (this.gaA.gaD == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.gbB);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.gaA.gbe) ? context.getResources().getString(R.string.pickerview_submit) : this.gaA.gbe);
            button2.setText(TextUtils.isEmpty(this.gaA.gbf) ? context.getResources().getString(R.string.pickerview_cancel) : this.gaA.gbf);
            textView.setText(TextUtils.isEmpty(this.gaA.gbg) ? "" : this.gaA.gbg);
            button.setTextColor(this.gaA.gbh);
            button2.setTextColor(this.gaA.gbi);
            textView.setTextColor(this.gaA.gbj);
            relativeLayout.setBackgroundColor(this.gaA.gbl);
            button.setTextSize(this.gaA.gbm);
            button2.setTextSize(this.gaA.gbm);
            textView.setTextSize(this.gaA.gbn);
        } else {
            this.gaA.gaD.bI(LayoutInflater.from(context).inflate(this.gaA.gbc, this.gbB));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.gaA.gbk);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.gbK = new c(linearLayout, this.gaA.gaI, this.gaA.gbd, this.gaA.gbo);
        if (this.gaA.gaC != null) {
            this.gbK.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bID() {
                    try {
                        b.this.gaA.gaC.q(c.dateFormat.parse(b.this.gbK.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.gbK.lR(this.gaA.gaP);
        if (this.gaA.gaM != 0 && this.gaA.gaN != 0 && this.gaA.gaM <= this.gaA.gaN) {
            bIG();
        }
        if (this.gaA.gaK != null && this.gaA.gaL != null) {
            if (this.gaA.gaK.getTimeInMillis() > this.gaA.gaL.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bIH();
        } else if (this.gaA.gaK != null) {
            if (this.gaA.gaK.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bIH();
        } else if (this.gaA.gaL != null) {
            if (this.gaA.gaL.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bIH();
        } else {
            bIH();
        }
        bIJ();
        this.gbK.e(this.gaA.gaQ, this.gaA.gaR, this.gaA.gaS, this.gaA.gaT, this.gaA.gaU, this.gaA.gaV);
        this.gbK.k(this.gaA.gaW, this.gaA.gaX, this.gaA.gaY, this.gaA.gaZ, this.gaA.gba, this.gaA.gbb);
        lQ(this.gaA.cancelable);
        this.gbK.setCyclic(this.gaA.gaO);
        this.gbK.setDividerColor(this.gaA.dBP);
        this.gbK.setDividerType(this.gaA.gbq);
        this.gbK.setLineSpacingMultiplier(this.gaA.dBQ);
        this.gbK.setTextColorOut(this.gaA.dBN);
        this.gbK.setTextColorCenter(this.gaA.dBO);
        this.gbK.lS(this.gaA.dBA);
    }

    private void bIG() {
        this.gbK.sG(this.gaA.gaM);
        this.gbK.sH(this.gaA.gaN);
    }

    private void bIH() {
        this.gbK.a(this.gaA.gaK, this.gaA.gaL);
        bII();
    }

    private void bII() {
        if (this.gaA.gaK != null && this.gaA.gaL != null) {
            if (this.gaA.gaJ == null || this.gaA.gaJ.getTimeInMillis() < this.gaA.gaK.getTimeInMillis() || this.gaA.gaJ.getTimeInMillis() > this.gaA.gaL.getTimeInMillis()) {
                this.gaA.gaJ = this.gaA.gaK;
            }
        } else if (this.gaA.gaK != null) {
            this.gaA.gaJ = this.gaA.gaK;
        } else if (this.gaA.gaL != null) {
            this.gaA.gaJ = this.gaA.gaL;
        }
    }

    private void bIJ() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.gaA.gaJ == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.gaA.gaJ.get(1);
            i2 = this.gaA.gaJ.get(2);
            i3 = this.gaA.gaJ.get(5);
            i4 = this.gaA.gaJ.get(11);
            i5 = this.gaA.gaJ.get(12);
            i6 = this.gaA.gaJ.get(13);
        }
        this.gbK.i(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bIK();
        }
        dismiss();
    }

    public void bIK() {
        if (this.gaA.gaB != null) {
            try {
                this.gaA.gaB.a(c.dateFormat.parse(this.gbK.getTime()), this.gbG);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bIF() {
        return this.gaA.gbp;
    }
}
