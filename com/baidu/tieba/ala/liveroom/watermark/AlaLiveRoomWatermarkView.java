package com.baidu.tieba.ala.liveroom.watermark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes11.dex */
public class AlaLiveRoomWatermarkView extends LinearLayout {
    private TextView hSA;
    private TextView hSz;

    public AlaLiveRoomWatermarkView(Context context) {
        super(context);
        initView();
    }

    public AlaLiveRoomWatermarkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public AlaLiveRoomWatermarkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_liveroom_watermark_layout, this);
        this.hSz = (TextView) findViewById(a.f.ala_liveroom_watermark_uname);
        this.hSA = (TextView) findViewById(a.f.ala_liveroom_watermark_starttime);
    }

    public void setValues(String str, long j) {
        if (str == null) {
            str = "";
        }
        this.hSz.setText(str);
        if (j == 0) {
            this.hSA.setText("");
            return;
        }
        this.hSA.setText(new SimpleDateFormat("yyyy.MM.dd").format(new Date(1000 * j)));
    }

    public void setTimeTextMode(boolean z) {
        if (z) {
            this.hSA.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha25));
        } else {
            this.hSA.setTextColor(getContext().getResources().getColor(a.c.sdk_black_alpha25));
        }
    }
}
