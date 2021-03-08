package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class d implements View.OnClickListener {
    private View gWc;
    private View gWd;
    private View gWe;
    private PlayDrawableImageView gWf;
    private a gWg;
    private ProgressBar gWh;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void bVc();

        void bVd();

        void bVe();
    }

    public void a(a aVar) {
        this.gWg = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View h(Context context, ViewGroup viewGroup) {
        if (this.gWc == null) {
            this.gWc = LayoutInflater.from(context).inflate(a.g.ala_live_floating, viewGroup, false);
            this.gWd = this.gWc.findViewById(a.f.live_is_finished_tip);
            this.gWe = this.gWc.findViewById(a.f.retry_tip);
            this.gWh = (ProgressBar) this.gWc.findViewById(a.f.progress_bar);
            this.gWc.setOnClickListener(this);
            this.gWc.findViewById(a.f.retry_view).setOnClickListener(this);
            this.gWf = (PlayDrawableImageView) this.gWc.findViewById(a.f.play_btn);
            this.gWf.setOnClickListener(this);
        }
        nd(false);
        return this.gWc;
    }

    public void bVf() {
        this.gWd.setVisibility(0);
        this.gWe.setVisibility(8);
        ne(false);
    }

    public void nd(boolean z) {
        this.gWf.setVisibility(z ? 0 : 8);
    }

    public void ne(boolean z) {
        this.gWh.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.retry_view) {
            if (this.gWg != null) {
                this.gWg.bVc();
            }
        } else if (view == this.gWc) {
            if (this.gWg != null) {
                this.gWg.bVd();
            }
        } else if (view == this.gWf && this.gWg != null) {
            this.gWg.bVe();
        }
    }
}
