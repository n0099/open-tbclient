package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class c extends a<com.baidu.tieba.card.data.k> {
    private final View.OnClickListener bec;
    private ThreadGodReplyLayout cVG;
    private View cVH;
    protected com.baidu.tieba.card.data.k cVI;
    private View.OnClickListener cVJ;
    private HeadPendantClickableView cmU;
    public ThreadSourceShareAndPraiseLayout cmX;
    public ThreadUserInfoLayout cmj;
    public ThreadCommentAndPraiseInfoLayout cmk;
    private com.baidu.tieba.NEGFeedBack.c cmv;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    protected abstract void b(com.baidu.tieba.card.data.k kVar);

    protected abstract void by(View view);

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cmv = null;
        this.mSkinType = 3;
        this.cVJ = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view, c.this.cVI);
                }
                c.this.eI(view == c.this.cVG);
            }
        };
        this.bec = new View.OnClickListener() { // from class: com.baidu.tieba.card.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view, c.this.cVI);
                }
            }
        };
        View view = getView();
        this.mPageContext = tbPageContext;
        this.cmU = (HeadPendantClickableView) view.findViewById(d.g.card_home_page_normal_thread_user_pendant_header);
        if (this.cmU.getHeadView() != null) {
            this.cmU.getHeadView().setIsRound(true);
            this.cmU.getHeadView().setDrawBorder(false);
            this.cmU.getHeadView().setDefaultResource(17170445);
            this.cmU.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.cmU.getHeadView().setDefaultBgResource(d.C0140d.cp_bg_line_e);
            this.cmU.getHeadView().setRadius(com.baidu.adp.lib.util.l.t(this.mPageContext.getPageActivity(), d.e.ds70));
        }
        this.cmU.DT();
        if (this.cmU.getPendantView() != null) {
            this.cmU.getPendantView().setIsRound(true);
            this.cmU.getPendantView().setDrawBorder(false);
        }
        this.cmk = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.cmj = (ThreadUserInfoLayout) view.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        this.cmv = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
        this.cmv.a((ViewGroup) this.cmU.getParent(), com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds120), 0);
        if (this.cmk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmk.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.cmk.setLayoutParams(layoutParams);
        }
        this.cVH = view.findViewById(d.g.divider_line);
        this.cmk.setOnClickListener(this.cVJ);
        this.cmk.setReplyTimeVisible(false);
        this.cmk.setShowPraiseNum(true);
        this.cmk.setNeedAddPraiseIcon(true);
        this.cmk.setNeedAddReplyIcon(true);
        this.cmk.setShareVisible(true);
        this.cmk.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view2, c.this.cVI);
                }
                if (c.this.cVI != null && c.this.cVI.threadData != null) {
                    j.kr(c.this.cVI.threadData.getId());
                    if (!c.this.akT()) {
                        c.this.akU();
                    }
                }
            }
        });
        this.cmX = (ThreadSourceShareAndPraiseLayout) view.findViewById(d.g.card_link_thread_source_read_share_layout);
        this.cmX.bez.setOnClickListener(this.cVJ);
        this.cmX.setShareReportFrom(3);
        this.cmX.setForumAfterClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.akP() != null) {
                    c.this.akP().a(view2, c.this.cVI);
                }
                if (c.this.cVI != null && c.this.cVI.threadData != null && view2 != c.this.cmX.bey) {
                    j.kr(c.this.cVI.threadData.getId());
                    if (!c.this.akT()) {
                        c.this.akU();
                    }
                }
            }
        });
        this.cVG = (ThreadGodReplyLayout) view.findViewById(d.g.card_home_page_god_reply_layout);
        this.cVG.setOnClickListener(this.cVJ);
        by(view);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.addresslist_item_bg);
            this.cmk.onChangeSkinType();
            this.cVG.onChangeSkinType();
            this.cmj.onChangeSkinType();
            if (this.cmv != null) {
                this.cmv.onChangeSkinType();
            }
            aj.t(this.cVH, d.C0140d.cp_bg_line_c);
            this.cmX.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.k kVar) {
        if (kVar == null || kVar.threadData == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.cVI = kVar;
        if (getView() != null) {
            getView().setVisibility(0);
            getView().setOnClickListener(this.cVJ);
        }
        if (this.cmv != null && this.cVI.WE() != null && kVar.threadData.zn() != null && !StringUtils.isNull(kVar.threadData.zn().getUserId())) {
            if (kVar.threadData.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.cmv.setVisibility(8);
            } else {
                this.cmv.setVisibility(0);
                ah ahVar = new ah();
                ahVar.cV(this.cVI.WE().getTid());
                ahVar.setFid(this.cVI.WE().getFid());
                ahVar.a(this.cVI.aNr);
                this.cmv.setData(ahVar);
                this.cmv.setFirstRowSingleColumn(true);
            }
        }
        this.cmj.setData(kVar.threadData);
        this.cVG.setData(kVar.threadData.AA());
        if (!akT() && j.ks(this.cVI.threadData.getId())) {
            akU();
        }
        this.cmj.setUserAfterClickListener(this.bec);
        bd WE = kVar.WE();
        if (this.cmj.getHeaderImg() != null) {
            if (this.cmj.getIsSimpleThread()) {
                this.cmj.getHeaderImg().setVisibility(8);
                this.cmU.setVisibility(8);
            } else if (WE.zn() == null || WE.zn().getPendantData() == null || StringUtils.isNull(WE.zn().getPendantData().ya())) {
                this.cmU.setVisibility(8);
                this.cmj.getHeaderImg().setVisibility(0);
                this.cmj.getHeaderImg().setData(WE);
            } else {
                this.cmj.getHeaderImg().setVisibility(4);
                this.cmU.setVisibility(0);
                this.cmU.setData(WE);
            }
        }
        b(kVar);
        jX(kVar.threadData.aQz);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cmv != null) {
            this.cmv.setUniqueId(bdUniqueId);
        }
        if (this.cmj != null) {
            this.cmj.setPageUniqueId(bdUniqueId);
        }
    }

    public View akR() {
        return this.cVG;
    }

    public void a(c.a aVar) {
        if (this.cmv != null) {
            this.cmv.setEventCallback(aVar);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.cmj != null) {
            return this.cmj.bdX;
        }
        return null;
    }

    public View akS() {
        if (this.cmj != null) {
            return this.cmj.bdY;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(boolean z) {
        if (this.cVI != null && this.cVI.threadData != null) {
            if (!akT()) {
                j.kr(this.cVI.threadData.getId());
                akU();
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(this.cVI.threadData, null, j.zd(), 18003, true, false, false).addLocateParam(this.cVI.alC());
            addLocateParam.setForumId(String.valueOf(this.cVI.threadData.getFid()));
            addLocateParam.setStartFrom(this.currentPageType);
            if (z) {
                addLocateParam.setJumpGodReply(true);
            }
            this.mPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akT() {
        return this.cVI.dal && !this.cVI.btQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akU() {
        j.a(this.cVG.getGodReplyContent(), this.cVI.threadData.getId(), d.C0140d.cp_cont_f, d.C0140d.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void jX(int i) {
        if (this.cVI != null && this.cVI.threadData != null) {
            if (i == 1) {
                this.cmk.setVisibility(8);
                this.cmX.setData(this.cVI.threadData);
                this.cmj.showForumNameView(false);
                return;
            }
            this.cmk.setData(this.cVI.threadData);
            this.cmX.setVisibility(8);
            this.cmj.showForumNameView(true);
        }
    }
}
