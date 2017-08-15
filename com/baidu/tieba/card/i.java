package com.baidu.tieba.card;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> acr;
    private View.OnClickListener aoH;
    private View.OnClickListener aoN;
    private View.OnClickListener aoX;
    public TbImageView bEJ;
    public ImageView bEK;
    private View bGx;
    private com.baidu.tbadk.core.view.h bGy;
    private com.baidu.tieba.card.data.k bHq;
    public View bHr;
    public RelativeLayout bHs;
    private CustomMessageListener bHt;
    public View bhj;
    private ThreadUserInfoLayout bkZ;
    public ThreadCommentAndPraiseInfoLayout bld;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGy = null;
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.WA() != null) {
                    i.this.WA().a(view, i.this.bHq);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.WA() != null) {
                    i.this.WA().a(view, i.this.bHq);
                }
            }
        };
        this.bHt = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bHq != null && i.this.bHq.threadData != null && i.this.bHq.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bHq.threadData.getTid())) {
                    m.a(i.this.mTextTitle, i.this.bHq.threadData.getId(), d.e.cp_cont_d, d.e.cp_cont_d);
                }
            }
        };
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bHq != null && !StringUtils.isNull(i.this.bHq.threadData.rK())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bHq.threadData.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.aoH != null) {
                        i.this.aoH.onClick(view);
                    }
                }
            }
        };
        this.acr = tbPageContext;
        S(getView());
    }

    private void S(View view) {
        this.bHr = view.findViewById(d.h.layout_root);
        this.bhj = view.findViewById(d.h.divider_line);
        this.bkZ = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_ala_video_user_info_layout);
        this.bGy = new com.baidu.tbadk.core.view.h(this.acr);
        this.bGy.wK();
        this.bGy.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bkZ.addView(this.bGy);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bHs = (RelativeLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHs.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.ag(this.acr.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds68);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bHs.setLayoutParams(layoutParams);
        this.bEJ = (TbImageView) view.findViewById(d.h.image_video);
        this.bEJ.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEJ.setDefaultResource(0);
        this.bEJ.setDefaultErrorResource(0);
        this.bEK = (ImageView) view.findViewById(d.h.image_video_play);
        this.bld = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bld.setOnClickListener(this);
        this.bld.setReplyTimeVisible(false);
        this.bld.setShowPraiseNum(false);
        this.bld.setNeedAddPraiseIcon(false);
        this.bld.setNeedAddReplyIcon(false);
        this.bld.setCommentNumEnable(false);
        this.bld.setLiveShareEnable(true);
        this.bld.setLiveAudienceEnable(true);
        this.bld.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bld.setLiveShareIcon(d.g.icon_home_card_share_n);
        this.bld.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.bld.setFrom(1);
        this.bGx = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bHr.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bHr, d.g.addresslist_item_bg);
            ai.k(this.bhj, d.e.cp_bg_line_c);
            ai.i(this.mTextTitle, d.e.cp_cont_b);
            ai.c(this.bEK, d.g.btn_icon_play_live);
            ai.k(this.bHs, d.e.cp_bg_line_k);
            this.bkZ.onChangeSkinType();
            this.bld.onChangeSkinType();
            if (this.bGy != null) {
                this.bGy.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_home_page_ala_live_item_new;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        this.bHq = kVar;
        Oy();
    }

    private void Oy() {
        if (this.bHq == null || this.bHq.MF() == null) {
            this.bHr.setVisibility(8);
            return;
        }
        this.bHr.setVisibility(0);
        this.bkZ.a(this.bHq.MF());
        this.bkZ.setUserAfterClickListener(this.aoX);
        if (this.bkZ.getHeaderImg() != null) {
            this.bkZ.getHeaderImg().setData(this.bHq.MF());
        }
        this.bHq.MF().sn();
        String string = this.acr.getResources().getString(d.l.ala_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bHq.MF().sf()));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bld.a(this.bHq.threadData)) {
            this.bGx.setVisibility(8);
        } else {
            this.bGx.setVisibility(0);
        }
        if (this.bGy != null && this.bHq.MF() != null) {
            an anVar = new an();
            anVar.cF(this.bHq.MF().getTid());
            anVar.setFid(this.bHq.MF().getFid());
            anVar.a(this.bHq.XV);
            this.bGy.setData(anVar);
            this.bGy.setFirstRowSingleColumn(true);
        }
        d(this.acr, TbadkCoreApplication.getInst().getSkinType());
        if (m.jf(this.bHq.threadData.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        WH();
    }

    public void WH() {
        if (com.baidu.tbadk.core.h.oX().pd() && this.bHq != null && this.bHq.MF() != null && this.bHq.MF().rX() != null) {
            this.bEJ.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.bEJ.c(this.bHq.MF().rX().cover, 10, false);
            this.bHs.setVisibility(0);
            return;
        }
        this.bHs.setVisibility(8);
    }

    public void a(h.a aVar) {
        if (this.bGy != null) {
            this.bGy.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bHr) {
            W(view);
        }
    }

    private void W(View view) {
        if (WA() != null) {
            WA().a(view, this.bHq);
        }
        if (this.bHq != null && this.bHq.MF() != null && this.bHq.MF().rX() != null) {
            m.je(this.bHq.threadData.getId());
            m.a(this.mTextTitle, this.bHq.threadData.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bHq.MF().rX());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.acr.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bld != null && this.bHt != null) {
            if (this.bkZ != null) {
                this.bkZ.setPageUniqueId(bdUniqueId);
            }
            this.bHt.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bGy != null) {
                this.bGy.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bHt);
        }
    }
}
