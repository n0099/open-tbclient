package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class k {
    private TextView eBQ;
    private int hjP;
    private TextView hkz;
    private HeadImageView hlV;
    private com.baidu.live.challenge.d hlW;
    private a hlX;
    private Context mContext;
    private View mRootView;
    private Runnable gTJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.4
        @Override // java.lang.Runnable
        public void run() {
            k.e(k.this);
            k.this.hkz.setText(k.this.mContext.getString(a.h.ala_challenge_panel_countdown, Integer.valueOf(k.this.hjP)));
            if (k.this.hjP > 0) {
                k.this.mHandler.postDelayed(this, 1000L);
            } else if (k.this.hlX != null) {
                k.this.hlX.a(k.this);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* loaded from: classes4.dex */
    public interface a {
        void a(k kVar);

        void c(com.baidu.live.challenge.d dVar);
    }

    static /* synthetic */ int e(k kVar) {
        int i = kVar.hjP;
        kVar.hjP = i - 1;
        return i;
    }

    public k(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenger_item_layout, (ViewGroup) null);
        this.hlV = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenger_user_header);
        this.hlV.setIsRound(true);
        this.hlV.setAutoChangeStyle(false);
        this.eBQ = (TextView) this.mRootView.findViewById(a.f.ala_challenger_user_name);
        this.hkz = (TextView) this.mRootView.findViewById(a.f.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.cdO();
            }
        });
    }

    public void k(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.hlW = dVar;
        this.hlV.startLoad(dVar.avatar, 25, false);
        this.eBQ.setText(dVar.userName);
        this.hjP = (int) ((dVar.aIj + 60) - (System.currentTimeMillis() / 1000));
        if (this.hjP > 0) {
            if (this.hjP > 60) {
                this.hjP = 60;
            }
            this.hkz.setText(this.mContext.getString(a.h.ala_challenge_panel_countdown, Integer.valueOf(this.hjP)));
            this.mHandler.removeCallbacks(this.gTJ);
            this.mHandler.postDelayed(this.gTJ, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdO() {
        if (this.hlW != null) {
            final Dialog dialog = new Dialog(this.mContext, a.i.ChallengeDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.f.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.hlW.avatar, 25, false);
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_name)).setText(this.hlW.userName);
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.h.sdk_host_id, String.valueOf(this.hlW.alaId)));
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_tip)).setText(this.mContext.getString(a.h.ala_challenge_panel_accept_tip, this.hlW.userName));
            ((TextView) inflate.findViewById(a.f.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (k.this.hlX != null) {
                        k.this.hlX.c(k.this.hlW);
                    }
                    dialog.dismiss();
                }
            });
            dialog.show();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                window.setContentView(inflate);
            }
        }
    }

    public boolean isVisible() {
        return this.mRootView.getVisibility() == 0;
    }

    public void a(a aVar) {
        this.hlX = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d cdP() {
        return this.hlW;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.gTJ);
    }
}
