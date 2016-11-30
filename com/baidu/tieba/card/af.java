package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class af extends r {
    private TbPageContext GO;
    private com.baidu.tbadk.core.view.userLike.c aRC;
    private CommonUserLikeButton.a aRG;
    private com.baidu.tbadk.core.data.bk aeu;
    public EntelechyUserLikeButton bbT;
    public TextView bdf;
    private com.baidu.tieba.card.data.o bdg;
    private View.OnClickListener bdh;
    private View.OnClickListener bdi;
    private int mSkinType;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aRG = new ag(this);
        this.bdh = new ah(this);
        this.bdi = new ai(this);
        OZ();
        this.GO = tbPageContext;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcJ.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds4);
        this.bcJ.setLayoutParams(layoutParams);
        this.bdf = new TextView(tbPageContext.getPageActivity());
        this.bdf.setIncludeFontPadding(false);
        this.bdf.setTextSize(0, com.baidu.adp.lib.util.k.e(tbPageContext.getPageActivity(), r.e.ds24));
        this.bdf.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.bdf.setOnClickListener(this.bdh);
        this.bcK.addView(this.bdf, 1);
        this.bbT = new EntelechyUserLikeButton(tbPageContext.getPageActivity());
        this.aRC = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bbT);
        this.bbT.setFanNumCallBack(this.aRG);
        this.bbT.setAfterOnClickListener(this.bdi);
        this.bbT.setId(r.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds28);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
        this.bbT.setGravity(21);
        this.bbT.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bbT);
    }

    @Override // com.baidu.tieba.card.r
    public void a(com.baidu.tieba.card.data.o oVar) {
        super.onBindDataToView(oVar);
        if (oVar != null && oVar.beS != null) {
            this.bdg = oVar;
            this.aeu = oVar.beS;
            oVar.sourceType = 0;
            if (oVar.beS.getAuthor() != null) {
                gh(oVar.beS.getAuthor().getFansNum());
                if (this.aeu.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aeu.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bbT.setVisibility(8);
                    return;
                }
                if (this.aeu.getAuthor().getGodUserData().getIsLike()) {
                    this.bbT.setVisibility(8);
                } else {
                    this.bbT.setVisibility(0);
                    this.aRC.a(this.aeu.getAuthor());
                }
                if (this.aeu.getAuthor().getGodUserData().getType() == 2) {
                    this.bcF.setGodIconMargin(0);
                } else {
                    this.bcF.setGodIconMargin(-1);
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.r, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.bdf, r.d.cp_cont_d);
            this.bbT.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.r
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
        this.aRC.i(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(int i) {
        if (this.bdf != null) {
            this.bdf.setText(String.format(this.GO.getResources().getString(r.j.fans_default_name_god_user), com.baidu.tbadk.core.util.ax.v(i)));
        }
    }
}
