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
    private c dRG;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.dQu = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        aUR();
        initViews();
        vh();
        if (this.dQu.dQx == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.dRx);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(UgcUBCUtils.UGC_TIME_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.dQu.dQY) ? context.getResources().getString(R.string.pickerview_submit) : this.dQu.dQY);
            button2.setText(TextUtils.isEmpty(this.dQu.dQZ) ? context.getResources().getString(R.string.pickerview_cancel) : this.dQu.dQZ);
            textView.setText(TextUtils.isEmpty(this.dQu.dRa) ? "" : this.dQu.dRa);
            button.setTextColor(this.dQu.dRb);
            button2.setTextColor(this.dQu.dRc);
            textView.setTextColor(this.dQu.dRd);
            relativeLayout.setBackgroundColor(this.dQu.dRf);
            button.setTextSize(this.dQu.dRg);
            button2.setTextSize(this.dQu.dRg);
            textView.setTextSize(this.dQu.dRh);
        } else {
            this.dQu.dQx.bc(LayoutInflater.from(context).inflate(this.dQu.dQW, this.dRx));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.dQu.dRe);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.dRG = new c(linearLayout, this.dQu.dQC, this.dQu.dQX, this.dQu.dRi);
        if (this.dQu.dQw != null) {
            this.dRG.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void aUQ() {
                    try {
                        b.this.dQu.dQw.m(c.dateFormat.parse(b.this.dRG.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.dRG.hs(this.dQu.dQJ);
        if (this.dQu.dQG != 0 && this.dQu.dQH != 0 && this.dQu.dQG <= this.dQu.dQH) {
            aUT();
        }
        if (this.dQu.dQE != null && this.dQu.dQF != null) {
            if (this.dQu.dQE.getTimeInMillis() > this.dQu.dQF.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aUU();
        } else if (this.dQu.dQE != null) {
            if (this.dQu.dQE.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aUU();
        } else if (this.dQu.dQF != null) {
            if (this.dQu.dQF.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aUU();
        } else {
            aUU();
        }
        aUW();
        this.dRG.c(this.dQu.dQK, this.dQu.dQL, this.dQu.dQM, this.dQu.dQN, this.dQu.dQO, this.dQu.dQP);
        this.dRG.j(this.dQu.dQQ, this.dQu.dQR, this.dQu.dQS, this.dQu.dQT, this.dQu.dQU, this.dQu.dQV);
        hr(this.dQu.dRk);
        this.dRG.setCyclic(this.dQu.dQI);
        this.dRG.setDividerColor(this.dQu.dividerColor);
        this.dRG.setDividerType(this.dQu.dRm);
        this.dRG.setLineSpacingMultiplier(this.dQu.lineSpacingMultiplier);
        this.dRG.setTextColorOut(this.dQu.textColorOut);
        this.dRG.setTextColorCenter(this.dQu.textColorCenter);
        this.dRG.isCenterLabel(this.dQu.isCenterLabel);
    }

    private void aUT() {
        this.dRG.nM(this.dQu.dQG);
        this.dRG.nN(this.dQu.dQH);
    }

    private void aUU() {
        this.dRG.a(this.dQu.dQE, this.dQu.dQF);
        aUV();
    }

    private void aUV() {
        if (this.dQu.dQE != null && this.dQu.dQF != null) {
            if (this.dQu.dQD == null || this.dQu.dQD.getTimeInMillis() < this.dQu.dQE.getTimeInMillis() || this.dQu.dQD.getTimeInMillis() > this.dQu.dQF.getTimeInMillis()) {
                this.dQu.dQD = this.dQu.dQE;
            }
        } else if (this.dQu.dQE != null) {
            this.dQu.dQD = this.dQu.dQE;
        } else if (this.dQu.dQF != null) {
            this.dQu.dQD = this.dQu.dQF;
        }
    }

    private void aUW() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.dQu.dQD == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.dQu.dQD.get(1);
            i2 = this.dQu.dQD.get(2);
            i3 = this.dQu.dQD.get(5);
            i4 = this.dQu.dQD.get(11);
            i5 = this.dQu.dQD.get(12);
            i6 = this.dQu.dQD.get(13);
        }
        this.dRG.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            aUX();
        }
        dismiss();
    }

    public void aUX() {
        if (this.dQu.dQv != null) {
            try {
                this.dQu.dQv.a(c.dateFormat.parse(this.dRG.getTime()), this.dRC);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean aUS() {
        return this.dQu.dRj;
    }
}
