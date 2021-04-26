package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernVideoImageView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f16989e;

    public ConcernVideoImageView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.concern_video_img_layout, (ViewGroup) this, true);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.concern_video_img);
        this.f16989e = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        int k = l.k(getContext()) - l.g(getContext(), R.dimen.ds68);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16989e.getLayoutParams();
        layoutParams.height = (k * 9) / 16;
        layoutParams.width = k;
    }

    public void setData(List<MediaData> list) {
        if (ListUtils.isEmpty(list) || StringUtils.isNull(list.get(0).getPicUrl())) {
            return;
        }
        this.f16989e.V(list.get(0).getPicUrl(), 10, false);
    }

    public ConcernVideoImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public ConcernVideoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
