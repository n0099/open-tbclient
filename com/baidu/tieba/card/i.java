package com.baidu.tieba.card;

import android.content.Context;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes.dex */
public class i extends a<com.baidu.tieba.card.data.k> {
    private TbPageContext<?> abz;
    private View.OnClickListener anJ;
    private View.OnClickListener anr;
    public View aod;
    private com.baidu.tieba.NEGFeedBack.c bJx;
    private com.baidu.tieba.card.data.k bKq;
    public View bKr;
    public RelativeLayout bKs;
    public TbImageView bKt;
    public ImageView bKu;
    private TextView bKv;
    private View bKw;
    private AlaPlayAnimationView bKx;
    private CustomMessageListener bKy;
    private View.OnClickListener bKz;
    private ThreadUserInfoLayout bnf;
    public ThreadCommentAndPraiseInfoLayout bnj;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJx = null;
        this.anJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Xr() != null) {
                    i.this.Xr().a(view, i.this.bKq);
                }
            }
        };
        this.anr = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Xr() != null) {
                    i.this.Xr().a(view, i.this.bKq);
                }
            }
        };
        this.bKy = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bKq != null && i.this.bKq.threadData != null && i.this.bKq.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bKq.threadData.getTid())) {
                    m.a(i.this.mTextTitle, i.this.bKq.threadData.getId(), d.e.cp_cont_d, d.e.cp_cont_d);
                }
            }
        };
        this.bKz = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bKq != null && !StringUtils.isNull(i.this.bKq.threadData.rA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bKq.threadData.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.anr != null) {
                        i.this.anr.onClick(view);
                    }
                }
            }
        };
        this.abz = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.bKr = view.findViewById(d.h.layout_root);
        this.aod = view.findViewById(d.h.divider_line);
        this.bnf = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_ala_video_user_info_layout);
        this.bJx = new com.baidu.tieba.NEGFeedBack.c(this.abz);
        this.bJx.Kr();
        this.bJx.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bnf.addView(this.bJx);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bKs = (RelativeLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bKs.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.ad(this.abz.getPageActivity()) - com.baidu.adp.lib.util.l.f(this.abz.getPageActivity(), d.f.ds68);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bKs.setLayoutParams(layoutParams);
        this.bKt = (TbImageView) view.findViewById(d.h.image_video);
        this.bKt.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bKt.setDefaultResource(0);
        this.bKt.setDefaultErrorResource(0);
        this.bKx = (AlaPlayAnimationView) view.findViewById(d.h.ala_play);
        this.bKu = (ImageView) view.findViewById(d.h.image_video_play);
        this.bnj = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.bnj.setOnClickListener(this);
        this.bnj.setReplyTimeVisible(false);
        this.bnj.setShowPraiseNum(true);
        this.bnj.setNeedAddPraiseIcon(true);
        this.bnj.setCommentNumEnable(false);
        this.bnj.setLiveAudienceEnable(false);
        this.bnj.setShareVisible(true);
        this.bnj.setFrom(1);
        this.bKv = (TextView) view.findViewById(d.h.play_count);
        this.bKw = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bKr.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bKr, d.g.addresslist_item_bg);
            aj.k(this.aod, d.e.cp_bg_line_e);
            aj.i(this.mTextTitle, d.e.cp_cont_b);
            aj.i(this.bKv, d.e.cp_cont_i);
            aj.c(this.bKu, d.g.btn_icon_play_live_on_n);
            aj.k(this.bKs, d.e.cp_bg_line_k);
            this.bnf.onChangeSkinType();
            this.bnj.onChangeSkinType();
            if (this.bJx != null) {
                this.bJx.onChangeSkinType();
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
        this.bKq = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bKq == null || this.bKq.Nj() == null) {
            this.bKr.setVisibility(8);
            return;
        }
        this.bKr.setVisibility(0);
        this.bnf.setData(this.bKq.Nj());
        this.bnf.setUserAfterClickListener(this.anJ);
        if (this.bnf.getHeaderImg() != null) {
            this.bnf.getHeaderImg().setData(this.bKq.Nj());
        }
        this.bKq.Nj().sd();
        this.mTextTitle.setText(new SpannableStringBuilder(this.bKq.Nj().rV()));
        if (this.bnj.setData(this.bKq.threadData)) {
            this.bKw.setVisibility(8);
        } else {
            this.bKw.setVisibility(0);
        }
        this.bKv.setText(String.format(this.abz.getResources().getString(d.l.ala_audience_count_prefix), am.z(this.bKq.threadData.rN().audience_count)));
        if (this.bJx != null && this.bKq.Nj() != null) {
            al alVar = new al();
            alVar.cy(this.bKq.Nj().getTid());
            alVar.setFid(this.bKq.Nj().getFid());
            alVar.a(this.bKq.Xg);
            this.bJx.setData(alVar);
            this.bJx.setFirstRowSingleColumn(true);
        }
        d(this.abz, TbadkCoreApplication.getInst().getSkinType());
        if (m.jn(this.bKq.threadData.getId())) {
            aj.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        Xy();
        this.bKx.XT();
    }

    public void Xy() {
        if (com.baidu.tbadk.core.h.oT().oZ() && this.bKq != null && this.bKq.Nj() != null && this.bKq.Nj().rN() != null) {
            this.bKt.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.bKt.c(this.bKq.Nj().rN().cover, 10, false);
            this.bKs.setVisibility(0);
            return;
        }
        this.bKs.setVisibility(8);
    }

    public void a(c.a aVar) {
        if (this.bJx != null) {
            this.bJx.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bKr) {
            ac(view);
        }
    }

    private void ac(View view) {
        if (Xr() != null) {
            Xr().a(view, this.bKq);
        }
        if (this.bKq != null && this.bKq.Nj() != null && this.bKq.Nj().rN() != null) {
            m.jm(this.bKq.threadData.getId());
            m.a(this.mTextTitle, this.bKq.threadData.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bKq.Nj().rN());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.abz.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bnj != null && this.bKy != null) {
            if (this.bnf != null) {
                this.bnf.setPageUniqueId(bdUniqueId);
            }
            this.bKy.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bJx != null) {
                this.bJx.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bKy);
        }
    }
}
