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
    public TbImageView bEK;
    public ImageView bEL;
    private View bGy;
    private com.baidu.tbadk.core.view.h bGz;
    private com.baidu.tieba.card.data.k bHr;
    public View bHs;
    public RelativeLayout bHt;
    private CustomMessageListener bHu;
    public View bhk;
    private ThreadUserInfoLayout bla;
    public ThreadCommentAndPraiseInfoLayout ble;
    public TextView mTextTitle;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGz = null;
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Wx() != null) {
                    i.this.Wx().a(view, i.this.bHr);
                }
            }
        };
        this.aoH = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.Wx() != null) {
                    i.this.Wx().a(view, i.this.bHr);
                }
            }
        };
        this.bHu = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.card.i.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && i.this.bHr != null && i.this.bHr.threadData != null && i.this.bHr.threadData.getTid() != null && i.this.mTextTitle != null && ((String) customResponsedMessage.getData()).equals(i.this.bHr.threadData.getTid())) {
                    m.a(i.this.mTextTitle, i.this.bHr.threadData.getId(), d.e.cp_cont_d, d.e.cp_cont_d);
                }
            }
        };
        this.aoN = new View.OnClickListener() { // from class: com.baidu.tieba.card.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.bHr != null && !StringUtils.isNull(i.this.bHr.threadData.rL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(i.this.getContext()).createNormalCfg(i.this.bHr.threadData.rL(), FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    if (i.this.aoH != null) {
                        i.this.aoH.onClick(view);
                    }
                }
            }
        };
        this.acr = tbPageContext;
        init(getView());
    }

    private void init(View view) {
        this.bHs = view.findViewById(d.h.layout_root);
        this.bhk = view.findViewById(d.h.divider_line);
        this.bla = (ThreadUserInfoLayout) view.findViewById(d.h.card_home_page_ala_video_user_info_layout);
        this.bGz = new com.baidu.tbadk.core.view.h(this.acr);
        this.bGz.wL();
        this.bGz.setLeftPadding((int) getContext().getResources().getDimension(d.f.ds60));
        this.bla.addView(this.bGz);
        this.mTextTitle = (TextView) view.findViewById(d.h.text_title);
        this.bHt = (RelativeLayout) view.findViewById(d.h.frame_video);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHt.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.k.ag(this.acr.getPageActivity()) - com.baidu.adp.lib.util.k.g(this.acr.getPageActivity(), d.f.ds68);
        layoutParams.height = (layoutParams.width * 9) / 16;
        this.bHt.setLayoutParams(layoutParams);
        this.bEK = (TbImageView) view.findViewById(d.h.image_video);
        this.bEK.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bEK.setDefaultResource(0);
        this.bEK.setDefaultErrorResource(0);
        this.bEL = (ImageView) view.findViewById(d.h.image_video_play);
        this.ble = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.text_bottom);
        this.ble.setOnClickListener(this);
        this.ble.setReplyTimeVisible(false);
        this.ble.setShowPraiseNum(false);
        this.ble.setNeedAddPraiseIcon(false);
        this.ble.setNeedAddReplyIcon(false);
        this.ble.setCommentNumEnable(false);
        this.ble.setLiveShareEnable(true);
        this.ble.setLiveAudienceEnable(true);
        this.ble.setReplyIcon(d.g.icon_home_card_comment_n);
        this.ble.setLiveShareIcon(d.g.icon_home_card_share_n);
        this.ble.setLiveAudienceIcon(d.g.icon_home_card_live_n);
        this.ble.setFrom(1);
        this.bGy = view.findViewById(d.h.divider_below_reply_number_layout);
        this.bHs.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.bHs, d.g.addresslist_item_bg);
            ai.k(this.bhk, d.e.cp_bg_line_c);
            ai.i(this.mTextTitle, d.e.cp_cont_b);
            ai.c(this.bEL, d.g.btn_icon_play_live);
            ai.k(this.bHt, d.e.cp_bg_line_k);
            this.bla.onChangeSkinType();
            this.ble.onChangeSkinType();
            if (this.bGz != null) {
                this.bGz.onChangeSkinType();
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
        this.bHr = kVar;
        refreshView();
    }

    private void refreshView() {
        if (this.bHr == null || this.bHr.MF() == null) {
            this.bHs.setVisibility(8);
            return;
        }
        this.bHs.setVisibility(0);
        this.bla.a(this.bHr.MF());
        this.bla.setUserAfterClickListener(this.aoX);
        if (this.bla.getHeaderImg() != null) {
            this.bla.getHeaderImg().setData(this.bHr.MF());
        }
        this.bHr.MF().so();
        String string = this.acr.getResources().getString(d.l.ala_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + ((Object) this.bHr.MF().sg()));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_c)), 0, string.length(), 33);
        this.mTextTitle.setText(spannableStringBuilder);
        if (this.ble.a(this.bHr.threadData)) {
            this.bGy.setVisibility(8);
        } else {
            this.bGy.setVisibility(0);
        }
        if (this.bGz != null && this.bHr.MF() != null) {
            an anVar = new an();
            anVar.cI(this.bHr.MF().getTid());
            anVar.setFid(this.bHr.MF().getFid());
            anVar.a(this.bHr.XW);
            this.bGz.setData(anVar);
            this.bGz.setFirstRowSingleColumn(true);
        }
        d(this.acr, TbadkCoreApplication.getInst().getSkinType());
        if (m.ji(this.bHr.threadData.getId())) {
            ai.c(this.mTextTitle, d.e.cp_cont_d, 1);
        } else {
            ai.c(this.mTextTitle, d.e.cp_cont_b, 1);
        }
        WE();
    }

    public void WE() {
        if (com.baidu.tbadk.core.h.oY().pe() && this.bHr != null && this.bHr.MF() != null && this.bHr.MF().rY() != null) {
            this.bEK.setDefaultBgResource(d.g.pic_bg_video_frs);
            this.bEK.c(this.bHr.MF().rY().cover, 10, false);
            this.bHt.setVisibility(0);
            return;
        }
        this.bHt.setVisibility(8);
    }

    public void a(h.a aVar) {
        if (this.bGz != null) {
            this.bGz.setEventCallback(aVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bHs) {
            V(view);
        }
    }

    private void V(View view) {
        if (Wx() != null) {
            Wx().a(view, this.bHr);
        }
        if (this.bHr != null && this.bHr.MF() != null && this.bHr.MF().rY() != null) {
            m.jh(this.bHr.threadData.getId());
            m.a(this.mTextTitle, this.bHr.threadData.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(this.bHr.MF().rY());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig((Context) this.acr.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_REC_PLAY, "", false, "")));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.ble != null && this.bHu != null) {
            if (this.bla != null) {
                this.bla.setPageUniqueId(bdUniqueId);
            }
            this.bHu.setTag(bdUniqueId);
            setTag(bdUniqueId);
            if (this.bGz != null) {
                this.bGz.setUniqueId(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bHu);
        }
    }
}
