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
/* loaded from: classes8.dex */
public class VoteStatusCard extends LinearLayout {
    private a ipK;
    private f iph;
    private e iqB;
    private TextView itQ;
    private VoteStatusView itR;
    private TextView itS;
    private TextView itT;
    private TextView itU;
    private TextView itV;
    private TextView itW;
    private TextView itX;
    private NewVoteCountDownView itY;
    private View itZ;
    private NewVoteCountDownView.a iua;
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
        this.status = d.itk;
        this.iua = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void cit() {
                if (VoteStatusCard.this.ipK != null) {
                    VoteStatusCard.this.ipK.onRefresh();
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
        crO();
    }

    private void tz() {
        this.itQ = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.itR = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.itS = (TextView) findViewById(R.id.apply_title);
        this.itT = (TextView) findViewById(R.id.apply_start_time);
        this.itU = (TextView) findViewById(R.id.vote_title);
        this.itV = (TextView) findViewById(R.id.vote_start_time);
        this.itW = (TextView) findViewById(R.id.publicity_title);
        this.itX = (TextView) findViewById(R.id.publicity_start_time);
        this.itZ = findViewById(R.id.vote_count_down_container);
        this.itY = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void crO() {
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
        this.iph = fVar;
        if (this.iph == null || this.iph.crp() == null) {
            setVisibility(8);
            return;
        }
        this.iqB = this.iph.crp();
        this.status = this.iqB.getStatus();
        this.itR.setStatus(this.status);
        long crj = this.iqB.crj() * 1000;
        this.itT.setText(au.dV(this.iqB.crh() * 1000));
        this.itV.setText(au.dU(this.iqB.crk() * 1000));
        this.itX.setText(au.dU(this.iqB.cri() * 1000));
        if (this.status == d.itk) {
            this.itZ.setVisibility(0);
            if (this.iua != null) {
                this.itY.setOnCountDownFinished(this.iua);
            }
            this.itY.setData(crj);
            return;
        }
        this.itZ.setVisibility(8);
    }

    public void uu(int i) {
        int color = ap.getColor(i, R.color.CAM_X0105);
        int color2 = ap.getColor(i, R.color.CAM_X0109);
        if (this.itS != null) {
            this.itS.setTextColor(color);
        }
        if (this.itU != null) {
            this.itU.setTextColor(this.status > d.itj ? color : color2);
        }
        if (this.itW != null) {
            TextView textView = this.itW;
            if (this.status <= d.itk) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.itR != null) {
            this.itR.uu(i);
        }
        ap.setViewTextColor(this.itQ, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.itT, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.itV, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.itX, R.color.CAM_X0109, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.itY != null) {
            this.itY.uu(i);
        }
        int color3 = ap.getColor(R.color.CAM_X0206);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.itZ.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.ipK = aVar;
    }

    public void onDestroy() {
        if (this.itY != null) {
            this.itY.onDestroy();
        }
    }
}
