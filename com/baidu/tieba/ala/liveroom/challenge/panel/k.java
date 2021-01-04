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
/* loaded from: classes11.dex */
public class k {
    private TextView eLt;
    private int hvK;
    private TextView hwu;
    private HeadImageView hxQ;
    private com.baidu.live.challenge.d hxR;
    private a hxS;
    private Context mContext;
    private View mRootView;
    private Runnable hfw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.4
        @Override // java.lang.Runnable
        public void run() {
            k.e(k.this);
            k.this.hwu.setText(k.this.mContext.getString(a.h.ala_challenge_panel_countdown, Integer.valueOf(k.this.hvK)));
            if (k.this.hvK > 0) {
                k.this.mHandler.postDelayed(this, 1000L);
            } else if (k.this.hxS != null) {
                k.this.hxS.a(k.this);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* loaded from: classes11.dex */
    public interface a {
        void a(k kVar);

        void c(com.baidu.live.challenge.d dVar);
    }

    static /* synthetic */ int e(k kVar) {
        int i = kVar.hvK;
        kVar.hvK = i - 1;
        return i;
    }

    public k(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenger_item_layout, (ViewGroup) null);
        this.hxQ = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenger_user_header);
        this.hxQ.setIsRound(true);
        this.hxQ.setAutoChangeStyle(false);
        this.eLt = (TextView) this.mRootView.findViewById(a.f.ala_challenger_user_name);
        this.hwu = (TextView) this.mRootView.findViewById(a.f.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.cgE();
            }
        });
    }

    public void k(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.hxR = dVar;
        this.hxQ.startLoad(dVar.avatar, 25, false);
        this.eLt.setText(dVar.userName);
        this.hvK = (int) ((dVar.aIF + 60) - (System.currentTimeMillis() / 1000));
        if (this.hvK > 0) {
            if (this.hvK > 60) {
                this.hvK = 60;
            }
            this.hwu.setText(this.mContext.getString(a.h.ala_challenge_panel_countdown, Integer.valueOf(this.hvK)));
            this.mHandler.removeCallbacks(this.hfw);
            this.mHandler.postDelayed(this.hfw, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgE() {
        if (this.hxR != null) {
            final Dialog dialog = new Dialog(this.mContext, a.i.ChallengeDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.f.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.hxR.avatar, 25, false);
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_name)).setText(this.hxR.userName);
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.h.sdk_host_id, String.valueOf(this.hxR.alaId)));
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_tip)).setText(this.mContext.getString(a.h.ala_challenge_panel_accept_tip, this.hxR.userName));
            ((TextView) inflate.findViewById(a.f.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (k.this.hxS != null) {
                        k.this.hxS.c(k.this.hxR);
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
        this.hxS = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d cgF() {
        return this.hxR;
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(this.hfw);
    }
}
