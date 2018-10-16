package com.baidu.tbadk.widget.timepicker.a.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tieba.e;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes.dex */
public class b extends a implements View.OnClickListener {
    private c bpy;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.bog = aVar;
        bJ(aVar.context);
    }

    private void bJ(Context context) {
        RL();
        initViews();
        initAnim();
        if (this.bog.boj == null) {
            LayoutInflater.from(context).inflate(e.h.pickerview_time, this.bpm);
            TextView textView = (TextView) findViewById(e.g.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.g.rv_topbar);
            Button button = (Button) findViewById(e.g.btnSubmit);
            Button button2 = (Button) findViewById(e.g.btnCancel);
            button.setTag("submit");
            button2.setTag(AiAppsUBCStatistic.VALUE_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.bog.boI) ? context.getResources().getString(e.j.pickerview_submit) : this.bog.boI);
            button2.setText(TextUtils.isEmpty(this.bog.boJ) ? context.getResources().getString(e.j.pickerview_cancel) : this.bog.boJ);
            textView.setText(TextUtils.isEmpty(this.bog.boK) ? "" : this.bog.boK);
            button.setTextColor(this.bog.boL);
            button2.setTextColor(this.bog.boM);
            textView.setTextColor(this.bog.boN);
            relativeLayout.setBackgroundColor(this.bog.boP);
            button.setTextSize(this.bog.boQ);
            button2.setTextSize(this.bog.boQ);
            textView.setTextSize(this.bog.boR);
        } else {
            this.bog.boj.Z(LayoutInflater.from(context).inflate(this.bog.boG, this.bpm));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(e.g.timepicker);
        linearLayout.setBackgroundColor(this.bog.boO);
        b(linearLayout);
    }

    private void b(LinearLayout linearLayout) {
        this.bpy = new c(linearLayout, this.bog.boo, this.bog.boH, this.bog.boS);
        if (this.bog.boi != null) {
            this.bpy.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void RJ() {
                    try {
                        b.this.bog.boi.j(c.bpA.parse(b.this.bpy.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.bpy.cN(this.bog.bot);
        if (this.bog.startYear != 0 && this.bog.endYear != 0 && this.bog.startYear <= this.bog.endYear) {
            RO();
        }
        if (this.bog.boq != null && this.bog.bor != null) {
            if (this.bog.boq.getTimeInMillis() > this.bog.bor.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            RP();
        } else if (this.bog.boq != null) {
            if (this.bog.boq.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            RP();
        } else if (this.bog.bor != null) {
            if (this.bog.bor.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            RP();
        } else {
            RP();
        }
        RR();
        this.bpy.c(this.bog.bou, this.bog.bov, this.bog.bow, this.bog.box, this.bog.boy, this.bog.boz);
        this.bpy.g(this.bog.boA, this.bog.boB, this.bog.boC, this.bog.boD, this.bog.boE, this.bog.boF);
        cM(this.bog.boY);
        this.bpy.setCyclic(this.bog.bos);
        this.bpy.setDividerColor(this.bog.boV);
        this.bpy.setDividerType(this.bog.bpb);
        this.bpy.setLineSpacingMultiplier(this.bog.boW);
        this.bpy.setTextColorOut(this.bog.boT);
        this.bpy.setTextColorCenter(this.bog.boU);
        this.bpy.cO(this.bog.boZ);
    }

    private void RO() {
        this.bpy.setStartYear(this.bog.startYear);
        this.bpy.gJ(this.bog.endYear);
    }

    private void RP() {
        this.bpy.a(this.bog.boq, this.bog.bor);
        RQ();
    }

    private void RQ() {
        if (this.bog.boq != null && this.bog.bor != null) {
            if (this.bog.bop == null || this.bog.bop.getTimeInMillis() < this.bog.boq.getTimeInMillis() || this.bog.bop.getTimeInMillis() > this.bog.bor.getTimeInMillis()) {
                this.bog.bop = this.bog.boq;
            }
        } else if (this.bog.boq != null) {
            this.bog.bop = this.bog.boq;
        } else if (this.bog.bor != null) {
            this.bog.bop = this.bog.bor;
        }
    }

    private void RR() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.bog.bop == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.bog.bop.get(1);
            i2 = this.bog.bop.get(2);
            i3 = this.bog.bop.get(5);
            i4 = this.bog.bop.get(11);
            i5 = this.bog.bop.get(12);
            i6 = this.bog.bop.get(13);
        }
        this.bpy.e(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            RS();
        }
        dismiss();
    }

    public void RS() {
        if (this.bog.boh != null) {
            try {
                this.bog.boh.a(c.bpA.parse(this.bpy.getTime()), this.bpt);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean RN() {
        return this.bog.boX;
    }
}
