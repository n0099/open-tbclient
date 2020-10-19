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
    private n gJV;
    private ImageView gKY;
    private ImageView gKZ;
    private TextView gLa;
    private TextView gLb;
    private ImageView gLc;
    private TextView gLd;
    private TextView gLe;
    CountDownTimer gLf;
    private String gLg;
    long gLh;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.gLg = this.mContext.getResources().getString(a.i.sdk_qualifying_count_down_begin_text);
        this.gLh = 0L;
        this.gJV = nVar;
        this.gKY = (ImageView) this.mRootView.findViewById(a.g.ala_paiwei_entry);
        this.gKZ = (ImageView) this.mRootView.findViewById(a.g.ala_challenge_entry);
        this.gLa = (TextView) this.mRootView.findViewById(a.g.ala_paiwei_entry_title);
        this.gLb = (TextView) this.mRootView.findViewById(a.g.ala_challenge_entry_title);
        this.gLc = (ImageView) this.mRootView.findViewById(a.g.ala_red_point);
        this.gLd = (TextView) this.mRootView.findViewById(a.g.ala_red_point_text);
        this.gLc.setVisibility(8);
        this.gLe = (TextView) this.mRootView.findViewById(a.g.ala_qualifying_count_down);
        this.gLe.setVisibility(8);
        this.gKY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gJV != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.gJV.removeView();
                }
            }
        });
        this.gLa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gJV != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.gJV.removeView();
                }
            }
        });
        this.gKZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bk(m.this.canUseChallenge);
                if (m.this.gJV != null) {
                    if (m.this.canUseChallenge) {
                        m.this.gJV.bUQ();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.i.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.gLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bk(m.this.canUseChallenge);
                if (m.this.gJV != null) {
                    if (m.this.canUseChallenge) {
                        m.this.gJV.bUQ();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.i.sdk_can_not_use_challenge));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bk(boolean z) {
        this.canUseChallenge = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dP(int i) {
        this.mCount = i;
        if (this.mCount == 0) {
            this.gLc.setVisibility(4);
            this.gLd.setText("");
        }
        if (this.mCount > 0) {
            this.gLc.setVisibility(0);
            this.gLd.setText(this.mContext.getString(a.i.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.gLd.setText(this.mContext.getResources().getString(a.i.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bUC() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Oe() {
        super.Oe();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.gJV.dN(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gJV.ew(dVar.userId);
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
        this.gJV.removeView();
        return true;
    }

    public void bVa() {
        if (this.gLf != null) {
            this.gLf.cancel();
        }
        this.gLf = new CountDownTimer(this.gLh, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.gLe.setVisibility(0);
                m.this.gLe.setText(m.this.gLg + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bNq();
            }
        };
        this.gLf.start();
    }

    public void ey(long j) {
        this.gLh = j;
    }

    public void bNq() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.gLe.setVisibility(0);
        this.gLe.setText(this.gLg + "00:00:00");
        this.gKY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.i.sdk_qualifying_count_down_end_text));
            }
        });
        this.gLa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.i.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void uh() {
        this.gLe.setVisibility(8);
    }
}
