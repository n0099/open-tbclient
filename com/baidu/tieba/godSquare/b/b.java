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
import com.baidu.tieba.card.data.h;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.card.b<h> {
    private c akZ;
    public ClickableHeaderImageView jDC;
    public CommonUserLikeButton jHs;
    private TextView jHu;
    private TextView jHv;
    private MetaData jHx;
    private h jHy;
    private TextView jHz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jDC = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jDC.setGodIconMargin(R.dimen.ds6);
        this.jDC.setAfterClickListener(this);
        this.jHu = (TextView) getView().findViewById(R.id.god_name);
        this.jHv = (TextView) getView().findViewById(R.id.god_describe);
        this.jHz = (TextView) getView().findViewById(R.id.rec_reason);
        this.jHs = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.akZ = new c(tbPageContext, this.jHs);
        this.jHs.setAfterOnClickListener(this);
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
            ap.setViewTextColor(this.jHu, R.color.CAM_X0105);
            ap.setViewTextColor(this.jHv, R.color.CAM_X0109);
            ap.setViewTextColor(this.jHz, R.color.CAM_X0109);
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
        if (hVar != null && hVar.eKe != null && hVar.eKe.getGodUserData() != null) {
            this.jHy = hVar;
            this.jHx = hVar.eKe;
            this.jDC.setData(hVar.eKe);
            this.jHu.setText(hVar.eKe.getName_show());
            this.jHv.setText(hVar.eKe.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.eKe.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.jHz.setText("");
            } else {
                this.jHz.setText(String.format(string, recommendReason));
            }
            this.akZ.a(hVar.eKe);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crI() != null) {
            crI().a(view, this.jHy);
        }
        if (view == getView() && this.jHx != null && !StringUtils.isNull(this.jHx.getName_show()) && !StringUtils.isNull(this.jHx.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.jHx.getUserId(), this.jHx.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
