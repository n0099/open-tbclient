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
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.a<h> {
    private c Nb;
    public ClickableHeaderImageView gPn;
    public CommonUserLikeButton gTf;
    private TextView gTg;
    private TextView gTh;
    private TextView gTi;
    private Drawable gTj;
    private MetaData gTk;
    private h gTl;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.gPn = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.gPn.setGodIconMargin(R.dimen.ds4);
        this.gPn.setAfterClickListener(this);
        this.gTh = (TextView) getView().findViewById(R.id.god_name);
        this.gTi = (TextView) getView().findViewById(R.id.god_describe);
        this.gTf = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.Nb = new c(tbPageContext, this.gTf);
        this.gTf.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.gTg = (TextView) getView().findViewById(R.id.god_rank);
        this.gTj = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gTh, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gTi, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gTg, (int) R.color.cp_cont_d);
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
        if (hVar != null && hVar.cOj != null && hVar.cOj.getGodUserData() != null) {
            this.gTl = hVar;
            this.gTk = hVar.cOj;
            uO(hVar.rank);
            this.gPn.setData(hVar.cOj);
            this.gTh.setText(hVar.cOj.getName_show());
            this.gTi.setText(hVar.cOj.getGodUserData().getIntro());
            this.Nb.a(hVar.cOj);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void uO(int i) {
        String str;
        switch (i) {
            case 1:
                this.gTg.setText("");
                am.setBackgroundResource(this.gTg, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.gTg.setText("");
                am.setBackgroundResource(this.gTg, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.gTg.setText("");
                am.setBackgroundResource(this.gTg, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.gTg.setBackgroundDrawable(this.gTj);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.gTg.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bta() != null) {
            bta().a(view, this.gTl);
        }
        if (view == getView() && this.gTk != null && !StringUtils.isNull(this.gTk.getName_show()) && !StringUtils.isNull(this.gTk.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gTk.getUserId(), 0L), false, this.gTk.isBigV())));
        }
    }
}
