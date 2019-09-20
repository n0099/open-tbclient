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
    private TextView eBs;
    private VoteStatusView eBt;
    private TextView eBu;
    private TextView eBv;
    private TextView eBw;
    private TextView eBx;
    private TextView eBy;
    private TextView eBz;
    private f ewD;
    private e exZ;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.eAM;
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
        qY();
    }

    private void qY() {
        this.eBs = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.eBt = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.eBu = (TextView) findViewById(R.id.apply_title);
        this.eBv = (TextView) findViewById(R.id.apply_start_time);
        this.eBw = (TextView) findViewById(R.id.vote_title);
        this.eBx = (TextView) findViewById(R.id.vote_start_time);
        this.eBy = (TextView) findViewById(R.id.publicity_title);
        this.eBz = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.ewD = fVar;
        if (this.ewD == null || this.ewD.aZv() == null) {
            setVisibility(8);
            return;
        }
        this.exZ = this.ewD.aZv();
        this.status = this.exZ.getStatus();
        this.eBt.setStatus(this.status);
        long aZq = this.exZ.aZq() * 1000;
        this.eBv.setText(aq.ax(this.exZ.aZo() * 1000));
        this.eBx.setText(aq.aw(this.exZ.aZr() * 1000));
        this.eBz.setText(aq.aw(this.exZ.aZp() * 1000));
    }

    public void nE(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.eBu != null) {
            this.eBu.setTextColor(color);
        }
        if (this.eBw != null) {
            this.eBw.setTextColor(this.status > d.eAL ? color : color2);
        }
        if (this.eBy != null) {
            TextView textView = this.eBy;
            if (this.status <= d.eAM) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.eBt != null) {
            this.eBt.nE(i);
        }
        am.d(this.eBs, R.color.cp_cont_b, 1, i);
        am.d(this.eBv, R.color.cp_cont_d, 1, i);
        am.d(this.eBx, R.color.cp_cont_d, 1, i);
        am.d(this.eBz, R.color.cp_cont_d, 1, i);
        am.g(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
