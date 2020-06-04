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
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.b<h> {
    private c agS;
    public ClickableHeaderImageView hSd;
    public CommonUserLikeButton hVW;
    private TextView hVY;
    private TextView hVZ;
    private MetaData hWb;
    private h hWc;
    private TextView hWd;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.hSd = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.hSd.setGodIconMargin(R.dimen.ds6);
        this.hSd.setAfterClickListener(this);
        this.hVY = (TextView) getView().findViewById(R.id.god_name);
        this.hVZ = (TextView) getView().findViewById(R.id.god_describe);
        this.hWd = (TextView) getView().findViewById(R.id.rec_reason);
        this.hVW = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.agS = new c(tbPageContext, this.hVW);
        this.hVW.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.hVY, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hVZ, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hWd, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
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
        if (hVar != null && hVar.dFJ != null && hVar.dFJ.getGodUserData() != null) {
            this.hWc = hVar;
            this.hWb = hVar.dFJ;
            this.hSd.setData(hVar.dFJ);
            this.hVY.setText(hVar.dFJ.getName_show());
            this.hVZ.setText(hVar.dFJ.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.dFJ.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.hWd.setText("");
            } else {
                this.hWd.setText(String.format(string, recommendReason));
            }
            this.agS.a(hVar.dFJ);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKU() != null) {
            bKU().a(view, this.hWc);
        }
        if (view == getView() && this.hWb != null && !StringUtils.isNull(this.hWb.getName_show()) && !StringUtils.isNull(this.hWb.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.hWb.getUserId(), this.hWb.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
