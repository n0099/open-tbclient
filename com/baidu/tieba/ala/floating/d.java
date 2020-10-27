package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private View gvV;
    private View gvW;
    private View gvX;
    private PlayDrawableImageView gvY;
    private a gvZ;
    private ProgressBar gwa;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bPS();

        void bPT();

        void bPU();
    }

    public void a(a aVar) {
        this.gvZ = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View e(Context context, ViewGroup viewGroup) {
        if (this.gvV == null) {
            this.gvV = LayoutInflater.from(context).inflate(a.h.ala_live_floating, viewGroup, false);
            this.gvW = this.gvV.findViewById(a.g.live_is_finished_tip);
            this.gvX = this.gvV.findViewById(a.g.retry_tip);
            this.gwa = (ProgressBar) this.gvV.findViewById(a.g.progress_bar);
            this.gvV.setOnClickListener(this);
            this.gvV.findViewById(a.g.retry_view).setOnClickListener(this);
            this.gvY = (PlayDrawableImageView) this.gvV.findViewById(a.g.play_btn);
            this.gvY.setOnClickListener(this);
        }
        lX(false);
        return this.gvV;
    }

    public void bPV() {
        this.gvW.setVisibility(0);
        this.gvX.setVisibility(8);
        lY(false);
    }

    public void lX(boolean z) {
        this.gvY.setVisibility(z ? 0 : 8);
    }

    public void lY(boolean z) {
        this.gwa.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.retry_view) {
            if (this.gvZ != null) {
                this.gvZ.bPS();
            }
        } else if (view == this.gvV) {
            if (this.gvZ != null) {
                this.gvZ.bPT();
            }
        } else if (view == this.gvY && this.gvZ != null) {
            this.gvZ.bPU();
        }
    }
}
