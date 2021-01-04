package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaLiveStreamStatusView extends LinearLayout {
    private boolean gNK;
    private TextView hRl;
    private int hRm;
    private boolean hRn;
    private Runnable hRo;

    public AlaLiveStreamStatusView(Context context) {
        super(context);
        this.hRm = 1;
        this.gNK = true;
        this.hRn = false;
        this.hRo = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hRm = 1;
        this.gNK = true;
        this.hRn = false;
        this.hRo = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hRm = 1;
        this.gNK = true;
        this.hRn = false;
        this.hRo = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_stream_status_layout, this);
        this.hRl = (TextView) findViewById(a.f.ala_live_stream_status_txt);
    }

    public void fL(int i) {
        String string;
        this.hRn = true;
        setVisibility(0);
        if (i > 40) {
            string = getContext().getResources().getString(a.h.ala_stream_status_bad);
        } else if (i > 20) {
            string = getContext().getResources().getString(a.h.ala_stream_status_good);
        } else {
            string = getContext().getResources().getString(a.h.ala_stream_status_very_good);
        }
        this.hRl.setText(string);
    }

    public int getCurLevel() {
        return this.hRm;
    }

    public boolean cob() {
        return this.hRn;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.gNK) {
            i = 4;
        }
        super.setVisibility(i);
    }

    public void setCanVisible(boolean z) {
        this.gNK = z;
    }
}
