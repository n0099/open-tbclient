package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private View gKn;
    private View gKo;
    private View gKp;
    private PlayDrawableImageView gKq;
    private a gKr;
    private ProgressBar gKs;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bVv();

        void bVw();

        void bVx();
    }

    public void a(a aVar) {
        this.gKr = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View e(Context context, ViewGroup viewGroup) {
        if (this.gKn == null) {
            this.gKn = LayoutInflater.from(context).inflate(a.g.ala_live_floating, viewGroup, false);
            this.gKo = this.gKn.findViewById(a.f.live_is_finished_tip);
            this.gKp = this.gKn.findViewById(a.f.retry_tip);
            this.gKs = (ProgressBar) this.gKn.findViewById(a.f.progress_bar);
            this.gKn.setOnClickListener(this);
            this.gKn.findViewById(a.f.retry_view).setOnClickListener(this);
            this.gKq = (PlayDrawableImageView) this.gKn.findViewById(a.f.play_btn);
            this.gKq.setOnClickListener(this);
        }
        mC(false);
        return this.gKn;
    }

    public void bVy() {
        this.gKo.setVisibility(0);
        this.gKp.setVisibility(8);
        mD(false);
    }

    public void mC(boolean z) {
        this.gKq.setVisibility(z ? 0 : 8);
    }

    public void mD(boolean z) {
        this.gKs.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.retry_view) {
            if (this.gKr != null) {
                this.gKr.bVv();
            }
        } else if (view == this.gKn) {
            if (this.gKr != null) {
                this.gKr.bVw();
            }
        } else if (view == this.gKq && this.gKr != null) {
            this.gKr.bVx();
        }
    }
}
