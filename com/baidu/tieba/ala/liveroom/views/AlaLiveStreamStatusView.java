package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class AlaLiveStreamStatusView extends LinearLayout {
    private boolean gNH;
    private TextView hSW;
    private int hSX;
    private boolean hSY;
    private Runnable hSZ;

    public AlaLiveStreamStatusView(Context context) {
        super(context);
        this.hSX = 1;
        this.gNH = true;
        this.hSY = false;
        this.hSZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(8);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSX = 1;
        this.gNH = true;
        this.hSY = false;
        this.hSZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(8);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSX = 1;
        this.gNH = true;
        this.hSY = false;
        this.hSZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(8);
            }
        };
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_stream_status_layout, this);
        this.hSW = (TextView) findViewById(a.f.ala_live_stream_status_txt);
    }

    public void ek(int i) {
        String string;
        this.hSY = true;
        setVisibility(0);
        if (i > 40) {
            string = getContext().getResources().getString(a.h.ala_stream_status_bad);
        } else if (i > 20) {
            string = getContext().getResources().getString(a.h.ala_stream_status_good);
        } else {
            string = getContext().getResources().getString(a.h.ala_stream_status_very_good);
        }
        this.hSW.setText(string);
    }

    public int getCurLevel() {
        return this.hSX;
    }

    public boolean clv() {
        return this.hSY;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.gNH) {
            i = 8;
        }
        super.setVisibility(i);
    }

    public void setCanVisible(boolean z) {
        this.gNH = z;
    }
}
