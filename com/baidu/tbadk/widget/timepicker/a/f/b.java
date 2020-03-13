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
    private c dRU;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.dQI = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        aUU();
        initViews();
        vh();
        if (this.dQI.dQL == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.dRL);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag(UgcUBCUtils.UGC_TIME_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.dQI.dRm) ? context.getResources().getString(R.string.pickerview_submit) : this.dQI.dRm);
            button2.setText(TextUtils.isEmpty(this.dQI.dRn) ? context.getResources().getString(R.string.pickerview_cancel) : this.dQI.dRn);
            textView.setText(TextUtils.isEmpty(this.dQI.dRo) ? "" : this.dQI.dRo);
            button.setTextColor(this.dQI.dRp);
            button2.setTextColor(this.dQI.dRq);
            textView.setTextColor(this.dQI.dRr);
            relativeLayout.setBackgroundColor(this.dQI.dRt);
            button.setTextSize(this.dQI.dRu);
            button2.setTextSize(this.dQI.dRu);
            textView.setTextSize(this.dQI.dRv);
        } else {
            this.dQI.dQL.bc(LayoutInflater.from(context).inflate(this.dQI.dRk, this.dRL));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.dQI.dRs);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.dRU = new c(linearLayout, this.dQI.dQQ, this.dQI.dRl, this.dQI.dRw);
        if (this.dQI.dQK != null) {
            this.dRU.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void aUT() {
                    try {
                        b.this.dQI.dQK.m(c.dateFormat.parse(b.this.dRU.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.dRU.hs(this.dQI.dQX);
        if (this.dQI.dQU != 0 && this.dQI.dQV != 0 && this.dQI.dQU <= this.dQI.dQV) {
            aUW();
        }
        if (this.dQI.dQS != null && this.dQI.dQT != null) {
            if (this.dQI.dQS.getTimeInMillis() > this.dQI.dQT.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            aUX();
        } else if (this.dQI.dQS != null) {
            if (this.dQI.dQS.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            aUX();
        } else if (this.dQI.dQT != null) {
            if (this.dQI.dQT.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            aUX();
        } else {
            aUX();
        }
        aUZ();
        this.dRU.c(this.dQI.dQY, this.dQI.dQZ, this.dQI.dRa, this.dQI.dRb, this.dQI.dRc, this.dQI.dRd);
        this.dRU.j(this.dQI.dRe, this.dQI.dRf, this.dQI.dRg, this.dQI.dRh, this.dQI.dRi, this.dQI.dRj);
        hr(this.dQI.dRy);
        this.dRU.setCyclic(this.dQI.dQW);
        this.dRU.setDividerColor(this.dQI.dividerColor);
        this.dRU.setDividerType(this.dQI.dRA);
        this.dRU.setLineSpacingMultiplier(this.dQI.lineSpacingMultiplier);
        this.dRU.setTextColorOut(this.dQI.textColorOut);
        this.dRU.setTextColorCenter(this.dQI.textColorCenter);
        this.dRU.isCenterLabel(this.dQI.isCenterLabel);
    }

    private void aUW() {
        this.dRU.nM(this.dQI.dQU);
        this.dRU.nN(this.dQI.dQV);
    }

    private void aUX() {
        this.dRU.a(this.dQI.dQS, this.dQI.dQT);
        aUY();
    }

    private void aUY() {
        if (this.dQI.dQS != null && this.dQI.dQT != null) {
            if (this.dQI.dQR == null || this.dQI.dQR.getTimeInMillis() < this.dQI.dQS.getTimeInMillis() || this.dQI.dQR.getTimeInMillis() > this.dQI.dQT.getTimeInMillis()) {
                this.dQI.dQR = this.dQI.dQS;
            }
        } else if (this.dQI.dQS != null) {
            this.dQI.dQR = this.dQI.dQS;
        } else if (this.dQI.dQT != null) {
            this.dQI.dQR = this.dQI.dQT;
        }
    }

    private void aUZ() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.dQI.dQR == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.dQI.dQR.get(1);
            i2 = this.dQI.dQR.get(2);
            i3 = this.dQI.dQR.get(5);
            i4 = this.dQI.dQR.get(11);
            i5 = this.dQI.dQR.get(12);
            i6 = this.dQI.dQR.get(13);
        }
        this.dRU.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            aVa();
        }
        dismiss();
    }

    public void aVa() {
        if (this.dQI.dQJ != null) {
            try {
                this.dQI.dQJ.a(c.dateFormat.parse(this.dRU.getTime()), this.dRQ);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean aUV() {
        return this.dQI.dRx;
    }
}
