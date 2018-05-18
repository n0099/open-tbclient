package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernVideoImageView extends RelativeLayout {
    private TbImageView dDc;

    public ConcernVideoImageView(Context context) {
        super(context);
        init();
    }

    public ConcernVideoImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public ConcernVideoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.concern_video_img_layout, (ViewGroup) this, true);
        this.dDc = (TbImageView) findViewById(d.g.concern_video_img);
        this.dDc.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        int af = l.af(getContext()) - l.e(getContext(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDc.getLayoutParams();
        layoutParams.height = (af * 9) / 16;
        layoutParams.width = af;
    }

    public void setData(List<MediaData> list) {
        if (!v.w(list) && !StringUtils.isNull(list.get(0).getPicUrl())) {
            this.dDc.startLoad(list.get(0).getPicUrl(), 10, false);
        }
    }
}
