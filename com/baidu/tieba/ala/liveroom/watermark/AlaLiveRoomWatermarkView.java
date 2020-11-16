package com.baidu.tieba.ala.liveroom.watermark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class AlaLiveRoomWatermarkView extends LinearLayout {
    private TextView hwS;
    private TextView hwT;

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
        this.hwS = (TextView) findViewById(a.f.ala_liveroom_watermark_uname);
        this.hwT = (TextView) findViewById(a.f.ala_liveroom_watermark_starttime);
    }

    public void setValues(String str, long j) {
        if (str == null) {
            str = "";
        }
        this.hwS.setText(str);
        if (j == 0) {
            this.hwT.setText("");
            return;
        }
        this.hwT.setText(new SimpleDateFormat("yyyy.MM.dd").format(new Date(1000 * j)));
    }

    public void setTimeTextMode(boolean z) {
        if (z) {
            this.hwT.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha25));
        } else {
            this.hwT.setTextColor(getContext().getResources().getColor(a.c.sdk_black_alpha25));
        }
    }
}
