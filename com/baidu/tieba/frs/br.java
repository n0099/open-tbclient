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
    public TbImageView bOX;
    public FrameLayout bPI;
    public PhotoLiveCardView bPJ;

    public br(View view) {
        super(view);
        this.amZ = 3;
        this.bPI = (FrameLayout) view.findViewById(w.h.live_card_layout);
        this.bOX = (TbImageView) view.findViewById(w.h.frs_single_livecard_theme_card);
        this.bPJ = (PhotoLiveCardView) view.findViewById(w.h.item_live_card);
        this.bPJ.setAllowGreyState(true);
    }
}
