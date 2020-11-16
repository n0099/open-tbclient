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
    private n hbv;
    private TextView hcA;
    private TextView hcB;
    private ImageView hcC;
    private TextView hcD;
    private TextView hcE;
    CountDownTimer hcF;
    private String hcG;
    long hcH;
    private ImageView hcy;
    private ImageView hcz;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.hcG = this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_begin_text);
        this.hcH = 0L;
        this.hbv = nVar;
        this.hcy = (ImageView) this.mRootView.findViewById(a.f.ala_paiwei_entry);
        this.hcz = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_entry);
        this.hcA = (TextView) this.mRootView.findViewById(a.f.ala_paiwei_entry_title);
        this.hcB = (TextView) this.mRootView.findViewById(a.f.ala_challenge_entry_title);
        this.hcC = (ImageView) this.mRootView.findViewById(a.f.ala_red_point);
        this.hcD = (TextView) this.mRootView.findViewById(a.f.ala_red_point_text);
        this.hcC.setVisibility(8);
        this.hcE = (TextView) this.mRootView.findViewById(a.f.ala_qualifying_count_down);
        this.hcE.setVisibility(8);
        this.hcy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hbv != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hbv.removeView();
                }
            }
        });
        this.hcA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hbv != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hbv.removeView();
                }
            }
        });
        this.hcz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bo(m.this.canUseChallenge);
                if (m.this.hbv != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hbv.bZK();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.hcB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bo(m.this.canUseChallenge);
                if (m.this.hbv != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hbv.bZK();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bo(boolean z) {
        this.canUseChallenge = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dL(int i) {
        this.mCount = i;
        if (this.mCount == 0) {
            this.hcC.setVisibility(4);
            this.hcD.setText("");
        }
        if (this.mCount > 0) {
            this.hcC.setVisibility(0);
            this.hcD.setText(this.mContext.getString(a.h.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.hcD.setText(this.mContext.getResources().getString(a.h.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bZw() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Ot() {
        super.Ot();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.hbv.dJ(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hbv.eU(dVar.userId);
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
        this.hbv.removeView();
        return true;
    }

    public void bZU() {
        if (this.hcF != null) {
            this.hcF.cancel();
        }
        this.hcF = new CountDownTimer(this.hcH, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.hcE.setVisibility(0);
                m.this.hcE.setText(m.this.hcG + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bRO();
            }
        };
        this.hcF.start();
    }

    public void eW(long j) {
        this.hcH = j;
    }

    public void bRO() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.hcE.setVisibility(0);
        this.hcE.setText(this.hcG + "00:00:00");
        this.hcy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
        this.hcA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void uh() {
        this.hcE.setVisibility(8);
    }
}
