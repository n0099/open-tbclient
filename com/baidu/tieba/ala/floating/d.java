package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class d implements View.OnClickListener {
    private View fWh;
    private View fWi;
    private View fWj;
    private PlayDrawableImageView fWk;
    private a fWl;
    private ProgressBar fWm;
    private Context mContext;

    /* loaded from: classes7.dex */
    public interface a {
        void bJs();

        void bJt();

        void bJu();
    }

    public void a(a aVar) {
        this.fWl = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View e(Context context, ViewGroup viewGroup) {
        if (this.fWh == null) {
            this.fWh = LayoutInflater.from(context).inflate(a.h.ala_live_floating, viewGroup, false);
            this.fWi = this.fWh.findViewById(a.g.live_is_finished_tip);
            this.fWj = this.fWh.findViewById(a.g.retry_tip);
            this.fWm = (ProgressBar) this.fWh.findViewById(a.g.progress_bar);
            this.fWh.setOnClickListener(this);
            this.fWh.findViewById(a.g.retry_view).setOnClickListener(this);
            this.fWk = (PlayDrawableImageView) this.fWh.findViewById(a.g.play_btn);
            this.fWk.setOnClickListener(this);
        }
        return this.fWh;
    }

    public void bJv() {
        this.fWi.setVisibility(0);
        this.fWj.setVisibility(8);
        lg(false);
    }

    public void lf(boolean z) {
        this.fWk.setVisibility(z ? 0 : 8);
    }

    public void lg(boolean z) {
        this.fWm.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.retry_view) {
            if (this.fWl != null) {
                this.fWl.bJs();
            }
        } else if (view == this.fWh) {
            if (this.fWl != null) {
                this.fWl.bJt();
            }
        } else if (view == this.fWk && this.fWl != null) {
            this.fWl.bJu();
        }
    }
}
