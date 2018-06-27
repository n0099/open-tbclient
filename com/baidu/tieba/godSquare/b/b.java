package com.baidu.tieba.godSquare.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c cvR;
    public ClickableHeaderImageView dIv;
    public CommonUserLikeButton dOF;
    private TextView dOH;
    private TextView dOI;
    private MetaData dOK;
    private f dOL;
    private TextView dOM;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dIv = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dIv.setGodIconMargin(d.e.ds6);
        this.dIv.setAfterClickListener(this);
        this.dOH = (TextView) getView().findViewById(d.g.god_name);
        this.dOI = (TextView) getView().findViewById(d.g.god_describe);
        this.dOM = (TextView) getView().findViewById(d.g.rec_reason);
        this.dOF = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cvR = new c(tbPageContext, this.dOF);
        this.dOF.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.f.home_thread_card_item_bg);
            am.h(this.dOH, d.C0142d.cp_cont_b);
            am.h(this.dOI, d.C0142d.cp_cont_d);
            am.h(this.dOM, d.C0142d.cp_cont_d);
            am.j(this.mBottomLine, d.C0142d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.aiE != null && fVar.aiE.getGodUserData() != null) {
            this.dOL = fVar;
            this.dOK = fVar.aiE;
            this.dIv.setData(fVar.aiE);
            this.dOH.setText(fVar.aiE.getName_show());
            this.dOI.setText(fVar.aiE.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(d.k.recommend_reason);
            String recommendReason = fVar.aiE.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.dOM.setText("");
            } else {
                this.dOM.setText(String.format(string, recommendReason));
            }
            this.cvR.a(fVar.aiE);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aia() != null) {
            aia().a(view, this.dOL);
        }
        if (view == getView() && this.dOK != null && !StringUtils.isNull(this.dOK.getName_show()) && !StringUtils.isNull(this.dOK.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.dOK.getUserId(), this.dOK.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
