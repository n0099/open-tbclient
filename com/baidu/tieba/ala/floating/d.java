package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private View gBq;
    private View gBr;
    private View gBs;
    private PlayDrawableImageView gBt;
    private a gBu;
    private ProgressBar gBv;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bRL();

        void bRM();

        void bRN();
    }

    public void a(a aVar) {
        this.gBu = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View e(Context context, ViewGroup viewGroup) {
        if (this.gBq == null) {
            this.gBq = LayoutInflater.from(context).inflate(a.g.ala_live_floating, viewGroup, false);
            this.gBr = this.gBq.findViewById(a.f.live_is_finished_tip);
            this.gBs = this.gBq.findViewById(a.f.retry_tip);
            this.gBv = (ProgressBar) this.gBq.findViewById(a.f.progress_bar);
            this.gBq.setOnClickListener(this);
            this.gBq.findViewById(a.f.retry_view).setOnClickListener(this);
            this.gBt = (PlayDrawableImageView) this.gBq.findViewById(a.f.play_btn);
            this.gBt.setOnClickListener(this);
        }
        mh(false);
        return this.gBq;
    }

    public void bRO() {
        this.gBr.setVisibility(0);
        this.gBs.setVisibility(8);
        mi(false);
    }

    public void mh(boolean z) {
        this.gBt.setVisibility(z ? 0 : 8);
    }

    public void mi(boolean z) {
        this.gBv.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.retry_view) {
            if (this.gBu != null) {
                this.gBu.bRL();
            }
        } else if (view == this.gBq) {
            if (this.gBu != null) {
                this.gBu.bRM();
            }
        } else if (view == this.gBt && this.gBu != null) {
            this.gBu.bRN();
        }
    }
}
