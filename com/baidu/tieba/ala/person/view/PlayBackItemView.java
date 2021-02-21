package com.baidu.tieba.ala.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.RatioTbImageView;
/* loaded from: classes11.dex */
public class PlayBackItemView extends RelativeLayout {
    private RatioTbImageView hYW;
    private LinearLayout hYX;
    private TextView hYY;
    private TextView hYZ;
    private TextView mTitleView;

    public PlayBackItemView(Context context) {
        super(context);
        init();
    }

    public PlayBackItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PlayBackItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_person_palyback_item, this);
        this.hYX = (LinearLayout) findViewById(a.f.playback_info_layout);
        this.hYW = (RatioTbImageView) findViewById(a.f.playback_cover);
        this.hYY = (TextView) findViewById(a.f.playback_audience_count);
        this.hYZ = (TextView) findViewById(a.f.playback_time);
        this.mTitleView = (TextView) findViewById(a.f.playback_title);
    }

    public void setData(String str, long j, long j2, String str2) {
        this.hYW.startLoad(str, 10, false);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.hYX.setVisibility(8);
        } else {
            this.hYX.setVisibility(0);
            String format = String.format(getContext().getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bg(j));
            String timeInterval = StringHelper.getTimeInterval(j2);
            this.hYY.setText(format);
            this.hYZ.setText(timeInterval);
        }
        if (StringUtils.isNull(str2)) {
            this.mTitleView.setText(StringHelper.STRING_MORE);
        } else {
            this.mTitleView.setText(str2);
        }
    }
}
