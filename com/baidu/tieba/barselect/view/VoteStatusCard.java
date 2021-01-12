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
/* loaded from: classes7.dex */
public class VoteStatusCard extends LinearLayout {
    private f ijz;
    private e ikT;
    private a ikc;
    private TextView iom;
    private VoteStatusView ion;
    private TextView ioo;
    private TextView iop;
    private TextView ioq;
    private TextView ior;
    private TextView ios;
    private TextView iot;
    private NewVoteCountDownView iou;
    private View iov;
    private NewVoteCountDownView.a iow;
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
        this.status = d.inG;
        this.iow = new NewVoteCountDownView.a() { // from class: com.baidu.tieba.barselect.view.VoteStatusCard.1
            @Override // com.baidu.tieba.view.NewVoteCountDownView.a
            public void chA() {
                if (VoteStatusCard.this.ikc != null) {
                    VoteStatusCard.this.ikc.onRefresh();
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
        tC();
        cqE();
    }

    private void tC() {
        this.iom = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.ion = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.ioo = (TextView) findViewById(R.id.apply_title);
        this.iop = (TextView) findViewById(R.id.apply_start_time);
        this.ioq = (TextView) findViewById(R.id.vote_title);
        this.ior = (TextView) findViewById(R.id.vote_start_time);
        this.ios = (TextView) findViewById(R.id.publicity_title);
        this.iot = (TextView) findViewById(R.id.publicity_start_time);
        this.iov = findViewById(R.id.vote_count_down_container);
        this.iou = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    private void cqE() {
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
        this.ijz = fVar;
        if (this.ijz == null || this.ijz.cqf() == null) {
            setVisibility(8);
            return;
        }
        this.ikT = this.ijz.cqf();
        this.status = this.ikT.getStatus();
        this.ion.setStatus(this.status);
        long cpZ = this.ikT.cpZ() * 1000;
        this.iop.setText(at.dP(this.ikT.cpX() * 1000));
        this.ior.setText(at.dO(this.ikT.cqa() * 1000));
        this.iot.setText(at.dO(this.ikT.cpY() * 1000));
        if (this.status == d.inG) {
            this.iov.setVisibility(0);
            if (this.iow != null) {
                this.iou.setOnCountDownFinished(this.iow);
            }
            this.iou.setData(cpZ);
            return;
        }
        this.iov.setVisibility(8);
    }

    public void uo(int i) {
        int color = ao.getColor(i, R.color.CAM_X0105);
        int color2 = ao.getColor(i, R.color.CAM_X0109);
        if (this.ioo != null) {
            this.ioo.setTextColor(color);
        }
        if (this.ioq != null) {
            this.ioq.setTextColor(this.status > d.inF ? color : color2);
        }
        if (this.ios != null) {
            TextView textView = this.ios;
            if (this.status <= d.inG) {
                color = color2;
            }
            textView.setTextColor(color);
        }
        if (this.ion != null) {
            this.ion.uo(i);
        }
        ao.setViewTextColor(this.iom, R.color.CAM_X0105, 1, i);
        ao.setViewTextColor(this.iop, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.ior, R.color.CAM_X0109, 1, i);
        ao.setViewTextColor(this.iot, R.color.CAM_X0109, 1, i);
        ao.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
        if (this.iou != null) {
            this.iou.uo(i);
        }
        int color3 = ao.getColor(R.color.CAM_X0206);
        com.baidu.tieba.view.e eVar = new com.baidu.tieba.view.e(this.mPath, 902.0f, 224.0f);
        eVar.setColor(color3);
        this.iov.setBackground(eVar);
    }

    public void setOnRefreshListener(a aVar) {
        this.ikc = aVar;
    }

    public void onDestroy() {
        if (this.iou != null) {
            this.iou.onDestroy();
        }
    }
}
