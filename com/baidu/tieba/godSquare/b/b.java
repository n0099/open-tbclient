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
    private c cNG;
    public ClickableHeaderImageView ebN;
    public CommonUserLikeButton ehT;
    private TextView ehV;
    private TextView ehW;
    private MetaData ehY;
    private f ehZ;
    private TextView eia;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.ebN = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.ebN.setGodIconMargin(e.C0200e.ds6);
        this.ebN.setAfterClickListener(this);
        this.ehV = (TextView) getView().findViewById(e.g.god_name);
        this.ehW = (TextView) getView().findViewById(e.g.god_describe);
        this.eia = (TextView) getView().findViewById(e.g.rec_reason);
        this.ehT = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cNG = new c(tbPageContext, this.ehT);
        this.ehT.setAfterOnClickListener(this);
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
            al.h(this.ehV, e.d.cp_cont_b);
            al.h(this.ehW, e.d.cp_cont_d);
            al.h(this.eia, e.d.cp_cont_d);
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
        if (fVar != null && fVar.aqk != null && fVar.aqk.getGodUserData() != null) {
            this.ehZ = fVar;
            this.ehY = fVar.aqk;
            this.ebN.setData(fVar.aqk);
            this.ehV.setText(fVar.aqk.getName_show());
            this.ehW.setText(fVar.aqk.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(e.j.recommend_reason);
            String recommendReason = fVar.aqk.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.eia.setText("");
            } else {
                this.eia.setText(String.format(string, recommendReason));
            }
            this.cNG.a(fVar.aqk);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anq() != null) {
            anq().a(view, this.ehZ);
        }
        if (view == getView() && this.ehY != null && !StringUtils.isNull(this.ehY.getName_show()) && !StringUtils.isNull(this.ehY.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.ehY.getUserId(), this.ehY.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
