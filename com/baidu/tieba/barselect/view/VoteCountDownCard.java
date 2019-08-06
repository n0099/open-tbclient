package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.view.VoteCountDownView;
/* loaded from: classes3.dex */
public class VoteCountDownCard extends LinearLayout {
    private f euT;
    private a evx;
    private e ewp;
    private VoteCountDownView ezD;
    private TextView ezE;
    private TextView ezF;
    private TextView ezG;
    private VoteCountDownView.a ezH;
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
        this.ezH = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.aZp();
                if (VoteCountDownCard.this.evx != null) {
                    VoteCountDownCard.this.evx.onRefresh();
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
        qX();
        int g = l.g(this.mContext, R.dimen.tbds56);
        int g2 = l.g(this.mContext, R.dimen.tbds52);
        setPadding(g, g2, g, g2);
    }

    private void qX() {
        this.ezG = (TextView) findViewById(R.id.count_down_view_title);
        this.ezD = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.ezE = (TextView) findViewById(R.id.candidate_num);
        this.ezF = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.euT = fVar;
        if (this.euT == null || this.euT.aYR() == null) {
            setVisibility(8);
            return;
        }
        this.ewp = this.euT.aYR();
        if (this.ewp.getStatus() != d.ezd) {
            setVisibility(8);
            return;
        }
        long aYM = this.ewp.aYM();
        if (this.ezH != null) {
            this.ezD.setOnCountDownFinished(this.ezH);
        }
        this.ezD.setData(aYM * 1000);
        this.ezE.setText("候选人" + this.ewp.aYI());
        this.ezF.setText("投票数" + this.ewp.aYJ() + "");
    }

    public void nA(int i) {
        am.d(this.ezG, R.color.cp_cont_b, 1, i);
        am.d(this.ezE, R.color.cp_cont_b, 1, i);
        am.d(this.ezF, R.color.cp_cont_b, 1, i);
        am.g(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.ezD != null) {
            this.ezD.nA(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZp() {
        this.ezG.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.evx = aVar;
    }

    public void onDestroy() {
        if (this.ezD != null) {
            this.ezD.onDestroy();
        }
    }
}
