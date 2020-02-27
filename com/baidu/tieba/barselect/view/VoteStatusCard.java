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
/* loaded from: classes8.dex */
public class VoteStatusCard extends LinearLayout {
    private f fCf;
    private e fDy;
    private TextView fGO;
    private VoteStatusView fGP;
    private TextView fGQ;
    private TextView fGR;
    private TextView fGS;
    private TextView fGT;
    private TextView fGU;
    private TextView fGV;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.fGi;
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
        ns();
    }

    private void ns() {
        this.fGO = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.fGP = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.fGQ = (TextView) findViewById(R.id.apply_title);
        this.fGR = (TextView) findViewById(R.id.apply_start_time);
        this.fGS = (TextView) findViewById(R.id.vote_title);
        this.fGT = (TextView) findViewById(R.id.vote_start_time);
        this.fGU = (TextView) findViewById(R.id.publicity_title);
        this.fGV = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.fCf = fVar;
        if (this.fCf == null || this.fCf.bug() == null) {
            setVisibility(8);
            return;
        }
        this.fDy = this.fCf.bug();
        this.status = this.fDy.getStatus();
        this.fGP.setStatus(this.status);
        long bub = this.fDy.bub() * 1000;
        this.fGR.setText(aq.bB(this.fDy.btZ() * 1000));
        this.fGT.setText(aq.bA(this.fDy.buc() * 1000));
        this.fGV.setText(aq.bA(this.fDy.bua() * 1000));
    }

    public void pk(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.fGQ != null) {
            this.fGQ.setTextColor(color);
        }
        if (this.fGS != null) {
            this.fGS.setTextColor(this.status > d.fGh ? color : color2);
        }
        if (this.fGU != null) {
            TextView textView = this.fGU;
            if (this.status <= d.fGi) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.fGP != null) {
            this.fGP.pk(i);
        }
        am.setViewTextColor(this.fGO, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fGR, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fGT, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fGV, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
