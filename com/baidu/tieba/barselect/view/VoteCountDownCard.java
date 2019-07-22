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
    private f euM;
    private a evq;
    private e ewi;
    private VoteCountDownView.a ezA;
    private VoteCountDownView ezw;
    private TextView ezx;
    private TextView ezy;
    private TextView ezz;
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
        this.ezA = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.aZn();
                if (VoteCountDownCard.this.evq != null) {
                    VoteCountDownCard.this.evq.onRefresh();
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
        this.ezz = (TextView) findViewById(R.id.count_down_view_title);
        this.ezw = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.ezx = (TextView) findViewById(R.id.candidate_num);
        this.ezy = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.euM = fVar;
        if (this.euM == null || this.euM.aYP() == null) {
            setVisibility(8);
            return;
        }
        this.ewi = this.euM.aYP();
        if (this.ewi.getStatus() != d.eyW) {
            setVisibility(8);
            return;
        }
        long aYK = this.ewi.aYK();
        if (this.ezA != null) {
            this.ezw.setOnCountDownFinished(this.ezA);
        }
        this.ezw.setData(aYK * 1000);
        this.ezx.setText("候选人" + this.ewi.aYG());
        this.ezy.setText("投票数" + this.ewi.aYH() + "");
    }

    public void nz(int i) {
        am.d(this.ezz, R.color.cp_cont_b, 1, i);
        am.d(this.ezx, R.color.cp_cont_b, 1, i);
        am.d(this.ezy, R.color.cp_cont_b, 1, i);
        am.g(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.ezw != null) {
            this.ezw.nz(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZn() {
        this.ezz.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.evq = aVar;
    }

    public void onDestroy() {
        if (this.ezw != null) {
            this.ezw.onDestroy();
        }
    }
}
