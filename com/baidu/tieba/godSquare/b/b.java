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
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.a<h> {
    private c Nb;
    public ClickableHeaderImageView gPn;
    public CommonUserLikeButton gTf;
    private TextView gTh;
    private TextView gTi;
    private MetaData gTk;
    private h gTl;
    private TextView gTm;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.gPn = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.gPn.setGodIconMargin(R.dimen.ds6);
        this.gPn.setAfterClickListener(this);
        this.gTh = (TextView) getView().findViewById(R.id.god_name);
        this.gTi = (TextView) getView().findViewById(R.id.god_describe);
        this.gTm = (TextView) getView().findViewById(R.id.rec_reason);
        this.gTf = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.Nb = new c(tbPageContext, this.gTf);
        this.gTf.setAfterOnClickListener(this);
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
            am.setViewTextColor(this.gTh, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gTi, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gTm, (int) R.color.cp_cont_d);
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
        if (hVar != null && hVar.cOj != null && hVar.cOj.getGodUserData() != null) {
            this.gTl = hVar;
            this.gTk = hVar.cOj;
            this.gPn.setData(hVar.cOj);
            this.gTh.setText(hVar.cOj.getName_show());
            this.gTi.setText(hVar.cOj.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.cOj.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.gTm.setText("");
            } else {
                this.gTm.setText(String.format(string, recommendReason));
            }
            this.Nb.a(hVar.cOj);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bta() != null) {
            bta().a(view, this.gTl);
        }
        if (view == getView() && this.gTk != null && !StringUtils.isNull(this.gTk.getName_show()) && !StringUtils.isNull(this.gTk.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.gTk.getUserId(), this.gTk.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
