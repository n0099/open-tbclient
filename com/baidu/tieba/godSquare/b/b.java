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
    private c ajW;
    public ClickableHeaderImageView jjx;
    public CommonUserLikeButton jno;
    private TextView jnq;
    private TextView jnr;
    private MetaData jnt;
    private i jnu;
    private TextView jnv;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jjx = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jjx.setGodIconMargin(R.dimen.ds6);
        this.jjx.setAfterClickListener(this);
        this.jnq = (TextView) getView().findViewById(R.id.god_name);
        this.jnr = (TextView) getView().findViewById(R.id.god_describe);
        this.jnv = (TextView) getView().findViewById(R.id.rec_reason);
        this.jno = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ajW = new c(tbPageContext, this.jno);
        this.jno.setAfterOnClickListener(this);
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
            ap.setViewTextColor(this.jnq, R.color.cp_cont_b);
            ap.setViewTextColor(this.jnr, R.color.cp_cont_d);
            ap.setViewTextColor(this.jnv, R.color.cp_cont_d);
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
        if (iVar != null && iVar.eyV != null && iVar.eyV.getGodUserData() != null) {
            this.jnu = iVar;
            this.jnt = iVar.eyV;
            this.jjx.setData(iVar.eyV);
            this.jnq.setText(iVar.eyV.getName_show());
            this.jnr.setText(iVar.eyV.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = iVar.eyV.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.jnv.setText("");
            } else {
                this.jnv.setText(String.format(string, recommendReason));
            }
            this.ajW.a(iVar.eyV);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cls() != null) {
            cls().a(view, this.jnu);
        }
        if (view == getView() && this.jnt != null && !StringUtils.isNull(this.jnt.getName_show()) && !StringUtils.isNull(this.jnt.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.jnt.getUserId(), this.jnt.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
