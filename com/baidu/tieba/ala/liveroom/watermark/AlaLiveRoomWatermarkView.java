package com.baidu.tieba.ala.liveroom.watermark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class AlaLiveRoomWatermarkView extends LinearLayout {
    private TextView fTj;
    private TextView fTk;

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
        LayoutInflater.from(getContext()).inflate(a.h.ala_liveroom_watermark_layout, this);
        this.fTj = (TextView) findViewById(a.g.ala_liveroom_watermark_uname);
        this.fTk = (TextView) findViewById(a.g.ala_liveroom_watermark_starttime);
    }

    public void setValues(String str, long j) {
        if (str == null) {
            str = "";
        }
        this.fTj.setText(str);
        if (j == 0) {
            this.fTk.setText("");
            return;
        }
        this.fTk.setText(new SimpleDateFormat("yyyy.MM.dd").format(new Date(1000 * j)));
    }

    public void setTimeTextMode(boolean z) {
        if (z) {
            this.fTk.setTextColor(getContext().getResources().getColor(a.d.sdk_white_alpha25));
        } else {
            this.fTk.setTextColor(getContext().getResources().getColor(a.d.sdk_black_alpha25));
        }
    }
}
