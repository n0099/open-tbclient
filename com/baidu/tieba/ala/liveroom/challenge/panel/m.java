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
    private n gVK;
    private ImageView gWN;
    private ImageView gWO;
    private TextView gWP;
    private TextView gWQ;
    private ImageView gWR;
    private TextView gWS;
    private TextView gWT;
    CountDownTimer gWU;
    private String gWV;
    long gWW;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.gWV = this.mContext.getResources().getString(a.i.sdk_qualifying_count_down_begin_text);
        this.gWW = 0L;
        this.gVK = nVar;
        this.gWN = (ImageView) this.mRootView.findViewById(a.g.ala_paiwei_entry);
        this.gWO = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_entry);
        this.gWP = (TextView) this.mRootView.findViewById(a.g.ala_paiwei_entry_title);
        this.gWQ = (TextView) this.mRootView.findViewById(a.g.ala_challenge_entry_title);
        this.gWR = (ImageView) this.mRootView.findViewById(a.g.ala_red_point);
        this.gWS = (TextView) this.mRootView.findViewById(a.g.ala_red_point_text);
        this.gWR.setVisibility(8);
        this.gWT = (TextView) this.mRootView.findViewById(a.g.ala_qualifying_count_down);
        this.gWT.setVisibility(8);
        this.gWN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gVK != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.gVK.removeView();
                }
            }
        });
        this.gWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gVK != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.gVK.removeView();
                }
            }
        });
        this.gWO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bl(m.this.canUseChallenge);
                if (m.this.gVK != null) {
                    if (m.this.canUseChallenge) {
                        m.this.gVK.bXP();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.i.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.gWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bl(m.this.canUseChallenge);
                if (m.this.gVK != null) {
                    if (m.this.canUseChallenge) {
                        m.this.gVK.bXP();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.i.sdk_can_not_use_challenge));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bl(boolean z) {
        this.canUseChallenge = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dP(int i) {
        this.mCount = i;
        if (this.mCount == 0) {
            this.gWR.setVisibility(4);
            this.gWS.setText("");
        }
        if (this.mCount > 0) {
            this.gWR.setVisibility(0);
            this.gWS.setText(this.mContext.getString(a.i.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.gWS.setText(this.mContext.getResources().getString(a.i.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bXB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void OC() {
        super.OC();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.gVK.dN(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gVK.ey(dVar.userId);
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
        this.gVK.removeView();
        return true;
    }

    public void bXZ() {
        if (this.gWU != null) {
            this.gWU.cancel();
        }
        this.gWU = new CountDownTimer(this.gWW, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.gWT.setVisibility(0);
                m.this.gWT.setText(m.this.gWV + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bPV();
            }
        };
        this.gWU.start();
    }

    public void eA(long j) {
        this.gWW = j;
    }

    public void bPV() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.gWT.setVisibility(0);
        this.gWT.setText(this.gWV + "00:00:00");
        this.gWN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.i.sdk_qualifying_count_down_end_text));
            }
        });
        this.gWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.i.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void uh() {
        this.gWT.setVisibility(8);
    }
}
