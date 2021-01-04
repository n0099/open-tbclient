package com.baidu.tieba.godSquare.a;

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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
/* loaded from: classes8.dex */
public class b extends com.baidu.tieba.card.b<h> {
    private c alC;
    public ClickableHeaderImageView jQg;
    public CommonUserLikeButton jUM;
    private TextView jUO;
    private TextView jUP;
    private MetaData jUR;
    private h jUS;
    private TextView jUT;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jQg = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jQg.setGodIconMargin(R.dimen.ds6);
        this.jQg.setAfterClickListener(this);
        this.jUO = (TextView) getView().findViewById(R.id.god_name);
        this.jUP = (TextView) getView().findViewById(R.id.god_describe);
        this.jUT = (TextView) getView().findViewById(R.id.rec_reason);
        this.jUM = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.alC = new c(tbPageContext, this.jUM);
        this.jUM.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ao.setViewTextColor(this.jUO, R.color.CAM_X0105);
            ao.setViewTextColor(this.jUP, R.color.CAM_X0109);
            ao.setViewTextColor(this.jUT, R.color.CAM_X0109);
            ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(h hVar) {
        if (hVar != null && hVar.eTY != null && hVar.eTY.getGodUserData() != null) {
            this.jUS = hVar;
            this.jUR = hVar.eTY;
            this.jQg.setData(hVar.eTY);
            this.jUO.setText(hVar.eTY.getName_show());
            this.jUP.setText(hVar.eTY.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.eTY.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.jUT.setText("");
            } else {
                this.jUT.setText(String.format(string, recommendReason));
            }
            this.alC.a(hVar.eTY);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cuC() != null) {
            cuC().a(view, this.jUS);
        }
        if (view == getView() && this.jUR != null && !StringUtils.isNull(this.jUR.getName_show()) && !StringUtils.isNull(this.jUR.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.jUR.getUserId(), this.jUR.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
