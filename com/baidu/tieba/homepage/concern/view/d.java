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
    private TextView aoS;
    private TextView aoq;
    private final View.OnClickListener aou;
    private com.baidu.tbadk.core.view.userLike.c bKO;
    protected bj bgF;
    protected LinearLayout blC;
    public ThreadCommentAndPraiseInfoLayout bly;
    public ClickableHeaderImageView cSv;
    private TextView dag;
    public ConcernUserLikeButton dah;
    private View dai;
    public LinearLayout daj;
    protected com.baidu.tieba.homepage.concern.b.b dak;
    protected boolean dal;
    private View.OnClickListener dam;
    protected View.OnClickListener dan;
    protected TbPageContext<?> mF;
    private int mSkinType;
    private TextView mTitle;

    protected abstract void V(bj bjVar);

    protected abstract void ab(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dal = false;
        this.dam = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.XL() != null) {
                    d.this.XL().a(view, d.this.dak);
                }
                if (d.this.dak != null && !StringUtils.isNull(d.this.dak.cZS.getName()) && !StringUtils.isNull(d.this.dak.cZS.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mF.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dak.cZS.getUserId(), 0L), false, d.this.dak.cZS.isGod())));
                }
            }
        };
        this.dan = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.XL() != null) {
                    d.this.XL().a(view, d.this.dak);
                }
                d.this.Yc();
            }
        };
        this.aou = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.XL() != null) {
                    d.this.XL().a(view, d.this.dak);
                }
            }
        };
        View view = getView();
        this.mF = tbPageContext;
        this.dag = (TextView) view.findViewById(d.h.card_recommend_god_reason);
        this.cSv = (ClickableHeaderImageView) view.findViewById(d.h.card_recommend_god_header_view);
        this.cSv.setAfterClickListener(this.aou);
        this.aoq = (TextView) view.findViewById(d.h.card_recommend_god_name);
        this.aoS = (TextView) view.findViewById(d.h.card_recommend_god_rec_intro);
        this.dah = (ConcernUserLikeButton) view.findViewById(d.h.card_recommend_god_user_like_btn);
        this.bKO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.dah);
        this.dah.setAfterOnClickListener(this.aou);
        this.dai = view.findViewById(d.h.card_recommend_god_divide_line);
        this.daj = (LinearLayout) view.findViewById(d.h.card_recommend_god_content);
        this.daj.setOnClickListener(this.dam);
        this.mTitle = (TextView) view.findViewById(d.h.card_recommend_god_therad_title);
        this.bly = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.h.card_recommend_god_therad_info_layout);
        if (this.bly.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bly.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bly.setLayoutParams(layoutParams);
        }
        this.bly.setOnClickListener(this.dan);
        this.bly.setReplyTimeVisible(false);
        this.bly.setIsBarViewVisible(false);
        this.bly.setShowPraiseNum(true);
        this.bly.setNeedAddPraiseIcon(true);
        this.bly.setNeedAddReplyIcon(true);
        this.bly.setShareVisible(false);
        this.bly.setReplyIcon(d.g.icon_home_card_comment_n);
        this.blC = (LinearLayout) view.findViewById(d.h.card_recommend_god_therad_content_layout);
        ab(view);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.bKO.i(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.g.addresslist_item_bg);
            aj.i(this.aoq, d.e.cp_cont_h);
            aj.i(this.aoS, d.e.cp_cont_j);
            aj.i(this.dag, d.e.cp_cont_j);
            aj.k(this.dai, d.e.cp_bg_line_c);
            this.dah.onChangeSkinType(i);
            this.bly.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.cZS != null && !StringUtils.isNull(bVar.cZS.getName()) && !StringUtils.isNull(bVar.cZS.getUserId()) && !StringUtils.isNull(bVar.bdn.getTid())) {
            this.dak = bVar;
            this.cSv.setData(this.dak.ctd);
            this.cSv.setIsRound(true);
            this.aoq.setText(this.dak.cZS.getName());
            this.aoS.setText(this.dak.cZS.getIntro());
            this.bKO.a(this.dak.ctd);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.daj.getLayoutParams();
            String aqv = this.dak.cZS.aqv();
            if (StringUtils.isNull(aqv)) {
                this.dag.setVisibility(8);
                layoutParams.topMargin = 0;
                this.daj.setLayoutParams(layoutParams);
            } else {
                this.dag.setVisibility(0);
                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(d.f.ds24);
                this.daj.setLayoutParams(layoutParams);
                this.dag.setText(aqv);
            }
            this.bgF = bVar.bdn;
            if (m.jv(this.bgF.getId())) {
                XQ();
            }
            this.bly.c(this.bgF);
            m.b(this.bgF, this.mTitle);
            if ((StringUtils.isNull(this.bgF.getTitle()) && (this.bgF.rz() == null || this.bgF.rz().size() == 0)) || this.bgF.rQ() == 1) {
                this.bgF.e(false, true);
                if (this.bgF.sb() == null || StringUtils.isNull(this.bgF.sb().toString())) {
                    this.dal = false;
                }
            }
            V(this.bgF);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.cSv != null) {
            this.cSv.setTag(bdUniqueId);
        }
        if (this.dah != null) {
            this.dah.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XQ() {
        m.a(this.mTitle, this.bgF.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Yc() {
        if (this.dak != null && this.bgF != null) {
            m.ju(this.bgF.getId());
            XQ();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mF.getPageActivity()).createCfgForPersonCenter(this.bgF.getId(), this.bgF.rR(), m.rs(), 18005)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
