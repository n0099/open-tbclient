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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
/* loaded from: classes8.dex */
public class b extends com.baidu.tieba.card.b<h> {
    private c akz;
    public ClickableHeaderImageView jSx;
    public CommonUserLikeButton jXJ;
    private TextView jXL;
    private TextView jXM;
    private MetaData jXO;
    private h jXP;
    private TextView jXQ;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jSx = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jSx.setGodIconMargin(R.dimen.ds6);
        this.jSx.setAfterClickListener(this);
        this.jXL = (TextView) getView().findViewById(R.id.god_name);
        this.jXM = (TextView) getView().findViewById(R.id.god_describe);
        this.jXQ = (TextView) getView().findViewById(R.id.rec_reason);
        this.jXJ = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.akz = new c(tbPageContext, this.jXJ);
        this.jXJ.setAfterOnClickListener(this);
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
            ap.setViewTextColor(this.jXL, R.color.CAM_X0105);
            ap.setViewTextColor(this.jXM, R.color.CAM_X0109);
            ap.setViewTextColor(this.jXQ, R.color.CAM_X0109);
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
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
        if (hVar != null && hVar.eRz != null && hVar.eRz.getGodUserData() != null) {
            this.jXP = hVar;
            this.jXO = hVar.eRz;
            this.jSx.setData(hVar.eRz);
            this.jXL.setText(hVar.eRz.getName_show());
            this.jXM.setText(hVar.eRz.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.eRz.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.jXQ.setText("");
            } else {
                this.jXQ.setText(String.format(string, recommendReason));
            }
            this.akz.a(hVar.eRz);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crV() != null) {
            crV().a(view, this.jXP);
        }
        if (view == getView() && this.jXO != null && !StringUtils.isNull(this.jXO.getName_show()) && !StringUtils.isNull(this.jXO.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.jXO.getUserId(), this.jXO.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
