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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> {
    private final View.OnClickListener aog;
    private com.baidu.tbadk.core.view.userLike.c bZO;
    protected bd bku;
    public ThreadUserInfoLayout bvI;
    public ThreadCommentAndPraiseInfoLayout bvM;
    protected LinearLayout bvP;
    private TextView doX;
    public ConcernUserLikeButton doY;
    private View doZ;
    private View dpa;
    public LinearLayout dpb;
    protected com.baidu.tieba.homepage.concern.b.b dpc;
    protected boolean dpd;
    private View.OnClickListener dpe;
    protected View.OnClickListener dpf;
    protected TbPageContext<?> mPageContext;
    private int mSkinType;
    protected TextView mTitle;

    protected abstract void W(bd bdVar);

    protected abstract void af(View view);

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dpd = true;
        this.dpe = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.abt() != null) {
                    d.this.abt().a(view, d.this.dpc);
                }
                if (d.this.dpc != null && !StringUtils.isNull(d.this.dpc.doK.getName()) && !StringUtils.isNull(d.this.dpc.doK.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(d.this.dpc.doK.getUserId(), 0L), false, d.this.dpc.doK.isGod())));
                }
            }
        };
        this.dpf = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.abt() != null) {
                    d.this.abt().a(view, d.this.dpc);
                }
                d.this.abM();
            }
        };
        this.aog = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.abt() != null) {
                    d.this.abt().a(view, d.this.dpc);
                }
            }
        };
        View view = getView();
        this.currentPageType = 1;
        this.mPageContext = tbPageContext;
        this.doX = (TextView) view.findViewById(d.g.card_recommend_god_reason);
        this.doY = (ConcernUserLikeButton) view.findViewById(d.g.card_recommend_god_user_like_btn);
        this.bvI = (ThreadUserInfoLayout) view.findViewById(d.g.card_rec_god_user_info);
        this.bZO = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.doY);
        this.bvI.setTShowVisible(false);
        this.bvI.getHeaderImg().setAfterClickListener(this.aog);
        this.doY.setAfterOnClickListener(this.aog);
        this.doZ = view.findViewById(d.g.card_recommend_god_divide_line);
        this.dpa = view.findViewById(d.g.divider_line);
        this.dpb = (LinearLayout) view.findViewById(d.g.card_recommend_god_content);
        this.dpb.setOnClickListener(this.dpe);
        this.mTitle = (TextView) view.findViewById(d.g.card_recommend_god_therad_title);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.card_recommend_god_therad_info_layout);
        this.bvM.setOnClickListener(this.dpf);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setIsBarViewVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setShareVisible(true);
        this.bvM.anR = this.currentPageType;
        this.bvP = (LinearLayout) view.findViewById(d.g.card_recommend_god_therad_content_layout);
        af(view);
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
            this.bZO.h(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(getView(), d.f.addresslist_item_bg);
            aj.i(this.doX, d.C0095d.cp_cont_d);
            aj.k(this.doZ, d.C0095d.cp_bg_line_e);
            aj.k(this.dpa, d.C0095d.cp_bg_line_e);
            this.doY.onChangeSkinType(i);
            this.bvM.onChangeSkinType();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.doK != null && !StringUtils.isNull(bVar.doK.getName()) && !StringUtils.isNull(bVar.doK.getUserId()) && !StringUtils.isNull(bVar.cBD.getTid())) {
            this.dpc = bVar;
            if (this.bvI != null) {
                this.bvI.setData(bVar.cBD);
                if (this.bvI.getHeaderImg() != null) {
                    this.bvI.getHeaderImg().setData(bVar.metaData);
                }
                this.bvI.onChangeSkinType();
            }
            this.bZO.a(this.dpc.metaData);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dpb.getLayoutParams();
            String atO = this.dpc.doK.atO();
            if (StringUtils.isNull(atO)) {
                this.doX.setVisibility(8);
            } else {
                this.doX.setVisibility(0);
                this.doX.setText(atO);
            }
            this.bku = bVar.cBD;
            if (k.jP(this.bku.getId())) {
                aby();
            }
            this.bvM.setData(this.bku);
            k.b(this.bku, this.mTitle);
            this.dpd = true;
            if ((StringUtils.isNull(this.bku.getTitle()) && (this.bku.rt() == null || this.bku.rt().size() == 0)) || this.bku.rL() == 1) {
                this.bku.e(false, true);
                if (this.bku.rV() == null || StringUtils.isNull(this.bku.rV().toString())) {
                    this.dpd = false;
                }
            }
            W(this.bku);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.doY != null) {
            this.doY.setTag(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aby() {
        k.a(this.mTitle, this.bku.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abM() {
        if (this.dpc != null && this.bku != null) {
            k.jO(this.bku.getId());
            aby();
            PbActivityConfig createCfgForPersonCenter = new PbActivityConfig(this.mPageContext.getPageActivity()).createCfgForPersonCenter(this.bku.getId(), this.bku.rM(), k.rl(), 18005);
            createCfgForPersonCenter.setStartFrom(this.currentPageType);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createCfgForPersonCenter));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
