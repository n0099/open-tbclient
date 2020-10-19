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
    private TextView eig;
    private int gIE;
    private TextView gJo;
    private HeadImageView gKK;
    private com.baidu.live.challenge.d gKL;
    private a gKM;
    private Context mContext;
    private View mRootView;
    private Runnable guX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.4
        @Override // java.lang.Runnable
        public void run() {
            k.e(k.this);
            k.this.gJo.setText(k.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(k.this.gIE)));
            if (k.this.gIE > 0) {
                k.this.mHandler.postDelayed(this, 1000L);
            } else if (k.this.gKM != null) {
                k.this.gKM.a(k.this);
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
        int i = kVar.gIE;
        kVar.gIE = i - 1;
        return i;
    }

    public k(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.gKK = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.gKK.setIsRound(true);
        this.gKK.setAutoChangeStyle(false);
        this.eig = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.gJo = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.bUY();
            }
        });
    }

    public void k(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.gKL = dVar;
        this.gKK.startLoad(dVar.avatar, 25, false);
        this.eig.setText(dVar.userName);
        this.gIE = (int) ((dVar.aGo + 60) - (System.currentTimeMillis() / 1000));
        if (this.gIE > 0) {
            if (this.gIE > 60) {
                this.gIE = 60;
            }
            this.gJo.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.gIE)));
            this.mHandler.removeCallbacks(this.guX);
            this.mHandler.postDelayed(this.guX, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUY() {
        if (this.gKL != null) {
            final Dialog dialog = new Dialog(this.mContext, a.j.ChallengeDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.gKL.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.gKL.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.gKL.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.gKL.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (k.this.gKM != null) {
                        k.this.gKM.c(k.this.gKL);
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
        this.gKM = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d bUZ() {
        return this.gKL;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.guX);
    }
}
