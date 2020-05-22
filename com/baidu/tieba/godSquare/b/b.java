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
    public ClickableHeaderImageView hRq;
    public CommonUserLikeButton hVj;
    private TextView hVl;
    private TextView hVm;
    private MetaData hVo;
    private h hVp;
    private TextView hVq;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.hRq = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.hRq.setGodIconMargin(R.dimen.ds6);
        this.hRq.setAfterClickListener(this);
        this.hVl = (TextView) getView().findViewById(R.id.god_name);
        this.hVm = (TextView) getView().findViewById(R.id.god_describe);
        this.hVq = (TextView) getView().findViewById(R.id.rec_reason);
        this.hVj = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.agS = new c(tbPageContext, this.hVj);
        this.hVj.setAfterOnClickListener(this);
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
            am.setViewTextColor(this.hVl, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hVm, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hVq, (int) R.color.cp_cont_d);
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
            this.hVp = hVar;
            this.hVo = hVar.dFJ;
            this.hRq.setData(hVar.dFJ);
            this.hVl.setText(hVar.dFJ.getName_show());
            this.hVm.setText(hVar.dFJ.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.dFJ.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.hVq.setText("");
            } else {
                this.hVq.setText(String.format(string, recommendReason));
            }
            this.agS.a(hVar.dFJ);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKS() != null) {
            bKS().a(view, this.hVp);
        }
        if (view == getView() && this.hVo != null && !StringUtils.isNull(this.hVo.getName_show()) && !StringUtils.isNull(this.hVo.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.hVo.getUserId(), this.hVo.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
