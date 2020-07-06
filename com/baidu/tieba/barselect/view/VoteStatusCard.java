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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.view.NewVoteCountDownView;
/* loaded from: classes8.dex */
public class VoteStatusCard extends LinearLayout {
    private f gJz;
    private e gKS;
    private a gKc;
    private TextView gOf;
    private VoteStatusView gOg;
    private TextView gOh;
    private TextView gOi;
    private TextView gOj;
    private TextView gOk;
    private TextView gOl;
    private TextView gOm;
    private NewVoteCountDownView gOn;
    private View gOo;
    private NewVoteCountDownView.a gOp;
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
        this.status = d.gNC;
        this.gOp = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void RB() {
                if (VoteStatusCard.this.gKc != null) {
                    VoteStatusCard.this.gKc.onRefresh();
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
        sq();
        bNV();
    }

    private void sq() {
        this.gOf = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.gOg = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.gOh = (TextView) findViewById(R.id.apply_title);
        this.gOi = (TextView) findViewById(R.id.apply_start_time);
        this.gOj = (TextView) findViewById(R.id.vote_title);
        this.gOk = (TextView) findViewById(R.id.vote_start_time);
        this.gOl = (TextView) findViewById(R.id.publicity_title);
        this.gOm = (TextView) findViewById(R.id.publicity_start_time);
        this.gOo = findViewById(R.id.vote_count_down_container);
        this.gOn = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void bNV() {
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
        this.gJz = fVar;
        if (this.gJz == null || this.gJz.bNw() == null) {
            setVisibility(8);
            return;
        }
        this.gKS = this.gJz.bNw();
        this.status = this.gKS.getStatus();
        this.gOg.setStatus(this.status);
        long bNr = this.gKS.bNr() * 1000;
        this.gOi.setText(ar.ch(this.gKS.bNp() * 1000));
        this.gOk.setText(ar.cg(this.gKS.bNs() * 1000));
        this.gOm.setText(ar.cg(this.gKS.bNq() * 1000));
        if (this.status == d.gNC) {
            this.gOo.setVisibility(0);
            if (this.gOp != null) {
                this.gOn.setOnCountDownFinished(this.gOp);
            }
            this.gOn.setData(bNr);
            return;
        }
        this.gOo.setVisibility(8);
    }

    public void qJ(int i) {
        int color = an.getColor(i, R.color.cp_cont_b);
        int color2 = an.getColor(i, R.color.cp_cont_d);
        if (this.gOh != null) {
            this.gOh.setTextColor(color);
        }
        if (this.gOj != null) {
            this.gOj.setTextColor(this.status > d.gNB ? color : color2);
        }
        if (this.gOl != null) {
            TextView textView = this.gOl;
            if (this.status <= d.gNC) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.gOg != null) {
            this.gOg.qJ(i);
        }
        an.setViewTextColor(this.gOf, R.color.cp_cont_b, 1, i);
        an.setViewTextColor(this.gOi, R.color.cp_cont_d, 1, i);
        an.setViewTextColor(this.gOk, R.color.cp_cont_d, 1, i);
        an.setViewTextColor(this.gOm, R.color.cp_cont_d, 1, i);
        an.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.gOn != null) {
            this.gOn.qJ(i);
        }
        int color3 = an.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.gOo.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.gKc = aVar;
    }

    public void onDestroy() {
        if (this.gOn != null) {
            this.gOn.onDestroy();
        }
    }
}
