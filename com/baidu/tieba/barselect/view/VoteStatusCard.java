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
    private f euT;
    private e ewp;
    private TextView ezJ;
    private VoteStatusView ezK;
    private TextView ezL;
    private TextView ezM;
    private TextView ezN;
    private TextView ezO;
    private TextView ezP;
    private TextView ezQ;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.ezd;
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setOrientation(1);
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
        int g = l.g(this.mContext, R.dimen.tbds56);
        int g2 = l.g(this.mContext, R.dimen.tbds52);
        setPadding(g, g2, g, g2);
        LayoutInflater.from(getContext()).inflate(R.layout.vote_status_card, (ViewGroup) this, true);
        qX();
    }

    private void qX() {
        this.ezJ = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.ezK = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.ezL = (TextView) findViewById(R.id.apply_title);
        this.ezM = (TextView) findViewById(R.id.apply_start_time);
        this.ezN = (TextView) findViewById(R.id.vote_title);
        this.ezO = (TextView) findViewById(R.id.vote_start_time);
        this.ezP = (TextView) findViewById(R.id.publicity_title);
        this.ezQ = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.euT = fVar;
        if (this.euT == null || this.euT.aYR() == null) {
            setVisibility(8);
            return;
        }
        this.ewp = this.euT.aYR();
        this.status = this.ewp.getStatus();
        this.ezK.setStatus(this.status);
        long aYM = this.ewp.aYM() * 1000;
        this.ezM.setText(aq.ax(this.ewp.aYK() * 1000));
        this.ezO.setText(aq.aw(this.ewp.aYN() * 1000));
        this.ezQ.setText(aq.aw(this.ewp.aYL() * 1000));
    }

    public void nA(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.ezL != null) {
            this.ezL.setTextColor(color);
        }
        if (this.ezN != null) {
            this.ezN.setTextColor(this.status > d.ezc ? color : color2);
        }
        if (this.ezP != null) {
            TextView textView = this.ezP;
            if (this.status <= d.ezd) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.ezK != null) {
            this.ezK.nA(i);
        }
        am.d(this.ezJ, R.color.cp_cont_b, 1, i);
        am.d(this.ezM, R.color.cp_cont_d, 1, i);
        am.d(this.ezO, R.color.cp_cont_d, 1, i);
        am.d(this.ezQ, R.color.cp_cont_d, 1, i);
        am.g(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
