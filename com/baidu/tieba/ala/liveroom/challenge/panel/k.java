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
    private TextView eIO;
    private int hvC;
    private TextView hwm;
    private HeadImageView hxI;
    private com.baidu.live.challenge.d hxJ;
    private a hxK;
    private Context mContext;
    private View mRootView;
    private Runnable hdO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.4
        @Override // java.lang.Runnable
        public void run() {
            k.e(k.this);
            k.this.hwm.setText(k.this.mContext.getString(a.h.ala_challenge_panel_countdown, Integer.valueOf(k.this.hvC)));
            if (k.this.hvC > 0) {
                k.this.mHandler.postDelayed(this, 1000L);
            } else if (k.this.hxK != null) {
                k.this.hxK.a(k.this);
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
        int i = kVar.hvC;
        kVar.hvC = i - 1;
        return i;
    }

    public k(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenger_item_layout, (ViewGroup) null);
        this.hxI = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenger_user_header);
        this.hxI.setIsRound(true);
        this.hxI.setAutoChangeStyle(false);
        this.eIO = (TextView) this.mRootView.findViewById(a.f.ala_challenger_user_name);
        this.hwm = (TextView) this.mRootView.findViewById(a.f.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.cdP();
            }
        });
    }

    public void k(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.hxJ = dVar;
        this.hxI.startLoad(dVar.avatar, 25, false);
        this.eIO.setText(dVar.userName);
        this.hvC = (int) ((dVar.aFF + 60) - (System.currentTimeMillis() / 1000));
        if (this.hvC > 0) {
            if (this.hvC > 60) {
                this.hvC = 60;
            }
            this.hwm.setText(this.mContext.getString(a.h.ala_challenge_panel_countdown, Integer.valueOf(this.hvC)));
            this.mHandler.removeCallbacks(this.hdO);
            this.mHandler.postDelayed(this.hdO, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdP() {
        if (this.hxJ != null) {
            final Dialog dialog = new Dialog(this.mContext, a.i.ChallengeDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.f.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.hxJ.avatar, 25, false);
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_name)).setText(this.hxJ.userName);
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.h.sdk_host_id, String.valueOf(this.hxJ.alaId)));
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept_tip)).setText(this.mContext.getString(a.h.ala_challenge_panel_accept_tip, this.hxJ.userName));
            ((TextView) inflate.findViewById(a.f.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.f.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.k.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (k.this.hxK != null) {
                        k.this.hxK.c(k.this.hxJ);
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
        this.hxK = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d cdQ() {
        return this.hxJ;
    }

    public void onDestory() {
        this.mHandler.removeCallbacksAndMessages(this.hdO);
    }
}
