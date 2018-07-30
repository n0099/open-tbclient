package com.baidu.tieba.frs.worldcup.videotopic.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.talkball.b.g;
/* loaded from: classes3.dex */
public class b {
    private TextView bcR;
    private TbImageView bcS;
    private ImageView bcT;
    private LinearLayout dNb;
    private LinearLayout dNc;
    private int mSkinType = 0;
    private TextView mTitle;
    private View v;

    public b(TbPageContext<?> tbPageContext) {
        this.v = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.video_topic_card_item, (ViewGroup) null, false);
        this.dNc = (LinearLayout) this.v.findViewById(d.g.layout_root);
        this.dNb = (LinearLayout) this.v.findViewById(d.g.layout_title);
        this.mTitle = (TextView) this.v.findViewById(d.g.text_title);
        this.bcS = (TbImageView) this.v.findViewById(d.g.image_video);
        this.bcS.setDefaultResource(d.f.video_play_count_bg);
        this.bcS.setGifIconSupport(false);
        this.bcT = (ImageView) this.v.findViewById(d.g.image_video_play);
        this.bcR = (TextView) this.v.findViewById(d.g.text_video_duration);
    }

    public View getView() {
        return this.v;
    }

    public void a(g gVar) {
        if (gVar != null) {
            if (gVar.getTitle() != null) {
                this.mTitle.setText(gVar.getTitle());
            }
            this.bcR.setText(ap.da(com.baidu.adp.lib.g.b.g(gVar.aBM(), 1) * 1000));
            if (gVar.aBL() != null) {
                this.bcS.startLoad(gVar.aBL(), 10, false);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.dNc.setBackgroundColor(am.getColor(this.mSkinType, d.C0140d.cp_bg_line_d));
            am.i(this.dNb, d.f.addresslist_item_bg);
            am.i(this.dNc, d.f.addresslist_item_bg);
            am.c(this.bcT, d.f.btn_icon_play_video_n);
            am.h(this.mTitle, d.C0140d.cp_cont_f);
            this.mSkinType = i;
        }
    }

    public LinearLayout getRootView() {
        return this.dNc;
    }
}
