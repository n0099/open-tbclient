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
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c eBX;
    public ClickableHeaderImageView fWj;
    private TextView gaA;
    public CommonUserLikeButton gat;
    private TextView gav;
    private TextView gaw;
    private MetaData gay;
    private f gaz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fWj = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fWj.setGodIconMargin(R.dimen.ds6);
        this.fWj.setAfterClickListener(this);
        this.gav = (TextView) getView().findViewById(R.id.god_name);
        this.gaw = (TextView) getView().findViewById(R.id.god_describe);
        this.gaA = (TextView) getView().findViewById(R.id.rec_reason);
        this.gat = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.eBX = new c(tbPageContext, this.gat);
        this.gat.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.drawable.home_thread_card_item_bg);
            am.j(this.gav, R.color.cp_cont_b);
            am.j(this.gaw, R.color.cp_cont_d);
            am.j(this.gaA, R.color.cp_cont_d);
            am.l(this.mBottomLine, R.color.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.bKb != null && fVar.bKb.getGodUserData() != null) {
            this.gaz = fVar;
            this.gay = fVar.bKb;
            this.fWj.setData(fVar.bKb);
            this.gav.setText(fVar.bKb.getName_show());
            this.gaw.setText(fVar.bKb.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = fVar.bKb.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.gaA.setText("");
            } else {
                this.gaA.setText(String.format(string, recommendReason));
            }
            this.eBX.a(fVar.bKb);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZo() != null) {
            aZo().a(view, this.gaz);
        }
        if (view == getView() && this.gay != null && !StringUtils.isNull(this.gay.getName_show()) && !StringUtils.isNull(this.gay.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.gay.getUserId(), this.gay.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
