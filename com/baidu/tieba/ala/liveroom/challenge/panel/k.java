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
/* loaded from: classes10.dex */
public class k {
    private TextView eKp;
    private TextView hxV;
    private int hxl;
    private HeadImageView hzr;
    private com.baidu.live.challenge.d hzs;
    private a hzt;
    private Context mContext;
    private View mRootView;
    private Runnable hfx = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.4
        @Override // java.lang.Runnable
        public void run() {
            k.e(k.this);
            k.this.hxV.setText(k.this.mContext.getString(a.h.ala_challenge_panel_countdown, Integer.valueOf(k.this.hxl)));
            if (k.this.hxl > 0) {
                k.this.mHandler.postDelayed(this, 1000L);
            } else if (k.this.hzt != null) {
                k.this.hzt.a(k.this);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* loaded from: classes10.dex */
    public interface a {
        void a(k kVar);

        void c(com.baidu.live.challenge.d dVar);
    }

    static /* synthetic */ int e(k kVar) {
        int i = kVar.hxl;
        kVar.hxl = i - 1;
        return i;
    }

    public k(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenger_item_layout, (ViewGroup) null);
        this.hzr = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenger_user_header);
        this.hzr.setIsRound(true);
        this.hzr.setAutoChangeStyle(false);
        this.eKp = (TextView) this.mRootView.findViewById(a.f.ala_challenger_user_name);
        this.hxV = (TextView) this.mRootView.findViewById(a.f.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.cdV();
            }
        });
    }

    public void k(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.hzs = dVar;
        this.hzr.startLoad(dVar.avatar, 25, false);
        this.eKp.setText(dVar.userName);
        this.hxl = (int) ((dVar.aHf + 60) - (System.currentTimeMillis() / 1000));
        if (this.hxl > 0) {
            if (this.hxl > 60) {
                this.hxl = 60;
            }
            this.hxV.setText(this.mContext.getString(a.h.ala_challenge_panel_countdown, Integer.valueOf(this.hxl)));
            this.mHandler.removeCallbacks(this.hfx);
            this.mHandler.postDelayed(this.hfx, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdV() {
        if (this.hzs != null) {
            final Dialog dialog = new Dialog(this.mContext, a.i.ChallengeDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.f.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.hzs.avatar, 25, false);
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_name)).setText(this.hzs.userName);
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.h.sdk_host_id, String.valueOf(this.hzs.alaId)));
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_tip)).setText(this.mContext.getString(a.h.ala_challenge_panel_accept_tip, this.hzs.userName));
            ((TextView) inflate.findViewById(a.f.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (k.this.hzt != null) {
                        k.this.hzt.c(k.this.hzs);
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
        this.hzt = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d cdW() {
        return this.hzs;
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(this.hfx);
    }
}
