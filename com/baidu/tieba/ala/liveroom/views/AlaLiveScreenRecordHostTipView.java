package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class AlaLiveScreenRecordHostTipView extends TextView {
    public AlaLiveScreenRecordHostTipView(Context context) {
        super(context);
        init(context);
    }

    public AlaLiveScreenRecordHostTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaLiveScreenRecordHostTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setGravity(17);
        setTextSize(0, context.getResources().getDimensionPixelSize(a.e.sdk_fontsize40));
        setTextColor(context.getResources().getColor(a.d.sdk_cp_cont_g));
        setText(a.i.ala_live_host_screen_record_start);
    }
}
