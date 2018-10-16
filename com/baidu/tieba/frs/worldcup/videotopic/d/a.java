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
    private bb aAQ;
    private ClickableHeaderImageView aFX;
    private TextView aFZ;
    private TextView bkC;
    private TbImageView bkD;
    private ImageView bkE;
    private TextView ecq;
    private FrameLayout ecr;
    private RelativeLayout ecs;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.ecs = (RelativeLayout) view.findViewById(e.g.layout_person);
        this.ecs.setOnClickListener(this);
        this.aFX = (ClickableHeaderImageView) view.findViewById(e.g.video_page_user_header);
        this.aFX.setDefaultResource(17170445);
        this.aFX.setDefaultResource(e.f.icon_default_avatar100);
        this.aFX.setDefaultBgResource(e.d.cp_bg_line_e);
        this.aFX.setIsRound(true);
        this.aFX.setClickable(false);
        this.aFZ = (TextView) view.findViewById(e.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.ecr = (FrameLayout) view.findViewById(e.g.layout_video);
        this.ecr.setOnClickListener(this);
        this.bkD = (TbImageView) view.findViewById(e.g.image_video);
        this.bkD.setPageId(getTag());
        this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bkD.setGifIconSupport(false);
        this.bkE = (ImageView) view.findViewById(e.g.image_video_play);
        this.bkC = (TextView) view.findViewById(e.g.text_video_duration);
        this.ecq = (TextView) view.findViewById(e.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aA(view);
        if (this.aAQ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aAQ));
        }
    }

    private void aA(View view) {
        if (anO() != null) {
            anO().a(view, this.aAQ);
        }
        if (this.aAQ != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.aAQ, this.aAQ.yB(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.aAQ.getFid()));
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
        this.aAQ = bbVar;
        if (this.aAQ == null) {
            this.ecs.setVisibility(8);
            this.ecr.setVisibility(8);
            return;
        }
        this.ecs.setVisibility(0);
        this.ecr.setVisibility(0);
        aoc();
        this.mTextTitle.setText(this.aAQ.getTitle());
        if (this.aAQ.yv() == null || this.aAQ.yv().getPortrait() == null) {
            this.aFX.setVisibility(8);
        } else {
            this.aFX.setData(this.aAQ, false);
            this.aFZ.setText(ao.d(this.aAQ.yv().getName_show(), 24, "..."));
            this.aFX.setVisibility(0);
        }
        this.bkC.setText(ao.dt(this.aAQ.yN().video_duration.intValue() * 1000));
        this.ecq.setText(String.format(this.mTbPageContext.getString(e.j.frs_comment_number), ao.H(this.aAQ.ym())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aoc() {
        if (this.bkD != null && this.ecr != null) {
            if (this.aAQ != null && this.aAQ.yN() != null) {
                this.ecr.setVisibility(0);
                this.bkD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bkD.startLoad(this.aAQ.yN().thumbnail_url, 10, false);
                return;
            }
            this.ecr.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.ecs, e.f.addresslist_item_bg);
            al.c(this.bkE, e.f.btn_icon_play_video_n);
            al.h(this.ecq, e.d.cp_cont_f);
            al.h(this.bkC, e.d.cp_cont_i);
            al.h(this.aFZ, e.d.cp_cont_f);
            al.h(this.mTextTitle, e.d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aFX.setPageId(bdUniqueId);
        }
    }
}
