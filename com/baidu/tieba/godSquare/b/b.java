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
    private c cMA;
    public ClickableHeaderImageView eat;
    private TextView egB;
    private TextView egC;
    private MetaData egE;
    private f egF;
    private TextView egG;
    public CommonUserLikeButton egz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.eat = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.eat.setGodIconMargin(e.C0175e.ds6);
        this.eat.setAfterClickListener(this);
        this.egB = (TextView) getView().findViewById(e.g.god_name);
        this.egC = (TextView) getView().findViewById(e.g.god_describe);
        this.egG = (TextView) getView().findViewById(e.g.rec_reason);
        this.egz = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cMA = new c(tbPageContext, this.egz);
        this.egz.setAfterOnClickListener(this);
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
            al.h(this.egB, e.d.cp_cont_b);
            al.h(this.egC, e.d.cp_cont_d);
            al.h(this.egG, e.d.cp_cont_d);
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
        if (fVar != null && fVar.apx != null && fVar.apx.getGodUserData() != null) {
            this.egF = fVar;
            this.egE = fVar.apx;
            this.eat.setData(fVar.apx);
            this.egB.setText(fVar.apx.getName_show());
            this.egC.setText(fVar.apx.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(e.j.recommend_reason);
            String recommendReason = fVar.apx.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.egG.setText("");
            } else {
                this.egG.setText(String.format(string, recommendReason));
            }
            this.cMA.a(fVar.apx);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anP() != null) {
            anP().a(view, this.egF);
        }
        if (view == getView() && this.egE != null && !StringUtils.isNull(this.egE.getName_show()) && !StringUtils.isNull(this.egE.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.egE.getUserId(), this.egE.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
