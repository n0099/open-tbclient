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
    private n gvA;
    private ImageView gwF;
    private ImageView gwG;
    private TextView gwH;
    private TextView gwI;
    private ImageView gwJ;
    private TextView gwK;
    private TextView gwL;
    CountDownTimer gwM;
    private String gwN;
    long gwO;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.gwN = this.mContext.getResources().getString(a.i.sdk_qualifying_count_down_begin_text);
        this.gwO = 0L;
        this.gvA = nVar;
        this.gwF = (ImageView) this.mRootView.findViewById(a.g.ala_paiwei_entry);
        this.gwG = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_entry);
        this.gwH = (TextView) this.mRootView.findViewById(a.g.ala_paiwei_entry_title);
        this.gwI = (TextView) this.mRootView.findViewById(a.g.ala_challenge_entry_title);
        this.gwJ = (ImageView) this.mRootView.findViewById(a.g.ala_red_point);
        this.gwK = (TextView) this.mRootView.findViewById(a.g.ala_red_point_text);
        this.gwJ.setVisibility(8);
        this.gwL = (TextView) this.mRootView.findViewById(a.g.ala_qualifying_count_down);
        this.gwL.setVisibility(8);
        this.gwF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gvA != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.gvA.removeView();
                }
            }
        });
        this.gwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gvA != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.gvA.removeView();
                }
            }
        });
        this.gwG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bg(m.this.canUseChallenge);
                if (m.this.gvA != null) {
                    if (m.this.canUseChallenge) {
                        m.this.gvA.bRw();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.i.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.gwI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bg(m.this.canUseChallenge);
                if (m.this.gvA != null) {
                    if (m.this.canUseChallenge) {
                        m.this.gvA.bRw();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.i.sdk_can_not_use_challenge));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bg(boolean z) {
        this.canUseChallenge = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dK(int i) {
        this.mCount = i;
        if (this.mCount == 0) {
            this.gwJ.setVisibility(4);
            this.gwK.setText("");
        }
        if (this.mCount > 0) {
            this.gwJ.setVisibility(0);
            this.gwK.setText(this.mContext.getString(a.i.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.gwK.setText(this.mContext.getResources().getString(a.i.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bRi() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void MZ() {
        super.MZ();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.gvA.dI(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gvA.eg(dVar.userId);
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
        this.gvA.removeView();
        return true;
    }

    public void bRG() {
        if (this.gwM != null) {
            this.gwM.cancel();
        }
        this.gwM = new CountDownTimer(this.gwO, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.gwL.setVisibility(0);
                m.this.gwL.setText(m.this.gwN + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bKG();
            }
        };
        this.gwM.start();
    }

    public void ei(long j) {
        this.gwO = j;
    }

    public void bKG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.gwL.setVisibility(0);
        this.gwL.setText(this.gwN + "00:00:00");
        this.gwF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.i.sdk_qualifying_count_down_end_text));
            }
        });
        this.gwH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.i.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void uh() {
        this.gwL.setVisibility(8);
    }
}
