package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaLiveStreamStatusView extends LinearLayout {
    private boolean gLY;
    private TextView hRn;
    private int hRo;
    private boolean hRp;
    private Runnable hRq;

    public AlaLiveStreamStatusView(Context context) {
        super(context);
        this.hRo = 1;
        this.gLY = true;
        this.hRp = false;
        this.hRq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(8);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hRo = 1;
        this.gLY = true;
        this.hRp = false;
        this.hRq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(8);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hRo = 1;
        this.gLY = true;
        this.hRp = false;
        this.hRq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(8);
            }
        };
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_stream_status_layout, this);
        this.hRn = (TextView) findViewById(a.f.ala_live_stream_status_txt);
    }

    public void ej(int i) {
        String string;
        this.hRp = true;
        setVisibility(0);
        if (i > 40) {
            string = getContext().getResources().getString(a.h.ala_stream_status_bad);
        } else if (i > 20) {
            string = getContext().getResources().getString(a.h.ala_stream_status_good);
        } else {
            string = getContext().getResources().getString(a.h.ala_stream_status_very_good);
        }
        this.hRn.setText(string);
    }

    public int getCurLevel() {
        return this.hRo;
    }

    public boolean clp() {
        return this.hRp;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.gLY) {
            i = 8;
        }
        super.setVisibility(i);
    }

    public void setCanVisible(boolean z) {
        this.gLY = z;
    }
}
