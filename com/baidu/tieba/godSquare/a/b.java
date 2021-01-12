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
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.card.b<h> {
    private c akK;
    public ClickableHeaderImageView jLA;
    public CommonUserLikeButton jQh;
    private TextView jQj;
    private TextView jQk;
    private MetaData jQm;
    private h jQn;
    private TextView jQo;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jLA = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jLA.setGodIconMargin(R.dimen.ds6);
        this.jLA.setAfterClickListener(this);
        this.jQj = (TextView) getView().findViewById(R.id.god_name);
        this.jQk = (TextView) getView().findViewById(R.id.god_describe);
        this.jQo = (TextView) getView().findViewById(R.id.rec_reason);
        this.jQh = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.akK = new c(tbPageContext, this.jQh);
        this.jQh.setAfterOnClickListener(this);
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
            ao.setViewTextColor(this.jQj, R.color.CAM_X0105);
            ao.setViewTextColor(this.jQk, R.color.CAM_X0109);
            ao.setViewTextColor(this.jQo, R.color.CAM_X0109);
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
        if (hVar != null && hVar.ePn != null && hVar.ePn.getGodUserData() != null) {
            this.jQn = hVar;
            this.jQm = hVar.ePn;
            this.jLA.setData(hVar.ePn);
            this.jQj.setText(hVar.ePn.getName_show());
            this.jQk.setText(hVar.ePn.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.ePn.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.jQo.setText("");
            } else {
                this.jQo.setText(String.format(string, recommendReason));
            }
            this.akK.a(hVar.ePn);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cqL() != null) {
            cqL().a(view, this.jQn);
        }
        if (view == getView() && this.jQm != null && !StringUtils.isNull(this.jQm.getName_show()) && !StringUtils.isNull(this.jQm.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.jQm.getUserId(), this.jQm.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
