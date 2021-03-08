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
/* loaded from: classes10.dex */
public class m extends g implements k.a {
    private boolean canUseChallenge;
    CountDownTimer gSr;
    private n hyC;
    private ImageView hzF;
    private ImageView hzG;
    private TextView hzH;
    private TextView hzI;
    private ImageView hzJ;
    private TextView hzK;
    private TextView hzL;
    private String hzM;
    long hzN;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.hzM = this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_begin_text);
        this.hzN = 0L;
        this.hyC = nVar;
        this.hzF = (ImageView) this.mRootView.findViewById(a.f.ala_paiwei_entry);
        this.hzG = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_entry);
        this.hzH = (TextView) this.mRootView.findViewById(a.f.ala_paiwei_entry_title);
        this.hzI = (TextView) this.mRootView.findViewById(a.f.ala_challenge_entry_title);
        this.hzJ = (ImageView) this.mRootView.findViewById(a.f.ala_red_point);
        this.hzK = (TextView) this.mRootView.findViewById(a.f.ala_red_point_text);
        this.hzJ.setVisibility(8);
        this.hzL = (TextView) this.mRootView.findViewById(a.f.ala_qualifying_count_down);
        this.hzL.setVisibility(8);
        this.hzF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hyC != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hyC.removeView();
                }
            }
        });
        this.hzH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hyC != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hyC.removeView();
                }
            }
        });
        this.hzG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.br(m.this.canUseChallenge);
                if (m.this.hyC != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hyC.cdN();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.hzI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.br(m.this.canUseChallenge);
                if (m.this.hyC != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hyC.cdN();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void br(boolean z) {
        this.canUseChallenge = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cz(int i) {
        this.mCount = i;
        if (this.mCount == 0) {
            this.hzJ.setVisibility(4);
            this.hzK.setText("");
        }
        if (this.mCount > 0) {
            this.hzJ.setVisibility(0);
            this.hzK.setText(this.mContext.getString(a.h.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.hzK.setText(this.mContext.getResources().getString(a.h.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdz() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.hyC.cx(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hyC.fD(dVar.userId);
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
        this.hyC.removeView();
        return true;
    }

    public void cdX() {
        if (this.gSr != null) {
            this.gSr.cancel();
        }
        this.gSr = new CountDownTimer(this.hzN, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.hzL.setVisibility(0);
                m.this.hzL.setText(m.this.hzM + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bVf();
            }
        };
        this.gSr.start();
    }

    public void fF(long j) {
        this.hzN = j;
    }

    public void bVf() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.hzL.setVisibility(0);
        this.hzL.setText(this.hzM + "00:00:00");
        this.hzF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
        this.hzH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void tv() {
        this.hzL.setVisibility(8);
    }
}
