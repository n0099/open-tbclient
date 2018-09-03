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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<bb> {
    private bb atE;
    private ClickableHeaderImageView axH;
    private TextView axI;
    private TextView bcR;
    private TbImageView bcS;
    private ImageView bcT;
    private TextView dNf;
    private FrameLayout dNg;
    private RelativeLayout dNh;
    private int mSkinType;
    private TextView mTextTitle;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mSkinType = 0;
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.dNh = (RelativeLayout) view.findViewById(f.g.layout_person);
        this.dNh.setOnClickListener(this);
        this.axH = (ClickableHeaderImageView) view.findViewById(f.g.video_page_user_header);
        this.axH.setDefaultResource(17170445);
        this.axH.setDefaultResource(f.C0146f.icon_default_avatar100);
        this.axH.setDefaultBgResource(f.d.cp_bg_line_e);
        this.axH.setIsRound(true);
        this.axH.setClickable(false);
        this.axI = (TextView) view.findViewById(f.g.video_page_user_name);
        this.mTextTitle = (TextView) view.findViewById(f.g.text_title);
        this.dNg = (FrameLayout) view.findViewById(f.g.layout_video);
        this.dNg.setOnClickListener(this);
        this.bcS = (TbImageView) view.findViewById(f.g.image_video);
        this.bcS.setPageId(getTag());
        this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.bcS.setGifIconSupport(false);
        this.bcT = (ImageView) view.findViewById(f.g.image_video_play);
        this.bcR = (TextView) view.findViewById(f.g.text_video_duration);
        this.dNf = (TextView) view.findViewById(f.g.comment_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        am(view);
        if (this.atE != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016495, this.atE));
        }
    }

    private void am(View view) {
        if (aiC() != null) {
            aiC().a(view, this.atE);
        }
        if (this.atE != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.atE, this.atE.vp(), "frs_page", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(this.atE.getFid()));
            createFromThreadCfg.setStartFrom(this.currentPageType);
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.video_topic_list_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: E */
    public void a(bb bbVar) {
        this.atE = bbVar;
        if (this.atE == null) {
            this.dNh.setVisibility(8);
            this.dNg.setVisibility(8);
            return;
        }
        this.dNh.setVisibility(0);
        this.dNg.setVisibility(0);
        aiQ();
        this.mTextTitle.setText(this.atE.getTitle());
        if (this.atE.vj() == null || this.atE.vj().getPortrait() == null) {
            this.axH.setVisibility(8);
        } else {
            this.axH.setData(this.atE, false);
            this.axI.setText(ap.d(this.atE.vj().getName_show(), 24, "..."));
            this.axH.setVisibility(0);
        }
        this.bcR.setText(ap.da(this.atE.vB().video_duration.intValue() * 1000));
        this.dNf.setText(String.format(this.mTbPageContext.getString(f.j.frs_comment_number), ap.B(this.atE.va())));
        d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    private void aiQ() {
        if (this.bcS != null && this.dNg != null) {
            if (this.atE != null && this.atE.vB() != null) {
                this.dNg.setVisibility(0);
                this.bcS.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
                this.bcS.startLoad(this.atE.vB().thumbnail_url, 10, false);
                return;
            }
            this.dNg.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.dNh, f.C0146f.addresslist_item_bg);
            am.c(this.bcT, f.C0146f.btn_icon_play_video_n);
            am.h(this.dNf, f.d.cp_cont_f);
            am.h(this.bcR, f.d.cp_cont_i);
            am.h(this.axI, f.d.cp_cont_f);
            am.h(this.mTextTitle, f.d.cp_cont_g);
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.axH.setPageId(bdUniqueId);
        }
    }
}
