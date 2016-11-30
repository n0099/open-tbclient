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
    private com.baidu.tbadk.core.view.userLike.c aRC;
    public TextView aYg;
    public ClickableHeaderImageView bcA;
    public TextView bcB;
    public EntelechyUserLikeButton bcC;
    private com.baidu.tieba.card.data.l bcD;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public p(View view, TbPageContext tbPageContext) {
        super(view);
        this.mSkinType = 3;
        this.mOnClickListener = new q(this);
        this.Gf = tbPageContext;
        this.bcA = (ClickableHeaderImageView) view.findViewById(r.g.rec_god_item_header);
        this.bcA.setGodIconMargin(r.e.ds6);
        this.aYg = (TextView) view.findViewById(r.g.rec_god_item_user_name);
        this.bcB = (TextView) view.findViewById(r.g.rec_god_item_user_describe);
        this.bcC = (EntelechyUserLikeButton) view.findViewById(r.g.rec_god_item_user_like_btn);
        this.aRC = new com.baidu.tbadk.core.view.userLike.c(this.Gf, this.bcC);
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public com.baidu.tieba.horizonalList.widget.n T(View view) {
        return new p(view, this.Gf);
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void a(com.baidu.tieba.horizonalList.widget.l lVar) {
        if (lVar instanceof com.baidu.tieba.card.data.l) {
            this.bcD = (com.baidu.tieba.card.data.l) lVar;
            if (this.bcD.author != null) {
                getView().setTag(r.g.rec_god_item_root, this.bcD.author.getUserId());
                this.bcA.setTag(r.g.rec_god_item_root, this.bcD.author.getUserId());
                this.bcC.setTag(this.bcD.author);
                this.bcA.setData(this.bcD.author);
                this.bcA.setAfterClickListener(this.aoz);
                this.aYg.setText(com.baidu.tbadk.core.util.ax.t(this.bcD.author.getName_show(), 5));
                getView().setOnClickListener(this.mOnClickListener);
                if (this.bcD.author.getGodUserData() != null) {
                    this.bcB.setText(com.baidu.tbadk.core.util.ax.t(this.bcD.author.getGodUserData().getIntro(), 6));
                }
                this.aRC.a(this.bcD.author);
                onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.n
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.j((View) this.aYg, r.d.cp_cont_b);
            com.baidu.tbadk.core.util.at.j((View) this.bcB, r.d.cp_cont_d);
            if (this.bcC != null) {
                this.bcC.onChangeSkinType(i);
            }
        }
        this.mSkinType = i;
    }
}
