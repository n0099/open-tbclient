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
/* loaded from: classes.dex */
public class ConcernVideoImageView extends RelativeLayout {
    private TbImageView dff;

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
        LayoutInflater.from(getContext()).inflate(d.h.concern_video_img_layout, (ViewGroup) this, true);
        this.dff = (TbImageView) findViewById(d.g.concern_video_img);
        this.dff.setDefaultBgResource(d.C0080d.cp_bg_line_e);
        int ac = l.ac(getContext()) - l.f(getContext(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dff.getLayoutParams();
        layoutParams.height = (ac * 9) / 16;
        layoutParams.width = ac;
    }

    public void setData(List<MediaData> list) {
        if (!v.v(list) && !StringUtils.isNull(list.get(0).getPicUrl())) {
            this.dff.startLoad(list.get(0).getPicUrl(), 10, false);
        }
    }
}
