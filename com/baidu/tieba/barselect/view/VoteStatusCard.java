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
    private f fCu;
    private e fDN;
    private TextView fHd;
    private VoteStatusView fHe;
    private TextView fHf;
    private TextView fHg;
    private TextView fHh;
    private TextView fHi;
    private TextView fHj;
    private TextView fHk;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.fGx;
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
        this.fHd = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.fHe = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.fHf = (TextView) findViewById(R.id.apply_title);
        this.fHg = (TextView) findViewById(R.id.apply_start_time);
        this.fHh = (TextView) findViewById(R.id.vote_title);
        this.fHi = (TextView) findViewById(R.id.vote_start_time);
        this.fHj = (TextView) findViewById(R.id.publicity_title);
        this.fHk = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.fCu = fVar;
        if (this.fCu == null || this.fCu.buj() == null) {
            setVisibility(8);
            return;
        }
        this.fDN = this.fCu.buj();
        this.status = this.fDN.getStatus();
        this.fHe.setStatus(this.status);
        long bue = this.fDN.bue() * 1000;
        this.fHg.setText(aq.bB(this.fDN.buc() * 1000));
        this.fHi.setText(aq.bA(this.fDN.buf() * 1000));
        this.fHk.setText(aq.bA(this.fDN.bud() * 1000));
    }

    public void pk(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.fHf != null) {
            this.fHf.setTextColor(color);
        }
        if (this.fHh != null) {
            this.fHh.setTextColor(this.status > d.fGw ? color : color2);
        }
        if (this.fHj != null) {
            TextView textView = this.fHj;
            if (this.status <= d.fGx) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.fHe != null) {
            this.fHe.pk(i);
        }
        am.setViewTextColor(this.fHd, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fHg, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fHi, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fHk, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
