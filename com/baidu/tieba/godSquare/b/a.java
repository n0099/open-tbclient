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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.h;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.card.a<h> {
    private c NB;
    public ClickableHeaderImageView gRp;
    public CommonUserLikeButton gVh;
    private TextView gVi;
    private TextView gVj;
    private TextView gVk;
    private Drawable gVl;
    private MetaData gVm;
    private h gVn;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.gRp = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.gRp.setGodIconMargin(R.dimen.ds4);
        this.gRp.setAfterClickListener(this);
        this.gVj = (TextView) getView().findViewById(R.id.god_name);
        this.gVk = (TextView) getView().findViewById(R.id.god_describe);
        this.gVh = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.NB = new c(tbPageContext, this.gVh);
        this.gVh.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.gVi = (TextView) getView().findViewById(R.id.god_rank);
        this.gVl = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
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
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gVi, (int) R.color.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(h hVar) {
        if (hVar != null && hVar.cSn != null && hVar.cSn.getGodUserData() != null) {
            this.gVn = hVar;
            this.gVm = hVar.cSn;
            uU(hVar.rank);
            this.gRp.setData(hVar.cSn);
            this.gVj.setText(hVar.cSn.getName_show());
            this.gVk.setText(hVar.cSn.getGodUserData().getIntro());
            this.NB.a(hVar.cSn);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void uU(int i) {
        String str;
        switch (i) {
            case 1:
                this.gVi.setText("");
                am.setBackgroundResource(this.gVi, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.gVi.setText("");
                am.setBackgroundResource(this.gVi, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.gVi.setText("");
                am.setBackgroundResource(this.gVi, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.gVi.setBackgroundDrawable(this.gVl);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.gVi.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buG() != null) {
            buG().a(view, this.gVn);
        }
        if (view == getView() && this.gVm != null && !StringUtils.isNull(this.gVm.getName_show()) && !StringUtils.isNull(this.gVm.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gVm.getUserId(), 0L), false, this.gVm.isBigV())));
        }
    }
}
