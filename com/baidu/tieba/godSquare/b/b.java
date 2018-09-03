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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c cyq;
    public ClickableHeaderImageView dLg;
    public CommonUserLikeButton dRn;
    private TextView dRp;
    private TextView dRq;
    private MetaData dRs;
    private f dRt;
    private TextView dRu;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dLg = (ClickableHeaderImageView) getView().findViewById(f.g.god_header_view);
        this.dLg.setGodIconMargin(f.e.ds6);
        this.dLg.setAfterClickListener(this);
        this.dRp = (TextView) getView().findViewById(f.g.god_name);
        this.dRq = (TextView) getView().findViewById(f.g.god_describe);
        this.dRu = (TextView) getView().findViewById(f.g.rec_reason);
        this.dRn = (CommonUserLikeButton) getView().findViewById(f.g.god_like_btn);
        this.cyq = new c(tbPageContext, this.dRn);
        this.dRn.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(f.g.bottom_line);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.C0146f.home_thread_card_item_bg);
            am.h(this.dRp, f.d.cp_cont_b);
            am.h(this.dRq, f.d.cp_cont_d);
            am.h(this.dRu, f.d.cp_cont_d);
            am.j(this.mBottomLine, f.d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.f fVar) {
        if (fVar != null && fVar.aib != null && fVar.aib.getGodUserData() != null) {
            this.dRt = fVar;
            this.dRs = fVar.aib;
            this.dLg.setData(fVar.aib);
            this.dRp.setText(fVar.aib.getName_show());
            this.dRq.setText(fVar.aib.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(f.j.recommend_reason);
            String recommendReason = fVar.aib.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.dRu.setText("");
            } else {
                this.dRu.setText(String.format(string, recommendReason));
            }
            this.cyq.a(fVar.aib);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiC() != null) {
            aiC().a(view, this.dRt);
        }
        if (view == getView() && this.dRs != null && !StringUtils.isNull(this.dRs.getName_show()) && !StringUtils.isNull(this.dRs.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.dRs.getUserId(), this.dRs.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
