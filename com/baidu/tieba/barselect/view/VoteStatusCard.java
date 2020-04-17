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
    private f ghD;
    private e giZ;
    private a gih;
    private TextView gmn;
    private VoteStatusView gmo;
    private TextView gmp;
    private TextView gmq;
    private TextView gmr;
    private TextView gms;
    private TextView gmt;
    private TextView gmu;
    private NewVoteCountDownView gmv;
    private View gmw;
    private NewVoteCountDownView.a gmx;
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
        this.status = d.glK;
        this.gmx = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void onFinished() {
                if (VoteStatusCard.this.gih != null) {
                    VoteStatusCard.this.gih.onRefresh();
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
        rL();
        bEx();
    }

    private void rL() {
        this.gmn = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.gmo = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.gmp = (TextView) findViewById(R.id.apply_title);
        this.gmq = (TextView) findViewById(R.id.apply_start_time);
        this.gmr = (TextView) findViewById(R.id.vote_title);
        this.gms = (TextView) findViewById(R.id.vote_start_time);
        this.gmt = (TextView) findViewById(R.id.publicity_title);
        this.gmu = (TextView) findViewById(R.id.publicity_start_time);
        this.gmw = findViewById(R.id.vote_count_down_container);
        this.gmv = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void bEx() {
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
        this.ghD = fVar;
        if (this.ghD == null || this.ghD.bDY() == null) {
            setVisibility(8);
            return;
        }
        this.giZ = this.ghD.bDY();
        this.status = this.giZ.getStatus();
        this.gmo.setStatus(this.status);
        long bDT = this.giZ.bDT() * 1000;
        this.gmq.setText(aq.cg(this.giZ.bDR() * 1000));
        this.gms.setText(aq.cf(this.giZ.bDU() * 1000));
        this.gmu.setText(aq.cf(this.giZ.bDS() * 1000));
        if (this.status == d.glK) {
            this.gmw.setVisibility(0);
            if (this.gmx != null) {
                this.gmv.setOnCountDownFinished(this.gmx);
            }
            this.gmv.setData(bDT);
            return;
        }
        this.gmw.setVisibility(8);
    }

    public void pH(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.gmp != null) {
            this.gmp.setTextColor(color);
        }
        if (this.gmr != null) {
            this.gmr.setTextColor(this.status > d.glJ ? color : color2);
        }
        if (this.gmt != null) {
            TextView textView = this.gmt;
            if (this.status <= d.glK) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.gmo != null) {
            this.gmo.pH(i);
        }
        am.setViewTextColor(this.gmn, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gmq, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gms, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gmu, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.gmv != null) {
            this.gmv.pH(i);
        }
        int color3 = am.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.gmw.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.gih = aVar;
    }

    public void onDestroy() {
        if (this.gmv != null) {
            this.gmv.onDestroy();
        }
    }
}
