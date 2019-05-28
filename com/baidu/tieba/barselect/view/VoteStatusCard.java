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
    private f epO;
    private e erk;
    private TextView euD;
    private VoteStatusView euE;
    private TextView euF;
    private TextView euG;
    private TextView euH;
    private TextView euI;
    private TextView euJ;
    private TextView euK;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.etX;
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
        this.euD = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.euE = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.euF = (TextView) findViewById(R.id.apply_title);
        this.euG = (TextView) findViewById(R.id.apply_start_time);
        this.euH = (TextView) findViewById(R.id.vote_title);
        this.euI = (TextView) findViewById(R.id.vote_start_time);
        this.euJ = (TextView) findViewById(R.id.publicity_title);
        this.euK = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.epO = fVar;
        if (this.epO == null || this.epO.aWT() == null) {
            setVisibility(8);
            return;
        }
        this.erk = this.epO.aWT();
        this.status = this.erk.getStatus();
        this.euE.setStatus(this.status);
        long aWO = this.erk.aWO() * 1000;
        this.euG.setText(ap.aw(this.erk.aWM() * 1000));
        this.euI.setText(ap.av(this.erk.aWP() * 1000));
        this.euK.setText(ap.av(this.erk.aWN() * 1000));
    }

    public void nq(int i) {
        int color = al.getColor(i, R.color.cp_cont_b);
        int color2 = al.getColor(i, R.color.cp_cont_d);
        if (this.euF != null) {
            this.euF.setTextColor(color);
        }
        if (this.euH != null) {
            this.euH.setTextColor(this.status > d.etW ? color : color2);
        }
        if (this.euJ != null) {
            TextView textView = this.euJ;
            if (this.status <= d.etX) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.euE != null) {
            this.euE.nq(i);
        }
        al.c(this.euD, R.color.cp_cont_b, 1, i);
        al.c(this.euG, R.color.cp_cont_d, 1, i);
        al.c(this.euI, R.color.cp_cont_d, 1, i);
        al.c(this.euK, R.color.cp_cont_d, 1, i);
        al.g(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
