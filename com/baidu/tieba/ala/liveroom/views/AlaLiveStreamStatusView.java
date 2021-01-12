package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaLiveStreamStatusView extends LinearLayout {
    private boolean gJe;
    private TextView hMF;
    private int hMG;
    private boolean hMH;
    private Runnable hMI;

    public AlaLiveStreamStatusView(Context context) {
        super(context);
        this.hMG = 1;
        this.gJe = true;
        this.hMH = false;
        this.hMI = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hMG = 1;
        this.gJe = true;
        this.hMH = false;
        this.hMI = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hMG = 1;
        this.gJe = true;
        this.hMH = false;
        this.hMI = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_stream_status_layout, this);
        this.hMF = (TextView) findViewById(a.f.ala_live_stream_status_txt);
    }

    public void ef(int i) {
        String string;
        this.hMH = true;
        setVisibility(0);
        if (i > 40) {
            string = getContext().getResources().getString(a.h.ala_stream_status_bad);
        } else if (i > 20) {
            string = getContext().getResources().getString(a.h.ala_stream_status_good);
        } else {
            string = getContext().getResources().getString(a.h.ala_stream_status_very_good);
        }
        this.hMF.setText(string);
    }

    public int getCurLevel() {
        return this.hMG;
    }

    public boolean ckk() {
        return this.hMH;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.gJe) {
            i = 4;
        }
        super.setVisibility(i);
    }

    public void setCanVisible(boolean z) {
        this.gJe = z;
    }
}
