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
    private f fDc;
    private e fEv;
    private TextView fHL;
    private VoteStatusView fHM;
    private TextView fHN;
    private TextView fHO;
    private TextView fHP;
    private TextView fHQ;
    private TextView fHR;
    private TextView fHS;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.fHf;
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
        this.fHL = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.fHM = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.fHN = (TextView) findViewById(R.id.apply_title);
        this.fHO = (TextView) findViewById(R.id.apply_start_time);
        this.fHP = (TextView) findViewById(R.id.vote_title);
        this.fHQ = (TextView) findViewById(R.id.vote_start_time);
        this.fHR = (TextView) findViewById(R.id.publicity_title);
        this.fHS = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.fDc = fVar;
        if (this.fDc == null || this.fDc.buo() == null) {
            setVisibility(8);
            return;
        }
        this.fEv = this.fDc.buo();
        this.status = this.fEv.getStatus();
        this.fHM.setStatus(this.status);
        long buj = this.fEv.buj() * 1000;
        this.fHO.setText(aq.bB(this.fEv.buh() * 1000));
        this.fHQ.setText(aq.bA(this.fEv.buk() * 1000));
        this.fHS.setText(aq.bA(this.fEv.bui() * 1000));
    }

    public void pm(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.fHN != null) {
            this.fHN.setTextColor(color);
        }
        if (this.fHP != null) {
            this.fHP.setTextColor(this.status > d.fHe ? color : color2);
        }
        if (this.fHR != null) {
            TextView textView = this.fHR;
            if (this.status <= d.fHf) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.fHM != null) {
            this.fHM.pm(i);
        }
        am.setViewTextColor(this.fHL, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fHO, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fHQ, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fHS, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
