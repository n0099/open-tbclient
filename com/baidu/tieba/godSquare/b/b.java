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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c cWa;
    public ClickableHeaderImageView dZY;
    private f eeA;
    private TextView eeB;
    public CommonUserLikeButton eeu;
    private TextView eew;
    private TextView eex;
    private MetaData eez;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dZY = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dZY.setGodIconMargin(d.e.ds6);
        this.dZY.setAfterClickListener(this);
        this.eew = (TextView) getView().findViewById(d.g.god_name);
        this.eex = (TextView) getView().findViewById(d.g.god_describe);
        this.eeB = (TextView) getView().findViewById(d.g.rec_reason);
        this.eeu = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cWa = new c(tbPageContext, this.eeu);
        this.eeu.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.eew, d.C0141d.cp_cont_b);
            aj.r(this.eex, d.C0141d.cp_cont_d);
            aj.r(this.eeB, d.C0141d.cp_cont_d);
            aj.t(this.mBottomLine, d.C0141d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.aOG != null && fVar.aOG.getGodUserData() != null) {
            this.eeA = fVar;
            this.eez = fVar.aOG;
            this.dZY.setData(fVar.aOG);
            this.eew.setText(fVar.aOG.getName_show());
            this.eex.setText(fVar.aOG.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(d.j.recommend_reason);
            String recommendReason = fVar.aOG.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.eeB.setText("");
            } else {
                this.eeB.setText(String.format(string, recommendReason));
            }
            this.cWa.a(fVar.aOG);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akP() != null) {
            akP().a(view, this.eeA);
        }
        if (view == getView() && this.eez != null && !StringUtils.isNull(this.eez.getName_show()) && !StringUtils.isNull(this.eez.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.eez.getUserId(), this.eez.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
