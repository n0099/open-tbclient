package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.PhotoLiveCardView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dw extends x.a {
    public int aik;
    ViewGroup bpX;
    TextView bpY;
    View bpZ;
    PhotoLiveCardView bqa;
    View bqb;
    View bqc;

    public dw(View view) {
        super(view);
        this.aik = 3;
        this.bpX = (ViewGroup) view.findViewById(t.g.live_content_layout);
        this.bpY = (TextView) this.bpX.findViewById(t.g.live_title);
        this.bpZ = this.bpX.findViewById(t.g.live_title_card_line);
        this.bqa = (PhotoLiveCardView) this.bpX.findViewById(t.g.item_live_card);
        this.bqb = this.bpX.findViewById(t.g.live_bottom_card_line);
        this.bqc = this.bpX.findViewById(t.g.all_live_list);
        c(this.bqa);
        xy();
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

    public void xy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.aik) {
            this.aik = skinType;
            com.baidu.tbadk.core.util.at.k(this.bpX, t.f.frs_item_control_btn_bg);
            com.baidu.tbadk.core.util.at.j((View) this.bpY, t.d.cp_cont_f);
            com.baidu.tbadk.core.util.at.l(this.bpZ, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.l(this.bqb, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.j(this.bqc, t.d.cp_link_tip_c);
            com.baidu.tbadk.core.util.at.k(this.bqc, t.f.frs_item_control_btn_bg);
            this.bqa.xy();
        }
    }
}
