package com.baidu.tieba.frs;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class eg extends y.a {
    public int aej;
    public TbImageView bkR;
    public FrameLayout blQ;
    public PhotoLiveCardView blR;

    public eg(View view) {
        super(view);
        this.aej = 3;
        this.blQ = (FrameLayout) view.findViewById(t.g.live_card_layout);
        this.bkR = (TbImageView) view.findViewById(t.g.frs_single_livecard_theme_card);
        this.blR = (PhotoLiveCardView) view.findViewById(t.g.item_live_card);
        this.blR.setAllowGreyState(true);
    }

    public void vm() {
        if (this.blR != null) {
            this.blR.vm();
        }
    }
}
