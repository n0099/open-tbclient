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
/* loaded from: classes7.dex */
public class k {
    private TextView dTQ;
    private TextView grt;
    private int grw;
    private HeadImageView gsR;
    private com.baidu.live.challenge.d gsS;
    private a gsT;
    private Context mContext;
    private View mRootView;
    private Runnable gfv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.4
        @Override // java.lang.Runnable
        public void run() {
            k.e(k.this);
            k.this.grt.setText(k.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(k.this.grw)));
            if (k.this.grw > 0) {
                k.this.mHandler.postDelayed(this, 1000L);
            } else if (k.this.gsT != null) {
                k.this.gsT.a(k.this);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* loaded from: classes7.dex */
    public interface a {
        void a(k kVar);

        void c(com.baidu.live.challenge.d dVar);
    }

    static /* synthetic */ int e(k kVar) {
        int i = kVar.grw;
        kVar.grw = i - 1;
        return i;
    }

    public k(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.gsR = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.gsR.setIsRound(true);
        this.gsR.setAutoChangeStyle(false);
        this.dTQ = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.grt = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.bQk();
            }
        });
    }

    public void k(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.gsS = dVar;
        this.gsR.startLoad(dVar.avatar, 25, false);
        this.dTQ.setText(dVar.userName);
        this.grw = (int) ((dVar.aCy + 60) - (System.currentTimeMillis() / 1000));
        if (this.grw > 0) {
            if (this.grw > 60) {
                this.grw = 60;
            }
            this.grt.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.grw)));
            this.mHandler.removeCallbacks(this.gfv);
            this.mHandler.postDelayed(this.gfv, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQk() {
        if (this.gsS != null) {
            final Dialog dialog = new Dialog(this.mContext, a.j.ChallengeDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.gsS.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.gsS.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.gsS.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.gsS.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (k.this.gsT != null) {
                        k.this.gsT.c(k.this.gsS);
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
        this.gsT = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d bQl() {
        return this.gsS;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.gfv);
    }
}
