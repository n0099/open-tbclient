package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class d implements View.OnClickListener {
    private View gWb;
    private View gWc;
    private View gWd;
    private PlayDrawableImageView gWe;
    private a gWf;
    private ProgressBar gWg;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void bYb();

        void bYc();

        void bYd();
    }

    public void a(a aVar) {
        this.gWf = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View h(Context context, ViewGroup viewGroup) {
        if (this.gWb == null) {
            this.gWb = LayoutInflater.from(context).inflate(a.g.ala_live_floating, viewGroup, false);
            this.gWc = this.gWb.findViewById(a.f.live_is_finished_tip);
            this.gWd = this.gWb.findViewById(a.f.retry_tip);
            this.gWg = (ProgressBar) this.gWb.findViewById(a.f.progress_bar);
            this.gWb.setOnClickListener(this);
            this.gWb.findViewById(a.f.retry_view).setOnClickListener(this);
            this.gWe = (PlayDrawableImageView) this.gWb.findViewById(a.f.play_btn);
            this.gWe.setOnClickListener(this);
        }
        nc(false);
        return this.gWb;
    }

    public void bYe() {
        this.gWc.setVisibility(0);
        this.gWd.setVisibility(8);
        nd(false);
    }

    public void nc(boolean z) {
        this.gWe.setVisibility(z ? 0 : 8);
    }

    public void nd(boolean z) {
        this.gWg.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.retry_view) {
            if (this.gWf != null) {
                this.gWf.bYb();
            }
        } else if (view == this.gWb) {
            if (this.gWf != null) {
                this.gWf.bYc();
            }
        } else if (view == this.gWe && this.gWf != null) {
            this.gWf.bYd();
        }
    }
}
