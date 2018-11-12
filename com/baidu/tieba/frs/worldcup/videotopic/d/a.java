package com.baidu.tieba.frs.worldcup.videotopic.d;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<bb> {
    private bb aBF;
    private ClickableHeaderImageView aGN;
    private TextView aGP;
    private TextView bln;
    private TbImageView blo;
    private ImageView blp;
    private TextView edL;
    private FrameLayout edM;
    private RelativeLayout edN;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.edN = (RelativeLayout) view.findViewById(e.g.layout_person);
        this.edN.setOnClickListener(this);
        this.aGN = (ClickableHeaderImageView) view.findViewById(e.g.video_page_user_header);
        this.aGN.setDefaultResource(17170445);
        this.aGN.setDefaultResource(e.f.icon_default_avatar100);
        this.aGN.setDefaultBgResource(e.d.cp_bg_line_e);
        this.aGN.setIsRound(true);
        this.aGN.setClickable(false);
        this.aGP = (TextView) view.findViewById(e.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.edM = (FrameLayout) view.findViewById(e.g.layout_video);
        this.edM.setOnClickListener(this);
        this.blo = (TbImageView) view.findViewById(e.g.image_video);
        this.blo.setPageId(getTag());
        this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.blo.setGifIconSupport(false);
        this.blp = (ImageView) view.findViewById(e.g.image_video_play);
        this.bln = (TextView) view.findViewById(e.g.text_video_duration);
        this.edL = (TextView) view.findViewById(e.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aC(view);
        if (this.aBF != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aBF));
        }
    }

    private void aC(View view) {
        if (anq() != null) {
            anq().a(view, this.aBF);
        }
        if (this.aBF != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.aBF, this.aBF.yI(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.aBF.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.video_topic_list_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: F */
    public void a(bb bbVar) {
        this.aBF = bbVar;
        if (this.aBF == null) {
            this.edN.setVisibility(8);
            this.edM.setVisibility(8);
            return;
        }
        this.edN.setVisibility(0);
        this.edM.setVisibility(0);
        anE();
        this.mTextTitle.setText(this.aBF.getTitle());
        if (this.aBF.yC() == null || this.aBF.yC().getPortrait() == null) {
            this.aGN.setVisibility(8);
        } else {
            this.aGN.setData(this.aBF, false);
            this.aGP.setText(ao.d(this.aBF.yC().getName_show(), 24, "..."));
            this.aGN.setVisibility(0);
        }
        this.bln.setText(ao.dH(this.aBF.yU().video_duration.intValue() * 1000));
        this.edL.setText(String.format(this.mTbPageContext.getString(e.j.frs_comment_number), ao.J(this.aBF.yt())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void anE() {
        if (this.blo != null && this.edM != null) {
            if (this.aBF != null && this.aBF.yU() != null) {
                this.edM.setVisibility(0);
                this.blo.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.blo.startLoad(this.aBF.yU().thumbnail_url, 10, false);
                return;
            }
            this.edM.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.edN, e.f.addresslist_item_bg);
            al.c(this.blp, e.f.btn_icon_play_video_n);
            al.h(this.edL, e.d.cp_cont_f);
            al.h(this.bln, e.d.cp_cont_i);
            al.h(this.aGP, e.d.cp_cont_f);
            al.h(this.mTextTitle, e.d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aGN.setPageId(bdUniqueId);
        }
    }
}
