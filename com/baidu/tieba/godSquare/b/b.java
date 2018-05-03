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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c cnX;
    public ClickableHeaderImageView duF;
    public CommonUserLikeButton dyX;
    private TextView dyZ;
    private TextView dza;
    private MetaData dzc;
    private f dzd;
    private TextView dze;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.duF = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.duF.setGodIconMargin(d.e.ds6);
        this.duF.setAfterClickListener(this);
        this.dyZ = (TextView) getView().findViewById(d.g.god_name);
        this.dza = (TextView) getView().findViewById(d.g.god_describe);
        this.dze = (TextView) getView().findViewById(d.g.rec_reason);
        this.dyX = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cnX = new c(tbPageContext, this.dyX);
        this.dyX.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.h(this.dyZ, d.C0126d.cp_cont_b);
            ak.h(this.dza, d.C0126d.cp_cont_d);
            ak.h(this.dze, d.C0126d.cp_cont_d);
            ak.j(this.mBottomLine, d.C0126d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.aae != null && fVar.aae.getGodUserData() != null) {
            this.dzd = fVar;
            this.dzc = fVar.aae;
            this.duF.setData(fVar.aae);
            this.dyZ.setText(fVar.aae.getName_show());
            this.dza.setText(fVar.aae.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(d.k.recommend_reason);
            String recommendReason = fVar.aae.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.dze.setText("");
            } else {
                this.dze.setText(String.format(string, recommendReason));
            }
            this.cnX.a(fVar.aae);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.dzd);
        }
        if (view2 == getView() && this.dzc != null && !StringUtils.isNull(this.dzc.getName_show()) && !StringUtils.isNull(this.dzc.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.dzc.getUserId(), this.dzc.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
