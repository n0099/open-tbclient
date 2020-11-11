package com.baidu.tieba.godSquare.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.i;
/* loaded from: classes24.dex */
public class a extends com.baidu.tieba.card.b<i> {
    private c ajW;
    public ClickableHeaderImageView jpv;
    public CommonUserLikeButton jtl;
    private TextView jtm;
    private TextView jtn;
    private TextView jto;
    private Drawable jtp;
    private MetaData jtq;
    private i jtr;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jpv = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jpv.setGodIconMargin(R.dimen.ds4);
        this.jpv.setAfterClickListener(this);
        this.jtn = (TextView) getView().findViewById(R.id.god_name);
        this.jto = (TextView) getView().findViewById(R.id.god_describe);
        this.jtl = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ajW = new c(tbPageContext, this.jtl);
        this.jtl.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.jtm = (TextView) getView().findViewById(R.id.god_rank);
        this.jtp = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.jtn, R.color.cp_cont_b);
            ap.setViewTextColor(this.jto, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.jtm, R.color.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(i iVar) {
        if (iVar != null && iVar.eEK != null && iVar.eEK.getGodUserData() != null) {
            this.jtr = iVar;
            this.jtq = iVar.eEK;
            Bj(iVar.rank);
            this.jpv.setData(iVar.eEK);
            this.jtn.setText(iVar.eEK.getName_show());
            this.jto.setText(iVar.eEK.getGodUserData().getIntro());
            this.ajW.a(iVar.eEK);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Bj(int i) {
        String str;
        switch (i) {
            case 1:
                this.jtm.setText("");
                ap.setBackgroundResource(this.jtm, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.jtm.setText("");
                ap.setBackgroundResource(this.jtm, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.jtm.setText("");
                ap.setBackgroundResource(this.jtm, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.jtm.setBackgroundDrawable(this.jtp);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.jtm.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnT() != null) {
            cnT().a(view, this.jtr);
        }
        if (view == getView() && this.jtq != null && !StringUtils.isNull(this.jtq.getName_show()) && !StringUtils.isNull(this.jtq.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jtq.getUserId(), 0L), false, this.jtq.isBigV())));
        }
    }
}
