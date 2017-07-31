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
    private TbPageContext<?> alI;
    public TextView aoS;
    private TextView apo;
    private com.baidu.tbadk.core.view.userLike.c bGu;
    public ClickableHeaderImageView cJn;
    private TextView cQO;
    private TextView cQP;
    public ConcernUserLikeButton cQQ;
    private View cQR;
    private LinearLayout cQS;
    private com.baidu.tieba.homepage.concern.b.b cQT;
    private MetaData cmf;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        getView().setOnClickListener(this);
        this.alI = tbPageContext;
        this.cQO = (TextView) view.findViewById(d.h.card_recommend_god_reason);
        this.cJn = (ClickableHeaderImageView) view.findViewById(d.h.card_recommend_god_header_view);
        this.aoS = (TextView) view.findViewById(d.h.card_recommend_god_name);
        this.apo = (TextView) view.findViewById(d.h.card_recommend_god_rec_intro);
        this.cQP = (TextView) view.findViewById(d.h.card_recommend_god_fans_post);
        this.cQQ = (ConcernUserLikeButton) view.findViewById(d.h.card_recommend_god_user_like_btn);
        this.bGu = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cQQ);
        this.cQQ.setAfterOnClickListener(this);
        this.cQR = view.findViewById(d.h.card_recommend_god_divide_line);
        this.cQS = (LinearLayout) view.findViewById(d.h.card_recommend_god_content);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bGu.i(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.i(this.aoS, d.e.cp_cont_h);
            ai.i(this.apo, d.e.cp_cont_d);
            ai.i(this.cQO, d.e.cp_cont_f);
            ai.i(this.cQP, d.e.cp_cont_d);
            ai.k(this.cQR, d.e.cp_bg_line_c);
            this.cQQ.onChangeSkinType(i);
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
        if (bVar != null && bVar.cQA != null && !StringUtils.isNull(bVar.cQA.getName()) && !StringUtils.isNull(bVar.cQA.getUserId())) {
            this.cQT = bVar;
            this.cmf = bVar.cmf;
            this.cJn.setData(this.cmf);
            this.cJn.setIsRound(true);
            this.aoS.setText(bVar.cQA.getName());
            this.apo.setText(bVar.cQA.getIntro());
            this.bGu.a(this.cmf);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cQS.getLayoutParams();
            if (StringUtils.isNull(bVar.cQA.aob())) {
                this.cQO.setVisibility(8);
                layoutParams.topMargin = 0;
                this.cQS.setLayoutParams(layoutParams);
            } else {
                this.cQO.setVisibility(0);
                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(d.f.ds24);
                this.cQS.setLayoutParams(layoutParams);
                this.cQO.setText(bVar.cQA.aob());
            }
            b(bVar);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (this.cQP != null && bVar != null) {
            String v = al.v(bVar.cQA.getFansNum());
            this.cQP.setText(v + Wd().getString(d.l.fans) + "  " + al.v(bVar.cQA.getPost_num()) + Wd().getString(d.l.tiezi));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (We() != null) {
            We().a(view, this.cQT);
        }
        if (view == getView() && this.cQT != null && !StringUtils.isNull(this.cQT.cQA.getName()) && !StringUtils.isNull(this.cQT.cQA.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.alI.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.cQT.cQA.getUserId(), 0L), false, this.cQT.cQA.isGod())));
        }
    }
}
