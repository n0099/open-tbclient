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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c cxK;
    public ClickableHeaderImageView dFa;
    public CommonUserLikeButton dLo;
    private TextView dLq;
    private TextView dLr;
    private MetaData dLt;
    private f dLu;
    private TextView dLv;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dFa = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dFa.setGodIconMargin(d.e.ds6);
        this.dFa.setAfterClickListener(this);
        this.dLq = (TextView) getView().findViewById(d.g.god_name);
        this.dLr = (TextView) getView().findViewById(d.g.god_describe);
        this.dLv = (TextView) getView().findViewById(d.g.rec_reason);
        this.dLo = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cxK = new c(tbPageContext, this.dLo);
        this.dLo.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.f.home_thread_card_item_bg);
            al.h(this.dLq, d.C0141d.cp_cont_b);
            al.h(this.dLr, d.C0141d.cp_cont_d);
            al.h(this.dLv, d.C0141d.cp_cont_d);
            al.j(this.mBottomLine, d.C0141d.cp_bg_line_b);
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
        if (fVar != null && fVar.aik != null && fVar.aik.getGodUserData() != null) {
            this.dLu = fVar;
            this.dLt = fVar.aik;
            this.dFa.setData(fVar.aik);
            this.dLq.setText(fVar.aik.getName_show());
            this.dLr.setText(fVar.aik.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(d.k.recommend_reason);
            String recommendReason = fVar.aik.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.dLv.setText("");
            } else {
                this.dLv.setText(String.format(string, recommendReason));
            }
            this.cxK.a(fVar.aik);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiI() != null) {
            aiI().a(view, this.dLu);
        }
        if (view == getView() && this.dLt != null && !StringUtils.isNull(this.dLt.getName_show()) && !StringUtils.isNull(this.dLt.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.dLt.getUserId(), this.dLt.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
