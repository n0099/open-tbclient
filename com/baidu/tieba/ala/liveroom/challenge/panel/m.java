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
    CountDownTimer gGH;
    private n hle;
    private ImageView hmh;
    private ImageView hmi;
    private TextView hmj;
    private TextView hmk;
    private ImageView hml;
    private TextView hmm;
    private TextView hmn;
    private String hmo;
    long hmp;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.hmo = this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_begin_text);
        this.hmp = 0L;
        this.hle = nVar;
        this.hmh = (ImageView) this.mRootView.findViewById(a.f.ala_paiwei_entry);
        this.hmi = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_entry);
        this.hmj = (TextView) this.mRootView.findViewById(a.f.ala_paiwei_entry_title);
        this.hmk = (TextView) this.mRootView.findViewById(a.f.ala_challenge_entry_title);
        this.hml = (ImageView) this.mRootView.findViewById(a.f.ala_red_point);
        this.hmm = (TextView) this.mRootView.findViewById(a.f.ala_red_point_text);
        this.hml.setVisibility(8);
        this.hmn = (TextView) this.mRootView.findViewById(a.f.ala_qualifying_count_down);
        this.hmn.setVisibility(8);
        this.hmh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hle != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hle.removeView();
                }
            }
        });
        this.hmj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hle != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hle.removeView();
                }
            }
        });
        this.hmi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bw(m.this.canUseChallenge);
                if (m.this.hle != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hle.cdF();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.hmk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bw(m.this.canUseChallenge);
                if (m.this.hle != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hle.cdF();
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
            this.hml.setVisibility(4);
            this.hmm.setText("");
        }
        if (this.mCount > 0) {
            this.hml.setVisibility(0);
            this.hmm.setText(this.mContext.getString(a.h.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.hmm.setText(this.mContext.getResources().getString(a.h.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void QM() {
        super.QM();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.hle.ec(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hle.fy(dVar.userId);
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
        this.hle.removeView();
        return true;
    }

    public void cdP() {
        if (this.gGH != null) {
            this.gGH.cancel();
        }
        this.gGH = new CountDownTimer(this.hmp, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.hmn.setVisibility(0);
                m.this.hmn.setText(m.this.hmo + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bVy();
            }
        };
        this.gGH.start();
    }

    public void fA(long j) {
        this.hmp = j;
    }

    public void bVy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.hmn.setVisibility(0);
        this.hmn.setText(this.hmo + "00:00:00");
        this.hmh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
        this.hmj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void uk() {
        this.hmn.setVisibility(8);
    }
}
