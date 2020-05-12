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
    private f ghJ;
    private a gin;
    private e gjf;
    private TextView gmA;
    private NewVoteCountDownView gmB;
    private View gmC;
    private NewVoteCountDownView.a gmD;
    private TextView gmt;
    private VoteStatusView gmu;
    private TextView gmv;
    private TextView gmw;
    private TextView gmx;
    private TextView gmy;
    private TextView gmz;
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
        this.status = d.glQ;
        this.gmD = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void onFinished() {
                if (VoteStatusCard.this.gin != null) {
                    VoteStatusCard.this.gin.onRefresh();
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
        bEw();
    }

    private void rL() {
        this.gmt = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.gmu = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.gmv = (TextView) findViewById(R.id.apply_title);
        this.gmw = (TextView) findViewById(R.id.apply_start_time);
        this.gmx = (TextView) findViewById(R.id.vote_title);
        this.gmy = (TextView) findViewById(R.id.vote_start_time);
        this.gmz = (TextView) findViewById(R.id.publicity_title);
        this.gmA = (TextView) findViewById(R.id.publicity_start_time);
        this.gmC = findViewById(R.id.vote_count_down_container);
        this.gmB = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void bEw() {
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
        this.ghJ = fVar;
        if (this.ghJ == null || this.ghJ.bDX() == null) {
            setVisibility(8);
            return;
        }
        this.gjf = this.ghJ.bDX();
        this.status = this.gjf.getStatus();
        this.gmu.setStatus(this.status);
        long bDS = this.gjf.bDS() * 1000;
        this.gmw.setText(aq.cg(this.gjf.bDQ() * 1000));
        this.gmy.setText(aq.cf(this.gjf.bDT() * 1000));
        this.gmA.setText(aq.cf(this.gjf.bDR() * 1000));
        if (this.status == d.glQ) {
            this.gmC.setVisibility(0);
            if (this.gmD != null) {
                this.gmB.setOnCountDownFinished(this.gmD);
            }
            this.gmB.setData(bDS);
            return;
        }
        this.gmC.setVisibility(8);
    }

    public void pH(int i) {
        int color = am.getColor(i, R.color.cp_cont_b);
        int color2 = am.getColor(i, R.color.cp_cont_d);
        if (this.gmv != null) {
            this.gmv.setTextColor(color);
        }
        if (this.gmx != null) {
            this.gmx.setTextColor(this.status > d.glP ? color : color2);
        }
        if (this.gmz != null) {
            TextView textView = this.gmz;
            if (this.status <= d.glQ) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.gmu != null) {
            this.gmu.pH(i);
        }
        am.setViewTextColor(this.gmt, R.color.cp_cont_b, 1, i);
        am.setViewTextColor(this.gmw, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gmy, R.color.cp_cont_d, 1, i);
        am.setViewTextColor(this.gmA, R.color.cp_cont_d, 1, i);
        am.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.gmB != null) {
            this.gmB.pH(i);
        }
        int color3 = am.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.gmC.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.gin = aVar;
    }

    public void onDestroy() {
        if (this.gmB != null) {
            this.gmB.onDestroy();
        }
    }
}
