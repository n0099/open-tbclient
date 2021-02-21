package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class d implements View.OnClickListener {
    private View gUt;
    private View gUu;
    private View gUv;
    private PlayDrawableImageView gUw;
    private a gUx;
    private ProgressBar gUy;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void bUW();

        void bUX();

        void bUY();
    }

    public void a(a aVar) {
        this.gUx = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View h(Context context, ViewGroup viewGroup) {
        if (this.gUt == null) {
            this.gUt = LayoutInflater.from(context).inflate(a.g.ala_live_floating, viewGroup, false);
            this.gUu = this.gUt.findViewById(a.f.live_is_finished_tip);
            this.gUv = this.gUt.findViewById(a.f.retry_tip);
            this.gUy = (ProgressBar) this.gUt.findViewById(a.f.progress_bar);
            this.gUt.setOnClickListener(this);
            this.gUt.findViewById(a.f.retry_view).setOnClickListener(this);
            this.gUw = (PlayDrawableImageView) this.gUt.findViewById(a.f.play_btn);
            this.gUw.setOnClickListener(this);
        }
        nd(false);
        return this.gUt;
    }

    public void bUZ() {
        this.gUu.setVisibility(0);
        this.gUv.setVisibility(8);
        ne(false);
    }

    public void nd(boolean z) {
        this.gUw.setVisibility(z ? 0 : 8);
    }

    public void ne(boolean z) {
        this.gUy.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.retry_view) {
            if (this.gUx != null) {
                this.gUx.bUW();
            }
        } else if (view == this.gUt) {
            if (this.gUx != null) {
                this.gUx.bUX();
            }
        } else if (view == this.gUw && this.gUx != null) {
            this.gUx.bUY();
        }
    }
}
