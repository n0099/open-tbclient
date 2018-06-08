package com.baidu.tieba.frs.worldcup.videotopic.insertcard;

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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.talkball.b.g;
/* loaded from: classes2.dex */
public class b {
    private ImageView bsT;
    private TbImageView cxQ;
    private TextView cya;
    private LinearLayout dGS;
    private LinearLayout dGT;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 0;
    private TextView mTitle;
    private View v;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.v = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.video_topic_card_item, (ViewGroup) null, false);
        this.dGT = (LinearLayout) this.v.findViewById(d.g.layout_root);
        this.dGS = (LinearLayout) this.v.findViewById(d.g.layout_title);
        this.mTitle = (TextView) this.v.findViewById(d.g.text_title);
        this.cxQ = (TbImageView) this.v.findViewById(d.g.image_video);
        this.cxQ.setDefaultResource(d.f.video_play_count_bg);
        this.cxQ.setGifIconSupport(false);
        this.bsT = (ImageView) this.v.findViewById(d.g.image_video_play);
        this.cya = (TextView) this.v.findViewById(d.g.text_video_duration);
    }

    public View getView() {
        return this.v;
    }

    public void a(g gVar) {
        if (gVar != null) {
            if (gVar.getTitle() != null) {
                this.mTitle.setText(gVar.getTitle());
            }
            this.cya.setText(ao.cX(com.baidu.adp.lib.g.b.g(gVar.aAw(), 1) * 1000));
            if (gVar.aAv() != null) {
                this.cxQ.startLoad(gVar.aAv(), 10, false);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.dGT.setBackgroundColor(al.getColor(this.mSkinType, d.C0141d.cp_bg_line_d));
            al.i(this.dGS, d.f.addresslist_item_bg);
            al.i(this.dGT, d.f.addresslist_item_bg);
            al.c(this.bsT, d.f.btn_icon_play_video_n);
            al.h(this.mTitle, d.C0141d.cp_cont_f);
            this.mSkinType = i;
        }
    }

    public LinearLayout aAJ() {
        return this.dGT;
    }
}
