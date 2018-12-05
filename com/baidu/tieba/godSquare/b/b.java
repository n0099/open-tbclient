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
    private c cUn;
    public ClickableHeaderImageView eiq;
    public CommonUserLikeButton eoN;
    private TextView eoP;
    private TextView eoQ;
    private MetaData eoS;
    private f eoT;
    private TextView eoU;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.eiq = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.eiq.setGodIconMargin(e.C0210e.ds6);
        this.eiq.setAfterClickListener(this);
        this.eoP = (TextView) getView().findViewById(e.g.god_name);
        this.eoQ = (TextView) getView().findViewById(e.g.god_describe);
        this.eoU = (TextView) getView().findViewById(e.g.rec_reason);
        this.eoN = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cUn = new c(tbPageContext, this.eoN);
        this.eoN.setAfterOnClickListener(this);
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
            al.h(this.eoP, e.d.cp_cont_b);
            al.h(this.eoQ, e.d.cp_cont_d);
            al.h(this.eoU, e.d.cp_cont_d);
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
        if (fVar != null && fVar.atK != null && fVar.atK.getGodUserData() != null) {
            this.eoT = fVar;
            this.eoS = fVar.atK;
            this.eiq.setData(fVar.atK);
            this.eoP.setText(fVar.atK.getName_show());
            this.eoQ.setText(fVar.atK.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(e.j.recommend_reason);
            String recommendReason = fVar.atK.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.eoU.setText("");
            } else {
                this.eoU.setText(String.format(string, recommendReason));
            }
            this.cUn.a(fVar.atK);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apc() != null) {
            apc().a(view, this.eoT);
        }
        if (view == getView() && this.eoS != null && !StringUtils.isNull(this.eoS.getName_show()) && !StringUtils.isNull(this.eoS.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.eoS.getUserId(), this.eoS.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
