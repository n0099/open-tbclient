package com.baidu.tieba.ala.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.RatioTbImageView;
/* loaded from: classes6.dex */
public class PlayBackItemView extends RelativeLayout {
    private RatioTbImageView ewk;
    private LinearLayout ewl;
    private TextView ewm;
    private TextView ewn;
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
        this.ewl = (LinearLayout) findViewById(a.g.playback_info_layout);
        this.ewk = (RatioTbImageView) findViewById(a.g.playback_cover);
        this.ewm = (TextView) findViewById(a.g.playback_audience_count);
        this.ewn = (TextView) findViewById(a.g.playback_time);
        this.mTitleView = (TextView) findViewById(a.g.playback_title);
    }

    public void setData(String str, long j, long j2, String str2) {
        this.ewk.startLoad(str, 10, false);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.ewl.setVisibility(8);
        } else {
            this.ewl.setVisibility(0);
            String format = String.format(getContext().getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.co(j));
            String timeInterval = StringHelper.getTimeInterval(j2);
            this.ewm.setText(format);
            this.ewn.setText(timeInterval);
        }
        if (StringUtils.isNull(str2)) {
            this.mTitleView.setText(StringHelper.STRING_MORE);
        } else {
            this.mTitleView.setText(str2);
        }
    }
}
