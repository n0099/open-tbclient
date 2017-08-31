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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> aby;
    private View.OnClickListener aoe;
    private View.OnClickListener aow;
    public TbImageView bHE;
    public ImageView bHF;
    private View bJs;
    private com.baidu.tbadk.core.view.h bJt;
    private com.baidu.tieba.card.data.k bKk;
    public View bKl;
    public RelativeLayout bKm;
    private CustomMessageListener bKn;
    private View.OnClickListener bKo;
    public View bhp;
    private ThreadUserInfoLayout blv;
    public ThreadCommentAndPraiseInfoLayout blz;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJt = null;
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.XA() != null) {
                    i.this.XA().a(view, i.this.bKk);
                }
            }
        };
        this.aoe = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.XA() != null) {
                    i.this.XA().a(view, i.this.bKk);
                }
            }
        };
        this.bKn = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bKk != null && i.this.bKk.threadData != null && i.this.bKk.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bKk.threadData.getTid())) {
                    m.a(i.this.mTextTitle, i.this.bKk.threadData.getId(), d.e.cp_cont_d, d.e.cp_cont_d);
                }
            }
        };
        this.bKo = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bKk != null && !StringUtils.isNull(i.this.bKk.threadData.rG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bKk.threadData.rG(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.aoe != null) {
                        i.this.aoe.onClick(view);
                    }
                }
            }
        };
        this.aby = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.bKl = view.findViewById(d.h.layout_root);
        this.bhp = view.findViewById(d.h.divider_line);
        this.blv = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_ala_video_user_info_layout);
        this.bJt = new com.baidu.tbadk.core.view.h(this.aby);
        this.bJt.wI();
        this.bJt.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.blv.addView(this.bJt);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bKm = (RelativeLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKm.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.ad(this.aby.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.aby.getPageActivity(), d.f.ds68);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bKm.setLayoutParams(layoutParams);
        this.bHE = (TbImageView) view.findViewById(d.h.image_video);
        this.bHE.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bHE.setDefaultResource(0);
        this.bHE.setDefaultErrorResource(0);
        this.bHF = (ImageView) view.findViewById(d.h.image_video_play);
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.blz.setOnClickListener(this);
        this.blz.setReplyTimeVisible(false);
        this.blz.setShowPraiseNum(false);
        this.blz.setNeedAddPraiseIcon(false);
        this.blz.setNeedAddReplyIcon(false);
        this.blz.setCommentNumEnable(false);
        this.blz.setLiveShareEnable(true);
        this.blz.setLiveAudienceEnable(true);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blz.setLiveShareIcon(d.g.icon_home_card_share_n);
        this.blz.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.blz.setFrom(1);
        this.bJs = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bKl.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bKl, d.g.addresslist_item_bg);
            aj.k(this.bhp, d.e.cp_bg_line_c);
            aj.i(this.mTextTitle, d.e.cp_cont_b);
            aj.c(this.bHF, d.g.btn_icon_play_live);
            aj.k(this.bKm, d.e.cp_bg_line_k);
            this.blv.onChangeSkinType();
            this.blz.onChangeSkinType();
            if (this.bJt != null) {
                this.bJt.onChangeSkinType();
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
        this.bKk = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bKk == null || this.bKk.MR() == null) {
            this.bKl.setVisibility(8);
            return;
        }
        this.bKl.setVisibility(0);
        this.blv.c(this.bKk.MR());
        this.blv.setUserAfterClickListener(this.aow);
        if (this.blv.getHeaderImg() != null) {
            this.blv.getHeaderImg().setData(this.bKk.MR());
        }
        this.bKk.MR().sj();
        String string = this.aby.getResources().getString(d.l.ala_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bKk.MR().sb()));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.blz.c(this.bKk.threadData)) {
            this.bJs.setVisibility(8);
        } else {
            this.bJs.setVisibility(0);
        }
        if (this.bJt != null && this.bKk.MR() != null) {
            an anVar = new an();
            anVar.cy(this.bKk.MR().getTid());
            anVar.setFid(this.bKk.MR().getFid());
            anVar.a(this.bKk.Xf);
            this.bJt.setData(anVar);
            this.bJt.setFirstRowSingleColumn(true);
        }
        d(this.aby, TbadkCoreApplication.getInst().getSkinType());
        if (m.jt(this.bKk.threadData.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        XH();
    }

    public void XH() {
        if (com.baidu.tbadk.core.h.oS().oY() && this.bKk != null && this.bKk.MR() != null && this.bKk.MR().rT() != null) {
            this.bHE.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.bHE.c(this.bKk.MR().rT().cover, 10, false);
            this.bKm.setVisibility(0);
            return;
        }
        this.bKm.setVisibility(8);
    }

    public void a(h.a aVar) {
        if (this.bJt != null) {
            this.bJt.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bKl) {
            ad(view);
        }
    }

    private void ad(View view) {
        if (XA() != null) {
            XA().a(view, this.bKk);
        }
        if (this.bKk != null && this.bKk.MR() != null && this.bKk.MR().rT() != null) {
            m.js(this.bKk.threadData.getId());
            m.a(this.mTextTitle, this.bKk.threadData.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bKk.MR().rT());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.aby.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.blz != null && this.bKn != null) {
            if (this.blv != null) {
                this.blv.setPageUniqueId(bdUniqueId);
            }
            this.bKn.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bJt != null) {
                this.bJt.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bKn);
        }
    }
}
