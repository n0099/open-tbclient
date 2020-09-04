package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class d implements View.OnClickListener {
    private View fWl;
    private View fWm;
    private View fWn;
    private PlayDrawableImageView fWo;
    private a fWp;
    private ProgressBar fWq;
    private Context mContext;

    /* loaded from: classes7.dex */
    public interface a {
        void bJt();

        void bJu();

        void bJv();
    }

    public void a(a aVar) {
        this.fWp = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View e(Context context, ViewGroup viewGroup) {
        if (this.fWl == null) {
            this.fWl = LayoutInflater.from(context).inflate(a.h.ala_live_floating, viewGroup, false);
            this.fWm = this.fWl.findViewById(a.g.live_is_finished_tip);
            this.fWn = this.fWl.findViewById(a.g.retry_tip);
            this.fWq = (ProgressBar) this.fWl.findViewById(a.g.progress_bar);
            this.fWl.setOnClickListener(this);
            this.fWl.findViewById(a.g.retry_view).setOnClickListener(this);
            this.fWo = (PlayDrawableImageView) this.fWl.findViewById(a.g.play_btn);
            this.fWo.setOnClickListener(this);
        }
        return this.fWl;
    }

    public void bJw() {
        this.fWm.setVisibility(0);
        this.fWn.setVisibility(8);
        li(false);
    }

    public void lh(boolean z) {
        this.fWo.setVisibility(z ? 0 : 8);
    }

    public void li(boolean z) {
        this.fWq.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.retry_view) {
            if (this.fWp != null) {
                this.fWp.bJt();
            }
        } else if (view == this.fWl) {
            if (this.fWp != null) {
                this.fWp.bJu();
            }
        } else if (view == this.fWo && this.fWp != null) {
            this.fWp.bJv();
        }
    }
}
