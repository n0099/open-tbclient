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
    CountDownTimer gQI;
    private n hwT;
    private ImageView hxW;
    private ImageView hxX;
    private TextView hxY;
    private TextView hxZ;
    private ImageView hya;
    private TextView hyb;
    private TextView hyc;
    private String hyd;
    long hye;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.hyd = this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_begin_text);
        this.hye = 0L;
        this.hwT = nVar;
        this.hxW = (ImageView) this.mRootView.findViewById(a.f.ala_paiwei_entry);
        this.hxX = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_entry);
        this.hxY = (TextView) this.mRootView.findViewById(a.f.ala_paiwei_entry_title);
        this.hxZ = (TextView) this.mRootView.findViewById(a.f.ala_challenge_entry_title);
        this.hya = (ImageView) this.mRootView.findViewById(a.f.ala_red_point);
        this.hyb = (TextView) this.mRootView.findViewById(a.f.ala_red_point_text);
        this.hya.setVisibility(8);
        this.hyc = (TextView) this.mRootView.findViewById(a.f.ala_qualifying_count_down);
        this.hyc.setVisibility(8);
        this.hxW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hwT != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hwT.removeView();
                }
            }
        });
        this.hxY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hwT != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hwT.removeView();
                }
            }
        });
        this.hxX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.br(m.this.canUseChallenge);
                if (m.this.hwT != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hwT.cdH();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.hxZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.br(m.this.canUseChallenge);
                if (m.this.hwT != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hwT.cdH();
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
            this.hya.setVisibility(4);
            this.hyb.setText("");
        }
        if (this.mCount > 0) {
            this.hya.setVisibility(0);
            this.hyb.setText(this.mContext.getString(a.h.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.hyb.setText(this.mContext.getResources().getString(a.h.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdt() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.hwT.cw(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hwT.fD(dVar.userId);
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
        this.hwT.removeView();
        return true;
    }

    public void cdR() {
        if (this.gQI != null) {
            this.gQI.cancel();
        }
        this.gQI = new CountDownTimer(this.hye, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.hyc.setVisibility(0);
                m.this.hyc.setText(m.this.hyd + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bUZ();
            }
        };
        this.gQI.start();
    }

    public void fF(long j) {
        this.hye = j;
    }

    public void bUZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.hyc.setVisibility(0);
        this.hyc.setText(this.hyd + "00:00:00");
        this.hxW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
        this.hxY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void tv() {
        this.hyc.setVisibility(8);
    }
}
