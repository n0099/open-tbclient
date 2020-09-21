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
/* loaded from: classes23.dex */
public class a extends com.baidu.tieba.card.b<i> {
    private c ajD;
    public ClickableHeaderImageView iIi;
    public CommonUserLikeButton iMb;
    private TextView iMc;
    private TextView iMd;
    private TextView iMe;
    private Drawable iMf;
    private MetaData iMg;
    private i iMh;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.iIi = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.iIi.setGodIconMargin(R.dimen.ds4);
        this.iIi.setAfterClickListener(this);
        this.iMd = (TextView) getView().findViewById(R.id.god_name);
        this.iMe = (TextView) getView().findViewById(R.id.god_describe);
        this.iMb = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ajD = new c(tbPageContext, this.iMb);
        this.iMb.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.iMc = (TextView) getView().findViewById(R.id.god_rank);
        this.iMf = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.iMd, R.color.cp_cont_b);
            ap.setViewTextColor(this.iMe, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.iMc, R.color.cp_cont_d);
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
        if (iVar != null && iVar.eep != null && iVar.eep.getGodUserData() != null) {
            this.iMh = iVar;
            this.iMg = iVar.eep;
            zX(iVar.rank);
            this.iIi.setData(iVar.eep);
            this.iMd.setText(iVar.eep.getName_show());
            this.iMe.setText(iVar.eep.getGodUserData().getIntro());
            this.ajD.a(iVar.eep);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void zX(int i) {
        String str;
        switch (i) {
            case 1:
                this.iMc.setText("");
                ap.setBackgroundResource(this.iMc, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.iMc.setText("");
                ap.setBackgroundResource(this.iMc, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.iMc.setText("");
                ap.setBackgroundResource(this.iMc, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.iMc.setBackgroundDrawable(this.iMf);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.iMc.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ceP() != null) {
            ceP().a(view, this.iMh);
        }
        if (view == getView() && this.iMg != null && !StringUtils.isNull(this.iMg.getName_show()) && !StringUtils.isNull(this.iMg.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.iMg.getUserId(), 0L), false, this.iMg.isBigV())));
        }
    }
}
