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
/* loaded from: classes7.dex */
public class VoteStatusCard extends LinearLayout {
    private a irH;
    private f ire;
    private e isy;
    private TextView ivN;
    private VoteStatusView ivO;
    private TextView ivP;
    private TextView ivQ;
    private TextView ivR;
    private TextView ivS;
    private TextView ivT;
    private TextView ivU;
    private NewVoteCountDownView ivV;
    private View ivW;
    private NewVoteCountDownView.a ivX;
    private Context mContext;
    private Path mPath;
    private int status;

    /* loaded from: classes7.dex */
    public interface a {
        void onRefresh();
    }

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.ivh;
        this.ivX = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void ciG() {
                if (VoteStatusCard.this.irH != null) {
                    VoteStatusCard.this.irH.onRefresh();
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
        tz();
        csb();
    }

    private void tz() {
        this.ivN = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.ivO = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.ivP = (TextView) findViewById(R.id.apply_title);
        this.ivQ = (TextView) findViewById(R.id.apply_start_time);
        this.ivR = (TextView) findViewById(R.id.vote_title);
        this.ivS = (TextView) findViewById(R.id.vote_start_time);
        this.ivT = (TextView) findViewById(R.id.publicity_title);
        this.ivU = (TextView) findViewById(R.id.publicity_start_time);
        this.ivW = findViewById(R.id.vote_count_down_container);
        this.ivV = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void csb() {
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
        this.ire = fVar;
        if (this.ire == null || this.ire.crC() == null) {
            setVisibility(8);
            return;
        }
        this.isy = this.ire.crC();
        this.status = this.isy.getStatus();
        this.ivO.setStatus(this.status);
        long crw = this.isy.crw() * 1000;
        this.ivQ.setText(au.dV(this.isy.cru() * 1000));
        this.ivS.setText(au.dU(this.isy.crx() * 1000));
        this.ivU.setText(au.dU(this.isy.crv() * 1000));
        if (this.status == d.ivh) {
            this.ivW.setVisibility(0);
            if (this.ivX != null) {
                this.ivV.setOnCountDownFinished(this.ivX);
            }
            this.ivV.setData(crw);
            return;
        }
        this.ivW.setVisibility(8);
    }

    public void uw(int i) {
        int color = ap.getColor(i, R.color.CAM_X0105);
        int color2 = ap.getColor(i, R.color.CAM_X0109);
        if (this.ivP != null) {
            this.ivP.setTextColor(color);
        }
        if (this.ivR != null) {
            this.ivR.setTextColor(this.status > d.ivg ? color : color2);
        }
        if (this.ivT != null) {
            TextView textView = this.ivT;
            if (this.status <= d.ivh) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.ivO != null) {
            this.ivO.uw(i);
        }
        ap.setViewTextColor(this.ivN, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.ivQ, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.ivS, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.ivU, R.color.CAM_X0109, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.ivV != null) {
            this.ivV.uw(i);
        }
        int color3 = ap.getColor(R.color.CAM_X0206);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.ivW.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.irH = aVar;
    }

    public void onDestroy() {
        if (this.ivV != null) {
            this.ivV.onDestroy();
        }
    }
}
