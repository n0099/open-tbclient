package com.baidu.tieba.ala.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.RatioTbImageView;
/* loaded from: classes3.dex */
public class PlayBackItemView extends RelativeLayout {
    private RatioTbImageView ftw;
    private LinearLayout ftx;
    private TextView fty;
    private TextView ftz;
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
        LayoutInflater.from(getContext()).inflate(a.h.ala_person_palyback_item, this);
        this.ftx = (LinearLayout) findViewById(a.g.playback_info_layout);
        this.ftw = (RatioTbImageView) findViewById(a.g.playback_cover);
        this.fty = (TextView) findViewById(a.g.playback_audience_count);
        this.ftz = (TextView) findViewById(a.g.playback_time);
        this.mTitleView = (TextView) findViewById(a.g.playback_title);
    }

    public void setData(String str, long j, long j2, String str2) {
        this.ftw.startLoad(str, 10, false);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.ftx.setVisibility(8);
        } else {
            this.ftx.setVisibility(0);
            String format = String.format(getContext().getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dd(j));
            String timeInterval = StringHelper.getTimeInterval(j2);
            this.fty.setText(format);
            this.ftz.setText(timeInterval);
        }
        if (StringUtils.isNull(str2)) {
            this.mTitleView.setText(StringHelper.STRING_MORE);
        } else {
            this.mTitleView.setText(str2);
        }
    }
}
