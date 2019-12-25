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
import com.baidu.tieba.card.data.h;
/* loaded from: classes8.dex */
public class b extends com.baidu.tieba.card.a<h> {
    private c MX;
    public ClickableHeaderImageView gLS;
    public CommonUserLikeButton gPL;
    private TextView gPN;
    private TextView gPO;
    private MetaData gPQ;
    private h gPR;
    private TextView gPS;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.gLS = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.gLS.setGodIconMargin(R.dimen.ds6);
        this.gLS.setAfterClickListener(this);
        this.gPN = (TextView) getView().findViewById(R.id.god_name);
        this.gPO = (TextView) getView().findViewById(R.id.god_describe);
        this.gPS = (TextView) getView().findViewById(R.id.rec_reason);
        this.gPL = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.MX = new c(tbPageContext, this.gPL);
        this.gPL.setAfterOnClickListener(this);
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
            am.setViewTextColor(this.gPN, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gPO, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gPS, (int) R.color.cp_cont_d);
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
    public void a(h hVar) {
        if (hVar != null && hVar.cNZ != null && hVar.cNZ.getGodUserData() != null) {
            this.gPR = hVar;
            this.gPQ = hVar.cNZ;
            this.gLS.setData(hVar.cNZ);
            this.gPN.setText(hVar.cNZ.getName_show());
            this.gPO.setText(hVar.cNZ.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.cNZ.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.gPS.setText("");
            } else {
                this.gPS.setText(String.format(string, recommendReason));
            }
            this.MX.a(hVar.cNZ);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (brY() != null) {
            brY().a(view, this.gPR);
        }
        if (view == getView() && this.gPQ != null && !StringUtils.isNull(this.gPQ.getName_show()) && !StringUtils.isNull(this.gPQ.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.gPQ.getUserId(), this.gPQ.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
