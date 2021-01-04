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
    CountDownTimer gSu;
    private n hxb;
    private ImageView hye;
    private ImageView hyf;
    private TextView hyg;
    private TextView hyh;
    private ImageView hyi;
    private TextView hyj;
    private TextView hyk;
    private String hyl;
    long hym;
    private int mCount;

    public m(Context context, n nVar) {
        super(context, nVar);
        this.mCount = 0;
        this.hyl = this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_begin_text);
        this.hym = 0L;
        this.hxb = nVar;
        this.hye = (ImageView) this.mRootView.findViewById(a.f.ala_paiwei_entry);
        this.hyf = (ImageView) this.mRootView.findViewById(a.f.ala_challenge_entry);
        this.hyg = (TextView) this.mRootView.findViewById(a.f.ala_paiwei_entry_title);
        this.hyh = (TextView) this.mRootView.findViewById(a.f.ala_challenge_entry_title);
        this.hyi = (ImageView) this.mRootView.findViewById(a.f.ala_red_point);
        this.hyj = (TextView) this.mRootView.findViewById(a.f.ala_red_point_text);
        this.hyi.setVisibility(8);
        this.hyk = (TextView) this.mRootView.findViewById(a.f.ala_qualifying_count_down);
        this.hyk.setVisibility(8);
        this.hye.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hxb != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hxb.removeView();
                }
            }
        });
        this.hyg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hxb != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913233, "aaa"));
                    m.this.hxb.removeView();
                }
            }
        });
        this.hyf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bt(m.this.canUseChallenge);
                if (m.this.hxb != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hxb.cgw();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
        this.hyh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.bt(m.this.canUseChallenge);
                if (m.this.hxb != null) {
                    if (m.this.canUseChallenge) {
                        m.this.hxb.cgw();
                    } else {
                        BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getString(a.h.sdk_can_not_use_challenge));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bt(boolean z) {
        this.canUseChallenge = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eb(int i) {
        this.mCount = i;
        if (this.mCount == 0) {
            this.hyi.setVisibility(4);
            this.hyj.setText("");
        }
        if (this.mCount > 0) {
            this.hyi.setVisibility(0);
            this.hyj.setText(this.mContext.getString(a.h.ala_challenge_number, Integer.valueOf(i)));
            if (this.mCount > 99) {
                this.hyj.setText(this.mContext.getResources().getString(a.h.sdk_red_point_count_too_much));
            }
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_qualifying_entry, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cgi() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds438) + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds236);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void a(k kVar) {
        this.hxb.dZ(this.mCount);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.k.a
    public void c(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hxb.fy(dVar.userId);
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
        this.hxb.removeView();
        return true;
    }

    public void cgG() {
        if (this.gSu != null) {
            this.gSu.cancel();
        }
        this.gSu = new CountDownTimer(this.hym, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.5
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String formatSecondsTimes = StringHelper.formatSecondsTimes(Math.round(j / 1000.0d));
                m.this.hyk.setVisibility(0);
                m.this.hyk.setText(m.this.hyl + formatSecondsTimes);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                m.this.bYe();
            }
        };
        this.gSu.start();
    }

    public void fA(long j) {
        this.hym = j;
    }

    public void bYe() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913237, false));
        this.hyk.setVisibility(0);
        this.hyk.setText(this.hyl + "00:00:00");
        this.hye.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
        this.hyg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BdUtilHelper.showToast(m.this.mContext, m.this.mContext.getResources().getString(a.h.sdk_qualifying_count_down_end_text));
            }
        });
    }

    public void tJ() {
        this.hyk.setVisibility(8);
    }
}
