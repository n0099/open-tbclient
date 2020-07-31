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
    private TextView dKI;
    private TextView gfl;
    private int gfo;
    private HeadImageView ggI;
    private com.baidu.live.challenge.d ggJ;
    private a ggK;
    private Context mContext;
    private View mRootView;
    private Runnable fTw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.4
        @Override // java.lang.Runnable
        public void run() {
            k.e(k.this);
            k.this.gfl.setText(k.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(k.this.gfo)));
            if (k.this.gfo > 0) {
                k.this.mHandler.postDelayed(this, 1000L);
            } else if (k.this.ggK != null) {
                k.this.ggK.a(k.this);
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
        int i = kVar.gfo;
        kVar.gfo = i - 1;
        return i;
    }

    public k(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.ggI = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.ggI.setIsRound(true);
        this.ggI.setAutoChangeStyle(false);
        this.dKI = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.gfl = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.bGF();
            }
        });
    }

    public void k(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.ggJ = dVar;
        this.ggI.startLoad(dVar.avatar, 25, false);
        this.dKI.setText(dVar.userName);
        this.gfo = (int) ((dVar.axw + 60) - (System.currentTimeMillis() / 1000));
        if (this.gfo > 0) {
            if (this.gfo > 60) {
                this.gfo = 60;
            }
            this.gfl.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.gfo)));
            this.mHandler.removeCallbacks(this.fTw);
            this.mHandler.postDelayed(this.fTw, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGF() {
        if (this.ggJ != null) {
            final Dialog dialog = new Dialog(this.mContext, a.j.ChallengeDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.ggJ.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.ggJ.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.ggJ.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.ggJ.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (k.this.ggK != null) {
                        k.this.ggK.c(k.this.ggJ);
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
        this.ggK = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d bGG() {
        return this.ggJ;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.fTw);
    }
}
