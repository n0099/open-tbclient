package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class i {
    private TextView dXU;
    private TextView fOn;
    private int fOq;
    private HeadImageView fPE;
    private com.baidu.live.challenge.d fPF;
    private a fPG;
    private Context mContext;
    private View mRootView;
    private Runnable fCU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.4
        @Override // java.lang.Runnable
        public void run() {
            i.e(i.this);
            i.this.fOn.setText(i.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(i.this.fOq)));
            if (i.this.fOq > 0) {
                i.this.mHandler.postDelayed(this, 1000L);
            } else if (i.this.fPG != null) {
                i.this.fPG.a(i.this);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* loaded from: classes3.dex */
    public interface a {
        void a(i iVar);

        void c(com.baidu.live.challenge.d dVar);
    }

    static /* synthetic */ int e(i iVar) {
        int i = iVar.fOq;
        iVar.fOq = i - 1;
        return i;
    }

    public i(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.fPE = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.fPE.setIsRound(true);
        this.fPE.setAutoChangeStyle(false);
        this.dXU = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.fOn = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.bAu();
            }
        });
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.fPF = dVar;
        this.fPE.startLoad(dVar.avatar, 25, false);
        this.dXU.setText(dVar.userName);
        this.fOq = (int) ((dVar.auo + 60) - (System.currentTimeMillis() / 1000));
        if (this.fOq > 0) {
            if (this.fOq > 60) {
                this.fOq = 60;
            }
            this.fOn.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.fOq)));
            this.mHandler.removeCallbacks(this.fCU);
            this.mHandler.postDelayed(this.fCU, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAu() {
        if (this.fPF != null) {
            final Dialog dialog = new Dialog(this.mContext, a.j.ChallengeDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.fPF.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.fPF.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.fPF.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.fPF.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.fPG != null) {
                        i.this.fPG.c(i.this.fPF);
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
        this.fPG = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d bAv() {
        return this.fPF;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.fCU);
    }
}
