package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class i {
    private TextView bXF;
    private TextView eRd;
    private int eRg;
    private HeadImageView eSu;
    private com.baidu.live.challenge.d eSv;
    private a eSw;
    private Context mContext;
    private View mRootView;
    private Runnable eFV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.4
        @Override // java.lang.Runnable
        public void run() {
            i.e(i.this);
            i.this.eRd.setText(i.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(i.this.eRg)));
            if (i.this.eRg > 0) {
                i.this.mHandler.postDelayed(this, 1000L);
            } else if (i.this.eSw != null) {
                i.this.eSw.a(i.this);
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
        int i = iVar.eRg;
        iVar.eRg = i - 1;
        return i;
    }

    public i(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.eSu = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.eSu.setIsRound(true);
        this.eSu.setAutoChangeStyle(false);
        this.bXF = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.eRd = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.bjf();
            }
        });
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.eSv = dVar;
        this.eSu.startLoad(dVar.avatar, 25, false);
        this.bXF.setText(dVar.userName);
        this.eRg = (int) ((dVar.Vw + 60) - (System.currentTimeMillis() / 1000));
        if (this.eRg > 0) {
            if (this.eRg > 60) {
                this.eRg = 60;
            }
            this.eRd.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.eRg)));
            this.mHandler.removeCallbacks(this.eFV);
            this.mHandler.postDelayed(this.eFV, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjf() {
        if (this.eSv != null) {
            final AlertDialog create = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.eSv.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.eSv.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.eSv.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.eSv.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    create.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.eSw != null) {
                        i.this.eSw.c(i.this.eSv);
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
        this.eSw = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d bjg() {
        return this.eSv;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.eFV);
    }
}
