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
/* loaded from: classes23.dex */
public class b extends com.baidu.tieba.card.b<i> {
    private c ajD;
    public ClickableHeaderImageView iIi;
    public CommonUserLikeButton iMb;
    private TextView iMd;
    private TextView iMe;
    private MetaData iMg;
    private i iMh;
    private TextView iMi;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.iIi = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.iIi.setGodIconMargin(R.dimen.ds6);
        this.iIi.setAfterClickListener(this);
        this.iMd = (TextView) getView().findViewById(R.id.god_name);
        this.iMe = (TextView) getView().findViewById(R.id.god_describe);
        this.iMi = (TextView) getView().findViewById(R.id.rec_reason);
        this.iMb = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ajD = new c(tbPageContext, this.iMb);
        this.iMb.setAfterOnClickListener(this);
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
            ap.setViewTextColor(this.iMd, R.color.cp_cont_b);
            ap.setViewTextColor(this.iMe, R.color.cp_cont_d);
            ap.setViewTextColor(this.iMi, R.color.cp_cont_d);
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
        if (iVar != null && iVar.eep != null && iVar.eep.getGodUserData() != null) {
            this.iMh = iVar;
            this.iMg = iVar.eep;
            this.iIi.setData(iVar.eep);
            this.iMd.setText(iVar.eep.getName_show());
            this.iMe.setText(iVar.eep.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = iVar.eep.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.iMi.setText("");
            } else {
                this.iMi.setText(String.format(string, recommendReason));
            }
            this.ajD.a(iVar.eep);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ceP() != null) {
            ceP().a(view, this.iMh);
        }
        if (view == getView() && this.iMg != null && !StringUtils.isNull(this.iMg.getName_show()) && !StringUtils.isNull(this.iMg.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.iMg.getUserId(), this.iMg.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
