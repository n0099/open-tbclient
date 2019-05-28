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
    private f epO;
    private a eqs;
    private e erk;
    private TextView euA;
    private VoteCountDownView.a euB;
    private VoteCountDownView eux;
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
        this.euB = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.aXq();
                if (VoteCountDownCard.this.eqs != null) {
                    VoteCountDownCard.this.eqs.onRefresh();
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
        this.euA = (TextView) findViewById(R.id.count_down_view_title);
        this.eux = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.euy = (TextView) findViewById(R.id.candidate_num);
        this.euz = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.epO = fVar;
        if (this.epO == null || this.epO.aWT() == null) {
            setVisibility(8);
            return;
        }
        this.erk = this.epO.aWT();
        if (this.erk.getStatus() != d.etX) {
            setVisibility(8);
            return;
        }
        long aWO = this.erk.aWO();
        if (this.euB != null) {
            this.eux.setOnCountDownFinished(this.euB);
        }
        this.eux.setData(aWO * 1000);
        this.euy.setText("候选人" + this.erk.aWK());
        this.euz.setText("投票数" + this.erk.aWL() + "");
    }

    public void nq(int i) {
        al.c(this.euA, R.color.cp_cont_b, 1, i);
        al.c(this.euy, R.color.cp_cont_b, 1, i);
        al.c(this.euz, R.color.cp_cont_b, 1, i);
        al.g(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.eux != null) {
            this.eux.nq(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXq() {
        this.euA.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.eqs = aVar;
    }

    public void onDestroy() {
        if (this.eux != null) {
            this.eux.onDestroy();
        }
    }
}
