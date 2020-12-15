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
    public ClickableHeaderImageView jDE;
    private h jHA;
    private TextView jHB;
    public CommonUserLikeButton jHu;
    private TextView jHw;
    private TextView jHx;
    private MetaData jHz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jDE = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jDE.setGodIconMargin(R.dimen.ds6);
        this.jDE.setAfterClickListener(this);
        this.jHw = (TextView) getView().findViewById(R.id.god_name);
        this.jHx = (TextView) getView().findViewById(R.id.god_describe);
        this.jHB = (TextView) getView().findViewById(R.id.rec_reason);
        this.jHu = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.akZ = new c(tbPageContext, this.jHu);
        this.jHu.setAfterOnClickListener(this);
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
            ap.setViewTextColor(this.jHw, R.color.CAM_X0105);
            ap.setViewTextColor(this.jHx, R.color.CAM_X0109);
            ap.setViewTextColor(this.jHB, R.color.CAM_X0109);
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
            this.jHA = hVar;
            this.jHz = hVar.eKe;
            this.jDE.setData(hVar.eKe);
            this.jHw.setText(hVar.eKe.getName_show());
            this.jHx.setText(hVar.eKe.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.eKe.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.jHB.setText("");
            } else {
                this.jHB.setText(String.format(string, recommendReason));
            }
            this.akZ.a(hVar.eKe);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crJ() != null) {
            crJ().a(view, this.jHA);
        }
        if (view == getView() && this.jHz != null && !StringUtils.isNull(this.jHz.getName_show()) && !StringUtils.isNull(this.jHz.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.jHz.getUserId(), this.jHz.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
