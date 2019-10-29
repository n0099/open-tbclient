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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.f;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c eMu;
    public ClickableHeaderImageView fYl;
    private TextView gcA;
    private TextView gcB;
    private MetaData gcD;
    private f gcE;
    private TextView gcF;
    public CommonUserLikeButton gcy;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fYl = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fYl.setGodIconMargin(R.dimen.ds6);
        this.fYl.setAfterClickListener(this);
        this.gcA = (TextView) getView().findViewById(R.id.god_name);
        this.gcB = (TextView) getView().findViewById(R.id.god_describe);
        this.gcF = (TextView) getView().findViewById(R.id.rec_reason);
        this.gcy = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.eMu = new c(tbPageContext, this.gcy);
        this.gcy.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gcA, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gcB, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gcF, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
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
        if (fVar != null && fVar.ccm != null && fVar.ccm.getGodUserData() != null) {
            this.gcE = fVar;
            this.gcD = fVar.ccm;
            this.fYl.setData(fVar.ccm);
            this.gcA.setText(fVar.ccm.getName_show());
            this.gcB.setText(fVar.ccm.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = fVar.ccm.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.gcF.setText("");
            } else {
                this.gcF.setText(String.format(string, recommendReason));
            }
            this.eMu.a(fVar.ccm);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZX() != null) {
            aZX().a(view, this.gcE);
        }
        if (view == getView() && this.gcD != null && !StringUtils.isNull(this.gcD.getName_show()) && !StringUtils.isNull(this.gcD.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.gcD.getUserId(), this.gcD.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
