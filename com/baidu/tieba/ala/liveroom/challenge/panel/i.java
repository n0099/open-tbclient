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
    private TextView csn;
    private int eaB;
    private TextView eay;
    private HeadImageView ebN;
    private com.baidu.live.challenge.d ebO;
    private a ebP;
    private Context mContext;
    private View mRootView;
    private Runnable eaC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.4
        @Override // java.lang.Runnable
        public void run() {
            i.e(i.this);
            i.this.eay.setText(i.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(i.this.eaB)));
            if (i.this.eaB > 0) {
                i.this.mHandler.postDelayed(this, 1000L);
            } else if (i.this.ebP != null) {
                i.this.ebP.a(i.this);
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
        int i = iVar.eaB;
        iVar.eaB = i - 1;
        return i;
    }

    public i(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.ebN = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.ebN.setIsRound(true);
        this.ebN.setAutoChangeStyle(false);
        this.csn = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.eay = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.aQO();
            }
        });
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.ebO = dVar;
        this.ebN.startLoad(dVar.avatar, 25, false);
        this.csn.setText(dVar.userName);
        this.eaB = (int) ((dVar.OI + 60) - (System.currentTimeMillis() / 1000));
        if (this.eaB > 0) {
            if (this.eaB > 60) {
                this.eaB = 60;
            }
            this.eay.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.eaB)));
            this.mHandler.removeCallbacks(this.eaC);
            this.mHandler.postDelayed(this.eaC, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQO() {
        if (this.ebO != null) {
            final AlertDialog create = new AlertDialog.Builder(this.mContext).create();
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.ebO.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.ebO.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.ebO.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.ebO.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    create.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.ebP != null) {
                        i.this.ebP.c(i.this.ebO);
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
        this.ebP = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d aQP() {
        return this.ebO;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.eaC);
    }
}
