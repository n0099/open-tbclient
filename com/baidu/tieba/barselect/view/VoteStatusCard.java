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
/* loaded from: classes21.dex */
public class VoteStatusCard extends LinearLayout {
    private f ibI;
    private a icl;
    private e idd;
    private TextView igA;
    private TextView igB;
    private TextView igC;
    private TextView igD;
    private TextView igE;
    private TextView igF;
    private NewVoteCountDownView igG;
    private View igH;
    private NewVoteCountDownView.a igI;
    private TextView igy;
    private VoteStatusView igz;
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
        this.status = d.ifS;
        this.igI = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void aia() {
                if (VoteStatusCard.this.icl != null) {
                    VoteStatusCard.this.icl.onRefresh();
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
        uo();
        crC();
    }

    private void uo() {
        this.igy = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.igz = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.igA = (TextView) findViewById(R.id.apply_title);
        this.igB = (TextView) findViewById(R.id.apply_start_time);
        this.igC = (TextView) findViewById(R.id.vote_title);
        this.igD = (TextView) findViewById(R.id.vote_start_time);
        this.igE = (TextView) findViewById(R.id.publicity_title);
        this.igF = (TextView) findViewById(R.id.publicity_start_time);
        this.igH = findViewById(R.id.vote_count_down_container);
        this.igG = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void crC() {
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
        this.ibI = fVar;
        if (this.ibI == null || this.ibI.crd() == null) {
            setVisibility(8);
            return;
        }
        this.idd = this.ibI.crd();
        this.status = this.idd.getStatus();
        this.igz.setStatus(this.status);
        long cqX = this.idd.cqX() * 1000;
        this.igB.setText(au.dP(this.idd.cqV() * 1000));
        this.igD.setText(au.dO(this.idd.cqY() * 1000));
        this.igF.setText(au.dO(this.idd.cqW() * 1000));
        if (this.status == d.ifS) {
            this.igH.setVisibility(0);
            if (this.igI != null) {
                this.igG.setOnCountDownFinished(this.igI);
            }
            this.igG.setData(cqX);
            return;
        }
        this.igH.setVisibility(8);
    }

    public void vJ(int i) {
        int color = ap.getColor(i, R.color.CAM_X0105);
        int color2 = ap.getColor(i, R.color.CAM_X0109);
        if (this.igA != null) {
            this.igA.setTextColor(color);
        }
        if (this.igC != null) {
            this.igC.setTextColor(this.status > d.ifR ? color : color2);
        }
        if (this.igE != null) {
            TextView textView = this.igE;
            if (this.status <= d.ifS) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.igz != null) {
            this.igz.vJ(i);
        }
        ap.setViewTextColor(this.igy, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.igB, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.igD, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.igF, R.color.CAM_X0109, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.igG != null) {
            this.igG.vJ(i);
        }
        int color3 = ap.getColor(R.color.CAM_X0206);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.igH.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.icl = aVar;
    }

    public void onDestroy() {
        if (this.igG != null) {
            this.igG.onDestroy();
        }
    }
}
