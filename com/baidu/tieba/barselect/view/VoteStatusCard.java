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
    private f eEy;
    private e eFR;
    private TextView eJj;
    private VoteStatusView eJk;
    private TextView eJl;
    private TextView eJm;
    private TextView eJn;
    private TextView eJo;
    private TextView eJp;
    private TextView eJq;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.eID;
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
        this.eJj = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.eJk = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.eJl = (TextView) findViewById(R.id.apply_title);
        this.eJm = (TextView) findViewById(R.id.apply_start_time);
        this.eJn = (TextView) findViewById(R.id.vote_title);
        this.eJo = (TextView) findViewById(R.id.vote_start_time);
        this.eJp = (TextView) findViewById(R.id.publicity_title);
        this.eJq = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.eEy = fVar;
        if (this.eEy == null || this.eEy.aZw() == null) {
            setVisibility(8);
            return;
        }
        this.eFR = this.eEy.aZw();
        this.status = this.eFR.getStatus();
        this.eJk.setStatus(this.status);
        long aZr = this.eFR.aZr() * 1000;
        this.eJm.setText(aq.aP(this.eFR.aZp() * 1000));
        this.eJo.setText(aq.aO(this.eFR.aZs() * 1000));
        this.eJq.setText(aq.aO(this.eFR.aZq() * 1000));
    }

    public void mD(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.eJl != null) {
            this.eJl.setTextColor(color);
        }
        if (this.eJn != null) {
            this.eJn.setTextColor(this.status > d.eIC ? color : color2);
        }
        if (this.eJp != null) {
            TextView textView = this.eJp;
            if (this.status <= d.eID) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.eJk != null) {
            this.eJk.mD(i);
        }
        am.setViewTextColor(this.eJj, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.eJm, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.eJo, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.eJq, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
