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
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c ehj;
    public ClickableHeaderImageView fAm;
    private MetaData fEB;
    private f fEC;
    private TextView fED;
    public CommonUserLikeButton fEw;
    private TextView fEy;
    private TextView fEz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fAm = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.fAm.setGodIconMargin(d.e.ds6);
        this.fAm.setAfterClickListener(this);
        this.fEy = (TextView) getView().findViewById(d.g.god_name);
        this.fEz = (TextView) getView().findViewById(d.g.god_describe);
        this.fED = (TextView) getView().findViewById(d.g.rec_reason);
        this.fEw = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.ehj = new c(tbPageContext, this.fEw);
        this.fEw.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.f.home_thread_card_item_bg);
            al.j(this.fEy, d.C0277d.cp_cont_b);
            al.j(this.fEz, d.C0277d.cp_cont_d);
            al.j(this.fED, d.C0277d.cp_cont_d);
            al.l(this.mBottomLine, d.C0277d.cp_bg_line_b);
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
        if (fVar != null && fVar.bBJ != null && fVar.bBJ.getGodUserData() != null) {
            this.fEC = fVar;
            this.fEB = fVar.bBJ;
            this.fAm.setData(fVar.bBJ);
            this.fEy.setText(fVar.bBJ.getName_show());
            this.fEz.setText(fVar.bBJ.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(d.j.recommend_reason);
            String recommendReason = fVar.bBJ.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.fED.setText("");
            } else {
                this.fED.setText(String.format(string, recommendReason));
            }
            this.ehj.a(fVar.bBJ);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQf() != null) {
            aQf().a(view, this.fEC);
        }
        if (view == getView() && this.fEB != null && !StringUtils.isNull(this.fEB.getName_show()) && !StringUtils.isNull(this.fEB.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.fEB.getUserId(), this.fEB.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
