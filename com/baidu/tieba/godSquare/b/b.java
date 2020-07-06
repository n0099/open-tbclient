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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.b<h> {
    private c ahX;
    public ClickableHeaderImageView igx;
    public CommonUserLikeButton ikr;
    private TextView ikt;
    private TextView iku;
    private MetaData ikw;
    private h ikx;
    private TextView iky;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.igx = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.igx.setGodIconMargin(R.dimen.ds6);
        this.igx.setAfterClickListener(this);
        this.ikt = (TextView) getView().findViewById(R.id.god_name);
        this.iku = (TextView) getView().findViewById(R.id.god_describe);
        this.iky = (TextView) getView().findViewById(R.id.rec_reason);
        this.ikr = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ahX = new c(tbPageContext, this.ikr);
        this.ikr.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            an.setViewTextColor(this.ikt, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.iku, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.iky, (int) R.color.cp_cont_d);
            an.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
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
        if (hVar != null && hVar.dMu != null && hVar.dMu.getGodUserData() != null) {
            this.ikx = hVar;
            this.ikw = hVar.dMu;
            this.igx.setData(hVar.dMu);
            this.ikt.setText(hVar.dMu.getName_show());
            this.iku.setText(hVar.dMu.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.dMu.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.iky.setText("");
            } else {
                this.iky.setText(String.format(string, recommendReason));
            }
            this.ahX.a(hVar.dMu);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bOd() != null) {
            bOd().a(view, this.ikx);
        }
        if (view == getView() && this.ikw != null && !StringUtils.isNull(this.ikw.getName_show()) && !StringUtils.isNull(this.ikw.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.ikw.getUserId(), this.ikw.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
