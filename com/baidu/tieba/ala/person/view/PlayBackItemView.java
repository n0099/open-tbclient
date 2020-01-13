package com.baidu.tieba.ala.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.RatioTbImageView;
/* loaded from: classes2.dex */
public class PlayBackItemView extends RelativeLayout {
    private RatioTbImageView fqT;
    private LinearLayout fqU;
    private TextView fqV;
    private TextView fqW;
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
        this.fqU = (LinearLayout) findViewById(a.g.playback_info_layout);
        this.fqT = (RatioTbImageView) findViewById(a.g.playback_cover);
        this.fqV = (TextView) findViewById(a.g.playback_audience_count);
        this.fqW = (TextView) findViewById(a.g.playback_time);
        this.mTitleView = (TextView) findViewById(a.g.playback_title);
    }

    public void setData(String str, long j, long j2, String str2) {
        this.fqT.startLoad(str, 10, false);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.fqU.setVisibility(8);
        } else {
            this.fqU.setVisibility(0);
            String format = String.format(getContext().getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.db(j));
            String timeInterval = StringHelper.getTimeInterval(j2);
            this.fqV.setText(format);
            this.fqW.setText(timeInterval);
        }
        if (StringUtils.isNull(str2)) {
            this.mTitleView.setText(StringHelper.STRING_MORE);
        } else {
            this.mTitleView.setText(str2);
        }
    }
}
