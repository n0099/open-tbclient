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
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes6.dex */
public class ConcernVideoImageView extends RelativeLayout {
    private TbImageView evj;

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
        LayoutInflater.from(getContext()).inflate(e.h.concern_video_img_layout, (ViewGroup) this, true);
        this.evj = (TbImageView) findViewById(e.g.concern_video_img);
        this.evj.setDefaultBgResource(e.d.cp_bg_line_e);
        int aO = l.aO(getContext()) - l.h(getContext(), e.C0210e.ds68);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evj.getLayoutParams();
        layoutParams.height = (aO * 9) / 16;
        layoutParams.width = aO;
    }

    public void setData(List<MediaData> list) {
        if (!v.I(list) && !StringUtils.isNull(list.get(0).getPicUrl())) {
            this.evj.startLoad(list.get(0).getPicUrl(), 10, false);
        }
    }
}
