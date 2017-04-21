package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class br extends y.a {
    public int amZ;
    public FrameLayout bRZ;
    public TbImageView bRo;
    public PhotoLiveCardView bSa;

    public br(View view) {
        super(view);
        this.amZ = 3;
        this.bRZ = (FrameLayout) view.findViewById(w.h.live_card_layout);
        this.bRo = (TbImageView) view.findViewById(w.h.frs_single_livecard_theme_card);
        this.bSa = (PhotoLiveCardView) view.findViewById(w.h.item_live_card);
        this.bSa.setAllowGreyState(true);
    }
}
