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
    private c eso;

    public b(com.baidu.tbadk.widget.timepicker.a.c.a aVar) {
        super(aVar.context);
        this.erb = aVar;
        initView(aVar.context);
    }

    private void initView(Context context) {
        bdg();
        initViews();
        zJ();
        if (this.erb.ere == null) {
            LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.esf);
            TextView textView = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rv_topbar);
            Button button = (Button) findViewById(R.id.btnSubmit);
            Button button2 = (Button) findViewById(R.id.btnCancel);
            button.setTag("submit");
            button2.setTag("cancel");
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.erb.erG) ? context.getResources().getString(R.string.pickerview_submit) : this.erb.erG);
            button2.setText(TextUtils.isEmpty(this.erb.erH) ? context.getResources().getString(R.string.pickerview_cancel) : this.erb.erH);
            textView.setText(TextUtils.isEmpty(this.erb.erI) ? "" : this.erb.erI);
            button.setTextColor(this.erb.erJ);
            button2.setTextColor(this.erb.erK);
            textView.setTextColor(this.erb.erL);
            relativeLayout.setBackgroundColor(this.erb.erN);
            button.setTextSize(this.erb.erO);
            button2.setTextSize(this.erb.erO);
            textView.setTextSize(this.erb.erP);
        } else {
            this.erb.ere.bd(LayoutInflater.from(context).inflate(this.erb.erE, this.esf));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.timepicker);
        linearLayout.setBackgroundColor(this.erb.erM);
        a(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        this.eso = new c(linearLayout, this.erb.erj, this.erb.erF, this.erb.erQ);
        if (this.erb.erd != null) {
            this.eso.a(new com.baidu.tbadk.widget.timepicker.a.d.b() { // from class: com.baidu.tbadk.widget.timepicker.a.f.b.1
                @Override // com.baidu.tbadk.widget.timepicker.a.d.b
                public void bdf() {
                    try {
                        b.this.erb.erd.m(c.dateFormat.parse(b.this.eso.getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        this.eso.ir(this.erb.erq);
        if (this.erb.ern != 0 && this.erb.ero != 0 && this.erb.ern <= this.erb.ero) {
            bdi();
        }
        if (this.erb.erl != null && this.erb.erm != null) {
            if (this.erb.erl.getTimeInMillis() > this.erb.erm.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            bdj();
        } else if (this.erb.erl != null) {
            if (this.erb.erl.get(1) < 1900) {
                throw new IllegalArgumentException("The startDate can not as early as 1900");
            }
            bdj();
        } else if (this.erb.erm != null) {
            if (this.erb.erm.get(1) > 2100) {
                throw new IllegalArgumentException("The endDate should not be later than 2100");
            }
            bdj();
        } else {
            bdj();
        }
        bdl();
        this.eso.c(this.erb.ers, this.erb.ert, this.erb.eru, this.erb.erv, this.erb.erw, this.erb.erx);
        this.eso.j(this.erb.ery, this.erb.erz, this.erb.erA, this.erb.erB, this.erb.erC, this.erb.erD);
        iq(this.erb.erS);
        this.eso.setCyclic(this.erb.erp);
        this.eso.setDividerColor(this.erb.dividerColor);
        this.eso.setDividerType(this.erb.erU);
        this.eso.setLineSpacingMultiplier(this.erb.lineSpacingMultiplier);
        this.eso.setTextColorOut(this.erb.textColorOut);
        this.eso.setTextColorCenter(this.erb.textColorCenter);
        this.eso.isCenterLabel(this.erb.isCenterLabel);
    }

    private void bdi() {
        this.eso.ob(this.erb.ern);
        this.eso.oc(this.erb.ero);
    }

    private void bdj() {
        this.eso.a(this.erb.erl, this.erb.erm);
        bdk();
    }

    private void bdk() {
        if (this.erb.erl != null && this.erb.erm != null) {
            if (this.erb.erk == null || this.erb.erk.getTimeInMillis() < this.erb.erl.getTimeInMillis() || this.erb.erk.getTimeInMillis() > this.erb.erm.getTimeInMillis()) {
                this.erb.erk = this.erb.erl;
            }
        } else if (this.erb.erl != null) {
            this.erb.erk = this.erb.erl;
        } else if (this.erb.erm != null) {
            this.erb.erk = this.erb.erm;
        }
    }

    private void bdl() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Calendar calendar = Calendar.getInstance();
        if (this.erb.erk == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i = calendar.get(1);
            i2 = calendar.get(2);
            i3 = calendar.get(5);
            i4 = calendar.get(11);
            i5 = calendar.get(12);
            i6 = calendar.get(13);
        } else {
            i = this.erb.erk.get(1);
            i2 = this.erb.erk.get(2);
            i3 = this.erb.erk.get(5);
            i4 = this.erb.erk.get(11);
            i5 = this.erb.erk.get(12);
            i6 = this.erb.erk.get(13);
        }
        this.eso.h(i, i2, i3, i4, i5, i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            bdm();
        }
        dismiss();
    }

    public void bdm() {
        if (this.erb.erc != null) {
            try {
                this.erb.erc.a(c.dateFormat.parse(this.eso.getTime()), this.esk);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.timepicker.a.f.a
    public boolean bdh() {
        return this.erb.erR;
    }
}
