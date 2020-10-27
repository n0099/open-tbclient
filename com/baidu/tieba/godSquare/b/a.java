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
    public ClickableHeaderImageView jjx;
    public CommonUserLikeButton jno;
    private TextView jnp;
    private TextView jnq;
    private TextView jnr;
    private Drawable jns;
    private MetaData jnt;
    private i jnu;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.jjx = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.jjx.setGodIconMargin(R.dimen.ds4);
        this.jjx.setAfterClickListener(this);
        this.jnq = (TextView) getView().findViewById(R.id.god_name);
        this.jnr = (TextView) getView().findViewById(R.id.god_describe);
        this.jno = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.ajW = new c(tbPageContext, this.jno);
        this.jno.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.jnp = (TextView) getView().findViewById(R.id.god_rank);
        this.jns = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            ap.setViewTextColor(this.jnq, R.color.cp_cont_b);
            ap.setViewTextColor(this.jnr, R.color.cp_cont_d);
            ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.jnp, R.color.cp_cont_d);
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
        if (iVar != null && iVar.eyV != null && iVar.eyV.getGodUserData() != null) {
            this.jnu = iVar;
            this.jnt = iVar.eyV;
            AW(iVar.rank);
            this.jjx.setData(iVar.eyV);
            this.jnq.setText(iVar.eyV.getName_show());
            this.jnr.setText(iVar.eyV.getGodUserData().getIntro());
            this.ajW.a(iVar.eyV);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void AW(int i) {
        String str;
        switch (i) {
            case 1:
                this.jnp.setText("");
                ap.setBackgroundResource(this.jnp, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.jnp.setText("");
                ap.setBackgroundResource(this.jnp, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.jnp.setText("");
                ap.setBackgroundResource(this.jnp, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.jnp.setBackgroundDrawable(this.jns);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.jnp.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cls() != null) {
            cls().a(view, this.jnu);
        }
        if (view == getView() && this.jnt != null && !StringUtils.isNull(this.jnt.getName_show()) && !StringUtils.isNull(this.jnt.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.jnt.getUserId(), 0L), false, this.jnt.isBigV())));
        }
    }
}
