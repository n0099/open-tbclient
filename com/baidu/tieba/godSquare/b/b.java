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
    private c eLD;
    public ClickableHeaderImageView fXu;
    public CommonUserLikeButton gbH;
    private TextView gbJ;
    private TextView gbK;
    private MetaData gbM;
    private f gbN;
    private TextView gbO;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.fXu = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.fXu.setGodIconMargin(R.dimen.ds6);
        this.fXu.setAfterClickListener(this);
        this.gbJ = (TextView) getView().findViewById(R.id.god_name);
        this.gbK = (TextView) getView().findViewById(R.id.god_describe);
        this.gbO = (TextView) getView().findViewById(R.id.rec_reason);
        this.gbH = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.eLD = new c(tbPageContext, this.gbH);
        this.gbH.setAfterOnClickListener(this);
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
            am.setViewTextColor(this.gbJ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gbK, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gbO, (int) R.color.cp_cont_d);
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
        if (fVar != null && fVar.cbv != null && fVar.cbv.getGodUserData() != null) {
            this.gbN = fVar;
            this.gbM = fVar.cbv;
            this.fXu.setData(fVar.cbv);
            this.gbJ.setText(fVar.cbv.getName_show());
            this.gbK.setText(fVar.cbv.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = fVar.cbv.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.gbO.setText("");
            } else {
                this.gbO.setText(String.format(string, recommendReason));
            }
            this.eLD.a(fVar.cbv);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZV() != null) {
            aZV().a(view, this.gbN);
        }
        if (view == getView() && this.gbM != null && !StringUtils.isNull(this.gbM.getName_show()) && !StringUtils.isNull(this.gbM.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.gbM.getUserId(), this.gbM.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
