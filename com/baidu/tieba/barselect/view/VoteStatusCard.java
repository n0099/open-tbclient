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
    private f fCh;
    private e fDA;
    private TextView fGQ;
    private VoteStatusView fGR;
    private TextView fGS;
    private TextView fGT;
    private TextView fGU;
    private TextView fGV;
    private TextView fGW;
    private TextView fGX;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.fGk;
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
        this.fGQ = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.fGR = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.fGS = (TextView) findViewById(R.id.apply_title);
        this.fGT = (TextView) findViewById(R.id.apply_start_time);
        this.fGU = (TextView) findViewById(R.id.vote_title);
        this.fGV = (TextView) findViewById(R.id.vote_start_time);
        this.fGW = (TextView) findViewById(R.id.publicity_title);
        this.fGX = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.fCh = fVar;
        if (this.fCh == null || this.fCh.bui() == null) {
            setVisibility(8);
            return;
        }
        this.fDA = this.fCh.bui();
        this.status = this.fDA.getStatus();
        this.fGR.setStatus(this.status);
        long bud = this.fDA.bud() * 1000;
        this.fGT.setText(aq.bB(this.fDA.bub() * 1000));
        this.fGV.setText(aq.bA(this.fDA.bue() * 1000));
        this.fGX.setText(aq.bA(this.fDA.buc() * 1000));
    }

    public void pk(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.fGS != null) {
            this.fGS.setTextColor(color);
        }
        if (this.fGU != null) {
            this.fGU.setTextColor(this.status > d.fGj ? color : color2);
        }
        if (this.fGW != null) {
            TextView textView = this.fGW;
            if (this.status <= d.fGk) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.fGR != null) {
            this.fGR.pk(i);
        }
        am.setViewTextColor(this.fGQ, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fGT, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fGV, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fGX, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
