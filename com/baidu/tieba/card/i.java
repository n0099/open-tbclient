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
    private TbPageContext<?> aaS;
    private View.OnClickListener anD;
    private View.OnClickListener ann;
    private View.OnClickListener ant;
    public TbImageView bCQ;
    public ImageView bCR;
    private View bEE;
    private com.baidu.tbadk.core.view.h bEF;
    private CustomMessageListener bFA;
    private com.baidu.tieba.card.data.k bFx;
    public View bFy;
    public RelativeLayout bFz;
    public View bfY;
    private ThreadUserInfoLayout bjL;
    public ThreadCommentAndPraiseInfoLayout bjP;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bEF = null;
        this.anD = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.VZ() != null) {
                    i.this.VZ().a(view, i.this.bFx);
                }
            }
        };
        this.ann = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.VZ() != null) {
                    i.this.VZ().a(view, i.this.bFx);
                }
            }
        };
        this.bFA = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bFx != null && i.this.bFx.threadData != null && i.this.bFx.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bFx.threadData.getTid())) {
                    m.a(i.this.mTextTitle, i.this.bFx.threadData.getId(), d.e.cp_cont_d, d.e.cp_cont_d);
                }
            }
        };
        this.ant = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bFx != null && !StringUtils.isNull(i.this.bFx.threadData.rA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bFx.threadData.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.ann != null) {
                        i.this.ann.onClick(view);
                    }
                }
            }
        };
        this.aaS = tbPageContext;
        S(getView());
    }

    private void S(View view) {
        this.bFy = view.findViewById(d.h.layout_root);
        this.bfY = view.findViewById(d.h.divider_line);
        this.bjL = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_ala_video_user_info_layout);
        this.bEF = new com.baidu.tbadk.core.view.h(this.aaS);
        this.bEF.wA();
        this.bEF.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bjL.addView(this.bEF);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bFz = (RelativeLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFz.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.af(this.aaS.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aaS.getPageActivity(), d.f.ds68);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bFz.setLayoutParams(layoutParams);
        this.bCQ = (TbImageView) view.findViewById(d.h.image_video);
        this.bCQ.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bCQ.setDefaultResource(0);
        this.bCQ.setDefaultErrorResource(0);
        this.bCR = (ImageView) view.findViewById(d.h.image_video_play);
        this.bjP = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bjP.setOnClickListener(this);
        this.bjP.setReplyTimeVisible(false);
        this.bjP.setShowPraiseNum(false);
        this.bjP.setNeedAddPraiseIcon(false);
        this.bjP.setNeedAddReplyIcon(false);
        this.bjP.setCommentNumEnable(false);
        this.bjP.setLiveShareEnable(true);
        this.bjP.setLiveAudienceEnable(true);
        this.bjP.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bjP.setLiveShareIcon(d.g.icon_home_card_share_n);
        this.bjP.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.bjP.setFrom(1);
        this.bEE = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bFy.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bFy, d.g.addresslist_item_bg);
            ai.k(this.bfY, d.e.cp_bg_line_c);
            ai.i(this.mTextTitle, d.e.cp_cont_b);
            ai.c(this.bCR, d.g.btn_icon_play_live);
            ai.k(this.bFz, d.e.cp_bg_line_k);
            this.bjL.onChangeSkinType();
            this.bjP.onChangeSkinType();
            if (this.bEF != null) {
                this.bEF.onChangeSkinType();
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
        this.bFx = kVar;
        Ot();
    }

    private void Ot() {
        if (this.bFx == null || this.bFx.MA() == null) {
            this.bFy.setVisibility(8);
            return;
        }
        this.bFy.setVisibility(0);
        this.bjL.a(this.bFx.MA());
        this.bjL.setUserAfterClickListener(this.anD);
        if (this.bjL.getHeaderImg() != null) {
            this.bjL.getHeaderImg().setData(this.bFx.MA());
        }
        this.bFx.MA().sd();
        String string = this.aaS.getResources().getString(d.l.ala_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bFx.MA().rV()));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bjP.a(this.bFx.threadData)) {
            this.bEE.setVisibility(8);
        } else {
            this.bEE.setVisibility(0);
        }
        if (this.bEF != null && this.bFx.MA() != null) {
            an anVar = new an();
            anVar.cz(this.bFx.MA().getTid());
            anVar.setFid(this.bFx.MA().getFid());
            anVar.a(this.bFx.Wx);
            this.bEF.setData(anVar);
            this.bEF.setFirstRowSingleColumn(true);
        }
        d(this.aaS, TbadkCoreApplication.getInst().getSkinType());
        if (m.iZ(this.bFx.threadData.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        Wg();
    }

    public void Wg() {
        if (com.baidu.tbadk.core.h.oN().oT() && this.bFx != null && this.bFx.MA() != null && this.bFx.MA().rN() != null) {
            this.bCQ.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.bCQ.c(this.bFx.MA().rN().cover, 10, false);
            this.bFz.setVisibility(0);
            return;
        }
        this.bFz.setVisibility(8);
    }

    public void a(h.a aVar) {
        if (this.bEF != null) {
            this.bEF.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bFy) {
            W(view);
        }
    }

    private void W(View view) {
        if (VZ() != null) {
            VZ().a(view, this.bFx);
        }
        if (this.bFx != null && this.bFx.MA() != null && this.bFx.MA().rN() != null) {
            m.iY(this.bFx.threadData.getId());
            m.a(this.mTextTitle, this.bFx.threadData.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bFx.MA().rN());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.aaS.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bjP != null && this.bFA != null) {
            if (this.bjL != null) {
                this.bjL.setPageUniqueId(bdUniqueId);
            }
            this.bFA.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bEF != null) {
                this.bEF.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bFA);
        }
    }
}
