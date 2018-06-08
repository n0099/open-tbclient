package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernVideoImageView extends RelativeLayout {
    private TbImageView dOn;

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
        this.dOn = (TbImageView) findViewById(d.g.concern_video_img);
        this.dOn.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        int ah = l.ah(getContext()) - l.e(getContext(), d.e.ds68);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dOn.getLayoutParams();
        layoutParams.height = (ah * 9) / 16;
        layoutParams.width = ah;
    }

    public void setData(List<MediaData> list) {
        if (!w.z(list) && !StringUtils.isNull(list.get(0).getPicUrl())) {
            this.dOn.startLoad(list.get(0).getPicUrl(), 10, false);
        }
    }
}
