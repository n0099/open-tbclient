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
    private VoteCountDownView eBm;
    private TextView eBn;
    private TextView eBo;
    private TextView eBp;
    private VoteCountDownView.a eBq;
    private f ewD;
    private e exZ;
    private a exh;
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
        this.eBq = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.aZT();
                if (VoteCountDownCard.this.exh != null) {
                    VoteCountDownCard.this.exh.onRefresh();
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
        qY();
        int g = l.g(this.mContext, R.dimen.tbds56);
        int g2 = l.g(this.mContext, R.dimen.tbds52);
        setPadding(g, g2, g, g2);
    }

    private void qY() {
        this.eBp = (TextView) findViewById(R.id.count_down_view_title);
        this.eBm = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.eBn = (TextView) findViewById(R.id.candidate_num);
        this.eBo = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.ewD = fVar;
        if (this.ewD == null || this.ewD.aZv() == null) {
            setVisibility(8);
            return;
        }
        this.exZ = this.ewD.aZv();
        if (this.exZ.getStatus() != d.eAM) {
            setVisibility(8);
            return;
        }
        long aZq = this.exZ.aZq();
        if (this.eBq != null) {
            this.eBm.setOnCountDownFinished(this.eBq);
        }
        this.eBm.setData(aZq * 1000);
        this.eBn.setText("候选人" + this.exZ.aZm());
        this.eBo.setText("投票数" + this.exZ.aZn() + "");
    }

    public void nE(int i) {
        am.d(this.eBp, R.color.cp_cont_b, 1, i);
        am.d(this.eBn, R.color.cp_cont_b, 1, i);
        am.d(this.eBo, R.color.cp_cont_b, 1, i);
        am.g(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.eBm != null) {
            this.eBm.nE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZT() {
        this.eBp.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.exh = aVar;
    }

    public void onDestroy() {
        if (this.eBm != null) {
            this.eBm.onDestroy();
        }
    }
}
