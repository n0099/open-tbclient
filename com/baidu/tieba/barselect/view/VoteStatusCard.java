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
    private f hbV;
    private a hcy;
    private e hdo;
    private TextView hgE;
    private VoteStatusView hgF;
    private TextView hgG;
    private TextView hgH;
    private TextView hgI;
    private TextView hgJ;
    private TextView hgK;
    private TextView hgL;
    private NewVoteCountDownView hgM;
    private View hgN;
    private NewVoteCountDownView.a hgO;
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
        this.status = d.hgb;
        this.hgO = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void XL() {
                if (VoteStatusCard.this.hcy != null) {
                    VoteStatusCard.this.hcy.onRefresh();
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
        cbs();
    }

    private void uf() {
        this.hgE = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.hgF = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.hgG = (TextView) findViewById(R.id.apply_title);
        this.hgH = (TextView) findViewById(R.id.apply_start_time);
        this.hgI = (TextView) findViewById(R.id.vote_title);
        this.hgJ = (TextView) findViewById(R.id.vote_start_time);
        this.hgK = (TextView) findViewById(R.id.publicity_title);
        this.hgL = (TextView) findViewById(R.id.publicity_start_time);
        this.hgN = findViewById(R.id.vote_count_down_container);
        this.hgM = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void cbs() {
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
        this.hbV = fVar;
        if (this.hbV == null || this.hbV.caS() == null) {
            setVisibility(8);
            return;
        }
        this.hdo = this.hbV.caS();
        this.status = this.hdo.getStatus();
        this.hgF.setStatus(this.status);
        long caN = this.hdo.caN() * 1000;
        this.hgH.setText(at.cJ(this.hdo.caL() * 1000));
        this.hgJ.setText(at.cI(this.hdo.caO() * 1000));
        this.hgL.setText(at.cI(this.hdo.caM() * 1000));
        if (this.status == d.hgb) {
            this.hgN.setVisibility(0);
            if (this.hgO != null) {
                this.hgM.setOnCountDownFinished(this.hgO);
            }
            this.hgM.setData(caN);
            return;
        }
        this.hgN.setVisibility(8);
    }

    public void tl(int i) {
        int color = ap.getColor(i, R.color.cp_cont_b);
        int color2 = ap.getColor(i, R.color.cp_cont_d);
        if (this.hgG != null) {
            this.hgG.setTextColor(color);
        }
        if (this.hgI != null) {
            this.hgI.setTextColor(this.status > d.hga ? color : color2);
        }
        if (this.hgK != null) {
            TextView textView = this.hgK;
            if (this.status <= d.hgb) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.hgF != null) {
            this.hgF.tl(i);
        }
        ap.setViewTextColor(this.hgE, R.color.cp_cont_b, 1, i);
        ap.setViewTextColor(this.hgH, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hgJ, R.color.cp_cont_d, 1, i);
        ap.setViewTextColor(this.hgL, R.color.cp_cont_d, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.hgM != null) {
            this.hgM.tl(i);
        }
        int color3 = ap.getColor(R.color.cp_bg_line_g);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.hgN.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.hcy = aVar;
    }

    public void onDestroy() {
        if (this.hgM != null) {
            this.hgM.onDestroy();
        }
    }
}
