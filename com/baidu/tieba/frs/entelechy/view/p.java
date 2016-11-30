package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class p extends a {
    private TbPageContext GO;
    private com.baidu.tbadk.core.view.userLike.c aRC;
    private CommonUserLikeButton.a aRG;
    private bk aeu;
    public EntelechyUserLikeButton bbT;
    public TextView bdf;
    private View.OnClickListener bdh;
    private int mSkinType;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.aRG = new q(this);
        this.bdh = new r(this);
        this.GO = tbPageContext;
        this.bcF.setGodIconMargin(0);
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
        this.bbT.setFanNumCallBack(this.aRG);
        this.bbT.setId(r.g.card_god_feed_like_btn);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds56));
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, r.g.guess_your_like_header);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds36);
        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
        this.bbT.setGravity(21);
        this.bbT.setLayoutParams(layoutParams2);
        ((ViewGroup) getView()).addView(this.bbT);
        this.aRC = new com.baidu.tbadk.core.view.userLike.c(tbPageContext, this.bbT);
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(bk bkVar) {
        super.onBindDataToView(bkVar);
        if (bkVar != null) {
            this.aeu = bkVar;
            if (this.aeu.getAuthor() == null || this.aeu.getAuthor().getPendantData() == null || StringUtils.isNull(this.aeu.getAuthor().getPendantData().pR())) {
                this.bcF.setIsGod(true);
            } else {
                this.bcF.setIsGod(false);
            }
            if (bkVar.getAuthor() != null) {
                this.aRC.a(bkVar.getAuthor());
                gh(bkVar.getAuthor().getFansNum());
                if (this.aeu.getAuthor().getUserId() != null && TbadkCoreApplication.getCurrentAccount() != null && this.aeu.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.bbT.setVisibility(8);
                    return;
                } else if (this.aeu.getAuthor().getGodUserData().getIsLike()) {
                    if (this.aeu.getAuthor().getGodUserData().getIsFromNetWork()) {
                        this.bbT.setVisibility(8);
                    } else {
                        this.bbT.setVisibility(0);
                        this.bbT.aO(true);
                    }
                } else {
                    this.bbT.setVisibility(0);
                }
            }
            int i = ((RelativeLayout.LayoutParams) this.bUJ.getLayoutParams()).height;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bbT.getLayoutParams();
            if (bkVar.si() != null) {
                layoutParams.topMargin = i + com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds20);
            } else {
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds40);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a, com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        super.onChangeSkinType(tbPageContext, i);
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.bdf, r.d.cp_cont_d);
            this.bbT.onChangeSkinType(i);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.frs.entelechy.view.a
    public void j(BdUniqueId bdUniqueId) {
        super.j(bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(int i) {
        if (this.bdf != null) {
            this.bdf.setText(String.format(this.GO.getResources().getString(r.j.fans_default_name_god_user), ax.v(i)));
        }
    }
}
