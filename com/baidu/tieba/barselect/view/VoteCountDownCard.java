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
    private f eEy;
    private e eFR;
    private a eFa;
    private VoteCountDownView eJd;
    private TextView eJe;
    private TextView eJf;
    private TextView eJg;
    private VoteCountDownView.a eJh;
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
        this.eJh = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.aZU();
                if (VoteCountDownCard.this.eFa != null) {
                    VoteCountDownCard.this.eFa.onRefresh();
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
        md();
        int dimens = l.getDimens(this.mContext, R.dimen.tbds56);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds52);
        setPadding(dimens, dimens2, dimens, dimens2);
    }

    private void md() {
        this.eJg = (TextView) findViewById(R.id.count_down_view_title);
        this.eJd = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.eJe = (TextView) findViewById(R.id.candidate_num);
        this.eJf = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.eEy = fVar;
        if (this.eEy == null || this.eEy.aZw() == null) {
            setVisibility(8);
            return;
        }
        this.eFR = this.eEy.aZw();
        if (this.eFR.getStatus() != d.eID) {
            setVisibility(8);
            return;
        }
        long aZr = this.eFR.aZr();
        if (this.eJh != null) {
            this.eJd.setOnCountDownFinished(this.eJh);
        }
        this.eJd.setData(aZr * 1000);
        this.eJe.setText("候选人" + this.eFR.aZn());
        this.eJf.setText("投票数" + this.eFR.aZo() + "");
    }

    public void mD(int i) {
        am.setViewTextColor(this.eJg, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.eJe, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.eJf, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.eJd != null) {
            this.eJd.mD(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZU() {
        this.eJg.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.eFa = aVar;
    }

    public void onDestroy() {
        if (this.eJd != null) {
            this.eJd.onDestroy();
        }
    }
}
