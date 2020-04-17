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
    private c agm;
    public ClickableHeaderImageView hCx;
    public CommonUserLikeButton hGr;
    private TextView hGt;
    private TextView hGu;
    private MetaData hGw;
    private h hGx;
    private TextView hGy;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.hCx = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.hCx.setGodIconMargin(R.dimen.ds6);
        this.hCx.setAfterClickListener(this);
        this.hGt = (TextView) getView().findViewById(R.id.god_name);
        this.hGu = (TextView) getView().findViewById(R.id.god_describe);
        this.hGy = (TextView) getView().findViewById(R.id.rec_reason);
        this.hGr = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.agm = new c(tbPageContext, this.hGr);
        this.hGr.setAfterOnClickListener(this);
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
            am.setViewTextColor(this.hGt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hGu, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hGy, (int) R.color.cp_cont_d);
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
        if (hVar != null && hVar.drK != null && hVar.drK.getGodUserData() != null) {
            this.hGx = hVar;
            this.hGw = hVar.drK;
            this.hCx.setData(hVar.drK);
            this.hGt.setText(hVar.drK.getName_show());
            this.hGu.setText(hVar.drK.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(R.string.recommend_reason);
            String recommendReason = hVar.drK.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.hGy.setText("");
            } else {
                this.hGy.setText(String.format(string, recommendReason));
            }
            this.agm.a(hVar.drK);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEy() != null) {
            bEy().a(view, this.hGx);
        }
        if (view == getView() && this.hGw != null && !StringUtils.isNull(this.hGw.getName_show()) && !StringUtils.isNull(this.hGw.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.hGw.getUserId(), this.hGw.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
