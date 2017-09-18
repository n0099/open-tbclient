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
    private View.OnClickListener aoc;
    private View.OnClickListener aou;
    public TbImageView bIv;
    public ImageView bIw;
    private View bKj;
    private com.baidu.tbadk.core.view.h bKk;
    private com.baidu.tieba.card.data.k bLb;
    public View bLc;
    public RelativeLayout bLd;
    private CustomMessageListener bLe;
    private View.OnClickListener bLf;
    public View bhm;
    private ThreadUserInfoLayout blu;
    public ThreadCommentAndPraiseInfoLayout bly;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bKk = null;
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.XL() != null) {
                    i.this.XL().a(view, i.this.bLb);
                }
            }
        };
        this.aoc = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.XL() != null) {
                    i.this.XL().a(view, i.this.bLb);
                }
            }
        };
        this.bLe = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bLb != null && i.this.bLb.threadData != null && i.this.bLb.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bLb.threadData.getTid())) {
                    m.a(i.this.mTextTitle, i.this.bLb.threadData.getId(), d.e.cp_cont_d, d.e.cp_cont_d);
                }
            }
        };
        this.bLf = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bLb != null && !StringUtils.isNull(i.this.bLb.threadData.rG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bLb.threadData.rG(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.aoc != null) {
                        i.this.aoc.onClick(view);
                    }
                }
            }
        };
        this.aby = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.bLc = view.findViewById(d.h.layout_root);
        this.bhm = view.findViewById(d.h.divider_line);
        this.blu = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_ala_video_user_info_layout);
        this.bKk = new com.baidu.tbadk.core.view.h(this.aby);
        this.bKk.wI();
        this.bKk.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.blu.addView(this.bKk);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bLd = (RelativeLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLd.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.ae(this.aby.getPageActivity()) - com.baidu.adp.lib.util.k.f(this.aby.getPageActivity(), d.f.ds68);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bLd.setLayoutParams(layoutParams);
        this.bIv = (TbImageView) view.findViewById(d.h.image_video);
        this.bIv.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bIv.setDefaultResource(0);
        this.bIv.setDefaultErrorResource(0);
        this.bIw = (ImageView) view.findViewById(d.h.image_video_play);
        this.bly = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bly.setOnClickListener(this);
        this.bly.setReplyTimeVisible(false);
        this.bly.setShowPraiseNum(false);
        this.bly.setNeedAddPraiseIcon(false);
        this.bly.setNeedAddReplyIcon(false);
        this.bly.setCommentNumEnable(false);
        this.bly.setLiveShareEnable(true);
        this.bly.setLiveAudienceEnable(true);
        this.bly.setReplyIcon(d.g.icon_home_card_comment_n);
        this.bly.setLiveShareIcon(d.g.icon_home_card_share_n);
        this.bly.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.bly.setFrom(1);
        this.bKj = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bLc.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bLc, d.g.addresslist_item_bg);
            aj.k(this.bhm, d.e.cp_bg_line_c);
            aj.i(this.mTextTitle, d.e.cp_cont_b);
            aj.c(this.bIw, d.g.btn_icon_play_live);
            aj.k(this.bLd, d.e.cp_bg_line_k);
            this.blu.onChangeSkinType();
            this.bly.onChangeSkinType();
            if (this.bKk != null) {
                this.bKk.onChangeSkinType();
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
        this.bLb = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bLb == null || this.bLb.MR() == null) {
            this.bLc.setVisibility(8);
            return;
        }
        this.bLc.setVisibility(0);
        this.blu.c(this.bLb.MR());
        this.blu.setUserAfterClickListener(this.aou);
        if (this.blu.getHeaderImg() != null) {
            this.blu.getHeaderImg().setData(this.bLb.MR());
        }
        this.bLb.MR().sj();
        String string = this.aby.getResources().getString(d.l.ala_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bLb.MR().sb()));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.bly.c(this.bLb.threadData)) {
            this.bKj.setVisibility(8);
        } else {
            this.bKj.setVisibility(0);
        }
        if (this.bKk != null && this.bLb.MR() != null) {
            an anVar = new an();
            anVar.cy(this.bLb.MR().getTid());
            anVar.setFid(this.bLb.MR().getFid());
            anVar.a(this.bLb.Xf);
            this.bKk.setData(anVar);
            this.bKk.setFirstRowSingleColumn(true);
        }
        d(this.aby, TbadkCoreApplication.getInst().getSkinType());
        if (m.jv(this.bLb.threadData.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        XS();
    }

    public void XS() {
        if (com.baidu.tbadk.core.h.oS().oY() && this.bLb != null && this.bLb.MR() != null && this.bLb.MR().rT() != null) {
            this.bIv.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.bIv.c(this.bLb.MR().rT().cover, 10, false);
            this.bLd.setVisibility(0);
            return;
        }
        this.bLd.setVisibility(8);
    }

    public void a(h.a aVar) {
        if (this.bKk != null) {
            this.bKk.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLc) {
            ad(view);
        }
    }

    private void ad(View view) {
        if (XL() != null) {
            XL().a(view, this.bLb);
        }
        if (this.bLb != null && this.bLb.MR() != null && this.bLb.MR().rT() != null) {
            m.ju(this.bLb.threadData.getId());
            m.a(this.mTextTitle, this.bLb.threadData.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bLb.MR().rT());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.aby.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bly != null && this.bLe != null) {
            if (this.blu != null) {
                this.blu.setPageUniqueId(bdUniqueId);
            }
            this.bLe.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bKk != null) {
                this.bKk.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bLe);
        }
    }
}
