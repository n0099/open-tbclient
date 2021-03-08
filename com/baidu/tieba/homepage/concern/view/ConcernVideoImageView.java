package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class ConcernVideoImageView extends RelativeLayout {
    private TbImageView eKF;

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
        LayoutInflater.from(getContext()).inflate(R.layout.concern_video_img_layout, (ViewGroup) this, true);
        this.eKF = (TbImageView) findViewById(R.id.concern_video_img);
        this.eKF.setDefaultBgResource(R.color.CAM_X0205);
        int equipmentWidth = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKF.getLayoutParams();
        layoutParams.height = (equipmentWidth * 9) / 16;
        layoutParams.width = equipmentWidth;
    }

    public void setData(List<MediaData> list) {
        if (!y.isEmpty(list) && !StringUtils.isNull(list.get(0).getPicUrl())) {
            this.eKF.startLoad(list.get(0).getPicUrl(), 10, false);
        }
    }
}
