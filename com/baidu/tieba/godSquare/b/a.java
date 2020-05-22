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
public class a extends com.baidu.tieba.card.b<h> {
    private c agS;
    public ClickableHeaderImageView hRq;
    public CommonUserLikeButton hVj;
    private TextView hVk;
    private TextView hVl;
    private TextView hVm;
    private Drawable hVn;
    private MetaData hVo;
    private h hVp;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.hRq = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.hRq.setGodIconMargin(R.dimen.ds4);
        this.hRq.setAfterClickListener(this);
        this.hVl = (TextView) getView().findViewById(R.id.god_name);
        this.hVm = (TextView) getView().findViewById(R.id.god_describe);
        this.hVj = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.agS = new c(tbPageContext, this.hVj);
        this.hVj.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.hVk = (TextView) getView().findViewById(R.id.god_rank);
        this.hVn = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.hVl, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hVm, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.hVk, (int) R.color.cp_cont_d);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_god_square_hot_god;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(h hVar) {
        if (hVar != null && hVar.dFJ != null && hVar.dFJ.getGodUserData() != null) {
            this.hVp = hVar;
            this.hVo = hVar.dFJ;
            wf(hVar.rank);
            this.hRq.setData(hVar.dFJ);
            this.hVl.setText(hVar.dFJ.getName_show());
            this.hVm.setText(hVar.dFJ.getGodUserData().getIntro());
            this.agS.a(hVar.dFJ);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void wf(int i) {
        String str;
        switch (i) {
            case 1:
                this.hVk.setText("");
                am.setBackgroundResource(this.hVk, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.hVk.setText("");
                am.setBackgroundResource(this.hVk, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.hVk.setText("");
                am.setBackgroundResource(this.hVk, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.hVk.setBackgroundDrawable(this.hVn);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.hVk.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKS() != null) {
            bKS().a(view, this.hVp);
        }
        if (view == getView() && this.hVo != null && !StringUtils.isNull(this.hVo.getName_show()) && !StringUtils.isNull(this.hVo.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.hVo.getUserId(), 0L), false, this.hVo.isBigV())));
        }
    }
}
