package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class i {
    private TextView crw;
    private TextView dZH;
    private int dZK;
    private HeadImageView eaW;
    private com.baidu.live.challenge.d eaX;
    private a eaY;
    private Context mContext;
    private View mRootView;
    private Runnable dZL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.4
        @Override // java.lang.Runnable
        public void run() {
            i.e(i.this);
            i.this.dZH.setText(i.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(i.this.dZK)));
            if (i.this.dZK > 0) {
                i.this.mHandler.postDelayed(this, 1000L);
            } else if (i.this.eaY != null) {
                i.this.eaY.a(i.this);
            }
        }
    };
    private Handler mHandler = new Handler();

    /* loaded from: classes6.dex */
    public interface a {
        void a(i iVar);

        void c(com.baidu.live.challenge.d dVar);
    }

    static /* synthetic */ int e(i iVar) {
        int i = iVar.dZK;
        iVar.dZK = i - 1;
        return i;
    }

    public i(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.eaW = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.eaW.setIsRound(true);
        this.eaW.setAutoChangeStyle(false);
        this.crw = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.dZH = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.aQM();
            }
        });
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.eaX = dVar;
        this.eaW.startLoad(dVar.avatar, 25, false);
        this.crw.setText(dVar.userName);
        this.dZK = (int) ((dVar.Oi + 60) - (System.currentTimeMillis() / 1000));
        if (this.dZK > 0) {
            if (this.dZK > 60) {
                this.dZK = 60;
            }
            this.dZH.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.dZK)));
            this.mHandler.removeCallbacks(this.dZL);
            this.mHandler.postDelayed(this.dZL, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQM() {
        if (this.eaX != null) {
            final AlertDialog create = new AlertDialog.Builder(this.mContext).create();
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.eaX.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.eaX.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.eaX.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.eaX.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    create.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.eaY != null) {
                        i.this.eaY.c(i.this.eaX);
                    }
                    create.dismiss();
                }
            });
            create.show();
            Window window = create.getWindow();
            window.setLayout(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds600), -2);
            window.setGravity(17);
            window.setContentView(inflate);
        }
    }

    public boolean isVisible() {
        return this.mRootView.getVisibility() == 0;
    }

    public void a(a aVar) {
        this.eaY = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d aQN() {
        return this.eaX;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.dZL);
    }
}
