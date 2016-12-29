package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.horizonalList.widget.n {
    private TbPageContext Gf;
    private com.baidu.tbadk.core.view.userLike.c aQT;
    public ClickableHeaderImageView bbG;
    public TextView bbH;
    public TextView bbI;
    public EntelechyUserLikeButton bbJ;
    private com.baidu.tieba.card.data.k bbK;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public p(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new q(this);
        this.Gf = tbPageContext;
        this.bbG = (ClickableHeaderImageView) view.findViewById(r.g.rec_god_item_header);
        this.bbG.setGodIconMargin(r.e.ds6);
        this.bbH = (TextView) view.findViewById(r.g.rec_god_item_user_name);
        this.bbI = (TextView) view.findViewById(r.g.rec_god_item_user_describe);
        this.bbJ = (EntelechyUserLikeButton) view.findViewById(r.g.rec_god_item_user_like_btn);
        this.aQT = new com.baidu.tbadk.core.view.userLike.c(this.Gf, this.bbJ);
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n T(View view) {
        return new p(view, this.Gf);
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.data.k) {
            this.bbK = (com.baidu.tieba.card.data.k) lVar;
            if (this.bbK.author != null) {
                getView().setTag(r.g.rec_god_item_root, this.bbK.author.getUserId());
                this.bbG.setTag(r.g.rec_god_item_root, this.bbK.author.getUserId());
                this.bbJ.setTag(this.bbK.author);
                this.bbG.setData(this.bbK.author);
                this.bbG.setAfterClickListener(this.aob);
                this.bbH.setText(com.baidu.tbadk.core.util.av.t(this.bbK.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bbK.author.getGodUserData() != null) {
                    this.bbI.setText(com.baidu.tbadk.core.util.av.t(this.bbK.author.getGodUserData().getIntro(), 6));
                }
                this.aQT.a(this.bbK.author);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.j((View) this.bbH, r.d.cp_cont_b);
            com.baidu.tbadk.core.util.ar.j((View) this.bbI, r.d.cp_cont_d);
            if (this.bbJ != null) {
                this.bbJ.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
