package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private View glQ;
    private View glR;
    private View glS;
    private PlayDrawableImageView glT;
    private a glU;
    private ProgressBar glV;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void bNn();

        void bNo();

        void bNp();
    }

    public void a(a aVar) {
        this.glU = aVar;
    }

    public d(Context context) {
        this.mContext = context;
    }

    public View e(Context context, ViewGroup viewGroup) {
        if (this.glQ == null) {
            this.glQ = LayoutInflater.from(context).inflate(a.h.ala_live_floating, viewGroup, false);
            this.glR = this.glQ.findViewById(a.g.live_is_finished_tip);
            this.glS = this.glQ.findViewById(a.g.retry_tip);
            this.glV = (ProgressBar) this.glQ.findViewById(a.g.progress_bar);
            this.glQ.setOnClickListener(this);
            this.glQ.findViewById(a.g.retry_view).setOnClickListener(this);
            this.glT = (PlayDrawableImageView) this.glQ.findViewById(a.g.play_btn);
            this.glT.setOnClickListener(this);
        }
        lH(false);
        return this.glQ;
    }

    public void bNq() {
        this.glR.setVisibility(0);
        this.glS.setVisibility(8);
        lI(false);
    }

    public void lH(boolean z) {
        this.glT.setVisibility(z ? 0 : 8);
    }

    public void lI(boolean z) {
        this.glV.setVisibility(z ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.retry_view) {
            if (this.glU != null) {
                this.glU.bNn();
            }
        } else if (view == this.glQ) {
            if (this.glU != null) {
                this.glU.bNo();
            }
        } else if (view == this.glT && this.glU != null) {
            this.glU.bNp();
        }
    }
}
