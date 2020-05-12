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
public class b extends com.baidu.tieba.card.a<h> {
    private c agp;
    public ClickableHeaderImageView hCD;
    private TextView hGA;
    private MetaData hGC;
    private h hGD;
    private TextView hGE;
    public CommonUserLikeButton hGx;
    private TextView hGz;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.hCD = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.hCD.setGodIconMargin(R.dimen.ds6);
        this.hCD.setAfterClickListener(this);
        this.hGz = (TextView) getView().findViewById(R.id.god_name);
        this.hGA = (TextView) getView().findViewById(R.id.god_describe);
        this.hGE = (TextView) getView().findViewById(R.id.rec_reason);
        this.hGx = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.agp = new c(tbPageContext, this.hGx);
        this.hGx.setAfterOnClickListener(this);
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
            am.setViewTextColor(this.hGz, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hGA, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hGE, (int) R.color.cp_cont_d);
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
        if (hVar != null && hVar.drO != null && hVar.drO.getGodUserData() != null) {
            this.hGD = hVar;
            this.hGC = hVar.drO;
            this.hCD.setData(hVar.drO);
            this.hGz.setText(hVar.drO.getName_show());
            this.hGA.setText(hVar.drO.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.drO.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.hGE.setText("");
            } else {
                this.hGE.setText(String.format(string, recommendReason));
            }
            this.agp.a(hVar.drO);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEx() != null) {
            bEx().a(view, this.hGD);
        }
        if (view == getView() && this.hGC != null && !StringUtils.isNull(this.hGC.getName_show()) && !StringUtils.isNull(this.hGC.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.hGC.getUserId(), this.hGC.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
