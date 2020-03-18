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
    private RatioTbImageView fuj;
    private LinearLayout fuk;
    private TextView ful;
    private TextView fum;
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
        this.fuk = (LinearLayout) findViewById(a.g.playback_info_layout);
        this.fuj = (RatioTbImageView) findViewById(a.g.playback_cover);
        this.ful = (TextView) findViewById(a.g.playback_audience_count);
        this.fum = (TextView) findViewById(a.g.playback_time);
        this.mTitleView = (TextView) findViewById(a.g.playback_title);
    }

    public void setData(String str, long j, long j2, String str2) {
        this.fuj.startLoad(str, 10, false);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.fuk.setVisibility(8);
        } else {
            this.fuk.setVisibility(0);
            String format = String.format(getContext().getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dd(j));
            String timeInterval = StringHelper.getTimeInterval(j2);
            this.ful.setText(format);
            this.fum.setText(timeInterval);
        }
        if (StringUtils.isNull(str2)) {
            this.mTitleView.setText(StringHelper.STRING_MORE);
        } else {
            this.mTitleView.setText(str2);
        }
    }
}
