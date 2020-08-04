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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.card.b<h> {
    private c ahO;
    public ClickableHeaderImageView imD;
    private MetaData iqB;
    private h iqC;
    private TextView iqD;
    public CommonUserLikeButton iqw;
    private TextView iqy;
    private TextView iqz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.imD = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.imD.setGodIconMargin(R.dimen.ds6);
        this.imD.setAfterClickListener(this);
        this.iqy = (TextView) getView().findViewById(R.id.god_name);
        this.iqz = (TextView) getView().findViewById(R.id.god_describe);
        this.iqD = (TextView) getView().findViewById(R.id.rec_reason);
        this.iqw = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ahO = new c(tbPageContext, this.iqw);
        this.iqw.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
    }

    public void m(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ao.setViewTextColor(this.iqy, R.color.cp_cont_b);
            ao.setViewTextColor(this.iqz, R.color.cp_cont_d);
            ao.setViewTextColor(this.iqD, R.color.cp_cont_d);
            ao.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
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
        if (hVar != null && hVar.dSF != null && hVar.dSF.getGodUserData() != null) {
            this.iqC = hVar;
            this.iqB = hVar.dSF;
            this.imD.setData(hVar.dSF);
            this.iqy.setText(hVar.dSF.getName_show());
            this.iqz.setText(hVar.dSF.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.dSF.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.iqD.setText("");
            } else {
                this.iqD.setText(String.format(string, recommendReason));
            }
            this.ahO.a(hVar.dSF);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bRn() != null) {
            bRn().a(view, this.iqC);
        }
        if (view == getView() && this.iqB != null && !StringUtils.isNull(this.iqB.getName_show()) && !StringUtils.isNull(this.iqB.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.iqB.getUserId(), this.iqB.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
