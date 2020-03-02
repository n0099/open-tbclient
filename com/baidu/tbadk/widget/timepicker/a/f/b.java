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
    private c dRH;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.dQv = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        aUT();
        initViews();
        vh();
        if (this.dQv.dQy == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.dRy);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(UgcUBCUtils.UGC_TIME_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.dQv.dQZ) ? context.getResources().getString(R.string.pickerview_submit) : this.dQv.dQZ);
            button2.setText(TextUtils.isEmpty(this.dQv.dRa) ? context.getResources().getString(R.string.pickerview_cancel) : this.dQv.dRa);
            textView.setText(TextUtils.isEmpty(this.dQv.dRb) ? "" : this.dQv.dRb);
            button.setTextColor(this.dQv.dRc);
            button2.setTextColor(this.dQv.dRd);
            textView.setTextColor(this.dQv.dRe);
            relativeLayout.setBackgroundColor(this.dQv.dRg);
            button.setTextSize(this.dQv.dRh);
            button2.setTextSize(this.dQv.dRh);
            textView.setTextSize(this.dQv.dRi);
        } else {
            this.dQv.dQy.bc(LayoutInflater.from(context).inflate(this.dQv.dQX, this.dRy));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.dQv.dRf);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.dRH = new c(linearLayout, this.dQv.dQD, this.dQv.dQY, this.dQv.dRj);
        if (this.dQv.dQx != null) {
            this.dRH.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void aUS() {
                    try {
                        b.this.dQv.dQx.m(c.dateFormat.parse(b.this.dRH.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.dRH.hs(this.dQv.dQK);
        if (this.dQv.dQH != 0 && this.dQv.dQI != 0 && this.dQv.dQH <= this.dQv.dQI) {
            aUV();
        }
        if (this.dQv.dQF != null && this.dQv.dQG != null) {
            if (this.dQv.dQF.getTimeInMillis() > this.dQv.dQG.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aUW();
        } else if (this.dQv.dQF != null) {
            if (this.dQv.dQF.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aUW();
        } else if (this.dQv.dQG != null) {
            if (this.dQv.dQG.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aUW();
        } else {
            aUW();
        }
        aUY();
        this.dRH.c(this.dQv.dQL, this.dQv.dQM, this.dQv.dQN, this.dQv.dQO, this.dQv.dQP, this.dQv.dQQ);
        this.dRH.j(this.dQv.dQR, this.dQv.dQS, this.dQv.dQT, this.dQv.dQU, this.dQv.dQV, this.dQv.dQW);
        hr(this.dQv.dRl);
        this.dRH.setCyclic(this.dQv.dQJ);
        this.dRH.setDividerColor(this.dQv.dividerColor);
        this.dRH.setDividerType(this.dQv.dRn);
        this.dRH.setLineSpacingMultiplier(this.dQv.lineSpacingMultiplier);
        this.dRH.setTextColorOut(this.dQv.textColorOut);
        this.dRH.setTextColorCenter(this.dQv.textColorCenter);
        this.dRH.isCenterLabel(this.dQv.isCenterLabel);
    }

    private void aUV() {
        this.dRH.nM(this.dQv.dQH);
        this.dRH.nN(this.dQv.dQI);
    }

    private void aUW() {
        this.dRH.a(this.dQv.dQF, this.dQv.dQG);
        aUX();
    }

    private void aUX() {
        if (this.dQv.dQF != null && this.dQv.dQG != null) {
            if (this.dQv.dQE == null || this.dQv.dQE.getTimeInMillis() < this.dQv.dQF.getTimeInMillis() || this.dQv.dQE.getTimeInMillis() > this.dQv.dQG.getTimeInMillis()) {
                this.dQv.dQE = this.dQv.dQF;
            }
        } else if (this.dQv.dQF != null) {
            this.dQv.dQE = this.dQv.dQF;
        } else if (this.dQv.dQG != null) {
            this.dQv.dQE = this.dQv.dQG;
        }
    }

    private void aUY() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.dQv.dQE == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.dQv.dQE.get(1);
            i2 = this.dQv.dQE.get(2);
            i3 = this.dQv.dQE.get(5);
            i4 = this.dQv.dQE.get(11);
            i5 = this.dQv.dQE.get(12);
            i6 = this.dQv.dQE.get(13);
        }
        this.dRH.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            aUZ();
        }
        dismiss();
    }

    public void aUZ() {
        if (this.dQv.dQw != null) {
            try {
                this.dQv.dQw.a(c.dateFormat.parse(this.dRH.getTime()), this.dRD);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean aUU() {
        return this.dQv.dRk;
    }
}
