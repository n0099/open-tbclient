package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.concern.b.b> {
    public TextView aoT;
    private TextView apq;
    private com.baidu.tbadk.core.view.userLike.c bHe;
    public ClickableHeaderImageView cLk;
    private TextView cSN;
    private TextView cSO;
    public ConcernUserLikeButton cSP;
    private View cSQ;
    private LinearLayout cSR;
    private com.baidu.tieba.homepage.concern.b.b cSS;
    private MetaData cmR;
    private TbPageContext<?> oW;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        getView().setOnClickListener(this);
        this.oW = tbPageContext;
        this.cSN = (TextView) view.findViewById(d.h.card_recommend_god_reason);
        this.cLk = (ClickableHeaderImageView) view.findViewById(d.h.card_recommend_god_header_view);
        this.aoT = (TextView) view.findViewById(d.h.card_recommend_god_name);
        this.apq = (TextView) view.findViewById(d.h.card_recommend_god_rec_intro);
        this.cSO = (TextView) view.findViewById(d.h.card_recommend_god_fans_post);
        this.cSP = (ConcernUserLikeButton) view.findViewById(d.h.card_recommend_god_user_like_btn);
        this.bHe = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cSP);
        this.cSP.setAfterOnClickListener(this);
        this.cSQ = view.findViewById(d.h.card_recommend_god_divide_line);
        this.cSR = (LinearLayout) view.findViewById(d.h.card_recommend_god_content);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bHe.i(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.i(this.aoT, d.e.cp_cont_h);
            ai.i(this.apq, d.e.cp_cont_d);
            ai.i(this.cSN, d.e.cp_cont_f);
            ai.i(this.cSO, d.e.cp_cont_d);
            ai.k(this.cSQ, d.e.cp_bg_line_c);
            this.cSP.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_recommend_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (bVar != null && bVar.cSz != null && !StringUtils.isNull(bVar.cSz.getName()) && !StringUtils.isNull(bVar.cSz.getUserId())) {
            this.cSS = bVar;
            this.cmR = bVar.cmR;
            this.cLk.setData(this.cmR);
            this.cLk.setIsRound(true);
            this.aoT.setText(bVar.cSz.getName());
            this.apq.setText(bVar.cSz.getIntro());
            this.bHe.a(this.cmR);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cSR.getLayoutParams();
            if (StringUtils.isNull(bVar.cSz.aoC())) {
                this.cSN.setVisibility(8);
                layoutParams.topMargin = 0;
                this.cSR.setLayoutParams(layoutParams);
            } else {
                this.cSN.setVisibility(0);
                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(d.f.ds24);
                this.cSR.setLayoutParams(layoutParams);
                this.cSN.setText(bVar.cSz.aoC());
            }
            b(bVar);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (this.cSO != null && bVar != null) {
            String v = al.v(bVar.cSz.getFansNum());
            this.cSO.setText(v + Ww().getString(d.l.fans) + "  " + al.v(bVar.cSz.getPost_num()) + Ww().getString(d.l.tiezi));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Wx() != null) {
            Wx().a(view, this.cSS);
        }
        if (view == getView() && this.cSS != null && !StringUtils.isNull(this.cSS.cSz.getName()) && !StringUtils.isNull(this.cSS.cSz.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.oW.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.cSS.cSz.getUserId(), 0L), false, this.cSS.cSz.isGod())));
        }
    }
}
