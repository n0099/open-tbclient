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
    private bb aFI;
    private ClickableHeaderImageView aKR;
    private TextView aKT;
    private TextView bpC;
    private TbImageView bpD;
    private ImageView bpE;
    private TextView enL;
    private FrameLayout enM;
    private RelativeLayout enN;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.enN = (RelativeLayout) view.findViewById(e.g.layout_person);
        this.enN.setOnClickListener(this);
        this.aKR = (ClickableHeaderImageView) view.findViewById(e.g.video_page_user_header);
        this.aKR.setDefaultResource(17170445);
        this.aKR.setDefaultResource(e.f.icon_default_avatar100);
        this.aKR.setDefaultBgResource(e.d.cp_bg_line_e);
        this.aKR.setIsRound(true);
        this.aKR.setClickable(false);
        this.aKT = (TextView) view.findViewById(e.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(e.g.text_title);
        this.enM = (FrameLayout) view.findViewById(e.g.layout_video);
        this.enM.setOnClickListener(this);
        this.bpD = (TbImageView) view.findViewById(e.g.image_video);
        this.bpD.setPageId(getTag());
        this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.bpD.setGifIconSupport(false);
        this.bpE = (ImageView) view.findViewById(e.g.image_video_play);
        this.bpC = (TextView) view.findViewById(e.g.text_video_duration);
        this.enL = (TextView) view.findViewById(e.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aF(view);
        if (this.aFI != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.aFI));
        }
    }

    private void aF(View view) {
        if (aqp() != null) {
            aqp().a(view, this.aFI);
        }
        if (this.aFI != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.aFI, this.aFI.zZ(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.aFI.getFid()));
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
        this.aFI = bbVar;
        if (this.aFI == null) {
            this.enN.setVisibility(8);
            this.enM.setVisibility(8);
            return;
        }
        this.enN.setVisibility(0);
        this.enM.setVisibility(0);
        aqD();
        this.mTextTitle.setText(this.aFI.getTitle());
        if (this.aFI.zT() == null || this.aFI.zT().getPortrait() == null) {
            this.aKR.setVisibility(8);
        } else {
            this.aKR.setData(this.aFI, false);
            this.aKT.setText(ao.d(this.aFI.zT().getName_show(), 24, "..."));
            this.aKR.setVisibility(0);
        }
        this.bpC.setText(ao.dV(this.aFI.Al().video_duration.intValue() * 1000));
        this.enL.setText(String.format(this.mTbPageContext.getString(e.j.frs_comment_number), ao.R(this.aFI.zK())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aqD() {
        if (this.bpD != null && this.enM != null) {
            if (this.aFI != null && this.aFI.Al() != null) {
                this.enM.setVisibility(0);
                this.bpD.setDefaultBgResource(e.f.pic_bg_video_frs);
                this.bpD.startLoad(this.aFI.Al().thumbnail_url, 10, false);
                return;
            }
            this.enM.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.enN, e.f.addresslist_item_bg);
            al.c(this.bpE, e.f.btn_icon_play_video_n);
            al.h(this.enL, e.d.cp_cont_f);
            al.h(this.bpC, e.d.cp_cont_i);
            al.h(this.aKT, e.d.cp_cont_f);
            al.h(this.mTextTitle, e.d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aKR.setPageId(bdUniqueId);
        }
    }
}
