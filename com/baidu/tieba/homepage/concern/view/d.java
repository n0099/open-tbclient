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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> implements com.baidu.tieba.a.e {
    private final View.OnClickListener aKA;
    private View bGr;
    protected bb bNv;
    private com.baidu.tbadk.core.view.userLike.c cUn;
    public ThreadUserInfoLayout caI;
    public ThreadCommentAndPraiseInfoLayout caJ;
    private String caw;
    protected LinearLayout cbH;
    public ThreadSourceShareAndPraiseLayout cbw;
    private View.OnClickListener erA;
    protected View.OnClickListener erB;
    private final View.OnClickListener erC;
    private TextView eru;
    public ConcernUserLikeButton erv;
    private View erw;
    public LinearLayout erx;
    protected com.baidu.tieba.homepage.concern.b.b ery;
    protected boolean erz;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void ag(bb bbVar);

    protected abstract void ax(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.erz = true;
        this.erA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.apc() != null) {
                    d.this.apc().a(view, d.this.ery);
                }
                if (d.this.ery != null && !StringUtils.isNull(d.this.ery.ere.getName()) && !StringUtils.isNull(d.this.ery.ere.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(d.this.ery.ere.getUserId(), 0L), false, d.this.ery.ere.isGod())));
                }
            }
        };
        this.erB = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.apc() != null) {
                    d.this.apc().a(view, d.this.ery);
                }
                d.this.apx();
            }
        };
        this.aKA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.apc() != null) {
                    d.this.apc().a(view, d.this.ery);
                }
            }
        };
        this.erC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.thread_info_commont_container && d.this.bNv != null) {
                    o.mD(d.this.bNv.getId());
                    d.this.aph();
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.eru = (TextView) view.findViewById(e.g.card_recommend_god_reason);
        this.erv = (ConcernUserLikeButton) view.findViewById(e.g.card_recommend_god_user_like_btn);
        this.caI = (ThreadUserInfoLayout) view.findViewById(e.g.card_rec_god_user_info);
        this.cUn = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.erv);
        this.caI.setTShowVisible(false);
        this.caI.getHeaderImg().setAfterClickListener(this.aKA);
        this.erv.setAfterOnClickListener(this.aKA);
        this.bGr = view.findViewById(e.g.card_recommend_god_divide_line);
        this.erw = view.findViewById(e.g.divider_line);
        this.erx = (LinearLayout) view.findViewById(e.g.card_recommend_god_content);
        this.erx.setOnClickListener(this.erA);
        this.mTitle = (TextView) view.findViewById(e.g.card_recommend_god_therad_title);
        this.caJ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(e.g.card_recommend_god_therad_info_layout);
        this.caJ.setOnClickListener(this.erB);
        this.caJ.setReplyTimeVisible(false);
        this.caJ.setIsBarViewVisible(false);
        this.caJ.setShowPraiseNum(true);
        this.caJ.setNeedAddPraiseIcon(true);
        this.caJ.setNeedAddReplyIcon(true);
        this.caJ.setShareVisible(true);
        this.caJ.avL = this.currentPageType;
        this.caJ.setForumAfterClickListener(this.erC);
        this.caJ.setShareReportFrom(4);
        this.caJ.setFrom(9);
        this.caJ.setDisPraiseFrom(4);
        this.cbw = (ThreadSourceShareAndPraiseLayout) view.findViewById(e.g.card_concern_god_source_read_share_layout);
        this.cbw.aKi.setOnClickListener(this.erB);
        this.cbw.aKi.avL = this.currentPageType;
        this.cbw.aKi.setForumAfterClickListener(this.erC);
        this.cbw.setShareReportFrom(4);
        this.cbw.setFrom(9);
        this.cbH = (LinearLayout) view.findViewById(e.g.card_recommend_god_therad_content_layout);
        ax(view);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.cUn.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.addresslist_item_bg);
            al.h(this.eru, e.d.cp_cont_d);
            al.j(this.bGr, e.d.cp_bg_line_e);
            al.j(this.erw, e.d.cp_bg_line_e);
            this.erv.onChangeSkinType(i);
            this.caJ.onChangeSkinType();
            this.cbw.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.ere != null && !StringUtils.isNull(bVar.ere.getName()) && !StringUtils.isNull(bVar.ere.getUserId()) && !StringUtils.isNull(bVar.dwZ.getTid())) {
            this.ery = bVar;
            if (this.caI != null) {
                this.caI.setData(bVar.dwZ);
                if (this.caI.getHeaderImg() != null) {
                    this.caI.getHeaderImg().setData(bVar.metaData);
                }
                this.caI.onChangeSkinType();
            }
            this.cUn.a(this.ery.metaData);
            String aKk = this.ery.ere.aKk();
            if (StringUtils.isNull(aKk)) {
                this.eru.setVisibility(8);
            } else {
                this.eru.setVisibility(0);
                this.eru.setText(aKk);
            }
            this.bNv = bVar.dwZ;
            if (o.mE(this.bNv.getId())) {
                aph();
            }
            this.caJ.setData(this.bNv);
            o.b(this.bNv, this.mTitle);
            this.erz = true;
            if ((StringUtils.isNull(this.bNv.getTitle()) && (this.bNv.zE() == null || this.bNv.zE().size() == 0)) || this.bNv.zW() == 1) {
                this.bNv.g(false, true);
                if (this.bNv.Ag() == null || StringUtils.isNull(this.bNv.Ag().toString())) {
                    this.erz = false;
                }
            }
            ag(this.bNv);
            iL(hC(1));
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.erv != null) {
            this.erv.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aph() {
        o.a(this.mTitle, this.bNv.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apx() {
        if (this.ery != null && this.bNv != null) {
            o.mD(this.bNv.getId());
            aph();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bNv.getId(), this.bNv.zX(), o.zu(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void iL(int i) {
        if (this.bNv != null) {
            if (i == 1) {
                this.caJ.setVisibility(8);
                this.cbw.setData(this.bNv);
                this.caI.showForumNameView(false);
                return;
            }
            this.caJ.setData(this.bNv);
            this.cbw.setVisibility(8);
            this.caI.showForumNameView(true);
        }
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.caw = str;
    }

    public int hC(int i) {
        return com.baidu.tieba.a.d.VM().M(this.caw, i);
    }
}
