package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class d implements View.OnClickListener {
    private View gUf;
    private View gUg;
    private View gUh;
    private PlayDrawableImageView gUi;
    private a gUj;
    private ProgressBar gUk;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void bUP();

        void bUQ();

        void bUR();
    }

    public void a(a aVar) {
        this.gUj = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View h(Context context, ViewGroup viewGroup) {
        if (this.gUf == null) {
            this.gUf = LayoutInflater.from(context).inflate(a.g.ala_live_floating, viewGroup, false);
            this.gUg = this.gUf.findViewById(a.f.live_is_finished_tip);
            this.gUh = this.gUf.findViewById(a.f.retry_tip);
            this.gUk = (ProgressBar) this.gUf.findViewById(a.f.progress_bar);
            this.gUf.setOnClickListener(this);
            this.gUf.findViewById(a.f.retry_view).setOnClickListener(this);
            this.gUi = (PlayDrawableImageView) this.gUf.findViewById(a.f.play_btn);
            this.gUi.setOnClickListener(this);
        }
        nd(false);
        return this.gUf;
    }

    public void bUS() {
        this.gUg.setVisibility(0);
        this.gUh.setVisibility(8);
        ne(false);
    }

    public void nd(boolean z) {
        this.gUi.setVisibility(z ? 0 : 8);
    }

    public void ne(boolean z) {
        this.gUk.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.retry_view) {
            if (this.gUj != null) {
                this.gUj.bUP();
            }
        } else if (view == this.gUf) {
            if (this.gUj != null) {
                this.gUj.bUQ();
            }
        } else if (view == this.gUi && this.gUj != null) {
            this.gUj.bUR();
        }
    }
}
