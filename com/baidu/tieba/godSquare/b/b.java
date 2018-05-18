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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<f> {
    private c cpg;
    public CommonUserLikeButton dAe;
    private TextView dAg;
    private TextView dAh;
    private MetaData dAj;
    private f dAk;
    private TextView dAl;
    public ClickableHeaderImageView dvN;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.dvN = (ClickableHeaderImageView) getView().findViewById(d.g.god_header_view);
        this.dvN.setGodIconMargin(d.e.ds6);
        this.dvN.setAfterClickListener(this);
        this.dAg = (TextView) getView().findViewById(d.g.god_name);
        this.dAh = (TextView) getView().findViewById(d.g.god_describe);
        this.dAl = (TextView) getView().findViewById(d.g.rec_reason);
        this.dAe = (CommonUserLikeButton) getView().findViewById(d.g.god_like_btn);
        this.cpg = new c(tbPageContext, this.dAe);
        this.dAe.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(d.g.bottom_line);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.f.home_thread_card_item_bg);
            ak.h(this.dAg, d.C0126d.cp_cont_b);
            ak.h(this.dAh, d.C0126d.cp_cont_d);
            ak.h(this.dAl, d.C0126d.cp_cont_d);
            ak.j(this.mBottomLine, d.C0126d.cp_bg_line_b);
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
        if (fVar != null && fVar.aaf != null && fVar.aaf.getGodUserData() != null) {
            this.dAk = fVar;
            this.dAj = fVar.aaf;
            this.dvN.setData(fVar.aaf);
            this.dAg.setText(fVar.aaf.getName_show());
            this.dAh.setText(fVar.aaf.getGodUserData().getIntro());
            String string = this.mPageContext.getResources().getString(d.k.recommend_reason);
            String recommendReason = fVar.aaf.getGodUserData().getRecommendReason();
            if (StringUtils.isNull(recommendReason)) {
                this.dAl.setText("");
            } else {
                this.dAl.setText(String.format(string, recommendReason));
            }
            this.cpg.a(fVar.aaf);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(view2, this.dAk);
        }
        if (view2 == getView() && this.dAj != null && !StringUtils.isNull(this.dAj.getName_show()) && !StringUtils.isNull(this.dAj.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.mPageContext.getPageActivity(), this.dAj.getUserId(), this.dAj.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
        }
    }
}
