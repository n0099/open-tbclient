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
/* loaded from: classes8.dex */
public class VoteCountDownCard extends LinearLayout {
    private a fDE;
    private f fDc;
    private e fEv;
    private VoteCountDownView fHF;
    private TextView fHG;
    private TextView fHH;
    private TextView fHI;
    private VoteCountDownView.a fHJ;
    private Context mContext;

    /* loaded from: classes8.dex */
    public interface a {
        void onRefresh();
    }

    public VoteCountDownCard(Context context) {
        this(context, null);
    }

    public VoteCountDownCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fHJ = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.buL();
                if (VoteCountDownCard.this.fDE != null) {
                    VoteCountDownCard.this.fDE.onRefresh();
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
        ns();
        int dimens = l.getDimens(this.mContext, R.dimen.tbds56);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds52);
        setPadding(dimens, dimens2, dimens, dimens2);
    }

    private void ns() {
        this.fHI = (TextView) findViewById(R.id.count_down_view_title);
        this.fHF = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.fHG = (TextView) findViewById(R.id.candidate_num);
        this.fHH = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.fDc = fVar;
        if (this.fDc == null || this.fDc.buo() == null) {
            setVisibility(8);
            return;
        }
        this.fEv = this.fDc.buo();
        if (this.fEv.getStatus() != d.fHf) {
            setVisibility(8);
            return;
        }
        long buj = this.fEv.buj();
        if (this.fHJ != null) {
            this.fHF.setOnCountDownFinished(this.fHJ);
        }
        this.fHF.setData(buj * 1000);
        this.fHG.setText("候选人" + this.fEv.buf());
        this.fHH.setText("投票数" + this.fEv.bug() + "");
    }

    public void pm(int i) {
        am.setViewTextColor(this.fHI, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fHG, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fHH, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.fHF != null) {
            this.fHF.pm(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buL() {
        this.fHI.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.fDE = aVar;
    }

    public void onDestroy() {
        if (this.fHF != null) {
            this.fHF.onDestroy();
        }
    }
}
