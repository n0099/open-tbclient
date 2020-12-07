package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class AlaLiveStreamStatusView extends LinearLayout {
    private boolean gBW;
    private TextView hFj;
    private int hFk;
    private boolean hFl;
    private Runnable hFm;

    public AlaLiveStreamStatusView(Context context) {
        super(context);
        this.hFk = 1;
        this.gBW = true;
        this.hFl = false;
        this.hFm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFk = 1;
        this.gBW = true;
        this.hFl = false;
        this.hFm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    public AlaLiveStreamStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hFk = 1;
        this.gBW = true;
        this.hFl = false;
        this.hFm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView.1
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveStreamStatusView.this.setVisibility(4);
            }
        };
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.g.ala_live_stream_status_layout, this);
        this.hFj = (TextView) findViewById(a.f.ala_live_stream_status_txt);
    }

    public void fK(int i) {
        String string;
        this.hFl = true;
        setVisibility(0);
        if (i > 40) {
            string = getContext().getResources().getString(a.h.ala_stream_status_bad);
        } else if (i > 20) {
            string = getContext().getResources().getString(a.h.ala_stream_status_good);
        } else {
            string = getContext().getResources().getString(a.h.ala_stream_status_very_good);
        }
        this.hFj.setText(string);
    }

    public int getCurLevel() {
        return this.hFk;
    }

    public boolean clj() {
        return this.hFl;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.gBW) {
            i = 4;
        }
        super.setVisibility(i);
    }

    public void setCanVisible(boolean z) {
        this.gBW = z;
    }
}
