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
    private f euM;
    private e ewi;
    private TextView ezC;
    private VoteStatusView ezD;
    private TextView ezE;
    private TextView ezF;
    private TextView ezG;
    private TextView ezH;
    private TextView ezI;
    private TextView ezJ;
    private Context mContext;
    private int status;

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.eyW;
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
        this.ezC = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.ezD = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.ezE = (TextView) findViewById(R.id.apply_title);
        this.ezF = (TextView) findViewById(R.id.apply_start_time);
        this.ezG = (TextView) findViewById(R.id.vote_title);
        this.ezH = (TextView) findViewById(R.id.vote_start_time);
        this.ezI = (TextView) findViewById(R.id.publicity_title);
        this.ezJ = (TextView) findViewById(R.id.publicity_start_time);
    }

    public void setData(f fVar) {
        this.euM = fVar;
        if (this.euM == null || this.euM.aYP() == null) {
            setVisibility(8);
            return;
        }
        this.ewi = this.euM.aYP();
        this.status = this.ewi.getStatus();
        this.ezD.setStatus(this.status);
        long aYK = this.ewi.aYK() * 1000;
        this.ezF.setText(aq.ax(this.ewi.aYI() * 1000));
        this.ezH.setText(aq.aw(this.ewi.aYL() * 1000));
        this.ezJ.setText(aq.aw(this.ewi.aYJ() * 1000));
    }

    public void nz(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.ezE != null) {
            this.ezE.setTextColor(color);
        }
        if (this.ezG != null) {
            this.ezG.setTextColor(this.status > d.eyV ? color : color2);
        }
        if (this.ezI != null) {
            TextView textView = this.ezI;
            if (this.status <= d.eyW) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.ezD != null) {
            this.ezD.nz(i);
        }
        am.d(this.ezC, R.color.cp_cont_b, 1, i);
        am.d(this.ezF, R.color.cp_cont_d, 1, i);
        am.d(this.ezH, R.color.cp_cont_d, 1, i);
        am.d(this.ezJ, R.color.cp_cont_d, 1, i);
        am.g(this, R.drawable.bar_select_bg_shadow_and_radius, i);
    }
}
