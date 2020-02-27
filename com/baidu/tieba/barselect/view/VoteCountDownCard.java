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
    private a fCH;
    private f fCf;
    private e fDy;
    private VoteCountDownView fGI;
    private TextView fGJ;
    private TextView fGK;
    private TextView fGL;
    private VoteCountDownView.a fGM;
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
        this.fGM = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.buD();
                if (VoteCountDownCard.this.fCH != null) {
                    VoteCountDownCard.this.fCH.onRefresh();
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
        this.fGL = (TextView) findViewById(R.id.count_down_view_title);
        this.fGI = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.fGJ = (TextView) findViewById(R.id.candidate_num);
        this.fGK = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.fCf = fVar;
        if (this.fCf == null || this.fCf.bug() == null) {
            setVisibility(8);
            return;
        }
        this.fDy = this.fCf.bug();
        if (this.fDy.getStatus() != d.fGi) {
            setVisibility(8);
            return;
        }
        long bub = this.fDy.bub();
        if (this.fGM != null) {
            this.fGI.setOnCountDownFinished(this.fGM);
        }
        this.fGI.setData(bub * 1000);
        this.fGJ.setText("候选人" + this.fDy.btX());
        this.fGK.setText("投票数" + this.fDy.btY() + "");
    }

    public void pk(int i) {
        am.setViewTextColor(this.fGL, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fGJ, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.fGK, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.fGI != null) {
            this.fGI.pk(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buD() {
        this.fGL.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.fCH = aVar;
    }

    public void onDestroy() {
        if (this.fGI != null) {
            this.fGI.onDestroy();
        }
    }
}
