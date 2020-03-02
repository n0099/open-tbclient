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
    public ClickableHeaderImageView gRp;
    public CommonUserLikeButton gVh;
    private TextView gVj;
    private TextView gVk;
    private MetaData gVm;
    private h gVn;
    private TextView gVo;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.gRp = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.gRp.setGodIconMargin(R.dimen.ds6);
        this.gRp.setAfterClickListener(this);
        this.gVj = (TextView) getView().findViewById(R.id.god_name);
        this.gVk = (TextView) getView().findViewById(R.id.god_describe);
        this.gVo = (TextView) getView().findViewById(R.id.rec_reason);
        this.gVh = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.NB = new c(tbPageContext, this.gVh);
        this.gVh.setAfterOnClickListener(this);
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
            am.setViewTextColor(this.gVj, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gVk, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.gVo, (int) R.color.cp_cont_d);
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
        if (hVar != null && hVar.cSn != null && hVar.cSn.getGodUserData() != null) {
            this.gVn = hVar;
            this.gVm = hVar.cSn;
            this.gRp.setData(hVar.cSn);
            this.gVj.setText(hVar.cSn.getName_show());
            this.gVk.setText(hVar.cSn.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.cSn.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.gVo.setText("");
            } else {
                this.gVo.setText(String.format(string, recommendReason));
            }
            this.NB.a(hVar.cSn);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buG() != null) {
            buG().a(view, this.gVn);
        }
        if (view == getView() && this.gVm != null && !StringUtils.isNull(this.gVm.getName_show()) && !StringUtils.isNull(this.gVm.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.gVm.getUserId(), this.gVm.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
