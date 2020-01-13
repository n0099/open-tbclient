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
/* loaded from: classes6.dex */
public class VoteCountDownCard extends LinearLayout {
    private a fAj;
    private e fBa;
    private VoteCountDownView fEl;
    private TextView fEm;
    private TextView fEn;
    private TextView fEo;
    private VoteCountDownView.a fEp;
    private f fzH;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void onRefresh();
    }

    public VoteCountDownCard(Context context) {
        this(context, null);
    }

    public VoteCountDownCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEp = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.bsZ();
                if (VoteCountDownCard.this.fAj != null) {
                    VoteCountDownCard.this.fAj.onRefresh();
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
        nb();
        int dimens = l.getDimens(this.mContext, R.dimen.tbds56);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds52);
        setPadding(dimens, dimens2, dimens, dimens2);
    }

    private void nb() {
        this.fEo = (TextView) findViewById(R.id.count_down_view_title);
        this.fEl = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.fEm = (TextView) findViewById(R.id.candidate_num);
        this.fEn = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.fzH = fVar;
        if (this.fzH == null || this.fzH.bsC() == null) {
            setVisibility(8);
            return;
        }
        this.fBa = this.fzH.bsC();
        if (this.fBa.getStatus() != d.fDL) {
            setVisibility(8);
            return;
        }
        long bsx = this.fBa.bsx();
        if (this.fEp != null) {
            this.fEl.setOnCountDownFinished(this.fEp);
        }
        this.fEl.setData(bsx * 1000);
        this.fEm.setText("候选人" + this.fBa.bst());
        this.fEn.setText("投票数" + this.fBa.bsu() + "");
    }

    public void oU(int i) {
        am.setViewTextColor(this.fEo, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fEm, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fEn, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.fEl != null) {
            this.fEl.oU(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsZ() {
        this.fEo.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.fAj = aVar;
    }

    public void onDestroy() {
        if (this.fEl != null) {
            this.fEl.onDestroy();
        }
    }
}
