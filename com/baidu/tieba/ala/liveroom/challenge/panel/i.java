package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.app.AlertDialog;
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
    private TextView cbJ;
    private TextView eUU;
    private int eUX;
    private HeadImageView eWl;
    private com.baidu.live.challenge.d eWm;
    private a eWn;
    private Context mContext;
    private View mRootView;
    private Runnable eJP = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.4
        @Override // java.lang.Runnable
        public void run() {
            i.e(i.this);
            i.this.eUU.setText(i.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(i.this.eUX)));
            if (i.this.eUX > 0) {
                i.this.mHandler.postDelayed(this, 1000L);
            } else if (i.this.eWn != null) {
                i.this.eWn.a(i.this);
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
        int i = iVar.eUX;
        iVar.eUX = i - 1;
        return i;
    }

    public i(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.eWl = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.eWl.setIsRound(true);
        this.eWl.setAutoChangeStyle(false);
        this.cbJ = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.eUU = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.bkU();
            }
        });
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.eWm = dVar;
        this.eWl.startLoad(dVar.avatar, 25, false);
        this.cbJ.setText(dVar.userName);
        this.eUX = (int) ((dVar.Xc + 60) - (System.currentTimeMillis() / 1000));
        if (this.eUX > 0) {
            if (this.eUX > 60) {
                this.eUX = 60;
            }
            this.eUU.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.eUX)));
            this.mHandler.removeCallbacks(this.eJP);
            this.mHandler.postDelayed(this.eJP, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkU() {
        if (this.eWm != null) {
            final AlertDialog create = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.eWm.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.eWm.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.eWm.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.eWm.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    create.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.eWn != null) {
                        i.this.eWn.c(i.this.eWm);
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
        this.eWn = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d bkV() {
        return this.eWm;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.eJP);
    }
}
