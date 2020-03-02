package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaLiveStreamStatusView extends LinearLayout {
    private boolean eTw;
    private TextView fmU;
    private int fmV;
    private Runnable fmW;

    public AlaLiveStreamStatusView(Context context) {
        super(context);
        this.fmV = 1;
        this.eTw = true;
        this.fmW = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmV = 1;
        this.eTw = true;
        this.fmW = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmV = 1;
        this.eTw = true;
        this.fmW = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_stream_status_layout, this);
        this.fmU = (TextView) findViewById(a.g.ala_live_stream_status_txt);
    }

    public void a(int i, boolean z, int i2, boolean z2) {
        String string;
        this.fmV = i2;
        setVisibility(0);
        if (z && i >= 80) {
            setVisibility(4);
        } else {
            setVisibility(0);
        }
        if (i > 80) {
            SafeHandler.getInst().removeCallbacks(this.fmW);
            SafeHandler.getInst().postDelayed(this.fmW, 5000L);
            string = getContext().getResources().getString(a.i.ala_stream_status_very_good);
        } else if (i > 40) {
            string = getContext().getResources().getString(a.i.ala_stream_status_good);
        } else if (i > 20) {
            string = getContext().getResources().getString(a.i.ala_stream_status_normal);
        } else {
            string = getContext().getResources().getString(a.i.ala_stream_status_bad);
        }
        this.fmU.setText(string);
    }

    public int getCurLevel() {
        return this.fmV;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.eTw) {
            i = 4;
        }
        super.setVisibility(i);
    }

    public void setCanVisible(boolean z) {
        this.eTw = z;
    }
}
