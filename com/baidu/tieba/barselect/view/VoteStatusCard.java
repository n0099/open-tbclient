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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.view.NewVoteCountDownView;
/* loaded from: classes8.dex */
public class VoteStatusCard extends LinearLayout {
    private TextView gBA;
    private TextView gBB;
    private NewVoteCountDownView gBC;
    private View gBD;
    private NewVoteCountDownView.a gBE;
    private TextView gBu;
    private VoteStatusView gBv;
    private TextView gBw;
    private TextView gBx;
    private TextView gBy;
    private TextView gBz;
    private f gwL;
    private a gxo;
    private e gyg;
    private Context mContext;
    private Path mPath;
    private int status;

    /* loaded from: classes8.dex */
    public interface a {
        void onRefresh();
    }

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.gAR;
        this.gBE = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void Qv() {
                if (VoteStatusCard.this.gxo != null) {
                    VoteStatusCard.this.gxo.onRefresh();
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
        rV();
        bKP();
    }

    private void rV() {
        this.gBu = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.gBv = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.gBw = (TextView) findViewById(R.id.apply_title);
        this.gBx = (TextView) findViewById(R.id.apply_start_time);
        this.gBy = (TextView) findViewById(R.id.vote_title);
        this.gBz = (TextView) findViewById(R.id.vote_start_time);
        this.gBA = (TextView) findViewById(R.id.publicity_title);
        this.gBB = (TextView) findViewById(R.id.publicity_start_time);
        this.gBD = findViewById(R.id.vote_count_down_container);
        this.gBC = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void bKP() {
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
        this.gwL = fVar;
        if (this.gwL == null || this.gwL.bKq() == null) {
            setVisibility(8);
            return;
        }
        this.gyg = this.gwL.bKq();
        this.status = this.gyg.getStatus();
        this.gBv.setStatus(this.status);
        long bKl = this.gyg.bKl() * 1000;
        this.gBx.setText(aq.cg(this.gyg.bKj() * 1000));
        this.gBz.setText(aq.cf(this.gyg.bKm() * 1000));
        this.gBB.setText(aq.cf(this.gyg.bKk() * 1000));
        if (this.status == d.gAR) {
            this.gBD.setVisibility(0);
            if (this.gBE != null) {
                this.gBC.setOnCountDownFinished(this.gBE);
            }
            this.gBC.setData(bKl);
            return;
        }
        this.gBD.setVisibility(8);
    }

    public void qk(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.gBw != null) {
            this.gBw.setTextColor(color);
        }
        if (this.gBy != null) {
            this.gBy.setTextColor(this.status > d.gAQ ? color : color2);
        }
        if (this.gBA != null) {
            TextView textView = this.gBA;
            if (this.status <= d.gAR) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.gBv != null) {
            this.gBv.qk(i);
        }
        am.setViewTextColor(this.gBu, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gBx, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gBz, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gBB, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.gBC != null) {
            this.gBC.qk(i);
        }
        int color3 = am.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.gBD.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.gxo = aVar;
    }

    public void onDestroy() {
        if (this.gBC != null) {
            this.gBC.onDestroy();
        }
    }
}
