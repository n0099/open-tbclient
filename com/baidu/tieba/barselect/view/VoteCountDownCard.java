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
    private a eFR;
    private f eFp;
    private e eGI;
    private VoteCountDownView eJU;
    private TextView eJV;
    private TextView eJW;
    private TextView eJX;
    private VoteCountDownView.a eJY;
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
        this.eJY = new VoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteCountDownCard.1
            @Override // com.baidu.tieba.view.VoteCountDownView.a
            public void onFinished() {
                VoteCountDownCard.this.aZW();
                if (VoteCountDownCard.this.eFR != null) {
                    VoteCountDownCard.this.eFR.onRefresh();
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
        this.eJX = (TextView) findViewById(R.id.count_down_view_title);
        this.eJU = (VoteCountDownView) findViewById(R.id.count_down_view);
        this.eJV = (TextView) findViewById(R.id.candidate_num);
        this.eJW = (TextView) findViewById(R.id.totel_vote_num);
    }

    public void setData(f fVar) {
        this.eFp = fVar;
        if (this.eFp == null || this.eFp.aZy() == null) {
            setVisibility(8);
            return;
        }
        this.eGI = this.eFp.aZy();
        if (this.eGI.getStatus() != d.eJu) {
            setVisibility(8);
            return;
        }
        long aZt = this.eGI.aZt();
        if (this.eJY != null) {
            this.eJU.setOnCountDownFinished(this.eJY);
        }
        this.eJU.setData(aZt * 1000);
        this.eJV.setText("候选人" + this.eGI.aZp());
        this.eJW.setText("投票数" + this.eGI.aZq() + "");
    }

    public void mE(int i) {
        am.setViewTextColor(this.eJX, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.eJV, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.eJW, R.color.cp_cont_b, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.eJU != null) {
            this.eJU.mE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZW() {
        this.eJX.setText(getResources().getString(R.string.vote_finished_tip));
    }

    public void setOnRefreshListener(a aVar) {
        this.eFR = aVar;
    }

    public void onDestroy() {
        if (this.eJU != null) {
            this.eJU.onDestroy();
        }
    }
}
