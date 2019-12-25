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
/* loaded from: classes5.dex */
public class VoteStatusCard extends LinearLayout {
    private TextView fBg;
    private VoteStatusView fBh;
    private TextView fBi;
    private TextView fBj;
    private TextView fBk;
    private TextView fBl;
    private TextView fBm;
    private TextView fBn;
    private f fww;
    private e fxP;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.fAA;
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
        na();
    }

    private void na() {
        this.fBg = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.fBh = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.fBi = (TextView) findViewById(R.id.apply_title);
        this.fBj = (TextView) findViewById(R.id.apply_start_time);
        this.fBk = (TextView) findViewById(R.id.vote_title);
        this.fBl = (TextView) findViewById(R.id.vote_start_time);
        this.fBm = (TextView) findViewById(R.id.publicity_title);
        this.fBn = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.fww = fVar;
        if (this.fww == null || this.fww.brA() == null) {
            setVisibility(8);
            return;
        }
        this.fxP = this.fww.brA();
        this.status = this.fxP.getStatus();
        this.fBh.setStatus(this.status);
        long brv = this.fxP.brv() * 1000;
        this.fBj.setText(aq.bu(this.fxP.brt() * 1000));
        this.fBl.setText(aq.bt(this.fxP.brw() * 1000));
        this.fBn.setText(aq.bt(this.fxP.bru() * 1000));
    }

    public void oT(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.fBi != null) {
            this.fBi.setTextColor(color);
        }
        if (this.fBk != null) {
            this.fBk.setTextColor(this.status > d.fAz ? color : color2);
        }
        if (this.fBm != null) {
            TextView textView = this.fBm;
            if (this.status <= d.fAA) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.fBh != null) {
            this.fBh.oT(i);
        }
        am.setViewTextColor(this.fBg, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fBj, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fBl, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.fBn, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
