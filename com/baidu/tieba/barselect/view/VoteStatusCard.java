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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.view.NewVoteCountDownView;
/* loaded from: classes15.dex */
public class VoteStatusCard extends LinearLayout {
    private a gPI;
    private f gPf;
    private e gQy;
    private TextView gTL;
    private VoteStatusView gTM;
    private TextView gTN;
    private TextView gTO;
    private TextView gTP;
    private TextView gTQ;
    private TextView gTR;
    private TextView gTS;
    private NewVoteCountDownView gTT;
    private View gTU;
    private NewVoteCountDownView.a gTV;
    private Context mContext;
    private Path mPath;
    private int status;

    /* loaded from: classes15.dex */
    public interface a {
        void onRefresh();
    }

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.gTi;
        this.gTV = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void RQ() {
                if (VoteStatusCard.this.gPI != null) {
                    VoteStatusCard.this.gPI.onRefresh();
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
        ss();
        bRg();
    }

    private void ss() {
        this.gTL = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.gTM = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.gTN = (TextView) findViewById(R.id.apply_title);
        this.gTO = (TextView) findViewById(R.id.apply_start_time);
        this.gTP = (TextView) findViewById(R.id.vote_title);
        this.gTQ = (TextView) findViewById(R.id.vote_start_time);
        this.gTR = (TextView) findViewById(R.id.publicity_title);
        this.gTS = (TextView) findViewById(R.id.publicity_start_time);
        this.gTU = findViewById(R.id.vote_count_down_container);
        this.gTT = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void bRg() {
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
        this.gPf = fVar;
        if (this.gPf == null || this.gPf.bQH() == null) {
            setVisibility(8);
            return;
        }
        this.gQy = this.gPf.bQH();
        this.status = this.gQy.getStatus();
        this.gTM.setStatus(this.status);
        long bQC = this.gQy.bQC() * 1000;
        this.gTO.setText(as.cy(this.gQy.bQA() * 1000));
        this.gTQ.setText(as.cx(this.gQy.bQD() * 1000));
        this.gTS.setText(as.cx(this.gQy.bQB() * 1000));
        if (this.status == d.gTi) {
            this.gTU.setVisibility(0);
            if (this.gTV != null) {
                this.gTT.setOnCountDownFinished(this.gTV);
            }
            this.gTT.setData(bQC);
            return;
        }
        this.gTU.setVisibility(8);
    }

    public void qZ(int i) {
        int color = ao.getColor(i, R.color.cp_cont_b);
        int color2 = ao.getColor(i, R.color.cp_cont_d);
        if (this.gTN != null) {
            this.gTN.setTextColor(color);
        }
        if (this.gTP != null) {
            this.gTP.setTextColor(this.status > d.gTh ? color : color2);
        }
        if (this.gTR != null) {
            TextView textView = this.gTR;
            if (this.status <= d.gTi) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.gTM != null) {
            this.gTM.qZ(i);
        }
        ao.setViewTextColor(this.gTL, R.color.cp_cont_b, 1, i);
        ao.setViewTextColor(this.gTO, R.color.cp_cont_d, 1, i);
        ao.setViewTextColor(this.gTQ, R.color.cp_cont_d, 1, i);
        ao.setViewTextColor(this.gTS, R.color.cp_cont_d, 1, i);
        ao.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.gTT != null) {
            this.gTT.qZ(i);
        }
        int color3 = ao.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.gTU.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.gPI = aVar;
    }

    public void onDestroy() {
        if (this.gTT != null) {
            this.gTT.onDestroy();
        }
    }
}
