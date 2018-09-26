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
    private ClickableHeaderImageView aBr;
    private TextView aBt;
    private bb awf;
    private TextView bgm;
    private TbImageView bgn;
    private ImageView bgo;
    private TextView dUx;
    private FrameLayout dUy;
    private RelativeLayout dUz;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.dUz = (RelativeLayout) view.findViewById(e.g.layout_person);
        this.dUz.setOnClickListener(this);
        this.aBr = (ClickableHeaderImageView) view.findViewById(e.g.video_page_user_header);
        this.aBr.setDefaultResource(17170445);
        this.aBr.setDefaultResource(e.f.icon_default_avatar100);
        this.aBr.setDefaultBgResource(e.d.cp_bg_line_e);
        this.aBr.setIsRound(true);
        this.aBr.setClickable(false);
        this.aBt = (TextView) view.findViewById(e.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.dUy = (FrameLayout) view.findViewById(e.g.layout_video);
        this.dUy.setOnClickListener(this);
        this.bgn = (TbImageView) view.findViewById(e.g.image_video);
        this.bgn.setPageId(getTag());
        this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bgn.setGifIconSupport(false);
        this.bgo = (ImageView) view.findViewById(e.g.image_video_play);
        this.bgm = (TextView) view.findViewById(e.g.text_video_duration);
        this.dUx = (TextView) view.findViewById(e.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aA(view);
        if (this.awf != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.awf));
        }
    }

    private void aA(View view) {
        if (akm() != null) {
            akm().a(view, this.awf);
        }
        if (this.awf != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.awf, this.awf.ws(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.awf.getFid()));
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
        this.awf = bbVar;
        if (this.awf == null) {
            this.dUz.setVisibility(8);
            this.dUy.setVisibility(8);
            return;
        }
        this.dUz.setVisibility(0);
        this.dUy.setVisibility(0);
        akA();
        this.mTextTitle.setText(this.awf.getTitle());
        if (this.awf.wm() == null || this.awf.wm().getPortrait() == null) {
            this.aBr.setVisibility(8);
        } else {
            this.aBr.setData(this.awf, false);
            this.aBt.setText(ao.d(this.awf.wm().getName_show(), 24, "..."));
            this.aBr.setVisibility(0);
        }
        this.bgm.setText(ao.dj(this.awf.wE().video_duration.intValue() * 1000));
        this.dUx.setText(String.format(this.mTbPageContext.getString(e.j.frs_comment_number), ao.F(this.awf.wd())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void akA() {
        if (this.bgn != null && this.dUy != null) {
            if (this.awf != null && this.awf.wE() != null) {
                this.dUy.setVisibility(0);
                this.bgn.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bgn.startLoad(this.awf.wE().thumbnail_url, 10, false);
                return;
            }
            this.dUy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.dUz, e.f.addresslist_item_bg);
            al.c(this.bgo, e.f.btn_icon_play_video_n);
            al.h(this.dUx, e.d.cp_cont_f);
            al.h(this.bgm, e.d.cp_cont_i);
            al.h(this.aBt, e.d.cp_cont_f);
            al.h(this.mTextTitle, e.d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aBr.setPageId(bdUniqueId);
        }
    }
}
