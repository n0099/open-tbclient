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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.view.NewVoteCountDownView;
/* loaded from: classes8.dex */
public class VoteStatusCard extends LinearLayout {
    private a ioL;
    private f ioi;
    private e ipC;
    private TextView isT;
    private VoteStatusView isU;
    private TextView isV;
    private TextView isW;
    private TextView isX;
    private TextView isY;
    private TextView isZ;
    private TextView ita;
    private NewVoteCountDownView itb;
    private View itc;
    private NewVoteCountDownView.a itd;
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
        this.status = d.isn;
        this.itd = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void clr() {
                if (VoteStatusCard.this.ioL != null) {
                    VoteStatusCard.this.ioL.onRefresh();
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
        tN();
        cuv();
    }

    private void tN() {
        this.isT = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.isU = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.isV = (TextView) findViewById(R.id.apply_title);
        this.isW = (TextView) findViewById(R.id.apply_start_time);
        this.isX = (TextView) findViewById(R.id.vote_title);
        this.isY = (TextView) findViewById(R.id.vote_start_time);
        this.isZ = (TextView) findViewById(R.id.publicity_title);
        this.ita = (TextView) findViewById(R.id.publicity_start_time);
        this.itc = findViewById(R.id.vote_count_down_container);
        this.itb = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void cuv() {
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
        this.ioi = fVar;
        if (this.ioi == null || this.ioi.ctW() == null) {
            setVisibility(8);
            return;
        }
        this.ipC = this.ioi.ctW();
        this.status = this.ipC.getStatus();
        this.isU.setStatus(this.status);
        long ctQ = this.ipC.ctQ() * 1000;
        this.isW.setText(at.dP(this.ipC.ctO() * 1000));
        this.isY.setText(at.dO(this.ipC.ctR() * 1000));
        this.ita.setText(at.dO(this.ipC.ctP() * 1000));
        if (this.status == d.isn) {
            this.itc.setVisibility(0);
            if (this.itd != null) {
                this.itb.setOnCountDownFinished(this.itd);
            }
            this.itb.setData(ctQ);
            return;
        }
        this.itc.setVisibility(8);
    }

    public void vU(int i) {
        int color = ao.getColor(i, R.color.CAM_X0105);
        int color2 = ao.getColor(i, R.color.CAM_X0109);
        if (this.isV != null) {
            this.isV.setTextColor(color);
        }
        if (this.isX != null) {
            this.isX.setTextColor(this.status > d.ism ? color : color2);
        }
        if (this.isZ != null) {
            TextView textView = this.isZ;
            if (this.status <= d.isn) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.isU != null) {
            this.isU.vU(i);
        }
        ao.setViewTextColor(this.isT, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.isW, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.isY, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.ita, R.color.CAM_X0109, 1, i);
        ao.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.itb != null) {
            this.itb.vU(i);
        }
        int color3 = ao.getColor(R.color.CAM_X0206);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.itc.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.ioL = aVar;
    }

    public void onDestroy() {
        if (this.itb != null) {
            this.itb.onDestroy();
        }
    }
}
