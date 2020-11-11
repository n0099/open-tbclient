package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private View gBJ;
    private View gBK;
    private View gBL;
    private PlayDrawableImageView gBM;
    private a gBN;
    private ProgressBar gBO;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bSs();

        void bSt();

        void bSu();
    }

    public void a(a aVar) {
        this.gBN = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View e(Context context, ViewGroup viewGroup) {
        if (this.gBJ == null) {
            this.gBJ = LayoutInflater.from(context).inflate(a.g.ala_live_floating, viewGroup, false);
            this.gBK = this.gBJ.findViewById(a.f.live_is_finished_tip);
            this.gBL = this.gBJ.findViewById(a.f.retry_tip);
            this.gBO = (ProgressBar) this.gBJ.findViewById(a.f.progress_bar);
            this.gBJ.setOnClickListener(this);
            this.gBJ.findViewById(a.f.retry_view).setOnClickListener(this);
            this.gBM = (PlayDrawableImageView) this.gBJ.findViewById(a.f.play_btn);
            this.gBM.setOnClickListener(this);
        }
        mg(false);
        return this.gBJ;
    }

    public void bSv() {
        this.gBK.setVisibility(0);
        this.gBL.setVisibility(8);
        mh(false);
    }

    public void mg(boolean z) {
        this.gBM.setVisibility(z ? 0 : 8);
    }

    public void mh(boolean z) {
        this.gBO.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.retry_view) {
            if (this.gBN != null) {
                this.gBN.bSs();
            }
        } else if (view == this.gBJ) {
            if (this.gBN != null) {
                this.gBN.bSt();
            }
        } else if (view == this.gBM && this.gBN != null) {
            this.gBN.bSu();
        }
    }
}
