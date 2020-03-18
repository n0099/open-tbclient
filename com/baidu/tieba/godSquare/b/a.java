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
    private c NC;
    public ClickableHeaderImageView gSI;
    public CommonUserLikeButton gWA;
    private TextView gWB;
    private TextView gWC;
    private TextView gWD;
    private Drawable gWE;
    private MetaData gWF;
    private h gWG;
    private View mBottomLine;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        getView().setOnClickListener(this);
        this.gSI = (ClickableHeaderImageView) getView().findViewById(R.id.god_header_view);
        this.gSI.setGodIconMargin(R.dimen.ds4);
        this.gSI.setAfterClickListener(this);
        this.gWC = (TextView) getView().findViewById(R.id.god_name);
        this.gWD = (TextView) getView().findViewById(R.id.god_describe);
        this.gWA = (CommonUserLikeButton) getView().findViewById(R.id.god_like_btn);
        this.NC = new c(tbPageContext, this.gWA);
        this.gWA.setAfterOnClickListener(this);
        this.mBottomLine = getView().findViewById(R.id.bottom_line);
        this.gWB = (TextView) getView().findViewById(R.id.god_rank);
        this.gWE = this.mPageContext.getResources().getDrawable(R.drawable.transparent_bg);
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.drawable.home_thread_card_item_bg);
            am.setViewTextColor(this.gWC, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.gWD, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gWB, (int) R.color.cp_cont_d);
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
        if (hVar != null && hVar.cSB != null && hVar.cSB.getGodUserData() != null) {
            this.gWG = hVar;
            this.gWF = hVar.cSB;
            vb(hVar.rank);
            this.gSI.setData(hVar.cSB);
            this.gWC.setText(hVar.cSB.getName_show());
            this.gWD.setText(hVar.cSB.getGodUserData().getIntro());
            this.NC.a(hVar.cSB);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void vb(int i) {
        String str;
        switch (i) {
            case 1:
                this.gWB.setText("");
                am.setBackgroundResource(this.gWB, R.drawable.icon_grade_round_no1);
                return;
            case 2:
                this.gWB.setText("");
                am.setBackgroundResource(this.gWB, R.drawable.icon_grade_round_no2);
                return;
            case 3:
                this.gWB.setText("");
                am.setBackgroundResource(this.gWB, R.drawable.icon_grade_round_no3);
                return;
            default:
                this.gWB.setBackgroundDrawable(this.gWE);
                if (i < 100) {
                    str = String.format("%02d", Integer.valueOf(i));
                } else {
                    str = i + "";
                }
                this.gWB.setText(str);
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buM() != null) {
            buM().a(view, this.gWG);
        }
        if (view == getView() && this.gWF != null && !StringUtils.isNull(this.gWF.getName_show()) && !StringUtils.isNull(this.gWF.getUserId())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.gWF.getUserId(), 0L), false, this.gWF.isBigV())));
        }
    }
}
