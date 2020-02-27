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
    private c NB;
    public ClickableHeaderImageView gRn;
    public CommonUserLikeButton gVf;
    private TextView gVh;
    private TextView gVi;
    private MetaData gVk;
    private h gVl;
    private TextView gVm;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.gRn = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.gRn.setGodIconMargin(R.dimen.ds6);
        this.gRn.setAfterClickListener(this);
        this.gVh = (TextView) getView().findViewById(R.id.god_name);
        this.gVi = (TextView) getView().findViewById(R.id.god_describe);
        this.gVm = (TextView) getView().findViewById(R.id.rec_reason);
        this.gVf = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.NB = new c(tbPageContext, this.gVf);
        this.gVf.setAfterOnClickListener(this);
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
            am.setViewTextColor(this.gVh, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gVi, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gVm, (int) R.color.cp_cont_d);
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
        if (hVar != null && hVar.cSm != null && hVar.cSm.getGodUserData() != null) {
            this.gVl = hVar;
            this.gVk = hVar.cSm;
            this.gRn.setData(hVar.cSm);
            this.gVh.setText(hVar.cSm.getName_show());
            this.gVi.setText(hVar.cSm.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.cSm.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.gVm.setText("");
            } else {
                this.gVm.setText(String.format(string, recommendReason));
            }
            this.NB.a(hVar.cSm);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buE() != null) {
            buE().a(view, this.gVl);
        }
        if (view == getView() && this.gVk != null && !StringUtils.isNull(this.gVk.getName_show()) && !StringUtils.isNull(this.gVk.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.gVk.getUserId(), this.gVk.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
