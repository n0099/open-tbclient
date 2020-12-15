package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tieba.ala.liveroom.challenge.panel.k;
/* loaded from: classes4.dex */
public class m extends g implements k.a {
    private boolean canUseChallenge;
    CountDownTimer gGJ;
    private n hlg;
    private ImageView hmj;
    private ImageView hmk;
    private TextView hml;
    private TextView hmm;
    private ImageView hmn;
    private TextView hmo;
    private TextView hmp;
    private String hmq;
    long hmr;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.hmq = this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_begin_text);
        this.hmr = 0L;
        this.hlg = nVar;
        this.hmj = (ImageView) this.mRootView.findViewById(a.f.ala_paiwei_entry);
        this.hmk = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_entry);
        this.hml = (TextView) this.mRootView.findViewById(a.f.ala_paiwei_entry_title);
        this.hmm = (TextView) this.mRootView.findViewById(a.f.ala_challenge_entry_title);
        this.hmn = (ImageView) this.mRootView.findViewById(a.f.ala_red_point);
        this.hmo = (TextView) this.mRootView.findViewById(a.f.ala_red_point_text);
        this.hmn.setVisibility(8);
        this.hmp = (TextView) this.mRootView.findViewById(a.f.ala_qualifying_count_down);
        this.hmp.setVisibility(8);
        this.hmj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hlg != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hlg.removeView();
                }
            }
        });
        this.hml.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hlg != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hlg.removeView();
                }
            }
        });
        this.hmk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bw(m.this.canUseChallenge);
                if (m.this.hlg != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hlg.cdG();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.hmm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bw(m.this.canUseChallenge);
                if (m.this.hlg != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hlg.cdG();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bw(boolean z) {
        this.canUseChallenge = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ee(int i) {
        this.mCount = i;
        if (this.mCount == 0) {
            this.hmn.setVisibility(4);
            this.hmo.setText("");
        }
        if (this.mCount > 0) {
            this.hmn.setVisibility(0);
            this.hmo.setText(this.mContext.getString(a.h.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.hmo.setText(this.mContext.getResources().getString(a.h.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cds() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void QM() {
        super.QM();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.hlg.ec(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hlg.fy(dVar.userId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        this.hlg.removeView();
        return true;
    }

    public void cdQ() {
        if (this.gGJ != null) {
            this.gGJ.cancel();
        }
        this.gGJ = new CountDownTimer(this.hmr, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.hmp.setVisibility(0);
                m.this.hmp.setText(m.this.hmq + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bVz();
            }
        };
        this.gGJ.start();
    }

    public void fA(long j) {
        this.hmr = j;
    }

    public void bVz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.hmp.setVisibility(0);
        this.hmp.setText(this.hmq + "00:00:00");
        this.hmj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
        this.hml.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void uk() {
        this.hmp.setVisibility(8);
    }
}
