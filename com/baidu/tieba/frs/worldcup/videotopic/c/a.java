package com.baidu.tieba.frs.worldcup.videotopic.c;

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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<bd> {
    private bd atn;
    private ClickableHeaderImageView axn;
    private TextView axo;
    private ImageView bsT;
    private TbImageView cxQ;
    private TextView cya;
    private TextView dHa;
    private FrameLayout dHb;
    private RelativeLayout dHc;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.dHc = (RelativeLayout) view.findViewById(d.g.layout_person);
        this.dHc.setOnClickListener(this);
        this.axn = (ClickableHeaderImageView) view.findViewById(d.g.video_page_user_header);
        this.axn.setDefaultResource(17170445);
        this.axn.setDefaultResource(d.f.icon_default_avatar100);
        this.axn.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.axn.setIsRound(true);
        this.axn.setClickable(false);
        this.axo = (TextView) view.findViewById(d.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.dHb = (FrameLayout) view.findViewById(d.g.layout_video);
        this.dHb.setOnClickListener(this);
        this.cxQ = (TbImageView) view.findViewById(d.g.image_video);
        this.cxQ.setPageId(getTag());
        this.cxQ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cxQ.setGifIconSupport(false);
        this.bsT = (ImageView) view.findViewById(d.g.image_video_play);
        this.cya = (TextView) view.findViewById(d.g.text_video_duration);
        this.dHa = (TextView) view.findViewById(d.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ah(view);
        if (this.atn != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.atn));
        }
    }

    private void ah(View view) {
        if (aiI() != null) {
            aiI().a(view, this.atn);
        }
        if (this.atn != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.atn, this.atn.vr(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.atn.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.video_topic_list_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: A */
    public void a(bd bdVar) {
        this.atn = bdVar;
        if (this.atn == null) {
            this.dHc.setVisibility(8);
            this.dHb.setVisibility(8);
            return;
        }
        this.dHc.setVisibility(0);
        this.dHb.setVisibility(0);
        aiW();
        this.mTextTitle.setText(this.atn.getTitle());
        if (this.atn.vm() == null || this.atn.vm().getPortrait() == null) {
            this.axn.setVisibility(8);
        } else {
            this.axn.setData(this.atn, false);
            this.axo.setText(ao.e(this.atn.vm().getName_show(), 24, "..."));
            this.axn.setVisibility(0);
        }
        this.cya.setText(ao.cX(this.atn.vD().video_duration.intValue() * 1000));
        this.dHa.setText(String.format(this.mTbPageContext.getString(d.k.frs_comment_number), ao.z(this.atn.ve())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aiW() {
        if (this.cxQ != null && this.dHb != null) {
            if (this.atn != null && this.atn.vD() != null) {
                this.dHb.setVisibility(0);
                this.cxQ.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cxQ.startLoad(this.atn.vD().thumbnail_url, 10, false);
                return;
            }
            this.dHb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.dHc, d.f.addresslist_item_bg);
            al.c(this.bsT, d.f.btn_icon_play_video_n);
            al.h(this.dHa, d.C0141d.cp_cont_f);
            al.h(this.cya, d.C0141d.cp_cont_i);
            al.h(this.axo, d.C0141d.cp_cont_f);
            al.h(this.mTextTitle, d.C0141d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.axn.setPageId(bdUniqueId);
        }
    }
}
