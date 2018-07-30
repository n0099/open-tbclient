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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<bb> {
    private bb atD;
    private ClickableHeaderImageView axK;
    private TextView axL;
    private TextView bcR;
    private TbImageView bcS;
    private ImageView bcT;
    private TextView dNj;
    private FrameLayout dNk;
    private RelativeLayout dNl;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.dNl = (RelativeLayout) view.findViewById(d.g.layout_person);
        this.dNl.setOnClickListener(this);
        this.axK = (ClickableHeaderImageView) view.findViewById(d.g.video_page_user_header);
        this.axK.setDefaultResource(17170445);
        this.axK.setDefaultResource(d.f.icon_default_avatar100);
        this.axK.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.axK.setIsRound(true);
        this.axK.setClickable(false);
        this.axL = (TextView) view.findViewById(d.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dNk = (FrameLayout) view.findViewById(d.g.layout_video);
        this.dNk.setOnClickListener(this);
        this.bcS = (TbImageView) view.findViewById(d.g.image_video);
        this.bcS.setPageId(getTag());
        this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bcS.setGifIconSupport(false);
        this.bcT = (ImageView) view.findViewById(d.g.image_video_play);
        this.bcR = (TextView) view.findViewById(d.g.text_video_duration);
        this.dNj = (TextView) view.findViewById(d.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        am(view);
        if (this.atD != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.atD));
        }
    }

    private void am(View view) {
        if (aiz() != null) {
            aiz().a(view, this.atD);
        }
        if (this.atD != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.atD, this.atD.vq(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.atD.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.video_topic_list_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        this.atD = bbVar;
        if (this.atD == null) {
            this.dNl.setVisibility(8);
            this.dNk.setVisibility(8);
            return;
        }
        this.dNl.setVisibility(0);
        this.dNk.setVisibility(0);
        aiN();
        this.mTextTitle.setText(this.atD.getTitle());
        if (this.atD.vk() == null || this.atD.vk().getPortrait() == null) {
            this.axK.setVisibility(8);
        } else {
            this.axK.setData(this.atD, false);
            this.axL.setText(ap.e(this.atD.vk().getName_show(), 24, "..."));
            this.axK.setVisibility(0);
        }
        this.bcR.setText(ap.da(this.atD.vC().video_duration.intValue() * 1000));
        this.dNj.setText(String.format(this.mTbPageContext.getString(d.j.frs_comment_number), ap.B(this.atD.vb())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aiN() {
        if (this.bcS != null && this.dNk != null) {
            if (this.atD != null && this.atD.vC() != null) {
                this.dNk.setVisibility(0);
                this.bcS.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.bcS.startLoad(this.atD.vC().thumbnail_url, 10, false);
                return;
            }
            this.dNk.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.dNl, d.f.addresslist_item_bg);
            am.c(this.bcT, d.f.btn_icon_play_video_n);
            am.h(this.dNj, d.C0140d.cp_cont_f);
            am.h(this.bcR, d.C0140d.cp_cont_i);
            am.h(this.axL, d.C0140d.cp_cont_f);
            am.h(this.mTextTitle, d.C0140d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.axK.setPageId(bdUniqueId);
        }
    }
}
