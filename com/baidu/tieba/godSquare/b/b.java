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
    private c ajc;
    public ClickableHeaderImageView iAH;
    public CommonUserLikeButton iEA;
    private TextView iEC;
    private TextView iED;
    private MetaData iEF;
    private i iEG;
    private TextView iEH;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.iAH = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.iAH.setGodIconMargin(R.dimen.ds6);
        this.iAH.setAfterClickListener(this);
        this.iEC = (TextView) getView().findViewById(R.id.god_name);
        this.iED = (TextView) getView().findViewById(R.id.god_describe);
        this.iEH = (TextView) getView().findViewById(R.id.rec_reason);
        this.iEA = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ajc = new c(tbPageContext, this.iEA);
        this.iEA.setAfterOnClickListener(this);
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
            ap.setViewTextColor(this.iEC, R.color.cp_cont_b);
            ap.setViewTextColor(this.iED, R.color.cp_cont_d);
            ap.setViewTextColor(this.iEH, R.color.cp_cont_d);
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
        if (iVar != null && iVar.ecb != null && iVar.ecb.getGodUserData() != null) {
            this.iEG = iVar;
            this.iEF = iVar.ecb;
            this.iAH.setData(iVar.ecb);
            this.iEC.setText(iVar.ecb.getName_show());
            this.iED.setText(iVar.ecb.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = iVar.ecb.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.iEH.setText("");
            } else {
                this.iEH.setText(String.format(string, recommendReason));
            }
            this.ajc.a(iVar.ecb);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbz() != null) {
            cbz().a(view, this.iEG);
        }
        if (view == getView() && this.iEF != null && !StringUtils.isNull(this.iEF.getName_show()) && !StringUtils.isNull(this.iEF.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.iEF.getUserId(), this.iEF.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
