package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
/* loaded from: classes3.dex */
public class VoteStatusCard extends LinearLayout {
    private f epN;
    private e erj;
    private TextView euC;
    private VoteStatusView euD;
    private TextView euE;
    private TextView euF;
    private TextView euG;
    private TextView euH;
    private TextView euI;
    private TextView euJ;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.etW;
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
        qA();
    }

    private void qA() {
        this.euC = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.euD = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.euE = (TextView) findViewById(R.id.apply_title);
        this.euF = (TextView) findViewById(R.id.apply_start_time);
        this.euG = (TextView) findViewById(R.id.vote_title);
        this.euH = (TextView) findViewById(R.id.vote_start_time);
        this.euI = (TextView) findViewById(R.id.publicity_title);
        this.euJ = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.epN = fVar;
        if (this.epN == null || this.epN.aWQ() == null) {
            setVisibility(8);
            return;
        }
        this.erj = this.epN.aWQ();
        this.status = this.erj.getStatus();
        this.euD.setStatus(this.status);
        long aWL = this.erj.aWL() * 1000;
        this.euF.setText(ap.aw(this.erj.aWJ() * 1000));
        this.euH.setText(ap.av(this.erj.aWM() * 1000));
        this.euJ.setText(ap.av(this.erj.aWK() * 1000));
    }

    public void nq(int i) {
        int color = al.getColor(i, R.color.cp_cont_b);
        int color2 = al.getColor(i, R.color.cp_cont_d);
        if (this.euE != null) {
            this.euE.setTextColor(color);
        }
        if (this.euG != null) {
            this.euG.setTextColor(this.status > d.etV ? color : color2);
        }
        if (this.euI != null) {
            TextView textView = this.euI;
            if (this.status <= d.etW) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.euD != null) {
            this.euD.nq(i);
        }
        al.c(this.euC, R.color.cp_cont_b, 1, i);
        al.c(this.euF, R.color.cp_cont_d, 1, i);
        al.c(this.euH, R.color.cp_cont_d, 1, i);
        al.c(this.euJ, R.color.cp_cont_d, 1, i);
        al.g(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
