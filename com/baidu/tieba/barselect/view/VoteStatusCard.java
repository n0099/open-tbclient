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
    private TextView hCG;
    private VoteStatusView hCH;
    private TextView hCI;
    private TextView hCJ;
    private TextView hCK;
    private TextView hCL;
    private TextView hCM;
    private TextView hCN;
    private NewVoteCountDownView hCO;
    private View hCP;
    private NewVoteCountDownView.a hCQ;
    private f hxT;
    private a hyw;
    private e hzp;
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
        this.status = d.hCa;
        this.hCQ = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void abg() {
                if (VoteStatusCard.this.hyw != null) {
                    VoteStatusCard.this.hyw.onRefresh();
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
        cie();
    }

    private void ul() {
        this.hCG = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.hCH = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.hCI = (TextView) findViewById(R.id.apply_title);
        this.hCJ = (TextView) findViewById(R.id.apply_start_time);
        this.hCK = (TextView) findViewById(R.id.vote_title);
        this.hCL = (TextView) findViewById(R.id.vote_start_time);
        this.hCM = (TextView) findViewById(R.id.publicity_title);
        this.hCN = (TextView) findViewById(R.id.publicity_start_time);
        this.hCP = findViewById(R.id.vote_count_down_container);
        this.hCO = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void cie() {
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
        this.hxT = fVar;
        if (this.hxT == null || this.hxT.chE() == null) {
            setVisibility(8);
            return;
        }
        this.hzp = this.hxT.chE();
        this.status = this.hzp.getStatus();
        this.hCH.setStatus(this.status);
        long chy = this.hzp.chy() * 1000;
        this.hCJ.setText(at.cS(this.hzp.chw() * 1000));
        this.hCL.setText(at.cR(this.hzp.chz() * 1000));
        this.hCN.setText(at.cR(this.hzp.chx() * 1000));
        if (this.status == d.hCa) {
            this.hCP.setVisibility(0);
            if (this.hCQ != null) {
                this.hCO.setOnCountDownFinished(this.hCQ);
            }
            this.hCO.setData(chy);
            return;
        }
        this.hCP.setVisibility(8);
    }

    public void uc(int i) {
        int color = ap.getColor(i, R.color.cp_cont_b);
        int color2 = ap.getColor(i, R.color.cp_cont_d);
        if (this.hCI != null) {
            this.hCI.setTextColor(color);
        }
        if (this.hCK != null) {
            this.hCK.setTextColor(this.status > d.hBZ ? color : color2);
        }
        if (this.hCM != null) {
            TextView textView = this.hCM;
            if (this.status <= d.hCa) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.hCH != null) {
            this.hCH.uc(i);
        }
        ap.setViewTextColor(this.hCG, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hCJ, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hCL, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hCN, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.hCO != null) {
            this.hCO.uc(i);
        }
        int color3 = ap.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.hCP.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.hyw = aVar;
    }

    public void onDestroy() {
        if (this.hCO != null) {
            this.hCO.onDestroy();
        }
    }
}
