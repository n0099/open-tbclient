package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.o;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> implements com.baidu.tieba.a.e {
    private final View.OnClickListener axL;
    private String bHB;
    public ThreadUserInfoLayout bHN;
    public ThreadCommentAndPraiseInfoLayout bHO;
    public ThreadSourceShareAndPraiseLayout bIC;
    protected LinearLayout bIN;
    protected bb buy;
    private com.baidu.tbadk.core.view.userLike.c cyq;
    private View dKy;
    private TextView dTS;
    public ConcernUserLikeButton dTT;
    private View dTU;
    public LinearLayout dTV;
    protected com.baidu.tieba.homepage.concern.b.b dTW;
    protected boolean dTX;
    private View.OnClickListener dTY;
    protected View.OnClickListener dTZ;
    private final View.OnClickListener dUa;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void af(bb bbVar);

    protected abstract void ah(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dTX = true;
        this.dTY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiC() != null) {
                    d.this.aiC().a(view, d.this.dTW);
                }
                if (d.this.dTW != null && !StringUtils.isNull(d.this.dTW.dTD.getName()) && !StringUtils.isNull(d.this.dTW.dTD.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dTW.dTD.getUserId(), 0L), false, d.this.dTW.dTD.isGod())));
                }
            }
        };
        this.dTZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiC() != null) {
                    d.this.aiC().a(view, d.this.dTW);
                }
                d.this.aiV();
            }
        };
        this.axL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.aiC() != null) {
                    d.this.aiC().a(view, d.this.dTW);
                }
            }
        };
        this.dUa = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == f.g.thread_info_commont_container && d.this.buy != null) {
                    o.kY(d.this.buy.getId());
                    d.this.aiH();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.dTS = (TextView) view.findViewById(f.g.card_recommend_god_reason);
        this.dTT = (ConcernUserLikeButton) view.findViewById(f.g.card_recommend_god_user_like_btn);
        this.bHN = (ThreadUserInfoLayout) view.findViewById(f.g.card_rec_god_user_info);
        this.cyq = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dTT);
        this.bHN.setTShowVisible(false);
        this.bHN.getHeaderImg().setAfterClickListener(this.axL);
        this.dTT.setAfterOnClickListener(this.axL);
        this.dKy = view.findViewById(f.g.card_recommend_god_divide_line);
        this.dTU = view.findViewById(f.g.divider_line);
        this.dTV = (LinearLayout) view.findViewById(f.g.card_recommend_god_content);
        this.dTV.setOnClickListener(this.dTY);
        this.mTitle = (TextView) view.findViewById(f.g.card_recommend_god_therad_title);
        this.bHO = (ThreadCommentAndPraiseInfoLayout) view.findViewById(f.g.card_recommend_god_therad_info_layout);
        this.bHO.setOnClickListener(this.dTZ);
        this.bHO.setReplyTimeVisible(false);
        this.bHO.setIsBarViewVisible(false);
        this.bHO.setShowPraiseNum(true);
        this.bHO.setNeedAddPraiseIcon(true);
        this.bHO.setNeedAddReplyIcon(true);
        this.bHO.setShareVisible(true);
        this.bHO.ajY = this.currentPageType;
        this.bHO.setForumAfterClickListener(this.dUa);
        this.bHO.setShareReportFrom(4);
        this.bHO.setFrom(9);
        this.bIC = (ThreadSourceShareAndPraiseLayout) view.findViewById(f.g.card_concern_god_source_read_share_layout);
        this.bIC.ayo.setOnClickListener(this.dTZ);
        this.bIC.ayo.ajY = this.currentPageType;
        this.bIC.ayo.setForumAfterClickListener(this.dUa);
        this.bIC.setShareReportFrom(4);
        this.bIC.setFrom(9);
        this.bIN = (LinearLayout) view.findViewById(f.g.card_recommend_god_therad_content_layout);
        ah(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cyq.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.addresslist_item_bg);
            am.h(this.dTS, f.d.cp_cont_d);
            am.j(this.dKy, f.d.cp_bg_line_e);
            am.j(this.dTU, f.d.cp_bg_line_e);
            this.dTT.onChangeSkinType(i);
            this.bHO.onChangeSkinType();
            this.bIC.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.dTD != null && !StringUtils.isNull(bVar.dTD.getName()) && !StringUtils.isNull(bVar.dTD.getUserId()) && !StringUtils.isNull(bVar.dbw.getTid())) {
            this.dTW = bVar;
            if (this.bHN != null) {
                this.bHN.setData(bVar.dbw);
                if (this.bHN.getHeaderImg() != null) {
                    this.bHN.getHeaderImg().setData(bVar.metaData);
                }
                this.bHN.onChangeSkinType();
            }
            this.cyq.a(this.dTW.metaData);
            String aDq = this.dTW.dTD.aDq();
            if (StringUtils.isNull(aDq)) {
                this.dTS.setVisibility(8);
            } else {
                this.dTS.setVisibility(0);
                this.dTS.setText(aDq);
            }
            this.buy = bVar.dbw;
            if (o.kZ(this.buy.getId())) {
                aiH();
            }
            this.bHO.setData(this.buy);
            o.b(this.buy, this.mTitle);
            this.dTX = true;
            if ((StringUtils.isNull(this.buy.getTitle()) && (this.buy.vh() == null || this.buy.vh().size() == 0)) || this.buy.vz() == 1) {
                this.buy.e(false, true);
                if (this.buy.vI() == null || StringUtils.isNull(this.buy.vI().toString())) {
                    this.dTX = false;
                }
            }
            af(this.buy);
            hm(gt(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.dTT != null) {
            this.dTT.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiH() {
        o.a(this.mTitle, this.buy.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiV() {
        if (this.dTW != null && this.buy != null) {
            o.kY(this.buy.getId());
            aiH();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.buy.getId(), this.buy.vA(), o.uX(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void hm(int i) {
        if (this.buy != null) {
            if (i == 1) {
                this.bHO.setVisibility(8);
                this.bIC.setData(this.buy);
                this.bHN.showForumNameView(false);
                return;
            }
            this.bHO.setData(this.buy);
            this.bIC.setVisibility(8);
            this.bHN.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.bHB = str;
    }

    public int gt(int i) {
        return com.baidu.tieba.a.d.QN().G(this.bHB, i);
    }
}
