package com.baidu.tieba.godSquare.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private c cUn;
    public ClickableHeaderImageView eiq;
    public CommonUserLikeButton eoN;
    private TextView eoO;
    private TextView eoP;
    private TextView eoQ;
    private Drawable eoR;
    private MetaData eoS;
    private f eoT;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.eiq = (ClickableHeaderImageView) getView().findViewById(e.g.god_header_view);
        this.eiq.setGodIconMargin(e.C0210e.ds4);
        this.eiq.setAfterClickListener(this);
        this.eoP = (TextView) getView().findViewById(e.g.god_name);
        this.eoQ = (TextView) getView().findViewById(e.g.god_describe);
        this.eoN = (CommonUserLikeButton) getView().findViewById(e.g.god_like_btn);
        this.cUn = new c(tbPageContext, this.eoN);
        this.eoN.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(e.g.bottom_line);
        this.eoO = (TextView) getView().findViewById(e.g.god_rank);
        this.eoR = this.mPageContext.getResources().getDrawable(e.f.transparent_bg);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.f.home_thread_card_item_bg);
            al.h(this.eoP, e.d.cp_cont_b);
            al.h(this.eoQ, e.d.cp_cont_d);
            al.j(this.mBottomLine, e.d.cp_bg_line_b);
            al.h(this.eoO, e.d.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null && fVar.atK != null && fVar.atK.getGodUserData() != null) {
            this.eoT = fVar;
            this.eoS = fVar.atK;
            ok(fVar.rank);
            this.eiq.setData(fVar.atK);
            this.eoP.setText(fVar.atK.getName_show());
            this.eoQ.setText(fVar.atK.getGodUserData().getIntro());
            this.cUn.a(fVar.atK);
            d(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void ok(int i) {
        String str;
        switch (i) {
            case 1:
                this.eoO.setText("");
                al.i(this.eoO, e.f.icon_grade_round_no1);
                return;
            case 2:
                this.eoO.setText("");
                al.i(this.eoO, e.f.icon_grade_round_no2);
                return;
            case 3:
                this.eoO.setText("");
                al.i(this.eoO, e.f.icon_grade_round_no3);
                return;
            default:
                this.eoO.setBackgroundDrawable(this.eoR);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.eoO.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apc() != null) {
            apc().a(view, this.eoT);
        }
        if (view == getView() && this.eoS != null && !StringUtils.isNull(this.eoS.getName_show()) && !StringUtils.isNull(this.eoS.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(this.eoS.getUserId(), 0L), false, this.eoS.isBigV())));
        }
    }
}
