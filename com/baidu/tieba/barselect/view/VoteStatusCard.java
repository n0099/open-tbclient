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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.view.NewVoteCountDownView;
/* loaded from: classes20.dex */
public class VoteStatusCard extends LinearLayout {
    private f hQM;
    private a hRp;
    private e hSi;
    private VoteStatusView hVA;
    private TextView hVB;
    private TextView hVC;
    private TextView hVD;
    private TextView hVE;
    private TextView hVF;
    private TextView hVG;
    private NewVoteCountDownView hVH;
    private View hVI;
    private NewVoteCountDownView.a hVJ;
    private TextView hVz;
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
        this.status = d.hUT;
        this.hVJ = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void aeS() {
                if (VoteStatusCard.this.hRp != null) {
                    VoteStatusCard.this.hRp.onRefresh();
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
        cno();
    }

    private void ul() {
        this.hVz = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.hVA = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.hVB = (TextView) findViewById(R.id.apply_title);
        this.hVC = (TextView) findViewById(R.id.apply_start_time);
        this.hVD = (TextView) findViewById(R.id.vote_title);
        this.hVE = (TextView) findViewById(R.id.vote_start_time);
        this.hVF = (TextView) findViewById(R.id.publicity_title);
        this.hVG = (TextView) findViewById(R.id.publicity_start_time);
        this.hVI = findViewById(R.id.vote_count_down_container);
        this.hVH = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void cno() {
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
        this.hQM = fVar;
        if (this.hQM == null || this.hQM.cmP() == null) {
            setVisibility(8);
            return;
        }
        this.hSi = this.hQM.cmP();
        this.status = this.hSi.getStatus();
        this.hVA.setStatus(this.status);
        long cmJ = this.hSi.cmJ() * 1000;
        this.hVC.setText(au.dq(this.hSi.cmH() * 1000));
        this.hVE.setText(au.dp(this.hSi.cmK() * 1000));
        this.hVG.setText(au.dp(this.hSi.cmI() * 1000));
        if (this.status == d.hUT) {
            this.hVI.setVisibility(0);
            if (this.hVJ != null) {
                this.hVH.setOnCountDownFinished(this.hVJ);
            }
            this.hVH.setData(cmJ);
            return;
        }
        this.hVI.setVisibility(8);
    }

    public void vc(int i) {
        int color = ap.getColor(i, R.color.CAM_X0105);
        int color2 = ap.getColor(i, R.color.CAM_X0109);
        if (this.hVB != null) {
            this.hVB.setTextColor(color);
        }
        if (this.hVD != null) {
            this.hVD.setTextColor(this.status > d.hUS ? color : color2);
        }
        if (this.hVF != null) {
            TextView textView = this.hVF;
            if (this.status <= d.hUT) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.hVA != null) {
            this.hVA.vc(i);
        }
        ap.setViewTextColor(this.hVz, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.hVC, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.hVE, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.hVG, R.color.CAM_X0109, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.hVH != null) {
            this.hVH.vc(i);
        }
        int color3 = ap.getColor(R.color.CAM_X0206);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.hVI.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.hRp = aVar;
    }

    public void onDestroy() {
        if (this.hVH != null) {
            this.hVH.onDestroy();
        }
    }
}
