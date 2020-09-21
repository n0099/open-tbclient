package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private View fZA;
    private PlayDrawableImageView fZB;
    private a fZC;
    private ProgressBar fZD;
    private View fZy;
    private View fZz;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bKD();

        void bKE();

        void bKF();
    }

    public void a(a aVar) {
        this.fZC = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View e(Context context, ViewGroup viewGroup) {
        if (this.fZy == null) {
            this.fZy = LayoutInflater.from(context).inflate(a.h.ala_live_floating, viewGroup, false);
            this.fZz = this.fZy.findViewById(a.g.live_is_finished_tip);
            this.fZA = this.fZy.findViewById(a.g.retry_tip);
            this.fZD = (ProgressBar) this.fZy.findViewById(a.g.progress_bar);
            this.fZy.setOnClickListener(this);
            this.fZy.findViewById(a.g.retry_view).setOnClickListener(this);
            this.fZB = (PlayDrawableImageView) this.fZy.findViewById(a.g.play_btn);
            this.fZB.setOnClickListener(this);
        }
        lj(false);
        return this.fZy;
    }

    public void bKG() {
        this.fZz.setVisibility(0);
        this.fZA.setVisibility(8);
        lk(false);
    }

    public void lj(boolean z) {
        this.fZB.setVisibility(z ? 0 : 8);
    }

    public void lk(boolean z) {
        this.fZD.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.retry_view) {
            if (this.fZC != null) {
                this.fZC.bKD();
            }
        } else if (view == this.fZy) {
            if (this.fZC != null) {
                this.fZC.bKE();
            }
        } else if (view == this.fZB && this.fZC != null) {
            this.fZC.bKF();
        }
    }
}
