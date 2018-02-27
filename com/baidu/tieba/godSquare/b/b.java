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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c cVX;
    public ClickableHeaderImageView dZI;
    public CommonUserLikeButton eee;
    private TextView eeg;
    private TextView eeh;
    private MetaData eej;
    private f eek;
    private TextView eel;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dZI = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dZI.setGodIconMargin(d.e.ds6);
        this.dZI.setAfterClickListener(this);
        this.eeg = (TextView) getView().findViewById(d.g.god_name);
        this.eeh = (TextView) getView().findViewById(d.g.god_describe);
        this.eel = (TextView) getView().findViewById(d.g.rec_reason);
        this.eee = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cVX = new c(tbPageContext, this.eee);
        this.eee.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(getView(), d.f.home_thread_card_item_bg);
            aj.r(this.eeg, d.C0141d.cp_cont_b);
            aj.r(this.eeh, d.C0141d.cp_cont_d);
            aj.r(this.eel, d.C0141d.cp_cont_d);
            aj.t(this.mBottomLine, d.C0141d.cp_bg_line_b);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_god_square_rec_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.aOF != null && fVar.aOF.getGodUserData() != null) {
            this.eek = fVar;
            this.eej = fVar.aOF;
            this.dZI.setData(fVar.aOF);
            this.eeg.setText(fVar.aOF.getName_show());
            this.eeh.setText(fVar.aOF.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(d.j.recommend_reason);
            String recommendReason = fVar.aOF.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.eel.setText("");
            } else {
                this.eel.setText(String.format(string, recommendReason));
            }
            this.cVX.a(fVar.aOF);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akO() != null) {
            akO().a(view, this.eek);
        }
        if (view == getView() && this.eej != null && !StringUtils.isNull(this.eej.getName_show()) && !StringUtils.isNull(this.eej.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.eej.getUserId(), this.eej.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
