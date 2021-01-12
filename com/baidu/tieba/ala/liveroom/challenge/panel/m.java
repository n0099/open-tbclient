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
    CountDownTimer gNO;
    private n hsv;
    private TextView htA;
    private TextView htB;
    private ImageView htC;
    private TextView htD;
    private TextView htE;
    private String htF;
    long htG;
    private ImageView hty;
    private ImageView htz;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.htF = this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_begin_text);
        this.htG = 0L;
        this.hsv = nVar;
        this.hty = (ImageView) this.mRootView.findViewById(a.f.ala_paiwei_entry);
        this.htz = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_entry);
        this.htA = (TextView) this.mRootView.findViewById(a.f.ala_paiwei_entry_title);
        this.htB = (TextView) this.mRootView.findViewById(a.f.ala_challenge_entry_title);
        this.htC = (ImageView) this.mRootView.findViewById(a.f.ala_red_point);
        this.htD = (TextView) this.mRootView.findViewById(a.f.ala_red_point_text);
        this.htC.setVisibility(8);
        this.htE = (TextView) this.mRootView.findViewById(a.f.ala_qualifying_count_down);
        this.htE.setVisibility(8);
        this.hty.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hsv != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hsv.removeView();
                }
            }
        });
        this.htA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hsv != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hsv.removeView();
                }
            }
        });
        this.htz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bp(m.this.canUseChallenge);
                if (m.this.hsv != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hsv.ccF();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.htB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bp(m.this.canUseChallenge);
                if (m.this.hsv != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hsv.ccF();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bp(boolean z) {
        this.canUseChallenge = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cv(int i) {
        this.mCount = i;
        if (this.mCount == 0) {
            this.htC.setVisibility(4);
            this.htD.setText("");
        }
        if (this.mCount > 0) {
            this.htC.setVisibility(0);
            this.htD.setText(this.mContext.getString(a.h.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.htD.setText(this.mContext.getResources().getString(a.h.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int ccr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.hsv.ct(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hsv.fy(dVar.userId);
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
        this.hsv.removeView();
        return true;
    }

    public void ccP() {
        if (this.gNO != null) {
            this.gNO.cancel();
        }
        this.gNO = new CountDownTimer(this.htG, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.htE.setVisibility(0);
                m.this.htE.setText(m.this.htF + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bUn();
            }
        };
        this.gNO.start();
    }

    public void fA(long j) {
        this.htG = j;
    }

    public void bUn() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.htE.setVisibility(0);
        this.htE.setText(this.htF + "00:00:00");
        this.hty.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
        this.htA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void ty() {
        this.htE.setVisibility(8);
    }
}
