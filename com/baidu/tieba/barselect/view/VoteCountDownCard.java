package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.view.VoteCountDownView;
/* loaded from: classes3.dex */
public class VoteCountDownCard extends LinearLayout {
    private f epN;
    private a eqr;
    private e erj;
    private VoteCountDownView.a euA;
    private VoteCountDownView euw;
    private TextView eux;
    private TextView euy;
    private TextView euz;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void onRefresh();
    }

    public VoteCountDownCard(Context context) {
        this(context, null);
    }

    public VoteCountDownCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.euA = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.aXn();
                if (VoteCountDownCard.this.eqr != null) {
                    VoteCountDownCard.this.eqr.onRefresh();
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
        LayoutInflater.from(getContext()).inflate(R.layout.vote_count_down_card, (ViewGroup) this, true);
        qA();
        int g = l.g(this.mContext, R.dimen.tbds56);
        int g2 = l.g(this.mContext, R.dimen.tbds52);
        setPadding(g, g2, g, g2);
    }

    private void qA() {
        this.euz = (TextView) findViewById(R.id.count_down_view_title);
        this.euw = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.eux = (TextView) findViewById(R.id.candidate_num);
        this.euy = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.epN = fVar;
        if (this.epN == null || this.epN.aWQ() == null) {
            setVisibility(8);
            return;
        }
        this.erj = this.epN.aWQ();
        if (this.erj.getStatus() != d.etW) {
            setVisibility(8);
            return;
        }
        long aWL = this.erj.aWL();
        if (this.euA != null) {
            this.euw.setOnCountDownFinished(this.euA);
        }
        this.euw.setData(aWL * 1000);
        this.eux.setText("候选人" + this.erj.aWH());
        this.euy.setText("投票数" + this.erj.aWI() + "");
    }

    public void nq(int i) {
        al.c(this.euz, R.color.cp_cont_b, 1, i);
        al.c(this.eux, R.color.cp_cont_b, 1, i);
        al.c(this.euy, R.color.cp_cont_b, 1, i);
        al.g(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.euw != null) {
            this.euw.nq(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXn() {
        this.euz.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.eqr = aVar;
    }

    public void onDestroy() {
        if (this.euw != null) {
            this.euw.onDestroy();
        }
    }
}
