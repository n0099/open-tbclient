package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.view.NewVoteCountDownView;
/* loaded from: classes20.dex */
public class VoteStatusCard extends LinearLayout {
    private f hiY;
    private a hjB;
    private e hku;
    private TextView hnM;
    private VoteStatusView hnN;
    private TextView hnO;
    private TextView hnP;
    private TextView hnQ;
    private TextView hnR;
    private TextView hnS;
    private TextView hnT;
    private NewVoteCountDownView hnU;
    private View hnV;
    private NewVoteCountDownView.a hnW;
    private Context mContext;
    private Path mPath;
    private int status;

    /* loaded from: classes20.dex */
    public interface a {
        void onRefresh();
    }

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.hng;
        this.hnW = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void Yu() {
                if (VoteStatusCard.this.hjB != null) {
                    VoteStatusCard.this.hjB.onRefresh();
                }
            }
        };
        initUI();
    }

    private void initUI() {
        this.mContext = getContext();
        setOrientation(1);
        setMinimumHeight(l.getDimens(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds56);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds52);
        setPadding(dimens, dimens2, dimens, dimens2);
        LayoutInflater.from(getContext()).inflate(R.layout.vote_status_card, (ViewGroup) this, true);
        ul();
        ceI();
    }

    private void ul() {
        this.hnM = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.hnN = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.hnO = (TextView) findViewById(R.id.apply_title);
        this.hnP = (TextView) findViewById(R.id.apply_start_time);
        this.hnQ = (TextView) findViewById(R.id.vote_title);
        this.hnR = (TextView) findViewById(R.id.vote_start_time);
        this.hnS = (TextView) findViewById(R.id.publicity_title);
        this.hnT = (TextView) findViewById(R.id.publicity_start_time);
        this.hnV = findViewById(R.id.vote_count_down_container);
        this.hnU = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void ceI() {
        this.mPath = new Path();
        this.mPath.moveTo(0.0f, 15.0f);
        this.mPath.lineTo(440.0f, 15.0f);
        this.mPath.lineTo(454.0f, 0.0f);
        this.mPath.lineTo(468.0f, 15.0f);
        this.mPath.lineTo(902.0f, 15.0f);
        this.mPath.lineTo(902.0f, 224.0f);
        this.mPath.lineTo(0.0f, 224.0f);
        this.mPath.lineTo(0.0f, 15.0f);
        this.mPath.close();
    }

    public void setData(f fVar) {
        this.hiY = fVar;
        if (this.hiY == null || this.hiY.cei() == null) {
            setVisibility(8);
            return;
        }
        this.hku = this.hiY.cei();
        this.status = this.hku.getStatus();
        this.hnN.setStatus(this.status);
        long cec = this.hku.cec() * 1000;
        this.hnP.setText(at.cK(this.hku.cea() * 1000));
        this.hnR.setText(at.cJ(this.hku.ced() * 1000));
        this.hnT.setText(at.cJ(this.hku.ceb() * 1000));
        if (this.status == d.hng) {
            this.hnV.setVisibility(0);
            if (this.hnW != null) {
                this.hnU.setOnCountDownFinished(this.hnW);
            }
            this.hnU.setData(cec);
            return;
        }
        this.hnV.setVisibility(8);
    }

    public void tE(int i) {
        int color = ap.getColor(i, R.color.cp_cont_b);
        int color2 = ap.getColor(i, R.color.cp_cont_d);
        if (this.hnO != null) {
            this.hnO.setTextColor(color);
        }
        if (this.hnQ != null) {
            this.hnQ.setTextColor(this.status > d.hnf ? color : color2);
        }
        if (this.hnS != null) {
            TextView textView = this.hnS;
            if (this.status <= d.hng) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.hnN != null) {
            this.hnN.tE(i);
        }
        ap.setViewTextColor(this.hnM, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hnP, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hnR, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hnT, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.hnU != null) {
            this.hnU.tE(i);
        }
        int color3 = ap.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.hnV.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.hjB = aVar;
    }

    public void onDestroy() {
        if (this.hnU != null) {
            this.hnU.onDestroy();
        }
    }
}
