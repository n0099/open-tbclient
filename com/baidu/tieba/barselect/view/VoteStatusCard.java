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
/* loaded from: classes21.dex */
public class VoteStatusCard extends LinearLayout {
    private a hQP;
    private f hQm;
    private e hRI;
    private TextView hUZ;
    private VoteStatusView hVa;
    private TextView hVb;
    private TextView hVc;
    private TextView hVd;
    private TextView hVe;
    private TextView hVf;
    private TextView hVg;
    private NewVoteCountDownView hVh;
    private View hVi;
    private NewVoteCountDownView.a hVj;
    private Context mContext;
    private Path mPath;
    private int status;

    /* loaded from: classes21.dex */
    public interface a {
        void onRefresh();
    }

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.hUt;
        this.hVj = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void afA() {
                if (VoteStatusCard.this.hQP != null) {
                    VoteStatusCard.this.hQP.onRefresh();
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
        cnM();
    }

    private void ul() {
        this.hUZ = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.hVa = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.hVb = (TextView) findViewById(R.id.apply_title);
        this.hVc = (TextView) findViewById(R.id.apply_start_time);
        this.hVd = (TextView) findViewById(R.id.vote_title);
        this.hVe = (TextView) findViewById(R.id.vote_start_time);
        this.hVf = (TextView) findViewById(R.id.publicity_title);
        this.hVg = (TextView) findViewById(R.id.publicity_start_time);
        this.hVi = findViewById(R.id.vote_count_down_container);
        this.hVh = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void cnM() {
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
        this.hQm = fVar;
        if (this.hQm == null || this.hQm.cnn() == null) {
            setVisibility(8);
            return;
        }
        this.hRI = this.hQm.cnn();
        this.status = this.hRI.getStatus();
        this.hVa.setStatus(this.status);
        long cnh = this.hRI.cnh() * 1000;
        this.hVc.setText(at.dq(this.hRI.cnf() * 1000));
        this.hVe.setText(at.dp(this.hRI.cni() * 1000));
        this.hVg.setText(at.dp(this.hRI.cng() * 1000));
        if (this.status == d.hUt) {
            this.hVi.setVisibility(0);
            if (this.hVj != null) {
                this.hVh.setOnCountDownFinished(this.hVj);
            }
            this.hVh.setData(cnh);
            return;
        }
        this.hVi.setVisibility(8);
    }

    public void uE(int i) {
        int color = ap.getColor(i, R.color.cp_cont_b);
        int color2 = ap.getColor(i, R.color.cp_cont_d);
        if (this.hVb != null) {
            this.hVb.setTextColor(color);
        }
        if (this.hVd != null) {
            this.hVd.setTextColor(this.status > d.hUs ? color : color2);
        }
        if (this.hVf != null) {
            TextView textView = this.hVf;
            if (this.status <= d.hUt) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.hVa != null) {
            this.hVa.uE(i);
        }
        ap.setViewTextColor(this.hUZ, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hVc, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hVe, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hVg, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.hVh != null) {
            this.hVh.uE(i);
        }
        int color3 = ap.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.hVi.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.hQP = aVar;
    }

    public void onDestroy() {
        if (this.hVh != null) {
            this.hVh.onDestroy();
        }
    }
}
