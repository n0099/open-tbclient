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
    private a fCW;
    private f fCu;
    private e fDN;
    private VoteCountDownView fGX;
    private TextView fGY;
    private TextView fGZ;
    private TextView fHa;
    private VoteCountDownView.a fHb;
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
        this.fHb = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.buG();
                if (VoteCountDownCard.this.fCW != null) {
                    VoteCountDownCard.this.fCW.onRefresh();
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
        this.fHa = (TextView) findViewById(R.id.count_down_view_title);
        this.fGX = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.fGY = (TextView) findViewById(R.id.candidate_num);
        this.fGZ = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.fCu = fVar;
        if (this.fCu == null || this.fCu.buj() == null) {
            setVisibility(8);
            return;
        }
        this.fDN = this.fCu.buj();
        if (this.fDN.getStatus() != d.fGx) {
            setVisibility(8);
            return;
        }
        long bue = this.fDN.bue();
        if (this.fHb != null) {
            this.fGX.setOnCountDownFinished(this.fHb);
        }
        this.fGX.setData(bue * 1000);
        this.fGY.setText("候选人" + this.fDN.bua());
        this.fGZ.setText("投票数" + this.fDN.bub() + "");
    }

    public void pk(int i) {
        am.setViewTextColor(this.fHa, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fGY, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fGZ, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.fGX != null) {
            this.fGX.pk(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buG() {
        this.fHa.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.fCW = aVar;
    }

    public void onDestroy() {
        if (this.fGX != null) {
            this.fGX.onDestroy();
        }
    }
}
