package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class dl extends x.a {
    public int ahf;
    ViewGroup bhQ;
    TextView bhR;
    View bhS;
    PhotoLiveCardView bhT;
    View bhU;
    View bhV;

    public dl(View view) {
        super(view);
        this.ahf = 3;
        this.bhQ = (ViewGroup) view.findViewById(n.g.live_content_layout);
        this.bhR = (TextView) this.bhQ.findViewById(n.g.live_title);
        this.bhS = this.bhQ.findViewById(n.g.live_title_card_line);
        this.bhT = (PhotoLiveCardView) this.bhQ.findViewById(n.g.item_live_card);
        this.bhU = this.bhQ.findViewById(n.g.live_bottom_card_line);
        this.bhV = this.bhQ.findViewById(n.g.all_live_list);
        c(this.bhT);
        vR();
    }

    private void c(PhotoLiveCardView photoLiveCardView) {
        photoLiveCardView.setShowContent(false);
        photoLiveCardView.setShowBottom(true);
        photoLiveCardView.setHeadPaddingTop(n.e.ds24);
        photoLiveCardView.setShowLiveIcon(true);
        photoLiveCardView.setShowRefreshTimeInButtom(true);
        photoLiveCardView.setShowHeadLiveIcon(true);
        photoLiveCardView.setParentBackground(n.f.addresslist_item_bg);
        photoLiveCardView.setTitleMaxLines(1);
    }

    public void vR() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ahf) {
            this.ahf = skinType;
            com.baidu.tbadk.core.util.as.i(this.bhQ, n.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.as.h((View) this.bhR, n.d.cp_cont_f);
            com.baidu.tbadk.core.util.as.j(this.bhS, n.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.as.j(this.bhU, n.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.as.h(this.bhV, n.d.cp_link_tip_c);
            com.baidu.tbadk.core.util.as.i(this.bhV, n.f.frs_item_control_btn_bg);
            this.bhT.vR();
        }
    }
}
