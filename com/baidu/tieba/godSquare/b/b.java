package com.baidu.tieba.godSquare.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.i;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.card.b<i> {
    private c ajV;
    public ClickableHeaderImageView iXa;
    public CommonUserLikeButton jaT;
    private TextView jaV;
    private TextView jaW;
    private MetaData jaY;
    private i jaZ;
    private TextView jba;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.iXa = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.iXa.setGodIconMargin(R.dimen.ds6);
        this.iXa.setAfterClickListener(this);
        this.jaV = (TextView) getView().findViewById(R.id.god_name);
        this.jaW = (TextView) getView().findViewById(R.id.god_describe);
        this.jba = (TextView) getView().findViewById(R.id.rec_reason);
        this.jaT = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ajV = new c(tbPageContext, this.jaT);
        this.jaT.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.jaV, R.color.cp_cont_b);
            ap.setViewTextColor(this.jaW, R.color.cp_cont_d);
            ap.setViewTextColor(this.jba, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(i iVar) {
        if (iVar != null && iVar.equ != null && iVar.equ.getGodUserData() != null) {
            this.jaZ = iVar;
            this.jaY = iVar.equ;
            this.iXa.setData(iVar.equ);
            this.jaV.setText(iVar.equ.getName_show());
            this.jaW.setText(iVar.equ.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = iVar.equ.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.jba.setText("");
            } else {
                this.jba.setText(String.format(string, recommendReason));
            }
            this.ajV.a(iVar.equ);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cil() != null) {
            cil().a(view, this.jaZ);
        }
        if (view == getView() && this.jaY != null && !StringUtils.isNull(this.jaY.getName_show()) && !StringUtils.isNull(this.jaY.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.jaY.getUserId(), this.jaY.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
