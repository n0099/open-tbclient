package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class d implements View.OnClickListener {
    private ProgressBar gRA;
    private View gRv;
    private View gRw;
    private View gRx;
    private PlayDrawableImageView gRy;
    private a gRz;
    private Context mContext;

    /* loaded from: classes10.dex */
    public interface a {
        void bUk();

        void bUl();

        void bUm();
    }

    public void a(a aVar) {
        this.gRz = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View h(Context context, ViewGroup viewGroup) {
        if (this.gRv == null) {
            this.gRv = LayoutInflater.from(context).inflate(a.g.ala_live_floating, viewGroup, false);
            this.gRw = this.gRv.findViewById(a.f.live_is_finished_tip);
            this.gRx = this.gRv.findViewById(a.f.retry_tip);
            this.gRA = (ProgressBar) this.gRv.findViewById(a.f.progress_bar);
            this.gRv.setOnClickListener(this);
            this.gRv.findViewById(a.f.retry_view).setOnClickListener(this);
            this.gRy = (PlayDrawableImageView) this.gRv.findViewById(a.f.play_btn);
            this.gRy.setOnClickListener(this);
        }
        mY(false);
        return this.gRv;
    }

    public void bUn() {
        this.gRw.setVisibility(0);
        this.gRx.setVisibility(8);
        mZ(false);
    }

    public void mY(boolean z) {
        this.gRy.setVisibility(z ? 0 : 8);
    }

    public void mZ(boolean z) {
        this.gRA.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.retry_view) {
            if (this.gRz != null) {
                this.gRz.bUk();
            }
        } else if (view == this.gRv) {
            if (this.gRz != null) {
                this.gRz.bUl();
            }
        } else if (view == this.gRy && this.gRz != null) {
            this.gRz.bUm();
        }
    }
}
