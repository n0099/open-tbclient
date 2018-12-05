package com.baidu.tieba.frs.worldcup.videotopic.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.worldcup.talkball.b.g;
/* loaded from: classes3.dex */
public class b {
    private TextView boL;
    private TbImageView boM;
    private ImageView boN;
    private LinearLayout ekg;
    private LinearLayout ekh;
    private int mSkinType = 0;
    private TextView mTitle;
    private View v;

    public b(TbPageContext<?> tbPageContext) {
        this.v = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.video_topic_card_item, (ViewGroup) null, false);
        this.ekh = (LinearLayout) this.v.findViewById(e.g.layout_root);
        this.ekg = (LinearLayout) this.v.findViewById(e.g.layout_title);
        this.mTitle = (TextView) this.v.findViewById(e.g.text_title);
        this.boM = (TbImageView) this.v.findViewById(e.g.image_video);
        this.boM.setDefaultResource(e.f.video_play_count_bg);
        this.boM.setGifIconSupport(false);
        this.boN = (ImageView) this.v.findViewById(e.g.image_video_play);
        this.boL = (TextView) this.v.findViewById(e.g.text_video_duration);
    }

    public View getView() {
        return this.v;
    }

    public void a(g gVar) {
        if (gVar != null) {
            if (gVar.getTitle() != null) {
                this.mTitle.setText(gVar.getTitle());
            }
            this.boL.setText(ao.dV(com.baidu.adp.lib.g.b.l(gVar.aIy(), 1) * 1000));
            if (gVar.aIx() != null) {
                this.boM.startLoad(gVar.aIx(), 10, false);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.ekh.setBackgroundColor(al.getColor(this.mSkinType, e.d.cp_bg_line_d));
            al.i(this.ekg, e.f.addresslist_item_bg);
            al.i(this.ekh, e.f.addresslist_item_bg);
            al.c(this.boN, e.f.btn_icon_play_video_n);
            al.h(this.mTitle, e.d.cp_cont_f);
            this.mSkinType = i;
        }
    }

    public LinearLayout getRootView() {
        return this.ekh;
    }
}
