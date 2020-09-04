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
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.card.b<i> {
    private c aje;
    public ClickableHeaderImageView iAN;
    public CommonUserLikeButton iEG;
    private TextView iEI;
    private TextView iEJ;
    private MetaData iEL;
    private i iEM;
    private TextView iEN;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.iAN = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.iAN.setGodIconMargin(R.dimen.ds6);
        this.iAN.setAfterClickListener(this);
        this.iEI = (TextView) getView().findViewById(R.id.god_name);
        this.iEJ = (TextView) getView().findViewById(R.id.god_describe);
        this.iEN = (TextView) getView().findViewById(R.id.rec_reason);
        this.iEG = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.aje = new c(tbPageContext, this.iEG);
        this.iEG.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.iEI, R.color.cp_cont_b);
            ap.setViewTextColor(this.iEJ, R.color.cp_cont_d);
            ap.setViewTextColor(this.iEN, R.color.cp_cont_d);
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
        if (iVar != null && iVar.ecf != null && iVar.ecf.getGodUserData() != null) {
            this.iEM = iVar;
            this.iEL = iVar.ecf;
            this.iAN.setData(iVar.ecf);
            this.iEI.setText(iVar.ecf.getName_show());
            this.iEJ.setText(iVar.ecf.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = iVar.ecf.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.iEN.setText("");
            } else {
                this.iEN.setText(String.format(string, recommendReason));
            }
            this.aje.a(iVar.ecf);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbA() != null) {
            cbA().a(view, this.iEM);
        }
        if (view == getView() && this.iEL != null && !StringUtils.isNull(this.iEL.getName_show()) && !StringUtils.isNull(this.iEL.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.iEL.getUserId(), this.iEL.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
