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
    private TbPageContext<?> ako;
    private TextView anV;
    public TextView anz;
    private com.baidu.tbadk.core.view.userLike.c bFk;
    public ClickableHeaderImageView cHS;
    private com.baidu.tieba.homepage.concern.b.b cPA;
    private TextView cPv;
    private TextView cPw;
    public ConcernUserLikeButton cPx;
    private View cPy;
    private LinearLayout cPz;
    private MetaData ckW;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        getView().setOnClickListener(this);
        this.ako = tbPageContext;
        this.cPv = (TextView) view.findViewById(d.h.card_recommend_god_reason);
        this.cHS = (ClickableHeaderImageView) view.findViewById(d.h.card_recommend_god_header_view);
        this.anz = (TextView) view.findViewById(d.h.card_recommend_god_name);
        this.anV = (TextView) view.findViewById(d.h.card_recommend_god_rec_intro);
        this.cPw = (TextView) view.findViewById(d.h.card_recommend_god_fans_post);
        this.cPx = (ConcernUserLikeButton) view.findViewById(d.h.card_recommend_god_user_like_btn);
        this.bFk = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.cPx);
        this.cPx.setAfterOnClickListener(this);
        this.cPy = view.findViewById(d.h.card_recommend_god_divide_line);
        this.cPz = (LinearLayout) view.findViewById(d.h.card_recommend_god_content);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bFk.i(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(getView(), d.g.home_thread_card_item_bg);
            ai.i(this.anz, d.e.cp_cont_h);
            ai.i(this.anV, d.e.cp_cont_d);
            ai.i(this.cPv, d.e.cp_cont_f);
            ai.i(this.cPw, d.e.cp_cont_d);
            ai.k(this.cPy, d.e.cp_bg_line_c);
            this.cPx.onChangeSkinType(i);
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
        if (bVar != null && bVar.cPh != null && !StringUtils.isNull(bVar.cPh.getName()) && !StringUtils.isNull(bVar.cPh.getUserId())) {
            this.cPA = bVar;
            this.ckW = bVar.ckW;
            this.cHS.setData(this.ckW);
            this.cHS.setIsRound(true);
            this.anz.setText(bVar.cPh.getName());
            this.anV.setText(bVar.cPh.getIntro());
            this.bFk.a(this.ckW);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cPz.getLayoutParams();
            if (StringUtils.isNull(bVar.cPh.anP())) {
                this.cPv.setVisibility(8);
                layoutParams.topMargin = 0;
                this.cPz.setLayoutParams(layoutParams);
            } else {
                this.cPv.setVisibility(0);
                layoutParams.topMargin = getContext().getResources().getDimensionPixelOffset(d.f.ds24);
                this.cPz.setLayoutParams(layoutParams);
                this.cPv.setText(bVar.cPh.anP());
            }
            b(bVar);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(com.baidu.tieba.homepage.concern.b.b bVar) {
        if (this.cPw != null && bVar != null) {
            String v = al.v(bVar.cPh.getFansNum());
            this.cPw.setText(v + VY().getString(d.l.fans) + "  " + al.v(bVar.cPh.getPost_num()) + VY().getString(d.l.tiezi));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (VZ() != null) {
            VZ().a(view, this.cPA);
        }
        if (view == getView() && this.cPA != null && !StringUtils.isNull(this.cPA.cPh.getName()) && !StringUtils.isNull(this.cPA.cPh.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.ako.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(this.cPA.cPh.getUserId(), 0L), false, this.cPA.cPh.isGod())));
        }
    }
}
