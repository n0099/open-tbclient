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
/* loaded from: classes6.dex */
public class VoteStatusCard extends LinearLayout {
    private e fBa;
    private TextView fEr;
    private VoteStatusView fEs;
    private TextView fEt;
    private TextView fEu;
    private TextView fEv;
    private TextView fEw;
    private TextView fEx;
    private TextView fEy;
    private f fzH;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.fDL;
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
        nb();
    }

    private void nb() {
        this.fEr = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.fEs = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.fEt = (TextView) findViewById(R.id.apply_title);
        this.fEu = (TextView) findViewById(R.id.apply_start_time);
        this.fEv = (TextView) findViewById(R.id.vote_title);
        this.fEw = (TextView) findViewById(R.id.vote_start_time);
        this.fEx = (TextView) findViewById(R.id.publicity_title);
        this.fEy = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.fzH = fVar;
        if (this.fzH == null || this.fzH.bsC() == null) {
            setVisibility(8);
            return;
        }
        this.fBa = this.fzH.bsC();
        this.status = this.fBa.getStatus();
        this.fEs.setStatus(this.status);
        long bsx = this.fBa.bsx() * 1000;
        this.fEu.setText(aq.bx(this.fBa.bsv() * 1000));
        this.fEw.setText(aq.bw(this.fBa.bsy() * 1000));
        this.fEy.setText(aq.bw(this.fBa.bsw() * 1000));
    }

    public void oU(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.fEt != null) {
            this.fEt.setTextColor(color);
        }
        if (this.fEv != null) {
            this.fEv.setTextColor(this.status > d.fDK ? color : color2);
        }
        if (this.fEx != null) {
            TextView textView = this.fEx;
            if (this.status <= d.fDL) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.fEs != null) {
            this.fEs.oU(i);
        }
        am.setViewTextColor(this.fEr, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fEu, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fEw, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fEy, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
