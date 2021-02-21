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
    private a ipY;
    private f ipv;
    private e iqP;
    private TextView iue;
    private VoteStatusView iuf;
    private TextView iug;
    private TextView iuh;
    private TextView iui;
    private TextView iuj;
    private TextView iuk;
    private TextView iul;
    private NewVoteCountDownView ium;
    private View iun;
    private NewVoteCountDownView.a iuo;
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
        this.status = d.ity;
        this.iuo = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void ciA() {
                if (VoteStatusCard.this.ipY != null) {
                    VoteStatusCard.this.ipY.onRefresh();
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
        crV();
    }

    private void tz() {
        this.iue = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.iuf = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.iug = (TextView) findViewById(R.id.apply_title);
        this.iuh = (TextView) findViewById(R.id.apply_start_time);
        this.iui = (TextView) findViewById(R.id.vote_title);
        this.iuj = (TextView) findViewById(R.id.vote_start_time);
        this.iuk = (TextView) findViewById(R.id.publicity_title);
        this.iul = (TextView) findViewById(R.id.publicity_start_time);
        this.iun = findViewById(R.id.vote_count_down_container);
        this.ium = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void crV() {
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
        this.ipv = fVar;
        if (this.ipv == null || this.ipv.crw() == null) {
            setVisibility(8);
            return;
        }
        this.iqP = this.ipv.crw();
        this.status = this.iqP.getStatus();
        this.iuf.setStatus(this.status);
        long crq = this.iqP.crq() * 1000;
        this.iuh.setText(au.dV(this.iqP.cro() * 1000));
        this.iuj.setText(au.dU(this.iqP.crr() * 1000));
        this.iul.setText(au.dU(this.iqP.crp() * 1000));
        if (this.status == d.ity) {
            this.iun.setVisibility(0);
            if (this.iuo != null) {
                this.ium.setOnCountDownFinished(this.iuo);
            }
            this.ium.setData(crq);
            return;
        }
        this.iun.setVisibility(8);
    }

    public void uu(int i) {
        int color = ap.getColor(i, R.color.CAM_X0105);
        int color2 = ap.getColor(i, R.color.CAM_X0109);
        if (this.iug != null) {
            this.iug.setTextColor(color);
        }
        if (this.iui != null) {
            this.iui.setTextColor(this.status > d.itx ? color : color2);
        }
        if (this.iuk != null) {
            TextView textView = this.iuk;
            if (this.status <= d.ity) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.iuf != null) {
            this.iuf.uu(i);
        }
        ap.setViewTextColor(this.iue, R.color.CAM_X0105, 1, i);
        ap.setViewTextColor(this.iuh, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.iuj, R.color.CAM_X0109, 1, i);
        ap.setViewTextColor(this.iul, R.color.CAM_X0109, 1, i);
        ap.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.ium != null) {
            this.ium.uu(i);
        }
        int color3 = ap.getColor(R.color.CAM_X0206);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.iun.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.ipY = aVar;
    }

    public void onDestroy() {
        if (this.ium != null) {
            this.ium.onDestroy();
        }
    }
}
