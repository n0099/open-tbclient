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
    private bb aFg;
    private ClickableHeaderImageView aKp;
    private TextView aKr;
    private TextView boO;
    private TbImageView boP;
    private ImageView boQ;
    private TextView enf;
    private FrameLayout eng;
    private RelativeLayout enh;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.enh = (RelativeLayout) view.findViewById(e.g.layout_person);
        this.enh.setOnClickListener(this);
        this.aKp = (ClickableHeaderImageView) view.findViewById(e.g.video_page_user_header);
        this.aKp.setDefaultResource(17170445);
        this.aKp.setDefaultResource(e.f.icon_default_avatar100);
        this.aKp.setDefaultBgResource(e.d.cp_bg_line_e);
        this.aKp.setIsRound(true);
        this.aKp.setClickable(false);
        this.aKr = (TextView) view.findViewById(e.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.eng = (FrameLayout) view.findViewById(e.g.layout_video);
        this.eng.setOnClickListener(this);
        this.boP = (TbImageView) view.findViewById(e.g.image_video);
        this.boP.setPageId(getTag());
        this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.boP.setGifIconSupport(false);
        this.boQ = (ImageView) view.findViewById(e.g.image_video_play);
        this.boO = (TextView) view.findViewById(e.g.text_video_duration);
        this.enf = (TextView) view.findViewById(e.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aF(view);
        if (this.aFg != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aFg));
        }
    }

    private void aF(View view) {
        if (apS() != null) {
            apS().a(view, this.aFg);
        }
        if (this.aFg != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.aFg, this.aFg.zM(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.aFg.getFid()));
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
        this.aFg = bbVar;
        if (this.aFg == null) {
            this.enh.setVisibility(8);
            this.eng.setVisibility(8);
            return;
        }
        this.enh.setVisibility(0);
        this.eng.setVisibility(0);
        aqg();
        this.mTextTitle.setText(this.aFg.getTitle());
        if (this.aFg.zG() == null || this.aFg.zG().getPortrait() == null) {
            this.aKp.setVisibility(8);
        } else {
            this.aKp.setData(this.aFg, false);
            this.aKr.setText(ao.d(this.aFg.zG().getName_show(), 24, "..."));
            this.aKp.setVisibility(0);
        }
        this.boO.setText(ao.dV(this.aFg.zY().video_duration.intValue() * 1000));
        this.enf.setText(String.format(this.mTbPageContext.getString(e.j.frs_comment_number), ao.R(this.aFg.zx())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aqg() {
        if (this.boP != null && this.eng != null) {
            if (this.aFg != null && this.aFg.zY() != null) {
                this.eng.setVisibility(0);
                this.boP.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.boP.startLoad(this.aFg.zY().thumbnail_url, 10, false);
                return;
            }
            this.eng.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.enh, e.f.addresslist_item_bg);
            al.c(this.boQ, e.f.btn_icon_play_video_n);
            al.h(this.enf, e.d.cp_cont_f);
            al.h(this.boO, e.d.cp_cont_i);
            al.h(this.aKr, e.d.cp_cont_f);
            al.h(this.mTextTitle, e.d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aKp.setPageId(bdUniqueId);
        }
    }
}
