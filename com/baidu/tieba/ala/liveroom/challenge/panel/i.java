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
    private TextView cbK;
    private TextView eUV;
    private int eUY;
    private HeadImageView eWm;
    private com.baidu.live.challenge.d eWn;
    private a eWo;
    private Context mContext;
    private View mRootView;
    private Runnable eJQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.4
        @Override // java.lang.Runnable
        public void run() {
            i.e(i.this);
            i.this.eUV.setText(i.this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(i.this.eUY)));
            if (i.this.eUY > 0) {
                i.this.mHandler.postDelayed(this, 1000L);
            } else if (i.this.eWo != null) {
                i.this.eWo.a(i.this);
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
        int i = iVar.eUY;
        iVar.eUY = i - 1;
        return i;
    }

    public i(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenger_item_layout, (ViewGroup) null);
        this.eWm = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenger_user_header);
        this.eWm.setIsRound(true);
        this.eWm.setAutoChangeStyle(false);
        this.cbK = (TextView) this.mRootView.findViewById(a.g.ala_challenger_user_name);
        this.eUV = (TextView) this.mRootView.findViewById(a.g.ala_challenger_wait_time);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.bkW();
            }
        });
    }

    public void h(com.baidu.live.challenge.d dVar) {
        if (dVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        this.eWn = dVar;
        this.eWm.startLoad(dVar.avatar, 25, false);
        this.cbK.setText(dVar.userName);
        this.eUY = (int) ((dVar.Xc + 60) - (System.currentTimeMillis() / 1000));
        if (this.eUY > 0) {
            if (this.eUY > 60) {
                this.eUY = 60;
            }
            this.eUV.setText(this.mContext.getString(a.i.ala_challenge_panel_countdown, Integer.valueOf(this.eUY)));
            this.mHandler.removeCallbacks(this.eJQ);
            this.mHandler.postDelayed(this.eJQ, 1000L);
            return;
        }
        this.mRootView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkW() {
        if (this.eWn != null) {
            final AlertDialog create = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
            View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_dialog_layout, (ViewGroup) null);
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(a.g.ala_challenger_accept_header);
            headImageView.setIsRound(true);
            headImageView.startLoad(this.eWn.avatar, 25, false);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_name)).setText(this.eWn.userName);
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_ala_id)).setText(this.mContext.getString(a.i.sdk_host_id, String.valueOf(this.eWn.alaId)));
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept_tip)).setText(this.mContext.getString(a.i.ala_challenge_panel_accept_tip, this.eWn.userName));
            ((TextView) inflate.findViewById(a.g.ala_challenge_deny)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    create.dismiss();
                }
            });
            ((TextView) inflate.findViewById(a.g.ala_challenge_accept)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.eWo != null) {
                        i.this.eWo.c(i.this.eWn);
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
        this.eWo = aVar;
    }

    public View getView() {
        return this.mRootView;
    }

    public com.baidu.live.challenge.d bkX() {
        return this.eWn;
    }

    public void onDestory() {
        this.mHandler.removeCallbacks(this.eJQ);
    }
}
