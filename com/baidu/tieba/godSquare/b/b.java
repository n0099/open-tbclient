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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c cyt;
    public ClickableHeaderImageView dLk;
    public CommonUserLikeButton dRs;
    private TextView dRu;
    private TextView dRv;
    private MetaData dRx;
    private f dRy;
    private TextView dRz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dLk = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dLk.setGodIconMargin(d.e.ds6);
        this.dLk.setAfterClickListener(this);
        this.dRu = (TextView) getView().findViewById(d.g.god_name);
        this.dRv = (TextView) getView().findViewById(d.g.god_describe);
        this.dRz = (TextView) getView().findViewById(d.g.rec_reason);
        this.dRs = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cyt = new c(tbPageContext, this.dRs);
        this.dRs.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.home_thread_card_item_bg);
            am.h(this.dRu, d.C0140d.cp_cont_b);
            am.h(this.dRv, d.C0140d.cp_cont_d);
            am.h(this.dRz, d.C0140d.cp_cont_d);
            am.j(this.mBottomLine, d.C0140d.cp_bg_line_b);
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
        if (fVar != null && fVar.aib != null && fVar.aib.getGodUserData() != null) {
            this.dRy = fVar;
            this.dRx = fVar.aib;
            this.dLk.setData(fVar.aib);
            this.dRu.setText(fVar.aib.getName_show());
            this.dRv.setText(fVar.aib.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(d.j.recommend_reason);
            String recommendReason = fVar.aib.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.dRz.setText("");
            } else {
                this.dRz.setText(String.format(string, recommendReason));
            }
            this.cyt.a(fVar.aib);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiz() != null) {
            aiz().a(view, this.dRy);
        }
        if (view == getView() && this.dRx != null && !StringUtils.isNull(this.dRx.getName_show()) && !StringUtils.isNull(this.dRx.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.dRx.getUserId(), this.dRx.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
