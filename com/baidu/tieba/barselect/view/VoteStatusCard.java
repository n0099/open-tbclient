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
    private f ibG;
    private a icj;
    private e idb;
    private TextView igA;
    private TextView igB;
    private TextView igC;
    private TextView igD;
    private NewVoteCountDownView igE;
    private View igF;
    private NewVoteCountDownView.a igG;
    private TextView igw;
    private VoteStatusView igx;
    private TextView igy;
    private TextView igz;
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
        this.status = d.ifQ;
        this.igG = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void aia() {
                if (VoteStatusCard.this.icj != null) {
                    VoteStatusCard.this.icj.onRefresh();
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
        crB();
    }

    private void uo() {
        this.igw = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.igx = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.igy = (TextView) findViewById(R.id.apply_title);
        this.igz = (TextView) findViewById(R.id.apply_start_time);
        this.igA = (TextView) findViewById(R.id.vote_title);
        this.igB = (TextView) findViewById(R.id.vote_start_time);
        this.igC = (TextView) findViewById(R.id.publicity_title);
        this.igD = (TextView) findViewById(R.id.publicity_start_time);
        this.igF = findViewById(R.id.vote_count_down_container);
        this.igE = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void crB() {
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
        this.ibG = fVar;
        if (this.ibG == null || this.ibG.crc() == null) {
            setVisibility(8);
            return;
        }
        this.idb = this.ibG.crc();
        this.status = this.idb.getStatus();
        this.igx.setStatus(this.status);
        long cqW = this.idb.cqW() * 1000;
        this.igz.setText(au.dP(this.idb.cqU() * 1000));
        this.igB.setText(au.dO(this.idb.cqX() * 1000));
        this.igD.setText(au.dO(this.idb.cqV() * 1000));
        if (this.status == d.ifQ) {
            this.igF.setVisibility(0);
            if (this.igG != null) {
                this.igE.setOnCountDownFinished(this.igG);
            }
            this.igE.setData(cqW);
            return;
        }
        this.igF.setVisibility(8);
    }

    public void vJ(int i) {
        int color = ap.getColor(i, R.color.CAM_X0105);
        int color2 = ap.getColor(i, R.color.CAM_X0109);
        if (this.igy != null) {
            this.igy.setTextColor(color);
        }
        if (this.igA != null) {
            this.igA.setTextColor(this.status > d.ifP ? color : color2);
        }
        if (this.igC != null) {
            TextView textView = this.igC;
            if (this.status <= d.ifQ) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.igx != null) {
            this.igx.vJ(i);
        }
        ap.setViewTextColor(this.igw, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.igz, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.igB, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.igD, R.color.CAM_X0109, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.igE != null) {
            this.igE.vJ(i);
        }
        int color3 = ap.getColor(R.color.CAM_X0206);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.igF.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.icj = aVar;
    }

    public void onDestroy() {
        if (this.igE != null) {
            this.igE.onDestroy();
        }
    }
}
