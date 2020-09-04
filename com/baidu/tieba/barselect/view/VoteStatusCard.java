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
/* loaded from: classes15.dex */
public class VoteStatusCard extends LinearLayout {
    private f hbZ;
    private a hcC;
    private e hds;
    private TextView hgI;
    private VoteStatusView hgJ;
    private TextView hgK;
    private TextView hgL;
    private TextView hgM;
    private TextView hgN;
    private TextView hgO;
    private TextView hgP;
    private NewVoteCountDownView hgQ;
    private View hgR;
    private NewVoteCountDownView.a hgS;
    private Context mContext;
    private Path mPath;
    private int status;

    /* loaded from: classes15.dex */
    public interface a {
        void onRefresh();
    }

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = d.hgf;
        this.hgS = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void XL() {
                if (VoteStatusCard.this.hcC != null) {
                    VoteStatusCard.this.hcC.onRefresh();
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
        uf();
        cbt();
    }

    private void uf() {
        this.hgI = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.hgJ = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.hgK = (TextView) findViewById(R.id.apply_title);
        this.hgL = (TextView) findViewById(R.id.apply_start_time);
        this.hgM = (TextView) findViewById(R.id.vote_title);
        this.hgN = (TextView) findViewById(R.id.vote_start_time);
        this.hgO = (TextView) findViewById(R.id.publicity_title);
        this.hgP = (TextView) findViewById(R.id.publicity_start_time);
        this.hgR = findViewById(R.id.vote_count_down_container);
        this.hgQ = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void cbt() {
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
        this.hbZ = fVar;
        if (this.hbZ == null || this.hbZ.caT() == null) {
            setVisibility(8);
            return;
        }
        this.hds = this.hbZ.caT();
        this.status = this.hds.getStatus();
        this.hgJ.setStatus(this.status);
        long caO = this.hds.caO() * 1000;
        this.hgL.setText(at.cJ(this.hds.caM() * 1000));
        this.hgN.setText(at.cI(this.hds.caP() * 1000));
        this.hgP.setText(at.cI(this.hds.caN() * 1000));
        if (this.status == d.hgf) {
            this.hgR.setVisibility(0);
            if (this.hgS != null) {
                this.hgQ.setOnCountDownFinished(this.hgS);
            }
            this.hgQ.setData(caO);
            return;
        }
        this.hgR.setVisibility(8);
    }

    public void tl(int i) {
        int color = ap.getColor(i, R.color.cp_cont_b);
        int color2 = ap.getColor(i, R.color.cp_cont_d);
        if (this.hgK != null) {
            this.hgK.setTextColor(color);
        }
        if (this.hgM != null) {
            this.hgM.setTextColor(this.status > d.hge ? color : color2);
        }
        if (this.hgO != null) {
            TextView textView = this.hgO;
            if (this.status <= d.hgf) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.hgJ != null) {
            this.hgJ.tl(i);
        }
        ap.setViewTextColor(this.hgI, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hgL, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hgN, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hgP, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.hgQ != null) {
            this.hgQ.tl(i);
        }
        int color3 = ap.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.hgR.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.hcC = aVar;
    }

    public void onDestroy() {
        if (this.hgQ != null) {
            this.hgQ.onDestroy();
        }
    }
}
