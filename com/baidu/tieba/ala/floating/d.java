package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private View gKp;
    private View gKq;
    private View gKr;
    private PlayDrawableImageView gKs;
    private a gKt;
    private ProgressBar gKu;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bVw();

        void bVx();

        void bVy();
    }

    public void a(a aVar) {
        this.gKt = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View e(Context context, ViewGroup viewGroup) {
        if (this.gKp == null) {
            this.gKp = LayoutInflater.from(context).inflate(a.g.ala_live_floating, viewGroup, false);
            this.gKq = this.gKp.findViewById(a.f.live_is_finished_tip);
            this.gKr = this.gKp.findViewById(a.f.retry_tip);
            this.gKu = (ProgressBar) this.gKp.findViewById(a.f.progress_bar);
            this.gKp.setOnClickListener(this);
            this.gKp.findViewById(a.f.retry_view).setOnClickListener(this);
            this.gKs = (PlayDrawableImageView) this.gKp.findViewById(a.f.play_btn);
            this.gKs.setOnClickListener(this);
        }
        mC(false);
        return this.gKp;
    }

    public void bVz() {
        this.gKq.setVisibility(0);
        this.gKr.setVisibility(8);
        mD(false);
    }

    public void mC(boolean z) {
        this.gKs.setVisibility(z ? 0 : 8);
    }

    public void mD(boolean z) {
        this.gKu.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.retry_view) {
            if (this.gKt != null) {
                this.gKt.bVw();
            }
        } else if (view == this.gKp) {
            if (this.gKt != null) {
                this.gKt.bVx();
            }
        } else if (view == this.gKs && this.gKt != null) {
            this.gKt.bVy();
        }
    }
}
