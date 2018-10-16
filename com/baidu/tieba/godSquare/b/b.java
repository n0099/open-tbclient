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
    public ClickableHeaderImageView eas;
    private TextView egA;
    private TextView egB;
    private MetaData egD;
    private f egE;
    private TextView egF;
    public CommonUserLikeButton egy;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.eas = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.eas.setGodIconMargin(e.C0175e.ds6);
        this.eas.setAfterClickListener(this);
        this.egA = (TextView) getView().findViewById(e.g.god_name);
        this.egB = (TextView) getView().findViewById(e.g.god_describe);
        this.egF = (TextView) getView().findViewById(e.g.rec_reason);
        this.egy = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cMA = new c(tbPageContext, this.egy);
        this.egy.setAfterOnClickListener(this);
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
            al.h(this.egA, e.d.cp_cont_b);
            al.h(this.egB, e.d.cp_cont_d);
            al.h(this.egF, e.d.cp_cont_d);
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
            this.egE = fVar;
            this.egD = fVar.apx;
            this.eas.setData(fVar.apx);
            this.egA.setText(fVar.apx.getName_show());
            this.egB.setText(fVar.apx.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(e.j.recommend_reason);
            String recommendReason = fVar.apx.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.egF.setText("");
            } else {
                this.egF.setText(String.format(string, recommendReason));
            }
            this.cMA.a(fVar.apx);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anO() != null) {
            anO().a(view, this.egE);
        }
        if (view == getView() && this.egD != null && !StringUtils.isNull(this.egD.getName_show()) && !StringUtils.isNull(this.egD.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.egD.getUserId(), this.egD.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
