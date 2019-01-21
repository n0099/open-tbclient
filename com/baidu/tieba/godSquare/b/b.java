package com.baidu.tieba.godSquare.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c cXP;
    public ClickableHeaderImageView elN;
    public CommonUserLikeButton esl;
    private TextView esn;
    private TextView eso;
    private MetaData esq;
    private f esr;
    private TextView ess;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.elN = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.elN.setGodIconMargin(e.C0210e.ds6);
        this.elN.setAfterClickListener(this);
        this.esn = (TextView) getView().findViewById(e.g.god_name);
        this.eso = (TextView) getView().findViewById(e.g.god_describe);
        this.ess = (TextView) getView().findViewById(e.g.rec_reason);
        this.esl = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cXP = new c(tbPageContext, this.esl);
        this.esl.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(e.g.bottom_line);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.esn, e.d.cp_cont_b);
            al.h(this.eso, e.d.cp_cont_d);
            al.h(this.ess, e.d.cp_cont_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.aun != null && fVar.aun.getGodUserData() != null) {
            this.esr = fVar;
            this.esq = fVar.aun;
            this.elN.setData(fVar.aun);
            this.esn.setText(fVar.aun.getName_show());
            this.eso.setText(fVar.aun.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(e.j.recommend_reason);
            String recommendReason = fVar.aun.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.ess.setText("");
            } else {
                this.ess.setText(String.format(string, recommendReason));
            }
            this.cXP.a(fVar.aun);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aqp() != null) {
            aqp().a(view, this.esr);
        }
        if (view == getView() && this.esq != null && !StringUtils.isNull(this.esq.getName_show()) && !StringUtils.isNull(this.esq.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.esq.getUserId(), this.esq.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
