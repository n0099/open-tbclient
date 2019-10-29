package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes3.dex */
public class VoteStatusCard extends LinearLayout {
    private f eFp;
    private e eGI;
    private TextView eKa;
    private VoteStatusView eKb;
    private TextView eKc;
    private TextView eKd;
    private TextView eKe;
    private TextView eKf;
    private TextView eKg;
    private TextView eKh;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.eJu;
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setOrientation(1);
        setMinimumHeight(l.getDimens(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds56);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds52);
        setPadding(dimens, dimens2, dimens, dimens2);
        LayoutInflater.from(getContext()).inflate(R.layout.vote_status_card, (ViewGroup) this, true);
        md();
    }

    private void md() {
        this.eKa = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.eKb = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.eKc = (TextView) findViewById(R.id.apply_title);
        this.eKd = (TextView) findViewById(R.id.apply_start_time);
        this.eKe = (TextView) findViewById(R.id.vote_title);
        this.eKf = (TextView) findViewById(R.id.vote_start_time);
        this.eKg = (TextView) findViewById(R.id.publicity_title);
        this.eKh = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.eFp = fVar;
        if (this.eFp == null || this.eFp.aZy() == null) {
            setVisibility(8);
            return;
        }
        this.eGI = this.eFp.aZy();
        this.status = this.eGI.getStatus();
        this.eKb.setStatus(this.status);
        long aZt = this.eGI.aZt() * 1000;
        this.eKd.setText(aq.aQ(this.eGI.aZr() * 1000));
        this.eKf.setText(aq.aP(this.eGI.aZu() * 1000));
        this.eKh.setText(aq.aP(this.eGI.aZs() * 1000));
    }

    public void mE(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.eKc != null) {
            this.eKc.setTextColor(color);
        }
        if (this.eKe != null) {
            this.eKe.setTextColor(this.status > d.eJt ? color : color2);
        }
        if (this.eKg != null) {
            TextView textView = this.eKg;
            if (this.status <= d.eJu) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.eKb != null) {
            this.eKb.mE(i);
        }
        am.setViewTextColor(this.eKa, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.eKd, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.eKf, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.eKh, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
