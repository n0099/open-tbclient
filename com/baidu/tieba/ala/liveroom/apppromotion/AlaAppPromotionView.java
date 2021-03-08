package com.baidu.tieba.ala.liveroom.apppromotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class AlaAppPromotionView extends RelativeLayout {
    private TbImageView hrO;
    private TextView hrP;

    public AlaAppPromotionView(Context context) {
        this(context, null);
    }

    public AlaAppPromotionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaAppPromotionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_app_promotion_view, (ViewGroup) this, true);
        this.hrO = (TbImageView) findViewById(a.f.iv_app_icon);
        this.hrP = (TextView) findViewById(a.f.tv_app_des);
        this.hrO.setDefaultBgResource(a.c.sdk_transparent);
    }

    public void setImage(String str) {
        this.hrO.startLoad(str, 10, false);
    }

    public void setStatus(String str) {
        this.hrP.setText(str);
    }

    public void setProgress(long j, long j2) {
        int i = (int) ((100 * j) / j2);
        if (i < 0) {
            i = 0;
        }
        this.hrP.setText(getResources().getString(a.h.ala_app_promotion_downloading, Integer.valueOf(i <= 100 ? i : 100)));
    }
}
