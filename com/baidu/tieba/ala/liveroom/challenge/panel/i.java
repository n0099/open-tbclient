package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class i {
    private TextView bXt;
    private TextView ePE;
    private int ePH;
    private HeadImageView eQR;
    private com.baidu.live.challenge.d eQS;
    private a eQT;
    private Context mContext;
    private View mRootView;
    private Runnable eEL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.4
        @Override // java.lang.Runnable
        public void run() {
            i.e(i.this);
            i.this.ePE.setText(i.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(i.this.ePH)));
            if (i.this.ePH > 0) {
                i.this.mHandler.postDelayed(this, 1000L);
            } else if (i.this.eQT != null) {
                i.this.eQT.a(i.this);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* loaded from: classes2.dex */
    public interface a {
        void a(i iVar);

        void c(com.baidu.live.challenge.d dVar);
    }

    static /* synthetic */ int e(i iVar) {
        int i = iVar.ePH;
        iVar.ePH = i - 1;
        return i;
    }

    public i(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.eQR = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.eQR.setIsRound(true);
        this.eQR.setAutoChangeStyle(false);
        this.bXt = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.ePE = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.biq();
            }
        });
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.eQS = dVar;
        this.eQR.startLoad(dVar.avatar, 25, false);
        this.bXt.setText(dVar.userName);
        this.ePH = (int) ((dVar.Vg + 60) - (System.currentTimeMillis() / 1000));
        if (this.ePH > 0) {
            if (this.ePH > 60) {
                this.ePH = 60;
            }
            this.ePE.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.ePH)));
            this.mHandler.removeCallbacks(this.eEL);
            this.mHandler.postDelayed(this.eEL, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biq() {
        if (this.eQS != null) {
            final AlertDialog create = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.eQS.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.eQS.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.eQS.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.eQS.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    create.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.eQT != null) {
                        i.this.eQT.c(i.this.eQS);
                    }
                    create.dismiss();
                }
            });
            create.show();
            Window window = create.getWindow();
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
        this.eQT = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d bir() {
        return this.eQS;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.eEL);
    }
}
