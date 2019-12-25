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
/* loaded from: classes5.dex */
public class VoteCountDownCard extends LinearLayout {
    private VoteCountDownView fBa;
    private TextView fBb;
    private TextView fBc;
    private TextView fBd;
    private VoteCountDownView.a fBe;
    private a fwY;
    private f fww;
    private e fxP;
    private Context mContext;

    /* loaded from: classes5.dex */
    public interface a {
        void onRefresh();
    }

    public VoteCountDownCard(Context context) {
        this(context, null);
    }

    public VoteCountDownCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBe = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.brX();
                if (VoteCountDownCard.this.fwY != null) {
                    VoteCountDownCard.this.fwY.onRefresh();
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
        na();
        int dimens = l.getDimens(this.mContext, R.dimen.tbds56);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds52);
        setPadding(dimens, dimens2, dimens, dimens2);
    }

    private void na() {
        this.fBd = (TextView) findViewById(R.id.count_down_view_title);
        this.fBa = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.fBb = (TextView) findViewById(R.id.candidate_num);
        this.fBc = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.fww = fVar;
        if (this.fww == null || this.fww.brA() == null) {
            setVisibility(8);
            return;
        }
        this.fxP = this.fww.brA();
        if (this.fxP.getStatus() != d.fAA) {
            setVisibility(8);
            return;
        }
        long brv = this.fxP.brv();
        if (this.fBe != null) {
            this.fBa.setOnCountDownFinished(this.fBe);
        }
        this.fBa.setData(brv * 1000);
        this.fBb.setText("候选人" + this.fxP.brr());
        this.fBc.setText("投票数" + this.fxP.brs() + "");
    }

    public void oT(int i) {
        am.setViewTextColor(this.fBd, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fBb, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fBc, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.fBa != null) {
            this.fBa.oT(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brX() {
        this.fBd.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.fwY = aVar;
    }

    public void onDestroy() {
        if (this.fBa != null) {
            this.fBa.onDestroy();
        }
    }
}
