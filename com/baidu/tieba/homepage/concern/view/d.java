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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.m;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> {
    private TextView aoU;
    private TextView aos;
    private final View.OnClickListener aow;
    private com.baidu.tbadk.core.view.userLike.c bJX;
    protected bj bgI;
    protected LinearLayout blD;
    public ThreadCommentAndPraiseInfoLayout blz;
    public ClickableHeaderImageView cRB;
    private TextView cZm;
    public ConcernUserLikeButton cZn;
    private View cZo;
    public LinearLayout cZp;
    protected com.baidu.tieba.homepage.concern.b.b cZq;
    protected boolean cZr;
    private View.OnClickListener cZs;
    protected View.OnClickListener cZt;
    protected TbPageContext<?> mF;
    private int mSkinType;
    private TextView mTitle;

    protected abstract void V(bj bjVar);

    protected abstract void ab(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cZr = false;
        this.cZs = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.XA() != null) {
                    d.this.XA().a(view, d.this.cZq);
                }
                if (d.this.cZq != null && !StringUtils.isNull(d.this.cZq.cYY.getName()) && !StringUtils.isNull(d.this.cZq.cYY.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mF.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.cZq.cYY.getUserId(), 0L), false, d.this.cZq.cYY.isGod())));
                }
            }
        };
        this.cZt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.XA() != null) {
                    d.this.XA().a(view, d.this.cZq);
                }
                d.this.XR();
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.XA() != null) {
                    d.this.XA().a(view, d.this.cZq);
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.cZm = (TextView) view.findViewById(d.h.card_recommend_god_reason);
        this.cRB = (ClickableHeaderImageView) view.findViewById(d.h.card_recommend_god_header_view);
        this.cRB.setAfterClickListener(this.aow);
        this.aos = (TextView) view.findViewById(d.h.card_recommend_god_name);
        this.aoU = (TextView) view.findViewById(d.h.card_recommend_god_rec_intro);
        this.cZn = (ConcernUserLikeButton) view.findViewById(d.h.card_recommend_god_user_like_btn);
        this.bJX = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cZn);
        this.cZn.setAfterOnClickListener(this.aow);
        this.cZo = view.findViewById(d.h.card_recommend_god_divide_line);
        this.cZp = (LinearLayout) view.findViewById(d.h.card_recommend_god_content);
        this.cZp.setOnClickListener(this.cZs);
        this.mTitle = (TextView) view.findViewById(d.h.card_recommend_god_therad_title);
        this.blz = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_recommend_god_therad_info_layout);
        if (this.blz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.blz.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.blz.setLayoutParams(layoutParams);
        }
        this.blz.setOnClickListener(this.cZt);
        this.blz.setReplyTimeVisible(false);
        this.blz.setIsBarViewVisible(false);
        this.blz.setShowPraiseNum(true);
        this.blz.setNeedAddPraiseIcon(true);
        this.blz.setNeedAddReplyIcon(true);
        this.blz.setShareVisible(false);
        this.blz.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blD = (LinearLayout) view.findViewById(d.h.card_recommend_god_therad_content_layout);
        ab(view);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.bJX.i(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.i(this.aos, d.e.cp_cont_h);
            aj.i(this.aoU, d.e.cp_cont_j);
            aj.i(this.cZm, d.e.cp_cont_j);
            aj.k(this.cZo, d.e.cp_bg_line_c);
            this.cZn.onChangeSkinType(i);
            this.blz.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.cYY != null && !StringUtils.isNull(bVar.cYY.getName()) && !StringUtils.isNull(bVar.cYY.getUserId()) && !StringUtils.isNull(bVar.bdq.getTid())) {
            this.cZq = bVar;
            this.cRB.setData(this.cZq.csl);
            this.cRB.setIsRound(true);
            this.aos.setText(this.cZq.cYY.getName());
            this.aoU.setText(this.cZq.cYY.getIntro());
            this.bJX.a(this.cZq.csl);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cZp.getLayoutParams();
            String aqk = this.cZq.cYY.aqk();
            if (StringUtils.isNull(aqk)) {
                this.cZm.setVisibility(8);
                layoutParams.topMargin = 0;
                this.cZp.setLayoutParams(layoutParams);
            } else {
                this.cZm.setVisibility(0);
                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(d.f.ds24);
                this.cZp.setLayoutParams(layoutParams);
                this.cZm.setText(aqk);
            }
            this.bgI = bVar.bdq;
            if (m.jt(this.bgI.getId())) {
                XF();
            }
            this.blz.c(this.bgI);
            m.b(this.bgI, this.mTitle);
            if ((StringUtils.isNull(this.bgI.getTitle()) && (this.bgI.rz() == null || this.bgI.rz().size() == 0)) || this.bgI.rQ() == 1) {
                this.bgI.e(false, true);
                if (this.bgI.sb() == null || StringUtils.isNull(this.bgI.sb().toString())) {
                    this.cZr = false;
                }
            }
            V(this.bgI);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cRB != null) {
            this.cRB.setTag(bdUniqueId);
        }
        if (this.cZn != null) {
            this.cZn.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XF() {
        m.a(this.mTitle, this.bgI.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XR() {
        if (this.cZq != null && this.bgI != null) {
            m.js(this.bgI.getId());
            XF();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mF.getPageActivity()).createCfgForPersonCenter(this.bgI.getId(), this.bgI.rR(), m.rs(), 18005)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
