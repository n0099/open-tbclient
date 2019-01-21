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
    private bb aFJ;
    private ClickableHeaderImageView aKS;
    private TextView aKU;
    private TextView bpD;
    private TbImageView bpE;
    private ImageView bpF;
    private TextView enM;
    private FrameLayout enN;
    private RelativeLayout enO;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.enO = (RelativeLayout) view.findViewById(e.g.layout_person);
        this.enO.setOnClickListener(this);
        this.aKS = (ClickableHeaderImageView) view.findViewById(e.g.video_page_user_header);
        this.aKS.setDefaultResource(17170445);
        this.aKS.setDefaultResource(e.f.icon_default_avatar100);
        this.aKS.setDefaultBgResource(e.d.cp_bg_line_e);
        this.aKS.setIsRound(true);
        this.aKS.setClickable(false);
        this.aKU = (TextView) view.findViewById(e.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.enN = (FrameLayout) view.findViewById(e.g.layout_video);
        this.enN.setOnClickListener(this);
        this.bpE = (TbImageView) view.findViewById(e.g.image_video);
        this.bpE.setPageId(getTag());
        this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpE.setGifIconSupport(false);
        this.bpF = (ImageView) view.findViewById(e.g.image_video_play);
        this.bpD = (TextView) view.findViewById(e.g.text_video_duration);
        this.enM = (TextView) view.findViewById(e.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aF(view);
        if (this.aFJ != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aFJ));
        }
    }

    private void aF(View view) {
        if (aqp() != null) {
            aqp().a(view, this.aFJ);
        }
        if (this.aFJ != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.aFJ, this.aFJ.zZ(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.aFJ.getFid()));
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
        this.aFJ = bbVar;
        if (this.aFJ == null) {
            this.enO.setVisibility(8);
            this.enN.setVisibility(8);
            return;
        }
        this.enO.setVisibility(0);
        this.enN.setVisibility(0);
        aqD();
        this.mTextTitle.setText(this.aFJ.getTitle());
        if (this.aFJ.zT() == null || this.aFJ.zT().getPortrait() == null) {
            this.aKS.setVisibility(8);
        } else {
            this.aKS.setData(this.aFJ, false);
            this.aKU.setText(ao.d(this.aFJ.zT().getName_show(), 24, "..."));
            this.aKS.setVisibility(0);
        }
        this.bpD.setText(ao.dV(this.aFJ.Al().video_duration.intValue() * 1000));
        this.enM.setText(String.format(this.mTbPageContext.getString(e.j.frs_comment_number), ao.R(this.aFJ.zK())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aqD() {
        if (this.bpE != null && this.enN != null) {
            if (this.aFJ != null && this.aFJ.Al() != null) {
                this.enN.setVisibility(0);
                this.bpE.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpE.startLoad(this.aFJ.Al().thumbnail_url, 10, false);
                return;
            }
            this.enN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.enO, e.f.addresslist_item_bg);
            al.c(this.bpF, e.f.btn_icon_play_video_n);
            al.h(this.enM, e.d.cp_cont_f);
            al.h(this.bpD, e.d.cp_cont_i);
            al.h(this.aKU, e.d.cp_cont_f);
            al.h(this.mTextTitle, e.d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aKS.setPageId(bdUniqueId);
        }
    }
}
