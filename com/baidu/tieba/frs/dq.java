package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dq extends x.a {
    public int ahU;
    ViewGroup bkI;
    TextView bkJ;
    View bkK;
    PhotoLiveCardView bkL;
    View bkM;
    View bkN;

    public dq(View view) {
        super(view);
        this.ahU = 3;
        this.bkI = (ViewGroup) view.findViewById(t.g.live_content_layout);
        this.bkJ = (TextView) this.bkI.findViewById(t.g.live_title);
        this.bkK = this.bkI.findViewById(t.g.live_title_card_line);
        this.bkL = (PhotoLiveCardView) this.bkI.findViewById(t.g.item_live_card);
        this.bkM = this.bkI.findViewById(t.g.live_bottom_card_line);
        this.bkN = this.bkI.findViewById(t.g.all_live_list);
        c(this.bkL);
        xf();
    }

    private void c(PhotoLiveCardView photoLiveCardView) {
        photoLiveCardView.setShowContent(false);
        photoLiveCardView.setShowBottom(true);
        photoLiveCardView.setHeadPaddingTop(t.e.ds24);
        photoLiveCardView.setShowLiveIcon(true);
        photoLiveCardView.setShowRefreshTimeInButtom(true);
        photoLiveCardView.setShowHeadLiveIcon(true);
        photoLiveCardView.setParentBackground(t.f.addresslist_item_bg);
        photoLiveCardView.setTitleMaxLines(1);
    }

    public void xf() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ahU) {
            this.ahU = skinType;
            com.baidu.tbadk.core.util.ar.k(this.bkI, t.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.ar.j((View) this.bkJ, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.ar.l(this.bkK, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ar.l(this.bkM, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ar.j(this.bkN, t.d.cp_link_tip_c);
            com.baidu.tbadk.core.util.ar.k(this.bkN, t.f.frs_item_control_btn_bg);
            this.bkL.xf();
        }
    }
}
