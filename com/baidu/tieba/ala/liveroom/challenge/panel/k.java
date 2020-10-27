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
    private TextView eqE;
    private int gUt;
    private TextView gVd;
    private com.baidu.live.challenge.d gWA;
    private a gWB;
    private HeadImageView gWz;
    private Context mContext;
    private View mRootView;
    private Runnable gFb = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.4
        @Override // java.lang.Runnable
        public void run() {
            k.e(k.this);
            k.this.gVd.setText(k.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(k.this.gUt)));
            if (k.this.gUt > 0) {
                k.this.mHandler.postDelayed(this, 1000L);
            } else if (k.this.gWB != null) {
                k.this.gWB.a(k.this);
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
        int i = kVar.gUt;
        kVar.gUt = i - 1;
        return i;
    }

    public k(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.gWz = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.gWz.setIsRound(true);
        this.gWz.setAutoChangeStyle(false);
        this.eqE = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.gVd = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.bXX();
            }
        });
    }

    public void k(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.gWA = dVar;
        this.gWz.startLoad(dVar.avatar, 25, false);
        this.eqE.setText(dVar.userName);
        this.gUt = (int) ((dVar.aGw + 60) - (System.currentTimeMillis() / 1000));
        if (this.gUt > 0) {
            if (this.gUt > 60) {
                this.gUt = 60;
            }
            this.gVd.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.gUt)));
            this.mHandler.removeCallbacks(this.gFb);
            this.mHandler.postDelayed(this.gFb, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXX() {
        if (this.gWA != null) {
            final Dialog dialog = new Dialog(this.mContext, a.j.ChallengeDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.gWA.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.gWA.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.gWA.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.gWA.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (k.this.gWB != null) {
                        k.this.gWB.c(k.this.gWA);
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
        this.gWB = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d bXY() {
        return this.gWA;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.gFb);
    }
}
