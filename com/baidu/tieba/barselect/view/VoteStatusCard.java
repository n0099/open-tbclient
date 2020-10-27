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
    private a hKS;
    private f hKp;
    private e hLL;
    private TextView hPc;
    private VoteStatusView hPd;
    private TextView hPe;
    private TextView hPf;
    private TextView hPg;
    private TextView hPh;
    private TextView hPi;
    private TextView hPj;
    private NewVoteCountDownView hPk;
    private View hPl;
    private NewVoteCountDownView.a hPm;
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
        this.status = d.hOw;
        this.hPm = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void ada() {
                if (VoteStatusCard.this.hKS != null) {
                    VoteStatusCard.this.hKS.onRefresh();
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
        cll();
    }

    private void ul() {
        this.hPc = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.hPd = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.hPe = (TextView) findViewById(R.id.apply_title);
        this.hPf = (TextView) findViewById(R.id.apply_start_time);
        this.hPg = (TextView) findViewById(R.id.vote_title);
        this.hPh = (TextView) findViewById(R.id.vote_start_time);
        this.hPi = (TextView) findViewById(R.id.publicity_title);
        this.hPj = (TextView) findViewById(R.id.publicity_start_time);
        this.hPl = findViewById(R.id.vote_count_down_container);
        this.hPk = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void cll() {
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
        this.hKp = fVar;
        if (this.hKp == null || this.hKp.ckL() == null) {
            setVisibility(8);
            return;
        }
        this.hLL = this.hKp.ckL();
        this.status = this.hLL.getStatus();
        this.hPd.setStatus(this.status);
        long ckF = this.hLL.ckF() * 1000;
        this.hPf.setText(at.cU(this.hLL.ckD() * 1000));
        this.hPh.setText(at.cT(this.hLL.ckG() * 1000));
        this.hPj.setText(at.cT(this.hLL.ckE() * 1000));
        if (this.status == d.hOw) {
            this.hPl.setVisibility(0);
            if (this.hPm != null) {
                this.hPk.setOnCountDownFinished(this.hPm);
            }
            this.hPk.setData(ckF);
            return;
        }
        this.hPl.setVisibility(8);
    }

    public void uu(int i) {
        int color = ap.getColor(i, R.color.cp_cont_b);
        int color2 = ap.getColor(i, R.color.cp_cont_d);
        if (this.hPe != null) {
            this.hPe.setTextColor(color);
        }
        if (this.hPg != null) {
            this.hPg.setTextColor(this.status > d.hOv ? color : color2);
        }
        if (this.hPi != null) {
            TextView textView = this.hPi;
            if (this.status <= d.hOw) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.hPd != null) {
            this.hPd.uu(i);
        }
        ap.setViewTextColor(this.hPc, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hPf, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hPh, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hPj, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.hPk != null) {
            this.hPk.uu(i);
        }
        int color3 = ap.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.hPl.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.hKS = aVar;
    }

    public void onDestroy() {
        if (this.hPk != null) {
            this.hPk.onDestroy();
        }
    }
}
