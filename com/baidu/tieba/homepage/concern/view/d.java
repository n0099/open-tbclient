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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> {
    private TextView anQ;
    private TextView ant;
    private final View.OnClickListener anx;
    private com.baidu.tbadk.core.view.userLike.c bJP;
    protected bh bie;
    public ThreadCommentAndPraiseInfoLayout bmV;
    protected LinearLayout bmZ;
    public ClickableHeaderImageView cKp;
    private View cUK;
    public LinearLayout cWA;
    protected com.baidu.tieba.homepage.concern.b.b cWB;
    protected boolean cWC;
    private View.OnClickListener cWD;
    protected View.OnClickListener cWE;
    private TextView cWx;
    public ConcernUserLikeButton cWy;
    private View cWz;
    protected TbPageContext<?> mH;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void Q(bh bhVar);

    protected abstract void aa(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cWC = false;
        this.cWD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Xn() != null) {
                    d.this.Xn().a(view, d.this.cWB);
                }
                if (d.this.cWB != null && !StringUtils.isNull(d.this.cWB.cWj.getName()) && !StringUtils.isNull(d.this.cWB.cWj.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mH.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.cWB.cWj.getUserId(), 0L), false, d.this.cWB.cWj.isGod())));
                }
            }
        };
        this.cWE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Xn() != null) {
                    d.this.Xn().a(view, d.this.cWB);
                }
                d.this.XF();
            }
        };
        this.anx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.Xn() != null) {
                    d.this.Xn().a(view, d.this.cWB);
                }
            }
        };
        View view = getView();
        this.mH = tbPageContext;
        this.cWx = (TextView) view.findViewById(d.h.card_recommend_god_reason);
        this.cKp = (ClickableHeaderImageView) view.findViewById(d.h.card_recommend_god_header_view);
        this.cKp.setAfterClickListener(this.anx);
        this.ant = (TextView) view.findViewById(d.h.card_recommend_god_name);
        this.anQ = (TextView) view.findViewById(d.h.card_recommend_god_rec_intro);
        this.cWy = (ConcernUserLikeButton) view.findViewById(d.h.card_recommend_god_user_like_btn);
        this.bJP = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cWy);
        this.cWy.setAfterOnClickListener(this.anx);
        this.cWz = view.findViewById(d.h.card_recommend_god_divide_line);
        this.cUK = view.findViewById(d.h.divider_line);
        this.cWA = (LinearLayout) view.findViewById(d.h.card_recommend_god_content);
        this.cWA.setOnClickListener(this.cWD);
        this.mTitle = (TextView) view.findViewById(d.h.card_recommend_god_therad_title);
        this.bmV = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_recommend_god_therad_info_layout);
        if (this.bmV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmV.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bmV.setLayoutParams(layoutParams);
        }
        this.bmV.setOnClickListener(this.cWE);
        this.bmV.setReplyTimeVisible(false);
        this.bmV.setIsBarViewVisible(false);
        this.bmV.setShowPraiseNum(true);
        this.bmV.setNeedAddPraiseIcon(true);
        this.bmV.setNeedAddReplyIcon(true);
        this.bmV.setShareVisible(true);
        this.bmZ = (LinearLayout) view.findViewById(d.h.card_recommend_god_therad_content_layout);
        aa(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.bJP.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.i(this.ant, d.e.cp_cont_h);
            aj.i(this.anQ, d.e.cp_cont_d);
            aj.i(this.cWx, d.e.cp_cont_j);
            aj.k(this.cWz, d.e.cp_bg_line_e);
            aj.k(this.cUK, d.e.cp_bg_line_e);
            this.cWy.onChangeSkinType(i);
            this.bmV.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.cWj != null && !StringUtils.isNull(bVar.cWj.getName()) && !StringUtils.isNull(bVar.cWj.getUserId()) && !StringUtils.isNull(bVar.beM.getTid())) {
            this.cWB = bVar;
            this.cKp.setData(this.cWB.metaData);
            this.cKp.setIsRound(true);
            this.ant.setText(this.cWB.cWj.getName());
            this.anQ.setText(this.cWB.cWj.getIntro());
            this.bJP.a(this.cWB.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWA.getLayoutParams();
            String aoW = this.cWB.cWj.aoW();
            if (StringUtils.isNull(aoW)) {
                this.cWx.setVisibility(8);
                layoutParams.topMargin = 0;
                this.cWA.setLayoutParams(layoutParams);
            } else {
                this.cWx.setVisibility(0);
                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(d.f.ds28);
                this.cWA.setLayoutParams(layoutParams);
                this.cWx.setText(aoW);
            }
            this.bie = bVar.beM;
            if (m.jm(this.bie.getId())) {
                Xs();
            }
            this.bmV.setData(this.bie);
            m.b(this.bie, this.mTitle);
            if ((StringUtils.isNull(this.bie.getTitle()) && (this.bie.rm() == null || this.bie.rm().size() == 0)) || this.bie.rD() == 1) {
                this.bie.e(false, true);
                if (this.bie.rO() == null || StringUtils.isNull(this.bie.rO().toString())) {
                    this.cWC = false;
                }
            }
            Q(this.bie);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cKp != null) {
            this.cKp.setTag(bdUniqueId);
        }
        if (this.cWy != null) {
            this.cWy.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xs() {
        m.a(this.mTitle, this.bie.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XF() {
        if (this.cWB != null && this.bie != null) {
            m.jl(this.bie.getId());
            Xs();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mH.getPageActivity()).createCfgForPersonCenter(this.bie.getId(), this.bie.rE(), m.rf(), 18005)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
