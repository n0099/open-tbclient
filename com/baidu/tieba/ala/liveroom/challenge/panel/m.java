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
/* loaded from: classes11.dex */
public class m extends g implements k.a {
    private boolean canUseChallenge;
    CountDownTimer gQu;
    private n hwF;
    private ImageView hxI;
    private ImageView hxJ;
    private TextView hxK;
    private TextView hxL;
    private ImageView hxM;
    private TextView hxN;
    private TextView hxO;
    private String hxP;
    long hxQ;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.hxP = this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_begin_text);
        this.hxQ = 0L;
        this.hwF = nVar;
        this.hxI = (ImageView) this.mRootView.findViewById(a.f.ala_paiwei_entry);
        this.hxJ = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_entry);
        this.hxK = (TextView) this.mRootView.findViewById(a.f.ala_paiwei_entry_title);
        this.hxL = (TextView) this.mRootView.findViewById(a.f.ala_challenge_entry_title);
        this.hxM = (ImageView) this.mRootView.findViewById(a.f.ala_red_point);
        this.hxN = (TextView) this.mRootView.findViewById(a.f.ala_red_point_text);
        this.hxM.setVisibility(8);
        this.hxO = (TextView) this.mRootView.findViewById(a.f.ala_qualifying_count_down);
        this.hxO.setVisibility(8);
        this.hxI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hwF != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hwF.removeView();
                }
            }
        });
        this.hxK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hwF != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hwF.removeView();
                }
            }
        });
        this.hxJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.br(m.this.canUseChallenge);
                if (m.this.hwF != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hwF.cdA();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.hxL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.br(m.this.canUseChallenge);
                if (m.this.hwF != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hwF.cdA();
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
    public void cy(int i) {
        this.mCount = i;
        if (this.mCount == 0) {
            this.hxM.setVisibility(4);
            this.hxN.setText("");
        }
        if (this.mCount > 0) {
            this.hxM.setVisibility(0);
            this.hxN.setText(this.mContext.getString(a.h.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.hxN.setText(this.mContext.getResources().getString(a.h.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdm() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.hwF.cw(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hwF.fD(dVar.userId);
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
        this.hwF.removeView();
        return true;
    }

    public void cdK() {
        if (this.gQu != null) {
            this.gQu.cancel();
        }
        this.gQu = new CountDownTimer(this.hxQ, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.hxO.setVisibility(0);
                m.this.hxO.setText(m.this.hxP + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bUS();
            }
        };
        this.gQu.start();
    }

    public void fF(long j) {
        this.hxQ = j;
    }

    public void bUS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.hxO.setVisibility(0);
        this.hxO.setText(this.hxP + "00:00:00");
        this.hxI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
        this.hxK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void tv() {
        this.hxO.setVisibility(8);
    }
}
