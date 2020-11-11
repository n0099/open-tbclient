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
    private n hbO;
    private ImageView hcR;
    private ImageView hcS;
    private TextView hcT;
    private TextView hcU;
    private ImageView hcV;
    private TextView hcW;
    private TextView hcX;
    CountDownTimer hcY;
    private String hcZ;
    long hda;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.hcZ = this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_begin_text);
        this.hda = 0L;
        this.hbO = nVar;
        this.hcR = (ImageView) this.mRootView.findViewById(a.f.ala_paiwei_entry);
        this.hcS = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_entry);
        this.hcT = (TextView) this.mRootView.findViewById(a.f.ala_paiwei_entry_title);
        this.hcU = (TextView) this.mRootView.findViewById(a.f.ala_challenge_entry_title);
        this.hcV = (ImageView) this.mRootView.findViewById(a.f.ala_red_point);
        this.hcW = (TextView) this.mRootView.findViewById(a.f.ala_red_point_text);
        this.hcV.setVisibility(8);
        this.hcX = (TextView) this.mRootView.findViewById(a.f.ala_qualifying_count_down);
        this.hcX.setVisibility(8);
        this.hcR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hbO != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hbO.removeView();
                }
            }
        });
        this.hcT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hbO != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hbO.removeView();
                }
            }
        });
        this.hcS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bm(m.this.canUseChallenge);
                if (m.this.hbO != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hbO.car();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.hcU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bm(m.this.canUseChallenge);
                if (m.this.hbO != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hbO.car();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bm(boolean z) {
        this.canUseChallenge = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dP(int i) {
        this.mCount = i;
        if (this.mCount == 0) {
            this.hcV.setVisibility(4);
            this.hcW.setText("");
        }
        if (this.mCount > 0) {
            this.hcV.setVisibility(0);
            this.hcW.setText(this.mContext.getString(a.h.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.hcW.setText(this.mContext.getResources().getString(a.h.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cad() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Pc() {
        super.Pc();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.hbO.dN(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hbO.eU(dVar.userId);
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
        this.hbO.removeView();
        return true;
    }

    public void caB() {
        if (this.hcY != null) {
            this.hcY.cancel();
        }
        this.hcY = new CountDownTimer(this.hda, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.hcX.setVisibility(0);
                m.this.hcX.setText(m.this.hcZ + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bSv();
            }
        };
        this.hcY.start();
    }

    public void eW(long j) {
        this.hda = j;
    }

    public void bSv() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.hcX.setVisibility(0);
        this.hcX.setText(this.hcZ + "00:00:00");
        this.hcR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
        this.hcT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void uh() {
        this.hcX.setVisibility(8);
    }
}
