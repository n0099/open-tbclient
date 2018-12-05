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
    private bb aFf;
    private ClickableHeaderImageView aKn;
    private TextView aKp;
    private TextView boL;
    private TbImageView boM;
    private ImageView boN;
    private TextView eko;
    private FrameLayout ekp;
    private RelativeLayout ekq;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.ekq = (RelativeLayout) view.findViewById(e.g.layout_person);
        this.ekq.setOnClickListener(this);
        this.aKn = (ClickableHeaderImageView) view.findViewById(e.g.video_page_user_header);
        this.aKn.setDefaultResource(17170445);
        this.aKn.setDefaultResource(e.f.icon_default_avatar100);
        this.aKn.setDefaultBgResource(e.d.cp_bg_line_e);
        this.aKn.setIsRound(true);
        this.aKn.setClickable(false);
        this.aKp = (TextView) view.findViewById(e.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.ekp = (FrameLayout) view.findViewById(e.g.layout_video);
        this.ekp.setOnClickListener(this);
        this.boM = (TbImageView) view.findViewById(e.g.image_video);
        this.boM.setPageId(getTag());
        this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boM.setGifIconSupport(false);
        this.boN = (ImageView) view.findViewById(e.g.image_video_play);
        this.boL = (TextView) view.findViewById(e.g.text_video_duration);
        this.eko = (TextView) view.findViewById(e.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aC(view);
        if (this.aFf != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aFf));
        }
    }

    private void aC(View view) {
        if (apc() != null) {
            apc().a(view, this.aFf);
        }
        if (this.aFf != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.aFf, this.aFf.zM(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.aFf.getFid()));
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
        this.aFf = bbVar;
        if (this.aFf == null) {
            this.ekq.setVisibility(8);
            this.ekp.setVisibility(8);
            return;
        }
        this.ekq.setVisibility(0);
        this.ekp.setVisibility(0);
        apr();
        this.mTextTitle.setText(this.aFf.getTitle());
        if (this.aFf.zG() == null || this.aFf.zG().getPortrait() == null) {
            this.aKn.setVisibility(8);
        } else {
            this.aKn.setData(this.aFf, false);
            this.aKp.setText(ao.d(this.aFf.zG().getName_show(), 24, "..."));
            this.aKn.setVisibility(0);
        }
        this.boL.setText(ao.dV(this.aFf.zY().video_duration.intValue() * 1000));
        this.eko.setText(String.format(this.mTbPageContext.getString(e.j.frs_comment_number), ao.Q(this.aFf.zx())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void apr() {
        if (this.boM != null && this.ekp != null) {
            if (this.aFf != null && this.aFf.zY() != null) {
                this.ekp.setVisibility(0);
                this.boM.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boM.startLoad(this.aFf.zY().thumbnail_url, 10, false);
                return;
            }
            this.ekp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.ekq, e.f.addresslist_item_bg);
            al.c(this.boN, e.f.btn_icon_play_video_n);
            al.h(this.eko, e.d.cp_cont_f);
            al.h(this.boL, e.d.cp_cont_i);
            al.h(this.aKp, e.d.cp_cont_f);
            al.h(this.mTextTitle, e.d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aKn.setPageId(bdUniqueId);
        }
    }
}
