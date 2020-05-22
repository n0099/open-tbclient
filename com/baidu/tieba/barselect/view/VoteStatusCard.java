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
    private TextView gBj;
    private VoteStatusView gBk;
    private TextView gBl;
    private TextView gBm;
    private TextView gBn;
    private TextView gBo;
    private TextView gBp;
    private TextView gBq;
    private NewVoteCountDownView gBr;
    private View gBs;
    private NewVoteCountDownView.a gBt;
    private f gwA;
    private e gxV;
    private a gxd;
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
        this.status = d.gAG;
        this.gBt = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void Qv() {
                if (VoteStatusCard.this.gxd != null) {
                    VoteStatusCard.this.gxd.onRefresh();
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
        bKN();
    }

    private void rV() {
        this.gBj = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.gBk = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.gBl = (TextView) findViewById(R.id.apply_title);
        this.gBm = (TextView) findViewById(R.id.apply_start_time);
        this.gBn = (TextView) findViewById(R.id.vote_title);
        this.gBo = (TextView) findViewById(R.id.vote_start_time);
        this.gBp = (TextView) findViewById(R.id.publicity_title);
        this.gBq = (TextView) findViewById(R.id.publicity_start_time);
        this.gBs = findViewById(R.id.vote_count_down_container);
        this.gBr = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void bKN() {
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
        this.gwA = fVar;
        if (this.gwA == null || this.gwA.bKo() == null) {
            setVisibility(8);
            return;
        }
        this.gxV = this.gwA.bKo();
        this.status = this.gxV.getStatus();
        this.gBk.setStatus(this.status);
        long bKj = this.gxV.bKj() * 1000;
        this.gBm.setText(aq.cg(this.gxV.bKh() * 1000));
        this.gBo.setText(aq.cf(this.gxV.bKk() * 1000));
        this.gBq.setText(aq.cf(this.gxV.bKi() * 1000));
        if (this.status == d.gAG) {
            this.gBs.setVisibility(0);
            if (this.gBt != null) {
                this.gBr.setOnCountDownFinished(this.gBt);
            }
            this.gBr.setData(bKj);
            return;
        }
        this.gBs.setVisibility(8);
    }

    public void qi(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.gBl != null) {
            this.gBl.setTextColor(color);
        }
        if (this.gBn != null) {
            this.gBn.setTextColor(this.status > d.gAF ? color : color2);
        }
        if (this.gBp != null) {
            TextView textView = this.gBp;
            if (this.status <= d.gAG) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.gBk != null) {
            this.gBk.qi(i);
        }
        am.setViewTextColor(this.gBj, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gBm, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gBo, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gBq, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.gBr != null) {
            this.gBr.qi(i);
        }
        int color3 = am.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.gBs.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.gxd = aVar;
    }

    public void onDestroy() {
        if (this.gBr != null) {
            this.gBr.onDestroy();
        }
    }
}
